package gs.exercises.sales.taxes.manager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import gs.exercises.sales.taxes.model.Order;
import gs.exercises.sales.taxes.model.OrderItem;

public class OrderManager {

	private static final Double STANDARD_TAX = 0.1;
	private static final Double IMPORTAT_TAX = 0.05;
	private static final Double ROUNDING = 0.05;

	public static Order buildOrder(List<OrderItem> orderItems) {

		BigDecimal orderTotal = new BigDecimal(0.0);
		BigDecimal orderSalesTaxes = new BigDecimal(0.0);

		for (OrderItem orderItem : orderItems) {
			
			BigDecimal taxAmount = getItemTaxAmountRounded(orderItem);
			BigDecimal grossAmount = orderItem.getUnitPrice().add(taxAmount);
			BigDecimal total = grossAmount.multiply(new BigDecimal(orderItem.getQuantity()));
			
			orderItem.setTotal(total);
			orderSalesTaxes = orderSalesTaxes.add(taxAmount.multiply(new BigDecimal(orderItem.getQuantity())));
			orderTotal = orderTotal.add(total).setScale(2, RoundingMode.HALF_DOWN);
		}
		
		Order order = new Order();
		order.setOrderItems(orderItems);
		order.setTotal(orderTotal);
		order.setSalesTaxes(orderSalesTaxes);
		
		return order;
	}
	
	private static BigDecimal getItemTaxAmountRounded(OrderItem orderItem) {
		
		Double taxes = 0.0;
		if ( ! orderItem.getTaxesExempt() ) {
			taxes = taxes + STANDARD_TAX;
		}
		if ( orderItem.getImported() ) {
			taxes = taxes + IMPORTAT_TAX;
		}
		
		BigDecimal taxAmount = orderItem.getUnitPrice().multiply(new BigDecimal(taxes));
		taxAmount = round(taxAmount, new BigDecimal(ROUNDING), RoundingMode.UP);
		
		return taxAmount;
	}

	private static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		
		if (increment.signum() == 0) {
			// 0 increment does not make much sense, but prevent division by 0
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result;
		}
	}

}