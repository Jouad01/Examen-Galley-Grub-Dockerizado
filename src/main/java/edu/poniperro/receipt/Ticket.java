package edu.poniperro.receipt;

import edu.poniperro.extras.Extra;
import edu.poniperro.order.Comanda;

public interface Ticket {
    Comanda getOrder();
    void setChain(Extra extra);
    Extra getChain();
    Double total();
    void sumExtrasCharge();
    void print();
}
