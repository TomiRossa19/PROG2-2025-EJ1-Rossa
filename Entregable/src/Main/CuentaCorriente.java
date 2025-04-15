package Main;

public class CuentaCorriente extends Cuenta implements IGestionSaldo {
    double giroDescubierto;
    public CuentaCorriente(double giroDescubierto){
        this.giroDescubierto = giroDescubierto;
    }
    public Integer getIndiceCuenta(){
        return indiceCuenta;
    }
    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if ((saldo - monto) >= -giroDescubierto) {
            saldo -= monto;
            operaciones ++;
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        saldo += monto;
        operaciones ++;
        return true;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    @Override
    public Integer getOperaciones() {
        return operaciones;
    }
    @Override
    public double getSaldo() {
        return saldo;
    }
}
