package custom;

import java.util.NoSuchElementException;

public class LinkedStack<T> {
    private static class Node<T> {
        final T value;
        final Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T value){
        top = new Node<>(value, top);
        size++;
    }

    public T pop(){
        T value = peek();
        top = top.next;
        size--;
        return value;
    }

    public T peek(){
        if(top == null){
            throw new NoSuchElementException("stack is empty");
        }
        return top.value;
    }
}
