package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;

public class TrNameTag extends TrItemTag {

    public TrNameTag() {
        super(new UID("item_name"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        return item.getName();
    }
}
