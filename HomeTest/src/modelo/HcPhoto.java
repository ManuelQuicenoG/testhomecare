package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the hc_photos database table.
 *
 */
@Entity
@Table(name = "hc_photos")
@NamedQuery(name = "HcPhoto.findAll", query = "SELECT h FROM HcPhoto h")
public class HcPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_PHOTOS_PHOTOID_GENERATOR", sequenceName = "HC_PHOTOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_PHOTOS_PHOTOID_GENERATOR")
	@Column(name = "photo_id")
	private Integer photoId;

	@Column(name = "name_photo")
	private String namePhoto;

	// bi-directional many-to-one association to HcAsset
	@ManyToOne
	@JoinColumn(name = "hc_assets_asset_id")
	private HcAsset hcAsset;

	// bi-directional many-to-one association to HcNew
	@ManyToOne
	@JoinColumn(name = "hc_news_new_id")
	private HcNew hcNew;

	// bi-directional many-to-one association to HcProduct
	@ManyToOne
	@JoinColumn(name = "hc_products_product_id")
	private HcProduct hcProduct;

	public HcPhoto() {
	}

	public HcAsset getHcAsset() {
		return this.hcAsset;
	}

	public HcNew getHcNew() {
		return this.hcNew;
	}

	public HcProduct getHcProduct() {
		return this.hcProduct;
	}

	public String getNamePhoto() {
		return this.namePhoto;
	}

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setHcAsset(HcAsset hcAsset) {
		this.hcAsset = hcAsset;
	}

	public void setHcNew(HcNew hcNew) {
		this.hcNew = hcNew;
	}

	public void setHcProduct(HcProduct hcProduct) {
		this.hcProduct = hcProduct;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

}