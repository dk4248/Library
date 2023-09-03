package org.example;

public class Book extends Library{
    boolean is_issued = false;
    protected String book_name;
    protected String author_name;
    protected int unique_book_id;
    protected int total_copies;
    protected int available_copies;

    Book(String book_name, String author_name, int unique_book_id, int total_copies){
        this.book_name = book_name;
        this.author_name = author_name;
        this.unique_book_id = unique_book_id;
        this.total_copies += total_copies;
    }
    void print_book_details(){
        print_yellow("Book Name : ");
        print(book_name);
        print_yellow("Author Name : ");
        print(author_name);
        print_yellow("Unique Book ID : ");
        print(String.valueOf(unique_book_id));
        print_yellow("Current Availability Status : ");
        if (is_issued){
            print_red("Not Available");
            System.out.println();
        }
        else {
            print_green("Available");
            System.out.println();
        }
//        print_lines();
    }
    void print_details_without_availability(){
        print_yellow("Book Name : ");
        print(book_name);
        print_yellow("Author Name : ");
        print(author_name);
        print_yellow("Unique Book ID : ");
        print(String.valueOf(unique_book_id));
        System.out.println();
    }
}
