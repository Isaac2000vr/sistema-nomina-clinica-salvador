package com.clinica.nomina.model;

import com.clinica.nomina.strategy.CalculoSalarioStrategy;

public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String id, String nombre, CalculoSalarioStrategy estrategiaCalculo) {
        super(id, nombre, estrategiaCalculo);
    }

    @Override
    public double calcularBeneficiosAdicionales() {
        // Empleados temporales: No aplican bonos ni beneficios adicionales
        return 0.0;
    }

    @Override
    public boolean esPermanente() {
        return false;
    }
}