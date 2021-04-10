package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_service_trans_r_states database table.
 * 
 */
@Embeddable
public class HcServiceTransRStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="state_id")
	private Integer stateId;

	@Column(name="hc_service_request_trans_hc_serv_r_trans_id", insertable=false, updatable=false)
	private Integer hcServiceRequestTransHcServRTransId;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	public HcServiceTransRStatePK() {
	}
	public Integer getStateId() {
		return this.stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getHcServiceRequestTransHcServRTransId() {
		return this.hcServiceRequestTransHcServRTransId;
	}
	public void setHcServiceRequestTransHcServRTransId(Integer hcServiceRequestTransHcServRTransId) {
		this.hcServiceRequestTransHcServRTransId = hcServiceRequestTransHcServRTransId;
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
		if (!(other instanceof HcServiceTransRStatePK)) {
			return false;
		}
		HcServiceTransRStatePK castOther = (HcServiceTransRStatePK)other;
		return 
			this.stateId.equals(castOther.stateId)
			&& this.hcServiceRequestTransHcServRTransId.equals(castOther.hcServiceRequestTransHcServRTransId)
			&& this.hcStatesStateId.equals(castOther.hcStatesStateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.stateId.hashCode();
		hash = hash * prime + this.hcServiceRequestTransHcServRTransId.hashCode();
		hash = hash * prime + this.hcStatesStateId.hashCode();
		
		return hash;
	}
}