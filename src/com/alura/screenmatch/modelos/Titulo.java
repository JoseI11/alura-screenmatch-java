package com.alura.screenmatch.modelos;
import com.alura.screenmatch.excepcion.ErrorEnConversionDuracionException;
import com.google.gson.annotations.SerializedName;
public class Titulo implements Comparable<Titulo>{



    private String nombre;
    private int fechaDeLanzamiento;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    private int duracionEnMinutos;

    /**
     * Constructor principal para crear un título con nombre y año de lanzamiento.
     * @param nombre Nombre del título (película/serie)
     * @param fechaDeLanzamiento Año de lanzamiento
     */
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    /**
     * Constructor que crea un título a partir de un objeto TituloOmdb.
     * @param miTituloOmdb Objeto con datos obtenidos de la API de OMDb
     * @throws ErrorEnConversionDuracionException Si la duración no está disponible (N/A)
     */
    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        if(miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDuracionException("No pude convertir la duracion," +
                    "porque contiene un N/A");
        }

        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    /**
     * Muestra la ficha técnica básica del título en consola.
     * Incluye nombre y año de lanzamiento.
     */
    public void muestraFichaTecnica(){
        System.out.println("Nombre de la película: " + nombre);
        System.out.println("Año de lanzamiento: " + fechaDeLanzamiento);
    }

    /**
     * Registra una nueva evaluación para este título.
     * @param nota Valor de la evaluación (0.0 a 10.0)
     */
    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeEvaluaciones++;
    }

    /**
     * Calcula el promedio de todas las evaluaciones registradas.
     * @return Promedio de evaluaciones o 0 si no hay evaluaciones
     */
    public double calculaMediaEvaluaciones(){
        return sumaDeLasEvaluaciones / totalDeEvaluaciones;
    }

    /**
     * Compara este título con otro por nombre (orden alfabético).
     * @param otroTitulo Título a comparar
     * @return Valor negativo, cero o positivo según el orden alfabético
     */
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    /**
     * Devuelve una representación en cadena del título.
     * @return Cadena con nombre, año y duración
     */
    @Override
    public String toString() {
        return "(nombre='" + nombre +"fechaDeLanzamiento=" +fechaDeLanzamiento+", duracion="+ duracionEnMinutos+")";


    }
}
