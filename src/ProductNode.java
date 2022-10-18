public class ProductNode {

    private Product product;
    private ProductNode next;

    public ProductNode(Product product) {
        this.product = product;
        this.next = null;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductNode getNext() {
        return this.next;
    }

    public void setNext(ProductNode next) {
        this.next = next;
    }
}
