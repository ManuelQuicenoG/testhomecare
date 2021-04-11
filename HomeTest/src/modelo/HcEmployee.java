package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the hc_employees database table.
 *
 */
@Entity
@Table(name = "hc_employees")
@NamedQuery(name = "HcEmployee.findAll", query = "SELECT h FROM HcEmployee h")
public class HcEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "hc_users_user_id")
	private Integer hcUsersUserId;

	private String description;

	// bi-directional one-to-one association to HcUser
	@OneToOne
	@JoinColumn(name = "hc_users_user_id")
	private HcUser hcUser;

	// bi-directional many-to-one association to HcService
	@OneToMany(mappedBy = "hcEmployee", fetch = FetchType.EAGER)
	private Set<HcService> hcServices;

	public HcEmployee() {
	}

	public HcService addHcService(HcService hcService) {
		getHcServices().add(hcService);
		hcService.setHcEmployee(this);

		return hcService;
	}

	public String getDescription() {
		return this.description;
	}

	public Set<HcService> getHcServices() {
		return this.hcServices;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public Integer getHcUsersUserId() {
		return this.hcUsersUserId;
	}

	public HcService removeHcService(HcService hcService) {
		getHcServices().remove(hcService);
		hcService.setHcEmployee(null);

		return hcService;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHcServices(Set<HcService> hcServices) {
		this.hcServices = hcServices;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setHcUsersUserId(Integer hcUsersUserId) {
		this.hcUsersUserId = hcUsersUserId;
	}

}