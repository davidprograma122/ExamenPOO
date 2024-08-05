package modelo;

/**
 *
 * @author david
 */
public class Vehiculo {

    private int idPropietario;
    private String placa;
    private String marca;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(int idPropietario, String placa, String marca, String color) {
        this.idPropietario = idPropietario;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String imprimir() {
        return "--------DATOS PROPIETATRIO--------\n"
                + "PLACA: " + getPlaca() + "\n"
                + "MARCA: " + getMarca() + "\n"
                + "COLOR: " + getColor() + "\n";
    }

}
