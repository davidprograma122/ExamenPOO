package vista;

import controlador.ConexionBDD;
import controlador.PropietarioControlador;
import controlador.VehiculoControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Propietario;
import modelo.Vehiculo;

/**
 *
 * @author david
 */
public class main {

    public static void main(String[] args) {
//         CONEXION A BASE DE DATOS
//        ConexionBDD cb = new ConexionBDD();
//        cb.conectar();
        VehiculoControlador VehiculoControlador = new VehiculoControlador();
        Scanner es = new Scanner(System.in);
        int op;

        while (true) {
            System.out.print("""
    |  ELIJA UNA OPCIÓN:                              |
    |-------------------------------------------------|
    |  OPCIONES:                                      |
    |   1. Insertar Datos                       |
    |   2. Listar Vehìculos de un Propietario         |   
    |   0. Salir del sistema                          |
      """.indent(30));

            System.out.print("Opción: ");
            op = es.nextInt();

            switch (op) {
                case 1:
                    // Lógica para insertar propietario
                    System.out.println("Ingrese los siguentes datos");
                    Propietario p = new Propietario();
                    System.out.print("Ingrese su nombre: ");
                    p.setNombre(es.next());
                    System.out.print("Ingrese su apellido: ");
                    p.setApellido(es.next());
                    System.out.print("Ingrese su cedula: ");
                    p.setCedula(es.next());
                    System.out.println("ingrese su número de telefono: ");
                    p.setTelefono(es.next());
                    PropietarioControlador pc = new PropietarioControlador();
                    pc.crearPropietario(p);

                    int idPropietario = pc.buscarIdPropietario(p.getCedula());
                    System.out.println("-------------------" + idPropietario);

                    System.out.println("Ingrese los siguentes datos del vehiculo");
                    Vehiculo v = new Vehiculo();

                    System.out.print("Ingrese la placa: ");
                    v.setPlaca(es.next());
                    System.out.print("Ingrese la marca: ");
                    v.setMarca(es.next());
                    System.out.print("Ingrese el color: ");
                    v.setColor(es.next());
                    v.setIdPropietario(idPropietario);

                    VehiculoControlador vC = new VehiculoControlador();
                    vC.crearVehiculo(v);

                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ingrese la cédula del propietario: ");
                    String cedula = scanner.nextLine();

                    ArrayList<Vehiculo> listarVehiculos = VehiculoControlador.listarVehiculosPorCedula(cedula);

                    for (Vehiculo vh : listarVehiculos) {
                        System.out.println(vh.imprimir());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        }
    }
}
