package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrKnowledgeBookItem;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class TrKnowledgeBookLoader extends TrBaseLoader {


    public TrKnowledgeBookItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        List<NamespacedKey> recipes = getRecipes(itemSection);
        return new TrKnowledgeBookItem(baseItem, recipes);
    }

    public List<NamespacedKey> getRecipes(Section itemSection) {
        List<String> recipesStr = itemSection.getStringList("Recipes");
        List<NamespacedKey> recipes = new ArrayList<>();
        for (String recipeStr : recipesStr) {
            NamespacedKey key = ItemManager.getInstance().parseNamespacedKey(recipeStr);
            recipes.add(key);
        }
        return recipes;
    }

}
