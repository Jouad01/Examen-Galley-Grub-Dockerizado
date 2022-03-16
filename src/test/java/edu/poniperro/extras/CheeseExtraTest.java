package edu.poniperro.extras;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;


public class CheeseExtraTest {

        static Receipt receipt;
        static Extra cheese;
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

            cheese = new CheeseExtra();
            receipt.setChain(cheese);
        }

        @Test
        public void sum_extras_cheese_test() {

            cheese.sumExtras(order);
            assertEquals(0.25d, order.getTotal(), 0.1d);
        }
    }
}
