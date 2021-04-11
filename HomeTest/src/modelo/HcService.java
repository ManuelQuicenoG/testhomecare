package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the hc_services database table.
 *
 */
@Entity
@Table(name = "hc_services")
@NamedQuery(name = "HcService.findAll", query = "SELECT h FROM HcService h")
public class HcService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_SERVICES_SERVID_GENERATOR", sequenceName = "HC_SERVICES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_SERVICES_SERVID_GENERATOR")
	@Column(name = "serv_id")
	private Integer servId;

	// bi-directional many-to-one association to HcServicePoll
	@OneToMany(mappedBy = "hcService", fetch = FetchType.EAGER)
	private Set<HcServicePoll> hcServicePolls;

	// bi-directional many-to-one association to HcServiceState
	@OneToMany(mappedBy = "hcService", fetch = FetchType.EAGER)
	private Set<HcServiceState> hcServiceStates;

	// bi-directional many-to-one association to HcEmployee
	@ManyToOne
	@JoinColumn(name = "hc_employees_user_id")
	private HcEmployee hcEmployee;

	// bi-directional many-to-one association to HcServiceRequest
	@ManyToOne
	@JoinColumn(name = "hc_service_requests_service_r_id")
	private HcServiceRequest hcServiceRequest;

	public HcService() {
	}

	public HcServicePoll addHcServicePoll(HcServicePoll hcServicePoll) {
		getHcServicePolls().add(hcServicePoll);
		hcServicePoll.setHcService(this);

		return hcServicePoll;
	}

	public HcServiceState addHcServiceState(HcServiceState hcServiceState) {
		getHcServiceStates().add(hcServiceState);
		hcServiceState.setHcService(this);

		return hcServiceState;
	}

	public HcEmployee getHcEmployee() {
		return this.hcEmployee;
	}

	public Set<HcServicePoll> getHcServicePolls() {
		return this.hcServicePolls;
	}

	public HcServiceRequest getHcServiceRequest() {
		return this.hcServiceRequest;
	}

	public Set<HcServiceState> getHcServiceStates() {
		return this.hcServiceStates;
	}

	public Integer getServId() {
		return this.servId;
	}

	public HcServicePoll removeHcServicePoll(HcServicePoll hcServicePoll) {
		getHcServicePolls().remove(hcServicePoll);
		hcServicePoll.setHcService(null);

		return hcServicePoll;
	}

	public HcServiceState removeHcServiceState(HcServiceState hcServiceState) {
		getHcServiceStates().remove(hcServiceState);
		hcServiceState.setHcService(null);

		return hcServiceState;
	}

	public void setHcEmployee(HcEmployee hcEmployee) {
		this.hcEmployee = hcEmployee;
	}

	public void setHcServicePolls(Set<HcServicePoll> hcServicePolls) {
		this.hcServicePolls = hcServicePolls;
	}

	public void setHcServiceRequest(HcServiceRequest hcServiceRequest) {
		this.hcServiceRequest = hcServiceRequest;
	}

	public void setHcServiceStates(Set<HcServiceState> hcServiceStates) {
		this.hcServiceStates = hcServiceStates;
	}

	public void setServId(Integer servId) {
		this.servId = servId;
	}

}