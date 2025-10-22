public class PercentageDiscount implements DiscountStrategy {
    private final int percentage = 10;
    @Override
    public int applyDiscount(int price) {
        return price - (price * percentage / 100);
    }
}
