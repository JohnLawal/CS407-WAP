package dataaccesslayer;


import models.Product;

import java.util.ArrayList;

public class Productbase {
    private static ArrayList<Product> db = new ArrayList<>();


    public static boolean productExists(Product product) {
        if (product == null) return false;
        if(db.size() == 0){
            setDB();
        }
        return db.contains(product);
    }

    public static ArrayList<Product> getDb() {
        if(db.size() == 0){
            setDB();
        }
        return db;
    }

    private static void setDB() {
        //add demo data
        db.add(new Product(1, "Facebook", 2000));
        db.add(new Product(2, "Amazon", 3000));
        db.add(new Product(3, "Google", 4000));
        db.add(new Product(4, "Capital One", 5000));
        db.add(new Product(5, "Microsoft", 6000));
        db.add(new Product(6, "WhatsApp", 7000));
        db.add(new Product(7, "Instagram", 8000));
        db.add(new Product(8, "SnapChat", 9000));
        db.add(new Product(9, "Yahoo", 2600));
        db.add(new Product(10, "Calculator", 3200));
    }
}
