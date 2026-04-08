package me.tr.tritems.messages.placeholders.amount;

import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.amount.TrRangeAmount;

public class TrGameplayAmountTag extends TrRangesAmountTag {

    public TrGameplayAmountTag() {
        super(new UID("item_game_amount", "item_game_quantity", "item_gameplay_amount", "item_gameplay_quantity"));
    }

    @Override
    protected TrRangeAmount getAmount(TrItem item) {
        return item.getGameplayAmount();
    }
}
