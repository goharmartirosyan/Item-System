# Inventory Management System
## Overview
This is a Java-based inventory management system that allows users to create, manage, and upgrade game items based on their rarity. Items can be upgraded by combining multiple items of the same type according to predefined upgrade rules. The system ensures proper inventory management, user interaction via the console, and error handling for invalid operations.

## Features
Add new items to the inventory.
Upgrade items based on predefined upgrade paths.
Display the inventory with item counts, grouped by rarity.
Handle invalid inputs gracefully.
Enforce upgrade requirements through structured rules.
## How to Run
Compile the Java files:
javac *.java
Run the Main class:
java Main
Follow the on-screen prompts to interact with the inventory system.
## Error Handling
1. Invalid Rarity Input
When creating an item, if an invalid rarity type is provided, an IllegalArgumentException is thrown:
throw new IllegalArgumentException("Invalid rarity type: " + rarityInput);
The user is prompted to enter a valid rarity type.
2. Invalid Epic Level
If the user tries to create an Epic item with an incorrect level (e.g., "Epic 3"), an exception is thrown:
throw new IllegalArgumentException("Invalid Epic level. Use 'Epic 1' or 'Epic 2'");
3. Invalid Menu Selection
The system ensures that the user selects a valid menu option (1-4). If an invalid option is entered, a message is displayed:
System.out.println("Invalid choice. Please enter a number between 1 and 4.");
4. Item Not Found for Upgrade
When upgrading an item, the system first checks if the item exists in the inventory. If not, a message is displayed:
System.out.println("Item not found in inventory. Please try again.");
5. Insufficient Items for Upgrade
If there aren’t enough items for an upgrade, the upgrade is aborted, and an error message is displayed:
System.out.println("Not enough items to upgrade " + name + " (" + rarity + ")");
