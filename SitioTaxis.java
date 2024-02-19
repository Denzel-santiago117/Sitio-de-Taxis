import java.util.Scanner;
import models.Administrador;
import models.Chofer;
import models.Unidades;

public class SitioTaxis {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {

            System.out.println("Hola, bienvenido al sitio de taxis.");
            System.out.println("Por favor, ingresa al sistema.");
            System.out.println("1. Administrador");
            System.out.println("2. Chofer");
            System.out.println("3. Salir");


            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuChofer();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 3);
    }

    public static void menuAdministrador() {
        Administrador admin = new Administrador();

        while (true) {
            System.out.println("\nMenú de Administrador:");
            System.out.println("Por favor, selecciona una opción:");
            System.out.println("1. Alta de nueva unidad");
            System.out.println("2. Agregar chofer");
            System.out.println("3.- Asignar chofer a la unidad");
            System.out.println("4. Volver al menú principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese marca y matricula de la nueva unidad:");
                    String marca = scanner.next();
                    int matricula = scanner.nextInt();
                    admin.altaNuevaUnidad(marca, matricula);
                    break;

                case 2:
                    System.out.println("Ingrese el nombre del nuevo chofer:");
                    String nombreNuevoChofer = scanner.next();
                    System.out.println("Ingrese la capacidad máxima de eventos del nuevo chofer:");
                    int capacidadMaximaEventos = scanner.nextInt();
                    Chofer.altaNuevoChofer(nombreNuevoChofer, capacidadMaximaEventos);
                    break;
                case 3:
                    System.out.println("Seleccione la unidad a la que desea asignar un chofer:");
                    admin.mostrarListaUnidades();
                    int contador1 = scanner.nextInt();
                    if (contador1 >= 0 && contador1 < admin.unidades.size()) {
                        System.out.println("Seleccione el chofer que desea asignar a esta unidad:");
                        Chofer.ListaChoferes();
                        int contador2 = scanner.nextInt();
                        if (contador2 >= 0 && contador2 < Chofer.getNumChoferes()) {
                            admin.asignarChofer(admin.unidades.get(contador1), Chofer.getChofer(contador2));
                            System.out.println("Chofer asignado correctamente a la unidad.");
                        } else {
                            System.out.println("Índice de chofer no válido.");
                        }
                    } else {
                        System.out.println("Índice de unidad no válido.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void menuChofer() {
        Chofer chofer = null;

        while (true) {
            System.out.println("\nMenú de Chofer:");
            System.out.println("Por favor, seleccione una opción:");
            System.out.println("1. Seleccionar chofer");
            System.out.println("2. Registrar evento");
            System.out.println("3. Realizar arqueo");
            System.out.println("4. Volver al menú principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione el chofer:");
                    Chofer.ListaChoferes();
                    int indiceChofer = scanner.nextInt();
                    if (indiceChofer >= 0 && indiceChofer < Chofer.getNumChoferes()) {
                        chofer = Chofer.getChofer(indiceChofer);
                        System.out.println("Chofer seleccionado: " + chofer.getNombre());
                    } else {
                        System.out.println("Índice de chofer no válido.");
                    }
                    break;
                case 2:
                    if (chofer == null) {
                        System.out.println("Debes seleccionar un chofer antes de registrar un evento.");
                        break;
                    }
                    System.out.println("Ingrese la descripción del evento:");
                    String descripcionEvento = scanner.next();
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    chofer.registrarEvento(descripcionEvento);
                    break;
                case 3:
                    if (chofer == null) {
                        System.out.println("Debes seleccionar un chofer antes de realizar el arqueo.");
                        break;
                    }
                    System.out.println("Ingrese el total del arqueo:");
                    double totalArqueo = scanner.nextDouble();
                    chofer.arqueo(totalArqueo);
                    break;
                case 4:
                    return; // Salir del método y volver al menú principal
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}