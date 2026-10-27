package com.clinica.nomina.strategy;

public class ComisionStrategy implements CalculoSalarioStrategy {
    private final double salarioBase;
    private final double ventasRealizadas;
    private final double porcentajeComision; // Ej: 0.05 para 5%

    public ComisionStrategy(double salarioBase, double ventasRealizadas, double porcentajeComision) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        if (ventasRealizadas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser menores a $0");
        }
        if (porcentajeComision < 0) {
            throw new IllegalArgumentException("El porcentaje de comisión no puede ser negativo");
        }
        this.salarioBase = salarioBase;
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalarioBruto() {
        double comisionBase = ventasRealizadas * porcentajeComision;
        // Si las ventas superan $20.000.000, recibe un bono adicional del 3% sobre las ventas
        double bonoAdicional = (ventasRealizadas > 20_000_000) ? ventasRealizadas * 0.03 : 0.0;
        return salarioBase + comisionBase + bonoAdicional;
    }
}