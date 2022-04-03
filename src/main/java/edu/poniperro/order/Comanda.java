package edu.poniperro.order;

import edu.poniperro.items.Item;

import java.util.List;

public interface Comanda {
    void addItem(String name, Double price);
    void addItem(String name, Double price, String extra);
    int size();
    List <Item> itemList();
    Double getTotal();
    void updateTotal(Double price);
    void display();
}

