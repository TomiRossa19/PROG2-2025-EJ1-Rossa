package Main;

public interface IGestionSaldo {
    boolean agregarSaldo(double monto);
    boolean quitarSaldo(double monto);
    double getSaldo();
    Integer getOperaciones();

}
