package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_transport_providers database table.
 *
 */
@Entity
@Table(name = "hc_transport_providers")
@NamedQuery(name = "HcTransportProvider.findAll", query = "SELECT h FROM HcTransportProvider h")
public class HcTransportProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcTransportProviderPK id;

	private String story;

	private Boolean tourism;

	// bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name="hc_users_user_id", insertable = false, updatable = false)
	private HcUser hcUser;

	// bi-directional many-to-one association to HcTransportService
	@OneToMany(mappedBy = "hcTransportProvider", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcTransportService> hcTransportServices;

	// bi-directional many-to-one association to HcVehicle
	@OneToMany(mappedBy = "hcTransportProvider", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcVehicle> hcVehicles;

	public HcTransportProvider() {
	}

	public HcTransportService addHcTransportService(HcTransportService hcTransportService) {
		getHcTransportServices().add(hcTransportService);
		hcTransportService.setHcTransportProvider(this);

		return hcTransportService;
	}

	public HcVehicle addHcVehicle(HcVehicle hcVehicle) {
		getHcVehicles().add(hcVehicle);
		hcVehicle.setHcTransportProvider(this);

		return hcVehicle;
	}

	public Set<HcTransportService> getHcTransportServices() {
		return this.hcTransportServices;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public Set<HcVehicle> getHcVehicles() {
		return this.hcVehicles;
	}

	public HcTransportProviderPK getId() {
		return this.id;
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

	public HcVehicle removeHcVehicle(HcVehicle hcVehicle) {
		getHcVehicles().remove(hcVehicle);
		hcVehicle.setHcTransportProvider(null);

		return hcVehicle;
	}

	public void setHcTransportServices(Set<HcTransportService> hcTransportServices) {
		this.hcTransportServices = hcTransportServices;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setHcVehicles(Set<HcVehicle> hcVehicles) {
		this.hcVehicles = hcVehicles;
	}

	public void setId(HcTransportProviderPK id) {
		this.id = id;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public void setTourism(Boolean tourism) {
		this.tourism = tourism;
	}

}