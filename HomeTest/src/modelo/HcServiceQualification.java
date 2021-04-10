package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hc_service_qualifications database table.
 * 
 */
@Entity
@Table(name="hc_service_qualifications")
@NamedQuery(name="HcServiceQualification.findAll", query="SELECT h FROM HcServiceQualification h")
public class HcServiceQualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_SERVICE_QUALIFICATIONS_SERVQUALID_GENERATOR", sequenceName="HC_SERVICE_QUALIFICATIONS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_SERVICE_QUALIFICATIONS_SERVQUALID_GENERATOR")
	@Column(name="serv_qual_id")
	private long servQualId;

	private Integer score;

	//bi-directional many-to-one association to HcCriteria
	@ManyToOne
	@JoinColumn(name="hc_criteria_criterion_id")
	private HcCriteria hcCriteria;

	//bi-directional many-to-one association to HcServicePoll
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="hc_service_poll_poll_type_id", referencedColumnName="hc_poll_type_poll_type_id"),
		@JoinColumn(name="hc_service_poll_serv_id", referencedColumnName="hc_services_serv_id")
		})
	private HcServicePoll hcServicePoll;

	public HcServiceQualification() {
	}

	public long getServQualId() {
		return this.servQualId;
	}

	public void setServQualId(long servQualId) {
		this.servQualId = servQualId;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public HcCriteria getHcCriteria() {
		return this.hcCriteria;
	}

	public void setHcCriteria(HcCriteria hcCriteria) {
		this.hcCriteria = hcCriteria;
	}

	public HcServicePoll getHcServicePoll() {
		return this.hcServicePoll;
	}

	public void setHcServicePoll(HcServicePoll hcServicePoll) {
		this.hcServicePoll = hcServicePoll;
	}

}