CREATE DATABASE IF NOT EXISTS banco_cuentas;
USE banco_cuentas;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    identificacion VARCHAR(50) UNIQUE NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(255),
    correo VARCHAR(100),
    telefono VARCHAR(20)
);

CREATE TABLE cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    monto_apertura DECIMAL(10,2) NOT NULL,
    estado VARCHAR(20) DEFAULT 'activa',
    motivo_estado VARCHAR(255),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

CREATE TABLE chequera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cuenta_id INT NOT NULL,
    cantidad_cheques INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'activa',
    motivo_estado VARCHAR(255),
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(id) ON DELETE CASCADE
);

CREATE TABLE cheque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    chequera_id INT NOT NULL,
    numero_cheque VARCHAR(50) NOT NULL,
    estado VARCHAR(20) DEFAULT 'emitido',
    motivo_estado VARCHAR(255),
    FOREIGN KEY (chequera_id) REFERENCES chequera(id) ON DELETE CASCADE
);
