package mx.softixx.cis.cloud.license.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.cloud.license.persistence.model.UserLicensePaymentHistory;

/**
 * Repository : UserLicensePaymentHistory
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicensePaymentHistoryRepository extends JpaRepository<UserLicensePaymentHistory, Long> {

	/**
	 * Returns the top of UserLicensePaymentHistory associated with a
	 * {@link UserLicense} sorted desc by {@link UserLicensePaymentHistory#getId()}
	 * 
	 * @param userLicense {@link UserLicense}
	 * @return UserLicensePaymentHistory or null
	 */
	UserLicensePaymentHistory findTopByUserLicenseOrderByIdDesc(UserLicense userLicense);

	/**
	 * Returns the list of UserLicensePaymentHistory associated with a
	 * {@link UserLicense} sorted by sort param
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param sort        {@link Sort}
	 * @return {@code List<UserLicensePaymentHistory>} or empty list
	 */
	List<UserLicensePaymentHistory> findByUserLicense(UserLicense userLicense, Sort sort);

	/**
	 * Returns a {@code Page<UserLicensePaymentHistory>} object associated with a
	 * {@link UserLicense} paged by pageable param
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param pageable    {@link Pageable}
	 * @return {@code Page<UserLicensePaymentHistory>} or empty page
	 */
	Page<UserLicensePaymentHistory> findByUserLicense(UserLicense userLicense, Pageable pageable);

	/**
	 * Returns the list of UserLicensePaymentHistory associated with a
	 * {@link UserLicense} if {@link UserLicensePaymentHistory#getDateTime()} is
	 * between the params startDate and endDate
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param startDate   LocalDateTime
	 * @param endDate     LocalDateTime
	 * @return {@code List<UserLicensePaymentHistory>} or empty list
	 */
	List<UserLicensePaymentHistory> findByUserLicenseAndPaymentDateBetween(UserLicense userLicense,
			LocalDateTime startDate, LocalDateTime endDate);

}