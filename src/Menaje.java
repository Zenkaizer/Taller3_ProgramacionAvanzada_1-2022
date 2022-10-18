public class Menaje extends Product{

    private boolean isClothes;
    private String size;

    public Menaje(String name, String EANCode, int price, int stock, boolean isClothes, String size) {
        super(name, EANCode, price, stock);
        this.isClothes = isClothes;
        this.size = size;
    }

    public Menaje(Product product){
        super(product.getName(), product.getEANCode(), product.getPrice(), 1);
        this.isClothes = ((Menaje) product).isClothes();
        this.size = ((Menaje) product).getSize();
    }

    public boolean isClothes() {
        return this.isClothes;
    }

    public void setClothes(boolean clothes) {
        isClothes = clothes;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
