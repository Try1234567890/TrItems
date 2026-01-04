package me.tr.tritems.properties.custommodeldata;

import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface TrCustomModelData {

    static TrIntegerCustomModelData integer(Integer value) {
        return new TrIntegerCustomModelData(value);
    }

    static TrComponentCustomModelData component(List<Float> floats, List<Boolean> booleans, List<String> strings, List<TrColor> colors) {
        return new TrComponentCustomModelData(floats, booleans, strings, colors);
    }

    void setTo(ItemMeta meta);

    default void setTo(ItemStack item) {
        if (TrValidator.isNull(item, "The item is null"))
            return;

        if (TrValidator.checkIf(!item.hasItemMeta(), "The item " + item.getType() + " has no meta"))
            return;

        setTo(item.getItemMeta());
    }
}
