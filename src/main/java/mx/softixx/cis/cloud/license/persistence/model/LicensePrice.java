package mx.softixx.cis.cloud.license.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "license_price"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "license_price", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_price_seq", allocationSize = 1)
public class LicensePrice extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@Column(name = "subtotal_mxn")
	private Double subtotalMxn;

	@Column(name = "tax_mxn")
	private boolean taxMxn;

	@Column(name = "tax_rate_mxn")
	private Integer taxRateMxn;

	@Column(name = "total_mxn")
	private Double totalMxn;

	@Column(name = "subtotal_usd")
	private Double subtotalUsd;

	@Column(name = "tax_usd")
	private boolean taxUsd;

	@Column(name = "tax_rate_usd")
	private Integer taxRateUsd;

	@Column(name = "total_usd")
	private Double totalUsd;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public Double getSubtotalMxn() {
		return subtotalMxn;
	}

	public void setSubtotalMxn(Double subtotalMxn) {
		this.subtotalMxn = subtotalMxn;
	}

	public boolean isTaxMxn() {
		return taxMxn;
	}

	public void setTaxMxn(boolean taxMxn) {
		this.taxMxn = taxMxn;
	}

	public Integer getTaxRateMxn() {
		return taxRateMxn;
	}

	public void setTaxRateMxn(Integer taxRateMxn) {
		this.taxRateMxn = taxRateMxn;
	}

	public Double getTotalMxn() {
		return totalMxn;
	}

	public void setTotalMxn(Double totalMxn) {
		this.totalMxn = totalMxn;
	}

	public Double getSubtotalUsd() {
		return subtotalUsd;
	}

	public void setSubtotalUsd(Double subtotalUsd) {
		this.subtotalUsd = subtotalUsd;
	}

	public boolean isTaxUsd() {
		return taxUsd;
	}

	public void setTaxUsd(boolean taxUsd) {
		this.taxUsd = taxUsd;
	}

	public Integer getTaxRateUsd() {
		return taxRateUsd;
	}

	public void setTaxRateUsd(Integer taxRateUsd) {
		this.taxRateUsd = taxRateUsd;
	}

	public Double getTotalUsd() {
		return totalUsd;
	}

	public void setTotalUsd(Double totalUsd) {
		this.totalUsd = totalUsd;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(subtotalMxn);
		sb.append("|");
		sb.append(taxMxn);
		sb.append("|");
		sb.append(taxRateMxn);
		sb.append("|");
		sb.append(totalMxn);
		sb.append("|");
		sb.append(subtotalUsd);
		sb.append("|");
		sb.append(taxUsd);
		sb.append("|");
		sb.append(taxRateUsd);
		sb.append("|");
		sb.append(totalUsd);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}