# library-management-system

library-management-system is an application which will help us handle the books data in library like creating, filtering
and removing.

Requirements :

1. Book: Represent a book with attributes like title, author, ISBN, genre, publication year,
   Departments, and availability (boolean). Implement appropriate getters and setters.

2. Library: Manage a collection of books in multiple departments. It should include
   methods:

3. addBook(Book book): Adds a book to the library's Departments collection (check for
   duplicates based on ISBN).

4. removeBook(String ISBN): Removes a book by ISBN.

5. findBookByTitle(String title): Returns a list of books matching the title (case-
   insensitive search).

6. findBookByAuthor(String author): Returns a list of books by the author (case-
   insensitive search).

7. listAllBooks(): Returns a list of all books in the library.

8. listAvailableBooks(): Returns a list of available books.

Technologies used : Java, Spring boot, Hibernate and postgresQL

# Working

1. Book details : With the help of spring boot we can store the book details easily by creating an entity
                    of the book information and using hibernate we can easily persist data.

2. Fetch and Filter API : with the help of HQL queries and pattern matching these can fetched easily.

3. deletion of data : here I am using a extra boolean 'active' with which i can soft delete the data and 
                        keep track of ingress and egress of book data.

4. Model mapper : to convert the entity into Data Transfer Object to show only necessary data to client.

5. Custom Wrapper Response : to wrap the response according to the known exceptions and making it easy to 
                            handle client side.

# How to use

Just clone the repository, make sure to create database(lms.sql script) and run the application
(entry point of application : LmsApplication.class)

To see the documentation of API http://{baseurl}:port/swagger-ui/index.html

