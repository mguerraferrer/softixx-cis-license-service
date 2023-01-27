package mx.softixx.cis.cloud.license.exposition.service;

import org.springframework.stereotype.Service;

import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.repository.LicenseRepository;
import mx.softixx.cis.common.license.exception.LicenseNotFoundException;

@Service
public class LicenseServiceImpl implements LicenseService {

	private final LicenseRepository licenseRepository;
	
	public LicenseServiceImpl(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	@Override
	public License findById(Long id) {
		return licenseRepository.findByIdAndActiveTrue(id).orElseThrow(LicenseNotFoundException::new);
	}

}