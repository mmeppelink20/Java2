package assignments.assignmentfour;

import java.util.*;

class Food {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
class Fruit extends Food {}
class Vegetable extends Food {}
class Apple extends Fruit {}
class Gala extends Apple {}
class Tropical extends Fruit {}
class Banana extends Tropical {}
class Root extends Vegetable{}
class Potato extends Root{}

interface PushPop<T> {
    T pop();
    
    T push(T item);
}

public class MyStack<T> implements PushPop<T>{
    private ArrayList<T> stack;

    // Creates an empty Stack
    public MyStack() {
        stack = new ArrayList<>();
    }

    // Tests if this stack is empty.
    public boolean empty() {
        return stack.size() == 0;
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public T peek() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    // Removes the object at the top of this stack and returns that object as the value of this function.
    public T pop() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public void swap(T obj1, T obj2) {
        int loc1 = stack.size() - search(obj1);
        int loc2 = stack.size() - search(obj2);

        T temp = stack.get(loc1);
        stack.set(loc1, obj2);
        stack.set(loc2, temp);

    }

    // Pushes an item onto the top of this stack.
    public T push(T item) {
        stack.add(item);
        return item;
    }

    // Returns the 1-based position where an object is on this stack.
    public int search(T o) {
        int i = stack.lastIndexOf(o);
        if (i >= 0) {
            return stack.size() - i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}