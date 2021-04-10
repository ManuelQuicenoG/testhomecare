package modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	@SequenceGenerator(name = "HC_SERVICE_REQUEST_TRANS_HCSERVRTRANSID_GENERATOR", sequenceName = "HC_SERVICE_REQUEST_TRANS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_SERVICE_REQUEST_TRANS_HCSERVRTRANSID_GENERATOR")
	@Column(name = "hc_serv_r_trans_id")
	private Integer hcServRTransId;

	@Column(name = "hc_description")
	private String hcDescription;

	@Column(name = "hc_destination_place")
	private String hcDestinationPlace;

	@Column(name = "hc_origin_place")
	private String hcOriginPlace;

	@Column(name = "hc_schedule")
	private Timestamp hcSchedule;

	@Column(name = "hc_transport_type")
	private String hcTransportType;

	@Column(name = "hc_vehicle_type")
	private String hcVehicleType;

	// bi-directional many-to-one association to HcServiceTransRState
	@OneToMany(mappedBy = "hcServiceRequestTran", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceTransRState> hcServiceTransRStates;

	// bi-directional many-to-one association to HcTransportService
	@OneToMany(mappedBy = "hcServiceRequestTran", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
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

	public Timestamp getHcSchedule() {
		return this.hcSchedule;
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

	public void setHcSchedule(Timestamp hcSchedule) {
		this.hcSchedule = hcSchedule;
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

	public void setHcVehicleType(String hcVehicleType) {
		this.hcVehicleType = hcVehicleType;
	}

}