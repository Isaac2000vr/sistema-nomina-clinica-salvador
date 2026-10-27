package com.clinica.nomina.strategy;

public class HorasStrategy implements CalculoSalarioStrategy {
    private final double tarifaHora;
    private final double horasTrabajadas;

    public HorasStrategy(double tarifaHora, double horasTrabajadas) {
        if (tarifaHora < 0) {
            throw new IllegalArgumentException("La tarifa por hora no puede ser negativa");
        }
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }
        this.tarifaHora = tarifaHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalarioBruto() {
        // Horas normales (hasta 40 horas)
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifaHora;
        } else {
            // Las horas extras (más de 40 horas) se pagan a 1.5x
            double horasNormales = 40 * tarifaHora;
            double horasExtras = (horasTrabajadas - 40) * (tarifaHora * 1.5);
            return horasNormales + horasExtras;
        }
    }
}