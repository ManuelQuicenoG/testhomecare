package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the hc_transport_services database table.
 *
 */
@Entity
@Table(name = "hc_transport_services")
@NamedQuery(name = "HcTransportService.findAll", query = "SELECT h FROM HcTransportService h")
public class HcTransportService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_TRANSPORT_SERVICES_HCSERVTRANSPORTID_GENERATOR", sequenceName = "HC_TRASNPORT_SERVICES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_TRANSPORT_SERVICES_HCSERVTRANSPORTID_GENERATOR")
	@Column(name = "hc_serv_transport_id")
	private Integer hcServTransportId;

	// bi-directional many-to-one association to HcServicePollTransport
	@OneToMany(mappedBy = "hcTransportService", fetch = FetchType.EAGER)
	private Set<HcServicePollTransport> hcServicePollTransports;

	// bi-directional many-to-one association to HcServiceTransState
	@OneToMany(mappedBy = "hcTransportService", fetch = FetchType.EAGER)
	private Set<HcServiceTransState> hcServiceTransStates;

	// bi-directional many-to-one association to HcServiceRequestTran
	@ManyToOne
	@JoinColumn(name = "hc_service_request_trans_hc_serv_r_trans_id")
	private HcServiceRequestTran hcServiceRequestTran;

	// bi-directional many-to-one association to HcTransportProvider
	@ManyToOne
	@JoinColumn(name = "hc_transport_providers_hc_provaider_id")
	private HcTransportProvider hcTransportProvider;

	public HcTransportService() {
	}

	public HcServicePollTransport addHcServicePollTransport(HcServicePollTransport hcServicePollTransport) {
		getHcServicePollTransports().add(hcServicePollTransport);
		hcServicePollTransport.setHcTransportService(this);

		return hcServicePollTransport;
	}

	public HcServiceTransState addHcServiceTransState(HcServiceTransState hcServiceTransState) {
		getHcServiceTransStates().add(hcServiceTransState);
		hcServiceTransState.setHcTransportService(this);

		return hcServiceTransState;
	}

	public Set<HcServicePollTransport> getHcServicePollTransports() {
		return this.hcServicePollTransports;
	}

	public HcServiceRequestTran getHcServiceRequestTran() {
		return this.hcServiceRequestTran;
	}

	public Set<HcServiceTransState> getHcServiceTransStates() {
		return this.hcServiceTransStates;
	}

	public Integer getHcServTransportId() {
		return this.hcServTransportId;
	}

	public HcTransportProvider getHcTransportProvider() {
		return this.hcTransportProvider;
	}

	public HcServicePollTransport removeHcServicePollTransport(HcServicePollTransport hcServicePollTransport) {
		getHcServicePollTransports().remove(hcServicePollTransport);
		hcServicePollTransport.setHcTransportService(null);

		return hcServicePollTransport;
	}

	public HcServiceTransState removeHcServiceTransState(HcServiceTransState hcServiceTransState) {
		getHcServiceTransStates().remove(hcServiceTransState);
		hcServiceTransState.setHcTransportService(null);

		return hcServiceTransState;
	}

	public void setHcServicePollTransports(Set<HcServicePollTransport> hcServicePollTransports) {
		this.hcServicePollTransports = hcServicePollTransports;
	}

	public void setHcServiceRequestTran(HcServiceRequestTran hcServiceRequestTran) {
		this.hcServiceRequestTran = hcServiceRequestTran;
	}

	public void setHcServiceTransStates(Set<HcServiceTransState> hcServiceTransStates) {
		this.hcServiceTransStates = hcServiceTransStates;
	}

	public void setHcServTransportId(Integer hcServTransportId) {
		this.hcServTransportId = hcServTransportId;
	}

	public void setHcTransportProvider(HcTransportProvider hcTransportProvider) {
		this.hcTransportProvider = hcTransportProvider;
	}

}