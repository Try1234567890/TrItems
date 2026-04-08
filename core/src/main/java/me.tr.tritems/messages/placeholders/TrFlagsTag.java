package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.permissions.TrPermission;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrFlagsTag extends TrItemTag {

    public TrFlagsTag() {
        super(new UID("item_flags"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        Optional<String> split = getSplit(params);

        List<String> enchants = getFlags(item);

        return split.map(s -> String.join(s, enchants)).orElseGet(enchants::toString);
    }

    private List<String> getFlags(TrItem item) {
        List<String> permissions = new ArrayList<>();

        for (TrFlag flag : item.getFlags()) {
            permissions.add(flag.identifier().toString());
        }

        return permissions;
    }

    private Optional<String> getSplit(ParamsContainer params) {
        return params.getAs("split", String.class);
    }

}
