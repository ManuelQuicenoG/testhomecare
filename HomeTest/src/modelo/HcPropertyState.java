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
 * The persistent class for the hc_property_states database table.
 *
 */
@Entity
@Table(name = "hc_property_states")
@NamedQuery(name = "HcPropertyState.findAll", query = "SELECT h FROM HcPropertyState h")
public class HcPropertyState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcPropertyStatePK id;

	@Column(name = "date_end")
	private LocalDate dateEnd;

	@Column(name = "date_start")
	private LocalDate dateStart;

	// bi-directional many-to-one association to HcProperty
	@ManyToOne
	@JoinColumn(name = "hc_properties_property_id")
	private HcProperty hcProperty;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name = "hc_states_state_id")
	private HcState hcState;

	public HcPropertyState() {
	}

	public HcProperty getHcProperty() {
		return this.hcProperty;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcPropertyStatePK getId() {
		return this.id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setHcProperty(HcProperty hcProperty) {
		this.hcProperty = hcProperty;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setId(HcPropertyStatePK id) {
		this.id = id;
	}

	public void setLocalDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setLocalDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

}