package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.components.Tag;
import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;

public abstract class TrItemTag extends Tag {
    public TrItemTag(UID uid) {
        super(uid);
    }


    @Override
    public String evaluate(ParamsContainer paramsContainer) {
        String id = paramsContainer.getAsOrNull("item", String.class);

        if (id == null || id.isEmpty())
            return "[ID_NOT_SPECIFIED]";

        TrItem item = TrItem.get(id);

        if (item == null)
            return "[ITEM_\"" + id + "\"_NOT_FOUND]";

        return getPlaceholder(item, paramsContainer);
    }

    protected abstract String getPlaceholder(TrItem item, ParamsContainer params);

    //List<TrRecipe> recipes;
}
