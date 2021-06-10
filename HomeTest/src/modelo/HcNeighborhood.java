package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the hc_neighborhoods database table.
 * 
 */
@Entity
@Table(name="hc_neighborhoods")
@NamedQuery(name="HcNeighborhood.findAll", query="SELECT h FROM HcNeighborhood h")
public class HcNeighborhood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="neighbor_id")
	private Integer neighborId;

	@Column(name="is_able")
	private Boolean isAble;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	//bi-directional many-to-one association to HcCity
	@ManyToOne
	@JoinColumn(name="hc_cities_city_id")
	private HcCity hcCity;

	//bi-directional many-to-one association to HcProperty
	@OneToMany(mappedBy="hcNeighborhood", fetch=FetchType.EAGER)
	private Set<HcProperty> hcProperties;

	//bi-directional many-to-one association to HcUser
	@OneToMany(mappedBy="hcNeighborhood", fetch=FetchType.EAGER)
	private Set<HcUser> hcUsers;

	public HcNeighborhood() {
	}

	public Integer getNeighborId() {
		return this.neighborId;
	}

	public void setNeighborId(Integer neighborId) {
		this.neighborId = neighborId;
	}

	public Boolean getIsAble() {
		return this.isAble;
	}

	public void setIsAble(Boolean isAble) {
		this.isAble = isAble;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HcCity getHcCity() {
		return this.hcCity;
	}

	public void setHcCity(HcCity hcCity) {
		this.hcCity = hcCity;
	}

	public Set<HcProperty> getHcProperties() {
		return this.hcProperties;
	}

	public void setHcProperties(Set<HcProperty> hcProperties) {
		this.hcProperties = hcProperties;
	}

	public HcProperty addHcProperty(HcProperty hcProperty) {
		getHcProperties().add(hcProperty);
		hcProperty.setHcNeighborhood(this);

		return hcProperty;
	}

	public HcProperty removeHcProperty(HcProperty hcProperty) {
		getHcProperties().remove(hcProperty);
		hcProperty.setHcNeighborhood(null);

		return hcProperty;
	}

	public Set<HcUser> getHcUsers() {
		return this.hcUsers;
	}

	public void setHcUsers(Set<HcUser> hcUsers) {
		this.hcUsers = hcUsers;
	}

	public HcUser addHcUser(HcUser hcUser) {
		getHcUsers().add(hcUser);
		hcUser.setHcNeighborhood(this);

		return hcUser;
	}

	public HcUser removeHcUser(HcUser hcUser) {
		getHcUsers().remove(hcUser);
		hcUser.setHcNeighborhood(null);

		return hcUser;
	}

}