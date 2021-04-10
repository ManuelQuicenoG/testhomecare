package modelo;

import java.io.Serializable;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_departments database table.
 *
 */
@Entity
@Table(name = "hc_departments")
@NamedQuery(name = "HcDepartment.findAll", query = "SELECT h FROM HcDepartment h")
public class HcDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "department_id")
	private Integer departmentId;

	private String name;

	// bi-directional many-to-one association to HcCity
	@OneToMany(mappedBy = "hcDepartment", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcCity> hcCities;

	// bi-directional many-to-one association to HcCountry
	@ManyToOne
	@JoinColumn(name = "hc_countries_country_id")
	private HcCountry hcCountry;

	public HcDepartment() {
	}

	public HcCity addHcCity(HcCity hcCity) {
		getHcCities().add(hcCity);
		hcCity.setHcDepartment(this);

		return hcCity;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public Set<HcCity> getHcCities() {
		return this.hcCities;
	}

	public HcCountry getHcCountry() {
		return this.hcCountry;
	}

	public String getName() {
		return this.name;
	}

	public HcCity removeHcCity(HcCity hcCity) {
		getHcCities().remove(hcCity);
		hcCity.setHcDepartment(null);

		return hcCity;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public void setHcCities(Set<HcCity> hcCities) {
		this.hcCities = hcCities;
	}

	public void setHcCountry(HcCountry hcCountry) {
		this.hcCountry = hcCountry;
	}

	public void setName(String name) {
		this.name = name;
	}

}