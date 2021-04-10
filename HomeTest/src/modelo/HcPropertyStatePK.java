package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_property_states database table.
 * 
 */
@Embeddable
public class HcPropertyStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_properties_property_id", insertable=false, updatable=false)
	private Integer hcPropertiesPropertyId;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	public HcPropertyStatePK() {
	}
	public Integer getHcPropertiesPropertyId() {
		return this.hcPropertiesPropertyId;
	}
	public void setHcPropertiesPropertyId(Integer hcPropertiesPropertyId) {
		this.hcPropertiesPropertyId = hcPropertiesPropertyId;
	}
	public Integer getHcStatesStateId() {
		return this.hcStatesStateId;
	}
	public void setHcStatesStateId(Integer hcStatesStateId) {
		this.hcStatesStateId = hcStatesStateId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcPropertyStatePK)) {
			return false;
		}
		HcPropertyStatePK castOther = (HcPropertyStatePK)other;
		return 
			this.hcPropertiesPropertyId.equals(castOther.hcPropertiesPropertyId)
			&& this.hcStatesStateId.equals(castOther.hcStatesStateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcPropertiesPropertyId.hashCode();
		hash = hash * prime + this.hcStatesStateId.hashCode();
		
		return hash;
	}
}