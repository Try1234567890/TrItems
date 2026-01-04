package me.tr.tritems.properties.custommodeldata;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.color.TrColorConverter;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class TrComponentCustomModelData implements TrCustomModelData {
    private List<Float> floats = new ArrayList<>();
    private List<Boolean> flags = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private List<TrColor> colors = new ArrayList<>();

    @Initialize
    private TrComponentCustomModelData() {

    }

    public TrComponentCustomModelData(List<Float> floats, List<Boolean> flags,
                                      List<String> strings, List<TrColor> colors) {
        this.floats = floats;
        this.flags = flags;
        this.strings = strings;
        this.colors = colors;
    }

    public TrComponentCustomModelData(CustomModelDataComponent component) {
        this.floats = component.getFloats();
        this.flags = component.getFlags();
        this.strings = component.getStrings();
        this.colors = component.getColors().stream().map(col -> new TrColor(TrColorConverter.toHex(col))).toList();

    }

    public static TrComponentCustomModelData of(List<Float> floats, List<Boolean> flags,
                                                List<String> strings, List<String> colors) {
        return new TrComponentCustomModelData(floats, flags, strings, colors.stream().map(TrColor::new).toList());
    }

    public List<Float> getFloats() {
        return floats;
    }

    public void setFloats(List<Float> floats) {
        this.floats = floats;
    }

    public List<Boolean> getFlags() {
        return flags;
    }

    public void setFlags(List<Boolean> flags) {
        this.flags = flags;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<TrColor> getColors() {
        return colors;
    }

    public void setColors(List<TrColor> colors) {
        this.colors = colors;
    }

    @Override
    public void setTo(ItemMeta meta) {
        if (TrValidator.isNull(meta, "The meta is null"))
            return;

        meta.getCustomModelDataComponent().setColors(getColors().stream().map(TrColor::toColor).toList());
        meta.getCustomModelDataComponent().setFlags(getFlags());
        meta.getCustomModelDataComponent().setFloats(getFloats());
        meta.getCustomModelDataComponent().setStrings(getStrings());
    }

    @Override
    public String toString() {
        return "TrComponentCustomModelData{" +
                "Floats=" + floats +
                ", Flags=" + flags +
                ", Strings=" + strings +
                ", Colors=" + colors +
                '}';
    }
}
