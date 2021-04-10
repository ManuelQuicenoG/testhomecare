package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;


/**
 * The persistent class for the hc_service_states database table.
 * 
 */
@Entity
@Table(name="hc_service_states")
@NamedQuery(name="HcServiceState.findAll", query="SELECT h FROM HcServiceState h")
public class HcServiceState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceStatePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private LocalDate dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private LocalDate dateStart;

	//bi-directional many-to-one association to HcService
	@ManyToOne
	@JoinColumn(name="hc_services_serv_id")
	private HcService hcService;

	//bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id")
	private HcState hcState;

	public HcServiceState() {
	}

	public HcServiceStatePK getId() {
		return this.id;
	}

	public void setId(HcServiceStatePK id) {
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

	public HcService getHcService() {
		return this.hcService;
	}

	public void setHcService(HcService hcService) {
		this.hcService = hcService;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

}