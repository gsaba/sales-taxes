package gs.exercises.sales.taxes.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gs.exercises.sales.taxes.manager.OrderManager;
import gs.exercises.sales.taxes.manager.ReceiptPrinterManager;
import gs.exercises.sales.taxes.model.Order;
import gs.exercises.sales.taxes.model.OrderItem;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        
    	List<OrderItem> orderItems1 = new ArrayList<OrderItem>();
    	orderItems1.add(new OrderItem("book", new BigDecimal(12.49), 2, true, false));
    	orderItems1.add(new OrderItem("music CD", new BigDecimal(14.99), 1, false, false));
    	orderItems1.add(new OrderItem("chocolate bar", new BigDecimal(0.85), 1, true, false));
    	Order order1 = OrderManager.buildOrder(orderItems1);
    	ReceiptPrinterManager.printReceipt(order1);
    	
    	assertEquals(order1.getTotal().doubleValue(), 42.32);
    	assertEquals(order1.getSalesTaxes().doubleValue(), 1.50);
    	
    	List<OrderItem> orderItems2 = new ArrayList<OrderItem>();
    	orderItems2.add(new OrderItem("imported box of chocolates", new BigDecimal(10.00), 1, true, true));
    	orderItems2.add(new OrderItem("imported bottle of perfume", new BigDecimal(47.50), 1, false, true));
    	Order order2 = OrderManager.buildOrder(orderItems2);
    	ReceiptPrinterManager.printReceipt(order2);
    	
    	assertEquals(order2.getTotal().doubleValue(), 65.15);
    	assertEquals(order2.getSalesTaxes().doubleValue(), 7.65);
    	
    	List<OrderItem> orderItems3 = new ArrayList<OrderItem>();
    	orderItems3.add(new OrderItem("imported bottle of perfume", new BigDecimal(27.99), 1, false, true));
    	orderItems3.add(new OrderItem("bottle of perfume", new BigDecimal(18.99), 1, false, false));
    	orderItems3.add(new OrderItem("packet of headache pills", new BigDecimal(9.75), 1, true, false));
    	orderItems3.add(new OrderItem("box of imported chocolates", new BigDecimal(11.25), 3, true, true));
    	Order order3 = OrderManager.buildOrder(orderItems3);
    	ReceiptPrinterManager.printReceipt(order3);
    	
    	assertEquals(order3.getTotal().doubleValue(), 98.38);
    	assertEquals(order3.getSalesTaxes().doubleValue(), 7.90);
    }
}