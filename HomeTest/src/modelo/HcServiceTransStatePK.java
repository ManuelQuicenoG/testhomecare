package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_service_trans_states database table.
 * 
 */
@Embeddable
public class HcServiceTransStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	@Column(name="hc_transport_services_hc_serv_trasnport_id", insertable=false, updatable=false)
	private Integer hcTransportServicesHcServTrasnportId;

	public HcServiceTransStatePK() {
	}
	public Integer getHcStatesStateId() {
		return this.hcStatesStateId;
	}
	public void setHcStatesStateId(Integer hcStatesStateId) {
		this.hcStatesStateId = hcStatesStateId;
	}
	public Integer getHcTransportServicesHcServTrasnportId() {
		return this.hcTransportServicesHcServTrasnportId;
	}
	public void setHcTransportServicesHcServTrasnportId(Integer hcTransportServicesHcServTrasnportId) {
		this.hcTransportServicesHcServTrasnportId = hcTransportServicesHcServTrasnportId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcServiceTransStatePK)) {
			return false;
		}
		HcServiceTransStatePK castOther = (HcServiceTransStatePK)other;
		return 
			this.hcStatesStateId.equals(castOther.hcStatesStateId)
			&& this.hcTransportServicesHcServTrasnportId.equals(castOther.hcTransportServicesHcServTrasnportId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcStatesStateId.hashCode();
		hash = hash * prime + this.hcTransportServicesHcServTrasnportId.hashCode();
		
		return hash;
	}
}