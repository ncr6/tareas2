package entidades;

import javax.swing.JOptionPane;

public class Cliente {
    private int diaReg = 0;
    private int mesReg = 0;
    private int anioReg = 0;
    private String dni = "00000000";
    private String nombres = "";
    private String apellidos = "";
    private String direccion = "";
    private String telefono = "";

    public Cliente(int diaReg, int mesReg, int anioReg, String dni, String nombres, String apellidos, String direccion, String telefono) {
        this.diaReg = diaReg;
        this.mesReg = mesReg;
        this.anioReg = anioReg;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public int getDiaReg() {
        return diaReg;
    }

    public void setDiaReg(int diaReg) {
        if (diaReg <= 31){
            this.diaReg = diaReg;
        } else {
            JOptionPane.showMessageDialog(null, "Los meses no tienen más de 31 días", "Fecha inválida", 0);
        }
    }

    public int getMesReg() {
        return mesReg;
    }

    public void setMesReg(int mesReg) {
        if (mesReg <= 12){
            this.mesReg = mesReg;
        } else {
            JOptionPane.showMessageDialog(null, "No hay más de 12 meses", "Fecha inválida", 0);
        }
    }

    public int getAnioReg() {
        return anioReg;
    }

    public void setAnioReg(int anioReg) {
        this.anioReg = anioReg;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return "\n[DATOS DEL CLIENTE]\nDNI: "+getDni()+"\nNombres: "+getNombres()+"\nApellidos: "+
                getApellidos()+"\nDireccion: "+getDireccion()+"\nTeléfono: "+getTelefono()+
                "\nFecha de registro: "+getDiaReg()+"/"+getMesReg()+"/"+getAnioReg();
    }
}
