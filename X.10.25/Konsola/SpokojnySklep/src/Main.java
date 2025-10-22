import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new PhysicalProduct("Laptop", 1500));
        products.add(new DigitalProduct("E-book", 30));

        Koszyk koszyk = new Koszyk(products);
        DiscountStrategy discountStrategy = new PercentageDiscount();
        int totalPrice = koszyk.total(discountStrategy);

        System.out.println("Cena po rabacie: " + totalPrice);
    }
}