# Assessment #2 

- Book StoreObjective
  The objective of this assessment is to build a Java webapplication using learning outcomes of Java modulesbased on a scenario. 

## Overview-Scenario and Design
  You  have been  asked  to  design  and  implement a 3-Tier based Java webapplication for a bookstore. The application  will  be  made  available  for  two  user  groups:  Registered  User  and Unregistered  User.  Each  user  group  is  to  have  access  to  their  own  facilities  and  interlinked functionalities. Unregistered users can view Book Store/browse books but cannot access all the facilities and features compared to those a Registered User has. 

  **Facilities provided to the Unregistered User**
  - Ability to view list of books displayed by the application
  - Ability to search Books
  - Ability to read a specific book information (Overview, Authors, etc)
  - Ability to add book to shopping basket
  - Ability to view the shopping basket
  - Ability to modify the shopping basket
  - Ability to choose to proceed and checkout option
  
  **Facilities provided to the Registered User**
  - Ability to access order history
  - Ability to view personal account details
  - Ability to modify account details such as firstname, lastname, email id and password
  - Ability to purchase books
  
 **Further details for an Unregistered and Registered Users** 
 An  Unregistered  User  can  view list  of books and just look and read  the basic book details provided. After that if the user is interested tthe user can register with Book Storeapplication.The registration process prompts the user to input all necessary details to register like firstname, lastname, email id and password etc. After registration, the user will have a unique email id and a password for logging in to theBook Store. Registered and Unregistered Users have a search option to search books by giving the name of the author(s) or the ISBN of the book. Registered Users can add books to shopping basket and purchase them.


 ## Database structure 
![dbGraph](./graphs/dbgraph.png)
**create statements**
```sql
CREATE table Book(
  Book_ID INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(255),
  Description VARCHAR(255),
  Genre VARCHAR(20),
  Author VARCHAR(50),
  Price INT,
  PRIMARY KEY(Book_ID)
);

CREATE table User(
  User_ID INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(255),
  Username VARCHAR(255),
  Password VARCHAR(20),
  Email VARCHAR(50),
  PRIMARY KEY(User_ID)
);

CREATE table Sale(
  Sale_ID INT NOT NULL AUTO_INCREMENT,
  User_ID INT,
  Book_ID INT,
  Date VARCHAR(12),
  Amount FLOAT(10,2),
  PRIMARY KEY(Sale_ID),
  FOREIGN KEY (User_ID) REFERENCES User(User_ID),
  FOREIGN KEY (Book_ID) REFERENCES Book(Book_ID)
);
```
**seed data**

```sql
INSERT INTO book(Title, Description, Genre, Author, Price)VALUES 
("harry potter", "its about a wizard", "fantasy", "jk rowling", 12.50),("Da Vinci Code", "Da Vinci Code is a book ...", "Thriller & Adventure", "Dan Brown", 9.50),("Very Hungry Caterpillar,The:The Very Hungry Caterpillar", "Very Hungry Caterpillar goes on an adventure", "picture book", "Eric Carle", 5.00),("Kite Runner", "a sad story", "literal fiction", "Khaled Hosseini", 5.00);

INSERT INTO user(Name, Username, Password, Email)VALUES 
("harry", "hp", "fantasyeee33", "hp@gmail.com"), ("daniel", "dannie", "fantafdsyeee33", "d@gmail.com"),("mike", "mk", "books123", "m@gmail.com");
```


## website layout first draft 

![webdesign](./graphs/basicwebdesign.png)

## SPRINT ONE 

as a user 
i should be able to see all books 

as a user 
i should be able to sign up 

as a user 
i should be able to 
login/out

## SPRINT TWO

as a user 
i should be able to search 
for a book by title 

as a user 
i should be able to see a 
specific books details 
"information (Overview, Authors, etc)"
