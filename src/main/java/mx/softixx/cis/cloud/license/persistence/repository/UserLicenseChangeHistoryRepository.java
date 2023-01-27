package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.UserLicense;
import mx.softixx.cis.cloud.license.persistence.model.UserLicenseChangeHistory;

/**
 * Repository : UserLicenseChangeHistory
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicenseChangeHistoryRepository extends JpaRepository<UserLicenseChangeHistory, Long> {

	/**
	 * Returns the list of UserLicenseChangeHistory associated with a
	 * {@link UserLicense} sorted by sort param
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param sort        {@link Sort}
	 * @return {@code List<UserLicenseChangeHistory>} or empty list
	 */
	List<UserLicenseChangeHistory> findByUserLicense(UserLicense userLicense, Sort sort);

	/**
	 * Returns a {@code Page<UserLicenseChangeHistory>} object associated with
	 * a {@link UserLicense} paged by pageable param
	 * 
	 * @param userLicense {@link UserLicense}
	 * @param pageable    {@link Pageable}
	 * @return {@code Page<UserLicenseChangeHistory>} or empty page
	 */
	Page<UserLicenseChangeHistory> findByUserLicense(UserLicense userLicense, Pageable pageable);

	/**
	 * Returns the top 1 of UserLicenseChangeHistory sorted desc by
	 * {@link UserLicenseChangeHistory#getDateTime()}
	 * 
	 * @param userLicense {@link UserLicense}
	 * @return UserLicenseChangeHistory or null
	 */
	UserLicenseChangeHistory findTop1ByUserLicenseOrderByDateTimeDesc(UserLicense userLicense);

}