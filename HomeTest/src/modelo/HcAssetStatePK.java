package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_asset_states database table.
 * 
 */
@Embeddable
public class HcAssetStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_states_state_id", insertable=false, updatable=false)
	private Integer hcStatesStateId;

	@Column(name="hc_assets_asset_id", insertable=false, updatable=false)
	private Integer hcAssetsAssetId;

	public HcAssetStatePK() {
	}
	public Integer getHcStatesStateId() {
		return this.hcStatesStateId;
	}
	public void setHcStatesStateId(Integer hcStatesStateId) {
		this.hcStatesStateId = hcStatesStateId;
	}
	public Integer getHcAssetsAssetId() {
		return this.hcAssetsAssetId;
	}
	public void setHcAssetsAssetId(Integer hcAssetsAssetId) {
		this.hcAssetsAssetId = hcAssetsAssetId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcAssetStatePK)) {
			return false;
		}
		HcAssetStatePK castOther = (HcAssetStatePK)other;
		return 
			this.hcStatesStateId.equals(castOther.hcStatesStateId)
			&& this.hcAssetsAssetId.equals(castOther.hcAssetsAssetId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcStatesStateId.hashCode();
		hash = hash * prime + this.hcAssetsAssetId.hashCode();
		
		return hash;
	}
}