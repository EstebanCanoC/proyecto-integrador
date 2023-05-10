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

# ClienteService( );

implementa las operaciones CRUD para la entidad Cliente, proporcionando métodos para crear, actualizar, eliminar y obtener un cliente por su número de identificación.

```json
{
  "apellido": "Mesa",
  "cedula": 1124589846,
  "celular": "3185678132",
  "ciudad": "Pereira",
  "correoElectronico": "FlorezCamila@gmail.com",
  "direccionResidencia": "Carrera 82 # 56 - 24",
  "nombre": "Laura"
}
```

Al momento de hacer uso del metodos HTTP
# POST PUT DELETE GET
en la ruta 
api/v1/clientes

# EmpleadoService( ); 

implementa las operaciones CRUD para la entidad Empleado, proporcionando métodos para crear, actualizar, eliminar y obtener un empleado por su número de identificación.

PaqueteService implementa la operación de crear un paquete para la entidad Paquete, donde se establece el tipo de paquete (liviano, mediano o grande) en función del peso del paquete, se asigna el peso y el valor declarado del paquete, y se guarda en el repositorio de paquetes. Cabe destacar que este servicio no implementa la operación de eliminar o actualizar un paquete, por lo que no es un servicio CRUD completo para la entidad Paquete.

```json
{
  "antiguedadEmpresa": 5,
  "apellido": "Perez",
  "cargo": "CONDUCTOR",
  "cedula": 1158459275,
  "celular": "3209848989",
  "ciudad": "Cali",
  "correoElectronico": "Jaime5@gmail.com",
  "direccionResidencia": "Calle 5 # 123 - 231",
  "nombre": "Jaime",
  "rh": "AB+"
}
```

Al momento de hacer uso del metodos HTTP
# POST PUT DELETE GET
en la ruta 
api/v1/clientes

<img alt="![Objeto]" src="https://github.com/EstebanCanoC/proyecto-integrador/assets/72243661/567e049e-f0c8-470c-bd48-d2b6aab5412f" width=320>

# EnvioService

se encarga de gestionar los envíos de paquetes. La clase utiliza los servicios de otras tres clases (ClienteService, PaqueteService, y EmpleadoService) y se comunica con una base de datos a través del objeto EnvioRepository.

La clase EnvioService tiene dos métodos públicos:

# crearEnvio( );

Este método recibe un objeto CrearEnvioDTO, que contiene información sobre el envío a crear, como la información del cliente, el peso del paquete y la dirección de entrega. El método primero utiliza el objeto ClienteService para obtener el cliente correspondiente a la cédula proporcionada en el CrearEnvioDTO. Luego utiliza el objeto PaqueteService para crear un nuevo objeto Paquete con el peso y valor declarado del paquete. Después, calcula el valor del envío basado en el peso y lo almacena junto con la información del envío y el objeto Paquete en la base de datos utilizando el objeto EnvioRepository. Finalmente, devuelve un objeto CrearEnvioRespuestaDTO, que contiene el número de guía del envío creado y su estado.

Para crear un envio se utiliza el metodo Post
# POST
```json
{
  "cedulaCliente": "1128450373",
    "ciudadOrigen": "Cali",
    "ciudadDestino": "Medellin",
    "direccionDestino": "Calle 45 #67 - 89",
    "nombreRecibe": "Juan Casas",
    "celular": "3117348990",
    "valorDeclaradoPaquete": 12000,
    "peso": 1
}
```

# obtenerEnvioPorNumeroGuia( );

Este método recibe un número de guía y utiliza el objeto EnvioRepository para buscar en la base de datos el envío correspondiente a ese número de guía. Si encuentra el envío, devuelve un objeto EnvioDTO que contiene información sobre el envío, incluyendo la información del cliente, la dirección de entrega, el peso del paquete y su valor declarado, así como el estado actual del envío.

Además, la clase EnvioService tiene dos métodos privados:

generarNumGuia: Este método genera un número de guía único para cada envío utilizando la clase UUID de Java.

generarValorEnvio: Este método calcula el valor del envío basado en el peso del paquete. Si el peso es menor que 2kg, el valor es de $30.000; si está entre 2kg y 5kg, el valor es de $40.000; y si es mayor que 5kg, el valor es de $50.000.

