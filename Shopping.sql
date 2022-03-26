CREATE DATABASE Shopping

USE Shopping

CREATE TABLE tipoRelacion
(
idTR INT IDENTITY (1,1) NOT NULL,
nombreTR VARCHAR (100),
CONSTRAINT PK_tipoRelacion PRIMARY KEY (idTR)
)

CREATE TABLE tipoArticulo
(
idTA INT IDENTITY (1,1) NOT NULL,
denominacionTA VARCHAR (100),
CONSTRAINT PK_tipoArticulo PRIMARY KEY (idTA)
)

CREATE TABLE comercio
(
idC INT IDENTITY (1,1) NOT NULL,
denominacionC VARCHAR (100),
CONSTRAINT PK_comercio PRIMARY KEY (idC)
)

CREATE TABLE usuario
(
idU INT IDENTITY (1,1) NOT NULL,
nombreU VARCHAR (50),
contrasenia VARCHAR (50),
CONSTRAINT PK_usuario PRIMARY KEY (idU)
)

CREATE TABLE articulo
(
idA INT IDENTITY (1,1) NOT NULL,
codigo VARCHAR (10),
denominacionA VARCHAR (100),
precioUnitario REAL,
idTA INT,
CONSTRAINT PK_articulo PRIMARY KEY (idA),
CONSTRAINT FK_articulo_tipoArticulo FOREIGN KEY (idTA) REFERENCES tipoArticulo (idTA)
)

CREATE TABLE pareja
(
idP INT IDENTITY (1,1) NOT NULL,
nombre1 VARCHAR (50),
apellido1 VARCHAR (50),
nombre2 VARCHAR (50),
apellido2 VARCHAR (50),
fechaCasamiento DATE,
idC INT,
CONSTRAINT PK_pareja PRIMARY KEY (idP),
CONSTRAINT FK_pareja_comercio FOREIGN KEY (idC) REFERENCES comercio (idC)
)

CREATE TABLE invitado
(
idI INT IDENTITY (1,1) NOT NULL,
nombreI VARCHAR (50),
idP INT,
idTR INT,
CONSTRAINT PK_invitado PRIMARY KEY (idI),
CONSTRAINT FK_invitado_pareja FOREIGN KEY (idP) REFERENCES pareja (idP),
CONSTRAINT FK_invitado_tipoRelacion FOREIGN KEY (idTR) REFERENCES tipoRelacion (idTR),
)

CREATE TABLE regalo
(
idR INT IDENTITY (1,1) NOT NULL,
cantidad INT,
regalado BIT,
idP INT,
idA INT,
idI INT NULL, 
CONSTRAINT PK_regalo PRIMARY KEY (idR),
CONSTRAINT FK_regalo_pareja FOREIGN KEY (idP) REFERENCES pareja (idP),
CONSTRAINT FK_regalo_articulo FOREIGN KEY (idA) REFERENCES articulo (idA),
CONSTRAINT FK_regalo_invitado FOREIGN KEY (idI) REFERENCES invitado (idI),
)

