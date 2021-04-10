package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;


/**
 * The persistent class for the hc_service_r_states database table.
 * 
 */
@Entity
@Table(name="hc_service_r_states")
@NamedQuery(name="HcServiceRState.findAll", query="SELECT h FROM HcServiceRState h")
public class HcServiceRState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceRStatePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private LocalDate dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private LocalDate dateStart;

	//bi-directional many-to-one association to HcServiceRequest
	@ManyToOne
	@JoinColumn(name="hc_service_requests_service_r_id")
	private HcServiceRequest hcServiceRequest;

	//bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id")
	private HcState hcState;

	public HcServiceRState() {
	}

	public HcServiceRStatePK getId() {
		return this.id;
	}

	public void setId(HcServiceRStatePK id) {
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

	public HcServiceRequest getHcServiceRequest() {
		return this.hcServiceRequest;
	}

	public void setHcServiceRequest(HcServiceRequest hcServiceRequest) {
		this.hcServiceRequest = hcServiceRequest;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

}