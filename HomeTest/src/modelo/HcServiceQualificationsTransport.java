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
 * The persistent class for the hc_service_qualifications_transport database
 * table.
 *
 */
@Entity
@Table(name = "hc_service_qualifications_transport")
@NamedQuery(name = "HcServiceQualificationsTransport.findAll", query = "SELECT h FROM HcServiceQualificationsTransport h")
public class HcServiceQualificationsTransport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_SERVICE_QUALIFICATIONS_TRANSPORT_SERVQUAILID_GENERATOR", sequenceName = "HC_SERVICE_QUALIFICATIONS_TRANSPORT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_SERVICE_QUALIFICATIONS_TRANSPORT_SERVQUAILID_GENERATOR")
	@Column(name = "serv_quail_id")
	private long servQuailId;

	private Integer score;

	// bi-directional many-to-one association to HcCriteriaTransport
	@ManyToOne
	@JoinColumn(name = "hc_criteria_transport_criterion_id")
	private HcCriteriaTransport hcCriteriaTransport;

	// bi-directional many-to-one association to HcServicePollTransport
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "hc_service_poll_transport_hc_poll_type_transport_poll_type_id", referencedColumnName = "hc_poll_type_transport_poll_type_id"),
			@JoinColumn(name = "hc_service_poll_transport_hc_serv_transport_id", referencedColumnName = "hc_transport_services_hc_serv_transport_id") })
	private HcServicePollTransport hcServicePollTransport;

	public HcServiceQualificationsTransport() {
	}

	public HcCriteriaTransport getHcCriteriaTransport() {
		return this.hcCriteriaTransport;
	}

	public HcServicePollTransport getHcServicePollTransport() {
		return this.hcServicePollTransport;
	}

	public Integer getScore() {
		return this.score;
	}

	public long getServQuailId() {
		return this.servQuailId;
	}

	public void setHcCriteriaTransport(HcCriteriaTransport hcCriteriaTransport) {
		this.hcCriteriaTransport = hcCriteriaTransport;
	}

	public void setHcServicePollTransport(HcServicePollTransport hcServicePollTransport) {
		this.hcServicePollTransport = hcServicePollTransport;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setServQuailId(long servQuailId) {
		this.servQuailId = servQuailId;
	}

}