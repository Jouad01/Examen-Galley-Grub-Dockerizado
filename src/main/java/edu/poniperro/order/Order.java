package edu.poniperro.order;

import edu.poniperro.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Order implements Comanda {
    private final List <Item> itemList = new ArrayList <>();
    private Double total = 0d;

    public Order(){}

    public void addItem(String name, Double price) {
        Item item = new Item(name, price);
        this.itemList.add(item);
    }

    public void addItem(String name, Double price, String extra) {
        Item item = new Item(name, price, extra);
        this.itemList.add(item);
    }

    public int size() {
        return this.itemList.size();
    }

    public List<Item> itemList() {
        return this.itemList;
    }

    public Double getTotal() {
        return this.total;
    }

    public void updateTotal(Double price) {
        this.total += price;
    }

    public void display() {
        System.out.println("\n" + "\t" + "\t" +  "=== ORDER ===");
        for (Item item : itemList) {
            itemDisplay(item);
        }
    }

    private void itemDisplay(Item item) {
        System.out.println("\t" + item.toString());
    }
}
