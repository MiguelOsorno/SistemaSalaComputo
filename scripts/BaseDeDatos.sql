DROP DATABASE IF EXISTS salacomputo;
CREATE DATABASE salacomputo;
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
    descripcion VARCHAR(250) NOT NULL,
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
    fechaPrestamo VARCHAR(50) NOT NULL,
    fechaEntrega VARCHAR(50) NOT NULL,
    estatus VARCHAR(10) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(inePrestador) REFERENCES prestador(id),
    FOREIGN KEY(claveEncargado) REFERENCES encargado(id),
    FOREIGN KEY(claveArticulo) REFERENCES articulo(id)
);

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (101,"Miguel","osorno","alumno","col.limon","111111");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (102,"Juan","lopez","alumno","col.durazno","111112");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (103,"Diego","Mendez","alumno","col.manzana","111113");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (104,"Diana","velazco","maestro","col.pera","111114");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (105,"jesus","munoz","maestro","col.sandia","111115");

INSERT INTO encargado(clave,nombre,apellido)
values(201,"administrador","admin");

INSERT INTO tipoArticulo(descripcion,tiempo,cantidad)
values("libro","hora",2);

INSERT INTO tipoArticulo(descripcion,tiempo,cantidad)
values("proyector","hora",1);

INSERT INTO tipoArticulo(descripcion,tiempo,cantidad)
values("computador","hora",1);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("300L","disponible","como aprender java|juan marquez|",1);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("301L","disponible","la logica de la programacion|jose perez lopez|",1);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("302L","disponible","it|sthephen king|",1);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("300C","disponible","azul|",2);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("301C","disponible","rojo|",2);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("302C","disponible","negro|",2);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("300PC","disponible","Dell|blanca|",3);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("301PC","disponible","MAC|negra|",3);

INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo)
values("302PC","disponible","Vaio|gris|",3);

DROP USER IF EXISTS 'miguelosorno'@'localhost';
CREATE USER 'miguelosorno'@'localhost';
GRANT ALL ON salacomputo.* TO 'miguelosorno'@'localhost';
FLUSH PRIVILEGES;