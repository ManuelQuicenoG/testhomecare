package modelo;

import java.io.Serializable;
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

/**
 * The persistent class for the hc_vehicles database table.
 *
 */
@Entity
@Table(name = "hc_vehicles")
@NamedQuery(name = "HcVehicle.findAll", query = "SELECT h FROM HcVehicle h")
public class HcVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_VEHICLES_HCVEHICLEID_GENERATOR", sequenceName = "HC_VEHICLES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_VEHICLES_HCVEHICLEID_GENERATOR")
	@Column(name = "hc_vehicle_id")
	private Integer hcVehicleId;

	@Column(name = "vh_conductor")
	private String vhConductor;

	@Column(name = "vh_make")
	private String vhMake;

	@Column(name = "vh_mode")
	private String vhMode;

	@Column(name = "vh_plate")
	private String vhPlate;

	@Column(name = "vh_transport_type")
	private String vhTransportType;

	@Column(name = "vh_type")
	private String vhType;

	// bi-directional many-to-one association to HcTransportProvider
	@OneToMany(mappedBy = "hcVehicle", fetch = FetchType.EAGER)
	private Set<HcTransportProvider> hcTransportProviders;

	public HcVehicle() {
	}

	public HcTransportProvider addHcTransportProvider(HcTransportProvider hcTransportProvider) {
		getHcTransportProviders().add(hcTransportProvider);
		hcTransportProvider.setHcVehicle(this);

		return hcTransportProvider;
	}

	public Set<HcTransportProvider> getHcTransportProviders() {
		return this.hcTransportProviders;
	}

	public Integer getHcVehicleId() {
		return this.hcVehicleId;
	}

	public String getVhConductor() {
		return this.vhConductor;
	}

	public String getVhMake() {
		return this.vhMake;
	}

	public String getVhMode() {
		return this.vhMode;
	}

	public String getVhPlate() {
		return this.vhPlate;
	}

	public String getVhTransportType() {
		return this.vhTransportType;
	}

	public String getVhType() {
		return this.vhType;
	}

	public HcTransportProvider removeHcTransportProvider(HcTransportProvider hcTransportProvider) {
		getHcTransportProviders().remove(hcTransportProvider);
		hcTransportProvider.setHcVehicle(null);

		return hcTransportProvider;
	}

	public void setHcTransportProviders(Set<HcTransportProvider> hcTransportProviders) {
		this.hcTransportProviders = hcTransportProviders;
	}

	public void setHcVehicleId(Integer hcVehicleId) {
		this.hcVehicleId = hcVehicleId;
	}

	public void setVhConductor(String vhConductor) {
		this.vhConductor = vhConductor;
	}

	public void setVhMake(String vhMake) {
		this.vhMake = vhMake;
	}

	public void setVhMode(String vhMode) {
		this.vhMode = vhMode;
	}

	public void setVhPlate(String vhPlate) {
		this.vhPlate = vhPlate;
	}

	public void setVhTransportType(String vhTransportType) {
		this.vhTransportType = vhTransportType;
	}

	public void setVhType(String vhType) {
		this.vhType = vhType;
	}

}