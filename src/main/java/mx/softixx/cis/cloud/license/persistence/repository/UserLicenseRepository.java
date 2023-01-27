package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.UserLicense;

/**
 * Repository : UserLicense
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface UserLicenseRepository extends JpaRepository<UserLicense, Long> {

	/**
	 * Returns the {@link UserLicense} that exactly matches the given serie
	 * 
	 * @param serie String
	 * @return UserLicense or null
	 */
	Optional<UserLicense> findBySerie(String serie);

	/**
	 * Returns the {@link UserLicense} associated to an user id and license id if
	 * {@link UserLicense#isActive} is true
	 * 
	 * @param userId    Long
	 * @param licenseId Long
	 * @return UserLicense or null
	 */
	Optional<UserLicense> findByUserIdAndLicenseIdAndActiveTrue(Long userId, Long licenseId);
	
	/**
	 * Returns the {@link UserLicense} that exactly matches the given id, user id
	 * and license id if {@link UserLicense#isActive} is true
	 * 
	 * @param userId    Long
	 * @param licenseId Long
	 * @return UserLicense or null
	 */
	Optional<UserLicense> findByIdAndUserIdAndLicenseIdAndActiveTrue(Long id, Long userId, Long licenseId);
	
	/**
	 * Returns the {@link UserLicense} that exactly matches the given id and user id
	 * 
	 * @param userId    Long
	 * @param licenseId Long
	 * @return UserLicense or null
	 */
	Optional<UserLicense> findByIdAndUserId(Long id, Long userId);

	/**
	 * Returns the list of UserLicense associated with a userId
	 * 
	 * @param userId Long
	 * @return {@code List<UserLicense>} or empty list
	 */
	List<UserLicense> findByUserId(Long userId);

	/**
	 * Returns the list of UserLicense if {@link UserLicense#getSerie()} is like to
	 * serie param and {@link UserLicense#getLicense#getLicenseType#getCode()} is
	 * like to code param sorted by sort param
	 * 
	 * @param serie String
	 * @param code  String
	 * @param sort  {@link Sort}
	 * @return {@code List<UserLicense>} or empty list
	 */
	List<UserLicense> findBySerieContainingIgnoreCaseAndLicense_LicenseType_CodeContainingIgnoreCase(String serie,
			String code, Sort sort);

	/**
	 * Returns a {@code Page<UserLicense>} object if {@link UserLicense#getSerie()}
	 * is like to serie param and
	 * {@link UserLicense#getLicense#getLicenseType#getCode()} is like to code param
	 * paged by pageable param
	 * 
	 * @param serie    String
	 * @param code     String
	 * @param pageable {@link Pageable}
	 * @return {@code Page<UserLicense>} or empty page
	 */
	Page<UserLicense> findBySerieContainingIgnoreCaseAndLicense_LicenseType_CodeContainingIgnoreCase(String serie,
			String code, Pageable pageable);

	/**
	 * Returns the list of UserLicense associated with a userId if
	 * {@link UserLicense#getSerie()} is like to serie param and
	 * {@link UserLicense#getLicense#getLicenseType#getCode()} is like to code param
	 * sorted by sort param
	 * 
	 * @param user  userId
	 * @param serie String
	 * @param code  String
	 * @param sort  {@link Sort}
	 * @return {@code List<UserLicense>} or empty list
	 */
	List<UserLicense> findByUserIdAndSerieContainingIgnoreCaseAndLicense_LicenseType_CodeContainingIgnoreCase(
			Long userId, String serie, String code, Sort sort);

	/**
	 * Returns a {@code Page<UserLicense>} object associated with a userId if
	 * {@link UserLicense#getSerie()} is like to serie param and
	 * {@link UserLicense#getLicense#getLicenseType#getCode()} is like to code param
	 * paged by pageable param
	 * 
	 * @param userId   Long
	 * @param serie    String
	 * @param code     String
	 * @param pageable {@link Pageable}
	 * @return {@code Page<UserLicense>} or empty page
	 */
	Page<UserLicense> findByUserIdAndSerieContainingIgnoreCaseAndLicense_LicenseType_CodeContainingIgnoreCase(
			Long userId, String serie, String code, Pageable pageable);

}