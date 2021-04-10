package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_property_types database table.
 * 
 */
@Entity
@Table(name="hc_property_types")
@NamedQuery(name="HcPropertyType.findAll", query="SELECT h FROM HcPropertyType h")
public class HcPropertyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prop_type_id")
	private String propTypeId;

	private String description;

	@Column(name="max_area")
	private double maxArea;

	@Column(name="max_baths")
	private Integer maxBaths;

	@Column(name="max_rooms")
	private Integer maxRooms;

	@Column(name="min_area")
	private double minArea;

	@Column(name="min_baths")
	private Integer minBaths;

	@Column(name="min_rooms")
	private Integer minRooms;

	private String name;

	//bi-directional many-to-one association to HcProperty
	@OneToMany(mappedBy="hcPropertyType", fetch=FetchType.EAGER)
	private Set<HcProperty> hcProperties;

	public HcPropertyType() {
	}

	public String getPropTypeId() {
		return this.propTypeId;
	}

	public void setPropTypeId(String propTypeId) {
		this.propTypeId = propTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMaxArea() {
		return this.maxArea;
	}

	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}

	public Integer getMaxBaths() {
		return this.maxBaths;
	}

	public void setMaxBaths(Integer maxBaths) {
		this.maxBaths = maxBaths;
	}

	public Integer getMaxRooms() {
		return this.maxRooms;
	}

	public void setMaxRooms(Integer maxRooms) {
		this.maxRooms = maxRooms;
	}

	public double getMinArea() {
		return this.minArea;
	}

	public void setMinArea(double minArea) {
		this.minArea = minArea;
	}

	public Integer getMinBaths() {
		return this.minBaths;
	}

	public void setMinBaths(Integer minBaths) {
		this.minBaths = minBaths;
	}

	public Integer getMinRooms() {
		return this.minRooms;
	}

	public void setMinRooms(Integer minRooms) {
		this.minRooms = minRooms;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<HcProperty> getHcProperties() {
		return this.hcProperties;
	}

	public void setHcProperties(Set<HcProperty> hcProperties) {
		this.hcProperties = hcProperties;
	}

	public HcProperty addHcProperty(HcProperty hcProperty) {
		getHcProperties().add(hcProperty);
		hcProperty.setHcPropertyType(this);

		return hcProperty;
	}

	public HcProperty removeHcProperty(HcProperty hcProperty) {
		getHcProperties().remove(hcProperty);
		hcProperty.setHcPropertyType(null);

		return hcProperty;
	}

}