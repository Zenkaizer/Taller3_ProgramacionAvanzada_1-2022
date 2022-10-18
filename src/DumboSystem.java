public interface DumboSystem {

    /**
     * Método encargado de agregar un nuevo usuario a la lista del sistema.
     * @param name Nombre del usuario.
     * @param rut Rut del usuario.
     * @param age Edad del usuario.
     * @param password Contraseña del usuario.
     * @param email Correo electrónico del usuario.
     * @param points Puntos acumulados por el usuario.
     * @param type Tipo de usuario.
     * @return "True" si el usuario se agregó satisfactoriamente y "False" si no lo logró.
     */
    boolean addNewUser(String name, String rut, int age, String password, String email, int points, String type);

    /**
     * Método encargado de agregar un nuevo producto de la sección de Aseo.
     * @param name Nombre del producto.
     * @param EANCode Código del producto.
     * @param price Precio del producto.
     * @param stock Stock del producto.
     * @param isPersonal Parámetro que indica si el producto es de uso personal o no.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    boolean addNewAseo(String name, String EANCode, int price, int stock, boolean isPersonal);

    /**
     * Método encargado de agregar un nuevo producto de la sección de Abarrotes.
     * @param name Nombre del producto.
     * @param EANCode Código del producto.
     * @param price Precio del producto.
     * @param stock Stock del producto.
     * @param stamps Cantidad de sellos del producto.
     * @param weight Peso del producto en gramos.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    boolean addNewAbarrotes(String name, String EANCode, int price, int stock, int stamps, int weight);

    /**
     * Método encargado de agregar un nuevo producto de la sección de Botillería.
     * @param name Nombre del producto.
     * @param EANCode Código del producto.
     * @param price Precio del producto.
     * @param stock Stock del producto.
     * @param stamps Cantidad de sellos del producto.
     * @param isAlcohol Parámetro que indica si el producto contiene alcohol o no.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    boolean addNewBotilleria(String name, String EANCode, int price, int stock, int stamps, boolean isAlcohol);

    /**
     * Método encargado de agregar un nuevo producto de la sección de Menaje.
     * @param name Nombre del producto.
     * @param EANCode Código del producto.
     * @param price Precio del producto.
     * @param stock Stock del producto.
     * @param isClothes Parámetro que indica si el producto es prenda o no.
     * @param size Talla del producto.
     * @return "True" si el producto se agregó satisfactoriamente y "False" si se lo logró.
     */
    boolean addNewMenaje(String name, String EANCode, int price, int stock, boolean isClothes, String size);

    /**
     * Método encargado de validar el inicio de session de un usuario al sistema.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @return "True" si el inicio es válido o "False" si no lo es.
     * */
    boolean validateLogin(String email, String password);

    /**
     * Método encargado de validar el inicio de session de un supervisor al sistema.
     * @param email Correo electrónico del supervisor.
     * @param password Contraseña del supervisor.
     * @return "True" si el inicio es válido o "False" si no lo es.
     */
    boolean validateLoginSupervisor(String email, String password);

    /**
     * Método encargado de validar que la contraseña sea válida al momento de registrar un usuario.
     * @param password Contraseña del usuario.
     * @return "True" si la contraseña es válida o "False" si no lo es.
     */
    boolean validatePassword(String password);

    /**
     * Método encargado de seleccionar el producto de la lista del sistema y agregarlo a la canasta del usuario.
     * @param EANCode Código del producto.
     * @return "True" si se agregó correctamente o "False" si no se logró.
     */
    boolean buyProduct(String EANCode);

    /**
     * Método encargado de seleccionar el producto de la canasta del usuario y agregarlo a la lista del sistema.
     * @param EANCode Código del producto.
     * @param quantity Cantidad de productos a eliminar.
     * @return "True" si se eliminó correctamente o "False" si no se logró.
     */
    boolean returnProduct(String EANCode, int quantity);

    /**
     * Método encargado de generar la boleta correspondiente al la venta.
     * @return "True" si se generó de manera correcta, o "False" si no lo hizo.
     */
    boolean generateTicket();

    /**
     * Método que obtiene la lista de productos del sistema.
     * @param index Índice del pasillo.
     * @return Lista de productos del sistema.
     */
    String[] getProductList(int index);

    /**
     * Método que obtiene la lista de usuarios del sistema.
     * @return Lista de usuarios del sistema.
     */
    String[] getUserList();

    /**
     * Método que obtiene la canasta del usuario.
     * @return Canasta del usuario.
     */
    String[] getUserProductList();

    /**
     * Método encargado de cambiar al día siguiente.
     */
    void changeDay();

    /**
     * Método encargado de obtener los días con más productos vendidos.
     * @return Días con más productos vendidos.
     */
    String[] daysWithMoreSales();

    /**
     * Método encargado de obtener a los clientes que más han gastado en el supermercado.
     * @return Clientes que más han gastado en el supermercado.
     */
    String[] customersWhoHaveSpentMore();

    /**
     * Método que obtiene los productos que más se han vendido.
     * @return Productos más vendidos.
     */
    String[] bestSellingProduct();

    /**
     * Método que obtiene los productos que menos se han vendido.
     * @return Productos menos vendidos.
     */
    String[] leastSoldProduct();

    /**
     * Método que obtiene a los usuarios que más puntos tienen del sistema.
     * @return Usuarios que más puntos tienen del sistema.
     */
    String[] customersWithMorePoints();

    /**
     * Método encargado de cerrar la sesión del usuario.
     */
    void logout();

    boolean existCustomer(String rut);

    boolean validateEmail(String email);

}
