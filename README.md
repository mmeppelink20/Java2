# Java Project

This is the project for my CIS-175 Java II course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Introduction - Reflection

The introductory unit for Java II was mostly a fast review of the final unit of Java I. However, Another thing we were introduced to was the lambda expression (->). I had previously heard of lambda expressions but did not know much about them. The syntax for the lambda expression reminds me of the arrow operator in C. Additionally we learned about the forEach() method in the ArrayList class. When the lambda expression is combined with the forEach method, it can make for a very short way to print the members of an ArrayList, for example: 
``` Java
ArrayList<Integer> numbers = new ArrayList<Integer>();

// Add Number to list
numbers.add(23);
numbers.add(32);
numbers.add(45);
numbers.add(63);

// forEach method of ArrayList and
// print numbers
numbers.forEach((n) -> System.out.println(n));
// code taken from https://www.geeksforgeeks.org/arraylist-foreach-method-in-java/
```
this code would print the following numbers `23, 32, 45, 63`. 


## Module 1 - Test Drive Development

In module 1 of Java 2 we learned about JUnit testing. I had previously been exposed to using JUnit in my ComS-227 class at Iowa State University, but this served as a useful review of JUnit as I hadn't used it for some time. JUnit5 has 3 types of test methods `assertEquals(x, y);`, `assertThrows();`, and `assertTrue();`. The method that is mainly used, assertEquals compares the expected value, "x", with the actual value, "y", and if the assertion is true, then the test passes. JUnit is an extremely helpful tool to ensure that your program is adequately tested and to ensure that all possible outcomes are checked and accounted for.

## Module 2 - Collections

in module 2 of Java 2 we learned about the Collections class, Maps and HashMaps, immutable vs mutable objects, deep copies and shallow copies, sorting, and the lambda expression. This has probably been the most difficult module throughout the entire Kirkwood Java track so far for me. I have no trouble implementing the concepts that were went over in this module, although, my knowledge of the lambda expression could use some more refining; when it comes to answering various questions about the Collections class I seem to strugle a little bit more. 

## Contributing to Open Source Projects

in module 3 of Java 2 we learned more in-depth about how to use Git and GitHub, a version control software, to collaborate on projects as a group of people, open source or otherwise. I previously thought I had a satisfactory understanding of how to use GitHub, but after completing this module I realized that wasn't really the case. This module introduced me to Git/GitHub features I previously had no knowledge of. The introduction of branches was perhaps the most interesting to me, they serve a valuable purpose in that you're able to work on an addition to your project with the peace of mind that if you mess up, you're able to go back very easily. 



















