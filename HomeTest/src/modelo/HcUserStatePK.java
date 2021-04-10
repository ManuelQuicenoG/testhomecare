package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_user_states database table.
 * 
 */
@Embeddable
public class HcUserStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_users_user_id", insertable=false, updatable=false)
	private Integer hcUsersUserId;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	public HcUserStatePK() {
	}
	public Integer getHcUsersUserId() {
		return this.hcUsersUserId;
	}
	public void setHcUsersUserId(Integer hcUsersUserId) {
		this.hcUsersUserId = hcUsersUserId;
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
		if (!(other instanceof HcUserStatePK)) {
			return false;
		}
		HcUserStatePK castOther = (HcUserStatePK)other;
		return 
			this.hcUsersUserId.equals(castOther.hcUsersUserId)
			&& this.hcStatesStateId.equals(castOther.hcStatesStateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcUsersUserId.hashCode();
		hash = hash * prime + this.hcStatesStateId.hashCode();
		
		return hash;
	}
}