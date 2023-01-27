package mx.softixx.cis.cloud.license.exposition.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.val;
import mx.softixx.cis.cloud.license.mapper.UserLicenseMapper;
import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.cloud.license.persistence.repository.UserLicenseRepository;
import mx.softixx.cis.common.license.exception.UserLicenseAlreadyExistsException;
import mx.softixx.cis.common.license.exception.UserLicenseNotFoundException;
import mx.softixx.cis.common.license.payload.UserLicenseRequest;
import mx.softixx.cis.common.license.payload.UserLicenseResponse;

@Transactional(readOnly = true)
@Service
public class UserLicenseServiceImpl implements UserLicenseService {

	private final LicenseService licenseService;
	private final UserLicenseRepository userLicenseRepository;

	public UserLicenseServiceImpl(LicenseService licenseService, UserLicenseRepository userLicenseRepository) {
		this.licenseService = licenseService;
		this.userLicenseRepository = userLicenseRepository;
	}

	@Override
	public UserLicense findById(Long id) {
		return userLicenseRepository.findById(id).orElseThrow(() -> new UserLicenseNotFoundException(id));
	}

	@Override
	public UserLicense findOne(Long id) {
		return userLicenseRepository.findById(id).orElse(null);
	}
	
	@Override
	public UserLicenseResponse findByUserAndUserLicense(Long userId, Long userLicenseId) {
		val entity = findById(userLicenseId);
		val licenseId = entity.getLicense().getId();
		val userLicense = userLicenseRepository.findByUserIdAndLicenseIdAndActiveTrue(userId, licenseId)
											   .orElseThrow(() -> new UserLicenseNotFoundException(userId, licenseId));
		return UserLicenseMapper.map(userLicense);
	}

	@Override
	public List<UserLicenseResponse> getLicensesByUser(Long userId) {
		val source = userLicenseRepository.findByUserId(userId);
		return source.stream().map(UserLicenseMapper::map).toList();
	}

	@Override
	public UserLicenseResponse findBySerie(String serie) {
		val userLicense = userLicenseRepository.findBySerie(serie)
											   .orElseThrow(() -> new UserLicenseNotFoundException(serie));
		return UserLicenseMapper.map(userLicense);
	}

	@Override
	@Transactional
	public UserLicenseResponse create(UserLicenseRequest request) {
		validateRequest(request);
		val license = licenseService.findById(request.getLicenseId());
		val userLicense = UserLicenseMapper.map(request, license);
		save(userLicense);
		return UserLicenseMapper.map(userLicense);
	}

	/**
	 * Updates a user's license only if it is currently active
	 */
	@Override
	@Transactional
	public UserLicenseResponse update(Long userId, Long ulId, Long licenseId, UserLicenseRequest request) {
		val userLicense = userLicenseRepository.findByIdAndUserIdAndLicenseIdAndActiveTrue(ulId, userId, licenseId)
											   .orElseThrow(() -> new UserLicenseNotFoundException(ulId, userId, licenseId));
		return update(request, userLicense);
	}

	/**
	 * Updates a user's license
	 */
	@Override
	@Transactional
	public UserLicenseResponse update(Long userId, Long ulId, UserLicenseRequest request) {
		val userLicense = userLicenseRepository.findByIdAndUserId(ulId, userId)
				   							   .orElseThrow(() -> new UserLicenseNotFoundException(ulId, userId));
		return update(request, userLicense);
	}

	private void validateRequest(UserLicenseRequest request) {
		val userLicenses = userLicenseRepository.findByUserId(request.getUserId());
		if (Boolean.TRUE.equals(request.getPrivatePractice())) {
			val count = userLicenses.stream().filter(UserLicense::isPrivatePractice).count();
			if (count > 0) {
				throw new UserLicenseAlreadyExistsException();
			}
		}
		
		try {
			findBySerie(request.getSerie());
			throw new UserLicenseAlreadyExistsException();
		} catch (UserLicenseNotFoundException e) {
			// Nothing to do
		}
	}
	
	private UserLicenseResponse update(UserLicenseRequest request, final UserLicense userLicense) {
		val license = licenseService.findById(request.getLicenseId());
		UserLicenseMapper.map(userLicense, request, license);
		save(userLicense);
		return UserLicenseMapper.map(userLicense);
	}
	
	private UserLicense save(UserLicense userLicense) {
		if (userLicense != null) {
			return userLicenseRepository.save(userLicense);
		}
		return null;
	}

}