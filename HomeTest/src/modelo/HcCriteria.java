package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_criteria database table.
 * 
 */
@Entity
@Table(name="hc_criteria")
@NamedQuery(name="HcCriteria.findAll", query="SELECT h FROM HcCriteria h")
public class HcCriteria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="criterion_id")
	private Integer criterionId;

	private String description;

	private String item;

	private Integer weight;

	//bi-directional many-to-one association to HcPollType
	@ManyToOne
	@JoinColumn(name="hc_poll_type_poll_type_id")
	private HcPollType hcPollType;

	//bi-directional many-to-one association to HcServiceQualification
	@OneToMany(mappedBy="hcCriteria", fetch=FetchType.EAGER)
	private Set<HcServiceQualification> hcServiceQualifications;

	public HcCriteria() {
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

	public HcPollType getHcPollType() {
		return this.hcPollType;
	}

	public void setHcPollType(HcPollType hcPollType) {
		this.hcPollType = hcPollType;
	}

	public Set<HcServiceQualification> getHcServiceQualifications() {
		return this.hcServiceQualifications;
	}

	public void setHcServiceQualifications(Set<HcServiceQualification> hcServiceQualifications) {
		this.hcServiceQualifications = hcServiceQualifications;
	}

	public HcServiceQualification addHcServiceQualification(HcServiceQualification hcServiceQualification) {
		getHcServiceQualifications().add(hcServiceQualification);
		hcServiceQualification.setHcCriteria(this);

		return hcServiceQualification;
	}

	public HcServiceQualification removeHcServiceQualification(HcServiceQualification hcServiceQualification) {
		getHcServiceQualifications().remove(hcServiceQualification);
		hcServiceQualification.setHcCriteria(null);

		return hcServiceQualification;
	}

}