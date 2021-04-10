package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_users database table.
 * 
 */
@Entity
@Table(name="hc_users")
@NamedQuery(name="HcUser.findAll", query="SELECT h FROM HcUser h")
public class HcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_USERS_USERID_GENERATOR", sequenceName="HC_USERS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_USERS_USERID_GENERATOR")
	@Column(name="user_id")
	private Integer userId;

	private Long cellphone;

	private String document;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	//bi-directional one-to-one association to HcEmployee
	@OneToOne(mappedBy="hcUser")
	private HcEmployee hcEmployee;

	//bi-directional one-to-one association to HcOwner
	@OneToOne(mappedBy="hcUser")
	private HcOwner hcOwner;

	//bi-directional many-to-one association to HcUserState
	@OneToMany(mappedBy="hcUser", fetch=FetchType.EAGER)
	private Set<HcUserState> hcUserStates;

	//bi-directional many-to-many association to HcChatroom
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="hc_user_chatrooms"
		, joinColumns={
			@JoinColumn(name="hc_users_user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="hc_chatrooms_chat_r_id")
			}
		)
	private Set<HcChatroom> hcChatrooms;

	//bi-directional many-to-one association to HcNeighborhood
	@ManyToOne
	@JoinColumn(name="hc_neighborhoods_neighbor_id")
	private HcNeighborhood hcNeighborhood;

	//bi-directional many-to-one association to HcRole
	@ManyToOne
	@JoinColumn(name="hc_roles_role_id")
	private HcRole hcRole;

	//bi-directional many-to-one association to HcNew
	@OneToMany(mappedBy="hcUser", fetch=FetchType.EAGER)
	private Set<HcNew> hcNews;

	//bi-directional many-to-one association to HcTransportProvider
	@OneToMany(mappedBy="hcUser", fetch=FetchType.EAGER)
	private Set<HcTransportProvider> hcTransportProviders;

	public HcUser() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(Long cellphone) {
		this.cellphone = cellphone;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HcEmployee getHcEmployee() {
		return this.hcEmployee;
	}

	public void setHcEmployee(HcEmployee hcEmployee) {
		this.hcEmployee = hcEmployee;
	}

	public HcOwner getHcOwner() {
		return this.hcOwner;
	}

	public void setHcOwner(HcOwner hcOwner) {
		this.hcOwner = hcOwner;
	}

	public Set<HcUserState> getHcUserStates() {
		return this.hcUserStates;
	}

	public void setHcUserStates(Set<HcUserState> hcUserStates) {
		this.hcUserStates = hcUserStates;
	}

	public HcUserState addHcUserState(HcUserState hcUserState) {
		getHcUserStates().add(hcUserState);
		hcUserState.setHcUser(this);

		return hcUserState;
	}

	public HcUserState removeHcUserState(HcUserState hcUserState) {
		getHcUserStates().remove(hcUserState);
		hcUserState.setHcUser(null);

		return hcUserState;
	}

	public Set<HcChatroom> getHcChatrooms() {
		return this.hcChatrooms;
	}

	public void setHcChatrooms(Set<HcChatroom> hcChatrooms) {
		this.hcChatrooms = hcChatrooms;
	}

	public HcNeighborhood getHcNeighborhood() {
		return this.hcNeighborhood;
	}

	public void setHcNeighborhood(HcNeighborhood hcNeighborhood) {
		this.hcNeighborhood = hcNeighborhood;
	}

	public HcRole getHcRole() {
		return this.hcRole;
	}

	public void setHcRole(HcRole hcRole) {
		this.hcRole = hcRole;
	}

	public Set<HcNew> getHcNews() {
		return this.hcNews;
	}

	public void setHcNews(Set<HcNew> hcNews) {
		this.hcNews = hcNews;
	}

	public HcNew addHcNew(HcNew hcNew) {
		getHcNews().add(hcNew);
		hcNew.setHcUser(this);

		return hcNew;
	}

	public HcNew removeHcNew(HcNew hcNew) {
		getHcNews().remove(hcNew);
		hcNew.setHcUser(null);

		return hcNew;
	}

	public Set<HcTransportProvider> getHcTransportProviders() {
		return this.hcTransportProviders;
	}

	public void setHcTransportProviders(Set<HcTransportProvider> hcTransportProviders) {
		this.hcTransportProviders = hcTransportProviders;
	}

	public HcTransportProvider addHcTransportProvider(HcTransportProvider hcTransportProvider) {
		getHcTransportProviders().add(hcTransportProvider);
		hcTransportProvider.setHcUser(this);

		return hcTransportProvider;
	}

	public HcTransportProvider removeHcTransportProvider(HcTransportProvider hcTransportProvider) {
		getHcTransportProviders().remove(hcTransportProvider);
		hcTransportProvider.setHcUser(null);

		return hcTransportProvider;
	}

}