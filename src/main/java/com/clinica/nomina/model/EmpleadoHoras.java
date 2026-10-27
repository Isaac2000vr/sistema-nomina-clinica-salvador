package com.clinica.nomina.model;

import com.clinica.nomina.strategy.CalculoSalarioStrategy;

public class EmpleadoHoras extends Empleado {
    private final int aniosEnEmpresa;
    private final boolean aceptaFondoAhorro;

    public EmpleadoHoras(String id, String nombre, CalculoSalarioStrategy estrategiaCalculo, 
                        int aniosEnEmpresa, boolean aceptaFondoAhorro) {
        super(id, nombre, estrategiaCalculo);
        if (aniosEnEmpresa < 0) {
            throw new IllegalArgumentException("Los años en la empresa no pueden ser negativos");
        }
        this.aniosEnEmpresa = aniosEnEmpresa;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }

    @Override
    public double calcularBeneficiosAdicionales() {
        // Empleados por Horas con más de 1 año tienen acceso a fondo de ahorro (2% del salario bruto) si lo aceptan
        if (aniosEnEmpresa > 1 && aceptaFondoAhorro) {
            return obtenerSalarioBruto() * 0.02;
        }
        return 0.0;
    }

    @Override
    public boolean esPermanente() {
        return false;
    }
}