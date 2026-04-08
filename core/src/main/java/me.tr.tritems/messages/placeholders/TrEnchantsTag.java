package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.enchants.TrEnchant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrEnchantsTag extends TrItemTag {

    public TrEnchantsTag() {
        super(new UID("item_enchants", "item_enchantments"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        Optional<String> split = getSplit(params);
        String format = getFormat(params);

        List<String> enchants = getEnchants(item, format);

        return split.map(s -> String.join(s, enchants)).orElseGet(enchants::toString);
    }

    private List<String> getEnchants(TrItem item, String format) {
        List<String> enchants = new ArrayList<>();

        for (TrEnchant enchant : item.getEnchants()) {

            String name = enchant.enchant().identifier().toString();
            int level = enchant.level();

            String enchantEntry = format.replace("$[NAME]", name).replace("$[LEVEL]", String.valueOf(level));
            enchants.add(enchantEntry);
        }

        return enchants;
    }

    private String getFormat(ParamsContainer params) {
        String format = params.getAsOrNull("format", String.class);
        if (format == null || format.isEmpty()) {
            return "$[NAME]: $[LEVEL]";
        }
        return format;
    }

    private Optional<String> getSplit(ParamsContainer params) {
        return params.getAs("split", String.class);
    }

}
