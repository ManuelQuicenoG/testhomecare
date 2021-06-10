package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_owners database table.
 * 
 */
@Entity
@Table(name="hc_owners")
@NamedQuery(name="HcOwner.findAll", query="SELECT h FROM HcOwner h")
public class HcOwner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hc_users_user_id")
	private Integer hcUsersUserId;

	//bi-directional one-to-one association to HcUser
	@OneToOne
	@JoinColumn(name="hc_users_user_id")
	private HcUser hcUser;

	//bi-directional many-to-many association to HcProperty
	@ManyToMany(mappedBy="hcOwners", fetch=FetchType.EAGER)
	private Set<HcProperty> hcProperties;

	public HcOwner() {
	}

	public Integer getHcUsersUserId() {
		return this.hcUsersUserId;
	}

	public void setHcUsersUserId(Integer hcUsersUserId) {
		this.hcUsersUserId = hcUsersUserId;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public Set<HcProperty> getHcProperties() {
		return this.hcProperties;
	}

	public void setHcProperties(Set<HcProperty> hcProperties) {
		this.hcProperties = hcProperties;
	}

}