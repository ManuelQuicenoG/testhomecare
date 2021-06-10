package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_service_states database table.
 * 
 */
@Embeddable
public class HcServiceStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	@Column(name="hc_services_serv_id", insertable=false, updatable=false)
	private Integer hcServicesServId;

	public HcServiceStatePK() {
	}
	public Integer getHcStatesStateId() {
		return this.hcStatesStateId;
	}
	public void setHcStatesStateId(Integer hcStatesStateId) {
		this.hcStatesStateId = hcStatesStateId;
	}
	public Integer getHcServicesServId() {
		return this.hcServicesServId;
	}
	public void setHcServicesServId(Integer hcServicesServId) {
		this.hcServicesServId = hcServicesServId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcServiceStatePK)) {
			return false;
		}
		HcServiceStatePK castOther = (HcServiceStatePK)other;
		return 
			this.hcStatesStateId.equals(castOther.hcStatesStateId)
			&& this.hcServicesServId.equals(castOther.hcServicesServId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcStatesStateId.hashCode();
		hash = hash * prime + this.hcServicesServId.hashCode();
		
		return hash;
	}
}