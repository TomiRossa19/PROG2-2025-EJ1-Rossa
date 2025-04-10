public class CuentaCorriente extends Cuenta implements IGestionSaldo{
    double giroDescubierto;

    @Override
    public boolean quitarSaldo(double monto) {
        
        return false;
    }
}
