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

/**
 * The persistent class for the hc_cities database table.
 *
 */
@Entity
@Table(name = "hc_cities")
@NamedQuery(name = "HcCity.findAll", query = "SELECT h FROM HcCity h")
public class HcCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "city_id")
	private Integer cityId;

	private String name;

	// bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name = "hc_departments_department_id")
	private HcDepartment hcDepartment;

	// bi-directional many-to-one association to HcNeighborhood
	@OneToMany(mappedBy = "hcCity", fetch = FetchType.EAGER)
	private Set<HcNeighborhood> hcNeighborhoods;

	public HcCity() {
	}

	public HcNeighborhood addHcNeighborhood(HcNeighborhood hcNeighborhood) {
		getHcNeighborhoods().add(hcNeighborhood);
		hcNeighborhood.setHcCity(this);

		return hcNeighborhood;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public Set<HcNeighborhood> getHcNeighborhoods() {
		return this.hcNeighborhoods;
	}

	public String getName() {
		return this.name;
	}

	public HcNeighborhood removeHcNeighborhood(HcNeighborhood hcNeighborhood) {
		getHcNeighborhoods().remove(hcNeighborhood);
		hcNeighborhood.setHcCity(null);

		return hcNeighborhood;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

	public void setHcNeighborhoods(Set<HcNeighborhood> hcNeighborhoods) {
		this.hcNeighborhoods = hcNeighborhoods;
	}

	public void setName(String name) {
		this.name = name;
	}

}