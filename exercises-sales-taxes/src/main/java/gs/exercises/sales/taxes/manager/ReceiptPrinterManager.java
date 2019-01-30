package gs.exercises.sales.taxes.manager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import gs.exercises.sales.taxes.model.Order;
import gs.exercises.sales.taxes.model.OrderItem;

public class ReceiptPrinterManager {
	
	private static final String DECIMAL_FORMAT = "#,##0.00";

	public static void printReceipt(Order order) {
		
		System.out.println();
		
		for (OrderItem orderItem : ( order.getOrderItems() != null ? order.getOrderItems() : new ArrayList<OrderItem>()) ) {
			
			System.out.println(orderItem.getQuantity() + " " + orderItem.getName() + ": " + printBigDecimal(orderItem.getTotal()));
		}
		
		System.out.println("Sales Taxes: " + printBigDecimal(order.getSalesTaxes()));
		System.out.println("Total: " + printBigDecimal(order.getTotal()));
	}
	
	private static String printBigDecimal(BigDecimal number) {
		
		if (number != null ) {
			DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
			return df.format(number);
		}
		return "";
	}
}
