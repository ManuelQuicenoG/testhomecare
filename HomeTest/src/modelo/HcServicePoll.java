package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the hc_service_poll database table.
 *
 */
@Entity
@Table(name = "hc_service_poll")
@NamedQuery(name = "HcServicePoll.findAll", query = "SELECT h FROM HcServicePoll h")
public class HcServicePoll implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServicePollPK id;

	@Column(name = "answer_review")
	private String answerReview;

	@Column(name = "average_qualification")
	private BigDecimal averageQualification;

	@Column(name = "general_qualification")
	private Integer generalQualification;

	private String review;

	// bi-directional many-to-one association to HcPollType
	@ManyToOne
	@JoinColumn(name = "hc_poll_type_poll_type_id", insertable = false, updatable = false)
	private HcPollType hcPollType;

	// bi-directional many-to-one association to HcService
	@ManyToOne
	@JoinColumn(name = "hc_services_serv_id", insertable = false, updatable = false)
	private HcService hcService;

	// bi-directional many-to-one association to HcServiceQualification
	@OneToMany(mappedBy = "hcServicePoll", fetch = FetchType.EAGER)
	private Set<HcServiceQualification> hcServiceQualifications;

	public HcServicePoll() {
	}

	public HcServiceQualification addHcServiceQualification(HcServiceQualification hcServiceQualification) {
		getHcServiceQualifications().add(hcServiceQualification);
		hcServiceQualification.setHcServicePoll(this);

		return hcServiceQualification;
	}

	public String getAnswerReview() {
		return this.answerReview;
	}

	public BigDecimal getAverageQualification() {
		return this.averageQualification;
	}

	public Integer getGeneralQualification() {
		return this.generalQualification;
	}

	public HcPollType getHcPollType() {
		return this.hcPollType;
	}

	public HcService getHcService() {
		return this.hcService;
	}

	public Set<HcServiceQualification> getHcServiceQualifications() {
		return this.hcServiceQualifications;
	}

	public HcServicePollPK getId() {
		return this.id;
	}

	public String getReview() {
		return this.review;
	}

	public HcServiceQualification removeHcServiceQualification(HcServiceQualification hcServiceQualification) {
		getHcServiceQualifications().remove(hcServiceQualification);
		hcServiceQualification.setHcServicePoll(null);

		return hcServiceQualification;
	}

	public void setAnswerReview(String answerReview) {
		this.answerReview = answerReview;
	}

	public void setAverageQualification(BigDecimal averageQualification) {
		this.averageQualification = averageQualification;
	}

	public void setGeneralQualification(Integer generalQualification) {
		this.generalQualification = generalQualification;
	}

	public void setHcPollType(HcPollType hcPollType) {
		this.hcPollType = hcPollType;
	}

	public void setHcService(HcService hcService) {
		this.hcService = hcService;
	}

	public void setHcServiceQualifications(Set<HcServiceQualification> hcServiceQualifications) {
		this.hcServiceQualifications = hcServiceQualifications;
	}

	public void setId(HcServicePollPK id) {
		this.id = id;
	}

	public void setReview(String review) {
		this.review = review;
	}

}