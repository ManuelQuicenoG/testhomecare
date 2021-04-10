package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_service_requests database table.
 *
 */
@Entity
@Table(name = "hc_service_requests")
@NamedQuery(name = "HcServiceRequest.findAll", query = "SELECT h FROM HcServiceRequest h")
public class HcServiceRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_SERVICE_REQUESTS_SERVICERID_GENERATOR", sequenceName = "HC_SERVICE_REQUESTS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_SERVICE_REQUESTS_SERVICERID_GENERATOR")
	@Column(name = "service_r_id")
	private Integer serviceRId;

	@Column(name = "beginning_time")
	private Time beginningTime;

	private double duration;

	@Column(name = "request_date")
	private LocalDate requestLocalDate;

	@Column(name = "service_value")
	private double serviceValue;

	// bi-directional many-to-one association to HcServiceRState
	@OneToMany(mappedBy = "hcServiceRequest", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceRState> hcServiceRStates;

	// bi-directional many-to-one association to HcProperty
	@ManyToOne
	@JoinColumn(name = "hc_properties_property_id")
	private HcProperty hcProperty;

	// bi-directional many-to-one association to HcService
	@OneToMany(mappedBy = "hcServiceRequest", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcService> hcServices;

	public HcServiceRequest() {
	}

	public HcService addHcService(HcService hcService) {
		getHcServices().add(hcService);
		hcService.setHcServiceRequest(this);

		return hcService;
	}

	public HcServiceRState addHcServiceRState(HcServiceRState hcServiceRState) {
		getHcServiceRStates().add(hcServiceRState);
		hcServiceRState.setHcServiceRequest(this);

		return hcServiceRState;
	}

	public Time getBeginningTime() {
		return this.beginningTime;
	}

	public double getDuration() {
		return this.duration;
	}

	public HcProperty getHcProperty() {
		return this.hcProperty;
	}

	public Set<HcServiceRState> getHcServiceRStates() {
		return this.hcServiceRStates;
	}

	public Set<HcService> getHcServices() {
		return this.hcServices;
	}

	public LocalDate getRequestLocalDate() {
		return this.requestLocalDate;
	}

	public Integer getServiceRId() {
		return this.serviceRId;
	}

	public double getServiceValue() {
		return this.serviceValue;
	}

	public HcService removeHcService(HcService hcService) {
		getHcServices().remove(hcService);
		hcService.setHcServiceRequest(null);

		return hcService;
	}

	public HcServiceRState removeHcServiceRState(HcServiceRState hcServiceRState) {
		getHcServiceRStates().remove(hcServiceRState);
		hcServiceRState.setHcServiceRequest(null);

		return hcServiceRState;
	}

	public void setBeginningTime(Time beginningTime) {
		this.beginningTime = beginningTime;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public void setHcProperty(HcProperty hcProperty) {
		this.hcProperty = hcProperty;
	}

	public void setHcServiceRStates(Set<HcServiceRState> hcServiceRStates) {
		this.hcServiceRStates = hcServiceRStates;
	}

	public void setHcServices(Set<HcService> hcServices) {
		this.hcServices = hcServices;
	}

	public void setRequestLocalDate(LocalDate requestLocalDate) {
		this.requestLocalDate = requestLocalDate;
	}

	public void setServiceRId(Integer serviceRId) {
		this.serviceRId = serviceRId;
	}

	public void setServiceValue(double serviceValue) {
		this.serviceValue = serviceValue;
	}

}