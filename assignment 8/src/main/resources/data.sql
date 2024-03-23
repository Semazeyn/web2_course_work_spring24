-- Additional actors
INSERT INTO ACTORS (name, gender, nationality) VALUES
('Brad Pitt', 'Male', 'American'),
('Angelina Jolie', 'Female', 'American'),
('Denzel Washington', 'Male', 'American'),
('Jennifer Lawrence', 'Female', 'American'),
('Robert Downey Jr.', 'Male', 'American'),
('Natalie Portman', 'Female', 'American'),
('Will Smith', 'Male', 'American'),
('Anne Hathaway', 'Female', 'American'),
('Matt Damon', 'Male', 'American'),
('Charlize Theron', 'Female', 'American');

-- Additional movies
INSERT INTO MOVIES (name, genre, image) VALUES
('Fight Club', 'Drama', 'https://m.media-amazon.com/images/I/71eHZFw+GlL._AC_UF894,1000_QL80_.jpg'),
('Mr. & Mrs. Smith', 'Action', 'https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/black-panther-web.jpg'),
('Training Day', 'Crime', 'https://img.buzzfeed.com/buzzfeed-static/complex/images/gdv2pu6io6ekpg5r8mta/back-to-the-future.jpg?output-format=jpg&output-quality=auto'),
('Silver Linings Playbook', 'Comedy', 'https://rukminim2.flixcart.com/image/850/1000/jf8khow0/poster/a/u/h/small-hollywood-movie-poster-blade-runner-2049-ridley-scott-original-imaf3qvx88xenydd.jpeg?q=20&crop=false'),
('Iron Man', 'Action', 'https://m.media-amazon.com/images/I/71eHZFw+GlL._AC_UF894,1000_QL80_.jpg'),
('Black Swan', 'Drama', 'https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/black-panther-web.jpg'),
('Independence Day', 'Sci-Fi', 'https://img.buzzfeed.com/buzzfeed-static/complex/images/gdv2pu6io6ekpg5r8mta/back-to-the-future.jpg?output-format=jpg&output-quality=auto'),
('Les Misérables', 'Musical', 'https://rukminim2.flixcart.com/image/850/1000/jf8khow0/poster/a/u/h/small-hollywood-movie-poster-blade-runner-2049-ridley-scott-original-imaf3qvx88xenydd.jpeg?q=20&crop=false'),
('The Martian', 'Sci-Fi', 'https://m.media-amazon.com/images/I/71eHZFw+GlL._AC_UF894,1000_QL80_.jpg'),
('Mad Max: Fury Road', 'Action', 'https://www.washingtonpost.com/graphics/2019/entertainment/oscar-nominees-movie-poster-design/img/black-panther-web.jpg');

-- Additional movie_actor relationships
INSERT INTO movie_actor (movie_id, actor_id) VALUES
(5, 5), -- Iron Man - Robert Downey Jr.
(5, 6), -- Iron Man - Natalie Portman
(6, 6), -- Black Swan - Natalie Portman
(6, 7), -- Black Swan - Will Smith
(7, 8), -- Independence Day - Anne Hathaway
(7, 9), -- Independence Day - Matt Damon
(8, 9), -- Les Misérables - Matt Damon
(8, 10), -- Les Misérables - Charlize Theron
(9, 10), -- The Martian - Charlize Theron
(9, 5); -- The Martian - Robert Downey Jr.
