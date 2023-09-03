package org.example;
public class Main {
    public static void main(String[] args) {
        String reset = "\u001B[0m";
        String bold = "\u001B[1m";
        String purple = "\u001B[35m";
        System.out.println();
        System.out.println("*".repeat(200));
        System.out.println(bold + purple +"Welcome to IIIT - D Library"+reset);
        System.out.println("*".repeat(200));
        System.out.println();
        Library lib = new Library();
        lib.main_interface();
    }
}