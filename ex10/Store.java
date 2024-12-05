package ex10;

public class Store {
    private int stock;

    public Store(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void deliver(int amount) {
        stock += amount;
    }
}
