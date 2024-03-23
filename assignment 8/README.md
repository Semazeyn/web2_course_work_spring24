				Movie Actor CRUD Application

This is a simple CRUD (Create, Read, Update, Delete) application developed using Spring Boot and Thymeleaf. It allows users to manage movies and actors, including adding, updating, and deleting records. The application uses an H2 in-memory database to store data.

How to Start the Application

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/SITE-ADA/as1-spring-boot-jpa-app-ZeynalovaSama   ```

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. Run the application by executing the `AssignmentApplication` class.

4. Access the application in your web browser at [http://localhost:8080](http://localhost:8080).

Features

- CRUD Operations: Allows users to perform CRUD operations on movies and actors.
- Pagination: Supports pagination for listing movies and actors.
- Sorting: Allows sorting of movie and actor lists based on different fields.
- Filtering: Provides filtering options for movies by genre and actors by nationality.
- Advanced Queries: Uses JPA query methods and native queries for retrieving data.

How to Use the Application

1. Home Page: The home page provides links to the movie and actor pages.

2. Movies: 
   - List of Movies: View all movies with pagination, sorting, and genre filtering.
   - Movie Details: View details of a specific movie, including its actors.
   - Create Movie: Add a new movie to the database.
   - Update Movie: Modify details of an existing movie.
   - Delete Movie: Remove a movie from the database.

3. Actors:
   - List of Actors: View all actors with pagination, sorting, and nationality filtering.
   - Actor Details: View details of a specific actor, including the movies they are in.
   - Create Actor: Add a new actor to the database.
   - Update Actor: Modify details of an existing actor.
   - Delete Actor: Remove an actor from the database.

Bonus Features

- Pagination: Implemented for both movies and actors lists.
- Sorting: Allows sorting based on different fields in movies and actors lists.
- Filtering: Supports filtering movies by genre and actors by nationality.


