# Java Project

This is the project for my CIS-175 Java II course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Introduction - Reflection

The introductory unit for Java II was mostly a fast review of the final unit of Java I. However, Another thing we were introduced to was the lambda expression (->). I had previously heard of lambda expressions but did not know much about them. The syntax for the lambda expression reminds me of the arrow operator in C. Additionally we learned about the forEach() method in the ArrayList class. When the lambda expression is combined with the forEach method, it can make for a very short way to print the members of an ArrayList, for example: 
``` Java
ArrayList<Integer> Numbers = new ArrayList<Integer>();

// Add Number to list
Numbers.add(23);
Numbers.add(32);
Numbers.add(45);
Numbers.add(63);

// forEach method of ArrayList and
// print numbers
Numbers.forEach((n) -> System.out.println(n));
// code taken from https://www.geeksforgeeks.org/arraylist-foreach-method-in-java/
```
this code would print the following numbers `23, 32, 45, 63`


## Module 1 - Reflection

In module 1 of Java 2 we learned about JUnit testing. I had previously been exposed to using JUnit in my ComS-227 class at Iowa State University, but this served as a useful review of JUnit as I hadn't used it for some time. JUnit5 has 3 types of test methods `assertEquals(x, y);`, `assertThrows();`, and `assertTrue();`. The one that is mainly used, assertEquals compares the expected value, "x", with the actual value, "y", and if the assertion is true, then the test passes.
