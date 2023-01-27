package mx.softixx.cis.cloud.license.exposition.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import mx.softixx.cis.cloud.license.exposition.observavility.LicenseTypeObservation;
import mx.softixx.cis.cloud.license.exposition.service.LicenseTypeService;
import mx.softixx.cis.common.license.payload.LicenseTypeResponse;

@RestController
@RequestMapping("/api/v1/licenses/types")
public class LicenseTypeController {
	
	private final LicenseTypeObservation licenseTypeObservation;
	private final LicenseTypeService licenseTypeService;
	
	public LicenseTypeController(LicenseTypeObservation licenseTypeObservation, LicenseTypeService licenseTypeService) {
		this.licenseTypeObservation = licenseTypeObservation;
		this.licenseTypeService = licenseTypeService;
	}

	@GetMapping
	public ResponseEntity<List<LicenseTypeResponse>> getLicenseTypes() {
		val licenseTypes = licenseTypeObservation.observeLicenseType();
		return ResponseEntity.ok(licenseTypes);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<LicenseTypeResponse> getLicenseType(@PathVariable Long id) {
		val licenseType = licenseTypeService.findById(id);
		return ResponseEntity.ok(licenseType);
	}
	
	@GetMapping("/code/{code}")
	public ResponseEntity<LicenseTypeResponse> getLicenseType(@PathVariable String code) {
		val licenseType = licenseTypeService.findByCode(code);
		return ResponseEntity.ok(licenseType);
	}
	
}