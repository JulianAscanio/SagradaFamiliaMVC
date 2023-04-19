package modelo;

public class Feligres {
    
    private String cedula;
    private String nombre;
    private String direcion;
    private String telefono;
    private int estrato;
    public String estado;

    public Feligres() {
    }

    public Feligres(String cedula, String nombre, String direcion, String telefono, int estrato, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direcion = direcion;
        this.telefono = telefono;
        this.estrato = estrato;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public double controlDiezmo(){
        double diezmo = 0;
        if (estrato == 1) {
            diezmo = 250000;
        }else if (estrato == 2 || estrato == 3) {
            diezmo = 500000;
        }else if (estrato > 3) {
            diezmo = 1000000;
        }
        
        return diezmo;
        
    }

}
