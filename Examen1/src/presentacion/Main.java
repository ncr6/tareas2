package presentacion;
import entidades.*;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    
    public static int menu(){
        int opcion;
        String mensajeMenu = "Seleccione una opcion del menú:" +
                             "\n1. Registrar personal"+
                             "\n2. Registrar cliente"+
                             "\n3. Registrar venta."+
                             "\n4. Listar datos de clientes por DNI ascendente."+
                             "\n5. Listar ventas por cliente."+
                             "\n6. Listar personal por apellido."+
                             "\n7. Salir."+
                             "\nIngrese su opción:";
        String mensajeInvalido = "La opción ingresada no es válida.\nPor favor inténtelo nuevamente.";
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeMenu, "Menú principal", 1));
            if (opcion<1 || opcion>7){
                JOptionPane.showMessageDialog(null, mensajeInvalido, "Opción inválida", 0);
            }
        } while (opcion<1 || opcion>7);
        
        return opcion;
    }
    
    public static boolean confirmarSesion(){
        boolean confirmado = false;
        int resultado = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION){
            confirmado = true;
        } else if (resultado == JOptionPane.NO_OPTION){
            confirmado = false;
        }
        return confirmado;
    }
    
    public static int validarInputDia(String diaDe, String registroDe){
        int dia = 0;
        do{
            dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de "+diaDe, "Registro de "+registroDe, 3));
            if (dia<1 || dia>31){
                JOptionPane.showMessageDialog(null, "Los meses no tienen más de 31 días ni menos de 1.\nPor favor revise los datos e intentelo nuevamente.", "Fecha inválida", 0);
            }
        } while (dia<1 || dia>31);
        return dia;
    }
    
    public static int validarInputMes(String mesDe, String registroDe){
        int mes = 0;
        do{
            mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de "+mesDe, "Registro de "+registroDe, 3));
            if (mes<1 || mes>12){
                JOptionPane.showMessageDialog(null, "Los años no tienen más de 12 meses ni menos de 1.\nPor favor revise los datos e intentelo nuevamente.", "Fecha inválida", 0);
            }
        } while (mes<1 || mes>12);
        return mes;
    }
    
    public static void listarAscendente(Cliente[] arreglo, int pos){
        String[] datos = new String[pos+1];
        String mensaje = "Los datos de clientes, de manera ascendente son:";
        for (int i=0; i<=pos; i++){
            datos[i] = arreglo[i].toString();
        }
        Arrays.sort(datos);
        for (int i=0; i<=pos; i++){
            mensaje += datos[i]+"\n";
        }
        JOptionPane.showMessageDialog(null, mensaje, "Resultados",1);
    }
    
    public static void listarDescendente(Personal[] arreglo, int pos){
        String[] datos = new String[pos+1];
        String mensaje = "Los datos de personal, de manera descendente son:";
        for (int i=0; i<=pos; i++){
            datos[i] = arreglo[i].toString();
        }
        Arrays.sort(datos);
        for (int i=pos; i>=pos; i--){
            mensaje += datos[i]+"\n";
        }
        JOptionPane.showMessageDialog(null, mensaje, "Resultados",1);             
    }
    
    public static void main(String[] args) {
        int opc, posC = -1, posE = -1, posV = -1;
        boolean continuar = true;
        
        JOptionPane.showMessageDialog(null, "Este programa simula un registro de datos de una empresa", "Bienvenido", 1);
        
        final int TAM = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamaño máximo de posiciones de memoria:", "Configurar memoria", 3));
        Cliente[] clientes = new Cliente[TAM];
        Personal[] empleados = new Personal[TAM];
        Venta[] ventas = new Venta[TAM];
        
        do{
            opc = menu();
            switch (opc){
                case 1 -> {
                    if (posE < TAM-1){
                        String dni  = JOptionPane.showInputDialog(null, "Ingrese el DNI del Trabajador:", "Registro de personal", 3);
                        String nombre  = JOptionPane.showInputDialog(null, "Ingrese el nombre del Trabajador:", "Registro de personal", 3);
                        String apellido  = JOptionPane.showInputDialog(null, "Ingrese el apellido del Trabajador:", "Registro de personal", 3);
                        int diaN = validarInputDia("nacimiento:", "personal");
                        int mesN = validarInputMes("nacimiento:", "personal");
                        int anioN = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento:", "Registro de personal", 3));
                        int diaI = validarInputDia("ingreso:", "personal");
                        int mesI = validarInputMes("ingreso:", "personal");
                        int anioI = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de ingreso:", "Registro de personal", 3));
                        int sbasico = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el sueldo básico del trabajador:", "Registro de personal", 3));
                        posE++;                        
                        empleados[posE] = new Personal(dni, nombre, apellido, diaN, mesN, anioN, diaI, mesI, anioI, sbasico);
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro de empleados está lleno.\nNo se pueden añadir más trabajadores.","Memoria llena",0);
                    }
                    continuar = confirmarSesion(); break;
                }
                case 2 -> {
                    if (posC < TAM-1){
                        int diaI = validarInputDia("registro:", "cliente");
                        int mesI = validarInputMes("registro:", "cliente");
                        int anioI = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de registro:", "Registro de cliente", 3));
                        String dni  = JOptionPane.showInputDialog(null, "Ingrese el DNI del Cliente:", "Registro de cliente", 3);
                        String nombre  = JOptionPane.showInputDialog(null, "Ingrese el nombre del Cliente:", "Registro de cliente", 3);
                        String apellido  = JOptionPane.showInputDialog(null, "Ingrese el apellido del Cliente:", "Registro de cliente", 3);
                        String direccion  = JOptionPane.showInputDialog(null, "Ingrese la dirección del Cliente:", "Registro de cliente", 3);
                        String telefono  = JOptionPane.showInputDialog(null, "Ingrese el teléfono del Cliente:", "Registro de cliente", 3);                        
                        posC++;                        
                        clientes[posC] = new Cliente(diaI, mesI, anioI, dni, nombre, apellido, direccion, telefono);
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro de clientes está lleno.\nNo se pueden añadir más trabajadores.","Memoria llena",0);
                    }
                    continuar = confirmarSesion(); break;
                }
                case 3 -> {
                    if (posC != -1 && posE != -1){
                        if (posV < TAM-1){
                            boolean clienteExists = false, vendedorExists = false;
                            String dniC  = JOptionPane.showInputDialog(null, "Ingrese el DNI del Cliente:", "Registro de venta", 3);
                            for (int i=0; i<= posC; i++){
                                if (clientes[i].getDni().equals(dniC)) clienteExists = true;
                            }
                            if (clienteExists){
                                String dniV  = JOptionPane.showInputDialog(null, "Ingrese el DNI del Vendedor:", "Registro de venta", 3);
                                for (int i=0; i<= posE; i++){
                                    if (empleados[i].getDni().equals(dniV)) vendedorExists = true;
                                }
                                if (vendedorExists){
                                    int diaV = validarInputDia("venta:", "venta");
                                    int mesV = validarInputMes("venta:", "venta");
                                    int anioV = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de registro:", "Registro de venta", 3));
                                    float monto = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto total de la venta:", "Registro de venta", 3));     
                                    posV++;
                                    ventas[posV] = new Venta(diaV, mesV, anioV, dniC, dniV, monto);    
                                } else {
                                    JOptionPane.showMessageDialog(null, "El DNI ingresado no corresponde a ningún vendedor ingresado", "DNI inválido", 0);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El DNI ingresado no corresponde a ningún cliente ingresado", "DNI inválido", 0);
                            } 
                        } else {
                            JOptionPane.showMessageDialog(null, "El registro de ventas está lleno.\nNo se pueden añadir más trabajadores.","Memoria llena",0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro de empleados o clientes está vacío.\nPor favor registre al menos 1 cliente y 1 vendedor\npara poder proceder con la venta.", "Registros vacíos", 2);
                    }
                    continuar = confirmarSesion(); break;             
                }
                case 4 -> {
                    listarAscendente(clientes, posC);
                    continuar = confirmarSesion(); break;                
                }
                case 5 -> {
                    String msj = "";
                    boolean clienteExists = false, vendedorExists = false;
                    String dniC  = JOptionPane.showInputDialog(null, "Ingrese el DNI del Cliente:", "Listado de compras del cliente", 3);
                    for (int i=0; i<= posC; i++){
                        if (clientes[i].getDni().equals(dniC)) clienteExists = true;
                    }
                    if (clienteExists){
                        for (int i = 0; i<= posV; i++){
                            if (dniC.equals(ventas[i].getDniCliente())){
                                msj += ventas[i].toString();
                            }
                        }
                        JOptionPane.showMessageDialog(null, msj, "Resultados del listado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "El DNI ingresado no corresponde a ningún cliente.", "Entrada inválida", 2);
                    }
                    
                    continuar = confirmarSesion(); break;
                }
                case 6 -> {
                    listarDescendente(empleados, posE);
                    continuar = confirmarSesion(); break;
                }
                case 7 -> {
                    continuar = false;
                    break;
                }
            }
        } while (continuar);
        
        JOptionPane.showMessageDialog(null, "Gracias por utilizar este programa.", "Hasta luego", 1);
        
    }
}
