package gs.exercises.salestaxes.model;

import java.math.BigDecimal;

public class OrderItem {
	
	private String name;
	private BigDecimal unitPrice;
	private Integer quantity;
	private Boolean taxesExempt;
	private Boolean imported;
	
	private BigDecimal taxesAmount;
	private BigDecimal total;
	
	public OrderItem(String name, BigDecimal unitPrice, Integer quantity, Boolean taxesExempt, Boolean imported) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.taxesExempt = taxesExempt;
		this.imported = imported;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Boolean getImported() {
		return imported;
	}
	public void setImported(Boolean imported) {
		this.imported = imported;
	}
	public Boolean getTaxesExempt() {
		return taxesExempt;
	}
	public void setTaxesExempt(Boolean taxesExempt) {
		this.taxesExempt = taxesExempt;
	}
	public BigDecimal getTaxesAmount() {
		return taxesAmount;
	}
	public void setTaxesAmount(BigDecimal taxesAmount) {
		this.taxesAmount = taxesAmount;
	}
}
