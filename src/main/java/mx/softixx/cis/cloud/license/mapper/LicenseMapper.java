package mx.softixx.cis.cloud.license.mapper;

import lombok.val;
import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.common.license.payload.LicenseResponse;

public final class LicenseMapper {

	private LicenseMapper() {
	}
	
	public static final LicenseResponse map(final License license) {
		if (license == null) {
			return null;
		}
		
		val licenseType = LicenseTypeMapper.map(license.getLicenseType());
		return LicenseResponse
				.builder()
				.id(license.getId())
				.totalSpecialities(license.getTotalSpecialities())
				.totalDoctors(license.getTotalDoctors())
				.totalAssistants(license.getTotalAssistants())
				.totalNurses(license.getTotalNurses())
				.dailyConsultations(license.getDailyConsultations())
				.duration(license.getDuration())
				.description(license.getDescription())
				.level(license.getLevel())
				.hash(license.getHash())
				.active(license.isActive())
				.licenseType(licenseType)
				.build();
	}
	
}