package queues;

import model.SampleData;
import model.Customer;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Queue: fist in, first out. The checkout line
        Queue<String> checkout = new ArrayDeque<>();
        for (Customer customer: SampleData.customers().subList(0,3)) {
            checkout.offer(customer.name());
        }
        System.out.println("Next: " + checkout.peek());
        System.out.println("Served: "+ checkout.poll());
        System.out.println("Sill waiting: "+ checkout.size());

        // PriorityQueue: express orders first, then the order that has waited longest
        Queue<PackingJob> packing = new PriorityQueue<>(
                Comparator.comparing(PackingJob::express).reversed()
                        .thenComparing(Comparator.comparingInt(PackingJob::waitingMinutes).reversed())
                        .thenComparing(PackingJob::orderId)
        );

        packing.add(new PackingJob("01", false, 30));
        packing.add(new PackingJob("02", true, 5));
        packing.add(new PackingJob("03", false, 30));
        packing.add(new PackingJob("04", true, 20));

        while(!packing.isEmpty()){
            PackingJob job = packing.poll();
            System.out.println("Pack "+ job.orderId() + (job.express()? "express": "standard")+", waiting: "+ job.waitingMinutes());
        }
    }
}
