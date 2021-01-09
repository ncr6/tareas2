package presentacion;
import entidades.*;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static int menu(){
        int opcion;
        String mensajeMenu = "Seleccione una opcion del menú:" +
                             "\n1. Registrar personal contratado."+
                             "\n2. Registrar personal a destajo."+
                             "\n3. Listar datos de contratados por apellido (ascendente)."+
                             "\n4. Listar datos de personal a destajo por numero de clientes (desc)."+
                             "\n5. Modificar personal a destajo."+
                             "\n6. Salir."+
                             "\nIngrese su opción:";
        String mensajeInvalido = "La opción ingresada no es válida.\nPor favor inténtelo nuevamente.";
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeMenu, "Menú principal", 1));
            if (opcion<1 || opcion>6){
                JOptionPane.showMessageDialog(null, mensajeInvalido, "Opción inválida", 0);
            }
        } while (opcion<1 || opcion>6);
        
        return opcion;
    }
    
   public static boolean confirmar(String pregunta){
        boolean confirmado = false;
        int resultado = JOptionPane.showConfirmDialog(null, pregunta, "Confirmación", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION){
            confirmado = true;
        } else if (resultado == JOptionPane.NO_OPTION){
            confirmado = false;
        }
        return confirmado;
    }
   
    public static float validarInputPctj(){
        float pctj = 0;
        do{
            pctj = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el porcentaje de comisión (0-100):", "Registro de empleado a destajo", 3));
            if (pctj<0 || pctj>100){
                JOptionPane.showMessageDialog(null, "El porcentaje debe estar entre 0% y 100%.\nPor favor revise los datos e intentelo nuevamente.", "Porcentaje inválido", 0);
            }
        } while (pctj<0 || pctj>100);
        return pctj;
    }
        
    public static int validarInputDia(String registroDe){
        int dia = 0;
        do{
            dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de contrato:", "Registro de "+registroDe, 3));
            if (dia<1 || dia>31){
                JOptionPane.showMessageDialog(null, "Los meses no tienen más de 31 días ni menos de 1.\nPor favor revise los datos e intentelo nuevamente.", "Fecha inválida", 0);
            }
        } while (dia<1 || dia>31);
        return dia;
    }
    
    public static int validarInputMes(String registroDe){
        int mes = 0;
        do{
            mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de contrato:", "Registro de "+registroDe, 3));
            if (mes<1 || mes>12){
                JOptionPane.showMessageDialog(null, "Los años no tienen más de 12 meses ni menos de 1.\nPor favor revise los datos e intentelo nuevamente.", "Fecha inválida", 0);
            }
        } while (mes<1 || mes>12);
        return mes;
    }   
    
    public static void listarAscendente(Contratado[] arreglo, int pos){
        String[] datos = new String[pos+1];
        String mensaje;
        int cont = 0; //Contador que envia hasta 4 datos de trabajadores por JOptionPane
        if (pos>=0){
            mensaje = "Los datos de contratados, de manera ascendente (por apellido) son:";
            for (int i=0; i<=pos; i++){
                datos[i] = arreglo[i].toString();
            }
            Arrays.sort(datos);
            for (int i=0; i<=pos; i++){
                if (cont<4){ //Con el fin de una correcta visualizacion en pantalla
                    mensaje += datos[i]+"\n";
                    cont++;
                } else {
                    JOptionPane.showMessageDialog(null, mensaje, "Listado de contratados",1);
                    mensaje = "";
                    mensaje += datos[i]+"\n";
                    cont = 1;
                }
            }
            if (cont<=4){
                JOptionPane.showMessageDialog(null, mensaje, "Listado de contratados",1);
            }
        } else {
            mensaje = "No se han registrado contratados hasta el momento.";
            JOptionPane.showMessageDialog(null, mensaje, "Listado de contratados",1);
        }
    }
    
    public static void listarDecendente(ADestajo[] arreglo, int pos){
        ADestajo[] datos = new ADestajo[pos+1];
        String mensaje;
        int cont = 0; //Contador que envia hasta 3 datos de adestajos por JOptionPane
        if (pos>=0){
            mensaje = "Los datos de empleados a destajo, de manera decendiente (por clientes captados) son:";
            for (int i=0; i<=pos; i++){
                datos[i] = arreglo[i];
            }
            Arrays.sort(datos);
            for (int i=pos; i>=0; i--){
                if (cont<3){ //Con el fin de una correcta visualizacion en pantalla
                    mensaje += datos[i].toString()+"\n";
                    cont++;
                } else {
                    JOptionPane.showMessageDialog(null, mensaje, "Listado de trabajadores a destajo",1);
                    mensaje = "";
                    mensaje += datos[i].toString()+"\n";
                    cont = 1;
                }
            }
            if (cont<=3){
                JOptionPane.showMessageDialog(null, mensaje, "Listado de trabajadores a destajo",1);
            }
        } else {
            mensaje = "No se ha registrado personal a destajo hasta el momento.";
            JOptionPane.showMessageDialog(null, mensaje, "Listado de trabajadores a destajo",1);
        }
    }
   
    
    
    public static void main(String[] args) {
        int opc, posC = -1, posD = -1;
        boolean continuar = true;
        
        JOptionPane.showMessageDialog(null, "Este programa simula un registro de personal de una empresa", "Bienvenido", 1);
        
        final int TAM = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamaño máximo de posiciones de memoria:", "Configurar memoria", 3));
        Contratado[] contratados = new Contratado[TAM];
        ADestajo[] adestajo = new ADestajo[TAM];
        
        do{
            opc = menu();
            switch (opc){
                case 1 -> {
                    if (posC < TAM-1){
                        String dni  = JOptionPane.showInputDialog(null, "Ingrese el DNI del trabajador contratado:", "Registro de personal contratado", 3);
                        String nombre  = JOptionPane.showInputDialog(null, "Ingrese el nombre del trabajador contratado:", "Registro de personal contratado", 3);
                        String apellido  = JOptionPane.showInputDialog(null, "Ingrese el apellido del trabajador contratado:", "Registro de personal contratado", 3);
                        int diaI = validarInputDia("contratado");
                        int mesI = validarInputMes("contratado");
                        int anioI = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de ingreso:", "Registro de personal contratado", 3));
                        posC++;                        
                        contratados[posC] = new Contratado(dni, nombre, apellido, diaI, mesI, anioI);
                        if (confirmar("¿Desea registrar descuentos por faltas/tardanzas?")){
                            contratados[posC].calcularDescuentos();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro de trabajadores contratados está lleno.\nNo se pueden añadir más trabajadores.","Memoria llena",0);
                    }
                        continuar = confirmar("¿Desea realizar otra operación?"); break;
                }
                
                case 2 -> {
                    if (posC < TAM-1){
                        String dni  = JOptionPane.showInputDialog(null, "Ingrese el DNI del personal a destajo:", "Registro de personal a destajo", 3);
                        String nombre  = JOptionPane.showInputDialog(null, "Ingrese el nombre del personal a destajo:", "Registro de personal a destajo", 3);
                        String apellido  = JOptionPane.showInputDialog(null, "Ingrese el apellido del personal a destajo:", "Registro de personal a destajo", 3);                       
                        int diaI = validarInputDia("empleado a destajo");
                        int mesI = validarInputMes("empleado a destajo");
                        int anioI = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de registro:", "Registro de personal a destajo", 3));
                        int clientes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de clientes captados:", "Registro de personal a destajo", 3));
                        float montoVenta = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto total vendido por este trabajador:", "Registro de personal a destajo", 3));
                        float porcentaje = validarInputPctj()/100;
                        posD++;                        
                        adestajo[posD] = new ADestajo(dni, nombre, apellido, diaI, mesI, anioI, clientes, montoVenta, porcentaje);
                        if (confirmar("¿Desea registrar descuentos por faltas/tardanzas?")){
                            adestajo[posD].calcularDescuentos();
                        }                    
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro de trabajadores a destajo está lleno.\nNo se pueden añadir más trabajadores.","Memoria llena",0);
                    }
                    continuar = confirmar("¿Desea realizar otra operación?"); break;
                }
                
                case 3 -> {
                    listarAscendente(contratados, posC);
                    continuar = confirmar("¿Desea realizar otra operación?"); break;                
                }
                
                case 4 -> {
                    listarDecendente(adestajo, posD);
                    continuar = confirmar("¿Desea realizar otra operación?"); break;                
                }
                
                case 5 -> {
                    String msj = "";
                    boolean adestajoExists = false;
                    int adestajoPos = -1;
                    String dniD  = JOptionPane.showInputDialog(null, "Ingrese el DNI del Trabajador a Destajo:", "Modificar datos de trabajador a destajo", 3);
                    for (int i=0; i<= posD; i++){
                        if (adestajo[i].getDni().equals(dniD)){
                            adestajoExists = true;
                            adestajoPos = i;
                        }
                    }
                    if (adestajoExists){
                        //Modificacion de datos del ADestajo
                        if (confirmar("Procederá a modificar los datos de "+adestajo[adestajoPos].getNombre()+" "+adestajo[adestajoPos].getApellido()+"\n¿Desea continuar?")){
                            adestajo[adestajoPos].setClientes(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de clientes captados:", "Modificación de personal a destajo", 3)));
                            adestajo[adestajoPos].setMontoVentas(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto total vendido por este trabajador:", "Modificación de personal a destajo", 3)));
                            adestajo[adestajoPos].setPorcentaje(validarInputPctj()/100);
                        }                    
                    } else {
                        JOptionPane.showMessageDialog(null, "El DNI ingresado no corresponde a ningún trabajador a destajo.", "Entrada inválida", 2);
                    }
                    
                    continuar = confirmar("¿Desea realizar otra operación?"); break;
                }
                
                case 6 -> {
                    continuar = false;               
                }
            }
        } while (continuar);
        
        JOptionPane.showMessageDialog(null, "Gracias por utilizar este programa.", "Hasta luego", 1);
    }
}
