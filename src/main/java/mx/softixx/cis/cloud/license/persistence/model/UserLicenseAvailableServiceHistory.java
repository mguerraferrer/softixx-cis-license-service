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
 * Persistent class for entity stored in table "user_license_service_history"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "user_license_service_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_user_license_service_history_id_seq", allocationSize = 1)
public class UserLicenseAvailableServiceHistory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_service_id", referencedColumnName = "id")
	private UserLicenseAvailableService userLicenseAvailableService;
	
	@Column(name = "entry_date", nullable = false)
	private LocalDateTime entryDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;

	/* Getters and Setters */
	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public UserLicenseAvailableService getUserLicenseAvailableService() {
		return userLicenseAvailableService;
	}

	public void setUserLicenseAvailableService(UserLicenseAvailableService userLicenseAvailableService) {
		this.userLicenseAvailableService = userLicenseAvailableService;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(entryDate);
		sb.append("|");
		sb.append(endDate);
		return sb.toString();
	}

}