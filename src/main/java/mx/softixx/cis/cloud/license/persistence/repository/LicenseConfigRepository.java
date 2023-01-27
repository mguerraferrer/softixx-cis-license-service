package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.model.LicenseConfig;

/**
 * Repository : LicenseConfig
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicenseConfigRepository extends JpaRepository<LicenseConfig, Long> {

	/**
	 * Returns the LicenseConfig that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicenseConfig or null
	 */
	LicenseConfig findByIdAndActiveTrue(Long id);

	/**
	 * Returns the LicenseConfig associated with a {@link License} and a
	 * paymentModeId if {@link LicenseConfig#isActive()} is
	 * false
	 * 
	 * @param license     {@link License}
	 * @param paymentModeId
	 * @return LicenseConfig or null
	 */
	LicenseConfig findByLicenseAndPaymentModeIdAndActiveTrue(License license, Long paymentModeId);

	/**
	 * Returns the list of LicenseConfig associated with a
	 * {@link License} if {@link LicenseConfig#isActive()} is true
	 * 
	 * @param license {@link License}
	 * @return {@code List<LicenseConfig>} or empty list
	 */
	List<LicenseConfig> findByLicenseAndActiveTrue(License license);

	/**
	 * Returns the list of LicenseConfig if
	 * {@link LicenseConfig#isActive()} is true
	 * 
	 * @return {@code List<LicenseConfig>} or empty list
	 */
	List<LicenseConfig> findByActiveTrue();

}