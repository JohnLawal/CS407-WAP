package controllers.Utility;

public enum AppStrings {
    STATUS("status"),
    SUCCESS("success"),
    FAILURE("failure"),
    MESSAGE("message"),
    USERNAME("username"),
    PASSWORD("password"),
    REMEMBER("remember"),
    PROMO("promo"),
    CART("cart");

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
}
