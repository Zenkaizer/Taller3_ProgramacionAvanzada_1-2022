public class ProductList {

    private ProductNode head;
    private int productQuantity;

    public ProductList() {
        this.head = null;
        this.productQuantity = 0;
    }

    public ProductNode getHead() {
        return this.head;
    }

    public void setHead(ProductNode head) {
        this.head = head;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void addProduct(Product product){

        if (this.head == null){
            this.head = new ProductNode(product);
            this.productQuantity++;
            return;
        }

        ProductNode newProduct = new ProductNode(product);
        ProductNode aux = this.head;

        while (aux.getNext() != null){
            aux = aux.getNext();
        }

        aux.setNext(newProduct);
        this.productQuantity++;
    }

    public Product getProductFromList(String code){

        if (this.head == null){
            return null;
        }

        ProductNode aux = this.head;

        while (!aux.getProduct().getEANCode().equals(code)){
            aux = aux.getNext();
            if (aux == null){
                return null;
            }
        }
        return aux.getProduct();
    }

    public Product getProductFromList(int position){

        if (this.head == null){
            return null;
        }

        if (position >= this.productQuantity || position < 0){
            return null;
        }

        ProductNode aux = this.head;

        for (int i = 0; i < position; i++) {
            aux = aux.getNext();
        }

        return aux.getProduct();
    }

    public void deleteProduct(String code){

        if (getProductFromList(code) == null){ // Validación por si no existe el producto.
            return;
        }

        if (this.head.getProduct().getEANCode().equals(code)){ // Si el producto a eliminar es el primero de la lista.
            this.head = this.head.getNext();
            this.productQuantity--;
            return;
        }

        ProductNode aux = this.head;

        while (aux.getNext().getProduct().getEANCode().equals(code)){
            aux = aux.getNext();
        }

        aux.setNext(aux.getNext().getNext());
    }
}
