# PROYECTO FINAL MAKAIA



El proyecto < Mensajería <img alt="LOGO-MAKAIA-EN-CURVAS-1" src="https://github.com/EstebanCanoC/proyecto-integrador/assets/72243661/825120f0-6c28-459f-9d51-02ab572a5b84" width=80 > > es una aplicación web desarrollada con Spring Boot que ofrece a los usuarios la capacidad de realizar un seguimiento y control de los clientes, empleados y envíos de paquetes a través de una interfaz amigable. La API utiliza el protocolo HTTP para permitir que los usuarios interactúen con el sistema a través de una serie de endpoints de API definidos.

Para el desarrollo del proyecto, se utilizó Gradle-Groovy como gestor de dependencias y Java 11 como lenguaje de programación. La base de datos está alojada en MySQL y se maneja mediante JPA e Hibernate 

Uno de los microservicios implementados en la aplicación es el sistema de gestión de envíos de paquetes. Con esta herramienta, los usuarios pueden crear nuevos envíos, actualizar el estado de los envíos existentes y consultar información detallada sobre los mismos. Además, el sistema de gestión de envíos cuenta con la funcionalidad de generar un número de guía único para cada envío, lo que facilita la identificación y seguimiento de los paquetes.


# Tecnologías utilizadas

# Spring Boot Framework. <img alt="spring-boot-seeklogo com" src="https://github.com/EstebanCanoC/proyecto-integrador/assets/72243661/a16fc417-d28b-4456-a772-43650d20e99f" width=120>

Gradle como Gestor de dependencias.

Lombok para generar anotaciones.

Bases de datos: MySQL.

JPA e Hibernate.

# Funcionalidades

operaciones CRUD (Crear, Leer, Actualizar y Borrar) para las entidades del sistema:

<img alt="[crud]" src="https://github.com/EstebanCanoC/proyecto-integrador/assets/72243661/b8e6b220-92cc-4af5-810e-8cf09bbfae45">

# ClienteService();

implementa las operaciones CRUD para la entidad Cliente, proporcionando métodos para crear, actualizar, eliminar y obtener un cliente por su número de identificación.

# EmpleadoService(); 

implementa las operaciones CRUD para la entidad Empleado, proporcionando métodos para crear, actualizar, eliminar y obtener un empleado por su número de identificación.

PaqueteService implementa la operación de crear un paquete para la entidad Paquete, donde se establece el tipo de paquete (liviano, mediano o grande) en función del peso del paquete, se asigna el peso y el valor declarado del paquete, y se guarda en el repositorio de paquetes. Cabe destacar que este servicio no implementa la operación de eliminar o actualizar un paquete, por lo que no es un servicio CRUD completo para la entidad Paquete.
