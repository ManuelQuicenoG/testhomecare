package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_cities database table.
 * 
 */
@Entity
@Table(name="hc_cities")
@NamedQuery(name="HcCity.findAll", query="SELECT h FROM HcCity h")
public class HcCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="city_id")
	private Integer cityId;

	private String name;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="hc_departments_department_id")
	private HcDepartment hcDepartment;

	//bi-directional many-to-one association to HcNeighborhood
	@OneToMany(mappedBy="hcCity", fetch=FetchType.EAGER)
	private Set<HcNeighborhood> hcNeighborhoods;

	public HcCity() {
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

	public Set<HcNeighborhood> getHcNeighborhoods() {
		return this.hcNeighborhoods;
	}

	public void setHcNeighborhoods(Set<HcNeighborhood> hcNeighborhoods) {
		this.hcNeighborhoods = hcNeighborhoods;
	}

	public HcNeighborhood addHcNeighborhood(HcNeighborhood hcNeighborhood) {
		getHcNeighborhoods().add(hcNeighborhood);
		hcNeighborhood.setHcCity(this);

		return hcNeighborhood;
	}

	public HcNeighborhood removeHcNeighborhood(HcNeighborhood hcNeighborhood) {
		getHcNeighborhoods().remove(hcNeighborhood);
		hcNeighborhood.setHcCity(null);

		return hcNeighborhood;
	}

}