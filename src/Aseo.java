public class Aseo extends Product{
    private boolean isPersonal;

    public Aseo(String name, String EANCode, int price, int stock, boolean isPersonal) {
        super(name, EANCode, price, stock);
        this.isPersonal = isPersonal;
    }

    public Aseo(Product product){
        super(product.getName(), product.getEANCode(), product.getPrice(), 1);
        this.isPersonal = ((Aseo) product).isPersonal();
    }

    public boolean isPersonal() {
        return this.isPersonal;
    }

    public void setPersonal(boolean personal) {
        isPersonal = personal;
    }

}
