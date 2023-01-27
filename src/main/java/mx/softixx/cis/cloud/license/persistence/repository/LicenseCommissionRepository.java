package mx.softixx.cis.cloud.license.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.license.persistence.model.LicenseCommission;

/**
 * Repository : LicenseCommission
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface LicenseCommissionRepository extends JpaRepository<LicenseCommission, Long> {

	/**
	 * Returns the LicenseCommission that exactly matches the given id
	 * 
	 * @param id Long
	 * @return LicenseCommission or null
	 */
	LicenseCommission findByIdAndActiveTrue(Long id);

	/**
	 * Returns the LicenseCommission associated with a onlinePaymentId and
	 * paymentSourceId if {@link LicenseCommission#isActive()} is true
	 * 
	 * @param onlinePaymentId
	 * @param paymentSourceId
	 * @return LicenseCommission or null
	 */
	LicenseCommission findByOnlinePaymentIdAndPaymentSourceIdAndActiveTrue(Long onlinePaymentId, Long paymentSourceId);

}