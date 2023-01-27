package mx.softixx.cis.cloud.license.exposition.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.val;
import mx.softixx.cis.cloud.license.mapper.LicenseTypeMapper;
import mx.softixx.cis.cloud.license.persistence.repository.LicenseTypeRepository;
import mx.softixx.cis.common.license.exception.LicenseTypeNotFoundException;
import mx.softixx.cis.common.license.payload.LicenseTypeResponse;

@Transactional(readOnly = true)
@Service
public class LicenseTypeServiceImpl implements LicenseTypeService {
	
	private final LicenseTypeRepository licenseTypeRepository;
	
	public LicenseTypeServiceImpl(LicenseTypeRepository licenseTypeRepository) {
		this.licenseTypeRepository = licenseTypeRepository;
	}

	@Override
	public List<LicenseTypeResponse> findAll() {
		val source = licenseTypeRepository.findByActiveTrue();
		return source.stream().map(LicenseTypeMapper::map).toList();
	}

	@Override
	public LicenseTypeResponse findById(Long id) {
		val licenseType = licenseTypeRepository.findByIdAndActiveTrue(id);
		if (licenseType == null) {
			throw new LicenseTypeNotFoundException(id);
		}
		return LicenseTypeMapper.map(licenseType);
	}

	@Override
	public LicenseTypeResponse findByCode(String code) {
		val licenseType = licenseTypeRepository.findByCodeAndActiveTrue(code);
		if (licenseType == null) {
			throw new LicenseTypeNotFoundException(code);
		}
		return LicenseTypeMapper.map(licenseType);
	}

}