package com.clinica.nomina.service;

import com.clinica.nomina.model.Empleado;

/**
 * Servicio encargado de la lógica central del cálculo de nómina,
 * deducciones de ley y liquidación final por empleado.
 * Aplica el principio de Responsabilidad Única (SRP).
 */
public class CalculadoraNominaService {

    // Porcentajes de ley
    private static final double PORCENTAJE_SALUD = 0.04;
    private static final double PORCENTAJE_PENSION = 0.04;
    private static final double PORCENTAJE_ARL = 0.00522; // Riesgo I básico

    public double calcularSalud(Empleado empleado) {
        return empleado.obtenerSalarioBruto() * PORCENTAJE_SALUD;
    }

    public double calcularPension(Empleado empleado) {
        return empleado.obtenerSalarioBruto() * PORCENTAJE_PENSION;
    }

    public double calcularARL(Empleado empleado) {
        return empleado.obtenerSalarioBruto() * PORCENTAJE_ARL;
    }

    public double calcularTotalDeducciones(Empleado empleado) {
        return calcularSalud(empleado) + calcularPension(empleado) + calcularARL(empleado);
    }

    public double calcularSalarioNeto(Empleado empleado) {
        double salarioBruto = empleado.obtenerSalarioBruto();
        double beneficios = empleado.calcularBeneficiosAdicionales();
        double deducciones = calcularTotalDeducciones(empleado);

        return salarioBruto + beneficios - deducciones;
    }
}