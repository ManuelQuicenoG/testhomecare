package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.LocalDate;
import java.util.Set;


/**
 * The persistent class for the hc_assets database table.
 * 
 */
@Entity
@Table(name="hc_assets")
@NamedQuery(name="HcAsset.findAll", query="SELECT h FROM HcAsset h")
public class HcAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_ASSETS_ASSETID_GENERATOR", sequenceName="HC_ASSETS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_ASSETS_ASSETID_GENERATOR")
	@Column(name="asset_id")
	private Integer assetId;

	@Column(name="alphanumeric_id")
	private String alphanumericId;

	private String name;

	@Column(name="pruchase_place")
	private String pruchasePlace;

	@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private LocalDate purchaseLocalDate;

	@Column(name="purchase_price")
	private double purchasePrice;

	@Temporal(TemporalType.DATE)
	@Column(name="warranty_date")
	private LocalDate warrantyLocalDate;

	//bi-directional many-to-one association to HcAssetState
	@OneToMany(mappedBy="hcAsset", fetch=FetchType.EAGER)
	private Set<HcAssetState> hcAssetStates;

	//bi-directional many-to-one association to HcProperty
	@ManyToOne
	@JoinColumn(name="hc_properties_property_id")
	private HcProperty hcProperty;

	//bi-directional many-to-one association to HcNew
	@OneToMany(mappedBy="hcAsset", fetch=FetchType.EAGER)
	private Set<HcNew> hcNews;

	//bi-directional many-to-one association to HcPhoto
	@OneToMany(mappedBy="hcAsset", fetch=FetchType.EAGER)
	private Set<HcPhoto> hcPhotos;

	public HcAsset() {
	}

	public Integer getAssetId() {
		return this.assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getAlphanumericId() {
		return this.alphanumericId;
	}

	public void setAlphanumericId(String alphanumericId) {
		this.alphanumericId = alphanumericId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPruchasePlace() {
		return this.pruchasePlace;
	}

	public void setPruchasePlace(String pruchasePlace) {
		this.pruchasePlace = pruchasePlace;
	}

	public LocalDate getPurchaseLocalDate() {
		return this.purchaseLocalDate;
	}

	public void setPurchaseLocalDate(LocalDate purchaseLocalDate) {
		this.purchaseLocalDate = purchaseLocalDate;
	}

	public double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public LocalDate getWarrantyLocalDate() {
		return this.warrantyLocalDate;
	}

	public void setWarrantyLocalDate(LocalDate warrantyLocalDate) {
		this.warrantyLocalDate = warrantyLocalDate;
	}

	public Set<HcAssetState> getHcAssetStates() {
		return this.hcAssetStates;
	}

	public void setHcAssetStates(Set<HcAssetState> hcAssetStates) {
		this.hcAssetStates = hcAssetStates;
	}

	public HcAssetState addHcAssetState(HcAssetState hcAssetState) {
		getHcAssetStates().add(hcAssetState);
		hcAssetState.setHcAsset(this);

		return hcAssetState;
	}

	public HcAssetState removeHcAssetState(HcAssetState hcAssetState) {
		getHcAssetStates().remove(hcAssetState);
		hcAssetState.setHcAsset(null);

		return hcAssetState;
	}

	public HcProperty getHcProperty() {
		return this.hcProperty;
	}

	public void setHcProperty(HcProperty hcProperty) {
		this.hcProperty = hcProperty;
	}

	public Set<HcNew> getHcNews() {
		return this.hcNews;
	}

	public void setHcNews(Set<HcNew> hcNews) {
		this.hcNews = hcNews;
	}

	public HcNew addHcNew(HcNew hcNew) {
		getHcNews().add(hcNew);
		hcNew.setHcAsset(this);

		return hcNew;
	}

	public HcNew removeHcNew(HcNew hcNew) {
		getHcNews().remove(hcNew);
		hcNew.setHcAsset(null);

		return hcNew;
	}

	public Set<HcPhoto> getHcPhotos() {
		return this.hcPhotos;
	}

	public void setHcPhotos(Set<HcPhoto> hcPhotos) {
		this.hcPhotos = hcPhotos;
	}

	public HcPhoto addHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().add(hcPhoto);
		hcPhoto.setHcAsset(this);

		return hcPhoto;
	}

	public HcPhoto removeHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().remove(hcPhoto);
		hcPhoto.setHcAsset(null);

		return hcPhoto;
	}

}