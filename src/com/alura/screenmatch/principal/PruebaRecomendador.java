package com.alura.screenmatch.principal;

import com.alura.screenmatch.algoritmos.RecomendadorPeliculas;
import com.alura.screenmatch.modelos.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class PruebaRecomendador {
    
    public static void main(String[] args) {
        // Crear algunas películas de ejemplo
        List<Pelicula> peliculas = new ArrayList<>();
        
        Pelicula pelicula1 = new Pelicula("El Padrino", 1972);
        pelicula1.setDuracionEnMinutos(175);
        pelicula1.evalua(9.2);
        pelicula1.evalua(9.5);
        pelicula1.evalua(8.9);
        peliculas.add(pelicula1);
        
        Pelicula pelicula2 = new Pelicula("El Padrino: Parte II", 1974);
        pelicula2.setDuracionEnMinutos(202);
        pelicula2.evalua(9.0);
        pelicula2.evalua(9.2);
        pelicula2.evalua(8.7);
        peliculas.add(pelicula2);
        
        Pelicula pelicula3 = new Pelicula("El Padrino: Parte III", 1990);
        pelicula3.setDuracionEnMinutos(162);
        pelicula3.evalua(7.6);
        pelicula3.evalua(7.8);
        pelicula3.evalua(7.4);
        peliculas.add(pelicula3);
        
        Pelicula pelicula4 = new Pelicula("El Caballero Oscuro", 2008);
        pelicula4.setDuracionEnMinutos(152);
        pelicula4.evalua(9.0);
        pelicula4.evalua(9.3);
        pelicula4.evalua(9.1);
        peliculas.add(pelicula4);
        
        Pelicula pelicula5 = new Pelicula("La Lista de Schindler", 1993);
        pelicula5.setDuracionEnMinutos(195);
        pelicula5.evalua(8.9);
        pelicula5.evalua(9.0);
        pelicula5.evalua(8.8);
        peliculas.add(pelicula5);
        
        // Crear instancia del recomendador
        RecomendadorPeliculas recomendador = new RecomendadorPeliculas();
        
        // Obtener recomendaciones basadas en "El Padrino"
        System.out.println("Recomendaciones basadas en 'El Padrino':");
        List<Pelicula> recomendaciones = recomendador.recomendarPeliculas(pelicula1, peliculas, 3);
        
        // Mostrar recomendaciones
        for (int i = 0; i < recomendaciones.size(); i++) {
            Pelicula p = recomendaciones.get(i);
            System.out.printf("%d. %s (%.1f/10)\n", 
                i + 1, 
                p.getNombre(), 
                p.calculaMediaEvaluaciones());
        }
        
        // Ejemplo de filtrado con programación funcional
        System.out.println("\nPelículas con duración mayor a 170 minutos:");
        recomendador.filtrarPeliculas(peliculas, p -> p.getDuracionEnMinutos() > 170)
                   .forEach(p -> System.out.println(p.getNombre() + " - " + p.getDuracionEnMinutos() + " min"));
        
        // Ejemplo de ordenamiento personalizado
        System.out.println("\nPelículas ordenadas por año (más recientes primero):");
        recomendador.ordenarPorInserccion(peliculas, (p1, p2) ->
            Integer.compare(p2.getFechaDeLanzamiento(), p1.getFechaDeLanzamiento())
        ).forEach(p -> System.out.println(p.getNombre() + " (" + p.getFechaDeLanzamiento() + ")"));
    }
}
