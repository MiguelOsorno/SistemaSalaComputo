USE salacomputo;

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (101,"Miguel","osorno","alumno","col.limon","111-111");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (102,"Juan","lopez","alumno","col.durazno","111-112");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (103,"Diego","Mendez","alumno","col.manzana","111-113");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (104,"Diana","velazco","maestro","col.pera","111-114");

INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) 
values (105,"jesus","muñoz","maestro","col.sandia","111-115");

INSERT INTO encargado(clave,nombre,apellido)
values(201,"mariana","juarez");

INSERT INTO encargado(clave,nombre,apellido)
values(202,"maria","lopez");

INSERT INTO tipoArticulo(descripcion,tiempo,cantidad)
values("libro","hora",2);

INSERT INTO tipoArticulo(descripcion,tiempo,cantidad)
values("cañon","hora",1);

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





