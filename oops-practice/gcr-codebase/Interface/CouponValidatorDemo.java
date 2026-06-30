interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

class ShoppingCart implements CouponValidator {
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.matches("[A-Z0-9]+");
    }
}

public class CouponValidatorDemo {
    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "OFF", "DISCOUNT2024", "WELCOME5", "abc123"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            boolean valid = cart.validateCoupon(coupon);
            System.out.println(coupon + " -> " + (valid ? "Valid" : "Invalid"));
        }
    }
}
