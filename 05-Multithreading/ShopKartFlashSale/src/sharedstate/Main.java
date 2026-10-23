package sharedstate;

public class Main {
    private static int stockSold =0;
    public static void main(String[] args) throws InterruptedException {
        Thread[] shoppers = new Thread[4];
        for(int i=0;i<shoppers.length; i++){
            shoppers[i] = new Thread(()-> {
                for (int n=0; n<10000; n++){
                    stockSold++;
                }
            });
            shoppers[i].start();
        }
        for (Thread shopper: shoppers){
            shopper.join();
        }
        System.out.println("Stock Sold: "+ stockSold);
    }
}
