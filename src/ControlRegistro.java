import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlRegistro {
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

}
