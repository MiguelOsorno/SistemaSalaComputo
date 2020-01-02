@echo off
ECHO Creando base de datos.....
mysql -u root -p < %CD%\BaseDeDatos.sql
ECHO Base de datos creada exitosamente
pause