package en.codegym.task.pro.task13.task1302;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.util.Arrays.asList;

/*
Verifying existence
*/

public class Solution {
    public static Set<String> languagesIKnow = new HashSet<>(asList("HTML CSS JavaScript SQL Java Python".split(" ")));

    public static void iteratorDemo() {
        Iterator<String> it = languagesIKnow.iterator();
        while(it.hasNext()) {
            String str = it.next();
            System.out.println("I know the " + str + " programming language");
        }
    }
    public static void checkWords(String word) {
        if(languagesIKnow.contains(word)) {
            System.out.println("The Word " + word + " is in the set");
        }
        else {
            System.out.println("The Word " + word + " is not in the set");
        }
    }

    public static void main(String[] args) {
        checkWords("C#");
        checkWords("Java");
        iteratorDemo();
    }
}