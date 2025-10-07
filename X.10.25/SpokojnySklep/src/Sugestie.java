import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Sugestie {
    @Test
    public void testTotalaPercentage(){
        List<Product> products = new ArrayList<>();
        products.add(new PhysicalProduct("Laptop", 1500));
        products.add(new DigitalProduct("E-book", 30));

        Koszyk koszyk = new Koszyk(products);
        DiscountStrategy discountStrategy = new PercentageDiscount();
        int totalPrice = koszyk.total(discountStrategy);
        // (1500 + 30) - 10% = 1377
        Assert.assertEquals(1377, totalPrice);
    }
    
    @Test
    public void testTotalaFixed() {
        List<Product> products = new ArrayList<>();
        products.add(new PhysicalProduct("Laptop", 1500));
        products.add(new DigitalProduct("E-book", 30));

        Koszyk koszyk = new Koszyk(products);
        DiscountStrategy discountStrategy = new FixedAmountDiscount();
        int totalPrice = koszyk.total(discountStrategy);
        // 1500 + 30 - 100 = 1430
        Assert.assertEquals(1430, totalPrice);
    }
}
