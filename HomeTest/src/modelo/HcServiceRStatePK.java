package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_service_r_states database table.
 * 
 */
@Embeddable
public class HcServiceRStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	@Column(name="hc_service_requests_service_r_id", insertable=false, updatable=false)
	private Integer hcServiceRequestsServiceRId;

	public HcServiceRStatePK() {
	}
	public Integer getHcStatesStateId() {
		return this.hcStatesStateId;
	}
	public void setHcStatesStateId(Integer hcStatesStateId) {
		this.hcStatesStateId = hcStatesStateId;
	}
	public Integer getHcServiceRequestsServiceRId() {
		return this.hcServiceRequestsServiceRId;
	}
	public void setHcServiceRequestsServiceRId(Integer hcServiceRequestsServiceRId) {
		this.hcServiceRequestsServiceRId = hcServiceRequestsServiceRId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcServiceRStatePK)) {
			return false;
		}
		HcServiceRStatePK castOther = (HcServiceRStatePK)other;
		return 
			this.hcStatesStateId.equals(castOther.hcStatesStateId)
			&& this.hcServiceRequestsServiceRId.equals(castOther.hcServiceRequestsServiceRId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcStatesStateId.hashCode();
		hash = hash * prime + this.hcServiceRequestsServiceRId.hashCode();
		
		return hash;
	}
}