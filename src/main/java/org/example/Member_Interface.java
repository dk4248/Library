package org.example;

import java.util.Scanner;

public class Member_Interface extends Library{
    private int checker(String name_ip , String phone_ip , int age_ip){
        for(Member member : member_Object_Array){
            if(member.name.equals(name_ip)){
                if(member.phone.equals(phone_ip)){
                    if(member.age == age_ip){
                        return member.member_id;
                    }
                }
            }
        }
        return -1;
    }
    private void print_my_books(Member member_in){
        if (member_in.books_issued == 0){
            print_red("You have not issued any book");
            System.out.println();
            print_lines();
            mem_printer(member_in);
        }
        print_blue("Books Issued : ");
        System.out.println();
        print_lines();
        for (Book book : member_in.issued_book_Object_Array){
            book.print_details_without_availability();
            print_lines();
        }
//        print_lines();
        mem_printer(member_in);
    }
    private void issue_book(Member member_in){
        if (member_in.books_issued == 2){
            print_red("You have already issued 2 books");
            mem_printer(member_in);
        }
        if (member_in.fine_to_be_paid > 0){
            print_red("You have a fine of Rs. " + member_in.fine_to_be_paid + " to be paid");
            System.out.println();
            print_lines();
            mem_printer(member_in);
        }
        else {
            print_available_books();
            print_blue("Enter the Unique Book ID : ");
            Scanner sc = new Scanner(System.in);
//        int book_id = sc.nextInt();
            String book_id_ch = sc.nextLine();
            if(is_int(book_id_ch) == false){
                print_red("Invalid Input");
                System.out.println();
                issue_book(member_in);
            }
            int book_id = Integer.parseInt(book_id_ch);
            if (book_id == 0){
                print_red("Invalid Input");
                System.out.println();
                print_lines();
                issue_book(member_in);
            }
            for(Book book : book_Object_Array){
                if(book.unique_book_id == book_id){
                    if(book.is_issued){
                        print_red("Book is already issued");
                        issue_book(member_in);
                    }
                    else {
                        book.is_issued = true;
                        member_in.issued_book_Object_Array.add(book);
                        if (member_in.books_issued == 0){
                            member_in.book1_issue_timer();
                        }
                        else if (member_in.books_issued == 1){
                            member_in.book2_issue_timer();
                        }
                        member_in.books_issued += 1;
                        print_green("Book Issued Successfully");
                        System.out.println();
                        print_lines();
                        mem_printer(member_in);
                    }
                }
            }

        }

    }
    private void return_book(Member member_in){
        if (member_in.books_issued == 0){
            print_red("You have not issued any book");
            System.out.println();
            print_lines();
            mem_printer(member_in);
        }
        else {
            print_blue("Enter the Unique Book ID : ");
            Scanner sc = new Scanner(System.in);
            String book_id_ch = sc.nextLine();
            if(is_int(book_id_ch) == false){
                print_red("Invalid Input");
                System.out.println();
                return_book(member_in);
            }
            int book_id = Integer.parseInt(book_id_ch);
            boolean flag = false;
            for(Book book : member_in.issued_book_Object_Array){
                if (book.unique_book_id == book_id){
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                print_red("You have not issued this book");
                mem_printer(member_in);
            }
            else {
                for(Book book : member_in.issued_book_Object_Array){
                    if(book.unique_book_id == book_id){
                        book.is_issued = false;
                        member_in.issued_book_Object_Array.remove(book);
                        if (member_in.books_issued == 1){
                            member_in.book1_return_timer();
                        }
                        else if (member_in.books_issued == 2){
                            member_in.book2_return_timer();
                        }
                        member_in.books_issued -= 1;
                        print_green("Book Returned Successfully");
                        System.out.println();
                        print_lines();
                        mem_printer(member_in);
                    }
                }
            }
        }
    }
    private void pay_fine(Member member_in){
        if (member_in.fine_to_be_paid == 0){
            print_red("You have no fine to be paid");
            System.out.println();
            print_lines();
            mem_printer(member_in);
        }else if (member_in.fine_to_be_paid != 0 && member_in.books_issued != 0){
            print_red("You have a fine of Rs. " + member_in.fine_to_be_paid + " to be paid");
            System.out.println();
            print_red("NOTE : This fine do not include the fine for the books that you have currently");
            System.out.println();
            print_green("Fine Payed Successfully!");
            System.out.println();
            member_in.fine_to_be_paid = 0;
            print_lines();
            mem_printer(member_in);
        }
        else {
            print_green("Your Fine of " + member_in.fine_to_be_paid + " is paid Successfully!");
            System.out.println();
            print_lines();
            member_in.fine_to_be_paid = 0;
            mem_printer(member_in);
        }
    }
    void print_available_books(Member member_in){
//        print_lines();
        print_blue("Available Books : ");
        System.out.println();
        print_lines();
        for (Book book : book_Object_Array){
            if(!book.is_issued){
                book.print_details_without_availability();
                print_lines();
            }
        }
        mem_printer(member_in);
    }
    private int mem_printer_count = 0;
    void mem_printer(Member member_in){
        if(mem_printer_count >= 2){
            mem_printer_count = 0;
            mem_interface(member_in);
            return;
        }
        mem_printer_count++;
        print_yellow("Please Enter your choice : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println();
        print_lines();
        if(is_int(input) == false){
            print_red("Invalid Input");
            System.out.println();
            mem_printer(member_in);
        }
        else {
            int inp = Integer.parseInt(input);
            if(inp == 1){
                print_lines();
                print_available_books(member_in);
            }
            else if(inp == 2){
                print_lines();
                print_my_books(member_in);
            }
            else if(inp == 3){
                print_lines();
                issue_book(member_in);
            }
            else if(inp == 4){
                print_lines();
                return_book(member_in);
            }
            else if(inp == 5){
                print_lines();
                pay_fine(member_in);
            }
            else if(inp == 6){
                print_lines();
                main_interface();
            }
            else {
                print_red("Invalid Input");
                System.out.println();
                print_lines();
                mem_printer(member_in);
            }
        }


    }
    void member_checker(){
        Scanner sc = new Scanner(System.in);
        print_blue("Enter your Name : ");
        String name_ip = sc.nextLine();
        print_blue("Enter your Phone No. : ");
        String phone_ip = sc.nextLine();
        print_blue("Enter your Age : ");
        int age_ip = sc.nextInt();
        int check1 = checker(name_ip , phone_ip , age_ip);
        if (check1 == -1){
            print_lines();
            print_red("You are not a Registered member.\nKindly Contact Librarian for the same OR Re-Enter the details");
            System.out.println();
            print_lines();
            main_interface();
        }
        else {
            Member member_in = null;
            for (Member member : member_Object_Array) {
                if (member.name.equals(name_ip)) {
                    if (member.phone.equals(phone_ip)) {
                        if (member.age == age_ip) {
                            member_in = member;
                            break;
                        }
                    }
                }
            }
            print_lines();
            print_green("Welcome to the Library!");
            System.out.println();
            print_lines();
            mem_interface(member_in);
        }
    }
    void mem_interface(Member member_in){
        Scanner sc1 = new Scanner(System.in);
        print_blue("1.) List Available Books");
        System.out.println();
        print_blue("2.) List My books");
        System.out.println();
        print_blue("3.) Issue a Book");
        System.out.println();
        print_blue("4.) Return a Book");
        System.out.println();
        print_blue("5.) Pay Fine");
        System.out.println();
        print_red("6.) Back");
        System.out.println();
        print_lines();
        print_yellow("Please Enter your choice : ");
        String inp = sc1.nextLine();
        switch (inp){
            case "1" -> {
                print_lines();
                print_available_books(member_in);
                mem_printer(member_in);
            }
            case "2" -> {
                print_lines();
                print_my_books(member_in);
            }
            case "3" -> {
                print_lines();
                issue_book(member_in);
            }
            case "4" -> {
                print_lines();
                return_book(member_in);
            }
            case "5" -> {
                print_lines();
                pay_fine(member_in);
            }
            case "6" -> {
                print_lines();
                main_interface();
            }
            default -> {
                print_red("Invalid Input");
                System.out.println();
                print_lines();
                mem_interface(member_in);
            }
        }
    }
}