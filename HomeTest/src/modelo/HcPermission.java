package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_permissions database table.
 * 
 */
@Entity
@Table(name="hc_permissions")
@NamedQuery(name="HcPermission.findAll", query="SELECT h FROM HcPermission h")
public class HcPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="perm_id")
	private Integer permId;

	private String name;

	//bi-directional many-to-many association to HcRole
	@ManyToMany(mappedBy="hcPermissions", fetch=FetchType.EAGER)
	private Set<HcRole> hcRoles;

	public HcPermission() {
	}

	public Integer getPermId() {
		return this.permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<HcRole> getHcRoles() {
		return this.hcRoles;
	}

	public void setHcRoles(Set<HcRole> hcRoles) {
		this.hcRoles = hcRoles;
	}

}