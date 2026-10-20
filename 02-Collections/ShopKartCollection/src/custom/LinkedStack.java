package custom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Iterable<T>{

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

    public boolean isEmpty(){
        return size ==0;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = top;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(current == null){
                    throw new NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
