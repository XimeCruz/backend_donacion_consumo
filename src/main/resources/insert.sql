-- INSERT INTO public.rol (id, nombre)
--     VALUES (DEFAULT, 'Donante'),
--             (DEFAULT, 'Beneficiario'),
--             (DEFAULT, 'Voluntario');

-- INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", rol)
-- VALUES
--     (9, 'Admin', 'Admin', 'Admin@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 'BENEFICIARIO'),
--     (10, 'Mateo josue Rodriguez Chico', 'Mateo', 'mateo204r@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 'BENEFICIARIO');
-- INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", rol)
-- VALUES
--     (11, 'Luisa Fernanda Morales', 'LuisaF', 'luisafernanda@mail.com', '123', 1, '3216549870', '1990-07-15', 'BENEFICIARIO'),
--     (12, 'Carlos Andrés Pérez', 'CarlosAP', 'carlosap@mail.com', '123', 0, '3007894561', '1985-11-09', 'BENEFICIARIO'),
--     (13, 'Sofía Castro', 'SofiaC', 'sofiacastro@mail.com', '123', 1, '3105678902', '1992-05-21', 'BENEFICIARIO'),
--     (14, 'Eduardo Ramírez', 'EduRam', 'eduardoram@mail.com', '123', 1, '3187654321', '1998-08-30', 'BENEFICIARIO');


-- INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", rol)
-- VALUES
--     (9, 'Admin', 'Admin', 'Admin@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 2),
--     (10, 'Mateo josue Rodriguez Chico', 'Mateo', 'mateo204r@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 1);
-- INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", rol)
-- VALUES
--     (11, 'Luisa Fernanda Morales', 'LuisaF', 'luisafernanda@mail.com', '$2a$10$Bk5H.dThPaaFE4/FzPGFa.V97T7YG0XbC9TnAbz/jK57LkiQeXapK', 1, '3216549870', '1990-07-15', 3),
--     (12, 'Carlos Andrés Pérez', 'CarlosAP', 'carlosap@mail.com', '$2a$10$Bk5H.dThPaaFE4/FzPGFa.V97T7YG0XbC9TnAbz/jK57LkiQeXapK', 0, '3007894561', '1985-11-09', 2),
--     (13, 'Sofía Castro', 'SofiaC', 'sofiacastro@mail.com', '$2a$10$Bk5H.dThPaaFE4/FzPGFa.V97T7YG0XbC9TnAbz/jK57LkiQeXapK', 1, '3105678902', '1992-05-21', 1),
--     (14, 'Eduardo Ramírez', 'EduRam', 'eduardoram@mail.com', '$2a$10$Bk5H.dThPaaFE4/FzPGFa.V97T7YG0XbC9TnAbz/jK57LkiQeXapK', 1, '3187654321', '1998-08-30', 1);

INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (1, 1, 'cruz.ximena@gmail.com', null, '2002-01-15', 'Ximena Cruz', 'XimeCruz', 'Leyayfrank1501', 'VOLUNTARIO', '75836165');
INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (9, 1, 'Admin@gmail.com', null, '2004-03-04', 'Admin', 'Admin', '123', 'ADMINISTRADOR', '3148918702');
INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (11, 1, 'luisafernanda@mail.com', null, '1990-07-15', 'Luisa Fernanda Morales', 'LuisaF', '123', 'BENEFICIARIO', '3216549870');
INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (13, 1, 'sofiacastro@mail.com', null, '1992-05-21', 'Sofía Castro', 'SofiaC', '123', 'VOLUNTARIO', '3105678902');
INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (10, 1, 'mateo204r@gmail.com', null, '2004-03-04', 'Mateo josue Rodriguez Chico', 'Mateo', '123', 'BENEFICIARIO', '3148918702');
INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (12, 0, 'carlosap@mail.com', null, '1985-11-09', 'Carlos Andrés Pérez', 'CarlosAP', '123', 'VOLUNTARIO', '3007894561');
INSERT INTO public.usuarios (id, activo, correo_electronico, direccion, "fecha de nacimiento", nombre, "nombre de usuario", password, rol, telefono) VALUES (14, 1, 'eduardoram@mail.com', null, '1998-08-30', 'Eduardo Ramírez', 'EduRam', '123', 'VOLUNTARIO', '3187654321');


INSERT INTO public.categoria (id, nombre, descripcion)
VALUES
    (1, 'vegetales', 'Vegetales frescos y saludables'),
    (2, 'frutas', 'Frutas frescas y jugosas'),
    (3, 'granos', 'Productos a base de granos'),
    (4, 'productos lacteos', 'Productos lácteos variados'),
    (5, 'proteinas', 'Fuentes de proteína animal y vegetal'),
    (6, 'otros', 'Otros productos diversos');


-- INSERT INTO public.albergue (id, beneficiario_id, capacidad, direccion, email, imagen, latitud, longitud, nombre, telefono, descripcion)
-- VALUES (1, 9, 500, 'Av. Peru', 'albergueesperanza@gmail.com', '/images/a2.jpeg', -16.4920308, -68.1446255, 'Albergue esperanza', '2458963', 'Ubicado en el corazón de la ciudad, el Albergue Refugio Urbano ofrece un oasis de tranquilidad y comodidad en medio del bullicio urbano. Este albergue es el lugar perfecto para viajeros de todas las edades que buscan un alojamiento asequible y céntrico sin comprometer la calidad y la seguridad.');
--
--

INSERT INTO public.albergue (id, beneficiario_id, capacidad, descripcion, direccion, email, imagen, latitud, longitud, nombre, telefono) VALUES (1, 11, 500, 'Ubicado en el corazón de la ciudad, el Albergue Refugio Urbano ofrece un oasis de tranquilidad y comodidad en medio del bullicio urbano. Este albergue es el lugar perfecto para viajeros de todas las edades que buscan un alojamiento asequible y céntrico sin comprometer la calidad y la seguridad.', 'Av. Peru', 'albergueesperanza@gmail.com', '/images/a2.jpeg', -16.4920308, -68.1446255, 'Albergue esperanza', '2458963');


INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (7, 'Zanahoria fresca y crujiente', '2024-04-18', null, 'Zanahoria',50, 1, 10, '/images/zanahoria.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (9, 'Pepino fresco de campo', '2024-04-18', null, 'Pepino', 60, 1, 10, '/images/pepino.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (8, 'Espinacas orgánicas', '2024-04-18', null, 'Espinaca',  40, 1, 10, '/images/espinaca.jpeg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (11, 'Pimiento rojo crujiente', '2024-04-18', null, 'Pimiento',  45, 1, 10, '/images/pimiento.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (10, 'Brócoli verde y nutritivo', '2024-04-18', null, 'Brócoli',  30, 1, 10, '/images/brocoli.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (24, 'Mantequilla cremosa', '2024-04-18', null, 'Mantequilla',  50, 4, 10, '/images/mantequilla.jpeg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (22, 'Yogur natural sin azúcar', '2024-04-18', null, 'Yogur',  40, 4, 10, '/images/yogurt.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (12, 'Plátano maduro y dulce', '2024-04-18', null, 'Plátano',  70, 2, 10, '/images/platanos.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (14, 'Uvas moradas sin semillas', '2024-04-18', null, 'Uva', 40, 2, 10, '/images/uva.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (18, 'Avena integral en hojuelas', '2024-04-18', null, 'Avena',  80, 3, 10, '/images/avena.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (15, 'Fresas rojas y jugosas', '2024-04-18', null, 'Fresa',  55, 2, 10, '/images/fresa.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (27, 'Filete de salmón fresco', '2024-04-18', null, 'Salmón',  20, 5, 10, '/images/salmon.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (23, 'Queso Cheddar en lonchas', '2024-04-18', null, 'Queso Cheddar',  30, 4, 10, '/images/queso.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (26, 'Yogur griego natural sin grasa', '2024-04-18', null, 'Yogur Griego',  35, 4, 10, '/images/yogurt2.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (19, 'Lentejas secas y nutritivas', '2024-04-18', null, 'Lentejas',  60, 3, 10, '/images/lenteja.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (16, 'Mango maduro de temporada', '2024-04-18', null, 'Mango',  45, 2, 10, '/images/mango.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (13, 'Naranjas frescas recién recolectadas', '2024-04-18', null, 'Naranja',  60, 2, 10, '/images/naranja.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (17, 'Quinoa orgánica de alta calidad', '2024-04-18', null, 'Quinoa',  25, 3, 10, '/images/quinua.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (20, 'Arroz integral de grano largo', '2024-04-18', null, 'Arroz Integral',  70, 3, 10, '/images/arroz.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (25, 'Leche de almendras sin azúcar', '2024-04-18', null, 'Leche de Almendras',  45, 4, 10, '/images/leche.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (21, 'Garbanzos secos de alta calidad', '2024-04-18', null, 'Garbanzos',  50, 3, 10, '/images/garbanzo.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (29, 'Tofu orgánico extrafirme', '2024-04-18', null, 'Tofu',  40, 5, 10, '/images/tofu.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (34, 'Cepillo de dientes suave', '2024-04-18', null, 'Cepillo de Dientes',  70, 6, 10, '/images/cepillo.png', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (36, 'Rollo de papel aluminio resistente', '2024-04-18', null, 'Papel Aluminio',  90, 6, 10, '/images/aluminio.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (32, 'Rollo de papel higiénico suave', '2024-04-18', null, 'Papel Higiénico',  100, 6, 10, '/images/higienico.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (31, 'Pechuga de pavo sin hueso', '2024-04-18', null, 'Pechuga de Pavo', 25, 5, 10, '/images/pechuga.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (30, 'Filete de carne de res magra', '2024-04-18', null, 'Carne de Res',  15, 5, 10, '/images/carne.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (28, 'Docena de huevos orgánicos', '2024-04-18', null, 'Huevos', 50, 5, 10, '/images/huevos.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (35, 'Shampoo revitalizante para cabello', '2024-04-18', null, 'Shampoo',  60, 6, 10, '/images/shampoo.jpg', false);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, cantidad_disponible, id_categoria, id_donante, imagen, verificado) VALUES (33, 'Detergente líquido para ropa', '2024-04-18', null, 'Detergente', 80, 6, 10, '/images/detergente.jpg', false);

-- INSERT INTO public.donacion (id,cantidad, fecha_adquisicion, hora_adquisicion, donante_id, organizacion_id, producto_id, voluntario_id)
-- VALUES
--     (1,7, '2024-04-18', '09:30:00', 10, 1, 7, 9),
--     (2,25, '2024-04-18', '10:15:00', 10, 1, 8, 9),
--     (3,77, '2024-04-18', '11:00:00', 10, 1, 9, 9),
--     (4,46, '2024-04-18', '12:30:00', 10, 1, 10, 9),
--     (5,33, '2024-04-18', '14:45:00', 10, 1, 11, 9),
--     (6,14, '2024-04-18', '15:20:00', 10, 1, 12, 9),
--     (7,11, '2024-04-18', '16:10:00', 10, 1, 13, 9),
--     (8,68, '2024-04-18', '17:00:00', 10, 1, 14, 9),
--     (9,50, '2024-04-18', '18:20:00', 10, 1, 15, 9),
--     (10,92, '2024-04-18', '19:45:00', 10, 1, 16, 9);

INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (2, true, true, false, 1, 9, 9, true, true);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (10, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (18, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (8, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (7, false, false, false, 1, 9, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (6, false, false, false, 1, 9, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (17, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (16, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (4, false, false, false, 1, 9, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (5, false, false, false, 1, 9, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (11, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (9, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (13, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (3, false, false, false, 1, 9, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (1, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (15, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (12, false, false, false, 1, 11, null, false, false);
INSERT INTO public.donacion (id, aceptado, asignado, recojo, albergue_id, beneficiario_id, voluntario_id, entregado, recibido) VALUES (14, false, false, false, 1, 11, null, false, false);



INSERT INTO public.albergue (id, beneficiario_id, capacidad, direccion, email, imagen, latitud, longitud, nombre, telefono, descripcion) VALUES
(2, 9, 300, 'Calle Libertad 123', 'contacto@alberguepaz.com', '/images/a2.jpeg', -12.046374, -77.0427934, 'Albergue de la Paz', '26751234', 'Disfruta de la comodidad y la calidez de nuestras instalaciones, ideales para viajeros que buscan un lugar seguro y céntrico en la vibrante ciudad.');

INSERT INTO public.albergue (id, beneficiario_id, capacidad, direccion, email, imagen, latitud, longitud, nombre, telefono, descripcion) VALUES
(3, 10, 120, 'Av. Bolívar 908', 'reservas@casadelviajero.com', '/images/a2.jpeg', -13.531950, -71.967463, 'Casa del Viajero', '984567123', 'Una experiencia única en el corazón histórico, donde el confort y la historia se encuentran para ofrecerte una estancia inolvidable.');

INSERT INTO public.albergue (id, beneficiario_id, capacidad, direccion, email, imagen, latitud, longitud, nombre, telefono, descripcion) VALUES
(4, 12, 450, 'Calle Fortaleza 77', 'info@fortalezahostel.com', '/images/a2.jpeg', -34.603684, -58.381559, 'Fortaleza Hostel', '45127893', 'Ven a disfrutar de nuestro acogedor albergue, con espaciosas habitaciones y una atención amable que te hará sentir como en casa.');

INSERT INTO public.albergue (id, beneficiario_id, capacidad, direccion, email, imagen, latitud, longitud, nombre, telefono, descripcion) VALUES
(5, 13, 200, 'Paseo de los Turistas', 'albergueplaya@mar.com', '/images/a2.jpeg', -33.047238, -71.6126885, 'Albergue Playa Serena', '321654987', 'Ideal para los amantes del sol y la playa, nuestro albergue ofrece las mejores vistas al mar y actividades para disfrutar de la naturaleza.');

INSERT INTO public.albergue (id, beneficiario_id, capacidad, direccion, email, imagen, latitud, longitud, nombre, telefono, descripcion) VALUES
(6, 14, 350, 'Avenida de los Pioneros 456', 'pioneros@albergueaventura.com', '/images/a2.jpeg', -54.801912, -68.3029511, 'Albergue Aventura', '229876543', 'Explora la naturaleza salvaje y descansa en nuestro albergue, donde cada día es una aventura y el confort es nuestra promesa.');


INSERT INTO public.actividad (id, cantidad, fecha, nombre_producto) VALUES (1, 4, '2024-04-30 02:04:10.000000', 'Espinaca');
INSERT INTO public.actividad (id, cantidad, fecha, nombre_producto) VALUES (2, 5, '2024-04-30 02:04:13.000000', 'Zanahoria');
INSERT INTO public.actividad (id, cantidad, fecha, nombre_producto) VALUES (3, 6, '2024-04-30 02:04:16.000000', 'Pepino');



INSERT INTO public.organizacion (id, area_servicio, nombre_org, tipo_alimento, tipo_org, ubicacion)
VALUES (1, 'Huerfanos', 'Aldeas Infantiles', 'de tood tipo', 'SIN FINES DE LUCRO', 'AV.olmos');
