CREATE DATABASE IF NOT EXISTS provincias_verdes;
USE provincias_verdes;

-- Tabla Usuarios
CREATE TABLE usuarios(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contrasena_hash VARCHAR(255) NOT NULL,
    tipo ENUM('ADMIN','USUARIO') NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE
);

-- Tabla Ubicaciones
CREATE TABLE ubicaciones(
    id INT PRIMARY KEY AUTO_INCREMENT,
    provincia VARCHAR(50) NOT NULL,
    direccion VARCHAR(150) NOT NULL,
    latitud DECIMAL(10,6) NOT NULL,
    longitud DECIMAL(10,6) NOT NULL,
    altitud DECIMAL(10,2),
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabla Equipos Solares
CREATE TABLE equipos_solares (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('PANEL','INVERSOR','BATERIA') NOT NULL,
    potencia_nominal DECIMAL(8,2) NOT NULL,
    cantidad INT NOT NULL,
    fecha_instalacion DATE NOT NULL,
    id_ubicacion INT UNIQUE NOT NULL,
    FOREIGN KEY (id_ubicacion) REFERENCES ubicaciones(id)
);

-- Tabla Registros Energía
CREATE TABLE registros_energia(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora DATETIME NOT NULL,
    energia_generada_kwh DECIMAL(10,3) NOT NULL,
    energia_consumida_kwh DECIMAL(10,3) NOT NULL,
    voltaje DECIMAL(5,2),
    corriente DECIMAL(5,2),
    id_equipo INT NOT NULL,
    FOREIGN KEY (id_equipo) REFERENCES equipos_solares(id)
);

-- Datos de prueba para que funcione el login
INSERT INTO usuarios (nombre, email, contrasena_hash, tipo, estado) VALUES 
('Guillermo Colla', 'g@ejemplo.com', '1234', 'ADMIN', 1);
