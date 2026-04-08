package me.tr.tritems.messages.placeholders.amount;

import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.amount.TrRangeAmount;

public class TrStackAmountTag extends TrRangesAmountTag {

    public TrStackAmountTag() {
        super(new UID("item_stack_amount", "item_stack_quantity"));
    }

    @Override
    protected TrRangeAmount getAmount(TrItem item) {
        return item.getStackAmount();
    }
}
