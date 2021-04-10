package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_new_states database table.
 * 
 */
@Embeddable
public class HcNewStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_news_new_id", insertable=false, updatable=false)
	private Integer hcNewsNewId;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	public HcNewStatePK() {
	}
	public Integer getHcNewsNewId() {
		return this.hcNewsNewId;
	}
	public void setHcNewsNewId(Integer hcNewsNewId) {
		this.hcNewsNewId = hcNewsNewId;
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
		if (!(other instanceof HcNewStatePK)) {
			return false;
		}
		HcNewStatePK castOther = (HcNewStatePK)other;
		return 
			this.hcNewsNewId.equals(castOther.hcNewsNewId)
			&& this.hcStatesStateId.equals(castOther.hcStatesStateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcNewsNewId.hashCode();
		hash = hash * prime + this.hcStatesStateId.hashCode();
		
		return hash;
	}
}