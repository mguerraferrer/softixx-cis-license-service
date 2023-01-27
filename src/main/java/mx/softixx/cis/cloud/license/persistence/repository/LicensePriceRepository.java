package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.model.LicensePrice;

/**
 * Repository : LicensePrice
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicensePriceRepository extends JpaRepository<LicensePrice, Long> {

	/**
	 * Returns the LicensePrice that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicensePrice or null
	 */
	LicensePrice findByIdAndActiveTrue(Long id);

	/**
	 * Returns the LicensePrice associated with a {@link License} if
	 * {@link LicensePrice#isActive()} is true
	 * 
	 * @param license {@link License}
	 * @return LicensePrice or null
	 */
	LicensePrice findByLicenseAndActiveTrue(License license);

	/**
	 * Returns the list of LicensePrice if
	 * {@link LicensePrice#isActive()} is true
	 * 
	 * @return {@code List<LicensePrice>} or empty list
	 */
	List<LicensePrice> findByActiveTrue();

}