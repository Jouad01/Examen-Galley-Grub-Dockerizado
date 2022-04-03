package edu.poniperro.receipt;

import edu.poniperro.extras.*;
import edu.poniperro.items.Item;
import edu.poniperro.order.Comanda;

public class Receipt implements Ticket{
    private Double total = 0d;
    private final Comanda comanda;
    private Extra firstExtra;

    public Receipt(Comanda comanda) {
        this.comanda = comanda;
    }

    public Comanda getOrder() {
        return this.comanda;
    }

    @Override
    public void setChain(Extra extra) {
        this.firstExtra = extra;
    }

    @Override
    public Extra getChain() {
        return this.firstExtra;
    }

    public Double total() {
        sumExtrasCharge();
        this.total = comanda.getTotal();
        return this.total;
    }

    @Override
    public void sumExtrasCharge() {
        if (firstExtra == null) {
            Regular regular = new Regular();
            Extra cheese = new CheeseExtra();
            Extra sauce = new SauceExtra();
            Extra size = new SizeLargeExtra();

            regular.setNextExtra(cheese);
            cheese.setNextExtra(sauce);
            sauce.setNextExtra(size);

            setChain(regular);
        }
        firstExtra.sumExtras(this.comanda);
    }

    public void print() {
        System.out.println("\n" + "\n" + "       " + "=== ORDER ===");
        for (Item item : comanda.itemList()) {
            System.out.println("    " + item.toString());
        }
        System.out.println("    " + "TOTAL -> " + String.format("%.2f", this.total) + "$");
    }
}

