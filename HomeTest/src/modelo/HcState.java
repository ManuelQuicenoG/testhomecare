package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_states database table.
 *
 */
@Entity
@Table(name = "hc_states")
@NamedQuery(name = "HcState.findAll", query = "SELECT h FROM HcState h")
public class HcState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "state_id")
	private Integer stateId;

	private String description;

	private String name;

	// bi-directional many-to-one association to HcPropertyState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcPropertyState> hcPropertyStates;

	// bi-directional many-to-one association to HcServiceRState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceRState> hcServiceRStates;

	// bi-directional many-to-one association to HcServiceState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceState> hcServiceStates;

	// bi-directional many-to-one association to HcUserState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcUserState> hcUserStates;

	// bi-directional many-to-one association to HcAssetState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcAssetState> hcAssetStates;

	// bi-directional many-to-one association to HcNewState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcNewState> hcNewStates;

	// bi-directional many-to-one association to HcServiceTransRState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceTransRState> hcServiceTransRStates;

	// bi-directional many-to-one association to HcServiceTransState
	@OneToMany(mappedBy = "hcState", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceTransState> hcServiceTransStates;

	public HcState() {
	}

	public HcAssetState addHcAssetState(HcAssetState hcAssetState) {
		getHcAssetStates().add(hcAssetState);
		hcAssetState.setHcState(this);

		return hcAssetState;
	}

	public HcNewState addHcNewState(HcNewState hcNewState) {
		getHcNewStates().add(hcNewState);
		hcNewState.setHcState(this);

		return hcNewState;
	}

	public HcPropertyState addHcPropertyState(HcPropertyState hcPropertyState) {
		getHcPropertyStates().add(hcPropertyState);
		hcPropertyState.setHcState(this);

		return hcPropertyState;
	}

	public HcServiceRState addHcServiceRState(HcServiceRState hcServiceRState) {
		getHcServiceRStates().add(hcServiceRState);
		hcServiceRState.setHcState(this);

		return hcServiceRState;
	}

	public HcServiceState addHcServiceState(HcServiceState hcServiceState) {
		getHcServiceStates().add(hcServiceState);
		hcServiceState.setHcState(this);

		return hcServiceState;
	}

	public HcServiceTransRState addHcServiceTransRState(HcServiceTransRState hcServiceTransRState) {
		getHcServiceTransRStates().add(hcServiceTransRState);
		hcServiceTransRState.setHcState(this);

		return hcServiceTransRState;
	}

	public HcServiceTransState addHcServiceTransState(HcServiceTransState hcServiceTransState) {
		getHcServiceTransStates().add(hcServiceTransState);
		hcServiceTransState.setHcState(this);

		return hcServiceTransState;
	}

	public HcUserState addHcUserState(HcUserState hcUserState) {
		getHcUserStates().add(hcUserState);
		hcUserState.setHcState(this);

		return hcUserState;
	}

	public String getDescription() {
		return this.description;
	}

	public Set<HcAssetState> getHcAssetStates() {
		return this.hcAssetStates;
	}

	public Set<HcNewState> getHcNewStates() {
		return this.hcNewStates;
	}

	public Set<HcPropertyState> getHcPropertyStates() {
		return this.hcPropertyStates;
	}

	public Set<HcServiceRState> getHcServiceRStates() {
		return this.hcServiceRStates;
	}

	public Set<HcServiceState> getHcServiceStates() {
		return this.hcServiceStates;
	}

	public Set<HcServiceTransRState> getHcServiceTransRStates() {
		return this.hcServiceTransRStates;
	}

	public Set<HcServiceTransState> getHcServiceTransStates() {
		return this.hcServiceTransStates;
	}

	public Set<HcUserState> getHcUserStates() {
		return this.hcUserStates;
	}

	public String getName() {
		return this.name;
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public HcAssetState removeHcAssetState(HcAssetState hcAssetState) {
		getHcAssetStates().remove(hcAssetState);
		hcAssetState.setHcState(null);

		return hcAssetState;
	}

	public HcNewState removeHcNewState(HcNewState hcNewState) {
		getHcNewStates().remove(hcNewState);
		hcNewState.setHcState(null);

		return hcNewState;
	}

	public HcPropertyState removeHcPropertyState(HcPropertyState hcPropertyState) {
		getHcPropertyStates().remove(hcPropertyState);
		hcPropertyState.setHcState(null);

		return hcPropertyState;
	}

	public HcServiceRState removeHcServiceRState(HcServiceRState hcServiceRState) {
		getHcServiceRStates().remove(hcServiceRState);
		hcServiceRState.setHcState(null);

		return hcServiceRState;
	}

	public HcServiceState removeHcServiceState(HcServiceState hcServiceState) {
		getHcServiceStates().remove(hcServiceState);
		hcServiceState.setHcState(null);

		return hcServiceState;
	}

	public HcServiceTransRState removeHcServiceTransRState(HcServiceTransRState hcServiceTransRState) {
		getHcServiceTransRStates().remove(hcServiceTransRState);
		hcServiceTransRState.setHcState(null);

		return hcServiceTransRState;
	}

	public HcServiceTransState removeHcServiceTransState(HcServiceTransState hcServiceTransState) {
		getHcServiceTransStates().remove(hcServiceTransState);
		hcServiceTransState.setHcState(null);

		return hcServiceTransState;
	}

	public HcUserState removeHcUserState(HcUserState hcUserState) {
		getHcUserStates().remove(hcUserState);
		hcUserState.setHcState(null);

		return hcUserState;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHcAssetStates(Set<HcAssetState> hcAssetStates) {
		this.hcAssetStates = hcAssetStates;
	}

	public void setHcNewStates(Set<HcNewState> hcNewStates) {
		this.hcNewStates = hcNewStates;
	}

	public void setHcPropertyStates(Set<HcPropertyState> hcPropertyStates) {
		this.hcPropertyStates = hcPropertyStates;
	}

	public void setHcServiceRStates(Set<HcServiceRState> hcServiceRStates) {
		this.hcServiceRStates = hcServiceRStates;
	}

	public void setHcServiceStates(Set<HcServiceState> hcServiceStates) {
		this.hcServiceStates = hcServiceStates;
	}

	public void setHcServiceTransRStates(Set<HcServiceTransRState> hcServiceTransRStates) {
		this.hcServiceTransRStates = hcServiceTransRStates;
	}

	public void setHcServiceTransStates(Set<HcServiceTransState> hcServiceTransStates) {
		this.hcServiceTransStates = hcServiceTransStates;
	}

	public void setHcUserStates(Set<HcUserState> hcUserStates) {
		this.hcUserStates = hcUserStates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}