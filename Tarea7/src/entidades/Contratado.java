package entidades;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class Contratado extends Personal implements BonoTServicio, Descuentos{
    private LocalDate fechaInicio = LocalDate.of(getAnioI(), getMesI(), getDiaI());
    private LocalDate fechaActual = LocalDate.now();
    private Period tiempoTrabajo = Period.between(fechaInicio,fechaActual);
    private int aniosTrab = tiempoTrabajo.getYears();
    
    public Contratado(String dni, String nombre, String apellido, int diaI, int mesI, int anioI){
        super(dni, nombre, apellido, diaI, mesI, anioI);
        ajustarSueldoTotal();
    }
    
    public Contratado(String dni, String nombre, String apellido, int diaI, int mesI, int anioI, float sueldoBasico){
        super(dni, nombre, apellido, diaI, mesI, anioI, sueldoBasico);
        ajustarSueldoTotal();
    }
    
    @Override
    public float calcularBono(){
        if (aniosTrab<4){
            return getSueldoBasico() * PCT03;
        } else if (aniosTrab<8){
            return getSueldoBasico() * PCT47;
        } else if (aniosTrab<16){
            return getSueldoBasico() * PCT815;
        } else {
            return getSueldoBasico() * PCT16M;
        }
    }
    
    @Override
    public final void ajustarSueldoTotal(){
        setSueldoTotal(getSueldoBasico()+calcularBono()-getDescuento());
    }
    
    @Override
    public float dFaltas(){
        float diasF = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el número de días de inasistencia: \n" +
                    "Descuentos por faltas"));
        //Se asume que se desea realizar un descuento por faltas del mes anterior
        return (diasF/(fechaActual.minusMonths(1).lengthOfMonth()))*SBASICO;
        
    }
    
    @Override
    public float dTardanzas(){
        float minT = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el número de minutos de tardanza: \n" +
                    "Descuentos por tardanzas"));
        //Se asume que se desea realizar un descuento por tardanzas del mes anterior
        return (minT/(fechaActual.minusMonths(1).lengthOfMonth()*1440))*SBASICO;
    }
    
    public float calcularDescuentos(){
        float descuentos = dFaltas()+dTardanzas();
        setDescuento(descuentos);
        ajustarSueldoTotal();
        return descuentos;
    }
    
    @Override
    public String toString(){
        return "\nApellido: " + getApellido() + "\nNombre: " + getNombre() +
                "\nDNI: " + getDni()+ "\nTrabajador desde: " + getDiaI() + "/" + getMesI() + "/" +
                getAnioI() + "\nSueldo básico: S/ " + String.format("%.2f",getSueldoBasico()) + "\nBono por Tiempo de Servicio: S/ " +
                String.format("%.2f",calcularBono()) + "\nDescuentos por tardanza/falta: -S/ " + String.format("%.2f",getDescuento()) +
                "\nSueldo total: S/ "+String.format("%.2f",getSueldoTotal());
    }

}
