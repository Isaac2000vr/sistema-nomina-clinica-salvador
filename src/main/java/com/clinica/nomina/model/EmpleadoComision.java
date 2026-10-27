package com.clinica.nomina.model;

import com.clinica.nomina.strategy.CalculoSalarioStrategy;

public class EmpleadoComision extends Empleado {

    public EmpleadoComision(String id, String nombre, CalculoSalarioStrategy estrategiaCalculo) {
        super(id, nombre, estrategiaCalculo);
    }

    @Override
    public double calcularBeneficiosAdicionales() {
        // Beneficio de empleados permanentes: Bono Alimentación ($1.000.000/mes)
        return 1_000_000.0;
    }

    @Override
    public boolean esPermanente() {
        return true;
    }
}