package oop.week4;

class FoodOrder {
    private String studentName;
    private String dishName;
    private boolean delivered;
    private int deliveryAttemptCount = 0;

    public FoodOrder(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty or null.");
        }
        if (dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty or null.");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.delivered = false;
    }

    public void markDelivered() {
        deliveryAttemptCount++;
        if (deliveryAttemptCount > 1) {
            System.out.println("ALERT: Order for " + studentName + " (" + dishName + ") is being double-served!");
        } else {
            this.delivered = true;
            System.out.println("Order delivered successfully to " + studentName);
        }
    }

    public static void processBatch(String[][] rawOrders) {
        int valid = 0;
        int rejected = 0;

        if (rawOrders == null) {
            System.out.println("Valid: 0 | Rejected: 0");
            return;
        }

        for (String[] order : rawOrders) {
            if (order == null || order.length < 2) {
                rejected++;
                continue;
            }
            try {
                new FoodOrder(order[0], order[1]);
                valid++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }
}

public class AssignmentP1_FoodOrder {
    public static void main(String[] args) {
        String[][] rawOrders = {
                { "Ravi", "Paneer Butter Masala" },
                { "", "Chole Bhature" },
                { "Meera", " " },
                { "Divya", "Veg Biryani" }
        };
        FoodOrder.processBatch(rawOrders);
    }
}