public class Abarrotes extends Product{

    private int stamps;
    private int weight;

    public Abarrotes(String name, String EANCode, int price, int stock, int stamps, int weight) {
        super(name, EANCode, price, stock);
        this.stamps = stamps;
        this.weight = weight;
    }

    public Abarrotes(Product product){
        super(product.getName(), product.getEANCode(), product.getPrice(), 1);
        this.stamps = ((Abarrotes) product).getStamps();
        this.weight = ((Abarrotes) product).getWeight();
    }

    public int getStamps() {
        return this.stamps;
    }

    public void setStamps(int stamps) {
        this.stamps = stamps;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
