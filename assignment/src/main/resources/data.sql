INSERT INTO ACTORS (name, gender, nationality) VALUES
('Tom Hanks', 'Male', 'American'),
('Meryl Streep', 'Female', 'American'),
('Leonardo DiCaprio', 'Male', 'American'),
('Scarlett Johansson', 'Female', 'American');

INSERT INTO MOVIES (name, genre, image) VALUES
('Forrest Gump', 'Drama', 'forrest_gump.jpg'),
('The Devil Wears Prada', 'Comedy', 'devil_wears_prada.jpg'),
('Inception', 'Sci-Fi', 'inception.jpg'),
('Lost in Translation', 'Drama', 'lost_in_translation.jpg');

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
