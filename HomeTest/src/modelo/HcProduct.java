package modelo;

import java.io.Serializable;
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

/**
 * The persistent class for the hc_products database table.
 *
 */
@Entity
@Table(name = "hc_products")
@NamedQuery(name = "HcProduct.findAll", query = "SELECT h FROM HcProduct h")
public class HcProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_PRODUCTS_PRODUCTID_GENERATOR", sequenceName = "HC_PRODUCTS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_PRODUCTS_PRODUCTID_GENERATOR")
	@Column(name = "product_id")
	private Integer productId;

	private String description;

	@Column(name = "expiration_date")
	private LocalDate expirationDate;

	private String name;

	@Column(name = "purchase_date")
	private LocalDate purchaseDate;

	@Column(name = "purchase_price")
	private double purchasePrice;

	private Integer quantity;

	@Column(name = "sale_price")
	private double salePrice;

	// bi-directional many-to-one association to HcOrder
	@OneToMany(mappedBy = "hcProduct", fetch = FetchType.EAGER)
	private Set<HcOrder> hcOrders;

	// bi-directional many-to-one association to HcPhoto
	@OneToMany(mappedBy = "hcProduct", fetch = FetchType.EAGER)
	private Set<HcPhoto> hcPhotos;

	// bi-directional many-to-one association to HcEmployee
	@ManyToOne
	@JoinColumn(name = "hc_employees_user_id")
	private HcEmployee hcEmployee;

	public HcProduct() {
	}

	public HcOrder addHcOrder(HcOrder hcOrder) {
		getHcOrders().add(hcOrder);
		hcOrder.setHcProduct(this);

		return hcOrder;
	}

	public HcPhoto addHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().add(hcPhoto);
		hcPhoto.setHcProduct(this);

		return hcPhoto;
	}

	public String getDescription() {
		return this.description;
	}

	public LocalDate getExpirationDate() {
		return this.expirationDate;
	}

	public HcEmployee getHcEmployee() {
		return this.hcEmployee;
	}

	public Set<HcOrder> getHcOrders() {
		return this.hcOrders;
	}

	public Set<HcPhoto> getHcPhotos() {
		return this.hcPhotos;
	}

	public String getName() {
		return this.name;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public LocalDate getPurchaseDate() {
		return this.purchaseDate;
	}

	public double getPurchasePrice() {
		return this.purchasePrice;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public double getSalePrice() {
		return this.salePrice;
	}

	public HcOrder removeHcOrder(HcOrder hcOrder) {
		getHcOrders().remove(hcOrder);
		hcOrder.setHcProduct(null);

		return hcOrder;
	}

	public HcPhoto removeHcPhoto(HcPhoto hcPhoto) {
		getHcPhotos().remove(hcPhoto);
		hcPhoto.setHcProduct(null);

		return hcPhoto;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setHcEmployee(HcEmployee hcEmployee) {
		this.hcEmployee = hcEmployee;
	}

	public void setHcOrders(Set<HcOrder> hcOrders) {
		this.hcOrders = hcOrders;
	}

	public void setHcPhotos(Set<HcPhoto> hcPhotos) {
		this.hcPhotos = hcPhotos;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

}