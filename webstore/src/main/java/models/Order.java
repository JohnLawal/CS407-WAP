package models;

public class Order {
    private int id;
    private Product product;
    private int quantity;

    public Order(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object order){
        if (order == null) return false;
        if(! (order instanceof Order)) return false;
        Order nOrder = (Order) order;
        return nOrder.getId() == this.id;
    }
}
