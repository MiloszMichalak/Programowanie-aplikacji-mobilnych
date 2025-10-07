public class FixedAmountDiscount implements DiscountStrategy{
    private final int amount = 100;
    @Override
    public int applyDiscount(int price) {
        return price - amount;
    }
}
