package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_services database table.
 * 
 */
@Entity
@Table(name="hc_services")
@NamedQuery(name="HcService.findAll", query="SELECT h FROM HcService h")
public class HcService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_SERVICES_SERVID_GENERATOR", sequenceName="HC_SERVICES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_SERVICES_SERVID_GENERATOR")
	@Column(name="serv_id")
	private Integer servId;

	//bi-directional many-to-one association to HcServicePoll
	@OneToMany(mappedBy="hcService", fetch=FetchType.EAGER)
	private Set<HcServicePoll> hcServicePolls;

	//bi-directional many-to-one association to HcServiceState
	@OneToMany(mappedBy="hcService", fetch=FetchType.EAGER)
	private Set<HcServiceState> hcServiceStates;

	//bi-directional many-to-one association to HcEmployee
	@ManyToOne
	@JoinColumn(name="hc_employees_user_id")
	private HcEmployee hcEmployee;

	//bi-directional many-to-one association to HcServiceRequest
	@ManyToOne
	@JoinColumn(name="hc_service_requests_service_r_id")
	private HcServiceRequest hcServiceRequest;

	public HcService() {
	}

	public Integer getServId() {
		return this.servId;
	}

	public void setServId(Integer servId) {
		this.servId = servId;
	}

	public Set<HcServicePoll> getHcServicePolls() {
		return this.hcServicePolls;
	}

	public void setHcServicePolls(Set<HcServicePoll> hcServicePolls) {
		this.hcServicePolls = hcServicePolls;
	}

	public HcServicePoll addHcServicePoll(HcServicePoll hcServicePoll) {
		getHcServicePolls().add(hcServicePoll);
		hcServicePoll.setHcService(this);

		return hcServicePoll;
	}

	public HcServicePoll removeHcServicePoll(HcServicePoll hcServicePoll) {
		getHcServicePolls().remove(hcServicePoll);
		hcServicePoll.setHcService(null);

		return hcServicePoll;
	}

	public Set<HcServiceState> getHcServiceStates() {
		return this.hcServiceStates;
	}

	public void setHcServiceStates(Set<HcServiceState> hcServiceStates) {
		this.hcServiceStates = hcServiceStates;
	}

	public HcServiceState addHcServiceState(HcServiceState hcServiceState) {
		getHcServiceStates().add(hcServiceState);
		hcServiceState.setHcService(this);

		return hcServiceState;
	}

	public HcServiceState removeHcServiceState(HcServiceState hcServiceState) {
		getHcServiceStates().remove(hcServiceState);
		hcServiceState.setHcService(null);

		return hcServiceState;
	}

	public HcEmployee getHcEmployee() {
		return this.hcEmployee;
	}

	public void setHcEmployee(HcEmployee hcEmployee) {
		this.hcEmployee = hcEmployee;
	}

	public HcServiceRequest getHcServiceRequest() {
		return this.hcServiceRequest;
	}

	public void setHcServiceRequest(HcServiceRequest hcServiceRequest) {
		this.hcServiceRequest = hcServiceRequest;
	}

}