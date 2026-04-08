package me.tr.tritems.messages.placeholders.amount;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.messages.placeholders.TrItemTag;

public class TrAmountTag extends TrItemTag {

    public TrAmountTag() {
        super(new UID("item_amount", "item_quantity"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        return String.valueOf(item.getAmount());
    }
}
