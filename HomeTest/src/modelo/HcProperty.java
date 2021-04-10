package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_properties database table.
 * 
 */
@Entity
@Table(name="hc_properties")
@NamedQuery(name="HcProperty.findAll", query="SELECT h FROM HcProperty h")
public class HcProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_PROPERTIES_PROPERTYID_GENERATOR", sequenceName="HC_PROPERTIES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_PROPERTIES_PROPERTYID_GENERATOR")
	@Column(name="property_id")
	private Integer propertyId;

	private String address;

	@Column(name="baths_quantity")
	private Integer bathsQuantity;

	@Column(name="rooms_quantity")
	private Integer roomsQuantity;

	@Column(name="total_area")
	private double totalArea;

	//bi-directional many-to-one association to HcNeighborhood
	@ManyToOne
	@JoinColumn(name="hc_neighborhoods_neighbor_id")
	private HcNeighborhood hcNeighborhood;

	//bi-directional many-to-many association to HcOwner
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="hc_property_admins"
		, joinColumns={
			@JoinColumn(name="hc_properties_property_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="hc_owners_hc_users_user_id")
			}
		)
	private Set<HcOwner> hcOwners;

	//bi-directional many-to-one association to HcPropertyType
	@ManyToOne
	@JoinColumn(name="hc_property_types_prop_type_id")
	private HcPropertyType hcPropertyType;

	//bi-directional many-to-one association to HcPropertyState
	@OneToMany(mappedBy="hcProperty", fetch=FetchType.EAGER)
	private Set<HcPropertyState> hcPropertyStates;

	//bi-directional many-to-one association to HcServiceRequest
	@OneToMany(mappedBy="hcProperty", fetch=FetchType.EAGER)
	private Set<HcServiceRequest> hcServiceRequests;

	//bi-directional many-to-one association to HcAsset
	@OneToMany(mappedBy="hcProperty", fetch=FetchType.EAGER)
	private Set<HcAsset> hcAssets;

	public HcProperty() {
	}

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getBathsQuantity() {
		return this.bathsQuantity;
	}

	public void setBathsQuantity(Integer bathsQuantity) {
		this.bathsQuantity = bathsQuantity;
	}

	public Integer getRoomsQuantity() {
		return this.roomsQuantity;
	}

	public void setRoomsQuantity(Integer roomsQuantity) {
		this.roomsQuantity = roomsQuantity;
	}

	public double getTotalArea() {
		return this.totalArea;
	}

	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}

	public HcNeighborhood getHcNeighborhood() {
		return this.hcNeighborhood;
	}

	public void setHcNeighborhood(HcNeighborhood hcNeighborhood) {
		this.hcNeighborhood = hcNeighborhood;
	}

	public Set<HcOwner> getHcOwners() {
		return this.hcOwners;
	}

	public void setHcOwners(Set<HcOwner> hcOwners) {
		this.hcOwners = hcOwners;
	}

	public HcPropertyType getHcPropertyType() {
		return this.hcPropertyType;
	}

	public void setHcPropertyType(HcPropertyType hcPropertyType) {
		this.hcPropertyType = hcPropertyType;
	}

	public Set<HcPropertyState> getHcPropertyStates() {
		return this.hcPropertyStates;
	}

	public void setHcPropertyStates(Set<HcPropertyState> hcPropertyStates) {
		this.hcPropertyStates = hcPropertyStates;
	}

	public HcPropertyState addHcPropertyState(HcPropertyState hcPropertyState) {
		getHcPropertyStates().add(hcPropertyState);
		hcPropertyState.setHcProperty(this);

		return hcPropertyState;
	}

	public HcPropertyState removeHcPropertyState(HcPropertyState hcPropertyState) {
		getHcPropertyStates().remove(hcPropertyState);
		hcPropertyState.setHcProperty(null);

		return hcPropertyState;
	}

	public Set<HcServiceRequest> getHcServiceRequests() {
		return this.hcServiceRequests;
	}

	public void setHcServiceRequests(Set<HcServiceRequest> hcServiceRequests) {
		this.hcServiceRequests = hcServiceRequests;
	}

	public HcServiceRequest addHcServiceRequest(HcServiceRequest hcServiceRequest) {
		getHcServiceRequests().add(hcServiceRequest);
		hcServiceRequest.setHcProperty(this);

		return hcServiceRequest;
	}

	public HcServiceRequest removeHcServiceRequest(HcServiceRequest hcServiceRequest) {
		getHcServiceRequests().remove(hcServiceRequest);
		hcServiceRequest.setHcProperty(null);

		return hcServiceRequest;
	}

	public Set<HcAsset> getHcAssets() {
		return this.hcAssets;
	}

	public void setHcAssets(Set<HcAsset> hcAssets) {
		this.hcAssets = hcAssets;
	}

	public HcAsset addHcAsset(HcAsset hcAsset) {
		getHcAssets().add(hcAsset);
		hcAsset.setHcProperty(this);

		return hcAsset;
	}

	public HcAsset removeHcAsset(HcAsset hcAsset) {
		getHcAssets().remove(hcAsset);
		hcAsset.setHcProperty(null);

		return hcAsset;
	}

}