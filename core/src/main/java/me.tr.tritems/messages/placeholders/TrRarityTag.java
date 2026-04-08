package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;

public class TrRarityTag extends TrItemTag {

    public TrRarityTag() {
        super(new UID("item_rarity"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        return String.valueOf(item.getRarity());
    }
}
