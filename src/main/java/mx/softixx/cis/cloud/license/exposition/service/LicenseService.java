package mx.softixx.cis.cloud.license.exposition.service;

import mx.softixx.cis.cloud.license.persistence.model.License;

public interface LicenseService {
	
	License findById(Long id);
	
}