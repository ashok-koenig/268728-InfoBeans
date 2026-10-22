package antipatterns;

import java.sql.SQLException;

public class Main {
    // 1. swallowing
    static int badParse(String text){
        int qty = 0;
        try {
            qty = Integer.parseInt(text);
        }catch (Exception e){

        }
        return qty;
    }
    static int goodParse(String text){
        try{
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Quantity must be a number", e);
        }
    }
    // 2. Catching Throwable
    static void reserve(boolean outOfStock){
        if(outOfStock){
            throw new IllegalStateException("out of stock");
        }
    }
    static String badReserve(boolean outOfStock){
        try{
            reserve(outOfStock);
            return "reserved";
        }catch (Throwable t){
            return "failed";
        }
    }
    static String goodReserve(boolean outOfStock){
        try{
            reserve(outOfStock);
            return "reserved";
        }catch (IllegalStateException e){
            return "failed: "+ e.getMessage();
        }
    }
    // 3. Exceptions as control flow
    static int badCount(String[] ids){
        int n=0;
        int totalLength=0;
        try{
            while(true){
                totalLength += ids[n].length();
                n++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            // Loop ended
        }
        return totalLength;
    }
    static int goodCount(String[] ids){
        int totalLength =0;
        for(String id: ids){
            totalLength+=id.length();
        }
        return totalLength;
    }
    // 4. Losing the cause
    static void badLoad(String id){
        try{
            throw new SQLException("Connection refused");
        }catch (SQLException e){
            throw new RuntimeException("Load failed");
        }
    }
    static void goodLoad(String id){
        try{
            throw new SQLException("Connection refused");
        }catch (SQLException e){
            throw new LoadFailedException("Load failed for id: "+ id, e);
        }
    }
    static class LoadFailedException extends RuntimeException{
        LoadFailedException(String message, Throwable cause){
            super(message, cause);
        }
    }
    public static void main(String[] args) {
        System.out.println("-- 1. Swallowing");
        System.out.println("bad: parse(abc) = "+ badParse("abc"));
        try{
            goodParse("abc");
        }catch (IllegalArgumentException e){
            System.out.println("good: "+ e.getMessage() + ", cause: "+ e.getCause().getClass().getSimpleName());
        }
        System.out.println("-- 2. Catching Throwable");
        System.out.println("bad: "+ badReserve(true));
        System.out.println("good: "+ goodReserve(true));
        System.out.println("-- 3. control flow");
        String[] ids = {"O1", "O2", "O3"};
        System.out.println("bad: "+ badCount(ids));
        System.out.println("good: "+ goodCount(ids));

        System.out.println("-- 4. Losing the cause");
        try{
            badLoad("01");
        }catch (RuntimeException e){
            System.out.println("bad: cause = "+ e.getCause());
        }
        try{
            goodLoad("01");
        }catch (RuntimeException e){
            System.out.println("good: cause = "+ e.getCause());
        }
    }
}
