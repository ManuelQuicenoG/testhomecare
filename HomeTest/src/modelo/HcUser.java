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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_users database table.
 *
 */
@Entity
@Table(name = "hc_users")
@NamedQuery(name = "HcUser.findAll", query = "SELECT h FROM HcUser h")
public class HcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_USERS_USERID_GENERATOR", sequenceName = "HC_USERS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_USERS_USERID_GENERATOR")
	@Column(name = "user_id")
	private Integer userId;

	private Long cellphone;

	private String document;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String password;

	// bi-directional one-to-one association to HcEmployee
	@OneToOne(mappedBy = "hcUser")
	private HcEmployee hcEmployee;

	// bi-directional one-to-one association to HcOwner
	@OneToOne(mappedBy = "hcUser")
	private HcOwner hcOwner;

	// bi-directional many-to-one association to HcUserState
	@OneToMany(mappedBy = "hcUser", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcUserState> hcUserStates;

	// bi-directional many-to-many association to HcChatroom
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "hc_user_chatrooms", joinColumns = {
			@JoinColumn(name = "hc_users_user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "hc_chatrooms_chat_r_id") })
	private Set<HcChatroom> hcChatrooms;

	// bi-directional many-to-one association to HcNeighborhood
	@ManyToOne
	@JoinColumn(name = "hc_neighborhoods_neighbor_id")
	private HcNeighborhood hcNeighborhood;

	// bi-directional many-to-one association to HcRole
	@ManyToOne
	@JoinColumn(name = "hc_roles_role_id")
	private HcRole hcRole;

	// bi-directional many-to-one association to HcNew
	@OneToMany(mappedBy = "hcUser", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcNew> hcNews;

	// bi-directional many-to-one association to HcTransportProvider
	@OneToMany(mappedBy = "hcUser", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcTransportProvider> hcTransportProviders;

	public HcUser() {
	}

	public HcNew addHcNew(HcNew hcNew) {
		getHcNews().add(hcNew);
		hcNew.setHcUser(this);

		return hcNew;
	}

	public HcTransportProvider addHcTransportProvider(HcTransportProvider hcTransportProvider) {
		getHcTransportProviders().add(hcTransportProvider);
		hcTransportProvider.setHcUser(this);

		return hcTransportProvider;
	}

	public HcUserState addHcUserState(HcUserState hcUserState) {
		getHcUserStates().add(hcUserState);
		hcUserState.setHcUser(this);

		return hcUserState;
	}

	public Long getCellphone() {
		return this.cellphone;
	}

	public String getDocument() {
		return this.document;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public Set<HcChatroom> getHcChatrooms() {
		return this.hcChatrooms;
	}

	public HcEmployee getHcEmployee() {
		return this.hcEmployee;
	}

	public HcNeighborhood getHcNeighborhood() {
		return this.hcNeighborhood;
	}

	public Set<HcNew> getHcNews() {
		return this.hcNews;
	}

	public HcOwner getHcOwner() {
		return this.hcOwner;
	}

	public HcRole getHcRole() {
		return this.hcRole;
	}

	public Set<HcTransportProvider> getHcTransportProviders() {
		return this.hcTransportProviders;
	}

	public Set<HcUserState> getHcUserStates() {
		return this.hcUserStates;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public HcNew removeHcNew(HcNew hcNew) {
		getHcNews().remove(hcNew);
		hcNew.setHcUser(null);

		return hcNew;
	}

	public HcTransportProvider removeHcTransportProvider(HcTransportProvider hcTransportProvider) {
		getHcTransportProviders().remove(hcTransportProvider);
		hcTransportProvider.setHcUser(null);

		return hcTransportProvider;
	}

	public HcUserState removeHcUserState(HcUserState hcUserState) {
		getHcUserStates().remove(hcUserState);
		hcUserState.setHcUser(null);

		return hcUserState;
	}

	public void setCellphone(Long cellphone) {
		this.cellphone = cellphone;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setHcChatrooms(Set<HcChatroom> hcChatrooms) {
		this.hcChatrooms = hcChatrooms;
	}

	public void setHcEmployee(HcEmployee hcEmployee) {
		this.hcEmployee = hcEmployee;
	}

	public void setHcNeighborhood(HcNeighborhood hcNeighborhood) {
		this.hcNeighborhood = hcNeighborhood;
	}

	public void setHcNews(Set<HcNew> hcNews) {
		this.hcNews = hcNews;
	}

	public void setHcOwner(HcOwner hcOwner) {
		this.hcOwner = hcOwner;
	}

	public void setHcRole(HcRole hcRole) {
		this.hcRole = hcRole;
	}

	public void setHcTransportProviders(Set<HcTransportProvider> hcTransportProviders) {
		this.hcTransportProviders = hcTransportProviders;
	}

	public void setHcUserStates(Set<HcUserState> hcUserStates) {
		this.hcUserStates = hcUserStates;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}