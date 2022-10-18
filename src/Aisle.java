public class Aisle {

    private String name;
    private ProductList productList;

    public Aisle(String name) {
        this.name = name;
        this.productList = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductList getProductList() {
        return this.productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }
}
