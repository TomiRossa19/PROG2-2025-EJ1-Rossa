package Main;

import java.util.ArrayList;
import java.util.List;

public class LogicaCuenta {
    private static LogicaCuenta instancia;
    List<Cuenta> cuentas;
    private LogicaCuenta(){
        this.cuentas = new ArrayList<>() {
        };
    }
    public static synchronized LogicaCuenta getInstancia() {
        if (instancia == null) {
            instancia = new LogicaCuenta();
        }
        return instancia;
    }
    public boolean agregarSaldo(Integer cuenta, double monto){
        if (cuenta < 0 || cuenta >= cuentas.size()) return false;
        return cuentas.get(cuenta).agregarSaldo(monto);
    };


    public boolean quitarSaldo(Integer cuenta, double monto)


    public double consultarSaldo(Integer cuenta)

}
