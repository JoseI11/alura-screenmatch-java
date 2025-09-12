package com.alura.screenmatch.calculos;

/**
 * Interfaz que define el contrato para elementos que pueden ser clasificados.
 * Las clases que implementen esta interfaz deben proporcionar un método para obtener su clasificación.
 */
public interface Clasificable {
    /**
     * Obtiene la clasificación del elemento.
     * @return Un entero que representa la clasificación (generalmente de 1 a 5)
     */
    int getClasificacion();
}
