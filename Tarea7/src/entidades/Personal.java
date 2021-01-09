package entidades;
import javax.swing.JOptionPane;

public abstract class Personal {
    private String dni = "00000000";
    private String nombre = "";
    private String apellido = "";
    private int diaI = 0;
    private int mesI = 0;
    private int anioI = 0;
    private float sueldoBasico = 930.0f;
    private float sueldoTotal = 0.0f;
    private float descuento = 0.0f;

    public Personal(String dni, String nombre, String apellido, int diaI, int mesI, int anioI){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.diaI = diaI;
        this.mesI = mesI;
        this.anioI = anioI;
    }  
    
    public Personal(String dni, String nombre, String apellido, int diaI, int mesI, int anioI, float sueldoBasico){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.diaI = diaI;
        this.mesI = mesI;
        this.anioI = anioI;
        this.sueldoBasico = sueldoBasico;
    }     
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public int getDiaI() {
        return diaI;
    }

    public void setDiaI(int diaI) {
        if (diaI <= 31){
            this.diaI = diaI;
        } else {
            JOptionPane.showMessageDialog(null, "Los meses no tienen más de 31 días", "Fecha inválida", 0);
        }
    }

    public int getMesI() {
        return mesI;
    }

    public void setMesI(int mesI) {
        if (mesI <= 12){
            this.mesI = mesI;
        } else {
            JOptionPane.showMessageDialog(null, "No hay más de 12 meses", "Fecha inválida", 0);
        }
    }

    public int getAnioI() {
        return anioI;
    }

    public void setAnioI(int anioI) {
        this.anioI = anioI;
    }
    
    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    } 
    
    public float getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(float sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    public abstract void ajustarSueldoTotal();
    
    @Override
    public String toString(){
        return "\nDNI: " + getDni() + "\nNombre: " + getNombre() +
                "\nApellido: " + getApellido()+ "\nTrabajador desde:" + getDiaI() + "/" +
                getMesI() + "/" + getAnioI();
    }

}
