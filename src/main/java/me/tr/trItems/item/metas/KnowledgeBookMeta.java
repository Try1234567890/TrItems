package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.KnowledgeBookItem;
import org.bukkit.entity.Player;

public class KnowledgeBookMeta extends BaseMeta {

    public void setMeta(KnowledgeBookItem item, Player player) {
        super.setMeta(item, player);
        setRecipes(item);
    }

    public void setRecipes(KnowledgeBookItem item) {
        org.bukkit.inventory.meta.KnowledgeBookMeta knowledgeBookMeta = item.getItemMeta();
        if (knowledgeBookMeta == null) return;
        knowledgeBookMeta.setRecipes(item.getRecipes());
        item.getStack().setItemMeta(knowledgeBookMeta);
    }


}
