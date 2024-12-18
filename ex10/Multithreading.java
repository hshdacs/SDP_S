package ex10;

public class Multithreading {

    public static void main(String[] args) throws InterruptedException {
        Store store = new Store(0);
        Producer l1 = new Producer(store);
        Producer l2 = new Producer(store);

        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(l2);

        long startTime = System.currentTimeMillis();
        System.out.println( "Starting stock: " + store.getStock() );
        t1.start();
        t2.start();

        // main is doing some more work ...
        for (int i = 0; i < Producer.MAX_CAPACITY / 2; i++) {
            performAction(i);
        }
        System.out.println( "Temporary stock: " + store.getStock() );

        t1.join();
        t2.join();

        long stopTime = System.currentTimeMillis();
        System.out.println( "Final stock: " + store.getStock() );
        long diffTime = stopTime - startTime;
        System.out.println("takes " + diffTime + "ms");
    }
            
    private static double performAction(int i) {
        // just do some (useless) calculation
        return Math.pow(2, i);
    }
}
