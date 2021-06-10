package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_service_poll database table.
 * 
 */
@Embeddable
public class HcServicePollPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_poll_type_poll_type_id", insertable=false, updatable=false)
	private Integer hcPollTypePollTypeId;

	@Column(name="hc_services_serv_id", insertable=false, updatable=false)
	private Integer hcServicesServId;

	public HcServicePollPK() {
	}
	public Integer getHcPollTypePollTypeId() {
		return this.hcPollTypePollTypeId;
	}
	public void setHcPollTypePollTypeId(Integer hcPollTypePollTypeId) {
		this.hcPollTypePollTypeId = hcPollTypePollTypeId;
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
		if (!(other instanceof HcServicePollPK)) {
			return false;
		}
		HcServicePollPK castOther = (HcServicePollPK)other;
		return 
			this.hcPollTypePollTypeId.equals(castOther.hcPollTypePollTypeId)
			&& this.hcServicesServId.equals(castOther.hcServicesServId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcPollTypePollTypeId.hashCode();
		hash = hash * prime + this.hcServicesServId.hashCode();
		
		return hash;
	}
}