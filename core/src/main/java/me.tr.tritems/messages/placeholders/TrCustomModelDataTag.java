package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;

public class TrCustomModelDataTag extends TrItemTag {

    public TrCustomModelDataTag() {
        super(new UID("item_custom_model_data", "item_cmd"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        return String.valueOf(item.getCustomModelData());
    }
}
