package edu.poniperro.items;

public enum Prices {
    CHEESE(0.25, "cheese"), // Clase enum para representar un grupo de constantes
    SAUCE(0.5, "sauce"),
    MEDIUM(0.25, "medium"),
    LARGE(0.5, "large");

    private final double price;
    private final String domainName;

    Prices(double price, String domainName) {

        this.price = price;
        this.domainName = domainName;
    }


    public static void display() {
        for (Prices extra : Prices.values()) {
            System.out.println("    " + extra + " -> " + extra.getPrice());
        }
    }

    public double getPrice() {
        return this.price;
    }

    public static double getPrice(String name) {
        double NOT_FOUND = 0;

        for (Prices extra : Prices.values()) {
            if (name.equals(extra.domainName)) {
                return extra.getPrice();
            }
        }

        return NOT_FOUND;
    }

    public String getDomainName() {
        return this.domainName;
    }

    static String getDomainName(String name) {
        for (Prices extra : Prices.values()) {
            if (name.equals(extra.domainName)) {
                return extra.domainName;
            }
        }

        return null;
    }

    static Prices[] getExtras() {
        return Prices.values();
    }
}