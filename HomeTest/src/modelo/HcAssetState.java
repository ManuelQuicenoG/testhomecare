package modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the hc_asset_states database table.
 *
 */
@Entity
@Table(name = "hc_asset_states")
@NamedQuery(name = "HcAssetState.findAll", query = "SELECT h FROM HcAssetState h")
public class HcAssetState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcAssetStatePK id;

	@Column(name = "date_end")
	private LocalDate dateEnd;

	@Column(name = "date_start")
	private LocalDate dateStart;

	// bi-directional many-to-one association to HcAsset
	@ManyToOne
	@JoinColumn(name = "hc_assets_asset_id")
	private HcAsset hcAsset;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name = "hc_states_state_id")
	private HcState hcState;

	public HcAssetState() {
	}

	public HcAsset getHcAsset() {
		return this.hcAsset;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcAssetStatePK getId() {
		return this.id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setHcAsset(HcAsset hcAsset) {
		this.hcAsset = hcAsset;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setId(HcAssetStatePK id) {
		this.id = id;
	}

	public void setLocalDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setLocalDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

}