package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_countries database table.
 *
 */
@Entity
@Table(name = "hc_countries")
@NamedQuery(name = "HcCountry.findAll", query = "SELECT h FROM HcCountry h")
public class HcCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "country_id")
	private String countryId;

	private String name;

	// bi-directional many-to-one association to HcDepartment
	@OneToMany(mappedBy = "hcCountry", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcDepartment> hcDepartments;

	public HcCountry() {
	}

	public HcDepartment addHcDepartment(HcDepartment hcDepartment) {
		getHcDepartments().add(hcDepartment);
		hcDepartment.setHcCountry(this);

		return hcDepartment;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public Set<HcDepartment> getHcDepartments() {
		return this.hcDepartments;
	}

	public String getName() {
		return this.name;
	}

	public HcDepartment removeHcDepartment(HcDepartment hcDepartment) {
		getHcDepartments().remove(hcDepartment);
		hcDepartment.setHcCountry(null);

		return hcDepartment;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public void setHcDepartments(Set<HcDepartment> hcDepartments) {
		this.hcDepartments = hcDepartments;
	}

	public void setName(String name) {
		this.name = name;
	}

}