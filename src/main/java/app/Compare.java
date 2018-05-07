package app;

public class Compare {
    
    private String stack[];
    private int top;
    private static final int SIZE = 5;
    
    public Compare() {
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
}