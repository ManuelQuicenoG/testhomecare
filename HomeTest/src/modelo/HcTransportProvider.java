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
 * The persistent class for the hc_transport_providers database table.
 *
 */
@Entity
@Table(name = "hc_transport_providers")
@NamedQuery(name = "HcTransportProvider.findAll", query = "SELECT h FROM HcTransportProvider h")
public class HcTransportProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_TRANSPORT_PROVIDERS_HCPROVAIDERID_GENERATOR", sequenceName = "HC_TRASNPORT_PROVIDERS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_TRANSPORT_PROVIDERS_HCPROVAIDERID_GENERATOR")
	@Column(name = "hc_provaider_id")
	private Integer hcProvaiderId;

	private String story;

	private Boolean tourism;

	// bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name = "hc_users_user_id")
	private HcUser hcUser;

	// bi-directional many-to-one association to HcVehicle
	@ManyToOne
	@JoinColumn(name = "hc_vehicles_hc_vehicle_id")
	private HcVehicle hcVehicle;

	// bi-directional many-to-one association to HcTransportService
	@OneToMany(mappedBy = "hcTransportProvider", fetch = FetchType.EAGER)
	private Set<HcTransportService> hcTransportServices;

	public HcTransportProvider() {
	}

	public HcTransportService addHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().add(hcTransportService);
		hcTransportService.setHcTransportProvider(this);

		return hcTransportService;
	}

	public Integer getHcProvaiderId() {
		return this.hcProvaiderId;
	}

	public Set<HcTransportService> getHcTransportServices() {
		return this.hcTransportServices;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public HcVehicle getHcVehicle() {
		return this.hcVehicle;
	}

	public String getStory() {
		return this.story;
	}

	public Boolean getTourism() {
		return this.tourism;
	}

	public HcTransportService removeHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().remove(hcTransportService);
		hcTransportService.setHcTransportProvider(null);

		return hcTransportService;
	}

	public void setHcProvaiderId(Integer hcProvaiderId) {
		this.hcProvaiderId = hcProvaiderId;
	}

	public void setHcTransportServices(Set<HcTransportService> hcTransportServices) {
		this.hcTransportServices = hcTransportServices;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setHcVehicle(HcVehicle hcVehicle) {
		this.hcVehicle = hcVehicle;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public void setTourism(Boolean tourism) {
		this.tourism = tourism;
	}

}