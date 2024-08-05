create database ExamenPOO;

use ExamenPOO

CREATE TABLE Propietarios (
  pro_id INT AUTO_INCREMENT PRIMARY KEY,
  pro_nombre VARCHAR(100) NOT NULL,
  pro_apellido VARCHAR(100) NOT NULL,
  pro_cedula VARCHAR(10) NOT NULL,
  pro_telefono VARCHAR(12) NOT NULL
);

CREATE TABLE Vehiculos (
  veh_id INT AUTO_INCREMENT PRIMARY KEY,
  veh_palca VARCHAR(15) NOT NULL,
  veh_marca VARCHAR(50) NOT NULL,
  veh_color VARCHAR(50) NOT NULL,
  pro_id INT NOT NULL,
  FOREIGN KEY (pro_id) REFERENCES Propietarios(pro_id)
);
