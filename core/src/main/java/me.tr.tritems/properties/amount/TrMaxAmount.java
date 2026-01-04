package me.tr.tritems.properties.amount;

import me.tr.serializer.annotations.Initialize;

public class TrMaxAmount {
    private int maxAmount;
    private int minAmount;
    private boolean ender;
    private boolean shulker;


    public TrMaxAmount(int maxAmount, int minAmount, boolean ender, boolean shulker) {
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.ender = ender;
        this.shulker = shulker;
    }

    @Initialize
    public TrMaxAmount(int maxAmount, int minAmount) {
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.ender = false;
        this.shulker = true;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public boolean isIncludeEnderChest() {
        return ender;
    }

    public void setIncludeEnderChest(boolean ender) {
        this.ender = ender;
    }

    public boolean isIncludeShulkerBoxes() {
        return shulker;
    }

    public void setIncludeShulkerBoxes(boolean shulker) {
        this.shulker = shulker;
    }

    @Override
    public String toString() {
        return "TrMaxAmount{Max=" + maxAmount + ", MinAmount=" + minAmount + ", Ender=" + ender + ", Shulker=" + shulker + '}';
    }
}
