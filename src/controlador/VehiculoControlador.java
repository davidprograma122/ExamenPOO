package controlador;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Vehiculo;

/**
 *
 * @author david
 */
public class VehiculoControlador {

//    VehiculoControlador VehiCon=new VehiculoControlador();

    ConexionBDD conexion = new ConexionBDD();
    com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    
    
    
    
    
    
    public void crearVehiculo(Vehiculo b) {
        try {
            String consultaSQL = "INSERT INTO vehiculos(veh_placa,veh_marca,veh_color,pro_id)VALUES(?,?,?,?);";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, b.getPlaca());
            ejecutar.setString(2, b.getMarca());
            ejecutar.setString(3, b.getColor());
            ejecutar.setInt(4, b.getIdPropietario());
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
    
    public ArrayList<Vehiculo> listarVehiculosPorCedula(String cedula) {
    ArrayList<Vehiculo> lista = new ArrayList<>();
    try {
        String consultaSQL = "SELECT * FROM vehiculos v, propietarios p WHERE p.pro_id=v.pro_id and pro_cedula =?;";
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(consultaSQL);
        pstmt.setString(1, cedula);
        ResultSet resultado = pstmt.executeQuery();
        while (resultado.next()) {
            Vehiculo v = new Vehiculo();
            v.setPlaca(resultado.getString("veh_placa"));
            v.setMarca(resultado.getString("veh_marca"));
            v.setColor(resultado.getString("veh_color"));
            lista.add(v);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    return lista;
}
    
    
//    public ArrayList<Vehiculo> listarVehiculos() {
//        ArrayList<Vehiculo> listarVehiculos = new ArrayList<>();
//        try {
//            String consultaSQL = "SELECT  veh_placa,veh_marca,veh_color from vehiculos;";
//            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
//            resultado = ejecutar.executeQuery();
//            while (resultado.next()) {
//                Vehiculo v = new Vehiculo();
//                v.setPlaca(resultado.getString("veh_placa"));
//                v.setMarca(resultado.getString("veh_marca"));
//                v.setColor(resultado.getString("veh_color"));
//                listarVehiculos.add(v);
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e);
//        }
//        return listarVehiculos;
//    }
    

}
