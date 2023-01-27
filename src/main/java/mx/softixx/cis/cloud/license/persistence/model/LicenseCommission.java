package mx.softixx.cis.cloud.license.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "license_commission"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "license_commission", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_commission_id_seq", allocationSize = 1)
public class LicenseCommission extends BaseEntity {

	@Column(name = "online_payment_id")
	private Long onlinePaymentId;

	@Column(name = "payment_source_id")
	private Long paymentSourceId;
	
	@Column(name = "comission_percentage")
	private BigDecimal comissionPercentage;

	@Column(name = "comission")
	private BigDecimal comission;

	@Column(name = "tax")
	private boolean tax;

	@Column(name = "tax_percentage")
	private BigDecimal taxPercentage;

	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseCommission", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	/* Getters and Setters */
	public BigDecimal getComissionPercentage() {
		return comissionPercentage;
	}

	public void setComissionPercentage(BigDecimal comissionPercentage) {
		this.comissionPercentage = comissionPercentage;
	}

	public BigDecimal getComission() {
		return comission;
	}

	public void setComission(BigDecimal comission) {
		this.comission = comission;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getOnlinePaymentId() {
		return onlinePaymentId;
	}

	public void setOnlinePaymentId(Long onlinePaymentId) {
		this.onlinePaymentId = onlinePaymentId;
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

	public Long getPaymentSourceId() {
		return paymentSourceId;
	}

	public void setPaymentSourceId(Long paymentSourceId) {
		this.paymentSourceId = paymentSourceId;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(comissionPercentage);
		sb.append("|");
		sb.append(comission);
		sb.append("|");
		sb.append(tax);
		sb.append("|");
		sb.append(taxPercentage);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}