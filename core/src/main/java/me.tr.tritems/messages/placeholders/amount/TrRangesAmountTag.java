package me.tr.tritems.messages.placeholders.amount;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.messages.placeholders.TrItemTag;
import me.tr.tritems.properties.amount.TrRangeAmount;

public abstract class TrRangesAmountTag extends TrItemTag {

    public TrRangesAmountTag(UID uid) {
        super(uid);
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        String format = getFormat(params);

        TrRangeAmount amount = getAmount(item);

        String max = String.valueOf(amount.getMaxAmount());
        String min = String.valueOf(amount.getMinAmount());
        String ender = String.valueOf(amount.isIncludeEnderChest());
        String shulker = String.valueOf(amount.isIncludeShulkerBoxes());

        return format
                .replace("$[MAX]", max)
                .replace("$[MIN]", min)
                .replace("$[ENDER]", ender)
                .replace("$[SHULKER]", shulker);
    }

    private String getFormat(ParamsContainer params) {
        String format = params.getAsOrNull("format", String.class);
        if (format == null || format.isEmpty()) {
            return "$[MAX]<->$[MIN] (Include[Ender: $[ENDER] | Shulker: $[SHULKER]])";
        }
        return format;
    }

    protected abstract TrRangeAmount getAmount(TrItem item);
}