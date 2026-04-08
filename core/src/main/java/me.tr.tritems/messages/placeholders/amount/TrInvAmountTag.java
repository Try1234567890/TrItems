package me.tr.tritems.messages.placeholders.amount;

import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.amount.TrRangeAmount;

public class TrInvAmountTag extends TrRangesAmountTag {

    public TrInvAmountTag() {
        super(new UID("item_inv_amount", "item_inv_quantity", "item_inventory_amount", "item_inventory_quantity"));
    }

    @Override
    protected TrRangeAmount getAmount(TrItem item) {
        return item.getInventoryAmount();
    }
}
