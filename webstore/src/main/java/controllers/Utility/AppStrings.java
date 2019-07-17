package controllers.Utility;

import java.util.ArrayList;

public enum AppStrings {
    STATUS("status"),
    SUCCESS("success"),
    FAILURE("failure"),
    MESSAGE("message"),
    USERNAME("username"),
    PASSWORD("password"),
    REMEMBER("remember"),
    PROMO("promo"),
    PRODUCT("product"),
    PRODUCT_ID("product_id"),
    ADDRESS("address"),
    LOCATION("location"),
    PAYMENT_METHOD("payment_method"),
    QUANTITY("quantity"),
    CART("cart"),
    IS_LOGGED_IN("isloggedIn"),
    FACEBOOK_LINK("facebook-link"),
    INSTAGRAM_LINK("instagram-link"),
    TWITTERLINK("twitter-link");

    String strVal;

    AppStrings(String strValue) {
        strVal = strValue;
    }

    public String asStr() {
        return strVal;
    }

    public static String returnAlert(String type, String topic, String message) {
        return "<div class = 'alert alert-" + type + "'>"
                + "<a href = '#' class = 'close' data-dismiss = 'alert'>&times;</a>"
                + "<strong>" + topic + "</strong>" + message
                + "</div>";
    }

    public static ArrayList<String> getLocations() {
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Fairfield");
        locations.add("Ottumwa");
        locations.add("Iowa City");
        locations.add("Cedar Rapids");
        return locations;
    }

}
