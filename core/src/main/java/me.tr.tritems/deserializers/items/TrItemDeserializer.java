package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.*;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.TrAttribute;
import me.tr.tritems.properties.custommodeldata.TrComponentCustomModelData;
import me.tr.tritems.properties.custommodeldata.TrIntegerCustomModelData;
import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.nbts.TrMemoryNBT;
import me.tr.tritems.properties.permissions.TrPermission;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class TrItemDeserializer {

    private TrItemDeserializer() {}

    public static void applyBase(TrItem item, Map<?, ?> map) throws DeserializationException {
        Object nameRaw = map.get("name");
        if (nameRaw == null) nameRaw = map.get("displayName");
        if (nameRaw instanceof String s) item.setName(s);

        Object loreRaw = map.get("lore");
        if (loreRaw == null) loreRaw = map.get("desc");
        if (loreRaw instanceof List<?> list)
            item.setLore(list.stream().filter(o -> o instanceof String).map(o -> (String) o).toList());

        Object amountRaw = map.get("amount");
        if (amountRaw == null) amountRaw = map.get("quantity");
        if (amountRaw instanceof Number n) item.setAmount(n.intValue());

        Object damageRaw = map.get("damage");
        if (damageRaw instanceof Number n) item.setDamage(n.intValue());

        Object slotRaw = map.get("slot");
        if (slotRaw instanceof Number n) item.setSlot(n.intValue());

        Object cmdRaw = map.get("customModelData");
        if (cmdRaw instanceof Number n)
            item.setCustomModelData(TrIntegerCustomModelDataDeserializer.deserialize(n));
        else if (cmdRaw instanceof Map<?, ?> cmdMap)
            item.setCustomModelData(TrComponentCustomModelDataDeserializer.deserialize(cmdMap));

        Object enchantsRaw = map.get("enchants");
        if (enchantsRaw == null) enchantsRaw = map.get("enchantments");
        if (enchantsRaw instanceof List<?> list)
            item.setEnchants(deserializeList(list, TrEnchantDeserializer::deserialize));

        Object flagsRaw = map.get("flags");
        if (flagsRaw == null) flagsRaw = map.get("flag");
        if (flagsRaw instanceof List<?> list)
            item.setFlags(deserializeList(list, TrFlagDeserializer::deserialize));

        Object attrsRaw = map.get("attributes");
        if (attrsRaw == null) attrsRaw = map.get("attribute");
        if (attrsRaw instanceof List<?> list)
            item.setAttributes(deserializeList(list, TrAttributeDeserializer::deserialize));

        Object permsRaw = map.get("permissions");
        if (permsRaw == null) permsRaw = map.get("permission");
        if (permsRaw instanceof List<?> list)
            item.setPermissions(deserializeList(list, TrPermissionDeserializer::deserialize));

        Object nbtsRaw = map.get("nbts");
        if (nbtsRaw == null) nbtsRaw = map.get("nbt");
        if (nbtsRaw instanceof List<?> list)
            item.setNBTs(deserializeList(list, TrMemoryNBTDeserializer::deserialize));

        Object rarityRaw = map.get("rarity");
        if (rarityRaw != null) item.setRarity(TrItemRarityDeserializer.deserialize(rarityRaw));

        Object ownerRaw = map.get("owner");
        if (ownerRaw == null) ownerRaw = map.get("UUID");
        if (ownerRaw == null) ownerRaw = map.get("uuid");
        if (ownerRaw != null) item.setOwner(TrOwnerDeserializer.deserialize(ownerRaw));

        Object gameplayRaw = map.get("gameplayAmount");
        if (gameplayRaw == null) gameplayRaw = map.get("gameplayQuantity");
        if (gameplayRaw != null) item.setGameplayAmount(TrRangeAmountDeserializer.deserialize(gameplayRaw));

        Object stackRaw = map.get("stackAmount");
        if (stackRaw == null) stackRaw = map.get("stackQuantity");
        if (stackRaw != null) item.setStackAmount(TrRangeAmountDeserializer.deserialize(stackRaw));

        Object invRaw = map.get("inventoryAmount");
        if (invRaw == null) invRaw = map.get("inventoryQuantity");
        if (invRaw != null) item.setInventoryAmount(TrRangeAmountDeserializer.deserialize(invRaw));
    }

    static Material material(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("material");
        if (raw == null) raw = map.get("type");
        if (raw == null) raw = map.get("mat");
        if (!(raw instanceof String str))
            throw new DeserializationException("missing or invalid 'material' field");
        try {
            return Material.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DeserializationException("unknown Material: " + str);
        }
    }

    static TrIdentifier identifier(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("identifier");
        if (raw == null) raw = map.get("ID");
        if (raw == null) raw = map.get("id");
        if (raw == null) throw new DeserializationException("missing 'identifier' field");
        return TrIdentifierDeserializer.deserialize(raw);
    }

    @FunctionalInterface
    interface Mapper<T> {
        T map(Object o) throws DeserializationException;
    }

    static <T> List<T> deserializeList(List<?> list, Mapper<T> mapper) throws DeserializationException {
        try {
            return list.stream().map(o -> {
                try { return mapper.map(o); }
                catch (DeserializationException e) { throw new RuntimeException(e); }
            }).toList();
        } catch (RuntimeException e) {
            if (e.getCause() instanceof DeserializationException de) throw de;
            throw e;
        }
    }
}
