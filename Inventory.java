import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void displayInventory() {
        Map<String, Integer> itemCount = new HashMap<>();

        for (Item item : items) {
            itemCount.put(item.toString(), itemCount.getOrDefault(item.toString(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue());
        }
    }
    public boolean upgradeItem(String name, String rarity) {
        Map<String, String> upgradePath = new HashMap<>();
        upgradePath.put("Common", "Great");
        upgradePath.put("Great", "Rare");
        upgradePath.put("Rare", "Epic");
        upgradePath.put("Epic", "Epic 1");
        upgradePath.put("Epic 1", "Epic 2");
        upgradePath.put("Epic 2", "Legendary");

        if (!upgradePath.containsKey(rarity)) {
            System.out.println("Upgrade not possible for this rarity.");
            return false;
        }

        String newRarity = upgradePath.get(rarity);
        List<Item> matchingItems = new ArrayList<>();

        for (Item item : items) {
            if (item.getName().equals(name) && item.getRarity().equalsIgnoreCase(rarity)) {
                matchingItems.add(item);
            }
        }

        int requiredCount = 3; // Default requirement

        if (rarity.equals("Epic")) {
            requiredCount = 2;
        } else if (rarity.equals("Epic 1")) {
            requiredCount = 1;


            int i = 0;
            Item epicItem = null;
            for (Item item : items) {
                if (item.rer() == Rarity.EPIC) {
                    i++;
                    epicItem = item;
                    break;
                }
            }

            if (epicItem == null) {
                System.out.println("Not enough Epic items to upgrade " + name + " (Epic 1)");
                return false;
            } else {
                items.remove(i);
                System.out.println(i);
                matchingItems.add(epicItem);
            }
        } else if (rarity.equals("Epic 2")) {
            requiredCount = 3; // Epic 2 → Legendary requires 3 same Epic 2 items
        }

        if (matchingItems.size() < requiredCount) {
            System.out.println("Not enough items to upgrade " + name + " (" + rarity + ")");
            return false;
        }

        // Remove used items
        for (int i = 0; i < requiredCount; i++) {
            removeItem(matchingItems.get(i));
        }

        // Add the upgraded item
        addItem(new Item(name, newRarity));
        System.out.println("Upgraded " + name + " (" + rarity + ") to " + newRarity);
        return true;
    }




}
