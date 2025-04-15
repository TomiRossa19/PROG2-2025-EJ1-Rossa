package Main;

public class Builder {
    private double giroDescubierto;

    public Builder setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
        return this;
    }

    public CuentaCorriente buildCuentaCorriente() {
        return new CuentaCorriente(giroDescubierto);
    }

    public CajaDeAhorro buildCajaDeAhorro() {
        return new CajaDeAhorro();
    }
}