import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlRegistro controlRegistro = new ControlRegistro();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Registro de Computadores ---");
            System.out.println("1. Registrar entrada de computador");
            System.out.println("2. Registrar salida de computador");
            System.out.println("3. Mostrar todos los registros");
            System.out.println("4. Mostrar computadores activos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarEntrada(controlRegistro, scanner);
                    break;
                case 2:
                    registrarSalida(controlRegistro, scanner);
                    break;
                case 3:
                    controlRegistro.mostrarRegistros();
                    break;
                case 4:
                    controlRegistro.mostrarActivos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void registrarEntrada(ControlRegistro controlRegistro, Scanner scanner) {
        System.out.print("Ingrese la marca del computador: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del computador: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el número de serial del computador: ");
        String serial = scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario: ");
        String propietario = scanner.nextLine();

        Computador computador = new Computador(marca, modelo, serial, propietario);
        controlRegistro.registrarEntrada(computador);
    }

    private static void registrarSalida(ControlRegistro controlRegistro, Scanner scanner) {
        System.out.print("Ingrese el número de serial del computador para registrar su salida: ");
        String serial = scanner.nextLine();
        controlRegistro.registrarSalida(serial);
    }
}


