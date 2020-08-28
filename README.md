# ABM Pedidos - RESTful API

Evaluación técnica para Navent. Api REST para alta, baja y modificación de pedidos.

## Requerimientos

- Java 8
- Maven

## Ejecución

**1. Clonar este repositorio**

**2. Ejecutar la aplicación con el siguiente comando**

```bash
mvn spring-boot:run
```

**3. El cliente HTML estará disponible en <http://localhost:8080/abm-pedidos>**


---


## Punto 2

Suponiendo que la tabla Pedidos tiene muchos registros y columnas, hay ciertas medidas que se podrían tomar en la aplicación para potenciar la eficiencia a la hora de realizar consultas desde un sitio web:
-	Implementar paginación en la devolución masiva de pedidos.
-	Indexar la tabla en la base de datos para acelerar el motor en la búsqueda.
-	Utilizar concurrencia de instancias implementando una única cache, en Redis por ejemplo, para aumentar la performance y reducir el acceso a base de datos
-	Almacenar los datos de tipo BLOB en una tabla aparte y acceder únicamente a la información necesaria en la solicitud actual.
-	Optimizar la cantidad de accesos a la base de datos. Por ejemplo, utilizando un repositorio JPA.
