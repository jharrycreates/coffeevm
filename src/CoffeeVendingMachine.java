import java.util.Scanner;

public class CoffeeVendingMachine {
    // Prices for hot and iced coffee types
    private final double HOT_ESPRESSO_COST = 1.50;
    private final double ICED_LATTE_COST = 2.50;
    private final double HOT_CAPPUCCINO_COST = 3.00;
    private final double ICED_MOCHA_COST = 3.50;

    private double balance = 0;

    // Method to insert money into the machine
    public void insertMoney(double amount) {
        balance += amount;
        System.out.printf("You inserted $%.2f. Current balance: $%.2f%n", amount, balance);
    }

    // Method to select coffee and check if there's enough balance
    public void selectCoffee(String type) {
        double cost = getCoffeeCost(type);

        if (cost == 0) {
            System.out.println("Invalid coffee type selected.");
            return;
        }

        if (balance >= cost) {
            balance -= cost;
            System.out.printf("Dispensing %s. Remaining balance: $%.2f%n", type, balance);
        } else {
            System.out.println("Oops! Not enough money for this coffee.");
        }
    }

    // Method to get the cost based on coffee type
    private double getCoffeeCost(String type) {
        switch (type.toLowerCase()) {
            case "hot espresso":
                return HOT_ESPRESSO_COST;
            case "iced latte":
                return ICED_LATTE_COST;
            case "hot cappuccino":
                return HOT_CAPPUCCINO_COST;
            case "iced mocha":
                return ICED_MOCHA_COST;
            default:
                return 0; // Invalid coffee type
        }
    }

    public static void main(String[] args) {
        CoffeeVendingMachine machine = new CoffeeVendingMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n🌟 Welcome to the Coffee Vending Machine! 🌟");
            System.out.println("1. Insert Money");
            System.out.println("2. Select Coffee");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Insert amount: $");
                    double amount = scanner.nextDouble();
                    machine.insertMoney(amount);
                    break;
                case 2:
                    System.out.println("Available Coffees:");
                    System.out.println("1. Hot Espresso ($1.50)");
                    System.out.println("2. Iced Latte ($2.50)");
                    System.out.println("3. Hot Cappuccino ($3.00)");
                    System.out.println("4. Iced Mocha ($3.50)");
                    System.out.print("Enter coffee name (e.g., Hot Espresso): ");
                    String coffeeType = scanner.nextLine();
                    machine.selectCoffee(coffeeType);
                    break;
                case 3:
                    System.out.println("Thanks for using the coffee machine! Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
