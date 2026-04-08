package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.nbts.TrMemoryNBT;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrNBTsTag extends TrItemTag {

    public TrNBTsTag() {
        super(new UID("item_nbts"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        Optional<String> split = getSplit(params);
        String format = getFormat(params);

        List<String> nbts = getEnchants(item, format);

        return split.map(s -> String.join(s, nbts)).orElseGet(nbts::toString);
    }

    private List<String> getEnchants(TrItem item, String format) {
        List<String> nbts = new ArrayList<>();

        for (TrMemoryNBT<?> nbt : item.getNBTs()) {

            String compound = nbt.getCompound();
            Object value = nbt.getValue();
            PersistentDataType<?, ?> type = nbt.getType();


            String nbtEntry = format.replace("$[COMPOUND]", compound)
                    .replace("$[VALUE]", String.valueOf(value))
                    .replace("$[TYPE]", type.getClass().getSimpleName());
            nbts.add(nbtEntry);
        }

        return nbts;
    }

    private String getFormat(ParamsContainer params) {
        String format = params.getAsOrNull("format", String.class);
        if (format == null || format.isEmpty()) {
            return "$[COMPOUND]: $[VALUE] ($[TYPE])";
        }
        return format;
    }

    private Optional<String> getSplit(ParamsContainer params) {
        return params.getAs("split", String.class);
    }

}
