package Main;

public class CuentaCorrienteDTO extends CuentaDTO {
    private double giroDescubierto;

    public CuentaCorrienteDTO(double saldo, int operaciones, double giroDescubierto) {
        super(saldo, operaciones);
        this.giroDescubierto = giroDescubierto;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }
}