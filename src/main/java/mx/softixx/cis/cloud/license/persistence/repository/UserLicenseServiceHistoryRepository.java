package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.UserLicenseAvailableService;
import mx.softixx.cis.cloud.license.persistence.model.UserLicenseAvailableServiceHistory;

/**
 * Repository : UserLicenseAvailableServiceHistory
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicenseServiceHistoryRepository extends JpaRepository<UserLicenseAvailableServiceHistory, Long> {

	/**
	 * Returns the list of UserLicenseAvailableServiceHistory associated with a
	 * {@link UserLicenseServiceEntity}
	 * 
	 * @param userLicenseService {@link UserLicenseServiceEntity}
	 * @return {@code List<UserLicenseAvailableServiceHistory>} or empty list
	 */
	List<UserLicenseAvailableServiceHistory> findByUserLicenseAvailableService(
			UserLicenseAvailableService userLicenseAvailableService);

	/**
	 * Returns the UserLicenseAvailableServiceHistory associated with a
	 * {@link UserLicenseServiceEntity} if
	 * {@link UserLicenseAvailableServiceHistory#getEndDate()} is null
	 * 
	 * @param userLicenseService {@link UserLicenseServiceEntity}
	 * @return UserLicenseAvailableServiceHistory or null
	 */
	UserLicenseAvailableServiceHistory findByUserLicenseAvailableServiceAndEndDateIsNull(
			UserLicenseAvailableService userLicenseAvailableService);

}