package mx.softixx.cis.cloud.license.exposition.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.val;
import mx.softixx.cis.cloud.license.exposition.observavility.UserLicenseObservation;
import mx.softixx.cis.common.license.payload.UserLicenseRequest;
import mx.softixx.cis.common.license.payload.UserLicenseResponse;
import mx.softixx.cis.common.validation.group.OnCreate;
import mx.softixx.cis.common.validation.group.OnUpdate;

@RestController
@RequestMapping("/api/v1/user-licenses")
@Validated
public class UserLicenseController {

	private final UserLicenseObservation userLicenseObservation;

	public UserLicenseController(UserLicenseObservation userLicenseObservation) {
		this.userLicenseObservation = userLicenseObservation;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<UserLicenseResponse>> getLicensesByUser(@PathVariable Long userId) {
		val licenses = userLicenseObservation.observeUserLicenseByUser(userId);
		return ResponseEntity.ok(licenses);
	}
	
	@GetMapping("/user/{userId}/ulid/{ulId}")
	public ResponseEntity<UserLicenseResponse> findByUserAndLicense(@PathVariable Long userId, @PathVariable Long ulId) {
		val userLicense = userLicenseObservation.observeUserLicenseByUserAndLicense(userId, ulId);
		return ResponseEntity.ok(userLicense);
	}

	@GetMapping("/serie/{serie}")
	public ResponseEntity<UserLicenseResponse> findBySerie(@PathVariable String serie) {
		val userLicense = userLicenseObservation.observeUserLicenseBySerie(serie);
		return ResponseEntity.ok(userLicense);
	}
	
	@PostMapping
	@Validated(OnCreate.class)
	public ResponseEntity<UserLicenseResponse> create(@RequestBody @Valid UserLicenseRequest request) {
		val userLicense = userLicenseObservation.observeCreate(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(userLicense);
	}
	
	@PutMapping("/user/{userId}/ulid/{ulId}/lid/{licenseId}")
	@Validated(OnUpdate.class)
	public ResponseEntity<UserLicenseResponse> update(@PathVariable Long userId,
													  @PathVariable Long ulId, 
													  @PathVariable Long licenseId, 
													  @RequestBody @Valid UserLicenseRequest request) {
		val userLicense = userLicenseObservation.observeUpdate(userId, ulId, licenseId, request);
		return ResponseEntity.ok(userLicense);
	}
	
	@PutMapping("/user/{userId}/ulid/{ulId}")
	@Validated(OnUpdate.class)
	public ResponseEntity<UserLicenseResponse> update(@PathVariable Long userId,
													  @PathVariable Long ulId,
													  @RequestBody @Valid UserLicenseRequest request) {
		val userLicense = userLicenseObservation.observeUpdate(userId, ulId, request);
		return ResponseEntity.ok(userLicense);
	}

}