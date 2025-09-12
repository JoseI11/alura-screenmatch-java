package com.alura.screenmatch.calculos;

/**
 * Clase que filtra y recomienda contenido basado en su clasificación.
 * Proporciona recomendaciones según la puntuación del contenido.
 */
public class FiltroRecomendacion {
    private String recomendacion;

    /**
     * Filtra y muestra una recomendación basada en la clasificación del contenido.
     * @param clasificable El elemento a evaluar (debe implementar la interfaz Clasificable)
     */
    public void filtra(Clasificable clasificable) {
        if (clasificable.getClasificacion() >= 4) {
            System.out.println("Está entre los favoritos del momento");
        } else if (clasificable.getClasificacion() >= 2) {
            System.out.println("Bien evaluado actualmente");
        } else {
            System.out.println("Colocalo en tu lista para verlo después");
        }
    }
}
