import java.util.*;

// Main class
public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Food> menu = new ArrayList<>();
    static HashMap<String, Order> orders = new HashMap<>();

    static int orderCounter = 1;

    public static void main(String[] args) {

        // Adding food items
        menu.add(new Food(1, "Burger", 500, 20));
        menu.add(new Food(2, "Pizza", 1200, 15));
        menu.add(new Food(3, "Biryani", 350, 25));
        menu.add(new Food(4, "Sandwich", 400, 20));

        while (true) {

            System.out.println("\n0. Exit");
            System.out.println("1. View Food Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. View My Orders");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 0:
                    System.out.println("Exiting Restaurant Management System...");
                    return;

                case 1:
                    viewMenu();
                    break;

                case 2:
                    placeOrder();
                    break;

                case 3:
                    cancelOrder();
                    break;

                case 4:
                    viewOrders();
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    // Function to read integer input
    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 1. View food menu
    static void viewMenu() {

        System.out.println("\n--- Restaurant Food Menu ---");

        for (Food f : menu) {
            f.displayFood();
        }
    }

    // 2. Place order
    static void placeOrder() {

        viewMenu();

        System.out.print("\nEnter Food ID: ");
        int foodId = readInt();

        Food selectedFood = null;

        for (Food f : menu) {
            if (f.getId() == foodId) {
                selectedFood = f;
                break;
            }
        }

        if (selectedFood == null) {
            System.out.println("Invalid Food ID!");
            return;
        }

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = readInt();

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        if (quantity > selectedFood.getAvailableQuantity()) {
            System.out.println("Only "
                    + selectedFood.getAvailableQuantity()
                    + " items available!");
            return;
        }

        selectedFood.reduceQuantity(quantity);

        String orderId = "O" + orderCounter++;

        Order order = new RestaurantOrder(
                orderId, name, selectedFood, quantity
        );

        orders.put(orderId, order);

        System.out.println("\nOrder placed successfully!");
        order.displayOrder();
    }

    // 3. Cancel order
    static void cancelOrder() {

        System.out.print("Enter Order ID to cancel: ");
        String orderId = sc.nextLine();

        Order order = orders.get(orderId);

        if (order != null) {

            order.getFood().addQuantity(order.getQuantity());

            orders.remove(orderId);

            System.out.println("Order cancelled successfully!");

        } else {
            System.out.println("Order not found!");
        }
    }

    // 4. View orders
    static void viewOrders() {

        if (orders.isEmpty()) {
            System.out.println("No orders available!");
            return;
        }

        System.out.println("\n--- Customer Orders ---");

        for (Order o : orders.values()) {
            o.displayOrder();
        }
    }
}


// Food class
class Food {

    // Encapsulation: Private attributes
    private int id;
    private String name;
    private double price;
    private int availableQuantity;

    // Constructor
    Food(int id, String name, double price, int availableQuantity) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    // Method to reduce quantity
    public void reduceQuantity(int quantity) {
        availableQuantity -= quantity;
    }

    // Method to add quantity
    public void addQuantity(int quantity) {
        availableQuantity += quantity;
    }

    // Display food details
    public void displayFood() {

        System.out.println(
                "ID: " + id
                + " | Food: " + name
                + " | Price: Rs." + price
                + " | Available: " + availableQuantity
        );
    }
}


// Abstract parent class
abstract class Order {

    // Private attributes
    private String orderId;
    private String customerName;
    private Food food;
    private int quantity;

    // Constructor
    Order(String orderId, String customerName,
          Food food, int quantity) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.food = food;
        this.quantity = quantity;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract methods
    abstract double calculateTotalBill();

    abstract void displayOrder();
}


// Child class
class RestaurantOrder extends Order {

    // Constructor
    RestaurantOrder(String orderId, String customerName,
                    Food food, int quantity) {

        super(orderId, customerName, food, quantity);
    }

    // Method overriding (Polymorphism)
    @Override
    double calculateTotalBill() {

        return getFood().getPrice() * getQuantity();
    }

    // Method overriding (Polymorphism)
    @Override
    void displayOrder() {

        System.out.println(
                "\nOrder ID: " + getOrderId()
                + " | Customer: " + getCustomerName()
                + " | Food: " + getFood().getName()
                + " | Quantity: " + getQuantity()
                + " | Total Bill: Rs." + calculateTotalBill()
        );
    }
}

