package edu.poniperro.extras;

import edu.poniperro.items.Item;
import edu.poniperro.order.Comanda;

public class Regular extends Extra{
    public Regular() {}

    @Override
    public void sumExtras(Comanda comanda) {
        for (Item item : comanda.itemList()) {
            comanda.updateTotal(item.price());
        }
        if (nextExtra != null) {
            nextExtra.get().sumExtras(comanda);
        }
    }
}
