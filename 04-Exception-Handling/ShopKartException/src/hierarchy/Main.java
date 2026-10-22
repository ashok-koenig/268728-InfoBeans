package hierarchy;

import java.io.FileNotFoundException;

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

        System.out.println("The End");
    }
}
