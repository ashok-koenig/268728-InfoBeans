package custom;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // cart changes, newest on top, so the shopper can undo them one by one
        LinkedStack<String> changes = new LinkedStack<>();
        changes.push("Added Laptop");
        changes.push("Added Mouse");
        changes.push("Removed Mouse");

        System.out.println("Changes: "+ changes.size());
        System.out.println("Latest: "+ changes.peek());

        // Iterable
        for(String change: changes){
            System.out.println(" "+ change);
        }

        // Undo, last change first
        System.out.println("Undo: "+ changes.pop());
        System.out.println("Undo: "+ changes.pop());
        System.out.println("Left: "+ changes.size());

        changes.pop();
        System.out.println("Empty: "+ changes.isEmpty());

        try{
            changes.pop();
        }catch (NoSuchElementException e){
            System.out.println("Nothing to undo: " + e.getMessage());
        }

        // Generic
        LinkedStack<Integer> viewed = new LinkedStack<>();
        viewed.push(101);
        viewed.push(102);
        int total =0;
        for(int view: viewed) total+=view;
        System.out.println("Sum of views: "+ total);
    }
}
