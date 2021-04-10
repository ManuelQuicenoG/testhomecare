package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;


/**
 * The persistent class for the hc_service_trans_r_states database table.
 * 
 */
@Entity
@Table(name="hc_service_trans_r_states")
@NamedQuery(name="HcServiceTransRState.findAll", query="SELECT h FROM HcServiceTransRState h")
public class HcServiceTransRState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceTransRStatePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="hc_schedule")
	private LocalDate hcSchedule;

	//bi-directional many-to-one association to HcServiceRequestTran
	@ManyToOne
	@JoinColumn(name="hc_service_request_trans_hc_serv_r_trans_id")
	private HcServiceRequestTran hcServiceRequestTran;

	//bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id")
	private HcState hcState;

	public HcServiceTransRState() {
	}

	public HcServiceTransRStatePK getId() {
		return this.id;
	}

	public void setId(HcServiceTransRStatePK id) {
		this.id = id;
	}

	public LocalDate getHcSchedule() {
		return this.hcSchedule;
	}

	public void setHcSchedule(LocalDate hcSchedule) {
		this.hcSchedule = hcSchedule;
	}

	public HcServiceRequestTran getHcServiceRequestTran() {
		return this.hcServiceRequestTran;
	}

	public void setHcServiceRequestTran(HcServiceRequestTran hcServiceRequestTran) {
		this.hcServiceRequestTran = hcServiceRequestTran;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

}