package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.model.LicensePromo;

/**
 * Repository : LicensePromo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicensePromoRepository extends JpaRepository<LicensePromo, Long> {

	/**
	 * Returns the LicensePromo that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicensePromo or null
	 */
	LicensePromo findByIdAndActiveTrue(Long id);

	/**
	 * Returns the LicensePromo that exactly matches the given code
	 * 
	 * @param code String
	 * @return LicensePromo or null
	 */
	LicensePromo findByCodeAndActiveTrue(String code);

	/**
	 * Returns the LicensePromo associated with a {@link License} and a
	 * paymentModeId if {@link LicensePromo#isActive()} is true
	 * 
	 * @param license       {@link License}
	 * @param paymentModeId Long
	 * @return LicensePromo or null
	 */
	LicensePromo findByLicenseAndPaymentModeIdAndActiveTrue(License license, Long paymentModeId);

	/**
	 * Returns the list of LicensePromo if {@link LicensePromo#isActive()} is true
	 * 
	 * @return {@code List<LicensePromo>} or empty list
	 */
	List<LicensePromo> findByActiveTrue();

}