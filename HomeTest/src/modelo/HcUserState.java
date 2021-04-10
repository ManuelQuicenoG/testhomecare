package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;


/**
 * The persistent class for the hc_user_states database table.
 * 
 */
@Entity
@Table(name="hc_user_states")
@NamedQuery(name="HcUserState.findAll", query="SELECT h FROM HcUserState h")
public class HcUserState implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcUserStatePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private LocalDate dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private LocalDate dateStart;

	//bi-directional many-to-one association to HcState
	@ManyToOne
	@JoinColumn(name="hc_states_state_id")
	private HcState hcState;

	//bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name="hc_users_user_id")
	private HcUser hcUser;

	public HcUserState() {
	}

	public HcUserStatePK getId() {
		return this.id;
	}

	public void setId(HcUserStatePK id) {
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

	public HcState getHcState() {
		return this.hcState;
	}

	public void setHcState(HcState hcState) {
		this.hcState = hcState;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

}