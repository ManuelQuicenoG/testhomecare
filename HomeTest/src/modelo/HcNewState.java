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
 * The persistent class for the hc_new_states database table.
 *
 */
@Entity
@Table(name = "hc_new_states")
@NamedQuery(name = "HcNewState.findAll", query = "SELECT h FROM HcNewState h")
public class HcNewState implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public LocalDate getDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getDateStart() {
		return this.dateStart;
	}

	public HcNew getHcNew() {
		return this.hcNew;
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

	public void setHcNew(HcNew hcNew) {
		this.hcNew = hcNew;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

}