## Más Alto 4

## Descripción del proyecto

El proyecto consiste en desarrollar una aplicación con interfaz gráfica (GUI) en Java para administrar una colección de cartas de Pokémon TCG. El sistema permitirá al usuario mantener sus cartas organizadas, ver su información y realizar distintas acciones sobre ellas de forma simple.

La aplicación cargará las cartas desde un archivo de texto llamado Sobres.txt, donde se encuentra la información de cada carta, como su nombre, rareza, tipo y los atributos correspondientes según si es una carta Pokémon, Item, Supporter o Energy. Además, cada carta tendrá una imagen asociada y, si esta no existe, el sistema mostrará una imagen por defecto.

Entre las funciones principales del programa estarán agregar, eliminar y modificar cartas, además de mostrar toda la colección. El usuario también podrá ordenar las cartas por nombre, rareza o poder para encontrar la información de forma más rápida. Al seleccionar una carta, se abrirá una ventana con una vista ampliada donde se mostrará la imagen de la carta, sus atributos y el poder calculado según su tipo.

El proyecto será desarrollado utilizando Programación Orientada a Objetos (POO), haciendo uso de herencia, interfaces, manejo de archivos y una arquitectura que permita separar la lógica del sistema de la interfaz gráfica. Además, se implementarán los patrones de diseño Singleton, Factory, Visitor y Strategy para organizar mejor el código y facilitar su mantenimiento.

Finalmente, el objetivo del proyecto es desarrollar un software que permita administrar una colección de cartas de forma ordenada y eficiente, utilizando buenas prácticas de programación para obtener un sistema claro, funcional y fácil de mantener.

## Integrantes
- Nombre Completo: Diego Nikolas Serrano Fuentes 
  - RUT: 22.105.561-6 
  - GitHub: diegoserrano-cloud

- Nombre Completo: Josselyn Alejandra Barraza Yáñez
  - RUT: 22.246.539-7
  - GitHub: josselynbarraza-sys
    
## Estructura del proyecto
- Taller4_DiegoSerrano_JosselynBarraza
    - Imagenes    #carpeta con las imagenes de las cartas
    - src
        - Factory
            - FactoryCarta.java
        - Strategy
            - OrdenNombre.java
            - OrdenPoder.java
            - OrdenRareza.java
            - StrategyOrdenar.java
        - Visitor
            - CalculadorPoder.java
            - Visitor.java
        - dominio
            - Carta.java # Clase abstracta
            - Energy.java 
            - Item.java 
            - Pokemon.java 
            - Supporter.java 
        - Logica
            - App.java # Clase principal que contiene toda la logica detrás del juego
            - Sistema.java #Interfaz
            - SistemaImple.java #Implementación de la interfaz, se encarga de todo
        - module-info.java
    - .classpath
    - .project
    - Diagramas (1).pdf
    - README.md
    - sobres.txt

## Instrucciones 
- Requisitos previos
  - Java JDK 11 o superior instalado
  - Tener algún IDE instalado compatible con java, por ejemplo, Eclipse IDE o Visual Studio Code.

- Instrucciones de ejecución
  - Importar el proyecto dentro del IDE seleccionado.
  - Seleccionar la carpeta src -> package "Logica" -> Clase "App".
  - Una vez dentro buscar el boton de "Play".
  - Disfrutar del juego :D
