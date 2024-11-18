import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ControlRegistro {
    private ArrayList<Registro> registros;

    public ControlRegistro() {
        registros = new ArrayList<>();
    }

    public void registrarEntrada(Computador computador) {
        String fecha = obtenerFechaActual();
        RegistroEntrada registroEntrada = new RegistroEntrada(computador, fecha);
        registros.add(registroEntrada);
        System.out.println("Entrada registrada para el computador con serial: " + computador.getSerial());
    }

    public void registrarSalida(String serial) {
        Computador computador = buscarComputadorActivo(serial);
        if (computador != null) {
            String fecha = obtenerFechaActual();
            RegistroSalida registroSalida = new RegistroSalida(computador, fecha);
            registros.add(registroSalida);
            System.out.println("Salida registrada para el computador con serial: " + serial);
        } else {
            System.out.println("Computador no encontrado o ya salió con el serial: " + serial);
        }
    }

    public void mostrarRegistros() {
        System.out.println("\n--- Historial de Registros ---");
        for (Registro registro : registros) {
            registro.mostrarDetalle();
            System.out.println("-------------------------");
        }
    }

    public void mostrarActivos() {
        System.out.println("\n--- Computadores Activos (en el campus) ---");
        for (Registro registro : registros) {
            if (registro instanceof RegistroEntrada && !estaSalidaRegistrada(registro.getComputador().getSerial())) {
                registro.mostrarDetalle();
                System.out.println("-------------------------");
            }
        }
    }

    private Computador buscarComputadorActivo(String serial) {
        for (Registro registro : registros) {
            if (registro instanceof RegistroEntrada &&
                    registro.getComputador().getSerial().equals(serial) &&
                    !estaSalidaRegistrada(serial)) {
                return registro.getComputador();
            }
        }
        return null;
    }

    private boolean estaSalidaRegistrada(String serial) {
        for (Registro registro : registros) {
            if (registro instanceof RegistroSalida && registro.getComputador().getSerial().equals(serial)) {
                return true;
            }
        }
        return false;
    }

    private String obtenerFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatoFecha.format(new Date());
    }
}