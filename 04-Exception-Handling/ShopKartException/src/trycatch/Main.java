package trycatch;

public class Main {
    static void divide(String text, int divisor){
        try{
            int number = Integer.parseInt(text);
            System.out.println("Result: " + number / divisor);
            System.out.println("Try block finished");
        }catch (NumberFormatException e){
            System.out.println("Not a number; "+ e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Cannot divide: "+ e.getMessage());
        } finally {
            System.out.println("Always printed");
        }
    }
    // Multi-catch
    static void parseQuantity(String text){
        try{
            int qty = Integer.parseInt(text.trim());
            System.out.println("Quantity: "+ qty);
        }catch (NumberFormatException | NullPointerException e){
            System.out.println("Bad input: "+ e.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        System.out.println("-- success path");
        divide("20", 5);
        System.out.println("-- exception path");
        divide("abc", 5);
        System.out.println("-- another exception");
        divide("20", 0);
        try{
            Integer.parseInt("xyz");
        }catch (NumberFormatException e){
            System.out.println("Specific handler");
        }catch (IllegalArgumentException e){
            System.out.println("General handler");
        }

        // Multi-catch
        parseQuantity("3");
        parseQuantity("three");
        parseQuantity(null);
    }
}
