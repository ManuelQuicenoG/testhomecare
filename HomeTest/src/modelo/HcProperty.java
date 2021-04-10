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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_properties database table.
 *
 */
@Entity
@Table(name = "hc_properties")
@NamedQuery(name = "HcProperty.findAll", query = "SELECT h FROM HcProperty h")
public class HcProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_PROPERTIES_PROPERTYID_GENERATOR", sequenceName = "HC_PROPERTIES_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_PROPERTIES_PROPERTYID_GENERATOR")
	@Column(name = "property_id")
	private Integer propertyId;

	private String address;

	@Column(name = "baths_quantity")
	private Integer bathsQuantity;

	@Column(name = "rooms_quantity")
	private Integer roomsQuantity;

	@Column(name = "total_area")
	private double totalArea;

	// bi-directional many-to-one association to HcNeighborhood
	@ManyToOne
	@JoinColumn(name = "hc_neighborhoods_neighbor_id")
	private HcNeighborhood hcNeighborhood;

	// bi-directional many-to-many association to HcOwner
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "hc_property_admins", joinColumns = {
			@JoinColumn(name = "hc_properties_property_id") }, inverseJoinColumns = {
					@JoinColumn(name = "hc_owners_hc_users_user_id") })
	private Set<HcOwner> hcOwners;

	// bi-directional many-to-one association to HcPropertyType
	@ManyToOne
	@JoinColumn(name = "hc_property_types_prop_type_id")
	private HcPropertyType hcPropertyType;

	// bi-directional many-to-one association to HcPropertyState
	@OneToMany(mappedBy = "hcProperty", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcPropertyState> hcPropertyStates;

	// bi-directional many-to-one association to HcServiceRequest
	@OneToMany(mappedBy = "hcProperty", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcServiceRequest> hcServiceRequests;

	// bi-directional many-to-one association to HcAsset
	@OneToMany(mappedBy = "hcProperty", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcAsset> hcAssets;

	public HcProperty() {
	}

	public HcAsset addHcAsset(HcAsset hcAsset) {
		getHcAssets().add(hcAsset);
		hcAsset.setHcProperty(this);

		return hcAsset;
	}

	public HcPropertyState addHcPropertyState(HcPropertyState hcPropertyState) {
		getHcPropertyStates().add(hcPropertyState);
		hcPropertyState.setHcProperty(this);

		return hcPropertyState;
	}

	public HcServiceRequest addHcServiceRequest(HcServiceRequest hcServiceRequest) {
		getHcServiceRequests().add(hcServiceRequest);
		hcServiceRequest.setHcProperty(this);

		return hcServiceRequest;
	}

	public String getAddress() {
		return this.address;
	}

	public Integer getBathsQuantity() {
		return this.bathsQuantity;
	}

	public Set<HcAsset> getHcAssets() {
		return this.hcAssets;
	}

	public HcNeighborhood getHcNeighborhood() {
		return this.hcNeighborhood;
	}

	public Set<HcOwner> getHcOwners() {
		return this.hcOwners;
	}

	public Set<HcPropertyState> getHcPropertyStates() {
		return this.hcPropertyStates;
	}

	public HcPropertyType getHcPropertyType() {
		return this.hcPropertyType;
	}

	public Set<HcServiceRequest> getHcServiceRequests() {
		return this.hcServiceRequests;
	}

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public Integer getRoomsQuantity() {
		return this.roomsQuantity;
	}

	public double getTotalArea() {
		return this.totalArea;
	}

	public HcAsset removeHcAsset(HcAsset hcAsset) {
		getHcAssets().remove(hcAsset);
		hcAsset.setHcProperty(null);

		return hcAsset;
	}

	public HcPropertyState removeHcPropertyState(HcPropertyState hcPropertyState) {
		getHcPropertyStates().remove(hcPropertyState);
		hcPropertyState.setHcProperty(null);

		return hcPropertyState;
	}

	public HcServiceRequest removeHcServiceRequest(HcServiceRequest hcServiceRequest) {
		getHcServiceRequests().remove(hcServiceRequest);
		hcServiceRequest.setHcProperty(null);

		return hcServiceRequest;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBathsQuantity(Integer bathsQuantity) {
		this.bathsQuantity = bathsQuantity;
	}

	public void setHcAssets(Set<HcAsset> hcAssets) {
		this.hcAssets = hcAssets;
	}

	public void setHcNeighborhood(HcNeighborhood hcNeighborhood) {
		this.hcNeighborhood = hcNeighborhood;
	}

	public void setHcOwners(Set<HcOwner> hcOwners) {
		this.hcOwners = hcOwners;
	}

	public void setHcPropertyStates(Set<HcPropertyState> hcPropertyStates) {
		this.hcPropertyStates = hcPropertyStates;
	}

	public void setHcPropertyType(HcPropertyType hcPropertyType) {
		this.hcPropertyType = hcPropertyType;
	}

	public void setHcServiceRequests(Set<HcServiceRequest> hcServiceRequests) {
		this.hcServiceRequests = hcServiceRequests;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public void setRoomsQuantity(Integer roomsQuantity) {
		this.roomsQuantity = roomsQuantity;
	}

	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}

}