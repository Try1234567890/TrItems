package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;

public class TrDamageTag extends TrItemTag {

    public TrDamageTag() {
        super(new UID("item_damage"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        return String.valueOf(item.getDamage());
    }
}
