package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrKnowledgeBookMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.KnowledgeBookMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrKnowledgeBookItem extends TrItem {
    private List<NamespacedKey> recipes = new ArrayList<>();

    @Initialize
    protected TrKnowledgeBookItem() {
        super(TrItemType.KNOWLEDGE_BOOK);
    }

    public TrKnowledgeBookItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrKnowledgeBookMeta getMeta() {
        return (TrKnowledgeBookMeta) super.getMeta();
    }

    @Override
    public @Nullable KnowledgeBookMeta getItemMeta() {
        return (KnowledgeBookMeta) super.getItemMeta();
    }

    public List<NamespacedKey> getBookRecipes() {
        return recipes;
    }

    public void setBookRecipes(List<NamespacedKey> recipes) {
        this.recipes = recipes;
    }

    public void addBookRecipes(List<NamespacedKey> recipes) {
        this.recipes.addAll(recipes);
    }

    public void addBookRecipes(NamespacedKey... recipes) {
        this.recipes.addAll(List.of(recipes));
    }
}
