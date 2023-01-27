package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.model.LicenseType;

/**
 * Repository : License
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicenseRepository extends JpaRepository<License, Long> {

	/**
	 * Returns the License that exactly matches the given id
	 * 
	 * @param id Long
	 * @return {@code Optional<License>} or {@code Optional.empty}
	 */
	Optional<License> findByIdAndActiveTrue(Long id);

	/**
	 * Returns the License associated with a {@link LicenseType} if
	 * {@link License#isActive()} is true
	 * 
	 * @param licenseType {@link LicenseType}
	 * @return {@code Optional<License>} or {@code Optional.empty}
	 */
	Optional<License> findByLicenseTypeAndActiveTrue(LicenseType licenseType);

	/**
	 * Returns the License that exactly matches the given level
	 * 
	 * @param level Integer
	 * @return {@code Optional<License>} or {@code Optional.empty}
	 */
	Optional<License> findByLevelAndActiveTrue(Integer level);

	/**
	 * Returns the list of License if {@link License#isActive()} is
	 * false
	 * 
	 * @return {@code List<License>} or empty list
	 */
	List<License> findByActiveTrue();

	/**
	 * Returns the list of License if {@link License#getLevel()} is greater than level param
	 * and {@link License#isActive()} is true sorted asc by {@link License#getLevel()}
	 * 
	 * @param level Integer
	 * @return {@code List<License>} or empty list
	 */
	List<License> findByLevelGreaterThanAndActiveTrueOrderByLevelAsc(Integer level);

}
