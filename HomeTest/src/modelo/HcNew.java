package modelo;

import java.io.Serializable;
import java.sql.Time;
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
 * The persistent class for the hc_news database table.
 *
 */
@Entity
@Table(name = "hc_news")
@NamedQuery(name = "HcNew.findAll", query = "SELECT h FROM HcNew h")
public class HcNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_NEWS_NEWID_GENERATOR", sequenceName="HC_NEWS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_NEWS_NEWID_GENERATOR")
	@Column(name="new_id")
	private Integer newId;

	@Column(name = "actual_date")
	private LocalDate actualLocalDate;

	@Column(name = "actual_time")
	private Time actualTime;

	private String description;

	// bi-directional many-to-one association to HcNewState
	@OneToMany(mappedBy = "hcNew", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcNewState> hcNewStates;

	// bi-directional many-to-one association to HcAsset
	@ManyToOne
	@JoinColumn(name = "hc_assets_asset_id")
	private HcAsset hcAsset;

	// bi-directional many-to-one association to HcNew
	@ManyToOne
	@JoinColumn(name = "hc_news_new_id")
	private HcNew hcNew;

	// bi-directional many-to-one association to HcNew
	@OneToMany(mappedBy = "hcNew", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcNew> hcNews;

	// bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name = "hc_users_user_id")
	private HcUser hcUser;

	// bi-directional many-to-one association to HcPhoto
	@OneToMany(mappedBy = "hcNew", fetch = FetchType.EAGER)
	private Set<HcPhoto> hcPhotos;

	public HcNew() {
	}

	public HcNew addHcNew(HcNew hcNew) {
		getHcNews().add(hcNew);
		hcNew.setHcNew(this);

		return hcNew;
	}

	public HcNewState addHcNewState(HcNewState hcNewState) {
		getHcNewStates().add(hcNewState);
		hcNewState.setHcNew(this);

		return hcNewState;
	}

	public HcPhoto addHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().add(hcPhoto);
		hcPhoto.setHcNew(this);

		return hcPhoto;
	}

	public LocalDate getActualLocalDate() {
		return this.actualLocalDate;
	}

	public Time getActualTime() {
		return this.actualTime;
	}

	public String getDescription() {
		return this.description;
	}

	public HcAsset getHcAsset() {
		return this.hcAsset;
	}

	public HcNew getHcNew() {
		return this.hcNew;
	}

	public Set<HcNew> getHcNews() {
		return this.hcNews;
	}

	public Set<HcNewState> getHcNewStates() {
		return this.hcNewStates;
	}

	public Set<HcPhoto> getHcPhotos() {
		return this.hcPhotos;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public Integer getNewId() {
		return this.newId;
	}

	public HcNew removeHcNew(HcNew hcNew) {
		getHcNews().remove(hcNew);
		hcNew.setHcNew(null);

		return hcNew;
	}

	public HcNewState removeHcNewState(HcNewState hcNewState) {
		getHcNewStates().remove(hcNewState);
		hcNewState.setHcNew(null);

		return hcNewState;
	}

	public HcPhoto removeHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().remove(hcPhoto);
		hcPhoto.setHcNew(null);

		return hcPhoto;
	}

	public void setActualLocalDate(LocalDate actualLocalDate) {
		this.actualLocalDate = actualLocalDate;
	}

	public void setActualTime(Time actualTime) {
		this.actualTime = actualTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHcAsset(HcAsset hcAsset) {
		this.hcAsset = hcAsset;
	}

	public void setHcNew(HcNew hcNew) {
		this.hcNew = hcNew;
	}

	public void setHcNews(Set<HcNew> hcNews) {
		this.hcNews = hcNews;
	}

	public void setHcNewStates(Set<HcNewState> hcNewStates) {
		this.hcNewStates = hcNewStates;
	}

	public void setHcPhotos(Set<HcPhoto> hcPhotos) {
		this.hcPhotos = hcPhotos;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setNewId(Integer newId) {
		this.newId = newId;
	}

}