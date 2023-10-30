/****************************************
/* Author: Teacher
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
/* Modified by Nick Bohm, Nathan, micah
*****************************************/

import java.io.*;
import java.util.*;

public class InputOutput {
    private Scanner input;
    
    public InputOutput() {
        input = new Scanner(System.in);
    }
    
    public InputOutput(Scanner inInput) {
        input = inInput;
    }
    
    public InputOutput(String filename) {
        try {
            input = new Scanner(new FileReader(filename));
        } catch (IOException e) {
            System.err.println("Error opening file");
            System.exit(0);
        }
    }
    
    public int nextInt() {
        return input.nextInt();
    }
    
    public String nextString() {
        return input.next();
    }
    
    public void flushLine() {
        input.nextLine();
    }
    
    public void print(String line) {
        System.out.print(line);
    }
    
    public void println(String line) {
        System.out.println(line);
    }
}
    
    
