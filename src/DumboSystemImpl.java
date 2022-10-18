import java.util.ArrayList;
public class DumboSystemImpl implements DumboSystem{

    private UserList userList;
    private ArrayList<Aisle> aisleList;
    private TicketList ticketList;
    private String currentDay;
    private User currentUser;

    public DumboSystemImpl() {
        this.userList = new UserList();
        this.ticketList = new TicketList();
        this.aisleList = new ArrayList<Aisle>();
        aisleList.add(new Aisle("Aseo")); // 0
        aisleList.add(new Aisle("Menaje")); // 1
        aisleList.add(new Aisle("Botilleria")); // 2
        aisleList.add(new Aisle("Abarrotes")); // 3
        this.currentDay = "Lunes";
        this.currentUser = null;
    }

    /**
     * Método encargado de agregar un nuevo usuario a la lista del sistema.
     *
     * @param name     Nombre del usuario.
     * @param rut      Rut del usuario.
     * @param age      Edad del usuario.
     * @param password Contraseña del usuario.
     * @param email    Correo electrónico del usuario.
     * @param points   Puntos acumulados por el usuario.
     * @param type     Tipo de usuario.
     * @return "True" si el usuario se agregó satisfactoriamente y "False" si no lo logró.
     */
    @Override
    public boolean addNewUser(String name, String rut, int age, String password, String email, int points, String type) {

        if (!existCustomer(rut)){
            return false;
        }
        if (!validatePassword(password)){
            return false;
        }
        if (age < 0 || points < 0){
            return false;
        }
        if (!validateEmail(email)){
            return false;
        }
        if (type.equals("Estandar") || type.equals("Premium") || type.equals("Supervisor")){
            return false;
        }

        User newUser = new User(name, rut, age, password, email, points, type);
        this.userList.addUser(newUser);
        return true;
    }

