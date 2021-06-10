package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
 * The persistent class for the hc_service_request_trans database table.
 *
 */
@Entity
@Table(name = "hc_service_request_trans")
@NamedQuery(name = "HcServiceRequestTran.findAll", query = "SELECT h FROM HcServiceRequestTran h")
public class HcServiceRequestTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_SERVICE_REQUEST_TRANS_HCSERVRTRANSID_GENERATOR", sequenceName = "HC_SERVICE_REQUESTS_TRANS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_SERVICE_REQUEST_TRANS_HCSERVRTRANSID_GENERATOR")
	@Column(name = "hc_serv_r_trans_id")
	private Integer hcServRTransId;

	@Column(name = "hc_description")
	private String hcDescription;

	@Column(name = "hc_destination_place")
	private String hcDestinationPlace;

	@Column(name = "hc_origin_place")
	private String hcOriginPlace;

	@Column(name = "hc_service_date_final")
	private LocalDate hcServiceDateFinal;

	@Column(name = "hc_service_hour_final")
	private LocalTime hcServiceHourFinal;

	@Column(name = "hc_service_trans_date")
	private LocalDate hcServiceTransDate;

	@Column(name = "hc_service_trans_hour")
	private LocalTime hcServiceTransHour;

	@Column(name = "hc_transport_type")
	private String hcTransportType;

	@Column(name = "hc_vehicle_type")
	private String hcVehicleType;

	// bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name = "hc_users_user_id")
	private HcUser hcUser;

	// bi-directional many-to-one association to HcServiceTransRState
	@OneToMany(mappedBy = "hcServiceRequestTran", fetch = FetchType.EAGER)
	private Set<HcServiceTransRState> hcServiceTransRStates;

	// bi-directional many-to-one association to HcTransportService
	@OneToMany(mappedBy = "hcServiceRequestTran", fetch = FetchType.EAGER)
	private Set<HcTransportService> hcTransportServices;

	public HcServiceRequestTran() {
	}

	public HcServiceTransRState addHcServiceTransRState(HcServiceTransRState hcServiceTransRState) {
		getHcServiceTransRStates().add(hcServiceTransRState);
		hcServiceTransRState.setHcServiceRequestTran(this);

		return hcServiceTransRState;
	}

	public HcTransportService addHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().add(hcTransportService);
		hcTransportService.setHcServiceRequestTran(this);

		return hcTransportService;
	}

	public String getHcDescription() {
		return this.hcDescription;
	}

	public String getHcDestinationPlace() {
		return this.hcDestinationPlace;
	}

	public String getHcOriginPlace() {
		return this.hcOriginPlace;
	}

	public LocalDate getHcServiceDateFinal() {
		return this.hcServiceDateFinal;
	}

	public LocalTime getHcServiceHourFinal() {
		return this.hcServiceHourFinal;
	}

	public LocalDate getHcServiceTransDate() {
		return this.hcServiceTransDate;
	}

	public LocalTime getHcServiceTransHour() {
		return this.hcServiceTransHour;
	}

	public Set<HcServiceTransRState> getHcServiceTransRStates() {
		return this.hcServiceTransRStates;
	}

	public Integer getHcServRTransId() {
		return this.hcServRTransId;
	}

	public Set<HcTransportService> getHcTransportServices() {
		return this.hcTransportServices;
	}

	public String getHcTransportType() {
		return this.hcTransportType;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public String getHcVehicleType() {
		return this.hcVehicleType;
	}

	public HcServiceTransRState removeHcServiceTransRState(HcServiceTransRState hcServiceTransRState) {
		getHcServiceTransRStates().remove(hcServiceTransRState);
		hcServiceTransRState.setHcServiceRequestTran(null);

		return hcServiceTransRState;
	}

	public HcTransportService removeHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().remove(hcTransportService);
		hcTransportService.setHcServiceRequestTran(null);

		return hcTransportService;
	}

	public void setHcDescription(String hcDescription) {
		this.hcDescription = hcDescription;
	}

	public void setHcDestinationPlace(String hcDestinationPlace) {
		this.hcDestinationPlace = hcDestinationPlace;
	}

	public void setHcOriginPlace(String hcOriginPlace) {
		this.hcOriginPlace = hcOriginPlace;
	}

	public void setHcServiceDateFinal(LocalDate hcServiceDateFinal) {
		this.hcServiceDateFinal = hcServiceDateFinal;
	}

	public void setHcServiceHourFinal(LocalTime hcServiceHourFinal) {
		this.hcServiceHourFinal = hcServiceHourFinal;
	}

	public void setHcServiceTransDate(LocalDate hcServiceTransDate) {
		this.hcServiceTransDate = hcServiceTransDate;
	}

	public void setHcServiceTransHour(LocalTime hcServiceTransHour) {
		this.hcServiceTransHour = hcServiceTransHour;
	}

	public void setHcServiceTransRStates(Set<HcServiceTransRState> hcServiceTransRStates) {
		this.hcServiceTransRStates = hcServiceTransRStates;
	}

	public void setHcServRTransId(Integer hcServRTransId) {
		this.hcServRTransId = hcServRTransId;
	}

	public void setHcTransportServices(Set<HcTransportService> hcTransportServices) {
		this.hcTransportServices = hcTransportServices;
	}

	public void setHcTransportType(String hcTransportType) {
		this.hcTransportType = hcTransportType;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setHcVehicleType(String hcVehicleType) {
		this.hcVehicleType = hcVehicleType;
	}

}