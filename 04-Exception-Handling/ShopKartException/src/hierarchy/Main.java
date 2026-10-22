package hierarchy;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            int num = Integer.parseInt("abc");
            System.out.println("The num value "+ num);
        }catch (NumberFormatException e){
            System.out.println("Exception: "+ e.getMessage());
        }

        // The Throwable hierarchy
        System.out.println("FileNotFoundException family: ");
        Class<?> type = FileNotFoundException.class;
        while(type != null){
            System.out.println(" "+ type.getSimpleName());
            type = type.getSuperclass();
        }

        System.out.println("IOException is unchecked: "+
                RuntimeException.class.isAssignableFrom(IOException.class));

        System.out.println("ArithmeticException is unchecked: "+
                RuntimeException.class.isAssignableFrom(ArithmeticException.class));

        System.out.println("StackOverflowError is an Error: "+
                Error.class.isAssignableFrom(StackOverflowError.class));

        // The stack unwinding untile someone handles the exception
        try{
            placeOrder();
        }catch (IllegalStateException e){
            System.out.println("Handled in main: "+ e.getMessage());
        }
        System.out.println("The End");
    }

    static void placeOrder() {
        System.out.println("PlaceOrder Starts");
        checkStock();
        System.out.println("PlaceOrder ends");
    }
    static void checkStock(){
        System.out.println("checkStock fails");
        throw new IllegalStateException("Laptop is out of stock");
    }
}
