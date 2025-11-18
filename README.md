# 🎬 ScreenMatch - Sistema de Recomendación de Películas

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

Sistema de recomendación de películas desarrollado en Java que utiliza algoritmos de similitud para sugerir películas basadas en preferencias y características similares.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Uso](#-uso)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Ejemplos de Código](#-ejemplos-de-código)
- [Contribuir](#-contribuir)
- [Licencia](#-licencia)

## ✨ Características

- Sistema de recomendación basado en similitud de coseno
- Gestión de catálogo de películas y series
- Filtrado y ordenamiento personalizado
- Cálculo de tiempo de visualización
- Interfaz de línea de comandos intuitiva

## 🛠️ Requisitos

- Java 17 o superior
- Maven 3.6 o superior
- Git (opcional, solo para clonar el repositorio)

## 🚀 Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/screenmatch-recomendador.git
   cd screenmatch-recomendador
   ```

2. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:
   ```bash
   mvn exec:java -Dexec.mainClass="com.alura.screenmatch.principal.Principal"
   ```

## 🎮 Uso

### Agregar una nueva película

```java
Pelicula pelicula = new Pelicula("El Padrino", 1972);
pelicula.setDuracionEnMinutos(175);
pelicula.evalua(9.2);
```

### Obtener recomendaciones

```java
RecomendadorPeliculas recomendador = new RecomendadorPeliculas();
List<Pelicula> recomendaciones = recomendador.recomendarPeliculas(peliculaFavorita, catalogoPeliculas, 5);
```

### Filtrar películas

```java
List<Pelicula> peliculasLargas = recomendador.filtrarPeliculas(
    catalogoPeliculas, 
    p -> p.getDuracionEnMinutos() > 120
);
```

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/alura/screenmatch/
│   │   ├── algoritmos/    # Algoritmos de recomendación
│   │   ├── calculos/      # Cálculos y utilidades
│   │   ├── excepcion/     # Manejo de excepciones
│   │   ├── modelos/       # Modelos de dominio
│   │   └── principal/     # Clases principales
│   └── resources/         # Recursos de la aplicación
└── test/                  # Pruebas unitarias
```

## 💻 Ejemplos de Código

### Crear una serie

```java
Serie breakingBad = new Serie("Breaking Bad", 2008);
breakingBad.setTemporadas(5);
breakingBad.setEpisodiosPorTemporada(13);
breakingBad.setMinutosPorEpisodio(49);
```

### Usar el sistema de recomendación

```java
// Obtener recomendaciones
List<Pelicula> recomendaciones = recomendador.recomendarPeliculas(
    peliculaReferencia, 
    catalogoPeliculas, 
    3
);

// Mostrar recomendaciones
System.out.println("Recomendaciones para ti:");
recomendaciones.forEach(p -> 
    System.out.println(p.getNombre() + " - " + p.calculaMediaEvaluaciones() + "/10")
);
```

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Por favor, sigue estos pasos:

1. Haz un fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/AmazingFeature`)
3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.

---

Realizado por José Imhoff - ¡Disfruta del cine!
