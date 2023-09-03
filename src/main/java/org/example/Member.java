package org.example;

import java.util.ArrayList;

public class Member extends Library {
    private long start1;
    private long start2;
    private long end2;
    private long end1;
    protected String name;
    protected String phone;
    protected int age;
    protected int member_id;
    protected int fine_to_be_paid = 0;
    Member(String name, String phone, int age, int member_id) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.member_id = member_id;
    }
//    protected int fine_getter() {
//        return (int) ((end1 - start1) / 1000) + (int) ((end2 - start2) / 1000);
//    }
    private void start1() {
        this.start1 = System.currentTimeMillis();
    }
    private long end1() {
        this.end1 = System.currentTimeMillis();
        return ((end1 - start1) / 1000);
    }
    private void start2() {
        this.start2 = System.currentTimeMillis();
    }
    private long end2() {
        this.end2 = System.currentTimeMillis();
        return ((end2 - start2) / 1000);
    }
    private int timer_book1(long time) {
        if (time > 10) {
            return (int) (time - 10);
        } else {
            return 0;
        }
    }
    private int timer_book2(long time) {
        if (time > 10) {
            return (int) (time - 10);
        } else {
            return 0;
        }
    }
    void book1_issue_timer() {
        start1();
    }
    void book2_issue_timer() {
        start2();
    }
    void book1_return_timer() {
        fine_to_be_paid += 3 * timer_book1(end1());
    }
    void book2_return_timer() {
        fine_to_be_paid += 3 * timer_book2(end2());
    }
    int books_issued = 0;
    ArrayList<Book> issued_book_Object_Array = new ArrayList<Book>(2);
    void print_details_mem() {
        print_purple("Name : ");
        print(name);
        print_purple("Phone : ");
        print(phone);
        print_purple("Age : ");
        print(String.valueOf(age));
        print_purple("Member ID : ");
        print(String.valueOf(member_id));
        print_purple("Books Issued : ");
        print(String.valueOf(books_issued));
        print_purple("Fine to be paid : ");
        print(String.valueOf(fine_to_be_paid));
//        print_lines();
    }
}

