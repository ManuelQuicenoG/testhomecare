package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_departments database table.
 * 
 */
@Entity
@Table(name="hc_departments")
@NamedQuery(name="HcDepartment.findAll", query="SELECT h FROM HcDepartment h")
public class HcDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="department_id")
	private Integer departmentId;

	private String name;

	//bi-directional many-to-one association to HcCity
	@OneToMany(mappedBy="hcDepartment", fetch=FetchType.EAGER)
	private Set<HcCity> hcCities;

	//bi-directional many-to-one association to HcCountry
	@ManyToOne
	@JoinColumn(name="hc_countries_country_id")
	private HcCountry hcCountry;

	public HcDepartment() {
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<HcCity> getHcCities() {
		return this.hcCities;
	}

	public void setHcCities(Set<HcCity> hcCities) {
		this.hcCities = hcCities;
	}

	public HcCity addHcCity(HcCity hcCity) {
		getHcCities().add(hcCity);
		hcCity.setHcDepartment(this);

		return hcCity;
	}

	public HcCity removeHcCity(HcCity hcCity) {
		getHcCities().remove(hcCity);
		hcCity.setHcDepartment(null);

		return hcCity;
	}

	public HcCountry getHcCountry() {
		return this.hcCountry;
	}

	public void setHcCountry(HcCountry hcCountry) {
		this.hcCountry = hcCountry;
	}

}