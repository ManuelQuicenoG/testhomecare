package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the hc_service_trans_states database table.
 *
 */
@Entity
@Table(name = "hc_service_trans_states")
@NamedQuery(name = "HcServiceTransState.findAll", query = "SELECT h FROM HcServiceTransState h")
public class HcServiceTransState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceTransStatePK id;

	@Column(name = "hc_service_trans_date")
	private LocalDate hcServiceTransDate;

	@Column(name = "hc_service_trans_hour")
	private Time hcServiceTransHour;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name = "hc_states_state_id")
	private HcState hcState;

	// bi-directional many-to-one association to HcTransportService
	@ManyToOne
	@JoinColumn(name = "hc_transport_services_hc_serv_transport_id")
	private HcTransportService hcTransportService;

	public HcServiceTransState() {
	}

	public LocalDate getHcServiceTransDate() {
		return this.hcServiceTransDate;
	}

	public Time getHcServiceTransHour() {
		return this.hcServiceTransHour;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcTransportService getHcTransportService() {
		return this.hcTransportService;
	}

	public HcServiceTransStatePK getId() {
		return this.id;
	}

	public void setHcServiceTransDate(LocalDate hcServiceTransDate) {
		this.hcServiceTransDate = hcServiceTransDate;
	}

	public void setHcServiceTransHour(Time hcServiceTransHour) {
		this.hcServiceTransHour = hcServiceTransHour;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setHcTransportService(HcTransportService hcTransportService) {
		this.hcTransportService = hcTransportService;
	}

	public void setId(HcServiceTransStatePK id) {
		this.id = id;
	}

}