    /**
     * Método encargado de agregar un nuevo producto de la sección de Aseo.
     *
     * @param name       Nombre del producto.
     * @param EANCode    Código del producto.
     * @param price      Precio del producto.
     * @param stock      Stock del producto.
     * @param isPersonal Parámetro que indica si el producto es de uso personal o no.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    @Override
    public boolean addNewAseo(String name, String EANCode, int price, int stock, boolean isPersonal) {
        if (price < 0 || stock < 0){
            return false;
        }
        Product newProduct = new Aseo(name, EANCode, price, stock, isPersonal);
        this.aisleList.get(0).getProductList().addProduct(newProduct);
        return true;
    }

    /**
     * Método encargado de agregar un nuevo producto de la sección de Abarrotes.
     *
     * @param name    Nombre del producto.
     * @param EANCode Código del producto.
     * @param price   Precio del producto.
     * @param stock   Stock del producto.
     * @param stamps  Cantidad de sellos del producto.
     * @param weight  Peso del producto en gramos.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    @Override
    public boolean addNewAbarrotes(String name, String EANCode, int price, int stock, int stamps, int weight) {
        if (price < 0 || stock < 0 || stamps < 0 || stamps > 4 || weight < 0){
            return false;
        }
        Product newProduct = new Abarrotes(name, EANCode, price, stock, stamps, weight);
        this.aisleList.get(3).getProductList().addProduct(newProduct);
        return true;
    }

    /**
     * Método encargado de agregar un nuevo producto de la sección de Botillería.
     *
     * @param name      Nombre del producto.
     * @param EANCode   Código del producto.
     * @param price     Precio del producto.
     * @param stock     Stock del producto.
     * @param stamps    Cantidad de sellos del producto.
     * @param isAlcohol Parámetro que indica si el producto contiene alcohol o no.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    @Override
    public boolean addNewBotilleria(String name, String EANCode, int price, int stock, int stamps, boolean isAlcohol) {
        if (price < 0 || stock < 0 || stamps < 0 || stamps > 4){
            return false;
        }
        Product newProduct = new Botilleria(name, EANCode, price, stock, stamps, isAlcohol);
        this.aisleList.get(2).getProductList().addProduct(newProduct);
        return true;
    }

    /**
     * Método encargado de agregar un nuevo producto de la sección de Menaje.
     *
     * @param name      Nombre del producto.
     * @param EANCode   Código del producto.
     * @param price     Precio del producto.
     * @param stock     Stock del producto.
     * @param isClothes Parámetro que indica si el producto es prenda o no.
     * @param size      Talla del producto.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    @Override
    public boolean addNewMenaje(String name, String EANCode, int price, int stock, boolean isClothes, String size) {
        if (price < 0 || stock < 0){
            return false;
        }
        Product newProduct = new Menaje(name, EANCode, price, stock, isClothes, size);
        this.aisleList.get(1).getProductList().addProduct(newProduct);
        return true;
    }

    /**
     * Método encargado de validar el inicio de session de un usuario al sistema.
     *
     * @param email    Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @return "True" si el inicio es válido o "False" si no lo es.
     */
    @Override
    public boolean validateLogin(String email, String password) {
        for (int i = 0; i < this.userList.getUserQuantity(); i++) {
            if (this.userList.getUserFromList(i).getEmail().equals(email) &&
                    this.userList.getUserFromList(i).getPassword().equals(password)){

                this.currentUser = this.userList.getUserFromList(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de validar el inicio de session de un supervisor al sistema.
     *
     * @param email    Correo electrónico del supervisor.
     * @param password Contraseña del supervisor.
     * @return "True" si el inicio es válido o "False" si no lo es.
     */
    @Override
    public boolean validateLoginSupervisor(String email, String password) {
        for (int i = 0; i < this.userList.getUserQuantity(); i++) {
            if (this.userList.getUserFromList(i).getEmail().equals(email) &&
                    this.userList.getUserFromList(i).getPassword().equals(password)){
                if (this.userList.getUserFromList(i).getType().equals("Supervisor")){
                    this.currentUser = this.userList.getUserFromList(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método encargado de validar que la contraseña sea válida al momento de registrar un usuario.
     *
     * @param password Contraseña del usuario.
     * @return "True" si la contraseña es válida o "False" si no lo es.
     */
    @Override
    public boolean validatePassword(String password) {

        if (password.length() < 6){
            return false;
        }

        boolean containsUpperCase = false;
        boolean containsNumber = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))){
                containsUpperCase = true;
            }
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))){
                containsNumber = true;
            }
        }

        return containsUpperCase && containsNumber;
    }

    /**
     * Método encargado de seleccionar el producto de la lista del sistema y agregarlo a la canasta del usuario.
     *
     * @param EANCode Código del producto.
     * @return "True" si se agregó correctamente o "False" si no se logró.
     */
    @Override
    public boolean buyProduct(String EANCode) {

        //Recorre la lista en búsqueda de sí el producto existe o no y si tiene stock disponible.
        for (Aisle aisle : this.aisleList) {
            Product product = aisle.getProductList().getProductFromList(EANCode);
            if (product == null) {
                return false;
            }
            if (product.getStock() == 0) {
                return false;
            }
        }

        //Primero consulta si el usuario ya tiene este producto en su canasta y en caso de tenerlo le agrega una unidad.
        Product userProduct = this.currentUser.getCart().getProductFromList(EANCode);
        if (userProduct != null){
            userProduct.setStock(userProduct.getStock() + 1);
            for (Aisle aisle : this.aisleList) {
                Product product = aisle.getProductList().getProductFromList(EANCode);
                if (product != null) {
                    product.setStock(product.getStock() - 1);
                    return true;
                }
            }
        }


        //Si el usuario no tiene el producto en el carrito, entonces se debe agregar con stock 1 y restarle al sistema.
        for (Aisle aisle : this.aisleList) {
            Product product = aisle.getProductList().getProductFromList(EANCode);
            if (product != null) {
                if (product instanceof Aseo) {
                    Aseo aseoProduct = new Aseo(product);
                    this.currentUser.getCart().addProduct(aseoProduct);
                    product.setStock(product.getStock() - 1);
                    return true;
                } else if (product instanceof Abarrotes) {
                    Abarrotes abarrotesProduct = new Abarrotes(product);
                    this.currentUser.getCart().addProduct(abarrotesProduct);
                    product.setStock(product.getStock() - 1);
                    return true;
                } else if (product instanceof Botilleria) {
                    Botilleria botilleriaProduct = new Botilleria(product);
                    this.currentUser.getCart().addProduct(botilleriaProduct);
                    product.setStock(product.getStock() - 1);
                    return true;
                } else if (product instanceof Menaje) {
                    Menaje menajeProduct = new Menaje(product);
                    this.currentUser.getCart().addProduct(menajeProduct);
                    product.setStock(product.getStock() - 1);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método encargado de seleccionar el producto de la canasta del usuario y agregarlo a la lista del sistema.
     *
     * @param EANCode Código del producto.
     * @param quantity Cantidad de
     * @return "True" si se eliminó correctamente o "False" si no se logró.
     */
    @Override
    public boolean returnProduct(String EANCode, int quantity) {

        if (this.currentUser.getCart().getProductFromList(EANCode) == null){
            return false;
        }

        for (int i = 0; i < this.currentUser.getCart().getProductQuantity(); i++) {
            if (this.currentUser.getCart().getProductFromList(i).getEANCode().equals(EANCode)){
                Product currentProduct = this.currentUser.getCart().getProductFromList(i);
                if (currentProduct.getStock() == quantity){
                    this.currentUser.getCart().deleteProduct(EANCode);
                    for (Aisle aisle : this.aisleList) {
                        Product systemProduct = aisle.getProductList().getProductFromList(EANCode);
                        if (systemProduct != null) {
                            systemProduct.setStock(systemProduct.getStock() + quantity);
                            return true;
                        }
                    }
                }else{
                    currentProduct.setStock(currentProduct.getStock() - quantity);
                    for (Aisle aisle : this.aisleList) {
                        Product systemProduct = aisle.getProductList().getProductFromList(EANCode);
                        if (systemProduct != null) {
                            systemProduct.setStock(systemProduct.getStock() + quantity);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Método encargado de generar la boleta correspondiente al la venta.
     *
     * @return "True" si se generó de manera correcta, o "False" si no lo hizo.
     */
    @Override
    public boolean generateTicket() {
        return false;
    }

    /**
     * Método que obtiene la lista de productos del sistema.
     * @param index Índice del pasillo.
     * @return Lista de productos del sistema.
     */
    @Override
    public String[] getProductList(int index) {

        int productQuantity = 0;

        if(index == 0){

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Aseo){
                    productQuantity++;
                }
            }

            String[] productList = new String[productQuantity + 1];
            productList[0] = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPasillo Actual: Aseo\n";

            int aux = 1;

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Aseo){
                    Product actualProduct = this.aisleList.get(index).getProductList().getProductFromList(i);
                    productList[aux] = actualProduct.toStringProduct()+"\n";
                    aux++;
                }
            }
            return productList;

        }
        else if(index == 1){

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Menaje){
                    productQuantity++;
                }
            }

            String[] productList = new String[productQuantity + 1];
            productList[0] = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPasillo Actual: Menaje\n";

            int aux = 1;

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Menaje){
                    Product actualProduct = this.aisleList.get(index).getProductList().getProductFromList(i);
                    productList[aux] = actualProduct.toStringProduct()+"\n";
                    aux++;
                }
            }
            return productList;

        }
        else if(index == 2) {

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Botilleria){
                    productQuantity++;
                }
            }

            String[] productList = new String[productQuantity + 1];
            productList[0] = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPasillo Actual: Botillería\n";

            int aux = 1;

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Botilleria){
                    Product actualProduct = this.aisleList.get(index).getProductList().getProductFromList(i);
                    productList[aux] = actualProduct.toStringProduct()+"\n";
                    aux++;
                }
            }
            return productList;

        }
        else if(index == 3){

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Abarrotes){
                    productQuantity++;
                }
            }

