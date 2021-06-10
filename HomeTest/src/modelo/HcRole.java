package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the hc_roles database table.
 *
 */
@Entity
@Table(name = "hc_roles")
@NamedQuery(name = "HcRole.findAll", query = "SELECT h FROM HcRole h")
public class HcRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	private Integer roleId;

	private String name;

	// bi-directional many-to-many association to HcPermission
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "hc_role_permissions", joinColumns = {
			@JoinColumn(name = "hc_roles_role_id") }, inverseJoinColumns = {
					@JoinColumn(name = "hc_permissions_perm_id") })
	private Set<HcPermission> hcPermissions;

	// bi-directional many-to-one association to HcUser
	@OneToMany(mappedBy = "hcRole")
	private Set<HcUser> hcUsers;

	public HcRole() {
	}

	public HcUser addHcUser(HcUser hcUser) {
		getHcUsers().add(hcUser);
		hcUser.setHcRole(this);

		return hcUser;
	}

	public Set<HcPermission> getHcPermissions() {
		return this.hcPermissions;
	}

	public Set<HcUser> getHcUsers() {
		return this.hcUsers;
	}

	public String getName() {
		return this.name;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public HcUser removeHcUser(HcUser hcUser) {
		getHcUsers().remove(hcUser);
		hcUser.setHcRole(null);

		return hcUser;
	}

	public void setHcPermissions(Set<HcPermission> hcPermissions) {
		this.hcPermissions = hcPermissions;
	}

	public void setHcUsers(Set<HcUser> hcUsers) {
		this.hcUsers = hcUsers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}