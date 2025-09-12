package com.alura.screenmatch.modelos;

import com.alura.screenmatch.calculos.Clasificable;

/**
 * Representa una película con sus características principales.
 * Hereda de Titulo e implementa la interfaz Clasificable.
 */
public class Pelicula extends Titulo implements Clasificable {
    private String director;

    /**
     * Crea una nueva instancia de Pelicula.
     * @param nombre Nombre de la película
     * @param fechaDeLanzamiento Año de estreno
     */
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Calcula la clasificación de la película basada en su evaluación media.
     * @return Entero entre 1 y 5 (estrellas)
     */
    @Override
    public int getClasificacion() {
        return (int) calculaMediaEvaluaciones() / 2;
    }

    /**
     * Devuelve una representación en cadena de la película.
     * @return Cadena con el formato "Pelicula: [nombre] (año)"
     */
    @Override
    public String toString() {
        return "Pelicula: " + this.getNombre() + " (" + getFechaDeLanzamiento() + ")";
    }
}
