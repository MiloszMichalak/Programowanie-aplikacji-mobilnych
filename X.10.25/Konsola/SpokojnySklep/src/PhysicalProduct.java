public class PhysicalProduct extends Product{
    public PhysicalProduct(String name, int price) {
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
