package me.tr.tritems.properties.custommodeldata;

import me.tr.serializer.annotations.AsNumber;
import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.inventory.meta.ItemMeta;

@AsNumber
public class TrIntegerCustomModelData implements TrCustomModelData {
    private int value;

    @Initialize
    public TrIntegerCustomModelData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setTo(ItemMeta meta) {
        if (TrValidator.isNull(meta, "The meta is null"))
            return;

        meta.setCustomModelData(value);
    }

    @Override
    public String toString() {
        return "TrIntegerCustomModelData{Value=" + value + '}';
    }
}
