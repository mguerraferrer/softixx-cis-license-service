package mx.softixx.cis.cloud.license.mapper;

import lombok.val;
import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.common.license.payload.UserLicenseRequest;
import mx.softixx.cis.common.license.payload.UserLicenseResponse;

public final class UserLicenseMapper {
	
	private UserLicenseMapper() {
	}
	
	public static final UserLicenseResponse map(final UserLicense userLicense) {
		if (userLicense == null) {
			return null;
		}
		
		val license = LicenseMapper.map(userLicense.getLicense());
		return UserLicenseResponse
				.builder()
				.id(userLicense.getId())
				.userId(userLicense.getUserId())
				.license(license)
				.serie(userLicense.getSerie())
				.activationDate(userLicense.getActivationDate())
				.actualizationDate(userLicense.getActualizationDate())
				.dueDate(userLicense.getDueDate())
				.privatePractice(userLicense.isPrivatePractice())
				.clinicalEntity(userLicense.isClinicalEntity())
				.licenseMxn(userLicense.isLicenseMxn())
				.licenseUsd(userLicense.isLicenseUsd())
				.active(userLicense.isActive())
				.build();
	}
	
	public static final UserLicense map(UserLicenseRequest request, License license) {
		if (request == null) {
			return null;
		}
		
		val userId = request.getUserId();
		val serie = request.getSerie();
		val dueDate = request.getDueDate();
		
		val userLicense = new UserLicense(license, userId, serie, dueDate);
		populateUserLicense(userLicense, request);
		
		return userLicense;
	}
	
	public static void map(final UserLicense userLicense, UserLicenseRequest request, License license) {
		if (userLicense != null && request != null) {
			val dueDate = request.getDueDate();
			if (dueDate != null) {
				userLicense.setDueDate(dueDate);
			}
			
			if (license != null) {
				userLicense.setLicense(license);
			}
			
			populateUserLicense(userLicense, request);
		}
	}
	
	private static void populateUserLicense(final UserLicense userLicense, final UserLicenseRequest request) {
		val activationDate = request.getActivationDate();
		if (activationDate != null) {
			userLicense.setActivationDate(activationDate);
		}
		
		val actualizationDate = request.getActualizationDate();
		if (actualizationDate != null) {
			userLicense.setActualizationDate(actualizationDate);
		}
		
		val privatePractice = request.getPrivatePractice();
		if (privatePractice != null) {
			userLicense.setPrivatePractice(privatePractice);
		}
		
		val clinicalEntity = request.getClinicalEntity();
		if (clinicalEntity != null) {
			userLicense.setClinicalEntity(clinicalEntity);
		}
		
		val licenseMxn = request.getLicenseMxn();
		if (licenseMxn != null) {
			userLicense.setLicenseMxn(licenseMxn);
		}
		
		val licenseUsd = request.getLicenseUsd();
		if (licenseUsd != null) {
			userLicense.setLicenseUsd(licenseUsd);
		}
		
		val active = request.getActive();
		if (active != null) {
			userLicense.setActive(active);
		}
	}
	
}