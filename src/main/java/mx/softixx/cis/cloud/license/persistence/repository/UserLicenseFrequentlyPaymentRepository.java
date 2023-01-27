package mx.softixx.cis.cloud.license.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.cloud.license.persistence.model.UserLicenseFrequentlyPayment;

/**
 * Repository : UserLicenseFrequentlyPayment
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicenseFrequentlyPaymentRepository extends JpaRepository<UserLicenseFrequentlyPayment, Long> {

	/**
	 * Returns the UserLicenseFrequentlyPaymentEntity if
	 * {@link UserLicenseFrequentlyPayment#isActive()} is true
	 * 
	 * @param userLicense {@link UserLicense}
	 * @return UserLicenseFrequentlyPaymentEntity or null
	 */
	UserLicenseFrequentlyPayment findByUserLicenseAndActiveTrue(UserLicense userLicense);

}