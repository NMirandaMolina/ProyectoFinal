public class Computador {

    private String marca;
    private String modelo;
    private String serial;
    private String propietario;

    public Computador(String marca, String modelo, String serial, String propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerial() {
        return serial;
    }

    public String getPropietario() {
        return propietario;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Serial: " + serial + ", Propietario: " + propietario);
    }
}
