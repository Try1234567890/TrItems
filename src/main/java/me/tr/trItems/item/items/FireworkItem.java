package me.tr.trItems.item.items;

import org.bukkit.FireworkEffect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

/**
 * Represents a custom firework item that extends the functionality of a base item.
 * This class allows setting and retrieving the power and effect of the firework.
 */
public class FireworkItem extends BaseItem {
    private int power;
    private List<FireworkEffect> effect;

    /**
     * Constructs a new FireworkItem with the specified base item properties, power, and effect.
     *
     * @param item   The base item to extend.
     * @param power  The power level of the firework.
     * @param effect The visual effect of the firework.
     */
    public FireworkItem(BaseItem item, int power, List<FireworkEffect> effect) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.power = power;
        this.effect = effect;
    }

    /**
     * Gets the power level of the firework.
     *
     * @return The power level.
     */
    public int getPower() {
        return power;
    }

    /**
     * Sets the power level of the firework.
     *
     * @param power The new power level.
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Gets the visual effect of the firework.
     *
     * @return The firework effect.
     */
    public List<FireworkEffect> getEffect() {
        return effect;
    }

    /**
     * Sets the visual effect of the firework.
     *
     * @param effect The new firework effect.
     */
    public void setEffect(List<FireworkEffect> effect) {
        this.effect = effect;
    }

    public FireworkMeta getItemMeta() {
        return (FireworkMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.FireworkMeta meta = new me.tr.trItems.item.metas.FireworkMeta();
        meta.setMeta(this, player);
    }
}