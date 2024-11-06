package ex06;

public class Kingdom {
    public static void main(String[] args) {
        Resident normalGuy = new Resident("Guy", 123);
        King meKing = new King("Charles", 5747);

        System.out.println("The resident pays " + normalGuy.taxes());
        System.out.println("The king pays " + meKing.taxes());
    }
}
