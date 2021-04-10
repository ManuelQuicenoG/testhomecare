package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;
import java.util.Set;


/**
 * The persistent class for the hc_poll_type database table.
 * 
 */
@Entity
@Table(name="hc_poll_type")
@NamedQuery(name="HcPollType.findAll", query="SELECT h FROM HcPollType h")
public class HcPollType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="poll_type_id")
	private Integer pollTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private LocalDate dateCreation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_expiry")
	private LocalDate dateExpiry;

	private String origin;

	private String target;

	//bi-directional many-to-one association to HcCriteria
	@OneToMany(mappedBy="hcPollType", fetch=FetchType.EAGER)
	private Set<HcCriteria> hcCriterias;

	//bi-directional many-to-one association to HcServicePoll
	@OneToMany(mappedBy="hcPollType", fetch=FetchType.EAGER)
	private Set<HcServicePoll> hcServicePolls;

	public HcPollType() {
	}

	public Integer getPollTypeId() {
		return this.pollTypeId;
	}

	public void setPollTypeId(Integer pollTypeId) {
		this.pollTypeId = pollTypeId;
	}

	public LocalDate getLocalDateCreation() {
		return this.dateCreation;
	}

	public void setLocalDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDate getLocalDateExpiry() {
		return this.dateExpiry;
	}

	public void setLocalDateExpiry(LocalDate dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Set<HcCriteria> getHcCriterias() {
		return this.hcCriterias;
	}

	public void setHcCriterias(Set<HcCriteria> hcCriterias) {
		this.hcCriterias = hcCriterias;
	}

	public HcCriteria addHcCriteria(HcCriteria hcCriteria) {
		getHcCriterias().add(hcCriteria);
		hcCriteria.setHcPollType(this);

		return hcCriteria;
	}

	public HcCriteria removeHcCriteria(HcCriteria hcCriteria) {
		getHcCriterias().remove(hcCriteria);
		hcCriteria.setHcPollType(null);

		return hcCriteria;
	}

	public Set<HcServicePoll> getHcServicePolls() {
		return this.hcServicePolls;
	}

	public void setHcServicePolls(Set<HcServicePoll> hcServicePolls) {
		this.hcServicePolls = hcServicePolls;
	}

	public HcServicePoll addHcServicePoll(HcServicePoll hcServicePoll) {
		getHcServicePolls().add(hcServicePoll);
		hcServicePoll.setHcPollType(this);

		return hcServicePoll;
	}

	public HcServicePoll removeHcServicePoll(HcServicePoll hcServicePoll) {
		getHcServicePolls().remove(hcServicePoll);
		hcServicePoll.setHcPollType(null);

		return hcServicePoll;
	}

}