package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.LicenseType;

/**
 * Repository : LicenseType
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicenseTypeRepository extends JpaRepository<LicenseType, Long> {
	
	/**
	 * Returns the LicenseType that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicenseType or null
	 */
	LicenseType findByIdAndActiveTrue(Long id);
	
	/**
	 * Returns the LicenseType that exactly matches the given code
	 * 
	 * @param code String
	 * @return LicenseType or null
	 */
	LicenseType findByCodeAndActiveTrue(String code);
	
	/**
	 * Returns the list of LicenseType that have the deleted field set to false
	 * 
	 * @return {@code List<LicenseType>} or empty list
	 */
	List<LicenseType> findByActiveTrue();
	
}