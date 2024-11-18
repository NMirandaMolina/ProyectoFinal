public class RegistroSalida extends Registro {

    public RegistroSalida(Computador computador, String fecha) {
        super(computador, fecha);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Registro de Salida:");
        computador.mostrarInfo();
        System.out.println("Fecha de salida: " + fecha);
    }
}
