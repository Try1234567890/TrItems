package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.KnowledgeBookItem;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBookLoader extends BaseLoader {


    public KnowledgeBookItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        List<NamespacedKey> recipes = getRecipes(itemSection);
        return new KnowledgeBookItem(baseItem, recipes);
    }

    public List<NamespacedKey> getRecipes(Section itemSection) {
        List<String> recipesStr = itemSection.getStringList("Recipes");
        List<NamespacedKey> recipes = new ArrayList<>();
        for (String recipeStr : recipesStr) {
            NamespacedKey key = main.getItemManager().getNamespacedKey(recipeStr);
            recipes.add(key);
        }
        return recipes;
    }

}
