package mx.softixx.cis.cloud.license.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.cloud.license.persistence.model.UserLicenseEditionHistory;

/**
 * Repository : UserLicenseEditionHistory
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicenseEditionHistoryRepository extends JpaRepository<UserLicenseEditionHistory, Long> {

	/**
	 * Returns the list of UserLicenseEditionHistory associated with a
	 * {@link UserLicense} sorted by sort param
	 * 
	 * @param userLicense {@link UserLicenseEditionHistory}
	 * @param sort        {@link sSort}
	 * @return {@code List<UserLicenseEditionHistory>} or empty list
	 */
	List<UserLicenseEditionHistory> findByUserLicense(UserLicense userLicense, Sort sort);

	/**
	 * Returns a {@code Page<UserLicenseEditionHistory>} object associated with a
	 * {@link UserLicense} paged by pageable param
	 * 
	 * @param userLicense {@link UserLicenseEditionHistory}
	 * @param pageable    Pageable
	 * @return {@code Page<UserLicenseEditionHistory>} or empty page
	 */
	Page<UserLicenseEditionHistory> findByUserLicense(UserLicense userLicense, Pageable pageable);

	/**
	 * Returns the list of UserLicenseEditionHistory associated with a
	 * {@link UserLicense} if {@link UserLicenseEditionHistory#getDateTime()} is
	 * between the params startDate and endDate
	 * 
	 * @param userLicense {@link UserLicenseEditionHistory}
	 * @param startDate   LocalDateTime
	 * @param endDate     LocalDateTime
	 * @return {@code List<UserLicenseEditionHistory>} or empty list
	 */
	List<UserLicenseEditionHistory> findByUserLicenseAndDateTimeBetween(UserLicense userLicense, LocalDateTime startDate,
			LocalDateTime endDate);

	/**
	 * Returns the top 1 of UserLicenseEditionHistory sorted desc by
	 * {@link UserLicenseEditionHistory#getDateTime()}
	 * 
	 * @param userLicense {@link UserLicense}
	 * @return UserLicenseEditionHistory or null
	 */
	UserLicenseEditionHistory findTop1ByUserLicenseOrderByDateTimeDesc(UserLicense userLicense);

}