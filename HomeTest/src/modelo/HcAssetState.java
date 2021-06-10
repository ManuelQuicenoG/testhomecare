package modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
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

	public LocalDate getDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getDateStart() {
		return this.dateStart;
	}

	public HcAsset getHcAsset() {
		return this.hcAsset;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public void setHcAsset(HcAsset hcAsset) {
		this.hcAsset = hcAsset;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

}