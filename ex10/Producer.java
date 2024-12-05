package ex10;

public class Producer implements Runnable {
    public final static int MAX_CAPACITY = 1_000_000;

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            store.deliver(1);
        }
    }

}
