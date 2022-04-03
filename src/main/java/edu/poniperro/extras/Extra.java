package edu.poniperro.extras;

import edu.poniperro.order.Comanda;

import java.util.Optional;

public class Extra {
    String extraProduct;
    Optional <Extra> nextExtra;

    public void setNextExtra(Extra extra) {
        this.nextExtra = Optional.ofNullable(extra);
    }

    public abstract void sumExtras(Comanda comanda);
}

