package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the hc_service_poll database table.
 * 
 */
@Entity
@Table(name="hc_service_poll")
@NamedQuery(name="HcServicePoll.findAll", query="SELECT h FROM HcServicePoll h")
public class HcServicePoll implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServicePollPK id;

	@Column(name="answer_review")
	private String answerReview;

	@Column(name="average_qualification")
	private BigDecimal averageQualification;

	@Column(name="general_qualification")
	private Integer generalQualification;

	private String review;

	//bi-directional many-to-one association to HcPollType
	@ManyToOne
	@JoinColumn(name="hc_poll_type_poll_type_id")
	private HcPollType hcPollType;

	//bi-directional many-to-one association to HcService
	@ManyToOne
	@JoinColumn(name="hc_services_serv_id")
	private HcService hcService;

	//bi-directional many-to-one association to HcServiceQualification
	@OneToMany(mappedBy="hcServicePoll", fetch=FetchType.EAGER)
	private Set<HcServiceQualification> hcServiceQualifications;

	public HcServicePoll() {
	}

	public HcServicePollPK getId() {
		return this.id;
	}

	public void setId(HcServicePollPK id) {
		this.id = id;
	}

	public String getAnswerReview() {
		return this.answerReview;
	}

	public void setAnswerReview(String answerReview) {
		this.answerReview = answerReview;
	}

	public BigDecimal getAverageQualification() {
		return this.averageQualification;
	}

	public void setAverageQualification(BigDecimal averageQualification) {
		this.averageQualification = averageQualification;
	}

	public Integer getGeneralQualification() {
		return this.generalQualification;
	}

	public void setGeneralQualification(Integer generalQualification) {
		this.generalQualification = generalQualification;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public HcPollType getHcPollType() {
		return this.hcPollType;
	}

	public void setHcPollType(HcPollType hcPollType) {
		this.hcPollType = hcPollType;
	}

	public HcService getHcService() {
		return this.hcService;
	}

	public void setHcService(HcService hcService) {
		this.hcService = hcService;
	}

	public Set<HcServiceQualification> getHcServiceQualifications() {
		return this.hcServiceQualifications;
	}

	public void setHcServiceQualifications(Set<HcServiceQualification> hcServiceQualifications) {
		this.hcServiceQualifications = hcServiceQualifications;
	}

	public HcServiceQualification addHcServiceQualification(HcServiceQualification hcServiceQualification) {
		getHcServiceQualifications().add(hcServiceQualification);
		hcServiceQualification.setHcServicePoll(this);

		return hcServiceQualification;
	}

	public HcServiceQualification removeHcServiceQualification(HcServiceQualification hcServiceQualification) {
		getHcServiceQualifications().remove(hcServiceQualification);
		hcServiceQualification.setHcServicePoll(null);

		return hcServiceQualification;
	}

}