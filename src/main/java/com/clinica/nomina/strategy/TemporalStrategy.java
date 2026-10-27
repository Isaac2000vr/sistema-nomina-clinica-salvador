package com.clinica.nomina.strategy;

public class TemporalStrategy implements CalculoSalarioStrategy {
    private final double salarioFijo;

    public TemporalStrategy(double salarioFijo) {
        if (salarioFijo < 0) {
            throw new IllegalArgumentException("El salario fijo no puede ser negativo");
        }
        this.salarioFijo = salarioFijo;
    }

    @Override
    public double calcularSalarioBruto() {
        // Salario fijo mensual sin bonos ni beneficios adicionales por estrategia
        return salarioFijo;
    }
}