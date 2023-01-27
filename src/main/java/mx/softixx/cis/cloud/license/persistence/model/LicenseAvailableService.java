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
 * Persistent class for entity stored in table "license_service"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "license_available_service", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_available_service_id_seq", allocationSize = 1)
public class LicenseAvailableService extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_id", referencedColumnName = "id")
    private License license;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_service_id", referencedColumnName = "id")
    private AvailableService availableService;
    
    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public AvailableService getAvailableService() {
		return availableService;
	}

	public void setAvailableService(AvailableService availableService) {
		this.availableService = availableService;
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