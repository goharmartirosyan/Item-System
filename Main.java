import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Item  2. Upgrade Item  3. Show Inventory  4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter rarity (Common, Great, Rare, Epic, Epic 1, Epic 2): ");
                String rarity = scanner.nextLine();
                inventory.addItem(new Item(name, rarity));
            } else if (choice == 2) {
                System.out.print("Enter item name to upgrade: ");
                String name = scanner.nextLine();
                System.out.print("Enter current rarity: ");
                String rarity = scanner.nextLine();
                inventory.upgradeItem(name, rarity);
            } else if (choice == 3) {
                inventory.displayInventory();
            } else {
                break;
            }
        }
        scanner.close();
    }
}