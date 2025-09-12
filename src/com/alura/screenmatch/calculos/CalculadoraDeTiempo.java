package com.alura.screenmatch.calculos;

import com.alura.screenmatch.modelos.Titulo;

/**
 * Clase utilitaria para calcular el tiempo total de visualización de contenido.
 * Permite sumar la duración de diferentes títulos (películas o series).
 */
public class CalculadoraDeTiempo {
    private int tiempoTotal;

    /**
     * Obtiene el tiempo total acumulado en minutos.
     * @return Tiempo total en minutos
     */
    public int getTiempoTotal() {
        return this.tiempoTotal;
    }

//    public void incluido(Filme f) {
//        this.tiempoTotal += f.getDuracionEnMinutos();
//    }
//
//    public void incluido(Serie s) {
//        this.tiempoTotal += s.getDuracionEnMinutos();
//    }

    /**
     * Agrega la duración de un título al tiempo total acumulado.
     * @param titulo El título (película o serie) cuya duración se sumará
     */
    public void incluido(Titulo titulo) {
        System.out.println("Agregando duración en minutos de " + titulo);
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }
}
