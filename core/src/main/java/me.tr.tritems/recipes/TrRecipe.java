package me.tr.tritems.recipes;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.recipes.inv.TrShapedRecipe;
import me.tr.tritems.recipes.inv.TrShapelessRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface TrRecipe {

    TrItem[] getIngredients();

    boolean eval(Inventory inv);

    default boolean isNull(ItemStack stack) {
        return stack == null || stack.getType() == Material.AIR;
    }

    static Class<? extends TrRecipe> getRecipeClass(Map<?, ?> map) {
        String type = (String) map.get("type");

        if (type == null)
            type = (String) map.get("Type");
        
        if (type != null) {
            return switch (type.toLowerCase()) {
                case "shaped" -> TrShapedRecipe.class;
                case "shapeless" -> TrShapelessRecipe.class;
                case "trade" -> TrTradeRecipe.class;
                default -> throw new IllegalStateException("Unexpected value: " + type.toLowerCase());
            };
        }

        if (map.containsKey("shape") || map.containsKey("Shape"))
            return TrShapedRecipe.class;
        else return TrShapelessRecipe.class;
    }

}
