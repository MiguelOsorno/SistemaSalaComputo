@echo off
ECHO Creando base de datos.....
mysql -u root < %CD%\BaseDeDatos.sql
ECHO Base de datos creada exitosamente
pause