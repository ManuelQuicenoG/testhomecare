package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the hc_neighborhoods database table.
 *
 */
@Entity
@Table(name = "hc_neighborhoods")
@NamedQuery(name = "HcNeighborhood.findAll", query = "SELECT h FROM HcNeighborhood h")
public class HcNeighborhood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "neighbor_id")
	private Integer neighborId;

	@Column(name = "is_able")
	private Boolean isAble;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	// bi-directional many-to-one association to HcCity
	@ManyToOne
	@JoinColumn(name = "hc_cities_city_id")
	private HcCity hcCity;

	// bi-directional many-to-one association to HcProperty
	@OneToMany(mappedBy = "hcNeighborhood", fetch = FetchType.EAGER)
	private Set<HcProperty> hcProperties;

	// bi-directional many-to-one association to HcUser
	@OneToMany(mappedBy = "hcNeighborhood", fetch = FetchType.EAGER)
	private Set<HcUser> hcUsers;

	public HcNeighborhood() {
	}

	public HcProperty addHcProperty(HcProperty hcProperty) {
		getHcProperties().add(hcProperty);
		hcProperty.setHcNeighborhood(this);

		return hcProperty;
	}

	public HcUser addHcUser(HcUser hcUser) {
		getHcUsers().add(hcUser);
		hcUser.setHcNeighborhood(this);

		return hcUser;
	}

	public HcCity getHcCity() {
		return this.hcCity;
	}

	public Set<HcProperty> getHcProperties() {
		return this.hcProperties;
	}

	public Set<HcUser> getHcUsers() {
		return this.hcUsers;
	}

	public Boolean getIsAble() {
		return this.isAble;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public String getName() {
		return this.name;
	}

	public Integer getNeighborId() {
		return this.neighborId;
	}

	public HcProperty removeHcProperty(HcProperty hcProperty) {
		getHcProperties().remove(hcProperty);
		hcProperty.setHcNeighborhood(null);

		return hcProperty;
	}

	public HcUser removeHcUser(HcUser hcUser) {
		getHcUsers().remove(hcUser);
		hcUser.setHcNeighborhood(null);

		return hcUser;
	}

	public void setHcCity(HcCity hcCity) {
		this.hcCity = hcCity;
	}

	public void setHcProperties(Set<HcProperty> hcProperties) {
		this.hcProperties = hcProperties;
	}

	public void setHcUsers(Set<HcUser> hcUsers) {
		this.hcUsers = hcUsers;
	}

	public void setIsAble(Boolean isAble) {
		this.isAble = isAble;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNeighborId(Integer neighborId) {
		this.neighborId = neighborId;
	}

}