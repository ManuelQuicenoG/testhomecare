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
 * The persistent class for the hc_service_r_states database table.
 *
 */
@Entity
@Table(name = "hc_service_r_states")
@NamedQuery(name = "HcServiceRState.findAll", query = "SELECT h FROM HcServiceRState h")
public class HcServiceRState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceRStatePK id;

	@Column(name="date_end")
	private LocalDate dateEnd;

	@Column(name="date_start")
	private LocalDate dateStart;

	// bi-directional many-to-one association to HcServiceRequest
	@ManyToOne
	@JoinColumn(name="hc_service_requests_service_r_id", insertable = false, updatable = false)
	private HcServiceRequest hcServiceRequest;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id", insertable = false, updatable = false)
	private HcState hcState;

	public HcServiceRState() {
	}

	public HcServiceRequest getHcServiceRequest() {
		return this.hcServiceRequest;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcServiceRStatePK getId() {
		return this.id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setHcServiceRequest(HcServiceRequest hcServiceRequest) {
		this.hcServiceRequest = hcServiceRequest;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setId(HcServiceRStatePK id) {
		this.id = id;
	}

	public void setLocalDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setLocalDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

}