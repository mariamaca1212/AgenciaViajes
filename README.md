# TripSplit

Guía de instalación y puesta en marcha del proyecto **TripSplit**, una
aplicación de escritorio basada en consola y desarrollada en Java.

Este documento explica cómo preparar el entorno, descargar o copiar el
proyecto, abrirlo en un entorno de desarrollo y ejecutarlo por primera
vez.

------------------------------------------------------------------------

## 1. Requisitos previos

Antes de instalar el proyecto, necesitas:

-   Un ordenador con Windows, Linux o macOS.
-   **Java JDK 8 o superior** instalado.
-   Una conexión a Internet para descargar Java o el entorno de
    desarrollo, si todavía no los tienes.
-   Un editor o IDE Java. Se recomienda **IntelliJ IDEA**. También
    puedes utilizar Eclipse o Visual Studio Code con las extensiones de
    Java.

> Es importante instalar el **JDK** (Java Development Kit), no solamente
> un entorno de ejecución. El JDK incluye `javac`, necesario para
> compilar el programa.

## 2. Instalar Java JDK

1.  Accede a la página oficial de descargas de Java:\
    https://www.oracle.com/java/technologies/downloads/
2.  Descarga el instalador del JDK compatible con tu sistema operativo.
3.  Ejecuta el instalador y sigue los pasos indicados.
4.  Cuando termine, abre una terminal o consola nueva.

Comprueba que Java está instalado:

``` bash
java -version
```

Comprueba también que está disponible el compilador:

``` bash
javac -version
```

Si ambos comandos muestran una versión, el entorno está preparado.

Si `java` o `javac` no se reconocen, revisa la instalación y la
configuración de la variable `PATH` del sistema. En Windows, puede ser
necesario añadir la carpeta `bin` de la instalación del JDK a dicha
variable.

## 3. Descargar el proyecto

Descarga el proyecto desde el repositorio o recibe la carpeta del
proyecto en formato ZIP.

Si lo has recibido comprimido:

1.  Localiza el archivo ZIP.
2.  Pulsa con el botón derecho y selecciona **Extraer todo**.
3.  Elige una ubicación para guardar la carpeta.
4.  Comprueba que dentro se encuentra el archivo `AgenciaViajes.java`.

La estructura necesaria para compilarlo desde consola es:

``` text
TripSplit/
└── AgenciaDeViajes/
    └── AgenciaViajes.java
```

**Importante:** conserva la carpeta `AgenciaDeViajes`, ya que coincide
con el paquete declarado al principio del archivo Java.

## 4. Abrir el proyecto en IntelliJ IDEA

1.  Abre IntelliJ IDEA.
2.  Selecciona **Open** (Abrir).
3.  Busca y selecciona la carpeta `TripSplit` que contiene el proyecto.
4.  Espera a que IntelliJ cargue los archivos.
5.  Si solicita configurar un JDK, selecciona el JDK instalado en el
    apartado anterior.
6.  Abre `AgenciaViajes.java`.
7.  Pulsa el icono verde de ejecución situado junto al método `main`, o
    utiliza la opción **Run**.

No es necesario instalar dependencias externas para ejecutar el código
proporcionado.

## 5. Compilar y ejecutar desde la terminal

También puedes utilizar el proyecto sin instalar un IDE.

Abre una terminal en la carpeta que contiene `AgenciaDeViajes` y
ejecuta:

### Windows

``` powershell
javac AgenciaDeViajes\AgenciaViajes.java
java AgenciaDeViajes.AgenciaViajes
```

### Linux y macOS

``` bash
javac AgenciaDeViajes/AgenciaViajes.java
java AgenciaDeViajes.AgenciaViajes
```

El primer comando compila el archivo Java y genera el archivo `.class`.
El segundo inicia la aplicación.

## 6. Solución de problemas de instalación

### El sistema no reconoce `java`

Comprueba que el JDK se ha instalado correctamente. Cierra y vuelve a
abrir la terminal después de instalarlo. Si sigue sin funcionar, revisa
la variable `PATH`.

### El sistema no reconoce `javac`

Probablemente se ha instalado solamente un entorno de ejecución o la
carpeta `bin` del JDK no está incluida en `PATH`. Instala un JDK y
revisa su configuración.

### Error relacionado con el paquete `AgenciaDeViajes`

Comprueba que el archivo `AgenciaViajes.java` está dentro de una carpeta
llamada exactamente `AgenciaDeViajes` y que estás ejecutando los
comandos desde la carpeta superior.

### IntelliJ IDEA no permite ejecutar el archivo

Comprueba que el proyecto tiene configurado un JDK. Puedes seleccionarlo
desde **File → Project Structure → Project SDK**.

### Los colores no aparecen correctamente

La aplicación utiliza códigos de color ANSI. Algunas consolas o
terminales pueden no mostrarlos correctamente. Prueba a ejecutar el
programa desde una terminal moderna.

------------------------------------------------------------------------

## 7. Información del proyecto

-   **Nombre:** TripSplit
-   **Lenguaje:** Java
-   **Tipo:** Aplicación de consola
-   **Clase principal:** `AgenciaViajes`
-   **Paquete:** `AgenciaDeViajes`
-   **JDK requerido:** Java 8 o superior
-   **Dependencias externas:** No requiere

## 8. Presupuesto del proyecto

El proyecto cuenta con un presupuesto orientativo adjunto, elaborado
como simulación académica por **NEXORA Soluciones Digitales**.

-   Base imponible: 420,00 €
-   IVA (21 %): 88,20 €
-   Total estimado: **508,20 €**

Este presupuesto es una simulación académica y no constituye una factura
fiscal ni acredita una operación comercial real.

------------------------------------------------------------------------

**TripSplit --- Guía de instalación**
