package dataaccesslayer;


import models.User;

import java.util.HashMap;

public class Userbase {
    private static HashMap<String, User> db = new HashMap<>();

    public static boolean userExists(User user) {
        if (user == null) return false;
        setDB();
        return db.containsValue(user);
    }

    private static void setDB(){
        //add demo data
        User testUser1 = new User("John","123");
        User testUser2 = new User("Sam","456");
        User testUser3 = new User("Van","789");
        User testUser4 = new User("Thu","xyx");

        db.put("1",testUser1);
        db.put("2",testUser2);
        db.put("3",testUser3);
        db.put("4",testUser4);
    }
}
