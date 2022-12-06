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

## Module 3 - Contributing to Open Source Projects

in module 3 of Java 2 we learned more in-depth about how to use Git and GitHub, a version control software, to collaborate on projects as a group of people, open source or otherwise. I previously thought I had a satisfactory understanding of how to use GitHub, but after completing this module I realized that wasn't really the case. This module introduced me to Git/GitHub features I previously had no knowledge of. The introduction of branches was perhaps the most interesting to me, they serve a valuable purpose in that you're able to work on an addition to your project with the peace of mind that if you mess up, you're able to go back very easily. 

## Module 4 - Generics

in module 4 of Java 2 we generics and wildcard arguments. A generic class in Java looks like this

```
class GenricExample<T> {
  // example code
}
```
A generic type, in Java, can not be representative of a primitive data type, such as an int or double. It can only be a class data type, such as a String or Integer. Using generics in Java offers many benefits; the java compiler offers stronger type checking when compiling generic code and will issue a compile-time error if type safety is violated. compile-time errors are much easier to fix than runtime errors. Generics also eliminate the need for casting in a lot of scenarios. lastly, generics can be used to implement generic algorithms, such as, the incredibly useful `ArrayList<T>` or `HashMap<K,V>`

https://docs.oracle.com/javase/tutorial/java/generics/why.html

Wildcard arguments are simply representative of an unknown type, and are representated by a `?`. They look like this

``` reverse(List<?> list) ```

## Moduel 6 - Lambda Expressions


in module 6 of Java 2, titled "Lambda Expressions" we learned about lambda expressions, method referenes, and functional interfaces. The functional interfaces we learned about were, the Supplier, Consumer, Predicate, Function, and UnaryOperator; we also learned about their "Bi" counter-parts, that except two arguments, rather than one. Method referenes are useful for being able to shorten the amount of code you have to write, here's an example of a method reference and consumer that really helped me understand how to use method references:
``` 
Consumer<String> consumer = UIUtility::showSectionTitle;
consumer.accept("Matthew"); 
```
This piece of code would simply call the UIutilitiy's showSectionTItle method, with the given arguments of the Consumer interface's abstract method accept() when paired with the object name.


## GENERAL ETHICAL PRINCIPLES

### 1.1 Contribute to society and to human well-being

I promise to promote fundamental human rights and protect every individual's right to autonomy. I promoise to respect diversity, promote work that will be used in socially responsible ways, will meet societies needs, and will be accessible. As well as promoting environmental sustainability.

### 1.2 Avoid harm

I promise to not cause physical or mental harm to others, unjustified destruction or disclosure of information, and unjustified damage to property, reputation, and the environment. I promise to complete my assigned duties in good faith; meaning, I will not commit any of the aforementioned actions in favor of personal gain. I promise to to report any signs of system risks that might result in any of the aforementioned categories of harm.

### 1.3 Be honest and trustworthy.

I promise to provide transparency and full discolsure of all pertinent system capabilities, limitations, and potential problems to the appropriate parties. This includes: making deliberately false or misleading claims, fabricating or falsifying data, offering or accepting bribes. I promise not to commit and of the aforementioned acts in any circumstance.

### 1.4 Be fair and take action not to discriminate.

I promise to uphold the values of equality, tolerance, and respect for others. I promise to foster an environment with fair participation for all kinds of people. I promise to avoid creating any system that will enhance or create any inequalities.

### 1.5 Respect the work required to produce new ideas, inventions, creative works, and computing artifacts.

I promise to respect other creator's ideas, inventinos, work, and artifacts, and respect copyrights, patents, trade secrets, license agreements, and other methods of protecting an author's works. I promise to not unduly oppose others' contributions of time and energy to projects that will help society.

### 1.6 Respect privacy.

I promise to familiarize myself with the various definitions and forms of privacy and understand the forms of privacy, rights and responsibilities associated with the collection and use of personal information. I promise to only collect the minimum amount of information necessary to make a system work.

### 1.7 Honor confidentiality.

I promise to protect trade secrets, client data, nonpublic business strategies, financial information, research data, pre-publication scholarly articles, and patent applications. I promise to protect confidentiality except in cases where it is evidence of the violation of law, and to only disclose such confidential information to the appropriate authorities. 









