package models;

public class Product {
    private int product_id;
    private String product_name;
    private double selling_price;

    public Product( int product_id, String product_name, double selling_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.selling_price = selling_price;
    }

    public int getId() {
        return product_id;
    }

    public String getName() {
        return product_name;
    }

    public double getPrice() {
        return selling_price;
    }

    @Override
    public boolean equals(Object product){
        if (product == null) return false;
        if(! (product instanceof Product)) return false;
        Product nProduct = (Product) product;
        return nProduct.getId() == this.product_id;
    }

}
