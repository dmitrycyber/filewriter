package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(10);



    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CallableTask> collection = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            collection.add(new CallableTask(cyclicBarrier1));
        }
        executorService.invokeAll(collection);

        TimeUnit.SECONDS.sleep(1);
        System.out.println(atomicInteger);

        executorService.shutdown();





        /*for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }*/

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Finish: " + atomicInteger);

    }

    public static class Task implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.getAndIncrement();
            }
        }
    }

    public static class CallableTask implements Callable<Integer>{
        CyclicBarrier cyclicBarrier;


        public CallableTask(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public Integer call() throws Exception {
            cyclicBarrier.await();
            for (int i = 0; i < 100; i++) {
                System.out.println(atomicInteger.get());
                atomicInteger.getAndIncrement();
            }
            return null;
        }
    }
}
