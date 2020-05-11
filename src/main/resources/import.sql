INSERT INTO roles(id_rol, nombre) values(1, 'ROLE_ADMIN');
INSERT INTO usuarios(id_usuario, nombre, paterno, email, username, password, enabled) values(1, 'Ash', 'Ketchum', 'juliolicona007@hotmail.com', 'ash', 'pokemon', 1);
INSERT INTO usuarios(id_usuario, nombre, paterno, email, username, password, enabled) values(2, 'Julio', 'Figueroa', 'juliolicona007@gmail.com', 'julio', 'prueba', 1);
INSERT INTO usuarios_roles(usuario_id, rol_id) VALUES(1, 1);
INSERT INTO usuarios_roles(usuario_id, rol_id) VALUES(2, 1);