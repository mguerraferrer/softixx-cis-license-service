package mx.softixx.cis.cloud.license.exposition.observavility;

import java.util.List;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.license.exposition.service.UserLicenseService;
import mx.softixx.cis.common.license.payload.UserLicenseRequest;
import mx.softixx.cis.common.license.payload.UserLicenseResponse;

@Component
public class UserLicenseObservation {

	private final UserLicenseService userLicenseService;
	private final ObservationRegistry observationRegistry;
	
	private static final String USER_ID_KEY = "userId";
	private static final String REQUEST_KEY = "request";

	public UserLicenseObservation(UserLicenseService userLicenseService, ObservationRegistry observationRegistry) {
		this.userLicenseService = userLicenseService;
		this.observationRegistry = observationRegistry;
	}
	
	public UserLicenseResponse observeUserLicenseByUserAndLicense(Long userId, Long userLicenseId) {
		val observationName = "UserLicenseController#findByUserAndLicense";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue(USER_ID_KEY, String.valueOf(userId))
				.lowCardinalityKeyValue("userLicenseId", String.valueOf(userLicenseId))
				.observe(() -> userLicenseService.findByUserAndUserLicense(userId, userLicenseId));
	}
	
	public List<UserLicenseResponse> observeUserLicenseByUser(Long userId) {
		val observationName = "UserLicenseController#getLicensesByUser";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue(USER_ID_KEY, String.valueOf(userId))
				.observe(() -> userLicenseService.getLicensesByUser(userId));
	}
	
	public UserLicenseResponse observeUserLicenseBySerie(String serie) {
		val observationName = "UserLicenseController#findBySerie";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("serie", serie)
				.observe(() -> userLicenseService.findBySerie(serie));
	}
	
	public UserLicenseResponse observeCreate(UserLicenseRequest request) {
		val observationName = "UserLicenseController#create";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue(REQUEST_KEY, request.toString())				
				.observe(() -> userLicenseService.create(request));
	}
	
	public UserLicenseResponse observeUpdate(Long userId, Long ulId, Long licenseId, UserLicenseRequest request) {
		val observationName = "UserLicenseController#update";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue(USER_ID_KEY, String.valueOf(userId))
				.lowCardinalityKeyValue("ulId", String.valueOf(ulId))
				.lowCardinalityKeyValue("licenseId", String.valueOf(licenseId))
				.lowCardinalityKeyValue(REQUEST_KEY, request.toString())
				.observe(() -> userLicenseService.update(userId, ulId, licenseId, request));
	}
	
	public UserLicenseResponse observeUpdate(Long userId, Long ulId, UserLicenseRequest request) {
		val observationName = "UserLicenseController#update";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue(USER_ID_KEY, String.valueOf(userId))
				.lowCardinalityKeyValue("ulId", String.valueOf(ulId))
				.lowCardinalityKeyValue(REQUEST_KEY, request.toString())
				.observe(() -> userLicenseService.update(userId, ulId, request));
	}

}