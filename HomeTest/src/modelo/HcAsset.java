package modelo;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_assets database table.
 *
 */
@Entity
@Table(name = "hc_assets")
@NamedQuery(name = "HcAsset.findAll", query = "SELECT h FROM HcAsset h")
public class HcAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_ASSETS_ASSETID_GENERATOR", sequenceName="HC_ASSETS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_ASSETS_ASSETID_GENERATOR")
	@Column(name="asset_id")
	private Integer assetId;

	@Column(name = "alphanumeric_id")
	private String alphanumericId;

	private String name;

	@Column(name = "pruchase_place")
	private String pruchasePlace;

	@Column(name = "purchase_date")
	private LocalDate purchaseLocalDate;

	@Column(name = "purchase_price")
	private double purchasePrice;

	@Column(name = "warranty_date")
	private LocalDate warrantyLocalDate;

	// bi-directional many-to-one association to HcAssetState
	@OneToMany(mappedBy = "hcAsset", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcAssetState> hcAssetStates;

	// bi-directional many-to-one association to HcProperty
	@ManyToOne
	@JoinColumn(name = "hc_properties_property_id")
	private HcProperty hcProperty;

	// bi-directional many-to-one association to HcNew
	@OneToMany(mappedBy = "hcAsset", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcNew> hcNews;

	// bi-directional many-to-one association to HcPhoto
	@OneToMany(mappedBy = "hcAsset", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcPhoto> hcPhotos;

	public HcAsset() {
	}

	public HcAssetState addHcAssetState(HcAssetState hcAssetState) {
		getHcAssetStates().add(hcAssetState);
		hcAssetState.setHcAsset(this);

		return hcAssetState;
	}

	public HcNew addHcNew(HcNew hcNew) {
		getHcNews().add(hcNew);
		hcNew.setHcAsset(this);

		return hcNew;
	}

	public HcPhoto addHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().add(hcPhoto);
		hcPhoto.setHcAsset(this);

		return hcPhoto;
	}

	public String getAlphanumericId() {
		return this.alphanumericId;
	}

	public Integer getAssetId() {
		return this.assetId;
	}

	public Set<HcAssetState> getHcAssetStates() {
		return this.hcAssetStates;
	}

	public Set<HcNew> getHcNews() {
		return this.hcNews;
	}

	public Set<HcPhoto> getHcPhotos() {
		return this.hcPhotos;
	}

	public HcProperty getHcProperty() {
		return this.hcProperty;
	}

	public String getName() {
		return this.name;
	}

	public String getPruchasePlace() {
		return this.pruchasePlace;
	}

	public LocalDate getPurchaseLocalDate() {
		return this.purchaseLocalDate;
	}

	public double getPurchasePrice() {
		return this.purchasePrice;
	}

	public LocalDate getWarrantyLocalDate() {
		return this.warrantyLocalDate;
	}

	public HcAssetState removeHcAssetState(HcAssetState hcAssetState) {
		getHcAssetStates().remove(hcAssetState);
		hcAssetState.setHcAsset(null);

		return hcAssetState;
	}

	public HcNew removeHcNew(HcNew hcNew) {
		getHcNews().remove(hcNew);
		hcNew.setHcAsset(null);

		return hcNew;
	}

	public HcPhoto removeHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().remove(hcPhoto);
		hcPhoto.setHcAsset(null);

		return hcPhoto;
	}

	public void setAlphanumericId(String alphanumericId) {
		this.alphanumericId = alphanumericId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public void setHcAssetStates(Set<HcAssetState> hcAssetStates) {
		this.hcAssetStates = hcAssetStates;
	}

	public void setHcNews(Set<HcNew> hcNews) {
		this.hcNews = hcNews;
	}

	public void setHcPhotos(Set<HcPhoto> hcPhotos) {
		this.hcPhotos = hcPhotos;
	}

	public void setHcProperty(HcProperty hcProperty) {
		this.hcProperty = hcProperty;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPruchasePlace(String pruchasePlace) {
		this.pruchasePlace = pruchasePlace;
	}

	public void setPurchaseLocalDate(LocalDate purchaseLocalDate) {
		this.purchaseLocalDate = purchaseLocalDate;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setWarrantyLocalDate(LocalDate warrantyLocalDate) {
		this.warrantyLocalDate = warrantyLocalDate;
	}

}