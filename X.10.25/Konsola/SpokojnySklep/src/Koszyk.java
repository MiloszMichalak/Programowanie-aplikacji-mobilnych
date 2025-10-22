import java.util.List;

public class Koszyk {
    List<Product> listaProduktow;
    
    public Koszyk(List<Product> listaProduktow) {
        this.listaProduktow = listaProduktow;
    }
    
    public int total(DiscountStrategy d){
        int suma = 0;
        for (Product p : listaProduktow) {
            suma += p.getPrice();
        }
        return d.applyDiscount(suma);
    }
}
