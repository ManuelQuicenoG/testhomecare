package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_employees database table.
 * 
 */
@Entity
@Table(name="hc_employees")
@NamedQuery(name="HcEmployee.findAll", query="SELECT h FROM HcEmployee h")
public class HcEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hc_users_user_id")
	private Integer hcUsersUserId;

	private String description;

	//bi-directional one-to-one association to HcUser
	@OneToOne
	@JoinColumn(name="hc_users_user_id")
	private HcUser hcUser;

	//bi-directional many-to-one association to HcProduct
	@OneToMany(mappedBy="hcEmployee", fetch=FetchType.EAGER)
	private Set<HcProduct> hcProducts;

	//bi-directional many-to-one association to HcService
	@OneToMany(mappedBy="hcEmployee", fetch=FetchType.EAGER)
	private Set<HcService> hcServices;

	public HcEmployee() {
	}

	public Integer getHcUsersUserId() {
		return this.hcUsersUserId;
	}

	public void setHcUsersUserId(Integer hcUsersUserId) {
		this.hcUsersUserId = hcUsersUserId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public Set<HcProduct> getHcProducts() {
		return this.hcProducts;
	}

	public void setHcProducts(Set<HcProduct> hcProducts) {
		this.hcProducts = hcProducts;
	}

	public HcProduct addHcProduct(HcProduct hcProduct) {
		getHcProducts().add(hcProduct);
		hcProduct.setHcEmployee(this);

		return hcProduct;
	}

	public HcProduct removeHcProduct(HcProduct hcProduct) {
		getHcProducts().remove(hcProduct);
		hcProduct.setHcEmployee(null);

		return hcProduct;
	}

	public Set<HcService> getHcServices() {
		return this.hcServices;
	}

	public void setHcServices(Set<HcService> hcServices) {
		this.hcServices = hcServices;
	}

	public HcService addHcService(HcService hcService) {
		getHcServices().add(hcService);
		hcService.setHcEmployee(this);

		return hcService;
	}

	public HcService removeHcService(HcService hcService) {
		getHcServices().remove(hcService);
		hcService.setHcEmployee(null);

		return hcService;
	}

}