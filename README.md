# Arquitectura de un mini API-Rest simulado
 Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código.
 #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*


## Tecnologías necesarias
* Java
* Maven
* GitHub

## Diseño de entidades
![Entidades](https://github.com/BrunoML1991/APAW-ECP2-BrunoMartin/blob/master/docs/Entidades.png)

## API
### POST /reviews
#### Parámetros del cuerpo
- `title`: String (**requerido**)
- `text`: String
- `rating`: int (**requerido**)
#### Respuesta
- 200 OK
  - `id`: String
  - `date`: LocalDateTime
- 403 BAD_REQUEST
---
### PUT /reviews/{id}
#### Parámetros del cuerpo
- `title`: String (**requerido**)
- `text`: String
- `rating`: int (**requerido**)
#### Respuesta
- 200 OK
    - `date`: LocalDateTime
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### POST /iconicCharacters
#### Parámetros del cuerpo
- `name`: String (**requerido**)
- `role`: String
#### Respuesta
- 200 OK
    - `id`: String
- 403 BAD_REQUEST
---
### POST /videogames
#### Parámetros del cuerpo
- `title`: String (**requerido**)
- `synopsis`: String
- `category`: Category
- `company`: String
- `iconicCharacterId`: String (**requerido**)
#### Respuesta
- 200 OK
  - `id`: String
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### DELETE /videogame/{id}
#### Respuesta
- 200 OK
- 404 NOT_FOUND
---
### GET /videogame
#### Respuesta
- 200 OK
  - `[ {id:String,title:String} ]`
  - 404 NOT_FOUND
---
### PATCH /videogames/{id}/category
#### Parámetros del cuerpo
- `category`: Category (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /reviews/search?q=rating:>=7
#### Respuesta
- 200 OK
  - `[ {id:String,title:String,rating:int} ]`
- 403 BAD_REQUEST