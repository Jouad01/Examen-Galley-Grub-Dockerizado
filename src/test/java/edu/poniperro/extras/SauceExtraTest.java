package edu.poniperro.extras;

import org.testng.annotations.BeforeClass;

public class SauceExtraTest {

    static Receipt receipt;
    static Extra sauce;
    static Order order;

    @BeforeClass
    public static void setup_receipt() {

        order = new Order();

        order.addItem("Krabby Patty", 1.25, "cheese");
        order.addItem("Coral Bits", 1.00, "medium");
        order.addItem("Kelp Rings", 1.50, "sauce");
        order.addItem("Golden Loaf", 2.00, "sauce");
        order.addItem("Seafoam Soda", 1.00, "large");

        receipt = new Receipt(order);

        sauce = new SauceExtra();
        receipt.setChain(sauce);
    }

    @Test
    public void sum_extras_cheese_test() {

        sauce.sumExtras(order);
        assertEquals(1.00d, order.getTotal(), 0.1d);
    }

}
}
