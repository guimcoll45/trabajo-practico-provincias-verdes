# trabajo-practico-provincias-verdes
Sistema de gestión de energía solar - Trabajo Práctico
# 🟢 Sistema Provincias Verdes
**Trabajo Práctico - Análisis y Diseño de Sistemas / Programación Orientada a Objetos**

## 📋 Descripción
Sistema de gestión y monitoreo de energía solar renovable. Permite administrar usuarios, ubicaciones geográficas, equipos solares, registrar mediciones de consumo y generación, y obtener reportes detallados de rendimiento y balance energético.

El proyecto está desarrollado en **Java** aplicando los 4 pilares de la Programación Orientada a Objetos:
- ✅ Abstracción
- ✅ Encapsulamiento
- ✅ Herencia
- ✅ Polimorfismo

Además, utiliza **MySQL** para la persistencia de datos y cumple con todo el diseño modelado en **Diagrama de Clases UML** y **Diagrama Entidad-Relación**.

---

## 🗂️ Estructura del Proyecto
El código fuente está organizado por capas y paquetes según las buenas prácticas de diseño:

📦 src

┗ 📂 com

┗ 📂 provinciasverdes

┣ 📂 enumeraciones → Valores fijos del sistema (TipoUsuario, Estado, Equipo, Reporte)

┣ 📂 modelo → Clases principales y lógica de negocio (EntidadBase, Usuario, Ubicacion, etc.)

┣ 📂 negocio → Gestores, algoritmos de ordenación, búsqueda y cálculos

┣ 📂 persistencia → Conexión y acceso a la Base de Datos

┗ 📂 presentacion → Interfaz de usuario, menú principal y ejecución

---

## 🛠️ Tecnologías Utilizadas
- **Lenguaje:** Java 17 o superior
- **Base de Datos:** MySQL 8.0
- **Conector:** MySQL Connector/J (JDBC)
- **Herramientas:** NetBeans / Eclipse / IntelliJ / GitHub Codespaces
- **Modelado:** UML (Diagrama de Clases), Entidad-Relación

---

## ⚙️ Requisitos Previos
Para ejecutar el sistema correctamente necesitás tener instalado:
1.  **Java JDK** configurado en las variables de entorno.
2.  **MySQL Server** (puede ser con XAMPP, WAMP o instalación directa).
3.  Un gestor de bases de datos (phpMyAdmin, Workbench o similar).

> ⚠️ *Nota: El sistema está configurado para funcionar con contraseña vacía en MySQL (usuario `root`), tal como es la instalación estándar.*

---

## 🚀 Instalación y Ejecución

### 1. Crear la Base de Datos
Ejecutá el archivo **`script_base_datos.sql`** que se encuentra en la raíz del proyecto en tu gestor MySQL.
Esto creará automáticamente:
- La base de datos `provincias_verdes`
- Las tablas: `usuarios`, `ubicaciones`, `equipos_solares`, `registros_energia`
- Un usuario de prueba: `g@ejemplo.com` / Contraseña: `1234`

### 2. Configurar Conexión
Verificá que en el archivo `ConexionDB.java` los datos coincidan con tu configuración:
```java
private static final String URL = "jdbc:mysql://localhost:3306/provincias_verdes?useSSL=false&serverTimezone=UTC";
private static final String USUARIO = "root"; 
private static final String CLAVE = ""; // Dejar vacío si no tenés contraseña

3. Compilar y Ejecutar
Abrí el proyecto en tu IDE.
Ejecutá la clase principal: com.provinciasverdes.presentacion.Main.java
Iniciá sesión con los datos de prueba mencionados arriba.
📚 Funcionalidades Principales
🔐 Autenticación: Control de acceso por usuario y perfil (ADMIN / USUARIO).
👤 Gestión de Usuarios: Alta, baja, modificación, cambio de estado y contraseña.
📍 Gestión de Ubicaciones: Registro de provincias, direcciones y coordenadas geográficas.
🔌 Gestión de Equipos: Registro de paneles, inversores y baterías con cálculo automático de capacidad total.
📊 Registro de Mediciones: Carga de datos de generación, consumo, voltaje y corriente.
⚖️ Balance Energético: Cálculo automático de la diferencia entre lo producido y lo consumido.
🔍 Algoritmos:
✅ Ordenamiento de ubicaciones por provincia.
✅ Búsqueda por coincidencia de texto.
📈 Reportes: Generación de informes diarios, semanales y mensuales con opción de exportación.
📐 Diseño y Modelos
Dentro del repositorio (o adjuntos a la entrega) se encuentran los diagramas realizados:
Diagrama de Clases UML: Muestra clases, atributos, métodos, herencia y relaciones.
Diagrama Entidad-Relación: Estructura de la base de datos, claves primarias, foráneas y relaciones 1:1, 1:N.
👨‍💻 Autor
Nombre: Guillermo Colla
Materia: Seminario Practico
Institución: - universidad siglo 21
