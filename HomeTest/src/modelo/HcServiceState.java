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
 * The persistent class for the hc_service_states database table.
 *
 */
@Entity
@Table(name = "hc_service_states")
@NamedQuery(name = "HcServiceState.findAll", query = "SELECT h FROM HcServiceState h")
public class HcServiceState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceStatePK id;

	@Column(name = "date_end")
	private LocalDate dateEnd;

	@Column(name = "date_start")
	private LocalDate dateStart;

	// bi-directional many-to-one association to HcService
	@ManyToOne
	@JoinColumn(name = "hc_services_serv_id", insertable = false, updatable = false)
	private HcService hcService;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name = "hc_states_state_id", insertable = false, updatable = false)
	private HcState hcState;

	public HcServiceState() {
	}

	public HcService getHcService() {
		return this.hcService;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcServiceStatePK getId() {
		return this.id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public void setHcService(HcService hcService) {
		this.hcService = hcService;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setId(HcServiceStatePK id) {
		this.id = id;
	}

}