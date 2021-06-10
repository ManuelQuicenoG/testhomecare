package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_criteria_transport database table.
 * 
 */
@Entity
@Table(name="hc_criteria_transport")
@NamedQuery(name="HcCriteriaTransport.findAll", query="SELECT h FROM HcCriteriaTransport h")
public class HcCriteriaTransport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="criterion_id")
	private Integer criterionId;

	private String description;

	private String item;

	private Integer weight;

	//bi-directional many-to-one association to HcPollTypeTransport
	@ManyToOne
	@JoinColumn(name="hc_poll_type_transport_poll_type_id")
	private HcPollTypeTransport hcPollTypeTransport;

	//bi-directional many-to-one association to HcServiceQualificationsTransport
	@OneToMany(mappedBy="hcCriteriaTransport", fetch=FetchType.EAGER)
	private Set<HcServiceQualificationsTransport> hcServiceQualificationsTransports;

	public HcCriteriaTransport() {
	}

	public Integer getCriterionId() {
		return this.criterionId;
	}

	public void setCriterionId(Integer criterionId) {
		this.criterionId = criterionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public HcPollTypeTransport getHcPollTypeTransport() {
		return this.hcPollTypeTransport;
	}

	public void setHcPollTypeTransport(HcPollTypeTransport hcPollTypeTransport) {
		this.hcPollTypeTransport = hcPollTypeTransport;
	}

	public Set<HcServiceQualificationsTransport> getHcServiceQualificationsTransports() {
		return this.hcServiceQualificationsTransports;
	}

	public void setHcServiceQualificationsTransports(Set<HcServiceQualificationsTransport> hcServiceQualificationsTransports) {
		this.hcServiceQualificationsTransports = hcServiceQualificationsTransports;
	}

	public HcServiceQualificationsTransport addHcServiceQualificationsTransport(HcServiceQualificationsTransport hcServiceQualificationsTransport) {
		getHcServiceQualificationsTransports().add(hcServiceQualificationsTransport);
		hcServiceQualificationsTransport.setHcCriteriaTransport(this);

		return hcServiceQualificationsTransport;
	}

	public HcServiceQualificationsTransport removeHcServiceQualificationsTransport(HcServiceQualificationsTransport hcServiceQualificationsTransport) {
		getHcServiceQualificationsTransports().remove(hcServiceQualificationsTransport);
		hcServiceQualificationsTransport.setHcCriteriaTransport(null);

		return hcServiceQualificationsTransport;
	}

}