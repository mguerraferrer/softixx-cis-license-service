package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.AvailableService;
import mx.softixx.cis.cloud.license.persistence.model.License;
import mx.softixx.cis.cloud.license.persistence.model.LicenseAvailableService;

/**
 * Repository : LicenseAvailableService
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicenseAvailableServiceRepository extends JpaRepository<LicenseAvailableService, Long> {

	/**
	 * Returns the LicenseAvailableService that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicenseAvailableService or null
	 */
	LicenseAvailableService findByIdAndActiveTrue(Long id);

	/**
	 * Returns the LicenseAvailableService associated with a {@link License} and
	 * a {@link AvailableService} if {@link LicenseAvailableService#isActive()} is true
	 * 
	 * @param license {@link License}
	 * @param service {@link AvailableService}
	 * @return LicenseAvailableService or null
	 */
	LicenseAvailableService findByLicenseAndAvailableServiceAndActiveTrue(License license, AvailableService service);

	/**
	 * Returns the list of LicenseAvailableService associated with a
	 * {@link License} if {@link LicenseAvailableService#isActive()} is true
	 * 
	 * @param license {@link License}
	 * @return {@code List<LicenseAvailableService>} or empty list
	 */
	List<LicenseAvailableService> findByLicenseAndActiveTrue(License license);

	/**
	 * Returns the list of LicenseAvailableService associated with a
	 * {@link License} if {@link LicenseAvailableService#isActive()} is true
	 * sorted asc by {@link AvailableService#getOrder()}
	 * 
	 * @param license {@link License}
	 * @return {@code List<LicenseAvailableService>} or empty list
	 */
	List<LicenseAvailableService> findByLicenseAndActiveTrueOrderByAvailableService_OrderAsc(License license);

	/**
	 * Returns the list of LicenseAvailableService associated with a
	 * {@link AvailableService} if {@link LicenseAvailableService#isActive()} is true
	 * 
	 * @param Service {@link AvailableService}
	 * @return {@code List<LicenseAvailableService>} or empty list
	 */
	List<LicenseAvailableService> findByAvailableServiceAndActiveTrue(AvailableService service);

	/**
	 * Returns the list of LicenseAvailableService associated with a
	 * {@link AvailableService} if {@link LicenseAvailableService#isActive()} is true
	 * sorted asc by {@link AvailableService#getOrder()}
	 * 
	 * @param service {@link AvailableService}
	 * @return {@code List<LicenseAvailableService>} or empty list
	 */
	List<LicenseAvailableService> findByAvailableServiceAndActiveTrueOrderByAvailableService_OrderAsc(AvailableService service);

}