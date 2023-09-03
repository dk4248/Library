# Library Management System

[//]: # (![Library]&#40;library.jpg&#41;)

This Java-Based Library Management System empowers librarians to manage library resources efficiently and enables patrons to check out and return books, as well as access their account information.

## Features

### Librarian Interface:
- **Register a New Member**: Librarians can add new members to the library system.
- **Remove a Member**: Librarians can remove library members as needed.
- **Add a New Book**: Librarians can add new books to the library's collection.
- **Remove a Book**: Librarians can remove books from the library's collection.
- **View Member List**: Provides a list of all library members, including their issued books and fines.
- **View Book List**: Displays a list of all library books, along with their availability status.

### Member Interface:
- **Browse Available Books**: Members can view a list of all books in the library and check their availability.
- **View Issued Books**: Members can see a list of books they have currently checked out.
- **Issue a Book**: Allows members to borrow a book from the library.
- **Return a Book**: Members can return borrowed books to the library.
- **Pay Fines**: Provides an option for members to pay any fines they may have accrued.

## Some Assumptions :
- The library has a single librarian.
- Phone numbers can be of any length.
- Age can be Integer only ( obviously ).
- I have taken system time for the fine calculation. So if the system time messes up, the fine calculation will also mess up.
## How to Run

To run the project, follow these steps:

1. **Set Working Directory**: Set the working directory to the root of the project.

2. **Recompile the Project**:
    - Open your terminal and navigate to the project's root directory.
    - Run the following commands to compile the project:
      ```bash
      mvn clean
      mvn compile
      mvn compiler:testCompile
      mvn validate
      mvn verify
      mvn jar:jar
      ```
      This will create a new .jar file in the `target` folder.

3. **Run the Program**:
    - After the compilation is complete, run the .jar file to start the program.

Alternatively, if you prefer not to recompile, you can directly execute the .jar file located in the `target` folder.

**Note**: This project has no external dependencies, making it easy to run.

**Debugged several times to make sure it works perfectly.**
**But if you find any bug please let it go.**

![Thank You](thank_you.png)

### Thank You for Exploring my Library Management System!
