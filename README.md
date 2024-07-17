# ForoHub API

ForoHub es una plataforma diseñada para gestionar discusiones en torno a diversos temas, particularmente útil para contextos educativos y de colaboración. Este proyecto fue desarrollado utilizando Spring Boot y se apoya en la seguridad y manejo de transacciones de Jakarta para garantizar la fluidez y seguridad en las interacciones de la base de datos.

## Características

- **Registro y autenticación de usuarios**: Permite a los usuarios registrarse y autenticarse para participar en los foros.
- **Gestión de tópicos**: Los usuarios pueden crear, obtener, actualizar y eliminar tópicos de discusión.
- **Paginación de tópicos**: Listado de tópicos con soporte de paginación para mejorar la performance en listados grandes.
- **Seguridad con tokens JWT**: Uso de JSON Web Tokens para gestionar la autenticación y autorización de los usuarios.

## Tecnologías Utilizadas

- **Spring Boot**: Utilizado como el framework principal para el desarrollo de la aplicación.
- **Jakarta Persistence (JPA)**: Para la gestión de las entidades y la interacción con la base de datos.
- **Jakarta Transactional**: Gestión de transacciones para asegurar la consistencia de los datos.
- **Spring Security**: Para la seguridad, autenticación y autorización dentro de la aplicación.
- **Swagger/OpenAPI**: Documentación de la API y pruebas de los endpoints mediante interfaz gráfica.
- **H2 Database**: Base de datos en memoria utilizada para desarrollo y pruebas.
