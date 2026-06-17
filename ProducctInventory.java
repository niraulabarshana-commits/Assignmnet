interface Discountable {
    void applyDiscount(double percentage);
}

class Electronics implements Discountable {
    private String name;
    private double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price -= price * percentage / 100;
        }
    }

    public void showProducct() {
        System.out.printf("%s -> Rs. %.2f%n", name, price);
    }
}

public class ProducctInventory {
    public static void main(String[] args) {
        Electronics[] inventory = {
                new Electronics("Laptop", 85000),
                new Electronics("Phone", 45000),
                new Electronics("Headphones", 5000)
        };

        for (Electronics item : inventory) {
            item.applyDiscount(10.0);
        }

        System.out.println("Inventory after 10% discount:");
        for (Electronics item : inventory) {
            item.showProducct();
        }
    }
}
