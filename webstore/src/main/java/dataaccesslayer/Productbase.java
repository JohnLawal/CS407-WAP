package dataaccesslayer;


import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Productbase {
    private static ArrayList<Product> db = new ArrayList<>();


    public static boolean productExists(Product product) {
        if (product == null) return false;
        setDB();
        return db.contains(product);
    }

    public static ArrayList<Product> getDb() {
        setDB();
        return db;
    }

    public static Product getProduct(int id) {
        setDB();
        return db.stream().filter(product -> product.getId() == id).collect(Collectors.toList()).get(0);
    }

    public static List<Product> searchProducts(String query) {
        setDB();
        return db.stream()
                .filter(product ->
                        product.getName().toLowerCase().equals(query.toLowerCase())
                                || product.getPrice() == Double.parseDouble(query.replaceAll("[^0-9]", "0"))
                )
                .collect(Collectors.toList());
    }

    public static ArrayList<Product> getAdverts() {
        setDB();
        ArrayList<Product> ads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Random r = new Random();
            int ranIndex = r.nextInt((8) + 1);
            ads.add(db.get(ranIndex));
        }
        return ads;
    }

    private static void setDB() {
        //add demo data
        if (db.size() == 0) {
            db.add(new Product(1, "Facebook", 2000));
            db.add(new Product(2, "Amazon", 3000));
            db.add(new Product(3, "Google", 4000));
            db.add(new Product(4, "Capital One", 5000));
            db.add(new Product(5, "Microsoft", 6000));
            db.add(new Product(6, "WhatsApp", 7000));
            db.add(new Product(7, "Instagram", 9000));
            db.add(new Product(8, "SnapChat", 9000));
            db.add(new Product(9, "Yahoo", 2600));
            db.add(new Product(10, "Calculator", 3200));
        }
    }


}
