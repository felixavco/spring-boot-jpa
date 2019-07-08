-- CREATE DATABASE spring_boot;

-- USE spring_boot;

-- CREATE TABLE clients(
--     id int NOT NULL AUTO_INCREMENT,
--     first_name VARCHAR(255),
--     last_name VARCHAR(255), 
--     email VARCHAR(255),
--     created_at TIMESTAMP,
--     photo VARCHAR(255),
--     PRIMARY KEY (id)
-- );

INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Felix', 'Avelar', 'felix@xilews.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Camila', 'Avelar', 'camila@xilews.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Brenda', 'Marroquin', 'brenda@xilews.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Barry', 'Gibb', 'barry@beegees.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Bruno', 'Marz', 'bmarz@gmail.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Karla', 'Rodriguez', 'karla@gmail.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Emilia', 'Rodriguez', 'emilia@gmail.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Mariana', 'Rodriguez', 'mariana@gmail.com', '2019-07-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-01', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2017-08-06', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2017-08-07', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2017-08-08', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-09', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-010', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Bruce', 'Lee', 'bruce.lee@gmail.com', '2017-08-11', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Johnny', 'Doe', 'johnny.doe@gmail.com', '2017-08-12', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('John', 'Roe', 'john.roe@gmail.com', '2017-08-13', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Jane', 'Roe', 'jane.roe@gmail.com', '2017-08-14', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Richard', 'Doe', 'richard.doe@gmail.com', '2017-08-15', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Janie', 'Doe', 'janie.doe@gmail.com', '2017-08-16', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Phillip', 'Webb', 'phillip.webb@gmail.com', '2017-08-17', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Stephane', 'Nicoll', 'stephane.nicoll@gmail.com', '2017-08-18', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Sam', 'Brannen', 'sam.brannen@gmail.com', '2017-08-19', '');  
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Juergen', 'Hoeller', 'juergen.Hoeller@gmail.com', '2017-08-20', ''); 
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Janie', 'Roe', 'janie.roe@gmail.com', '2017-08-21', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('John', 'Smith', 'john.smith@gmail.com', '2017-08-22', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Joe', 'Bloggs', 'joe.bloggs@gmail.com', '2017-08-23', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('John', 'Stiles', 'john.stiles@gmail.com', '2017-08-24', '');
INSERT INTO clients (first_name, last_name, email, created_at, photo) VALUES('Richard', 'Roe', 'stiles.roe@gmail.com', '2017-08-25', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, created_at) VALUES('Panasonic Pantalla LCD', 575.00, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES('Sony Camara digital DSC-W320B', 175.99, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES('Apple iPod shuffle', 49.99, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES('Sony Notebook Z110', 675.95, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES('Hewlett Packard Multifuncional F2280', 325.75, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES('Bianchi Bicicleta Aro 26', 125.00, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES('Mica Comoda 5 Cajones', 175.50, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, client_id, created_at) VALUES('Factura equipos de oficina', "una observacion", 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, client_id, created_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

