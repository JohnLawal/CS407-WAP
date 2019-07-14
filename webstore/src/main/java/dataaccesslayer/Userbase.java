package dataaccesslayer;


import models.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Userbase {
    private static ArrayList<User> db = new ArrayList<>();

    public static boolean userExists(User user) {
        if (user == null) return false;
        setDB();
        return db.contains(user);
    }

    public static User getUser(String username){
        setDB();
        return db.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList()).get(0);
    }

    private static void setDB(){
        //add demo data
        if(db.size() == 0){
            User testUser1 = new User("John","123","(641) 451-3981","me@jlawal.com","1000 N. 4th Street");
            User testUser2 = new User("Sam","456","(625) 481-3451","sam@mum.edu","1041 N. 4th Street");
            User testUser3 = new User("Van","789","(684) 457-3981","van@mum.edu","500 S. 4th Street");
            User testUser4 = new User("Thu","987","(644) 361-3791","thu@mum.edu","100 Utopia Park");

            db.add(testUser1);
            db.add(testUser2);
            db.add(testUser3);
            db.add(testUser4);
        }

    }
}
