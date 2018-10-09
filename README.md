# Arquitectura de un mini API-Rest simulado
 Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código.
 #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*


## Tecnologías necesarias
* Java
* Maven
* GitHub

## Diseño de entidades
![themes-architecture-diagram](https://github.com/miw-upm/APAW-themes-layers/blob/develop/docs/themes-entities-class-diagram.png)

## API
### POST /review
#### Parámetros del cuerpo
- `title`: String (**requerido**)
- `text`: String
- `rating`: int (**requerido**)
#### Respuesta
- 200 OK
  - `id`: String
  -`date`: LocalDateTime
- 403 BAD_REQUEST
---
### PUT /users/{id}
#### Parámetros del cuerpo
- `nick`: String (**requerido**)
- `email`: String
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### POST /suggestions
#### Parámetros del cuerpo
- `negative`: Boolean (**requerido**)
- `description`: String (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
---
### POST /themes
#### Parámetros del cuerpo
- `reference`: String (**requerido**)
- `category`: Category
- `userId`: String
#### Respuesta
- 200 OK
  - `id`: String
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /themes
#### Respuesta
- 200 OK
  - `[ {id:String,reference:String} ]`
---
### DELETE /themes/{id}
#### Respuesta
- 200 OK
---
### POST /themes/{id}/votes
#### Parámetros del cuerpo
- `value`: Integer (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /themes/{id}/average
#### Respuesta
- 200 OK
  - `average`: Double
- 404 NOT_FOUND
---
### PATH /themes/{id}/category
#### Parámetros del cuerpo
- `category`: String (**requerido**)
#### Respuesta
- 200 OK
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /themes/search?q=average:>=3
#### Respuesta
- 200 OK
  - `[ {id:String,reference:String} ]`
- 403 BAD_REQUEST

