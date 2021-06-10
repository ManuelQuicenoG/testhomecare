package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_service_poll_transport database table.
 * 
 */
@Embeddable
public class HcServicePollTransportPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_poll_type_transport_poll_type_id", insertable=false, updatable=false)
	private Integer hcPollTypeTransportPollTypeId;

	@Column(name="hc_transport_services_hc_serv_transport_id", insertable=false, updatable=false)
	private Integer hcTransportServicesHcServTransportId;

	public HcServicePollTransportPK() {
	}
	public Integer getHcPollTypeTransportPollTypeId() {
		return this.hcPollTypeTransportPollTypeId;
	}
	public void setHcPollTypeTransportPollTypeId(Integer hcPollTypeTransportPollTypeId) {
		this.hcPollTypeTransportPollTypeId = hcPollTypeTransportPollTypeId;
	}
	public Integer getHcTransportServicesHcServTransportId() {
		return this.hcTransportServicesHcServTransportId;
	}
	public void setHcTransportServicesHcServTransportId(Integer hcTransportServicesHcServTransportId) {
		this.hcTransportServicesHcServTransportId = hcTransportServicesHcServTransportId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcServicePollTransportPK)) {
			return false;
		}
		HcServicePollTransportPK castOther = (HcServicePollTransportPK)other;
		return 
			this.hcPollTypeTransportPollTypeId.equals(castOther.hcPollTypeTransportPollTypeId)
			&& this.hcTransportServicesHcServTransportId.equals(castOther.hcTransportServicesHcServTransportId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcPollTypeTransportPollTypeId.hashCode();
		hash = hash * prime + this.hcTransportServicesHcServTransportId.hashCode();
		
		return hash;
	}
}