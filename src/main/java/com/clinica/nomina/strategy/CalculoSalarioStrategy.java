package com.clinica.nomina.strategy;

/**
 * Interfaz que define la estrategia para el cálculo del salario bruto.
 * Aplica el principio Open/Closed (OCP) de SOLID.
 */
public interface CalculoSalarioStrategy {
    double calcularSalarioBruto();
}