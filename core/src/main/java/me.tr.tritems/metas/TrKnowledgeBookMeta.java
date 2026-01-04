package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrKnowledgeBookItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.KnowledgeBookMeta;

import java.util.ArrayList;
import java.util.List;

public class TrKnowledgeBookMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrKnowledgeBookMeta.class.getSimpleName());
        }

        @Override
        public TrKnowledgeBookMeta newInstance(TrItem item) {
            return new TrKnowledgeBookMeta((TrKnowledgeBookItem) item);
        }
    };

    public TrKnowledgeBookMeta(TrKnowledgeBookItem item) {
        super(item);
    }

    @Override
    public TrKnowledgeBookItem getItem() {
        return (TrKnowledgeBookItem) super.getItem();
    }

    public TrKnowledgeBookMeta setBookRecipes(List<NamespacedKey> recipes) {
        getItem().setBookRecipes(recipes);
        return this;
    }

    public TrKnowledgeBookMeta addBookRecipes(List<NamespacedKey> recipes) {
        getItem().addBookRecipes(recipes);
        return this;
    }

    public TrKnowledgeBookMeta addBookRecipes(NamespacedKey... recipes) {
        getItem().addBookRecipes(recipes);
        return this;
    }

    @Override
    public TrKnowledgeBookItem apply() {
        KnowledgeBookMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setRecipes(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setRecipes(KnowledgeBookMeta meta) {
        List<NamespacedKey> recipes = meta.getRecipes();
        List<NamespacedKey> newRecipes = getItem().getBookRecipes();


        if (newRecipes == null) {
            meta.setRecipes(new ArrayList<>());
            return;
        }

        if (newRecipes.equals(recipes))
            return;

        meta.setRecipes(newRecipes);
    }
}
