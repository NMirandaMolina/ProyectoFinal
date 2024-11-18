public class RegistroEntrada {
    public RegistroEntrada(Computador computador, String fecha) {
        super(computador, fecha);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Registro de Entrada:");
        computador.mostrarInfo();
        System.out.println("Fecha de entrada: " + fecha);
    }

}
