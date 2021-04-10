package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_transport_providers database table.
 * 
 */
@Embeddable
public class HcTransportProviderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_provaider_id")
	private Integer hcProvaiderId;

	@Column(name="hc_users_user_id", insertable=false, updatable=false)
	private Integer hcUsersUserId;

	public HcTransportProviderPK() {
	}
	public Integer getHcProvaiderId() {
		return this.hcProvaiderId;
	}
	public void setHcProvaiderId(Integer hcProvaiderId) {
		this.hcProvaiderId = hcProvaiderId;
	}
	public Integer getHcUsersUserId() {
		return this.hcUsersUserId;
	}
	public void setHcUsersUserId(Integer hcUsersUserId) {
		this.hcUsersUserId = hcUsersUserId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcTransportProviderPK)) {
			return false;
		}
		HcTransportProviderPK castOther = (HcTransportProviderPK)other;
		return 
			this.hcProvaiderId.equals(castOther.hcProvaiderId)
			&& this.hcUsersUserId.equals(castOther.hcUsersUserId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcProvaiderId.hashCode();
		hash = hash * prime + this.hcUsersUserId.hashCode();
		
		return hash;
	}
}