package com.alura.screenmatch.modelos;

/**
 * Representa una serie de televisión con sus características específicas.
 * Hereda de Titulo y agrega funcionalidades propias de las series.
 */
public class Serie extends Titulo {
    private int temporadas;
    private boolean activa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    /**
     * Crea una nueva instancia de Serie.
     * @param nombre Nombre de la serie
     * @param fechaDeLanzamiento Año de estreno
     */
    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    /**
     * Calcula la duración total de la serie en minutos.
     * @return Duración total = temporadas × episodios × duración por episodio
     */
    @Override
    public int getDuracionEnMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    /**
     * Devuelve una representación en cadena de la serie.
     * @return Cadena con el formato "Serie: [nombre] (año), [temporadas] temporadas"
     */
    @Override
    public String toString() {
        return "Serie: "+this.getNombre()+" ("+this.getFechaDeLanzamiento()+")";
    }
}
