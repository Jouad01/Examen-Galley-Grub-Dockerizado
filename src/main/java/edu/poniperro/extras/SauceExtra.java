package edu.poniperro.extras;

import edu.poniperro.items.Item;
import edu.poniperro.items.Prices;
import edu.poniperro.order.Comanda;

public class SauceExtra extends Extra {
    private final Double SAUCE_PRICE;

    public SauceExtra() {
        this.extraProduct = Prices.SAUCE.getDomainName();
        this.SAUCE_PRICE = Prices.SAUCE.getPrice();
    }

    @Override
    public void sumExtras(Comanda comanda) {
        for (Item item : comanda.itemList()) {
            if (item.extra() == this.extraProduct) {
                comanda.updateTotal(SAUCE_PRICE);
            }
        }
        if (nextExtra != null) {
            nextExtra.get().sumExtras(comanda);
        }
    }
}
