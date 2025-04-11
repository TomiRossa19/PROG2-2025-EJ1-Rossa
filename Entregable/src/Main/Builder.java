package Main;

public class Builder {
    private double giroDescubierto;

    // Setter para el giro descubierto (solo se usa si se quiere crear una CuentaCorriente)
    public Builder setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
        return this;
    }

    // Crea una cuenta corriente usando el valor configurado
    public CuentaCorriente buildCuentaCorriente() {
        return new CuentaCorriente(giroDescubierto);
    }

    // Crea una caja de ahorro (sin configuración extra por ahora)
    public CajaDeAhorro buildCajaDeAhorro() {
        return new CajaDeAhorro();
    }
}