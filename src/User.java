public class User {

    private String name;
    private String rut;
    private int age;
    private String password;
    private String email;
    private int points;
    private String type;
    private ProductList cart;

    public User(String name, String rut, int age, String password, String email, int points, String type) {
        this.name = name;
        this.rut = rut;
        this.age = age;
        this.password = password;
        this.email = email;
        this.points = points;
        this.type = type;
        this.cart = new ProductList();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductList getCart() {
        return this.cart;
    }

    public void setCart(ProductList cart) {
        this.cart = cart;
    }
}
