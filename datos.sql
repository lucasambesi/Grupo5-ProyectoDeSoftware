insert into `moneda` (id_moneda, nombre) values (1, "Pesos");

insert into `categoria` (id_categoria, nombre) values (1, "Calzado");
insert into `categoria` (id_categoria, nombre) values ("Remera");
insert into `categoria` (id_categoria, nombre) values ("Accesorios");

insert into `subcategoria` (id_subcategoria, nombre, id_categoria) values (1, "Camiseta", 2);
insert into `subcategoria` (id_subcategoria, nombre, id_categoria) values ("Urbana", 2);
insert into `subcategoria` (id_subcategoria, nombre, id_categoria) values ("Botines", 1);
insert into `subcategoria` (id_subcategoria, nombre, id_categoria) values ("Zapatillas", 1);
insert into `subcategoria` (id_subcategoria, nombre, id_categoria) values ("Futbol", 3);
insert into `subcategoria` (id_subcategoria, nombre, id_categoria) values ("Padel", 3);

insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (1, 1, "Camiseta de fútbol de Independiente", "Nueva Camiseta Puma Independiente 2020/21. Este modelo está diseñado especialmente para todos los fanáticos del Rojo. Llevá tu amor por Independiente vayas donde vayas con la nueva camiseta, alentá desde tu casa, compartí tu pasión por estos colores. Este modelo se entrega en caja", "Camiseta de Independiente 2020/21", 7199, "/images/camiseta.jpg", 1, 1);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (1, "Botines Adidas con tapones de aluminio", "Esta bota combina ligereza con comodidad y resistencia al usar una composición de cuero sintético suave y muy duradero en el exterior", "Botines Adidas Fútbol 11", 22000, "/images/futbol11.jpg", 1, 3);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (0, "Canilleras Nike Mercurial Hard Shell", "Canilleras Nike Mercurial Hard Shell ofrecen máxima comodidad durante el juego. Con ajuste anatómico y funda transpirable para una protección cómoda y ligera.", "Canilleras Nike", 1900, "/images/canillera.jpg", 1, 5);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (1, "Botines Nike React Phantom Vision Pro", "Las zapatillas de fútbol Nike React Phantom Vision Pro Dynamic Fit para futsal llevan la precisión del juego callejero a la cancha interior con una parte superior duradera y texturada", "Botines Nike de Futsal", 14000, "/images/futsal.jpg", 1, 3);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (0, "Medias adidas Futbol Adisock 18 Hombre Bl/ng", "La tecnología Climacool favorece la ventilación y te mantiene fresco y seco", "Medias de fútbol Adidas", 999, "/images/media.jpg", 1, 5);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (0, "Raqueta Snauwaert C Paddle Yain Ng Bl", "Paleta Gama Alta de Carbono, balance speed y núcleo de Foam Importado", "Raqueta de Paddle", 8500, "/images/raqueta.jpg", 1, 6);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (1, "Remera adidas Originals Moda Trefoil T Shirt Hombre Ng", "Cuello redondo de canalé, manga corta y 100% algodón", "Remera Adidas Original", 2600, "/images/remeraadidas.jpg", 1, 2);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (1, "Nike Remera Cinza Sb Dri Fit Ok Grey Heather", "Remera Nike Cinza, 100% algodón", "Nike Remera Sb", 2600, "/images/remeranike.jpg", 1, 2);
insert into `producto` (id_producto, activo, descripcion_corta, descripcion_larga, nombre, precio, url_imagen, id_moneda, id_subcategoria) values (0, "Zapatillas Adidas Originals Ozweego - Eg0552", "Zapatillas estilo urbano, material exterior nobuk, suela de goma y caña baja", "Zapatillas Adidas Ozweego", 12000, "/images/zapatilla.jpg", 1, 4);
