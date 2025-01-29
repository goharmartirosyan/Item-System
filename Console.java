import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = 0;
            do {
                System.out.println("\n1. Add Item  2. Upgrade Item  3. Show Inventory  4. Exit");
                choice = scanner.nextInt();

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } while (choice < 1 || choice > 4);

            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                String rarity = getValidRarity(scanner);
                inventory.addItem(new Item(name, rarity));
            } else if (choice == 2) {
                System.out.print("Enter item name to upgrade: ");
                String name = scanner.nextLine();

                // checks if the item exists in the inventory
                boolean itemExists = false;
                for (Item item : inventory.getItems()) {
                    if (item.getName().equalsIgnoreCase(name)) {
                        itemExists = true;
                        break;
                    }
                }

                if (!itemExists) {
                    // in case it is not found
                    System.out.println("Item not found in inventory. Please try again.");
                } else {
                    String rarity = getValidRarity(scanner);
                    inventory.upgradeItem(name, rarity);
                }
            } else if (choice == 3) {
                inventory.displayInventory();
            } else {
                break;
            }
        }
        scanner.close();
    }
    private static String getValidRarity(Scanner scanner) {
        String rarity = "";
        boolean validRarity = false;

        while (!validRarity) {
            System.out.print("Enter rarity (Common, Great, Rare, Epic, Epic 1, Epic 2): ");
            rarity = scanner.nextLine();

            // Check if the rarity is valid
            if (rarity.equalsIgnoreCase("Common") ||
                    rarity.equalsIgnoreCase("Great") ||
                    rarity.equalsIgnoreCase("Rare") ||
                    rarity.equalsIgnoreCase("Epic") ||
                    rarity.equalsIgnoreCase("Epic 1") ||
                    rarity.equalsIgnoreCase("Epic 2")) {

                validRarity = true;  // If valid, exit the loop
            } else {
                System.out.println("Invalid rarity. Please enter a valid rarity (Common, Great, Rare, Epic, Epic 1, Epic 2).");
            }
        }

        return rarity;
    }
}
