package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the hc_service_poll_transport database table.
 * 
 */
@Entity
@Table(name="hc_service_poll_transport")
@NamedQuery(name="HcServicePollTransport.findAll", query="SELECT h FROM HcServicePollTransport h")
public class HcServicePollTransport implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcServicePollTransportPK id;

	@Column(name="answer_review")
	private String answerReview;

	@Column(name="average_qualification")
	private BigDecimal averageQualification;

	@Column(name="general_qualification")
	private Integer generalQualification;

	private String review;

	//bi-directional many-to-one association to HcPollTypeTransport
	@ManyToOne
	@JoinColumn(name="hc_poll_type_transport_poll_type_id")
	private HcPollTypeTransport hcPollTypeTransport;

	//bi-directional many-to-one association to HcTransportService
	@ManyToOne
	@JoinColumn(name="hc_transport_services_hc_serv_transport_id")
	private HcTransportService hcTransportService;

	//bi-directional many-to-one association to HcServiceQualificationsTransport
	@OneToMany(mappedBy="hcServicePollTransport", fetch=FetchType.EAGER)
	private Set<HcServiceQualificationsTransport> hcServiceQualificationsTransports;

	public HcServicePollTransport() {
	}

	public HcServicePollTransportPK getId() {
		return this.id;
	}

	public void setId(HcServicePollTransportPK id) {
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

	public HcPollTypeTransport getHcPollTypeTransport() {
		return this.hcPollTypeTransport;
	}

	public void setHcPollTypeTransport(HcPollTypeTransport hcPollTypeTransport) {
		this.hcPollTypeTransport = hcPollTypeTransport;
	}

	public HcTransportService getHcTransportService() {
		return this.hcTransportService;
	}

	public void setHcTransportService(HcTransportService hcTransportService) {
		this.hcTransportService = hcTransportService;
	}

	public Set<HcServiceQualificationsTransport> getHcServiceQualificationsTransports() {
		return this.hcServiceQualificationsTransports;
	}

	public void setHcServiceQualificationsTransports(Set<HcServiceQualificationsTransport> hcServiceQualificationsTransports) {
		this.hcServiceQualificationsTransports = hcServiceQualificationsTransports;
	}

	public HcServiceQualificationsTransport addHcServiceQualificationsTransport(HcServiceQualificationsTransport hcServiceQualificationsTransport) {
		getHcServiceQualificationsTransports().add(hcServiceQualificationsTransport);
		hcServiceQualificationsTransport.setHcServicePollTransport(this);

		return hcServiceQualificationsTransport;
	}

	public HcServiceQualificationsTransport removeHcServiceQualificationsTransport(HcServiceQualificationsTransport hcServiceQualificationsTransport) {
		getHcServiceQualificationsTransports().remove(hcServiceQualificationsTransport);
		hcServiceQualificationsTransport.setHcServicePollTransport(null);

		return hcServiceQualificationsTransport;
	}

}