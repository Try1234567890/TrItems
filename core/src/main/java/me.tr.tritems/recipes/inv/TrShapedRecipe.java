package me.tr.tritems.recipes.inv;

import me.tr.serializer.annotations.Ignore;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrRecipeItem;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrShapedRecipe implements TrInvRecipe {
    private final TrRecipeItem[] ingredients;
    private final String[] shape;
    private int[] grid;

    private @Ignore Map<Integer, TrItem> mappedIngredients;

    public TrShapedRecipe(TrRecipeItem[] ingredients, String[] shape) {
        this.ingredients = ingredients;
        this.shape = shape;
    }

    public TrShapedRecipe(TrRecipeItem[] ingredients, String[] shape, int[] grid) {
        this.ingredients = ingredients;
        this.shape = shape;
        this.grid = grid;
    }

    @Override
    public TrRecipeItem[] getIngredients() {
        return ingredients;
    }

    public String[] getShape() {
        return shape;
    }

    @Override
    public int[] getGrid() {
        if (grid == null
                || grid.length == 0) {
            createGrid();
        }
        return grid;
    }

    private Map<Integer, TrItem> getMappedIngredients() {
        if (mappedIngredients == null
                || mappedIngredients.isEmpty()) {
            mapIngredients();
        }
        return mappedIngredients;
    }

    @Override
    public boolean eval(Inventory inv) {
        for (int slot : getGrid()) {

            TrItem expect = getMappedIngredients().get(slot);
            ItemStack stack = inv.getContents()[slot];

            if (expect == null
                    && isNull(stack))
                continue;

            if (isNull(stack))
                return false;

            TrItem found = TrItem.fromOrBuild(stack);

            if (!found.equals(expect))
                return false;

        }

        return true;
    }

    private void createGrid() {
        int[] grid = new int[getShape().length];
        for (int i = 0; i < getShape().length; i++) {
            char[] row = getShape()[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                int slot = i * row.length + j;
                grid[slot] = slot;
            }
        }
        this.grid = grid;
    }

    private void mapIngredients() {
        Map<Integer, TrItem> mappedIngredients = new HashMap<>();
        for (int i = 0; i < getShape().length; i++) {
            char[] row = getShape()[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                char letter = row[j];
                int slot = i * row.length + j;
                mappedIngredients.put(getGrid()[slot], getItem(letter));
            }
        }

        this.mappedIngredients = mappedIngredients;
    }

    private TrRecipeItem getItem(char letter) {
        return Arrays.stream(getIngredients())
                .filter(item -> item.getLetter() == letter)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "TrShapedRecipe{" +
                "Ingredients=" + Arrays.toString(ingredients) +
                ", Shape=" + Arrays.toString(shape) +
                ", Grid=" + Arrays.toString(grid) +
                '}';
    }
}




















