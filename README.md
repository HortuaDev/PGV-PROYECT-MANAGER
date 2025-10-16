# Administrador De Productos:

## UD1 – Práctica – Programación multiproceso

## Problema a resolver:

Una empresa tiene en diferentes archivos, en los cuales hay almacenados distintos productos desorganizadamente, hay productos de tecnologia, higiene, alimentos, etc.

Devido a la desorganizacion, se solicita que un programa revise todos estos archivos, los organice, los almacene en otro archivo, y los muestre por consola para que el personal pueda clasificarlos de manera adecuada.

## Descripcion de la solucion

Programa en Java que lee varios ficheros de productos en paralelo (cada fichero puede procesarse en un subproceso), fusiona y organiza los registros en un único fichero de salida y, finalmente, muestra ese fichero por consola.

## Estructura del proyecto

- src/net/salesianos/... — código fuente
- src/net/salesianos/files/input/ — ficheros de entrada (varios)
- src/net/salesianos/files/output/ — fichero de salida generado
- README.md

## Formato de los ficheros de entrada

Se recomienda un formato CSV simple por línea, por ejemplo:
`id,nombre,categoria,cantidad,precio`

Ejemplo:

```
1,Televisor,tecnologia,8,499.99
2,Shampoo,higiene,25,4.50
```

## Comportamiento del programa

- Escanea un directorio de entrada para localizar ficheros de productos.
- Crea subprocesos para leer cada fichero de forma concurrente.
- Normaliza/valida registros (p. ej. tipos y duplicados).
- Fusiona todos los registros en un único fichero de salida (p. ej. data/output/fileResult.csv).
- Ordena los registros por un campo configurable (por ejemplo id o nombre).
- Al finalizar, lee el fichero de salida y lo muestra por consola.

## Uso (ejemplos)

### Guía de inicio rápido

1. Clona el repositorio:

```cmd
git clone https://github.com/tu-usuario/PGV-PROYECT-MANAGER.git
```

2. Abre el proyecto en VSCode:

```cmd
cd PGV-PROYECT-MANAGER
code .
```

3. Asegúrate de tener instalado:

- Java JDK 11 o superior
- Extension Pack for Java en VSCode

4. Ejecuta el programa:
   presiona clik derecho sobre el archivo `App.java` y seleciona la opcion `Run Java`

![Ejecutar programa](./images/ejemplo_run_java.png)

## Ejemplo de salida por consola

Al terminar, el programa imprimirá algo tipo:

`Fichero generado: data/output/fileResult.csv
Registros totales: 124
Mostrando 10 primeros registros:
1,Mouse,12.50,10
2,Teclado,25.00,5
...`
