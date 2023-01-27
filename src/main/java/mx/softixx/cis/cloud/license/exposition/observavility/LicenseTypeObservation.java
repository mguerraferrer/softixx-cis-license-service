package mx.softixx.cis.cloud.license.exposition.observavility;

import java.util.List;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.license.exposition.service.LicenseTypeService;
import mx.softixx.cis.common.license.payload.LicenseTypeResponse;

@Component
public class LicenseTypeObservation {

	private final LicenseTypeService licenseTypeService;
	private final ObservationRegistry observationRegistry;

	public LicenseTypeObservation(LicenseTypeService licenseTypeService, ObservationRegistry observationRegistry) {
		this.licenseTypeService = licenseTypeService;
		this.observationRegistry = observationRegistry;
	}

	public List<LicenseTypeResponse> observeLicenseType() {
		val observationName = "LicenseTypeController#getLicenseTypes";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("licenseType", "findAll")
				.observe(licenseTypeService::findAll);
	}

}