package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    void print_lines(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
    void print_red(String s){
        System.out.print("\u001B[31m" + s + "\u001B[0m");
    }
    void print_green(String s){
        System.out.print("\u001B[32m" + s + "\u001B[0m");
    }
    void print_blue(String s){
        System.out.print("\u001B[34m" + s + "\u001B[0m");
    }
    void print_yellow(String s){
        System.out.print("\u001B[33m" + s + "\u001B[0m");
    }
    void print_purple(String s){
        System.out.print("\u001B[35m" + s + "\u001B[0m");
    }
    void print(String s){
        System.out.println(s);
    }
    protected static int total_unique_book_count = 0;
    protected static int total_book_count = 0;
    protected static int total_student_count = 0;
    static String [] all_book_names = new String[1000];
    static String [] all_author_name = new String[1000];
    static int [] total_copies_Array = new int[1000];
    static int [] unique_book_id = new int[1000];
    static String [] student_name_Array = new String[1000];
    static String [] phone_no_Array = new String[1000];
    static int [] age_Array = new int[1000];
    static int [] member_id_Array = new int[1000];
    boolean is_int(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    static ArrayList<Member> member_Object_Array = new ArrayList<Member>(1000);
    static ArrayList<Book> book_Object_Array = new ArrayList<Book>(1000);
    void print_available_books(){
//        print_lines();
        print_blue("Available Books : ");
        System.out.println();
        for (Book book : book_Object_Array){
            if (book.book_name != null && !book.is_issued){
                book.print_details_without_availability();
                print_lines();
            }
        }
    }
    void main_interface(){
        Librarian_Interface librarian_interface = new Librarian_Interface();
        Member_Interface member_interface = new Member_Interface();
        Scanner sc = new Scanner(System.in);
        print_blue("1.) Enter as a Librarian");
        System.out.println();
        print_blue("2.) Enter as a Member");
        System.out.println();
        print_red("3.) EXIT");
        System.out.println();
        print_lines();
        print_yellow("Please Enter your choice : ");
        String inp = sc.nextLine();
        print_lines();
        switch (inp){
            case "1" -> {
                librarian_interface.lib_checker();
            }
            case "2" -> {
                member_interface.member_checker();
            }
            case "3" -> {
                print_green("Thanks for using the Library");
                System.exit(0);
            }
            default -> {
                print_red("Please enter a valid choice");
                System.out.println();
                main_interface();
            }
        }
    }
}
