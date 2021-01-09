package entidades;

public class Venta {
    private int diaCompra;
    private int mesCompra;
    private int anioCompra;
    private String dniCliente;
    private String dniVendedor;
    private float monto;
    
    public Venta(int diaCompra, int mesCompra, int anioCompra, String dniCliente, String dniVendedor, float monto){
        this.diaCompra = diaCompra;
        this.mesCompra = mesCompra;
        this.anioCompra = anioCompra;
        this.dniCliente = dniCliente;
        this.dniVendedor = dniVendedor;
        this.monto = monto;
        
    }
    
    public int getDiaCompra() {
        return diaCompra;
    }

    public void setDiaCompra(int diaCompra) {
        this.diaCompra = diaCompra;
    }

    public int getMesCompra() {
        return mesCompra;
    }

    public void setMesCompra(int mesCompra) {
        this.mesCompra = mesCompra;
    }

    public int getAnioCompra() {
        return anioCompra;
    }

    public void setAnioCompra(int anioCompra) {
        this.anioCompra = anioCompra;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniVendedor() {
        return dniVendedor;
    }

    public void setDniVendedor(String dniVendedor) {
        this.dniVendedor = dniVendedor;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    @Override
    public String toString(){
        return "[DATOS DE LA VENTA]\n"+"Fecha de venta: "+getDiaCompra()+"/"+getMesCompra()+"/"+getAnioCompra()+
               "\nDNI del Cliente: "+getDniCliente()+"\nDNI del Vendedor: "+getDniVendedor()+"\nMonto: S/"+getMonto();
    }
}
