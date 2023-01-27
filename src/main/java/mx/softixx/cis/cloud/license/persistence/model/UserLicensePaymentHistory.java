package mx.softixx.cis.cloud.license.persistence.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "user_license_payment_history"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "user_license_payment_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_payment_history_id_seq", allocationSize = 1)
public class UserLicensePaymentHistory extends BaseEntity {

	@Column(name = "payment_day", nullable = false)
	private LocalDateTime paymentDate;

	@Column(name = "reference", nullable = false, length = 50)
	private String reference;

	@Column(name = "currency", nullable = false, length = 50)
	private String currency;

	@Column(name = "discount_code", length = 50)
	private String discountCode;

	@Column(name = "subtotal", nullable = false)
	private Double subtotal;

	@Column(name = "tax", nullable = false)
	private Double tax;

	@Column(name = "discount", nullable = false)
	private Double discount;

	@Column(name = "total_comission", nullable = false)
	private Double totalComission;

	@Column(name = "total_services", nullable = false)
	private Double totalServices;

	@Column(name = "total", nullable = false)
	private Double total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_comission_id", referencedColumnName = "id")
	private LicenseCommission licenseCommission;

	@Column(name = "payment_mode_id")
	private Long paymentModeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_promo_id", referencedColumnName = "id")
	private LicensePromo licensePromo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_direct_promo_id", referencedColumnName = "id")
	private LicenseDirectPromo licenseDirectPromo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "payment_source_id")
	private Long paymentSourceId;

	public UserLicensePaymentHistory() {
		super();
	}

	/* Getters and Setters */
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotalComission() {
		return totalComission;
	}

	public void setTotalComission(Double totalComission) {
		this.totalComission = totalComission;
	}

	public Double getTotalServices() {
		return totalServices;
	}

	public void setTotalServices(Double totalServices) {
		this.totalServices = totalServices;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LicenseCommission getLicenseCommission() {
		return licenseCommission;
	}

	public void setLicenseCommission(LicenseCommission licenseCommission) {
		this.licenseCommission = licenseCommission;
	}

	public Long getPaymentModeId() {
		return paymentModeId;
	}

	public void setPaymentModeId(Long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public LicensePromo getLicensePromo() {
		return licensePromo;
	}

	public void setLicensePromo(LicensePromo licensePromo) {
		this.licensePromo = licensePromo;
	}

	public LicenseDirectPromo getLicenseDirectPromo() {
		return licenseDirectPromo;
	}

	public void setLicenseDirectPromo(LicenseDirectPromo licenseDirectPromo) {
		this.licenseDirectPromo = licenseDirectPromo;
	}

	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
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
		sb.append(paymentDate);
		sb.append("|");
		sb.append(reference);
		sb.append("|");
		sb.append(currency);
		sb.append("|");
		sb.append(discountCode);
		sb.append("|");
		sb.append(subtotal);
		sb.append("|");
		sb.append(tax);
		sb.append("|");
		sb.append(discount);
		sb.append("|");
		sb.append(totalComission);
		sb.append("|");
		sb.append(totalServices);
		sb.append("|");
		sb.append(total);
		return sb.toString();
	}

}