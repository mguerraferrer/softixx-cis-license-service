package mx.softixx.cis.cloud.license.persistence.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "user_license_payment_frequently"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "user_license_payment_frequently", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_payment_frequently_id_seq", allocationSize = 1)
public class UserLicenseFrequentlyPayment extends BaseEntity {

	@Column(name = "next_payment", nullable = false)
	private LocalDateTime nextPayment;

	@Column(name = "payment_mode_id")
	private Long paymentModeId;

	@ManyToOne
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public LocalDateTime getNextPayment() {
		return nextPayment;
	}

	public void setNextPayment(LocalDateTime nextPayment) {
		this.nextPayment = nextPayment;
	}

	public Long getPaymentModeId() {
		return paymentModeId;
	}

	public void setPaymentModeId(Long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(nextPayment);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}