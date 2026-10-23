package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static void onFourThread(Runnable job) throws InterruptedException {
        Thread[] threads = new Thread[4];
        for (int i=0;i<threads.length; i++){
            threads[i] = new Thread(job);
            threads[i].start();
        }
        for(Thread thread: threads){
            thread.join();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // ConcurrentHashMap
        Map<String, Integer> broken = new ConcurrentHashMap<>();
        onFourThread(()-> {
            for(int i=0;i< 50000; i++){
                if(broken.containsKey("phone")){
                    broken.put("phone", broken.get("phone")+ 1);
                }else{
                    broken.put("phone", 1);
                }
            }
        });
        System.out.println("Phone count: "+ broken.get("phone"));
        Map<String, Integer> sales = new ConcurrentHashMap<>();
        onFourThread(()-> {
            for(int i=0;i< 50000; i++){
               sales.merge("phone", 1, Integer::sum);
            }
        });
        System.out.println("Phone count: "+ sales.get("phone"));

        // CopyOnWriteArrayList
        List<String> listeners = new CopyOnWriteArrayList<>(List.of("audit"));
        for(String l : listeners){
            listeners.add("late");
        }
        System.out.println("CopyonWrite listeners: "+ listeners);

        // Plain ArrayList
        List<String> plain = new ArrayList<>(List.of("audit"));
        for(String l : plain){
            plain.add("late");
        }
        System.out.println("Array List: "+ listeners);
    }
}
