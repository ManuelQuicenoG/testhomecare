package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the hc_service_request_trans database table.
 * 
 */
@Entity
@Table(name="hc_service_request_trans")
@NamedQuery(name="HcServiceRequestTran.findAll", query="SELECT h FROM HcServiceRequestTran h")
public class HcServiceRequestTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_SERVICE_REQUEST_TRANS_HCSERVRTRANSID_GENERATOR", sequenceName="HC_SERVICE_REQUEST_TRANS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_SERVICE_REQUEST_TRANS_HCSERVRTRANSID_GENERATOR")
	@Column(name="hc_serv_r_trans_id")
	private Integer hcServRTransId;

	@Column(name="hc_description")
	private String hcDescription;

	@Column(name="hc_destination_place")
	private String hcDestinationPlace;

	@Column(name="hc_origin_place")
	private String hcOriginPlace;

	@Column(name="hc_schedule")
	private Timestamp hcSchedule;

	@Column(name="hc_transport_type")
	private String hcTransportType;

	@Column(name="hc_vehicle_type")
	private String hcVehicleType;

	//bi-directional many-to-one association to HcServiceTransRState
	@OneToMany(mappedBy="hcServiceRequestTran", fetch=FetchType.EAGER)
	private Set<HcServiceTransRState> hcServiceTransRStates;

	//bi-directional many-to-one association to HcTransportService
	@OneToMany(mappedBy="hcServiceRequestTran", fetch=FetchType.EAGER)
	private Set<HcTransportService> hcTransportServices;

	public HcServiceRequestTran() {
	}

	public Integer getHcServRTransId() {
		return this.hcServRTransId;
	}

	public void setHcServRTransId(Integer hcServRTransId) {
		this.hcServRTransId = hcServRTransId;
	}

	public String getHcDescription() {
		return this.hcDescription;
	}

	public void setHcDescription(String hcDescription) {
		this.hcDescription = hcDescription;
	}

	public String getHcDestinationPlace() {
		return this.hcDestinationPlace;
	}

	public void setHcDestinationPlace(String hcDestinationPlace) {
		this.hcDestinationPlace = hcDestinationPlace;
	}

	public String getHcOriginPlace() {
		return this.hcOriginPlace;
	}

	public void setHcOriginPlace(String hcOriginPlace) {
		this.hcOriginPlace = hcOriginPlace;
	}

	public Timestamp getHcSchedule() {
		return this.hcSchedule;
	}

	public void setHcSchedule(Timestamp hcSchedule) {
		this.hcSchedule = hcSchedule;
	}

	public String getHcTransportType() {
		return this.hcTransportType;
	}

	public void setHcTransportType(String hcTransportType) {
		this.hcTransportType = hcTransportType;
	}

	public String getHcVehicleType() {
		return this.hcVehicleType;
	}

	public void setHcVehicleType(String hcVehicleType) {
		this.hcVehicleType = hcVehicleType;
	}

	public Set<HcServiceTransRState> getHcServiceTransRStates() {
		return this.hcServiceTransRStates;
	}

	public void setHcServiceTransRStates(Set<HcServiceTransRState> hcServiceTransRStates) {
		this.hcServiceTransRStates = hcServiceTransRStates;
	}

	public HcServiceTransRState addHcServiceTransRState(HcServiceTransRState hcServiceTransRState) {
		getHcServiceTransRStates().add(hcServiceTransRState);
		hcServiceTransRState.setHcServiceRequestTran(this);

		return hcServiceTransRState;
	}

	public HcServiceTransRState removeHcServiceTransRState(HcServiceTransRState hcServiceTransRState) {
		getHcServiceTransRStates().remove(hcServiceTransRState);
		hcServiceTransRState.setHcServiceRequestTran(null);

		return hcServiceTransRState;
	}

	public Set<HcTransportService> getHcTransportServices() {
		return this.hcTransportServices;
	}

	public void setHcTransportServices(Set<HcTransportService> hcTransportServices) {
		this.hcTransportServices = hcTransportServices;
	}

	public HcTransportService addHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().add(hcTransportService);
		hcTransportService.setHcServiceRequestTran(this);

		return hcTransportService;
	}

	public HcTransportService removeHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().remove(hcTransportService);
		hcTransportService.setHcServiceRequestTran(null);

		return hcTransportService;
	}

}