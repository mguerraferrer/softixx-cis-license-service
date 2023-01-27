package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.LicenseDirectPromo;

/**
 * Repository : LicenseDirectPromo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicenseDirectPromoRepository extends JpaRepository<LicenseDirectPromo, Long> {

	/**
	 * Returns the LicenseDirectPromo that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicenseDirectPromo or null
	 */
	LicenseDirectPromo findByIdAndActiveTrue(Long id);

	/**
	 * Returns the LicenseDirectPromo that exactly matches the given id if
	 * {@link LicenseDirectPromo#getAvailable()} is true and
	 * {@link LicenseDirectPromo#isActive()} is true
	 * 
	 * @param id Long
	 * @return LicenseDirectPromo or null
	 */
	LicenseDirectPromo findByIdAndAvailableTrueAndActiveTrue(Long id);

	/**
	 * Returns the LicenseDirectPromo that exactly matches the given code
	 * 
	 * @param code String
	 * @return LicenseDirectPromo or null
	 */
	LicenseDirectPromo findByCodeAndActiveTrue(String code);

	/**
	 * Returns the LicenseDirectPromo that exactly matches the given code if
	 * {@link LicenseDirectPromo#getAvailable()} is true and
	 * {@link LicenseDirectPromo#isActive()} is true
	 * 
	 * @param id Longcode String
	 * @return LicenseDirectPromo or null
	 */
	LicenseDirectPromo findByCodeAndAvailableTrueAndActiveTrue(String code);

	/**
	 * Returns the list of LicenseDirectPromo if
	 * {@link LicenseDirectPromo#isActive()} is true
	 * 
	 * @return {@code List<LicenseDirectPromo>} or empty list
	 */
	List<LicenseDirectPromo> findByActiveTrue();

}