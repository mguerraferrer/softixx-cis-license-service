package mx.softixx.cis.cloud.license.persistence.model;

import java.time.LocalDate;
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
 * Persistent class for entity stored in table "user_license"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "user_license", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_id_seq", allocationSize = 1)
public class UserLicense extends BaseEntity {

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "serie", length = 50)
	private String serie;

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@Column(name = "actualization_date")
	private LocalDateTime actualizationDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "private_practice")
	private boolean privatePractice;

	@Column(name = "clinical_entity")
	private boolean clinicalEntity;

	@Column(name = "license_mxn")
	private boolean licenseMxn;

	@Column(name = "license_usd")
	private boolean licenseUsd;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseAvailableService.class)
	private List<UserLicenseAvailableService> userLicenseServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseChangeHistory.class)
	private List<UserLicenseChangeHistory> userLicenseChangeHistories;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseFrequentlyPayment.class)
	private List<UserLicenseFrequentlyPayment> userLicensePaymentFrequentlies;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseEditionHistory.class)
	private List<UserLicenseEditionHistory> userLicenseEditionHistories;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	public UserLicense() {
	}

	public UserLicense(License license, Long userId, String serie, LocalDate dueDate) {
		this.license = license;
		this.userId = userId;
		this.serie = serie;
		this.dueDate = dueDate;
	}

	/* Getters and Setters */
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public LocalDateTime getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(LocalDateTime activationDate) {
		this.activationDate = activationDate;
	}

	public LocalDateTime getActualizationDate() {
		return actualizationDate;
	}

	public void setActualizationDate(LocalDateTime actualizationDate) {
		this.actualizationDate = actualizationDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(boolean privatePractice) {
		this.privatePractice = privatePractice;
	}

	public boolean isClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(boolean clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public boolean isLicenseMxn() {
		return licenseMxn;
	}

	public void setLicenseMxn(boolean licenseMxn) {
		this.licenseMxn = licenseMxn;
	}

	public boolean isLicenseUsd() {
		return licenseUsd;
	}

	public void setLicenseUsd(boolean licenseUsd) {
		this.licenseUsd = licenseUsd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public List<UserLicenseAvailableService> getUserLicenseServices() {
		if (userLicenseServices == null) {
			userLicenseServices = new ArrayList<>();
		}
		return userLicenseServices;
	}

	public void setUserLicenseServices(List<UserLicenseAvailableService> userLicenseServices) {
		this.userLicenseServices = userLicenseServices;
	}

	public List<UserLicenseChangeHistory> getUserLicenseChangeHistories() {
		if (userLicenseChangeHistories == null) {
			userLicenseChangeHistories = new ArrayList<>();
		}
		return userLicenseChangeHistories;
	}

	public void setUserLicenseChangeHistories(List<UserLicenseChangeHistory> userLicenseChangeHistories) {
		this.userLicenseChangeHistories = userLicenseChangeHistories;
	}

	public List<UserLicenseFrequentlyPayment> getUserLicensePaymentFrequentlies() {
		if (userLicensePaymentFrequentlies == null) {
			userLicensePaymentFrequentlies = new ArrayList<>();
		}
		return userLicensePaymentFrequentlies;
	}

	public void setUserLicensePaymentFrequentlies(List<UserLicenseFrequentlyPayment> userLicensePaymentFrequentlies) {
		this.userLicensePaymentFrequentlies = userLicensePaymentFrequentlies;
	}

	public List<UserLicenseEditionHistory> getUserLicenseEditionHistories() {
		if (userLicenseEditionHistories == null) {
			userLicenseEditionHistories = new ArrayList<>();
		}
		return userLicenseEditionHistories;
	}

	public void setUserLicenseEditionHistories(List<UserLicenseEditionHistory> userLicenseEditionHistories) {
		this.userLicenseEditionHistories = userLicenseEditionHistories;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(serie);
		sb.append("|");
		sb.append(activationDate);
		sb.append("|");
		sb.append(actualizationDate);
		sb.append("|");
		sb.append(dueDate);
		sb.append("|");
		sb.append(privatePractice);
		sb.append("|");
		sb.append(clinicalEntity);
		sb.append("|");
		sb.append(licenseMxn);
		sb.append("|");
		sb.append(licenseUsd);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}