import ucn.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        DumboSystem system = new DumboSystemImpl();
        readFiles(system);
        mainMenu(system);



    }

    /**
     * Subprograma que se encarga de leer los archivos de texto del taller y llamar a los métodos del sistema para agregarlos a sus listas.
     * @param system Corresponde al llamado del sistema para utilizar los métodos del sistemaImpl.
     * @throws IOException Corresponde a la exepción que ve el estado de la lectura de los archivos.
     */
    private static void readFiles(DumboSystem system) throws IOException {

        ArchivoEntrada arch1;

        while (true){
            try{
                arch1 = new ArchivoEntrada("clientes.txt");
                break;
            }catch (Exception e) {
                StdOut.println("No se encontró el archivo.");
            }
        }

        while (!arch1.isEndFile()) {
            Registro regEnt = arch1.getRegistro();
            try {
                String name = regEnt.getString();
                String rut = regEnt.getString();
                int age = regEnt.getInt();
                String password = regEnt.getString();
                String email = regEnt.getString();
                int points = regEnt.getInt();
                String type = regEnt.getString();
                if (system.addNewUser(name, rut, age, password, email, points, type)) {
                    StdOut.println(name + " agregado correctamente!");
                }else{
                    StdOut.print(name + " no se pudo agregar.");
                }
            } catch (Exception e) {
                StdOut.print("[!] USUARIO CON CAMPOS INVÁLIDOS [!]");
            }
        }
        ArchivoEntrada arch2 = new ArchivoEntrada("productos.txt");
        while (!arch2.isEndFile()) {
            Registro regEnt = arch2.getRegistro();
            try {
                String name = regEnt.getString();
                String EANCode = regEnt.getString();
                int price = regEnt.getInt();
                int stock = regEnt.getInt();
                String type = regEnt.getString();

                switch (type) {
                    case "Aseo" -> {
                        String personal = regEnt.getString();
                        system.addNewAseo(name, EANCode, price, stock, !personal.equals("no"));
                    }
                    case "Abarrotes" -> {
                        int stamps = regEnt.getInt();
                        int weight = regEnt.getInt();
                        system.addNewAbarrotes(name, EANCode, price, stock, stamps, weight);
                    }
                    case "Menaje" -> {
                        String clothes = regEnt.getString();
                        if (clothes.equals("si")) {
                            String size = regEnt.getString();
                            system.addNewMenaje(name, EANCode, price, stock, true, size);
                        } else system.addNewMenaje(name, EANCode, price, stock, false, "0");
                    }
                    case "Botilleria" -> {
                        int stamps = regEnt.getInt();
                        String alcohol = regEnt.getString();
                        system.addNewBotilleria(name, EANCode, price, stock, stamps, alcohol.equals("si"));
                    }
                    default -> StdOut.println("¡PRODUCTO NO AGREGADO!");
                }
            } catch (Exception e) {
                StdOut.print("[!] PRODUCTO CON CAMPOS INVÁLIDOS [!]");
            }
        }
    }
    /**
     * Subprograma que se encarga de manejar el menú principal del sistema.
     * @param system Corresponde al llamado del sistema para utilizar los métodos del sistemaImpl.
     */
    public static void mainMenu(DumboSystem system){

        String option = null;
        while (!Objects.equals(option, "6")){

            StdOut.println("\n[*] Bienvenido a Dumbo [*]");
            StdOut.println("1) Iniciar Sesión");
            StdOut.println("2) Registrar nuevo cliente");
            StdOut.println("3) Estadísticas");
            StdOut.println("4) Ingresar nuevo producto");
            StdOut.println("5) Cambiar día de la semana");
            StdOut.println("6) Salir del sistema");
            int optionInt;

            while (true) {
                try {
                    StdOut.print("Seleccione una opción: ");
                    option = StdIn.readLine();
                    optionInt = Integer.parseInt(option);
                    if (optionInt >= 1 && optionInt <= 6){
                        break;
                    }else{
                        StdOut.println("\nValor ingresado no valido!");
                    }
                }
                catch (Exception e){
                    StdOut.println("\nValor ingresado no valido!");
                }
            }

            switch (option){
                case "1" -> login(system);
                case "2" -> registerCustomer(system);
                case "3" -> StdOut.println("3");
                case "4" -> StdOut.println("4");
                case "5" -> StdOut.println("5");
                case "6" -> StdOut.println("\nADIOS!");
            }
        }
    }
    /**
     * Subprograma que se encarga de manejar la opción de iniciar sesión del usuario, y derivarlo a los demás submenus.
     * @param system Corresponde al llamado del sistema para utilizar los métodos del sistemaImpl.
     */
    public static void login(DumboSystem system){
        StdOut.println("\n[*] Iniciar Sesión [*]");
        StdOut.print("Ingrese su correo: ");
        String email = StdIn.readLine();
        StdOut.print("Ingrese su contraseña: ");
        String password = StdIn.readLine();
        boolean userValidation = system.validateLogin(email,password);
        boolean supervisorValidation = system.validateLoginSupervisor(email,password);

        if(!userValidation){
            StdOut.println("No se pudo iniciar sesión, usuario inexistente o contraseña inválida");
            return;
        }

        if (supervisorValidation){
            StdOut.println("[!]Supervisor " + email + ", no puede iniciar sesión para comprar[!]");
            return;
        }

        clientMenu(system);
    }
    /**
     * Subprograma que se encarga de manejar el menú del cliente logueado.
     * @param system Corresponde al llamado del sistema para utilizar los métodos del sistemaImpl.
     */
    public static void clientMenu(DumboSystem system){
        //GRACIAS JR7
        ArrayList<String> options = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        String option = null;
        while (!Objects.equals(option, "4")){
            StdOut.println("\n[*] Supermercado Dumbo [*]");
            StdOut.println("1) Ver pasillos");
            StdOut.println("2) Ver canasta");
            StdOut.println("3) Generar venta");
            StdOut.println("4) Cerrar sesión");
            StdOut.print("Ingrese una opción: ");
            option = StdIn.readLine();
            while (!options.contains(option)){
                StdOut.println("[!] OPCIÓN INVÁLIDA, INTENTELO NUEVAMENTE [!]");
                StdOut.print("Ingrese una opción: ");
                option = StdIn.readLine();
            }

            switch (option){
                case "1" -> displayAisle(system);
                case "2" -> displayClientCart(system);
                //case "3" -> generarVenta(sistema);
                case "4" -> system.logout();
            }
        }
    }
    /**
     * Subprograma que se encarga de desplegar el pasillo actual y desplegar el menú de compras del usuario.
     * @param system Corresponde al llamado del sistema para utilizar los métodos del sistemaImpl.
     */
    public static void displayAisle(DumboSystem system){
        int index = 0;
        String option = null;

        while (!Objects.equals(option, "4")) {

            if (index == -1){
                index = 3;
            }

            if (index == 4){
                index = 0;
            }

            String[] aisle = system.getProductList(index);
            for (String s : aisle) {
                StdOut.println(s);
            }
            StdOut.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            StdOut.println("1) Comprar producto");
            StdOut.println("2) Siguiente pasillo");
            StdOut.println("3) Anterior pasillo");
            StdOut.println("4) Volver al menú principal");
            StdOut.print("Ingrese una opción: ");
            option = StdIn.readLine();

            while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")) {
                StdOut.println("[!] OPCIÓN INVÁLIDA, INTENTELO NUEVAMENTE [!]");
                StdOut.print("Ingrese una opción: ");
                option = StdIn.readLine();
            }

            switch (option) {
                case "1" -> buyProduct(system);
                case "2" -> index++;
                case "3" -> index--;
                case "4" -> StdOut.println("\nVolviendo al menú anterior.");
            }
        }

    }
    /**
     * Subprograma que se encarga de la lógica de comprar un producto.
     * @param system Corresponde al llamado del sistema para utilizar los métodos del sistemaImpl.
     */
    public static void buyProduct(DumboSystem system){
        StdOut.println("\n[*] Comprar un producto [*]");
        StdOut.print("Ingrese el código del producto a comprar: ");
        String EANCode = StdIn.readLine();

        if (system.buyProduct(EANCode)){
            StdOut.println("¡Producto añadido a la canasta!");
        }else{
            StdOut.println("Producto no encontrado.");
        }
    }

    public static void displayClientCart(DumboSystem system) {
        while (true) {
            StdOut.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nCanasta: ");
            String[] canasta = system.getUserProductList();
            for (String s : canasta) {
                StdOut.println(s);
            }
            StdOut.println("1) Eliminar producto");
            StdOut.println("2) Volver al menú anterior");
            StdOut.print("Seleccione una opción: ");
            String opcion = StdIn.readString();

            while (!Objects.equals(opcion, "1") && !Objects.equals(opcion, "2")) {
                StdOut.println("OPCIÓN INVÁLIDA, INGRESELA NUEVAMENTE.");
                StdOut.print("Seleccione una opción: ");
                opcion = StdIn.readString();
            }

            if (opcion.equals("1")) {
                StdOut.println("Ingrese el código del producto a eliminar: ");
                String codigo = StdIn.readLine();
                StdOut.println("Ingrese la cantidad a eliminar: ");
                String cantidadStr = StdIn.readLine();
                int cantidad;

                while (true) {
                    try {
                        cantidad = Integer.parseInt(cantidadStr);
                        if (cantidad > 0){
                            if (system.returnProduct(codigo, cantidad)){
                                StdOut.println("Producto eliminado con éxito!");
                            }else{
                                StdOut.println("Código no encontrado!");
                            }
                            break;
                        }

                    }catch (Exception e){
                        StdOut.println("CANTIDAD INVÁLIDA. INGRESELA NUEVAMENTE.");
                        StdOut.print("Ingrese la cantidad a eliminar: ");
                        cantidadStr = StdIn.readLine();
                    }
                }
            }else{
                break;
            }
        }
    }

    public static void registerCustomer(DumboSystem system){

        StdOut.println("\n[*] Registrar nuevo cliente [*]");
        StdOut.print("Ingrese su correo: ");
        String emailSuper = StdIn.readLine();
        StdOut.print("Ingrese su contraseña: ");
        String passwordSuper = StdIn.readLine();

        if(!system.validateLoginSupervisor(emailSuper, passwordSuper)){
            StdOut.println("[!] Usted no cuenta con permisos de supervisor [!]");
            return;
        }

        StdOut.print("Ingrese el rut del nuevo cliente: ");
        String rut = StdIn.readLine();

        if(!system.existCustomer(rut)){
            StdOut.println("Rut ya perteneciente a otro cliente");
            return;
        }

        StdOut.print("Ingrese el nombre y apellido del nuevo cliente: ");
        String name = StdIn.readLine();

        int age;
        while (true){
            try{
                StdOut.println("Ingrese la edad del nuevo cliente: ");
                String ageStr = StdIn.readLine();
                age = Integer.parseInt(ageStr);
                break;
            }catch (Exception e){
                StdOut.println("EDAD INVÁLIDA");
            }
        }

        String password;
        while (true){
            try{
                StdOut.println("Ingrese la contraseña del nuevo cliente: ");
                password = StdIn.readLine();
                if (system.validatePassword(password)){
                    break;
                }
            }catch (Exception e){
                StdOut.print("[!] La contraseña no cumple con los requisitos [!]");
            }
        }

        String email;
        while (true){
            try{
                StdOut.println("Ingrese el correo electrónico del nuevo cliente: ");
                email = StdIn.readLine();
                if (system.validateEmail(email)){
                    break;
                }
            }catch (Exception e){
                StdOut.print("[!] El correo no cumple con los requisitos [!]");
            }
        }

        String type = null;
        while (!Objects.equals(type, "Estandar") && !Objects.equals(type, "Premium")){
            StdOut.println("Ingrese su tipo de membresía (Estandar o Premium): ");
            type = StdIn.readLine();
        }

        if (system.addNewUser(name, rut, age, password, email, 0, type)){
            StdOut.println("¡Usuario registrado con éxito!");
        }else {
            StdOut.println("[!] Error, no se ha podido agregar el usuario al sistema [!]");
        }
    }
}
