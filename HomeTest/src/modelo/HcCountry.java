package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_countries database table.
 * 
 */
@Entity
@Table(name="hc_countries")
@NamedQuery(name="HcCountry.findAll", query="SELECT h FROM HcCountry h")
public class HcCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	private String countryId;

	private String name;

	//bi-directional many-to-one association to HcDepartment
	@OneToMany(mappedBy="hcCountry", fetch=FetchType.EAGER)
	private Set<HcDepartment> hcDepartments;

	public HcCountry() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<HcDepartment> getHcDepartments() {
		return this.hcDepartments;
	}

	public void setHcDepartments(Set<HcDepartment> hcDepartments) {
		this.hcDepartments = hcDepartments;
	}

	public HcDepartment addHcDepartment(HcDepartment hcDepartment) {
		getHcDepartments().add(hcDepartment);
		hcDepartment.setHcCountry(this);

		return hcDepartment;
	}

	public HcDepartment removeHcDepartment(HcDepartment hcDepartment) {
		getHcDepartments().remove(hcDepartment);
		hcDepartment.setHcCountry(null);

		return hcDepartment;
	}

}