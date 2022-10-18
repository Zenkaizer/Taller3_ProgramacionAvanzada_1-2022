public abstract class Product {

    private String name;
    private String EANCode;
    private int price;
    private int stock;

    public Product(String name, String EANCode, int price, int stock) {
        this.name = name;
        this.EANCode = EANCode;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEANCode() {
        return this.EANCode;
    }

    public void setEANCode(String EANCode) {
        this.EANCode = EANCode;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toStringProduct(){
        return "Nombre: "+this.name+"\nCódigo: "+this.EANCode+"\nPrecio: "+this.price+"\nCantidad: "+this.stock;

    }
}
