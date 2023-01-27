package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.AvailableService;
import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.cloud.license.persistence.model.UserLicenseAvailableService;

/**
 * Repository : UserLicenseService
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicenseServiceRepository extends JpaRepository<UserLicenseAvailableService, Long> {

	/**
	 * Returns the UserLicenseAvailableService that exactly matches the given id
	 * 
	 * @param id Long
	 * @return UserLicenseAvailableService or null
	 */
	UserLicenseAvailableService findByIdAndActiveTrue(Long id);

	/**
	 * Returns the UserLicenseAvailableService associated with a {@link UserLicense}
	 * and a {@link AvailableService} if
	 * {@link UserLicenseAvailableService#isActive()} is true
	 * 
	 * @param userLicense      {@link UserLicense}
	 * @param availableService {@link AvailableService}
	 * @return UserLicenseAvailableService or null
	 */
	UserLicenseAvailableService findByUserLicenseAndAvailableServiceAndActiveTrue(UserLicense userLicense,
			AvailableService availableService);

	/**
	 * Returns the list of UserLicenseAvailableService associated with a
	 * {@link UserLicense} and if {@link UserLicenseAvailableService#isActive()} is
	 * true
	 * 
	 * @param userLicense {@link UserLicense}
	 * @return {@code List<UserLicenseAvailableService>} or empty list
	 */
	List<UserLicenseAvailableService> findByUserLicenseAndActiveTrue(UserLicense userLicense);

	/**
	 * Returns the list of UserLicenseAvailableService associated with a
	 * {@link UserLicense} and if {@link UserLicenseAvailableService#isActive()} is
	 * true sorted by sort param
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param sort        {@link Sort}
	 * @return {@code List<UserLicenseAvailableService>} or empty list
	 */
	List<UserLicenseAvailableService> findByUserLicenseAndActiveTrue(UserLicense userLicense, Sort sort);

	/**
	 * Returns a {@code Page<UserLicenseAvailableService>} object associated with a
	 * {@link UserLicense} and if {@link UserLicenseAvailableService#isActive()} is
	 * true paged by pageable param
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param pageable    {@link Pageable}
	 * @return {@code Page<UserLicenseAvailableService>} or empty page
	 */
	Page<UserLicenseAvailableService> findByUserLicenseAndActiveTrue(UserLicense userLicense, Pageable pageable);

}