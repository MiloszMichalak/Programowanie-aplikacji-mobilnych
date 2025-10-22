public class DigitalProduct extends Product{
    public DigitalProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
