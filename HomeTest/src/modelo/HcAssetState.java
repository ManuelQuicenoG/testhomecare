package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;


/**
 * The persistent class for the hc_asset_states database table.
 * 
 */
@Entity
@Table(name="hc_asset_states")
@NamedQuery(name="HcAssetState.findAll", query="SELECT h FROM HcAssetState h")
public class HcAssetState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcAssetStatePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private LocalDate dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private LocalDate dateStart;

	//bi-directional many-to-one association to HcAsset
	@ManyToOne
	@JoinColumn(name="hc_assets_asset_id")
	private HcAsset hcAsset;

	//bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id")
	private HcState hcState;

	public HcAssetState() {
	}

	public HcAssetStatePK getId() {
		return this.id;
	}

	public void setId(HcAssetStatePK id) {
		this.id = id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public void setLocalDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setLocalDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public HcAsset getHcAsset() {
		return this.hcAsset;
	}

	public void setHcAsset(HcAsset hcAsset) {
		this.hcAsset = hcAsset;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

}