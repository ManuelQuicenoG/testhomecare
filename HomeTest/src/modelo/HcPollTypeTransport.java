package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the hc_poll_type_transport database table.
 *
 */
@Entity
@Table(name = "hc_poll_type_transport")
@NamedQuery(name = "HcPollTypeTransport.findAll", query = "SELECT h FROM HcPollTypeTransport h")
public class HcPollTypeTransport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "poll_type_id")
	private Integer pollTypeId;

	@Column(name = "date_creation")
	private LocalDate dateCreation;

	@Column(name = "date_expiry")
	private LocalDate dateExpiry;

	private String origin;

	private String target;

	// bi-directional many-to-one association to HcCriteriaTransport
	@OneToMany(mappedBy = "hcPollTypeTransport", fetch = FetchType.EAGER)
	private Set<HcCriteriaTransport> hcCriteriaTransports;

	// bi-directional many-to-one association to HcServicePollTransport
	@OneToMany(mappedBy = "hcPollTypeTransport", fetch = FetchType.EAGER)
	private Set<HcServicePollTransport> hcServicePollTransports;

	public HcPollTypeTransport() {
	}

	public HcCriteriaTransport addHcCriteriaTransport(HcCriteriaTransport hcCriteriaTransport) {
		getHcCriteriaTransports().add(hcCriteriaTransport);
		hcCriteriaTransport.setHcPollTypeTransport(this);

		return hcCriteriaTransport;
	}

	public HcServicePollTransport addHcServicePollTransport(HcServicePollTransport hcServicePollTransport) {
		getHcServicePollTransports().add(hcServicePollTransport);
		hcServicePollTransport.setHcPollTypeTransport(this);

		return hcServicePollTransport;
	}

	public LocalDate getDateCreation() {
		return this.dateCreation;
	}

	public LocalDate getDateExpiry() {
		return this.dateExpiry;
	}

	public Set<HcCriteriaTransport> getHcCriteriaTransports() {
		return this.hcCriteriaTransports;
	}

	public Set<HcServicePollTransport> getHcServicePollTransports() {
		return this.hcServicePollTransports;
	}

	public String getOrigin() {
		return this.origin;
	}

	public Integer getPollTypeId() {
		return this.pollTypeId;
	}

	public String getTarget() {
		return this.target;
	}

	public HcCriteriaTransport removeHcCriteriaTransport(HcCriteriaTransport hcCriteriaTransport) {
		getHcCriteriaTransports().remove(hcCriteriaTransport);
		hcCriteriaTransport.setHcPollTypeTransport(null);

		return hcCriteriaTransport;
	}

	public HcServicePollTransport removeHcServicePollTransport(HcServicePollTransport hcServicePollTransport) {
		getHcServicePollTransports().remove(hcServicePollTransport);
		hcServicePollTransport.setHcPollTypeTransport(null);

		return hcServicePollTransport;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateExpiry(LocalDate dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public void setHcCriteriaTransports(Set<HcCriteriaTransport> hcCriteriaTransports) {
		this.hcCriteriaTransports = hcCriteriaTransports;
	}

	public void setHcServicePollTransports(Set<HcServicePollTransport> hcServicePollTransports) {
		this.hcServicePollTransports = hcServicePollTransports;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setPollTypeId(Integer pollTypeId) {
		this.pollTypeId = pollTypeId;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}