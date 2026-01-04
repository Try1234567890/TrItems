package me.tr.tritems.recipes.inv;

import me.tr.tritems.items.TrItem;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class TrShapelessRecipe implements TrInvRecipe {
    private final TrItem[] ingredients;
    private int[] grid;

    public TrShapelessRecipe(TrItem[] ingredients) {
        this.ingredients = ingredients;
    }

    public TrShapelessRecipe(TrItem[] ingredients, int[] grid) {
        this.ingredients = ingredients;
        this.grid = grid;
    }

    @Override
    public TrItem[] getIngredients() {
        return ingredients;
    }

    private List<TrItem> getIngredientsAsList() {
        return Arrays.asList(ingredients);
    }

    @Override
    public int[] getGrid() {
        if (grid == null || grid.length == 0) {
            grid = new int[]{
                    0, 1, 2, 3, 4, 5, 6, 7, 8
            };
        }
        return grid;
    }

    @Override
    public boolean eval(Inventory inv) {
        List<TrItem> ingredients = getIngredientsAsList();
        TrItem[] itemsInGrid = getItemsInGrid(inv);

        for (TrItem actual : itemsInGrid) {
            if (!ingredients.contains(actual))
                return false;
        }

        return true;
    }

    private TrItem[] getItemsInGrid(Inventory inv) {
        TrItem[] items = new TrItem[getGrid().length];
        for (int i = 0; i < getGrid().length; i++) {
            int slot = getGrid()[i];

            ItemStack stack = inv.getItem(slot);

            items[i] = stack == null ? null : TrItem.fromOrBuild(stack);
        }

        return items;
    }

    @Override
    public String toString() {
        return "TrShapelessRecipe{" +
                "Ingredients=" + Arrays.toString(ingredients) +
                ", Grid=" + Arrays.toString(grid) +
                '}';
    }
}




















