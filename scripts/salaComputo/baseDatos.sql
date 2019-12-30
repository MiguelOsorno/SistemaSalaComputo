CREATE DATABASE SalaComputo;
USE salacomputo;
CREATE TABLE prestador(
    id INT AUTO_INCREMENT NOT NULL,
    ine INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    PRIMARY KEY(ID)
);
CREATE TABLE tipoArticulo(
    id INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(20) NOT NULL,
    tiempo VARCHAR(10) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE articulo(
    id INT AUTO_INCREMENT NOT NULL,
    clave VARCHAR(10) NOT NULL,
    estatus VARCHAR(15) NOT NULL,
    descripcion VARCHAR(60) NOT NULL,
    idTipoArticulo INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idTipoArticulo) REFERENCES tipoArticulo(id)
);
CREATE TABLE encargado(
    id INT AUTO_INCREMENT NOT NULL,
    clave INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    PRIMARY KEY(ID)
);
CREATE TABLE prestamo(
    id INT AUTO_INCREMENT NOT NULL,
    inePrestador INT NOT NULL,
    claveEncargado INT NOT NULL, 
    claveArticulo INT NOT NULL,
    fechaPrestamo DATETIME NOT NULL,
    fechaEntrega DATETIME NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(inePrestador) REFERENCES prestador(id),
    FOREIGN KEY(claveEncargado) REFERENCES encargado(id),
    FOREIGN KEY(claveArticulo) REFERENCES articulo(id)
);




