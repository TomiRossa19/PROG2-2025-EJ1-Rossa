public class CuentaCorriente extends Cuenta implements IGestionSaldo {
    double giroDescubierto;

    @Override
    public boolean quitarSaldo(double monto) {
        // Se puede retirar si el saldo final no es menor al límite del descubierto negativo
        if ((saldo - monto) >= -giroDescubierto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }
}
