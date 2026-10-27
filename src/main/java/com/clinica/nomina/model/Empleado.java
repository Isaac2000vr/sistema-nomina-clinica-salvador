package com.clinica.nomina.model;

import com.clinica.nomina.strategy.CalculoSalarioStrategy;

/**
 * Clase abstracta base que representa a un Empleado.
 * Aplica el principio de Inversión de Dependencias (DIP) al depender de CalculoSalarioStrategy.
 */
public abstract class Empleado {
    private final String id;
    private final String nombre;
    private final CalculoSalarioStrategy estrategiaCalculo;

    public Empleado(String id, String nombre, CalculoSalarioStrategy estrategiaCalculo) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del empleado no puede estar vacío");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío");
        }
        if (estrategiaCalculo == null) {
            throw new IllegalArgumentException("La estrategia de cálculo no puede ser nula");
        }
        this.id = id;
        this.nombre = nombre;
        this.estrategiaCalculo = estrategiaCalculo;
    }

    public double obtenerSalarioBruto() {
        return estrategiaCalculo.calcularSalarioBruto();
    }

    /**
     * Devuelve los beneficios adicionales según las reglas de negocio de cada tipo de empleado.
     */
    public abstract double calcularBeneficiosAdicionales();

    /**
     * Indica si el empleado es considerado permanente en la empresa.
     */
    public abstract boolean esPermanente();

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}