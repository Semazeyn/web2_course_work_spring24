INSERT INTO ACTORS (name, gender, nationality) VALUES
('Tom Hanks', 'Male', 'American'),
('Meryl Streep', 'Female', 'American'),
('Leonardo DiCaprio', 'Male', 'American'),
('Scarlett Johansson', 'Female', 'American');

INSERT INTO MOVIES (name, genre, image) VALUES
('Forrest Gump', 'Drama', 'https://m.media-amazon.com/images/I/71eHZFw+GlL._AC_UF894,1000_QL80_.jpg'),
('The Devil Wears Prada', 'Comedy', 'https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/black-panther-web.jpg'),
('Inception', 'Sci-Fi', 'https://img.buzzfeed.com/buzzfeed-static/complex/images/gdv2pu6io6ekpg5r8mta/back-to-the-future.jpg?output-format=jpg&output-quality=auto'),
('Lost in Translation', 'Drama', 'https://rukminim2.flixcart.com/image/850/1000/jf8khow0/poster/a/u/h/small-hollywood-movie-poster-blade-runner-2049-ridley-scott-original-imaf3qvx88xenydd.jpeg?q=20&crop=false');
--('Hello', 'Drama', 'https://www.belarte.co.uk/cdn/shop/products/LaLaLand_530x@2x.jpg?v=1622308522'),
--('The', 'Comedy', 'https://i.ebayimg.com/images/g/Pc8AAOSwWBth9cf2/s-l1200.webp'),
--('World', 'Sci-Fi', 'https://filmartgallery.com/cdn/shop/products/Shrek-Vintage-Movie-Poster-Original-1-Sheet-27x41.jpg?v=1665732097'),
--('Translation', 'Drama', 'https://dbdzm869oupei.cloudfront.net/img/posters/preview/91008.png');

-- For the movie_actor table (to establish the many-to-many relationship)
INSERT INTO movie_actor (movie_id, actor_id) VALUES
(1, 1), -- Forrest Gump - Tom Hanks
(2, 2), -- The Devil Wears Prada - Meryl Streep
(3, 3), -- Inception - Leonardo DiCaprio
(4, 4), -- Lost in Translation - Scarlett Johansson
(1, 2), -- Forrest Gump - Meryl Streep
(2, 1), -- The Devil Wears Prada - Tom Hanks
(3, 4), -- Inception - Scarlett Johansson
(4, 3); -- Lost in Translation - Leonardo DiCaprio
--(5, 2);
--(6, 4);
--(7, 3);
--(8, 1);