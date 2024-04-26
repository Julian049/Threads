# Proyecto usando hilos 

## Descripcion 
Este proyecto esta orientado al proceso de aprendizaje del manejo de hilos y reforzar la utilización del patrón de diseño MVP.

## Requisitos
Java 17

## Funcionamiento 
Este proyecto funciona generando n elementos entre 4 opciones disponibles: círculos, cuadrados, imágenes o texto. Estos son generados de forma aleatoria y pintados en la pantalla. Luego, mediante el botón de iniciar el juego, se empezarán a mover los elementos hasta pegar con los bordes del panel.

NOTA: Los elementos tienen la capacidad de rebotar según el tamaño del panel, sin embargo, estos solo lo harán mientras el programa no se esté ejecutando. Así que, si desea ajustar el tamaño del panel para que los elementos reboten al nuevo tamaño mientras está en ejecución, no funcionará. Esto solo se aplicará si primero detiene el programa, luego ajusta el tamaño y lo reanuda.

El programa cuenta con 3 botones `Add`, `Start` y `Stop`.

`Add` funciona para pintar los elementos que son generados aleatoriamente.

`Start` inicia el movimiento de todos los elementos.

`Stop` detiene el movimiento de todos los elementos.

Además, también cuenta con un espacio de texto que sirve para poner el número de elementos que quiera añadir al programa.

## Estructura del codigo

### Arquitectura del projecto

El proyecto se diseñó bajo el modelo MVP.

### Arquitectura de los elementos 

Las figuras en el código se conocen como elementos, estos cuentan con una gran cantidad de atributos, algunos de los cuales no son manejables por el usuario debido a que se generan de forma aleatoria. Estos atributos son:

- `XCoordinate`
- `YCoordinate`
- `type`
- `speed`
- `typeMovement`
- `direction`
- `image`

Sin embargo, también hay atributos que sí se pueden configurar dependiendo de las necesidades del usuario. Estos se pueden modificar en el archivo `config.properties` cambiando los valores correspondientes. Los atributos son:

- `imageHeight`
- `imageWidth`
- `circleSize`
- `squareSize`
- `textFontSize`
- `text`
- `image`

Los siguientes atributos se calculan automáticamente en función de la información cargada:

- `textWidth`
- `textHeight`

### Archivo de configuración

En el proyecto se encuentra el archivo `config.properties` en donde se podrán manejar aspectos de configuración del código, como tamaños, rutas de archivos y demás.

A continuación se hará una breve descripción de cada atributo:

`UIUpdateSpeed` define la velocidad con la que se va a actualizar el panel, es independiente a la velocidad de cada elemento, ya que en este caso es la frecuencia de actualización del panel.

`circleSize` define el tamaño de los círculos que se generen.

`imageHeight` define el alto de las imágenes que se generen.

`imageWidth` define el ancho de las imágenes que se generen.

`squareSize` define el tamaño de los cuadrados que se generen.

`textSize` define el tamaño del texto que se genere.

`imagePath`, `imagePath2`, `imagePath3` y `imagePath4` son las rutas de las 4 imágenes que hay disponibles en el programa.

`movingPixels` define la cantidad de píxeles que los elementos se van a mover por cada vez que el elemento se mueva.

`minSpeed` define la velocidad mínima en la que el programa genera las velocidades de los elementos.

`maxSpeed` define la velocidad máxima en la que el programa genera las velocidades de los elementos.

`text` define el texto que se va a generar.

`UIWidth` define el ancho inicial del panel.

`UIHeight` define el alto inicial del panel.