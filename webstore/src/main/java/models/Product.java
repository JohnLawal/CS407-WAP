package models;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product( int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object product){
        if (product == null) return false;
        if(! (product instanceof Product)) return false;
        Product nProduct = (Product) product;
        return nProduct.getId() == this.id;
    }

}
