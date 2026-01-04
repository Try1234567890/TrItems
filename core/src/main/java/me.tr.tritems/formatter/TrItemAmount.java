package me.tr.tritems.formatter;

import me.tr.trformatter.palceholders.functions.Function;
import me.tr.trformatter.palceholders.params.Params;
import me.tr.trformatter.palceholders.placeholders.Placeholder;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.identification.TrReusableIdentifier;

public class TrItemAmount extends Placeholder {

    public TrItemAmount() {
        super(new UID("ItemAmount"));
    }

    public TrItemAmount(Params params, Function[] functions, int start, int end) {
        super(new UID("ItemAmount"), params, functions, start, end, 1);
    }

    @Override
    public String process(String s) {
        TrIdentifier ID = TrReusableIdentifier.of(getParams().asString(0));

        TrItem item = TrItem.get(ID);

        if (item == null)
            return "-1";

        return String.valueOf(item.getAmount());
    }

    @Override
    public Placeholder newInstance(Params params, Function[] functions, int i, int i1) {
        return new TrItemAmount(params, functions, i, i1);
    }

}
