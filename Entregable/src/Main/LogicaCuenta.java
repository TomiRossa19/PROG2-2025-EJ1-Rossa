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
    public CuentaDTO mapearACuentaDTO(Cuenta cuenta) {
        if (cuenta instanceof CuentaCorriente) {
            CuentaCorriente cc = (CuentaCorriente) cuenta;
            return new CuentaCorrienteDTO(cc.getSaldo(), cc.getOperaciones(), cc.getGiroDescubierto());
        } else if (cuenta instanceof CajaDeAhorro) {
            CajaDeAhorro ca = (CajaDeAhorro) cuenta;
            return new CajaDeAhorroDTO(ca.getSaldo(), ca.getOperaciones());
        } else {
            throw new IllegalArgumentException("Tipo de cuenta no soportado");
        }
    }
    public boolean agregarSaldo(Integer cuenta, double monto) {
        if (cuenta < 0 || cuenta >= cuentas.size()) return false;
        Cuenta cuenta1 = cuentas.get(cuenta);
        if (cuenta1 instanceof IGestionSaldo) {
            return ((IGestionSaldo) cuenta1).agregarSaldo(monto);
        }
        return false;
    }
    public boolean quitarSaldo(Integer cuenta, double monto){
        if (cuenta < 0 || cuenta >= cuentas.size()) return false;
        Cuenta cuenta1 = cuentas.get(cuenta);
        if (cuenta1 instanceof IGestionSaldo) {
            return ((IGestionSaldo) cuenta1).quitarSaldo(monto);
        }
        return false;
    }
    public double consultarSaldo(Integer cuenta) {
        if (cuenta < 0 || cuenta >= cuentas.size()) {
            throw new IllegalArgumentException("Índice de cuenta inválido");
        }

        Cuenta cuenta1 = cuentas.get(cuenta);
        CuentaDTO cuentaDTO = mapearACuentaDTO(cuenta1); // Convertimos la cuenta a DTO
        return cuentaDTO.getSaldo(); // Retornamos solo el saldo desde el DTO
    }


}
