package mx.softixx.cis.cloud.license.persistence.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "license_promo"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "license_promo", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_promo_id_seq", allocationSize = 1)
public class LicensePromo extends BaseEntity {

	@Column(name = "code", length = 20)
	private String code;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "active")
	private boolean active;

	@Column(name = "payment_mode_id")
	private Long paymentModeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licensePromo", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getPaymentModeId() {
		return paymentModeId;
	}

	public void setPaymentModeId(Long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	public void setUserLicensePaymentHistories(List<UserLicensePaymentHistory> userLicensePaymentHistories) {
		this.userLicensePaymentHistories = userLicensePaymentHistories;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(code);
		sb.append("|");
		sb.append(discount);
		sb.append("|");
		sb.append(startDate);
		sb.append("|");
		sb.append(dueDate);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}