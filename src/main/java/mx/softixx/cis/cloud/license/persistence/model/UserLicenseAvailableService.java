package mx.softixx.cis.cloud.license.persistence.model;

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
 * Persistent class for entity stored in table "user_license_service"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "user_license_service", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_service_id_seq", allocationSize = 1)
public class UserLicenseAvailableService extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_service_id", referencedColumnName = "id")
    private AvailableService availableService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_license_id", referencedColumnName = "id")
    private UserLicense userLicense;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicenseAvailableService", targetEntity = UserLicenseAvailableServiceHistory.class)
    private List<UserLicenseAvailableServiceHistory> userLicenseServiceHistories;
    
    @Column(name = "active")
	private boolean active;

    /* Getters and Setters */
    public AvailableService getAvailableService() {
		return availableService;
	}

	public void setAvailableService(AvailableService availableService) {
		this.availableService = availableService;
	}
	
    public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	public List<UserLicenseAvailableServiceHistory> getUserLicenseServiceHistories() {
		if(userLicenseServiceHistories == null) {
			userLicenseServiceHistories = new ArrayList<>();
		}
		return userLicenseServiceHistories;
	}

	public void setUserLicenseServiceHistories(List<UserLicenseAvailableServiceHistory> userLicenseServiceHistories) {
		this.userLicenseServiceHistories = userLicenseServiceHistories;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
    public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(active);
        return sb.toString();
    }

}