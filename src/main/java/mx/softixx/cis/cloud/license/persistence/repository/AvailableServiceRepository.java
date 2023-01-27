package mx.softixx.cis.cloud.license.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.AvailableService;

/**
 * Repository : AvailableService
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface AvailableServiceRepository extends JpaRepository<AvailableService, Long> {

	/**
	 * Returns the AvailableService that exactly matches the given id
	 * 
	 * @param id Long
	 * @return AvailableService or null
	 */
	AvailableService findByIdAndActiveTrue(Long id);

	/**
	 * Returns the AvailableService that exactly matches the given code
	 * 
	 * @param code String
	 * @return AvailableService or null
	 */
	AvailableService findByCodeAndActiveTrue(String code);

	/**
	 * Returns the list of AvailableService if {@link AvailableService#isActive()} is
	 * false
	 * 
	 * @return {@code List<AvailableService>} or empty list
	 */
	List<AvailableService> findByActiveTrue();

}