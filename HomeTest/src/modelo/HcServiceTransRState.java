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

	@Column(name = "hc_service_trans_date")
	private LocalDate hcServiceTransDate;

	@Column(name = "hc_service_trans_hour")
	private Time hcServiceTransHour;

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

	public HcServiceRequestTran getHcServiceRequestTran() {
		return this.hcServiceRequestTran;
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

	public HcServiceTransRStatePK getId() {
		return this.id;
	}

	public void setHcServiceRequestTran(HcServiceRequestTran hcServiceRequestTran) {
		this.hcServiceRequestTran = hcServiceRequestTran;
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

	public void setId(HcServiceTransRStatePK id) {
		this.id = id;
	}

}