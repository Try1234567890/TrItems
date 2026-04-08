package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.permissions.TrPermission;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrPermissionsTag extends TrItemTag {

    public TrPermissionsTag() {
        super(new UID("item_permissions"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        Optional<String> split = getSplit(params);
        String format = getFormat(params);

        List<String> permissions = getPermissions(item, format);

        return split.map(s -> String.join(s, permissions)).orElseGet(permissions::toString);
    }

    private List<String> getPermissions(TrItem item, String format) {
        List<String> permissions = new ArrayList<>();

        for (TrPermission permission : item.getPermissions()) {

            String name = permission.getPermission();
            String other = permission.getOther();
            List<String> aliases = permission.getAliases();

            String permissionEntry = format.replace("$[PERMISSION]", name)
                    .replace("$[OTHER]", other)
                    .replace("$[ALIASES]", aliases.toString());

            permissions.add(permissionEntry);
        }

        return permissions;
    }

    private String getFormat(ParamsContainer params) {
        String format = params.getAsOrNull("format", String.class);
        if (format == null || format.isEmpty()) {
            return "Permission: $[PERMISSION], Other: $[OTHER], Aliases: $[ALIASES]";
        }
        return format;
    }

    private Optional<String> getSplit(ParamsContainer params) {
        return params.getAs("split", String.class);
    }

}
