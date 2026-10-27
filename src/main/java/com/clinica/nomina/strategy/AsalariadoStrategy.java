package com.clinica.nomina.strategy;

public class AsalariadoStrategy implements CalculoSalarioStrategy {
    private final double salarioFijo;
    private final int aniosEnEmpresa;

    public AsalariadoStrategy(double salarioFijo, int aniosEnEmpresa) {
        if (salarioFijo < 0) {
            throw new IllegalArgumentException("El salario fijo no puede ser negativo");
        }
        if (aniosEnEmpresa < 0) {
            throw new IllegalArgumentException("Los años en la empresa no pueden ser negativos");
        }
        this.salarioFijo = salarioFijo;
        this.aniosEnEmpresa = aniosEnEmpresa;
    }

    @Override
    public double calcularSalarioBruto() {
        // Bono del 10% si lleva más de 5 años en la empresa
        double bono = (aniosEnEmpresa > 5) ? salarioFijo * 0.10 : 0.0;
        return salarioFijo + bono;
    }
}