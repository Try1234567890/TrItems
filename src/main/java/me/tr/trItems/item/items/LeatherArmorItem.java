package me.tr.trItems.item.items;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Represents a custom leather armor item that extends the functionality of an armor item.
 * This class allows setting and retrieving the color of the leather armor.
 */
public class LeatherArmorItem extends ArmorItem {
    private Color color;

    /**
     * Constructs a new LeatherArmorItem with the specified armor item properties and color.
     *
     * @param item  The armor item to extend.
     * @param color The color of the leather armor.
     */
    public LeatherArmorItem(ArmorItem item, Color color) {
        super(item.getBaseItem(), item.getArmorTrim());
        this.color = color;
    }

    /**
     * Gets the color of the leather armor.
     *
     * @return The color of the armor.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the leather armor.
     *
     * @param color The new color of the armor.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public LeatherArmorMeta getArmorMeta() {
        return (LeatherArmorMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.LeatherArmorMeta meta = new me.tr.trItems.item.metas.LeatherArmorMeta();
        meta.setMeta(this, player);
    }
}
