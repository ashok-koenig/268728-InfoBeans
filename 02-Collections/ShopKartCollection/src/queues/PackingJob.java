package queues;

public record PackingJob(String orderId, boolean express, int waitingMinutes) {
}
