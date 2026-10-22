package antipatterns;

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
    public static void main(String[] args) {
        System.out.println("-- 1. Swallowing");
        System.out.println("bad: parse(abc) = "+ badParse("abc"));
        try{
            goodParse("abc");
        }catch (IllegalArgumentException e){
            System.out.println("good: "+ e.getMessage() + ", cause: "+ e.getCause().getClass().getSimpleName());
        }
    }
}
