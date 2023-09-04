package org.example;

import java.util.Scanner;

public class Librarian_Interface extends Library{
    int checker(String name, String phone, int age){
        for (Member member : member_Object_Array){
            if (member.name.equals(name) && member.phone.equals(phone) && member.age == age){
                return 0;
            }
        }
        return 1;
    }
    int checker_id(int member_id_ip){
        for(Member member : member_Object_Array){
            if (member.member_id == member_id_ip && member.name != null){
                return 1;
            }
        }
        return 0;
    }
    int book_checker(String book_name, String author_name){
        for (Book book : book_Object_Array){
            if(book.book_name == null){
                continue;
            }
            if (book.book_name.equals(book_name) && book.author_name.equals(author_name)){
                return 0;
            }
        }
        return 1;
    }
    void register_member(){
        print_blue("Enter name : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        print_blue("Enter phone number : ");
        String phone = sc.nextLine();
        print_blue("Enter age : ");
//        int age = sc.nextInt();
        String age_ch = sc.nextLine();
        if (is_int(age_ch) == false){
            print_lines();
            print_red("Please enter a valid age");
            System.out.println();
            print_lines();
            register_member();
        }
        int age = Integer.parseInt(age_ch);
        int check1 = checker(name, phone, age);
        if (check1 == 0){
            print_lines();
            print_red("Member already exists");
            System.out.println();
            print_lines();
            input_taker();
        }
        else{
            total_student_count++;
            Member member = new Member(name , phone, age, total_student_count);
            student_name_Array[total_student_count] = name;
            phone_no_Array[total_student_count] = phone;
            age_Array[total_student_count] = age;
            member_id_Array[total_student_count] = total_student_count;
            member_Object_Array.add(member);
            print_lines();
            print_green("Member successfully registered with Member ID : " + total_student_count);
            System.out.println();
            print_lines();
            input_taker();
            print_lines();
        }

    }
    void remove_member(){
        print_blue("Enter the Member ID : ");
        Scanner sc = new Scanner(System.in);
        String member_id_ch = sc.nextLine();
        if (is_int(member_id_ch) == false){
            print_lines();
            print_red("Please enter a valid Member ID");
            System.out.println();
            print_lines();
            input_taker();
        }
        int member_id_ip = Integer.parseInt(member_id_ch);
        int check = checker_id(member_id_ip);
        if (check == 0){
            print_lines();
            print_red("Member does not exist");
            System.out.println();
            print_lines();
            input_taker();
        }
        if (member_Object_Array.get(member_id_ip - 1).books_issued > 0){
            print_lines();
            print_red("Member has books issued");
            System.out.println();
            print_lines();
            input_taker();
        }
        else{
            for(Member member : member_Object_Array){
                if (member.member_id == member_id_ip){
                    member_Object_Array.remove(member);
                    break;
                }
            }
            student_name_Array[member_id_ip] = null;
            phone_no_Array[member_id_ip] = null;
            age_Array[member_id_ip] = 0;
            member_id_Array[member_id_ip] = 0;
            print_lines();
            print_green("Member successfully removed");
            System.out.println();
            print_lines();
            input_taker();
        }
    }
    void add_book(){
        print_blue("Enter the name of the book : ");
        Scanner sc = new Scanner(System.in);
        String book_name = sc.nextLine();
        print_blue("Enter the name of the author : ");
        String author_name = sc.nextLine();
        print_blue("Enter the total number of copies : ");
//        int total_copies_ip = sc.nextInt();
        String total_copies_ch = sc.nextLine();
        if (is_int(total_copies_ch) == false){
            print_lines();
            print_red("Please enter a valid number of copies");
            System.out.println();
            print_lines();
            add_book();
        }
        int total_copies_ip = Integer.parseInt(total_copies_ch);
        int check = book_checker(book_name, author_name);
        if (check == 0){
            print_lines();
            print_red("Book already exists");
            System.out.println();
            print_yellow("Adding copies to the existing book");
            System.out.println();
            print_lines();
            for(Book book : book_Object_Array){
                if (book.author_name.equals(author_name) && book.book_name.equals(book_name)){
                    book.total_copies += total_copies_ip;
                    book.available_copies += total_copies_ip;
                }
            }
            int initial_book_count = 0;
            int initial_available_book_count = 0;
            for(Book book : book_Object_Array){
                if (book.author_name.equals(author_name) && book.book_name.equals(book_name)){
                    initial_book_count = book.total_copies;
                    initial_available_book_count = book.available_copies;
                    break;
                }
            }
            for (int i = 1 ; i <= total_copies_ip ; i++){
                Book book = new Book(book_name, author_name,total_book_count+i , initial_book_count);
                book.available_copies = initial_available_book_count;
                book_Object_Array.add(book);
                all_book_names[total_book_count+i] = book_name;
                all_author_name[total_book_count+i] = author_name;
                total_copies_Array[total_book_count+i] += total_copies_ip;
                unique_book_id[total_book_count+i] = total_book_count+i;
            }
            total_book_count += total_copies_ip;
            total_unique_book_count += 1;
            print_lines();
            input_taker();
        }
        else{
            for (int i = 1 ; i <= total_copies_ip ; i++){
                Book book = new Book(book_name, author_name,total_book_count+i , total_copies_ip);
                book.available_copies = total_copies_ip;
                book_Object_Array.add(book);
                all_book_names[total_book_count+i] = book_name;
                all_author_name[total_book_count+i] = author_name;
                total_copies_Array[total_book_count+i] = total_copies_ip;
                unique_book_id[total_book_count+i] = total_book_count+i;
            }
            total_book_count += total_copies_ip;
            total_unique_book_count += 1;
            print_lines();
            print_green("Book successfully added");
            System.out.println();
            print_lines();
            input_taker();
        }
    }
    void remove_book(){
//        print_lines();
        print_blue("Enter the unique book id : ");
        Scanner sc = new Scanner(System.in);
        String unique_book_id_ch = sc.nextLine();
        if (is_int(unique_book_id_ch) == false){
            print_lines();
            print_red("Please enter a valid unique book id");
            System.out.println();
            print_lines();
            remove_book();
        }
        int unique_book_id_ip = Integer.parseInt(unique_book_id_ch);
        int check = 0;
        for (Book book : book_Object_Array){
            if (book.unique_book_id == unique_book_id_ip && book.is_issued == false){
                check = 1;
                break;
            }
        }
        if (check == 0){
            print_lines();
            print_red("Book does not exist OR Book is issued to a member");
            System.out.println();
            print_lines();
            input_taker();
        }
        else{
            for(Book book : book_Object_Array){
                if (book.author_name.equals(all_author_name[unique_book_id_ip]) && book.book_name.equals(all_book_names[unique_book_id_ip])){
                    book.total_copies -= 1;
                    book.available_copies -= 1;
                }
            }
            Book booki = null;
            for(Book book : book_Object_Array){
                if (book.unique_book_id == unique_book_id_ip){
                    booki = book;
                    break;
                }
            }
//            book_Object_Array.remove(unique_book_id_ip);
            booki.book_name = null;
            booki.author_name = null;
            booki.unique_book_id = 0;
            all_book_names[unique_book_id_ip] = null;
            all_author_name[unique_book_id_ip] = null;
            unique_book_id[unique_book_id_ip] = 0;
            total_book_count -= 1;
            print_lines();
            print_green("Book successfully removed");
            System.out.println();
            print_lines();
            input_taker();
        }
    }
    void view_all_members(){
        if (total_student_count == 0){
            print_red("No members available");
            System.out.println();
            print_lines();
            input_taker();
        }
        for(Member member : member_Object_Array){
            if (member == null){
                continue;
            }
            member.print_details_mem();
            print_lines();
        }
        input_taker();
    }
    void view_all_books(){
        print_lines();
        if (total_book_count == 0){
            print_red("No books available");
            System.out.println();
            print_lines();
            input_taker();
        }
        for(Book book : book_Object_Array){
            if (book.book_name != null){
                book.print_book_details();
                print_lines();}
        }
        input_taker();
    }
    private int input_taker_count = 0;
    void input_taker(){
        if (input_taker_count >= 2){
            input_taker_count = 0;
            lib_checker();
            return;
        }
        input_taker_count++;
        print_yellow("Please enter your choice : ");
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        print_lines();
        switch (inp){
            case "1" -> {
                register_member();
            }
            case "2" -> {
                remove_member();
            }
            case "3" -> {
                add_book();
            }
            case "4" -> {
                remove_book();
            }
            case "5" -> {
                view_all_members();
            }
            case "6" -> {
                view_all_books();
            }
            case "7" -> {
                main_interface();
            }
            default -> {
                print_red("Please enter a valid choice");
                System.out.println();
                print_lines();
                input_taker();
            }
        }
    }
    void lib_checker(){
        Scanner sc = new Scanner(System.in);
        print_blue("1.) Register a Member");
        System.out.println();
        print_blue("2.) Remove a Member");
        System.out.println();
        print_blue("3.) Add a Book");
        System.out.println();
        print_blue("4.) Remove a Book");
        System.out.println();
        print_blue("5.) View all members along with their issued books and fines to be paid");
        System.out.println();
        print_blue("6.) View all books");
        System.out.println();
        print_red("7.) Back to main menu");
        System.out.println();
        print_lines();
        print_yellow("Please Enter your choice : ");
        String inp = sc.nextLine();
        print_lines();
        switch (inp){
            case "1" -> {
                register_member();
            }
            case "2" -> {
                remove_member();
            }
            case "3" -> {
                add_book();
            }
            case "4" -> {
                remove_book();
            }
            case "5" -> {
                view_all_members();
            }
            case "6" -> {
                view_all_books();
            }
            case "7" -> {
                main_interface();
            }
            default -> {
                print_red("Please enter a valid choice");
                System.out.println();
                print_lines();
                lib_checker();
            }
        }
    }
}
