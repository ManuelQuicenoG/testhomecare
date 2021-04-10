package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hc_vehicles database table.
 * 
 */
@Entity
@Table(name="hc_vehicles")
@NamedQuery(name="HcVehicle.findAll", query="SELECT h FROM HcVehicle h")
public class HcVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_VEHICLES_HCVEHICLEID_GENERATOR", sequenceName="HC_VEHICLES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_VEHICLES_HCVEHICLEID_GENERATOR")
	@Column(name="hc_vehicle_id")
	private Integer hcVehicleId;

	@Column(name="vh_conductor")
	private String vhConductor;

	@Column(name="vh_make")
	private String vhMake;

	@Column(name="vh_mode")
	private String vhMode;

	@Column(name="vh_plate")
	private String vhPlate;

	@Column(name="vh_transport_type")
	private String vhTransportType;

	@Column(name="vh_type")
	private String vhType;

	//bi-directional many-to-one association to HcTransportProvider
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="hc_transport_providers_hc_provaider_id", referencedColumnName="hc_provaider_id"),
		@JoinColumn(name="hc_transport_providers_hc_users_user_id", referencedColumnName="hc_users_user_id")
		})
	private HcTransportProvider hcTransportProvider;

	public HcVehicle() {
	}

	public Integer getHcVehicleId() {
		return this.hcVehicleId;
	}

	public void setHcVehicleId(Integer hcVehicleId) {
		this.hcVehicleId = hcVehicleId;
	}

	public String getVhConductor() {
		return this.vhConductor;
	}

	public void setVhConductor(String vhConductor) {
		this.vhConductor = vhConductor;
	}

	public String getVhMake() {
		return this.vhMake;
	}

	public void setVhMake(String vhMake) {
		this.vhMake = vhMake;
	}

	public String getVhMode() {
		return this.vhMode;
	}

	public void setVhMode(String vhMode) {
		this.vhMode = vhMode;
	}

	public String getVhPlate() {
		return this.vhPlate;
	}

	public void setVhPlate(String vhPlate) {
		this.vhPlate = vhPlate;
	}

	public String getVhTransportType() {
		return this.vhTransportType;
	}

	public void setVhTransportType(String vhTransportType) {
		this.vhTransportType = vhTransportType;
	}

	public String getVhType() {
		return this.vhType;
	}

	public void setVhType(String vhType) {
		this.vhType = vhType;
	}

	public HcTransportProvider getHcTransportProvider() {
		return this.hcTransportProvider;
	}

	public void setHcTransportProvider(HcTransportProvider hcTransportProvider) {
		this.hcTransportProvider = hcTransportProvider;
	}

}