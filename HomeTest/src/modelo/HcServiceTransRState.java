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
 * The persistent class for the hc_service_trans_r_states database table.
 *
 */
@Entity
@Table(name = "hc_service_trans_r_states")
@NamedQuery(name = "HcServiceTransRState.findAll", query = "SELECT h FROM HcServiceTransRState h")
public class HcServiceTransRState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServiceTransRStatePK id;

	@Column(name = "hc_schedule")
	private LocalDate hcSchedule;

	// bi-directional many-to-one association to HcServiceRequestTran
	@ManyToOne
	@JoinColumn(name = "hc_service_request_trans_hc_serv_r_trans_id")
	private HcServiceRequestTran hcServiceRequestTran;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name = "hc_states_state_id")
	private HcState hcState;

	public HcServiceTransRState() {
	}

	public LocalDate getHcSchedule() {
		return this.hcSchedule;
	}

	public HcServiceRequestTran getHcServiceRequestTran() {
		return this.hcServiceRequestTran;
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcServiceTransRStatePK getId() {
		return this.id;
	}

	public void setHcSchedule(LocalDate hcSchedule) {
		this.hcSchedule = hcSchedule;
	}

	public void setHcServiceRequestTran(HcServiceRequestTran hcServiceRequestTran) {
		this.hcServiceRequestTran = hcServiceRequestTran;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setId(HcServiceTransRStatePK id) {
		this.id = id;
	}

}