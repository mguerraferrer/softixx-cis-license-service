package mx.softixx.cis.cloud.license.exposition.service;

import java.util.List;

import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.common.license.payload.UserLicenseRequest;
import mx.softixx.cis.common.license.payload.UserLicenseResponse;

public interface UserLicenseService {
	
	UserLicense findById(Long id);
	
	UserLicense findOne(Long id);
	
	UserLicenseResponse findByUserAndUserLicense(Long userId, Long userLicenseId);
	
	List<UserLicenseResponse> getLicensesByUser(Long userId);
	
	UserLicenseResponse findBySerie(String serie);
	
	UserLicenseResponse create(UserLicenseRequest request);
	
	UserLicenseResponse update(Long userId, Long ulId, Long licenseId, UserLicenseRequest request);
	
	UserLicenseResponse update(Long userId, Long ulId, UserLicenseRequest request);
	
}