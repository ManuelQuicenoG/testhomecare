package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the hc_order database table.
 *
 */
@Entity
@Table(name = "hc_order")
@NamedQuery(name = "HcOrder.findAll", query = "SELECT h FROM HcOrder h")
public class HcOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_ORDER_ORDERID_GENERATOR", sequenceName = "HC_ORDER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_ORDER_ORDERID_GENERATOR")
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "delivery_date")
	private LocalDate deliveryDate;

	@Column(name = "delivery_mode")
	private Integer deliveryMode;

	@Column(name = "delivery_time")
	private LocalTime deliveryTime;

	@Column(name = "order_date")
	private LocalDate orderDate;

	// bi-directional many-to-one association to HcProduct
	@ManyToOne
	@JoinColumn(name = "hc_products_product_id")
	private HcProduct hcProduct;

	// bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name = "hc_users_user_id")
	private HcUser hcUser;

	public HcOrder() {
	}

	public LocalDate getDeliveryDate() {
		return this.deliveryDate;
	}

	public Integer getDeliveryMode() {
		return this.deliveryMode;
	}

	public LocalTime getDeliveryTime() {
		return this.deliveryTime;
	}

	public HcProduct getHcProduct() {
		return this.hcProduct;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public LocalDate getOrderDate() {
		return this.orderDate;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setDeliveryMode(Integer deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public void setHcProduct(HcProduct hcProduct) {
		this.hcProduct = hcProduct;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}