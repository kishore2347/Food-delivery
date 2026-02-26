import java.util.*;

class FoodItem {
    int id;
    String name;
    double price;

    FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class FoodDeliveryApp {

    static List<FoodItem> menu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double totalAmount = 0;

    public static void main(String[] args) {

        menu.add(new FoodItem(1, "Pizza", 250));
        menu.add(new FoodItem(2, "Burger", 120));
        menu.add(new FoodItem(3, "Pasta", 180));
        menu.add(new FoodItem(4, "Sandwich", 90));
        menu.add(new FoodItem(5, "Cold Drink", 50));

        int choice;

        do {
            System.out.println("\n---- FOOD DELIVERY APPLICATION ----");
            System.out.println("1. View Menu");
            System.out.println("2. Order Food");
            System.out.println("3. View Total Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewMenu();
                    break;

                case 2:
                    orderFood();
                    break;

                case 3:
                    System.out.println("Total Bill Amount: ₹" + totalAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using Food Delivery App!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    static void viewMenu() {
        System.out.println("\n---- MENU ----");
        for (FoodItem item : menu) {
            System.out.println(item.id + ". " + item.name + " - ₹" + item.price);
        }
    }

    static void orderFood() {
        viewMenu();
        System.out.print("Enter Food ID to order: ");
        int id = sc.nextInt();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        for (FoodItem item : menu) {
            if (item.id == id) {
                double cost = item.price * qty;
                totalAmount += cost;
                System.out.println("Added to cart. Cost: ₹" + cost);
                return;
            }
        }

        System.out.println("Invalid Food ID!");
    }
}