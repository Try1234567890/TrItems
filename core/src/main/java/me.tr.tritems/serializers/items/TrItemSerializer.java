package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrItemSerializer {

    private TrItemSerializer() {}

    public static Map<String, Object> serialize(TrItem item) throws SerializationException {
        Map<String, Object> map = new HashMap<>();

        if (item.identifier() == null) throw new SerializationException("identifier is null");
        map.put("identifier", TrIdentifierSerializer.serialize(item.identifier()));
        map.put("material", item.getMaterial().name());

        if (item.getName() != null)
            map.put("name", item.getName());

        if (item.getLore() != null && !item.getLore().isEmpty())
            map.put("lore", item.getLore());

        map.put("amount", item.getAmount());

        if (item.getDamage() != 0)
            map.put("damage", item.getDamage());

        if (item.getSlot() != -1)
            map.put("slot", item.getSlot());

        if (item.getCustomModelData() != null) {
            if (item.getCustomModelData() instanceof me.tr.tritems.properties.custommodeldata.TrIntegerCustomModelData i)
                map.put("customModelData", TrIntegerCustomModelDataSerializer.serialize(i));
            else if (item.getCustomModelData() instanceof me.tr.tritems.properties.custommodeldata.TrComponentCustomModelData c)
                map.put("customModelData", TrComponentCustomModelDataSerializer.serialize(c));
        }

        if (item.getEnchants() != null && !item.getEnchants().isEmpty())
            map.put("enchants", item.getEnchants().stream().map(e -> {
                try { return TrEnchantSerializer.serialize(e); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());

        if (item.getFlags() != null && !item.getFlags().isEmpty())
            map.put("flags", item.getFlags().stream().map(f -> {
                try { return TrFlagSerializer.serialize(f); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());

        if (item.getAttributes() != null && !item.getAttributes().isEmpty())
            map.put("attributes", item.getAttributes().stream().map(a -> {
                try { return TrAttributeSerializer.serialize(a); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());

        if (item.getPermissions() != null && !item.getPermissions().isEmpty())
            map.put("permissions", item.getPermissions().stream().map(p -> {
                try { return TrPermissionSerializer.serialize(p); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());

        if (item.getNBTs() != null && !item.getNBTs().isEmpty())
            map.put("nbts", item.getNBTs().stream().map(n -> {
                try { return TrMemoryNBTSerializer.serialize(n); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());

        if (item.getRarity() != null)
            map.put("rarity", TrItemRaritySerializer.serialize(item.getRarity()));

        if (item.getOwner() != null)
            map.put("owner", TrOwnerSerializer.serialize(item.getOwner()));

        if (item.getGameplayAmount() != null)
            map.put("gameplayAmount", TrRangeAmountSerializer.serialize(item.getGameplayAmount()));

        if (item.getStackAmount() != null)
            map.put("stackAmount", TrRangeAmountSerializer.serialize(item.getStackAmount()));

        if (item.getInventoryAmount() != null)
            map.put("inventoryAmount", TrRangeAmountSerializer.serialize(item.getInventoryAmount()));

        return map;
    }
}
