package entidades;

import static entidades.Descuentos.SBASICO;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ADestajo extends Personal implements Descuentos, Comparable<ADestajo> {
    private int clientes = 0;
    private float montoVentas = 0.0f;
    private float porcentaje = 0.0f;
    private LocalDate fechaActual = LocalDate.now();
    
    public ADestajo(String dni, String nombre, String apellido, int diaI, int mesI, int anioI, int clientes, float montoVentas, float porcentaje){
        super(dni, nombre, apellido, diaI, mesI, anioI);
        this.clientes = clientes;
        this.montoVentas = montoVentas;
        this.porcentaje = porcentaje;
        ajustarSueldoTotal();
    }
    
    public ADestajo(String dni, String nombre, String apellido, int diaI, int mesI, int anioI, int clientes, float montoVentas, float porcentaje, float sueldoBasico){
        super(dni, nombre, apellido, diaI, mesI, anioI, sueldoBasico);
        this.clientes = clientes;
        this.montoVentas = montoVentas;
        this.porcentaje = porcentaje;
        ajustarSueldoTotal();
    }
    
    public int getClientes() {
        return clientes;
    }

    public void setClientes(int clientes) {
        this.clientes = clientes;
    }

    public float getMontoVentas() {
        return montoVentas;
    }

    public void setMontoVentas(float montoVentas) {
        this.montoVentas = montoVentas;
        ajustarSueldoTotal();
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
        ajustarSueldoTotal();
    }
    
    public float calcularComision(){
        return montoVentas * porcentaje;
    }
    
    @Override
    public final void ajustarSueldoTotal(){
        setSueldoTotal(getSueldoBasico()+calcularComision()-getDescuento());
    }
    
    @Override
    public float dFaltas(){
        float diasF = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el número de días de inasistencia: \n" +
                    "Descuentos por faltas"));
        //Se asume que al ser un empleado a destajo, se calculan sus faltas en el mismo mes
        return (diasF/(fechaActual.lengthOfMonth()))*SBASICO;
        
    }
    
    @Override
    public float dTardanzas(){
        float minT = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el número de minutos de tardanza: \n" +
                    "Descuentos por tardanzas"));
        //Se asume que al ser un empleado a destajo, se calculan sus tardanzas en el mismo mes
        return (minT/(fechaActual.lengthOfMonth()*1440))*SBASICO;
    }
    
    public float calcularDescuentos(){
        float descuentos = dFaltas()+dTardanzas();
        setDescuento(descuentos);
        ajustarSueldoTotal();
        return descuentos;
    }
    
    @Override
    public String toString(){
        return "\nClientes captados: " + getClientes() + 
                "\nMonto vendido: S/ " + String.format("%.2f",getMontoVentas()) + "\nDNI: " + getDni() +
                "\nNombre: " + getNombre() + "\nApellido: " + getApellido() +
                "\nTrabajador desde: " + getDiaI() + "/" + getMesI() + "/" + getAnioI() +
                "\nSueldo básico: S/ "+ String.format("%.2f",getSueldoBasico()) +
                "\nPorcentaje de comisión: " + getPorcentaje()*100 +"%" + "\nComisión: S/ " + String.format("%.2f",calcularComision()) +
                "\nDescuentos por tardanza/falta: -S/ " + String.format("%.2f",getDescuento()) +
                "\nSueldo total: S/ "+String.format("%.2f",getSueldoTotal());
    }
    
    @Override
    public int compareTo(ADestajo otro){
        if(this.getClientes() > otro.getClientes())
            return 1;
        else if (this.getClientes() == otro.getClientes())
            return 0;
        return -1;
    }

}
