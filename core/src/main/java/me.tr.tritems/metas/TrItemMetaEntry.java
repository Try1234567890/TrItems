package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifiable;

public interface TrItemMetaEntry extends TrIdentifiable {

    TrItemMeta newInstance(TrItem item);

}
