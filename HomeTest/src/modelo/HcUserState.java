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
 * The persistent class for the hc_user_states database table.
 *
 */
@Entity
@Table(name = "hc_user_states")
@NamedQuery(name = "HcUserState.findAll", query = "SELECT h FROM HcUserState h")
public class HcUserState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcUserStatePK id;

	@Column(name="date_end")
	private LocalDate dateEnd;

	@Column(name="date_start")
	private LocalDate dateStart;

	// bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id", insertable = false, updatable = false)
	private HcState hcState;

	// bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name="hc_users_user_id", insertable = false, updatable = false)
	private HcUser hcUser;

	public HcUserState() {
	}

	public HcState getHcState() {
		return this.hcState;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public HcUserStatePK getId() {
		return this.id;
	}

	public LocalDate getLocalDateEnd() {
		return this.dateEnd;
	}

	public LocalDate getLocalDateStart() {
		return this.dateStart;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setId(HcUserStatePK id) {
		this.id = id;
	}

	public void setLocalDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setLocalDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

}