package Main;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo {
    public Integer getIndiceCuenta(){
        return indiceCuenta;
    }
    @Override
    public Integer getOperaciones() {
        return operaciones;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        saldo += monto;
        operaciones += operaciones;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
            saldo -= monto;
            operaciones += operaciones;
            return true;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}
