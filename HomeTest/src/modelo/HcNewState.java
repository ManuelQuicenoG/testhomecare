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
 * The persistent class for the hc_new_states database table.
 *
 */
@Entity
@Table(name = "hc_new_states")
@NamedQuery(name = "HcNewState.findAll", query = "SELECT h FROM HcNewState h")
public class HcNewState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcNewStatePK id;

	@Column(name = "date_end")
	private LocalDate dateEnd;

	@Column(name = "date_start")
	private LocalDate dateStart;

	// bi-directional many-to-one association to HcNew
	@ManyToOne
	@JoinColumn(name = "hc_news_new_id")
	private HcNew hcNew;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name = "hc_states_state_id")
	private HcState hcState;

	public HcNewState() {
	}

	public HcNew getHcNew() {
		return this.hcNew;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcNewStatePK getId() {
		return this.id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setHcNew(HcNew hcNew) {
		this.hcNew = hcNew;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setId(HcNewStatePK id) {
		this.id = id;
	}

	public void setLocalDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setLocalDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

}