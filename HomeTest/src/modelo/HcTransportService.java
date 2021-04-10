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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	@SequenceGenerator(name = "HC_TRANSPORT_SERVICES_HCSERVTRASNPORTID_GENERATOR", sequenceName = "HC_TRANSPORT_SERVICES_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_TRANSPORT_SERVICES_HCSERVTRASNPORTID_GENERATOR")
	@Column(name = "hc_serv_trasnport_id")
	private Integer hcServTrasnportId;

	// bi-directional many-to-one association to HcServiceTransState
	@OneToMany(mappedBy = "hcTransportService", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceTransState> hcServiceTransStates;

	// bi-directional many-to-one association to HcServiceRequestTran
	@ManyToOne
	@JoinColumn(name = "hc_service_request_trans_hc_serv_r_trans_id")
	private HcServiceRequestTran hcServiceRequestTran;

	// bi-directional many-to-one association to HcTransportProvider
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "hc_transport_providers_hc_provaider_id", referencedColumnName = "hc_provaider_id"),
			@JoinColumn(name = "hc_transport_providers_hc_users_user_id", referencedColumnName = "hc_users_user_id") })
	private HcTransportProvider hcTransportProvider;

	public HcTransportService() {
	}

	public HcServiceTransState addHcServiceTransState(HcServiceTransState hcServiceTransState) {
		getHcServiceTransStates().add(hcServiceTransState);
		hcServiceTransState.setHcTransportService(this);

		return hcServiceTransState;
	}

	public HcServiceRequestTran getHcServiceRequestTran() {
		return this.hcServiceRequestTran;
	}

	public Set<HcServiceTransState> getHcServiceTransStates() {
		return this.hcServiceTransStates;
	}

	public Integer getHcServTrasnportId() {
		return this.hcServTrasnportId;
	}

	public HcTransportProvider getHcTransportProvider() {
		return this.hcTransportProvider;
	}

	public HcServiceTransState removeHcServiceTransState(HcServiceTransState hcServiceTransState) {
		getHcServiceTransStates().remove(hcServiceTransState);
		hcServiceTransState.setHcTransportService(null);

		return hcServiceTransState;
	}

	public void setHcServiceRequestTran(HcServiceRequestTran hcServiceRequestTran) {
		this.hcServiceRequestTran = hcServiceRequestTran;
	}

	public void setHcServiceTransStates(Set<HcServiceTransState> hcServiceTransStates) {
		this.hcServiceTransStates = hcServiceTransStates;
	}

	public void setHcServTrasnportId(Integer hcServTrasnportId) {
		this.hcServTrasnportId = hcServTrasnportId;
	}

	public void setHcTransportProvider(HcTransportProvider hcTransportProvider) {
		this.hcTransportProvider = hcTransportProvider;
	}

}