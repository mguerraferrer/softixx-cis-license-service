package mx.softixx.cis.cloud.license.exposition.service;

import java.util.List;

import mx.softixx.cis.common.license.payload.LicenseTypeResponse;

public interface LicenseTypeService {
	
	List<LicenseTypeResponse> findAll();
	
	LicenseTypeResponse findById(Long id);
	
	LicenseTypeResponse findByCode(String code);
	
}