package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.LocalDate;
import java.util.Set;


/**
 * The persistent class for the hc_service_requests database table.
 * 
 */
@Entity
@Table(name="hc_service_requests")
@NamedQuery(name="HcServiceRequest.findAll", query="SELECT h FROM HcServiceRequest h")
public class HcServiceRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_SERVICE_REQUESTS_SERVICERID_GENERATOR", sequenceName="HC_SERVICE_REQUESTS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_SERVICE_REQUESTS_SERVICERID_GENERATOR")
	@Column(name="service_r_id")
	private Integer serviceRId;

	@Column(name="beginning_time")
	private Time beginningTime;

	private double duration;

	@Temporal(TemporalType.DATE)
	@Column(name="request_date")
	private LocalDate requestLocalDate;

	@Column(name="service_value")
	private double serviceValue;

	//bi-directional many-to-one association to HcServiceRState
	@OneToMany(mappedBy="hcServiceRequest", fetch=FetchType.EAGER)
	private Set<HcServiceRState> hcServiceRStates;

	//bi-directional many-to-one association to HcProperty
	@ManyToOne
	@JoinColumn(name="hc_properties_property_id")
	private HcProperty hcProperty;

	//bi-directional many-to-one association to HcService
	@OneToMany(mappedBy="hcServiceRequest", fetch=FetchType.EAGER)
	private Set<HcService> hcServices;

	public HcServiceRequest() {
	}

	public Integer getServiceRId() {
		return this.serviceRId;
	}

	public void setServiceRId(Integer serviceRId) {
		this.serviceRId = serviceRId;
	}

	public Time getBeginningTime() {
		return this.beginningTime;
	}

	public void setBeginningTime(Time beginningTime) {
		this.beginningTime = beginningTime;
	}

	public double getDuration() {
		return this.duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public LocalDate getRequestLocalDate() {
		return this.requestLocalDate;
	}

	public void setRequestLocalDate(LocalDate requestLocalDate) {
		this.requestLocalDate = requestLocalDate;
	}

	public double getServiceValue() {
		return this.serviceValue;
	}

	public void setServiceValue(double serviceValue) {
		this.serviceValue = serviceValue;
	}

	public Set<HcServiceRState> getHcServiceRStates() {
		return this.hcServiceRStates;
	}

	public void setHcServiceRStates(Set<HcServiceRState> hcServiceRStates) {
		this.hcServiceRStates = hcServiceRStates;
	}

	public HcServiceRState addHcServiceRState(HcServiceRState hcServiceRState) {
		getHcServiceRStates().add(hcServiceRState);
		hcServiceRState.setHcServiceRequest(this);

		return hcServiceRState;
	}

	public HcServiceRState removeHcServiceRState(HcServiceRState hcServiceRState) {
		getHcServiceRStates().remove(hcServiceRState);
		hcServiceRState.setHcServiceRequest(null);

		return hcServiceRState;
	}

	public HcProperty getHcProperty() {
		return this.hcProperty;
	}

	public void setHcProperty(HcProperty hcProperty) {
		this.hcProperty = hcProperty;
	}

	public Set<HcService> getHcServices() {
		return this.hcServices;
	}

	public void setHcServices(Set<HcService> hcServices) {
		this.hcServices = hcServices;
	}

	public HcService addHcService(HcService hcService) {
		getHcServices().add(hcService);
		hcService.setHcServiceRequest(this);

		return hcService;
	}

	public HcService removeHcService(HcService hcService) {
		getHcServices().remove(hcService);
		hcService.setHcServiceRequest(null);

		return hcService;
	}

}