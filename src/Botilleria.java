public class Botilleria extends Product{

    private int stamps;
    private boolean isAlcohol;

    public Botilleria(String name, String EANCode, int price, int stock, int stamps, boolean isAlcohol) {
        super(name, EANCode, price, stock);
        this.stamps = stamps;
        this.isAlcohol = isAlcohol;
    }

    public Botilleria(Product product){
        super(product.getName(), product.getEANCode(), product.getPrice(), 1);
        this.stamps = ((Botilleria) product).getStamps();
        this.isAlcohol = ((Botilleria) product).isAlcohol();
    }
    public int getStamps() {
        return this.stamps;
    }

    public void setStamps(int stamps) {
        this.stamps = stamps;
    }

    public boolean isAlcohol() {
        return this.isAlcohol;
    }

    public void setAlcohol(boolean alcohol) {
        isAlcohol = alcohol;
    }
}
