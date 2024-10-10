# ![Portada](https://i.imgur.com/UDujezt.jpeg)

# ColorPop

El backend de este aplicativo de punto de venta (POS) está diseñado para ofrecer una robusta API RESTful que permite la interacción entre el servidor y el frontend, facilitando el intercambio de datos en formato JSON. Implementado con Spring Boot y Java JPA, el sistema maneja operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para gestionar usuarios, productos y transacciones. Los verbos HTTP se utilizan para definir las rutas de la API: `GET` para obtener información sobre productos y ventas; `POST` para crear nuevos registros; `PUT` para actualizar datos existentes; y `DELETE` para eliminar registros no deseados. Esta estructura permite que el frontend consuma eficientemente la API, mostrando la información de manera dinámica en la interfaz de usuario. Al utilizar un generador de tokens para la autenticación, se garantiza que solo los usuarios autorizados puedan realizar cambios, lo que añade una capa adicional de seguridad al sistema. En conjunto, esta arquitectura no solo optimiza el flujo de datos entre el cliente y el servidor, sino que también facilita la escalabilidad y mantenibilidad del aplicativo a largo plazo.

### link del sistema pos 

[POS](https://github.com/Alejandramzp/Proyecto_FRONT_SpringBoot_MunozPaula-PargaHelen-CeballosKenneth.git)

### Requerimientos para Iniciar con Bases de Datos

**Definición de Base de Datos:** Una base de datos es un conjunto organizado de datos que permite almacenar, gestionar y recuperar información de manera eficiente. Las bases de datos son fundamentales para aplicaciones y sistemas que requieren almacenamiento de datos estructurados.

### Modelos de Bases de Datos

#### 	1. Modelo Conceptual

- **Descripción:** Es la representación abstracta de los datos, que captura las entidades y sus relaciones sin entrar en detalles técnicos. Se centra en qué datos son necesarios y cómo se relacionan entre sí.

- **Objetivo:** Facilitar la comprensión de los datos y su estructura a un nivel alto, generalmente utilizando diagramas como el Diagrama Entidad-Relación (ER).

  ![concepuaal](https://i.imgur.com/rh3jff5.png)

#### 	2. Modelo Lógico

- **Descripción:** Se basa en el modelo conceptual pero introduce elementos más técnicos, como la definición de tablas, campos y relaciones, sin preocuparse por cómo se implementará físicamente.

- **Objetivo:** Proporcionar una estructura que se pueda traducir directamente a un sistema de gestión de bases de datos (SGBD), definiendo cómo se organizarán los datos.

  ![concepuaal](https://i.imgur.com/4EobxAY.png)



#### 	3. Modelo Físico(UML)

- **Descripción:** Es la implementación real de la base de datos en un sistema específico. Incluye detalles sobre la estructura de almacenamiento, tipos de datos y optimización del rendimiento.
- **Objetivo:** Asegurar que la base de datos esté diseñada para funcionar de manera eficiente en el hardware y software utilizados.



![img](https://i.imgur.com/Ii5QF5F.png)

###  Creación de la Base de Datos

**Proceso de Creación:** Después de definir los modelos conceptual, lógico y físico, se procede a crear la base de datos en el SGBD elegido. Este proceso incluye:

1. **Definición de Tablas:** Las tablas son estructuras que almacenan datos en filas y columnas.

2. Registro de 6 Tablas:

   Se registrarán seis tablas en total, cada una diseñada para almacenar un tipo específico de información. Por ejemplo:

   - **Usuarios:**  información para el ingreso al aplicativo (empleados).
   - **Productos:** Detalles de los productos.
   - **Ventas:** Registro de pedidos realizados.
   - **Empleados:** registro de personal .
   - **Detalles_ventas:** detalle de cada una de las ventas ya realizadas
   - **Carrito:** información de selección por el cliente 

   

   ### Backup (copia de seguridad) 

   Un backup es una copia de los datos de una base de datos que se almacena en un lugar seguro. Esta copia puede ser utilizada para restaurar la base de datos a un estado anterior en caso de que los datos originales se pierdan o se dañen.

   ### Resguardo de Datos en la Base de Datos

   Este proyecto implementa un sistema de resguardo para los datos de varias tablas, asegurando que se mantenga un historial de la información eliminada. Las siguientes tablas son creadas para almacenar la información de resguardo:

   

   ### Tablas de Resguardo

   1. **`productos_resguardo`**

      - **Descripción**: Almacena un historial de los productos eliminados.

      - ```mysql
        CREATE TABLE productos_resguardo (
            id BIGINT,
            codigo_producto VARCHAR(50),
            nombre VARCHAR(100),
            descripcion TEXT,
            precio DECIMAL(10, 2),
            cantidad_disponible INT,
            fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            PRIMARY KEY (id, fecha_resguardo)
        );
        ```

        

   2. **`empleados_resguardo`**

      - **Descripción**: Almacena un historial de los empleados eliminados.

        - ```mysql
          CREATE TABLE empleados_resguardo (
              id BIGINT,
              identificacion VARCHAR(100),
              nombres VARCHAR(255),
              apellidos VARCHAR(255),
              direccion VARCHAR(255),
              telefono VARCHAR(100),
              rol ENUM('Administrador', 'Gerente', 'Cajero'),
              estado ENUM('Activo', 'Inactivo'),
              fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
              PRIMARY KEY (id, fecha_resguardo)
          );
          
          ```

          

   3. **`usuarios_resguardo`**

      - **Descripción**: Almacena un historial de los usuarios eliminados.

      - ```mysql
        CREATE TABLE usuarios_resguardo (
            id BIGINT,
            id_empleado BIGINT,
            username VARCHAR(255),
            password VARCHAR(255),
            fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            PRIMARY KEY (id, fecha_resguardo),
            FOREIGN KEY (id_empleado) REFERENCES empleados_resguardo(id)
        );
        
        ```

        

   4. **`carrito_resguardo`**

      - **Descripción**: Almacena un historial de los carritos eliminados.

      - ```mysql
        CREATE TABLE carrito_resguardo (
            id BIGINT,
            id_usuario BIGINT,
            id_producto BIGINT,
            cantidad INT,
            precio_unitario DECIMAL(10, 2),
            fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            PRIMARY KEY (id, fecha_resguardo),
            FOREIGN KEY (id_usuario) REFERENCES usuarios_resguardo(id),
            FOREIGN KEY (id_producto) REFERENCES productos_resguardo(id)
        );
        
        ```

        

   5. **`ventas_resguardo`**

      - **Descripción**: Almacena un historial de las ventas eliminadas.

      - ```mysql
        CREATE TABLE ventas_resguardo (
            id BIGINT,
            numero_venta VARCHAR(50),
            id_empleado BIGINT,
            fecha TIMESTAMP,
            total DECIMAL(10, 2),
            fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            PRIMARY KEY (id, fecha_resguardo),
            FOREIGN KEY (id_empleado) REFERENCES empleados_resguardo(id)
        );
        ```

        

   6. **`detalles_venta_resguardo`**

      - **Descripción**: Almacena un historial de los detalles de ventas eliminados.

      - ```mysql
        CREATE TABLE detalles_venta_resguardo (
            id BIGINT,
            id_venta BIGINT,
            id_producto BIGINT,
            cantidad INT,
            precio_unidad DECIMAL(10, 2),
            fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            PRIMARY KEY (id, fecha_resguardo),
            FOREIGN KEY (id_venta) REFERENCES ventas_resguardo(id),
            FOREIGN KEY (id_producto) REFERENCES productos_resguardo(id)
        );
        ```

        ### Triggers

        Se han implementado triggers para registrar automáticamente en las tablas de resguardo cuando se elimina un registro de las tablas originales. Esto garantiza que siempre tengamos un historial de las eliminaciones.

        - **Trigger `after_producto_delete`**: Registra datos del producto eliminado en `productos_resguardo`.
        - **Trigger `after_empleado_delete`**: Registra datos del empleado eliminado en `empleados_resguardo`.
        - **Trigger `after_usuario_delete`**: Registra datos del usuario eliminado en `usuarios_resguardo`.
        - **Trigger `after_carrito_delete`**: Registra datos del carrito eliminado en `carrito_resguardo`.
        - **Trigger `after_venta_delete`**: Registra datos de la venta eliminada en `ventas_resguardo`.
        - **Trigger `after_detalle_venta_delete`**: Registra datos del detalle de venta eliminado en `detalles_venta_resguardo`.

   

   ### 	  Funciones 

   ​	        Una **función** es un bloque de código que realiza una tarea específica y se puede reutilizar en diferentes partes de un programa 

   - ​        Se define con un nombre y puede aceptar parámetros y devolver un resultado.

   - ​        Permite la reutilización de código y la abstracción de la complejidad.

     **En Bases de Datos**:

     ​        Puedes crear funciones para realizar cálculos o transformaciones sobre datos.

     ​        Se pueden usar en consultas SQL para manipular datos.

   ###    Procedimientos 

    Un **procedimiento almacenado** (o simplemente **procedimiento**) en MySQL es un conjunto de instrucciones SQL que se agrupan para                              realizar  una tarea específica. Estos procedimientos se almacenan en la base de datos y pueden ser llamados desde otras consultas o aplicaciones.

   ###   Eventos 

   un **evento** es una tarea programada que se ejecuta automáticamente en el servidor de base de datos en un momento específico o en intervalos regulares. En MySQL, los eventos se utilizan para realizar tareas como mantenimiento de datos, actualizaciones periódicas o ejecución de procedimientos almacenados de manera automatizada.

   ### Uso de IntelliJ para Desarrollar la Aplicación

   #### 1. Configuración de IntelliJ

   - La versión Community es suficiente para este tipo de proyectos.

   - Abre IntelliJ y selecciona "New Project".
   - Elige "Spring Initializr" para crear un nuevo proyecto Spring Boot.

   #### 5.2. Descarga del Archivo Spring Boot

   - **Selecciona Dependencias:**
     - Al crear el proyecto, selecciona las siguientes dependencias:
       - **Spring Web**: Para desarrollar aplicaciones web.
       - **Spring Data JPA**: Para la gestión de la base de datos.
       - **MySQL Driver**: Para conectarte a la base de datos MySQL.
   - **Nombre del Proyecto:** Llama al proyecto "colorpop".

   ### 6. Creación de la Arquitectura MCD (Modelo Conceptual de Datos)

   La arquitectura **MDC** (Modelo de Dominio Controlador) en Java es un patrón arquitectónico que se utiliza para organizar el código de aplicaciones, especialmente en el contexto de aplicaciones web. Aunque el término no es tan común como MVC (Modelo-Vista-Controlador), en algunas discusiones se refiere a una organización similar, donde el enfoque está en la separación de las responsabilidades y la organización del dominio de la aplicación.

   

   ![img](https://i.imgur.com/9Tu3MBW.png)

   ####  Creación de Entidades

   - **Definición de Entidades:** Para cada tabla que creaste en la base de datos, deberás crear una clase de entidad en tu proyecto Spring Boot. Cada entidad representará una tabla y tendrá atributos que correspondan a las columnas de la tabla.Como ejemplo se utilizara este codigo 



#### **Model** 

Es fundamental para estructurar los datos, gestionar la lógica de negocio, interactuar con la base de datos y mantener la aplicación organizada y fácil de mantener. En el contexto de una aplicación de e-commerce, el modelo permite gestionar aspectos esenciales como los carritos de compra de los usuarios de manera eficiente y efectiva.

```java
package com.example.ColorPop.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto id_producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_unitario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}

```

La clase `Carrito` actúa como un modelo de datos que mapea a la tabla `carrito` en la base de datos, facilitando la gestión de los artículos que un usuario desea comprar. Las relaciones con otras entidades (`Usuario` y `Producto`) permiten mantener la integridad de los datos y facilitar operaciones complejas como la consulta y la manipulación de datos en la base de datos.



#### **Repository** 

un repositorio es una capa que se encarga de gestionar la lógica de acceso a datos, proporcionando una interfaz limpia y abstraída para trabajar con esos datos. Esto promueve la separación de preocupaciones, facilita las pruebas y permite a los desarrolladores centrarse en la lógica de negocio sin preocuparse por los detalles de la persistencia.

```java
package com.example.ColorPop.Repository;

import com.example.ColorPop.Model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
} 
```

 `CarritoRepository` es una interfaz que permite realizar operaciones de acceso a datos para la entidad `Carrito`. Al heredar de `JpaRepository`, proporciona una serie de métodos útiles que simplifican el trabajo con la base de datos, permitiendo a los desarrolladores enfocarse en la lógica de negocio sin tener que escribir código repetitivo para las operaciones CRUD (Crear, Leer, Actualizar, Eliminar).



#### **Service**

Un **servicio** es una parte de una aplicación que se encarga de manejar las reglas y la lógica detrás de cómo se deben tratar los datos. Es como un intermediario entre la parte de la aplicación que muestra información al usuario (la interfaz) y la parte que se encarga de almacenar esos datos (la base de datos).

```java
package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Carrito;
import com.example.ColorPop.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> getAllCarritos(){
        return carritoRepository.findAll();
    }

    public Optional<Carrito> getCarritoById(Long id){
        return carritoRepository.findById(id);
    }

    public Carrito saveCarrito(Carrito carrito){
        return carritoRepository.save(carrito);
    }

    public void deleteCarrito(Long id){
        carritoRepository.deleteById(id);
    }

    public Carrito updateCarrito(Long id, Carrito carritoDetails){
        Carrito carrito = carritoRepository.findById(id).orElseThrow();

        carrito.setId_usuario(carritoDetails.getId_usuario());
        carrito.setId_producto(carritoDetails.getId_producto());
        carrito.setCantidad(carritoDetails.getCantidad());
        carrito.setPrecio_unitario(carritoDetails.getPrecio_unitario());

        return carritoRepository.save(carrito);
    }
}
```

 `CarritoService` es responsable de encapsular la lógica de negocio relacionada con los carritos de compras. Proporciona métodos para recuperar, guardar, eliminar y actualizar carritos utilizando el `CarritoRepository`, facilitando así la interacción con los datos de la aplicación de manera organizada y eficiente. Esto ayuda a mantener una buena separación de responsabilidades entre la capa de presentación y la lógica de negocio.

#### **Controller**

Un controlador es una clase que actúa como intermediaria entre la interfaz de usuario (la vista) y la lógica de negocio (el servicio y el modelo). Su objetivo principal es gestionar las solicitudes del usuario y coordinar la respuesta adecuada.

```java
package com.example.ColorPop.Controller;


import com.example.ColorPop.Model.Carrito;
import com.example.ColorPop.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> getAllCarrito() {
        try {
            List<Carrito> carritos = carritoService.getAllCarritos();
            return ResponseEntity.ok(carritos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable Long id) {
        try {
            Carrito carrito = carritoService.getCarritoById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado"));
            return ResponseEntity.ok(carrito);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Carrito> createCarrito(@RequestBody Carrito carrito) {
        try {
            Carrito nuevoCarrito = carritoService.saveCarrito(carrito);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCarrito);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
        try {
            Carrito carritoActualizado = carritoService.updateCarrito(id, carrito);
            return ResponseEntity.ok(carritoActualizado);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable Long id) {
        try {
            carritoService.deleteCarrito(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
```

`CarritoController` es responsable de manejar las interacciones HTTP relacionadas con los carritos de compra. Cada método define cómo responder a diferentes tipos de solicitudes (GET, POST, PUT, DELETE) y utiliza `CarritoService` para realizar las operaciones necesarias sobre los carritos. El controlador asegura que las respuestas se devuelvan en un formato adecuado y maneja errores de manera que el cliente reciba información clara sobre el estado de las operaciones.

### **Documentacion de la API**

[Swagger](https://app.swaggerhub.com/apis-docs/PaulaMunoz/ColorPop/1.0.0)

### Cors

CORS (Cross-Origin Resource Sharing) es un mecanismo de seguridad implementado por los navegadores web que permite o restringe las solicitudes HTTP entre diferentes dominios. De manera predeterminada, un navegador impide que una página web realice solicitudes a un dominio diferente del que sirvió la página (esto se conoce como "Same-Origin Policy"). Sin embargo, con CORS, un servidor puede indicar al navegador qué dominios están permitidos para hacer solicitudes a ese servidor.

```java
package com.example.ColorPop.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura CORS para los endpoints que comienzan con /api/
        registry.addMapping("/**") // Permitir CORS para todas las rutas que comienzan con /api/
                .allowedOriginPatterns("*") // Permitir solicitudes desde cualquier origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTION") // Métodos permitidos
                .allowedHeaders("*") // Permitir todos los encabezados
                .allowCredentials(true); // Permitir credenciales (cookies, autorización)
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://127.0.0.1:5500/");
        configuration.addAllowedOrigin("http://172.16.101.161/");
        configuration.addAllowedMethod("*"); //
        configuration.addAllowedHeader("*");  // Permitir todos los encabezados
        configuration.setAllowCredentials(true);  // Permitir credenciales (cookies, headers de autenticación)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // Aplicar configuración a todas las rutas
        return source;
    }
    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(corsConfigurationSource());
    }
}
```

Este código asegura que las solicitudes de distintos dominios puedan interactuar con la API, respetando reglas definidas para métodos permitidos, orígenes, encabezados, y el uso de credenciales.



### Security Config

Esta clase define cómo se maneja la seguridad de la aplicación, especificando qué rutas requieren autenticación, qué roles tienen acceso a ciertos endpoints y cómo se encriptan las contraseñas para mayor seguridad.

```java
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Nueva forma de deshabilitar CSRF en Spring Security 6.1+
                .authorizeHttpRequests(auth -> auth
                        // === Acceso público ===
                        .requestMatchers("/api/login").permitAll()  // Cualquier usuario puede acceder al login
                        .requestMatchers("/api/ventas/").hasAuthority("Cajero") // Cajero solo puede registrar ventas
                        .requestMatchers("/api/inventarios/").hasAuthority("Gerente") // Gerente gestiona inventarios y reportes
                        .requestMatchers("/api/empleados/").hasAuthority("Administrador") // Admin gestiona empleados

                        .anyRequest().authenticated() // Otras rutas requieren autenticación
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Sin estado (stateless)

        // Añadir el filtro JWT antes del filtro de autenticación de usuario
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
```

Este código define la configuración de seguridad de una aplicación utilizando **Spring Security**, configura la seguridad de la aplicación para que:

- Permita el acceso público al endpoint de login.

- Restringe el acceso a diferentes endpoints según los roles (autoridades) del usuario: **Cajero**, **Gerente**, y **Administrador**.

- Utiliza autenticación basada en **tokens JWT** y asegura que la aplicación sea **stateless**, es decir, no se manejen sesiones de usuario en el servidor.

  

  

### JWT 

```java
package com.example.ColorPop.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ColorPop.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
private static final long EXPIRATION_TIME = 36_000_000; // 10 horas en milisegundos

// Generar un token JWT
public String generateToken(String username) {
    return JWT.create()
            .withSubject(username)
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC256(SECRET_KEY));
}

// Extraer el username del token
public String extractUsername(String token) {
    DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY))
            .build()
            .verify(token);
    return decodedJWT.getSubject();
}

// Validar el token
public boolean validateToken(String token, Usuario usuario) {
    String username = extractUsername(token);
    return username.equals(usuario.getUsername()) && !isTokenExpired(token);
}

// Verificar si el token ha expirado
private boolean isTokenExpired(String token) {
    DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET_KEY))
            .build()
            .verify(token);
    return decodedJWT.getExpiresAt().before(new Date());
} 
}
```

El `JwtService` es un componente de Spring que gestiona la generación y validación de tokens JWT (JSON Web Tokens). Este servicio permite crear tokens para un usuario específico con un tiempo de expiración de 10 horas, extraer el nombre de usuario del token y validar su autenticidad, asegurando que el token corresponda al usuario y que no haya expirado. A través de métodos como `generateToken`, `extractUsername` y `validateToken`, se facilita la gestión segura de la autenticación en la aplicación, protegiendo así los recursos y las interacciones del usuario.

### Tecnologías Utilizadas

- **Spring Boot**: Framework para el desarrollo del backend.  
- **Java**: Lenguaje de programación utilizado. 
- **Arquitectura MVC**: Estructazzura del proyecto backend.
- **JWT (JSON Web Token)**: Generación de tokens de seguridad para la autenticación de usuarios.
- **MySQL** 
- **Swagger**

###  Creado por: 

- Paula Muñoz

- Helen Parga 

- Kenneth Ceballos
