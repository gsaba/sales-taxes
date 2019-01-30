package gs.exercises.sales.taxes.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
	
	private List<OrderItem> orderItems;
	private BigDecimal total;
	private BigDecimal salesTaxes;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(BigDecimal salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	@Override
	public String toString() {
		return "Order [orderItems=" + orderItems + "]";
	}
}
