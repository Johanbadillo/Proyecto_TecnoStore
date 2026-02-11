DROP DATABASE tecnostore_db;

CREATE DATABASE tecnostore_db;

use tecnostore_db;

CREATE TABLE marca (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    nombre VARCHAR(50) not null
);

CREATE Table sistema_operativo (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    nombre VARCHAR(50) not null
);

CREATE Table celulares (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    id_marca INT not null,
    modelo VARCHAR(50) not null,
    id_sistema_operativo INT not null,
    gama enum("alta", "media", "baja") not null,
    precio DOUBLE not null,
    stock INT not null,
    FOREIGN KEY (id_marca) REFERENCES marca (id),
    FOREIGN KEY (id_sistema_operativo) REFERENCES sistema_operativo (id)
);

create Table persona (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    nombre VARCHAR(50) not null,
    identificacion VARCHAR(50) not null,
    correo VARCHAR(50) not null,
    telefono VARCHAR(50) not null
);

CREATE Table clientes (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    FOREIGN KEY (id) REFERENCES persona (id)
);

CREATE Table empleados (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    FOREIGN KEY (id) REFERENCES persona (id)
);

CREATE Table ventas (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    id_cliente INT not null,
    fecha DATE not null,
    total DOUBLE not null,
    FOREIGN KEY (id_cliente) REFERENCES clientes (id)
);

CREATE Table detalle_ventas (
    id INT PRIMARY KEY AUTO_INCREMENT not null,
    id_venta INT not null,
    id_celular INT not null,
    cantidad INT not null,
    subtotal DOUBLE not null,
    FOREIGN KEY (id_venta) REFERENCES ventas (id),
    FOREIGN KEY (id_celular) REFERENCES celulares (id)
);

-- TRIGGER 1: Calcular subtotal automáticamente al insertar un detalle de venta
DELIMITER //
CREATE TRIGGER calcular_subtotal_insert
BEFORE INSERT ON detalle_ventas
FOR EACH ROW
BEGIN
    DECLARE precio_celular DOUBLE;

    SELECT precio INTO precio_celular 
    FROM celulares 
    WHERE id = NEW.id_celular;
    

    SET NEW.subtotal = precio_celular * NEW.cantidad;
END//
DELIMITER ;

-- TRIGGER 2: Actualizar el total de la venta automáticamente después de insertar un detalle
DELIMITER //
CREATE TRIGGER actualizar_total_venta_insert
AFTER INSERT ON detalle_ventas
FOR EACH ROW
BEGIN
    DECLARE total_calculado DOUBLE;
    
    SELECT SUM(subtotal) INTO total_calculado
    FROM detalle_ventas
    WHERE id_venta = NEW.id_venta;
    
    UPDATE ventas 
    SET total = total_calculado
    WHERE id = NEW.id_venta;
END//
DELIMITER ;


INSERT INTO marca (nombre) VALUES
('Samsung'),
('Apple'),
('Xiaomi'),
('Motorola'),
('Oppo'),
('Vivo'),
('Huawei');

INSERT INTO sistema_operativo (nombre) VALUES
('Android'),
('iOS'),
('HarmonyOS');

INSERT INTO celulares (id_marca, modelo, id_sistema_operativo, gama, precio, stock) VALUES

(1, 'Galaxy S24 Ultra', 1, 'alta', 1299.00, 2),
(1, 'Galaxy S23 FE',     1, 'media',  599.00, 2),
(1, 'Galaxy A15',        1, 'baja',   169.00, 4),


(2, 'iPhone 16 Pro Max', 2, 'alta',  1199.00, 8),
(2, 'iPhone 15',         2, 'alta',   799.00, 4),
(2, 'iPhone SE (2022)',  2, 'media',  429.00, 8),


(3, 'Xiaomi 14T Pro',    1, 'alta',   849.00, 1),
(3, 'Poco X6 Pro',       1, 'media',  349.00, 3),
(3, 'Redmi Note 13',     1, 'media',  219.00, 5),
(3, 'Redmi 13C',         1, 'baja',   129.00, 8),


(4, 'Edge 50 Pro',       1, 'alta',   699.00,  9),
(4, 'Moto G85',          1, 'media',  299.00, 3),


(5, 'Find X7 Ultra',     1, 'alta',   999.00,  6),
(5, 'Reno12',            1, 'media',  449.00, 2);

INSERT INTO persona (nombre, identificacion, correo, telefono) VALUES
('Ana Maria González',     '1012345678', 'ana.gonzalez@gmail.com',     '310 456 7890'),
('Carlos Andrés Ramirez',  '1023456789', 'carlos.ramirez@hotmail.com', '315 678 9012'),
('Laura Patricia Gómez',   '1034567890', 'laura.gomez@outlook.com',    '320 789 0123'),
('Diego Felipe Castro',    '1045678901', 'diego.castro@yahoo.com',     '301 890 1234'),
('Mariana Sofia López',    '1056789012', 'mariana.lopez@gmail.com',    '312 901 2345');

INSERT INTO clientes (id) VALUES (1), (2), (3);

INSERT INTO empleados (id) VALUES (4), (5);

INSERT INTO ventas (id_cliente, fecha, total) VALUES 
(1, '2025-10-10', 0), 
(1, '2025-12-01', 0),  
(2, '2021-10-10', 0), 
(3, '1999-03-12', 0);


INSERT INTO detalle_ventas (id_venta, id_celular, cantidad) VALUES
(1,  4, 1), 
(1,  9, 2),  
(1, 11, 1),
(2,  1, 1),
(3,  9, 2),
(2, 13, 1),
(2,  2, 1), 
(3, 10, 3),
(3, 12, 2);
