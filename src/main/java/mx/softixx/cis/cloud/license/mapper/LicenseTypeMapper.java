package mx.softixx.cis.cloud.license.mapper;

import mx.softixx.cis.cloud.license.persistence.model.LicenseType;
import mx.softixx.cis.common.license.payload.LicenseTypeResponse;

public final class LicenseTypeMapper {
	
	private LicenseTypeMapper() {
	}
	
	public static final LicenseTypeResponse map(final LicenseType licenseType) {
		if (licenseType == null) {
			return null;
		}
		
		return LicenseTypeResponse
				.builder()
				.id(licenseType.getId())
				.code(licenseType.getCode())
				.valueMx(licenseType.getValueMx())
				.valueUs(licenseType.getValueUs())
				.active(licenseType.isActive())
				.build();
	}
	
}