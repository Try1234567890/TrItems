package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrKnowledgeBookItem;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.KnowledgeBookMeta;

import java.util.List;

public class TrKnowledgeBookMeta extends TrBaseMeta {

    private TrKnowledgeBookMeta() {
    }

    public TrKnowledgeBookMeta(TrKnowledgeBookItem item) {
        super(item);
    }


    @Override
    public TrKnowledgeBookItem getItem() {
        return (TrKnowledgeBookItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setRecipes();
    }

    public void setRecipes() {
        KnowledgeBookMeta knowledgeBookMeta = getItem().getItemMeta();
        if (knowledgeBookMeta == null) return;
        knowledgeBookMeta.setRecipes(getItem().getRecipes());
        getItem().getStack().setItemMeta(knowledgeBookMeta);
    }

    public void editRecipes(List<NamespacedKey> recipes) {
        getItem().setRecipes(recipes);
        setRecipes();
    }

}
