package assignments.assignmentfour;

import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        MyStack<Character> charStack = new MyStack<>();
        charStack.push('J');
        charStack.push('A');
        charStack.push('V');
        charStack.push('A');
        System.out.println(charStack.toString());
        System.out.println(charStack.peek());
        char ch = charStack.pop();
        System.out.println(ch);
        System.out.println(charStack.peek());
        charStack.pop();
        System.out.println(charStack.toString());
        System.out.println(charStack.search('V'));
        System.out.println(charStack.search('J'));
        System.out.println(charStack.empty());
        charStack.pop();
        charStack.pop();

        charStack.swap('J', 'A');

        // charStack.pop();
        // System.out.println(charStack.peek());
        System.out.println(charStack.empty());
        System.out.println();
    }
}