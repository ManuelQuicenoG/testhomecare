package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the hc_service_qualifications database table.
 *
 */
@Entity
@Table(name = "hc_service_qualifications")
@NamedQuery(name = "HcServiceQualification.findAll", query = "SELECT h FROM HcServiceQualification h")
public class HcServiceQualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_SERVICE_QUALIFICATIONS_SERVQUALID_GENERATOR", sequenceName = "HC_SERVICE_QUALIFICATIONS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_SERVICE_QUALIFICATIONS_SERVQUALID_GENERATOR")
	@Column(name = "serv_qual_id")
	private long servQualId;

	private Integer score;

	// bi-directional many-to-one association to HcCriteria
	@ManyToOne
	@JoinColumn(name = "hc_criteria_criterion_id")
	private HcCriteria hcCriteria;

	// bi-directional many-to-one association to HcServicePoll
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "hc_service_poll_poll_type_id", referencedColumnName = "hc_poll_type_poll_type_id"),
			@JoinColumn(name = "hc_service_poll_serv_id", referencedColumnName = "hc_services_serv_id") })
	private HcServicePoll hcServicePoll;

	public HcServiceQualification() {
	}

	public HcCriteria getHcCriteria() {
		return this.hcCriteria;
	}

	public HcServicePoll getHcServicePoll() {
		return this.hcServicePoll;
	}

	public Integer getScore() {
		return this.score;
	}

	public long getServQualId() {
		return this.servQualId;
	}

	public void setHcCriteria(HcCriteria hcCriteria) {
		this.hcCriteria = hcCriteria;
	}

	public void setHcServicePoll(HcServicePoll hcServicePoll) {
		this.hcServicePoll = hcServicePoll;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setServQualId(long servQualId) {
		this.servQualId = servQualId;
	}

}