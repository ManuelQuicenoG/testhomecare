package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the hc_service_trans_states database table.
 * 
 */
@Entity
@Table(name="hc_service_trans_states")
@NamedQuery(name="HcServiceTransState.findAll", query="SELECT h FROM HcServiceTransState h")
public class HcServiceTransState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceTransStatePK id;

	@Column(name="hc_schedule")
	private Timestamp hcSchedule;

	//bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id")
	private HcState hcState;

	//bi-directional many-to-one association to HcTransportService
	@ManyToOne
	@JoinColumn(name="hc_transport_services_hc_serv_trasnport_id")
	private HcTransportService hcTransportService;

	public HcServiceTransState() {
	}

	public HcServiceTransStatePK getId() {
		return this.id;
	}

	public void setId(HcServiceTransStatePK id) {
		this.id = id;
	}

	public Timestamp getHcSchedule() {
		return this.hcSchedule;
	}

	public void setHcSchedule(Timestamp hcSchedule) {
		this.hcSchedule = hcSchedule;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public HcTransportService getHcTransportService() {
		return this.hcTransportService;
	}

	public void setHcTransportService(HcTransportService hcTransportService) {
		this.hcTransportService = hcTransportService;
	}

}