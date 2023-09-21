# BookStore-API

The **Bookstore API** is a Spring Boot application that allows you to manage books and authors. It provides functionality to add, retrieve, and update books, authors, and their associations.

## Features

- Manage books and authors.
- Create, update, and delete books and authors.
- Retrieve book titles, authors, and book details.
- Establish associations between books and authors.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Mysql Database (for development)
- Java 8
- Maven
### Prerequisites

- Java 8 or higher
- Maven
- Git
- Mysql

Database Schema
The application uses Mysql database for development. The database schema includes the following tables:

book: Represents books with properties like id, title, publicationYear, price, isbn, and description.
author: Represents authors with properties like id, firstName, lastName, biography, and birthDate.
book_author: Represents the association between books and authors with properties like id, book_id, and author_id.



### Usage
API Endpoints
Books:

- Post /BookStore/addbook: add book  
- PUT /BookStore/updatebook/{id}: Update book by id.
- POST /BookStore/getbookbyid/{id}: get book by id.
- GET /BookStore/getbook/{title}: get book by id.
- GET /BookStore//booktitles: get titles of all books.
- DELETE /BookStore/delete/{id}: delete book by id.

Authors:

- GET /Author/getlist: Get a list of all authors.
- PUT /Author//update/{id}}: Update a specific author by ID.
- POST /Author/addauthor: Create a new author.
- GET /Author/getauthor/{id}: get author by ID.
- DELETE /Author/delete/{id}: Delete an author by ID.

book_author:

- POST /bookauthor/add: Create an association between a book and an author.
- GET /bookauthor/authorsbooks/{id}: get all books of a author by id.
- GET /bookauthor/authorsbooksbyname/{fname}/{lname}: get all books of a author by first name and last name.

### Sample Requests

Create a Book:

- Send a POST request to http://localhost:8080/BookStore/addbook with JSON data containing book details to create a new book.
- json

{
    "title": "Sample Book",
    "publicationYear": 2023,
    "price": 29.99,
    "isbn": "978-1234567890",
    "description": "A sample book description."
}
