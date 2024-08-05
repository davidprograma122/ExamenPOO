package controlador;

import com.sun.jdi.connect.spi.Connection;
import modelo.Propietario;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author david
 */
public class PropietarioControlador {

    ConexionBDD conexion = new ConexionBDD();
    com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void crearPropietario(Propietario p) {
        try {
            String consultaSQL = "INSERT INTO examenpoo.propietarios(pro_nombre,pro_apellido,pro_cedula,pro_telefono)VALUES(?,?,?,?);";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, p.getNombre());
            ejecutar.setString(2, p.getApellido());
            ejecutar.setString(3, p.getCedula());
            ejecutar.setString(4, p.getTelefono());
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Se ha creado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR1: " + e);
        }
    }
    public int buscarIdPropietario(String cedula){
        try {
            String consultaSQL="SELECT  pro_id FROM propietarios WHERE pro_cedula='"+cedula+"';";
            ejecutar =(PreparedStatement)connection.prepareCall(cedula);
            ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            resultado=ejecutar.executeQuery();
            if (resultado.next()){
                int idPersona = resultado.getInt("pro_id");
                return idPersona;
            }else {
                System.out.println("Ingrese una cedula valida");
            }
            
        } catch (Exception e) {
            System.out.println("Error2, comuniquese con el administrador"+e);
        }
        return 0;
    }
    
}
