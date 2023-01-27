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
 * Persistent class for entity stored in table "user_license_change_history"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "user_license_change_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_change_history_id_seq", allocationSize = 1)
public class UserLicenseChangeHistory extends BaseEntity {

	@Column(name = "old_license_hash", nullable = false, length = 50)
	private String oldLicenseHash;

	@Column(name = "current_license_hash", nullable = false, length = 50)
	private String currentLicenseHash;

	@Column(name = "date_time", nullable = false)
	private LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	public UserLicenseChangeHistory() {
	}

	public UserLicenseChangeHistory(UserLicense userLicense, String oldLicenseHash, String currentLicenseHash) {
		this.userLicense = userLicense;
		this.oldLicenseHash = oldLicenseHash;
		this.currentLicenseHash = currentLicenseHash;
		this.dateTime = LocalDateTime.now();
	}

	/* Getters and Setters */
	public String getOldLicenseHash() {
		return oldLicenseHash;
	}

	public void setOldLicenseHash(String oldLicenseHash) {
		this.oldLicenseHash = oldLicenseHash;
	}

	public String getCurrentLicenseHash() {
		return currentLicenseHash;
	}

	public void setCurrentLicenseHash(String currentLicenseHash) {
		this.currentLicenseHash = currentLicenseHash;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
		sb.append(oldLicenseHash);
		sb.append("|");
		sb.append(currentLicenseHash);
		sb.append("|");
		sb.append(dateTime);
		return sb.toString();
	}

}