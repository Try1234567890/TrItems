package me.tr.tritems.formatter;

import me.tr.trformatter.palceholders.functions.Function;
import me.tr.trformatter.palceholders.params.Params;
import me.tr.trformatter.palceholders.placeholders.Placeholder;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.identification.TrReusableIdentifier;

public class TrItemLore extends Placeholder {

    public TrItemLore() {
        super(new UID("ItemLore"));
    }

    public TrItemLore(Params params, Function[] functions, int start, int end) {
        super(new UID("ItemLore"), params, functions, start, end, 1);
    }

    @Override
    public String process(String s) {
        TrIdentifier ID = TrReusableIdentifier.of(getParams().asString(0));

        TrItem item = TrItem.get(ID);

        if (item == null)
            return "";

        return item.getLore().stream().map(l -> l + "\n").reduce("", String::concat).trim();
    }

    @Override
    public Placeholder newInstance(Params params, Function[] functions, int i, int i1) {
        return new TrItemLore(params, functions, i, i1);
    }

}
