package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hc_photos database table.
 * 
 */
@Entity
@Table(name="hc_photos")
@NamedQuery(name="HcPhoto.findAll", query="SELECT h FROM HcPhoto h")
public class HcPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_PHOTOS_PHOTOID_GENERATOR", sequenceName="HC_PHOTOS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_PHOTOS_PHOTOID_GENERATOR")
	@Column(name="photo_id")
	private Integer photoId;

	@Column(name="name_photo")
	private String namePhoto;

	//bi-directional many-to-one association to HcAsset
	@ManyToOne
	@JoinColumn(name="hc_assets_asset_id")
	private HcAsset hcAsset;

	//bi-directional many-to-one association to HcNew
	@ManyToOne
	@JoinColumn(name="hc_news_new_id")
	private HcNew hcNew;

	public HcPhoto() {
	}

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getNamePhoto() {
		return this.namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	public HcAsset getHcAsset() {
		return this.hcAsset;
	}

	public void setHcAsset(HcAsset hcAsset) {
		this.hcAsset = hcAsset;
	}

	public HcNew getHcNew() {
		return this.hcNew;
	}

	public void setHcNew(HcNew hcNew) {
		this.hcNew = hcNew;
	}

}