            String[] productList = new String[productQuantity + 1];
            productList[0] = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPasillo Actual: Abarrotes\n";

            int aux = 1;

            for (int i = 0; i < this.aisleList.get(index).getProductList().getProductQuantity() ; i++) {
                if(this.aisleList.get(index).getProductList().getProductFromList(i) instanceof Abarrotes){
                    Product actualProduct = this.aisleList.get(index).getProductList().getProductFromList(i);
                    productList[aux] = actualProduct.toStringProduct()+"\n";
                    aux++;
                }
            }
            return productList;

        }

        return null;
    }

    /**
     * Método que obtiene la lista de usuarios del sistema.
     *
     * @return Lista de usuarios del sistema.
     */
    @Override
    public String[] getUserList() {
        return new String[0];
    }

    /**
     * Método que obtiene la canasta del usuario.
     *
     * @return Canasta del usuario.
     */
    @Override
    public String[] getUserProductList() {

        String[] cart = new String[this.currentUser.getCart().getProductQuantity() + 1];

        if (this.currentUser.getCart().getProductQuantity() == 0){
            cart[0] = "La canasta esta vacia!";
        }

        for (int i = 0; i < this.currentUser.getCart().getProductQuantity() ; i++) {
            Product currentProduct = this.currentUser.getCart().getProductFromList(i);
            String message = currentProduct.toStringProduct();
            cart[i] = message;
        }
        return cart;
    }

    /**
     * Método encargado de cambiar al día siguiente.
     */
    @Override
    public void changeDay() {
        if (this.currentDay.equals("Lunes")){
            this.currentDay = "Martes";
            return;
        }
        if (this.currentDay.equals("Martes")){
            this.currentDay = "Miércoles";
            return;
        }
        if (this.currentDay.equals("Miércoles")){
            this.currentDay = "Jueves";
            return;
        }
        if (this.currentDay.equals("Jueves")){
            this.currentDay = "Viernes";
            return;
        }
        if (this.currentDay.equals("Viernes")){
            this.currentDay = "Sábado";
            return;
        }
        if (this.currentDay.equals("Sábado")){
            this.currentDay = "Domingo";
            return;
        }
        if (this.currentDay.equals("Domingo")){
            this.currentDay = "Lunes";
        }
    }

    /**
     * Método encargado de obtener los días con más productos vendidos.
     *
     * @return Días con más productos vendidos.
     */
    @Override
    public String[] daysWithMoreSales() {
        return new String[0];
    }

    /**
     * Método encargado de obtener a los clientes que más han gastado en el supermercado.
     *
     * @return Clientes que más han gastado en el supermercado.
     */
    @Override
    public String[] customersWhoHaveSpentMore() {
        return new String[0];
    }

    /**
     * Método que obtiene los productos que más se han vendido.
     *
     * @return Productos más vendidos.
     */
    @Override
    public String[] bestSellingProduct() {
        return new String[0];
    }

    /**
     * Método que obtiene los productos que menos se han vendido.
     *
     * @return Productos menos vendidos.
     */
    @Override
    public String[] leastSoldProduct() {
        return new String[0];
    }

    /**
     * Método que obtiene a los usuarios que más puntos tienen del sistema.
     *
     * @return Usuarios que más puntos tienen del sistema.
     */
    @Override
    public String[] customersWithMorePoints() {
        return new String[0];
    }

    /**
     * Método encargado de cerrar la sesión del usuario.
     */
    @Override
    public void logout() {
        this.currentUser = null;
    }

    @Override
    public boolean existCustomer(String rut){
        for (int i = 0; i < this.userList.getUserQuantity(); i++) {
            if (this.userList.getUserFromList(i).getRut().equals(rut)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateEmail(String email){
        for (int i = 0; i < this.userList.getUserQuantity(); i++) {
            if (email.equals(this.userList.getUserFromList(i).getEmail())){
                return false;
            }
        }
        String[] split = email.split("@");
        return split[1].equals("gmail.com") || split[1].equals("hotmail.com") || split[1].equals("outlook.com") ||
                split[1].equals("icloud.com") || split[1].equals("yahoo.com") || split[1].equals("ucn.cl");
    }

}
