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
 * Persistent class for entity stored in table "license_type"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "license_type", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_type_id_seq", allocationSize = 1)
public class LicenseType extends BaseEntity {

	@Column(name = "code", length = 100)
	private String code;

	@Column(name = "value_mx", length = 100)
	private String valueMx;

	@Column(name = "value_us", length = 100)
	private String valueUs;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseType", targetEntity = License.class)
	private List<License> licenses;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<License> getLicenses() {
		if (licenses == null) {
			licenses = new ArrayList<>();
		}
		return licenses;
	}

	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
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
		sb.append(active);
		return sb.toString();
	}

}