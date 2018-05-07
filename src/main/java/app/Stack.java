/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;

/**
 *
 * @author jasmin
 */
public class Stack {
    
    private String stack[];
    private int top;
    private static final int SIZE = 5;
    
    public Stack() {
        stack = new String [SIZE];
        top = -1;
    }

    public boolean push(String s) {             //Insert (to top)
        if (top >= SIZE-1) {
            return false;
        } else {
            stack[++top] = s;
            return true;
        }
    }

    public String pop() {                       //Delete (from top)
        if (top == -1) {
            return null;
        } else {
            return stack[top--];
        }
    }
    
    /*public String peek() {
        
    }*/

    public void print() {                       //Print the stack
        for (int i = top; i >= 0; i--)
            System.out.print(stack[i] + " ");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack cities = new Stack();
        String item;
        int count = 1;
        
        try {
            System.out.println("Compare cities: ");
            do {
                item = sc.nextLine();
                cities.push(item);
                count++;
            } while (count <= 5);
            cities.print();
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }
}