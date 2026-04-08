package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.owner.TrOwner;
import org.bukkit.OfflinePlayer;

import javax.print.attribute.standard.MediaSize;
import java.util.Optional;
import java.util.function.Function;

public class TrOwnerTag extends TrItemTag {

    public TrOwnerTag() {
        super(new UID("item_owner"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        TrOwner owner = item.getOwner();

        if (owner == null)
            return "";

        return getComponentToShow(params).get(owner);
    }

    private ComponentToShow getComponentToShow(ParamsContainer params) {
        Optional<String> comToShowName = params.getAs("component", String.class);

        return comToShowName.map(ComponentToShow::parse).orElse(ComponentToShow.NAME);
    }

    private enum ComponentToShow {

        UUID((owner) -> owner.getUUID().toString()),
        NAME((owner) -> {
            OfflinePlayer player = owner.getOfflinePlayer();
            if (player == null)
                return "[PLAYER_\"" + owner.getUUID() + "\"_IS_NULL]";
            return player.getName();
        });

        private final Function<TrOwner, String> getter;

        ComponentToShow(Function<TrOwner, String> getter) {
            this.getter = getter;
        }

        public String get(TrOwner owner) {
            return getter.apply(owner);
        }

        public static ComponentToShow parse(String str) {
            try {
                return ComponentToShow.valueOf(str.toUpperCase());
            } catch (Exception ignored) {
                return NAME;
            }
        }
    }
}
