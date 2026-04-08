package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;

import java.util.Optional;

public class TrLoreTag extends TrItemTag {

    public TrLoreTag() {
        super(new UID("item_lore"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        Optional<String> split = getSplit(params);

        return split.map(s -> String.join(s, item.getLore())).orElseGet(() -> String.valueOf(item.getLore()));

    }

    private Optional<String> getSplit(ParamsContainer params) {
        return params.getAs("split", String.class);
    }
}
