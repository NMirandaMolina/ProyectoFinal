public abstract class Registro {

    protected Computador computador;
    protected String fecha;

    public Registro(Computador computador, String fecha) {
        this.computador = computador;
        this.fecha = fecha;
    }

    public Computador getComputador() {
        return computador;
    }

    public String getFecha() {
        return fecha;
    }

    public abstract void mostrarDetalle();
}

