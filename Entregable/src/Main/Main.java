package Main;

import java.util.*;
import java.util.concurrent.*;
import java.lang.InterruptedException;
public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder();
        LogicaCuenta logica = LogicaCuenta.getInstancia();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Cuenta cuenta;
            if (random.nextBoolean()) {    // se ejecuta si da true
                double giro = 100 + (400 * random.nextDouble());
                cuenta = builder.setGiroDescubierto(giro).buildCuentaCorriente();
            } else {    // se ejecuta si da false
                cuenta = builder.buildCajaDeAhorro();
            }
            logica.cuentas.add(cuenta);
            System.out.println("Cuenta " + i + " creada: " + cuenta.getClass().getSimpleName());
        }
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Boolean>> resultados = new ArrayList<>();

        // Ejecutar 10.000 tareas concurrentes
        for (int i = 0; i < 10_000; i++) {
            final int indice = random.nextInt(10);
            final double monto = 10 + random.nextDouble() * 90;
            Callable<Boolean> tarea = random.nextBoolean()
                    ? () -> logica.agregarSaldo(indice, monto)
                    : () -> logica.quitarSaldo(indice, monto);

            resultados.add(executor.submit(tarea));
        }
        try {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("La espera fue interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt(); //volver a marcar el hilo como interrumpido
        }
        int exitosas = 0;
        for (Future<Boolean> r : resultados) {
            try {
                if (r.get()) exitosas++;
            } catch (InterruptedException e) {
                System.err.println("La espera de la tarea fue interrumpida: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.err.println("Hubo un error en la ejecución de la tarea: " + e.getMessage());
            }
        }

        System.out.println("Operaciones exitosas: " + exitosas);
        logica.imprimirResumenCuentas();
    }
}

