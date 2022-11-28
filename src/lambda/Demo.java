package lambda;


import assignments.challengeone.Person;
import com.sun.source.doctree.UnknownInlineTagTree;
import final_project.UIUtility;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;

class Product {

    public Product() {
        System.out.println("Product supplied");
    }
}
public class Demo {
    public static void main(String[] args) {

        Supplier<Product> proSupplier = () -> new Product();
        System.out.println("p1");
        Product p = proSupplier.get();
        System.out.println("p2");

        Predicate<String> missing = s -> s == null || s.isBlank();

        System.out.println(missing.test(""));


        // Predicate
        Predicate<Integer> isEven = (num) -> num % 2 == 0;

        List<Integer> myNums = new ArrayList<>(Arrays.asList(8, 1, 9, 2, 6 ,7)); //immutable
        myNums.removeIf(isEven);
        System.out.println(myNums + "\n");


        int n = 4;
        System.out.println(n + " is " + (isEven.test(n) ? "even" : "odd"));
        n = 5;
        System.out.println(n + " is " + (isEven.test(n) ? "even" : "odd"));
        n = 6;
        System.out.println(n + " is " + (isEven.test(n) ? "even" : "odd"));

        System.out.println();

        Predicate<String> containsHashTag = (str) -> str.indexOf("#") >= 0;
        String tweet = "Kirkwood Eagles advance to the #NJCAAVB DII Championships for the fifth straight year";
        if(containsHashTag.test(tweet)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    // Predicate


        // BiPredicate
        BiPredicate<Integer, Integer> isFactor = (x, y) -> x % y == 0;

        int num1 = 10;
        int num2 = 2;

        System.out.println(num2 + " is" + (isFactor.test(num1, num2) ? "" : " not") + " a factor of " + num1);

        num2 = 3;
        System.out.println(num2 + " is" + (isFactor.test(num1, num2) ? "" : " not") + " a factor of " + num1);
    // BiPredicate

        Consumer<String> consumer = UIUtility::showSectionTitle;
        consumer.accept("Matthew");
    }
}
