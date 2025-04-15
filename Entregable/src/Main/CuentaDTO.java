package Main;

public class CuentaDTO {
    protected double saldo;
    protected int operaciones;

    public CuentaDTO(double saldo, int operaciones) {
        this.saldo = saldo;
        this.operaciones = operaciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }
}