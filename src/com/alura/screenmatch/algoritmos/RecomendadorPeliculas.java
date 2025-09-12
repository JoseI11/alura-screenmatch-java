package com.alura.screenmatch.algoritmos;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class RecomendadorPeliculas {
    
    /**
     * Recomienda películas basadas en la similitud con una película de referencia
     * utilizando el algoritmo de similitud del coseno.
     * 
     * @param peliculaReferencia Película de referencia para la recomendación
     * @param peliculas Lista de películas disponibles para recomendar
     * @param cantidad Número de recomendaciones a devolver
     * @return Lista de películas recomendadas ordenadas por similitud
     */

    /**
     * Constructor por defecto de la clase RecomendadorPeliculas.
     */
    public RecomendadorPeliculas() {
    }
    public List<Pelicula> recomendarPeliculas(Pelicula peliculaReferencia, List<Pelicula> peliculas, int cantidad) {
        // Validación de parámetros
        if (peliculaReferencia == null || peliculas == null || peliculas.isEmpty() || cantidad <= 0) {
            return Collections.emptyList();
        }

        // Mapa para almacenar la similitud de cada película con la referencia
        Map<Pelicula, Double> similitudes = new HashMap<>();
        
        // Características de la película de referencia
        Map<String, Double> caracteristicasReferencia = extraerCaracteristicas(peliculaReferencia);
        
        // Calcular similitud con cada película
        for (Pelicula pelicula : peliculas) {
            // No comparar con la misma película
            if (!pelicula.equals(peliculaReferencia)) {
                Map<String, Double> caracteristicas = extraerCaracteristicas(pelicula);
                double similitud = calcularSimilitudCoseno(caracteristicasReferencia, caracteristicas);
                similitudes.put(pelicula, similitud);
            }
        }
        
        // Ordenar películas por similitud (de mayor a menor)
        List<Map.Entry<Pelicula, Double>> entradas = new ArrayList<>(similitudes.entrySet());
        entradas.sort(Map.Entry.<Pelicula, Double>comparingByValue().reversed());
        
        // Seleccionar las primeras 'cantidad' películas
        List<Pelicula> recomendaciones = new ArrayList<>();
        int contador = 0;
        for (Map.Entry<Pelicula, Double> entrada : entradas) {
            if (contador >= cantidad) break;
            recomendaciones.add(entrada.getKey());
            contador++;
        }
        
        return recomendaciones;
    }
    
    /**
     * Extrae características numéricas de una película para el cálculo de similitud.
     */
    /**
     * Extrae características numéricas de una película para el cálculo de similitud.
     * @param pelicula La película de la cual extraer características
     * @return Mapa de características con sus valores numéricos
     */
    private Map<String, Double> extraerCaracteristicas(Pelicula pelicula) {
        Map<String, Double> caracteristicas = new HashMap<>();
        
        // Usamos el año de lanzamiento como una característica
        caracteristicas.put("anio", (double) pelicula.getFechaDeLanzamiento());
        
        // Usamos la duración como característica
        caracteristicas.put("duracion", (double) pelicula.getDuracionEnMinutos());
        
        // Si hay evaluaciones, las usamos como característica
        if (pelicula.getTotalDeEvaluaciones() > 0) {
            caracteristicas.put("evaluacion", pelicula.calculaMediaEvaluaciones());
        } else {
            caracteristicas.put("evaluacion", 0.0);
        }
        
        return caracteristicas;
    }
    
    /**
     * Calcula la similitud del coseno entre dos vectores de características.
     */
    /**
     * Calcula la similitud del coseno entre dos vectores de características.
     * @param vectorA Primer vector de características
     * @param vectorB Segundo vector de características
     * @return Valor de similitud entre 0 (ninguna similitud) y 1 (idénticos)
     */
    private double calcularSimilitudCoseno(Map<String, Double> vectorA, Map<String, Double> vectorB) {
        // Obtener todas las claves únicas de ambos vectores
        Set<String> claves = new HashSet<>();
        claves.addAll(vectorA.keySet());
        claves.addAll(vectorB.keySet());
        
        // Calcular producto punto
        double productoPunto = 0.0;
        double normaA = 0.0;
        double normaB = 0.0;
        
        for (String clave : claves) {
            double valorA = vectorA.getOrDefault(clave, 0.0);
            double valorB = vectorB.getOrDefault(clave, 0.0);
            
            productoPunto += valorA * valorB;
            normaA += Math.pow(valorA, 2);
            normaB += Math.pow(valorB, 2);
        }
        
        // Evitar división por cero
        if (normaA == 0 || normaB == 0) {
            return 0.0;
        }
        
        return productoPunto / (Math.sqrt(normaA) * Math.sqrt(normaB));
    }
    
    /**
     * Filtra películas por un criterio personalizado usando un predicado.
     * Ejemplo de programación funcional en Java.
     */
    /**
     * Filtra una lista de películas según un criterio personalizado.
     * @param peliculas Lista de películas a filtrar
     * @param criterio Predicado que define la condición de filtrado
     * @return Lista de películas que cumplen con el criterio
     */
    public List<Pelicula> filtrarPeliculas(List<Pelicula> peliculas, java.util.function.Predicate<Pelicula> criterio) {
        List<Pelicula> resultado = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (criterio.test(pelicula)) {
                resultado.add(pelicula);
            }
        }
        return resultado;
    }
    
    /**
     * Ordena películas usando el algoritmo de ordenamiento por inserción.
     * Aunque no es el más eficiente para listas grandes, es útil para demostrar
     * el conocimiento de algoritmos de ordenamiento.
     */
    /**
     * Ordena una lista de películas usando el algoritmo de ordenación por inserción.
     * @param peliculas Lista de películas a ordenar
     * @param comparador Comparador que define el criterio de ordenación
     * @return Nueva lista ordenada
     */
    public List<Pelicula> ordenarPorInserccion(List<Pelicula> peliculas, Comparator<Pelicula> comparador) {
        if (peliculas == null || peliculas.size() <= 1) {
            return new ArrayList<>(peliculas);
        }
        
        List<Pelicula> resultado = new ArrayList<>(peliculas);
        
        for (int i = 1; i < resultado.size(); i++) {
            Pelicula actual = resultado.get(i);
            int j = i - 1;
            
            while (j >= 0 && comparador.compare(resultado.get(j), actual) > 0) {
                resultado.set(j + 1, resultado.get(j));
                j--;
            }
            
            resultado.set(j + 1, actual);
        }
        
        return resultado;
    }
}
