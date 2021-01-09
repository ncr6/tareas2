package entidades;
import javax.swing.JOptionPane;

public class Personal {
    private String dni = "00000000";
    private String nombres = "";
    private String apellidos = "";
    private int diaNac = 0;
    private int mesNac = 0;
    private int anioNac = 0;
    private int diaIngreso = 0;
    private int mesIngreso = 0;
    private int anioIngreso = 0;
    private float sueldoBasico = 0;
    private float bonoTiempoServicio = 0;

    public Personal(String dni, String nombres, String apellidos, int diaNac, int mesNac, int anioNac, int diaIngreso, int mesIngreso, int anioIngreso, float sueldoBasico){
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.diaNac = diaNac;
        this.mesNac = mesNac;
        this.anioNac = anioNac;
        this.diaIngreso = diaIngreso;
        this.mesIngreso = mesIngreso;
        this.anioIngreso = anioIngreso;
        this.sueldoBasico = sueldoBasico;
        setBonoTiempoServicio();
    }  
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDiaNac() {
        return diaNac;
    }

    public void setDiaNac(int diaNac) {
        if (diaNac <= 31){
            this.diaNac = diaNac;
        } else {
            JOptionPane.showMessageDialog(null, "Los meses no tienen más de 31 días", "Fecha inválida", 0);
        }
    }

    public int getMesNac() {
        return mesNac;
    }
    
    public void setMesNac(int mesNac) {
        if (mesNac <= 12){
            this.mesNac = mesNac;
        } else {
            JOptionPane.showMessageDialog(null, "No hay más de 12 meses", "Fecha inválida", 0);
        }
    }

    public int getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(int anioNac) {
        this.anioNac = anioNac;
    }

    public int getDiaIngreso() {
        return diaIngreso;
    }

    public void setDiaIngreso(int diaIngreso) {
        if (diaIngreso <= 31){
            this.diaIngreso = diaIngreso;
        } else {
            JOptionPane.showMessageDialog(null, "Los meses no tienen más de 31 días", "Fecha inválida", 0);
        }
    }

    public int getMesIngreso() {
        return mesIngreso;
    }

    public void setMesIngreso(int mesIngreso) {
        if (mesIngreso <= 12){
            this.mesIngreso = mesIngreso;
        } else {
            JOptionPane.showMessageDialog(null, "No hay más de 12 meses", "Fecha inválida", 0);
        }
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
        setBonoTiempoServicio();
    }

    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
        setBonoTiempoServicio();
    }

    public float getBonoTiempoServicio() {
        return bonoTiempoServicio;
    }

    private void setBonoTiempoServicio() {
        int aniosLab = 2020-anioIngreso;
        if (aniosLab<4){
            bonoTiempoServicio = sueldoBasico * 0.05f;
        } else if (aniosLab<8){
            bonoTiempoServicio = sueldoBasico * 0.1f;
        } else if (aniosLab<16){
            bonoTiempoServicio = sueldoBasico * 0.15f;
        } else {
            bonoTiempoServicio = sueldoBasico * 0.2f;
        }
    }
        
    public void ajustarBono() {
        setBonoTiempoServicio();
    }
    
    @Override
    public String toString(){
        float sTotal = getSueldoBasico() + getBonoTiempoServicio();
        return "\n[DATOS DEL EMPLEADO]\nApellidos: "+getApellidos()+"\nNombres: "+getNombres()+
                "\nDNI: "+getDni()+"\nFecha de nacimiento: "+getDiaNac()+"/"+getMesNac()+"/"+getAnioNac()+
                "\nFecha de ingreso:"+getDiaIngreso()+"/"+getMesIngreso()+"/"+getAnioIngreso()+"/"+
                "\nSueldo básico: S/ "+getSueldoBasico()+"\nBonificación por T.S.: S/ "+getBonoTiempoServicio()+
                "\nSueldo total: S/ "+sTotal;
    }

}
