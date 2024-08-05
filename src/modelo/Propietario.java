package modelo;

/**
 *
 * @author david
 */
public class Propietario {

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;

    public Propietario() {
    }

    public Propietario(String nombre, String apellido, String cedula, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String imprimir() {
        return "--------DATOS PROPIETATRIO--------\n"
                + "NOMBRE: " + getNombre() + "\n"
                + "APELLIDO: " + getApellido() + "\n"
                + "TELEFONO: " + getTelefono() + "\n"
                + "CEDULA: " + getCedula() + "\n";
    }
}
