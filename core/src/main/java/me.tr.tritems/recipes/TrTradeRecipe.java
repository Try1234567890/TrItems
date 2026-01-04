package me.tr.tritems.recipes;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.items.TrItem;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.List;

public class TrTradeRecipe implements TrRecipe {
    private TrItem[] ingredients;

    @Initialize
    private TrTradeRecipe() {

    }

    public TrTradeRecipe(TrItem[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public TrItem[] getIngredients() {
        return ingredients;
    }

    @Override
    public boolean eval(Inventory inv) {
        List<TrItem> contents = Arrays.stream(inv.getContents())
                .filter(item -> !isNull(item))
                .map(TrItem::fromOrBuild)
                .toList();

        for (TrItem item : getIngredients()) {
            if (!contents.contains(item))
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "TrTradeRecipe{" +
                "Ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
