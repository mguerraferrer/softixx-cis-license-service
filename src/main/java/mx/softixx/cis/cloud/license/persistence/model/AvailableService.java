package mx.softixx.cis.cloud.license.persistence.model;

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
 * Persistent class for entity stored in table "service"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "available_service", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.available_service_id_seq", allocationSize = 1)
public class AvailableService extends BaseEntity {

	@Column(name = "code", nullable = false, length = 10)
	private String code;

	@Column(name = "value_mx", nullable = false, length = 100)
	private String valueMx;

	@Column(name = "value_us", nullable = false, length = 100)
	private String valueUs;

	@Column(name = "image", length = 100)
	private String image;

	@Column(name = "frequently_payment")
	private boolean frequentlyPayment;

	@Column(name = "order")
	private Integer order;

	@Column(name = "hash", length = 100)
	private String hash;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "price_mxn")
	private Double priceMxn;

	@Column(name = "price_usd")
	private Double priceUsd;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "availableService", targetEntity = LicenseAvailableService.class)
	private List<LicenseAvailableService> licenseAvailableServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "availableService", targetEntity = UserLicenseAvailableService.class)
	private List<UserLicenseAvailableService> userLicenseServices;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValueMx() {
		return valueMx;
	}

	public void setValueMx(String valueMx) {
		this.valueMx = valueMx;
	}

	public String getValueUs() {
		return valueUs;
	}

	public void setValueUs(String valueUs) {
		this.valueUs = valueUs;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isFrequentlyPayment() {
		return frequentlyPayment;
	}

	public void setFrequentlyPayment(boolean frequentlyPayment) {
		this.frequentlyPayment = frequentlyPayment;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPriceMxn() {
		return priceMxn;
	}

	public void setPriceMxn(Double priceMxn) {
		this.priceMxn = priceMxn;
	}

	public Double getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(Double priceUsd) {
		this.priceUsd = priceUsd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<LicenseAvailableService> getLicenseAvailableServices() {
		if (licenseAvailableServices == null) {
			licenseAvailableServices = new ArrayList<>();
		}
		return licenseAvailableServices;
	}

	public void setLicenseAvailableServices(List<LicenseAvailableService> licenseAvailableServices) {
		this.licenseAvailableServices = licenseAvailableServices;
	}

	public List<UserLicenseAvailableService> getUserLicenseServices() {
		if (userLicenseServices == null) {
			userLicenseServices = new ArrayList<>();
		}
		return userLicenseServices;
	}

	public void setUserLicenseServices(List<UserLicenseAvailableService> userLicenseServices) {
		this.userLicenseServices = userLicenseServices;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(code);
		sb.append("|");
		sb.append(valueMx);
		sb.append("|");
		sb.append(valueUs);
		sb.append("|");
		sb.append(image);
		sb.append("|");
		sb.append(frequentlyPayment);
		sb.append("|");
		sb.append(order);
		sb.append("|");
		sb.append(hash);
		sb.append("|");
		sb.append(description);
		sb.append("|");
		sb.append(priceMxn);
		sb.append("|");
		sb.append(priceUsd);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}