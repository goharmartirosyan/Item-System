import java.util.Objects;

public class Item {
    private String name;
    private Rarity rarity;
    private int upgradeCount;
    public Item(String name, String rarityInput) {
        this.name = name;

        rarityInput = rarityInput.toUpperCase(); // Normalize input

        if (rarityInput.equals(Rarity.EPIC.name())) {
            // If input is "EPIC" (without number)
            this.rarity = Rarity.EPIC;
            this.upgradeCount = 0;
        } else if (rarityInput.startsWith("EPIC ")) {
            // If input is "EPIC 1" or "EPIC 2"
            char lastChar = rarityInput.charAt(rarityInput.length() - 1);
            if (lastChar == '1' || lastChar == '2') {
                this.rarity = Rarity.EPIC;
                this.upgradeCount = Character.getNumericValue(lastChar); // Convert '1' or '2' to int
            } else {
                throw new IllegalArgumentException("Invalid Epic level. Use 'Epic 1' or 'Epic 2'");
            }
        } else {
            // Validate other rarities
            try {
                this.rarity = Rarity.valueOf(rarityInput);
                this.upgradeCount = 0;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid rarity type: " + rarityInput);
            }
        }
    }
    @Override
    public String toString() {
        return name + " [" + rarity + (upgradeCount != 0? " " + upgradeCount : "") + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item other)) return false;
        return name.equals(other.name) && rarity == other.rarity && upgradeCount == other.upgradeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rarity, upgradeCount);
    }
    public Rarity rer(){
        return rarity;
    }

    public String getRarity() {
        if(upgradeCount == 0){
            return rarity.name();
        }
        return rarity.name() + " " + upgradeCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
