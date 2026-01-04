package me.tr.tritems.metas;

import com.google.common.collect.Multimap;
import me.tr.tritems.TrItems;
import me.tr.tritems.formatter.TrItemFormatter;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.TrAttribute;
import me.tr.tritems.properties.amount.TrMaxAmount;
import me.tr.tritems.properties.custommodeldata.TrComponentCustomModelData;
import me.tr.tritems.properties.custommodeldata.TrCustomModelData;
import me.tr.tritems.properties.custommodeldata.TrIntegerCustomModelData;
import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.nbts.TrMemoryNBT;
import me.tr.tritems.properties.owner.TrOwner;
import me.tr.tritems.properties.permissions.TrPermission;
import me.tr.tritems.properties.rarity.TrItemRarity;
import me.tr.tritems.recipes.TrRecipe;
import me.tr.tritems.utility.CanBeEmpty;
import me.tr.tritems.utility.TrValidator;
import net.kyori.adventure.text.Component;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrItemMeta.class.getSimpleName());
        }

        @Override
        public TrItemMeta newInstance(TrItem item) {
            return new TrItemMeta(item);
        }
    };
    private TrItem item;

    public TrItemMeta(TrItem item) {
        if (TrValidator.isNull(item, "The provided item to " + getClass().getSimpleName() + " cannot be null."))
            return;
        this.item = item;
    }

    public TrItem getItem() {
        return item;
    }

    public TrItemMeta setName(String name) {
        getItem().setName(name);
        return this;
    }

    public TrItemMeta setLore(@CanBeEmpty List<String> lore) {
        getItem().setLore(lore);
        return this;
    }

    public TrItemMeta addLore(@CanBeEmpty List<String> lore) {
        getItem().addLore(lore);
        return this;
    }

    public TrItemMeta addLore(@CanBeEmpty String... lore) {
        getItem().addLore(List.of(lore));
        return this;
    }

    public TrItemMeta addLore(String lore) {
        getItem().addLore(lore);
        return this;
    }

    public TrItemMeta addLore(int i, String lore) {
        getItem().addLore(i, lore);
        return this;
    }

    public TrItemMeta setEnchants(@CanBeEmpty List<TrEnchant> enchants) {
        getItem().setEnchants(enchants);
        return this;
    }

    public TrItemMeta addEnchants(@CanBeEmpty List<TrEnchant> enchants) {
        getItem().addEnchants(enchants);
        return this;
    }

    public TrItemMeta addEnchants(@CanBeEmpty TrEnchant... enchants) {
        getItem().addEnchants(List.of(enchants));
        return this;
    }

    public TrItemMeta addEnchant(TrEnchant enchants) {
        getItem().addEnchants(enchants);
        return this;
    }

    public TrItemMeta setCustomModelData(int customModelData) {
        getItem().setCustomModelData(new TrIntegerCustomModelData(customModelData));
        return this;
    }

    public TrItemMeta setCustomModelData(TrCustomModelData customModelData) {
        getItem().setCustomModelData(customModelData);
        return this;
    }

    public TrItemMeta setCustomModelData(TrComponentCustomModelData customModelData) {
        getItem().setCustomModelData(customModelData);
        return this;
    }

    public TrItemMeta setAmount(int amount) {
        getItem().setAmount(amount);
        return this;
    }

    public TrItemMeta setGameplayAmount(TrMaxAmount amount) {
        getItem().setGameplayAmount(amount);
        return this;
    }

    public TrItemMeta setStackAmount(TrMaxAmount amount) {
        getItem().setStackAmount(amount);
        return this;
    }

    public TrItemMeta setInventoryAmount(TrMaxAmount amount) {
        getItem().setInventoryAmount(amount);
        return this;
    }

    public TrItemMeta setNBTs(@CanBeEmpty List<TrMemoryNBT<?>> nbts) {
        getItem().setNBTs(nbts);
        return this;
    }

    public TrItemMeta addNBTs(@CanBeEmpty List<TrMemoryNBT<?>> nbts) {
        getItem().addNBTs(nbts);
        return this;
    }

    public TrItemMeta addNBTs(@CanBeEmpty TrMemoryNBT<?>... nbts) {
        getItem().addNBTs(List.of(nbts));
        return this;
    }

    public TrItemMeta addNBT(TrMemoryNBT<?> nbt) {
        getItem().addNBT(nbt);
        return this;
    }


    public TrItemMeta setPermissions(@CanBeEmpty List<TrPermission> permissions) {
        getItem().setPermissions(permissions);
        return this;
    }

    public TrItemMeta addPermissions(@CanBeEmpty List<TrPermission> permissions) {
        getItem().addPermissions(permissions);
        return this;
    }

    public TrItemMeta addPermissions(@CanBeEmpty TrPermission... permissions) {
        getItem().addPermissions(List.of(permissions));
        return this;
    }

    public TrItemMeta addPermission(TrPermission permission) {
        getItem().addPermission(permission);
        return this;
    }

    public TrItemMeta setFlags(@CanBeEmpty List<TrFlag> flags) {
        getItem().addFlags(flags);
        return this;
    }

    public TrItemMeta addFlags(@CanBeEmpty List<TrFlag> flags) {
        getItem().addFlags(flags);
        return this;
    }

    public TrItemMeta addFlags(@CanBeEmpty TrFlag... flags) {
        getItem().addFlags(List.of(flags));
        return this;
    }

    public TrItemMeta addFlag(TrFlag flag) {
        getItem().addFlag(flag);
        return this;
    }

    public TrItemMeta setRarity(TrItemRarity rarity) {
        getItem().setRarity(rarity);
        return this;
    }

    public TrItemMeta setOwner(TrOwner owner) {
        getItem().setOwner(owner);
        return this;
    }

    public TrItemMeta setOwner(UUID owner) {
        getItem().setOwner(new TrOwner(owner));
        return this;
    }

    public TrItemMeta setOwner(Player owner) {
        getItem().setOwner(new TrOwner(owner));
        return this;
    }

    public TrItemMeta setOwner(OfflinePlayer owner) {
        getItem().setOwner(new TrOwner(owner));
        return this;
    }

    public TrItemMeta setDamage(Number damage) {
        getItem().setDamage(damage.intValue());
        return this;
    }

    public TrItemMeta setSlot(Number slot) {
        getItem().setSlot(slot.intValue());
        return this;
    }

    public TrItemMeta setAttributes(@CanBeEmpty List<TrAttribute> attributes) {
        getItem().addAttributes(attributes);
        return this;
    }

    public TrItemMeta addAttributes(@CanBeEmpty List<TrAttribute> attributes) {
        getItem().addAttributes(attributes);
        return this;
    }

    public TrItemMeta addAttributes(@CanBeEmpty TrAttribute... attributes) {
        getItem().addAttributes(List.of(attributes));
        return this;
    }

    public TrItemMeta addAttribute(TrAttribute attribute) {
        getItem().addAttribute(attribute);
        return this;
    }

    public TrItemMeta setRecipes(List<TrRecipe> recipes) {
        getItem().setRecipes(recipes);
        return this;
    }

    public TrItemMeta addRecipes(@CanBeEmpty List<TrRecipe> recipes) {
        getItem().addRecipes(recipes);
        return this;
    }

    public TrItemMeta addRecipes(@CanBeEmpty TrRecipe... recipes) {
        getItem().addRecipes(recipes);
        return this;
    }

    public TrItemMeta addRecipe(TrRecipe recipe) {
        getItem().addRecipe(recipe);
        return this;
    }

    public TrItem apply() {
        return apply(getItem().getItemMeta());
    }

    protected TrItem apply(ItemMeta meta) {
        ItemStack stack = new ItemStack(getItem().getMaterial(), getAmount());

        if (meta != null) {

            setName(meta);
            setLore(meta);
            setEnchants(meta);
            setCustomModelData(meta);
            setNBTs(meta);
            setFlags(meta);
            setDamage(meta);
            setAttributes(meta);
            setRarity(meta);

        }

        stack.setItemMeta(meta);
        getItem().setStack(stack);
        return getItem();
    }

    private int getAmount() {
        return Math.min(Math.max(1, getItem().getAmount()), getItem().getStack().getMaxStackSize());
    }

    private void setName(ItemMeta meta) {
        String itemName = getItem().getName();

        if (itemName == null) {
            meta.customName(null);
            return;
        }

        Component name = meta.customName();
        Component newName = TrItemFormatter.format(itemName);

        if (newName.equals(name))
            return;

        meta.customName(newName);
    }

    private void setLore(ItemMeta meta) {
        List<String> itemLore = getItem().getLore();

        if (itemLore == null || itemLore.isEmpty()) {
            meta.lore(null);
            return;
        }

        List<Component> lore = meta.lore();
        List<Component> newLore = TrItemFormatter.format(itemLore);

        if (newLore.equals(lore))
            return;

        meta.lore(newLore);
    }

    private void setEnchants(ItemMeta meta) {
        meta.removeEnchantments();
        List<TrEnchant> itemEnchants = getItem().getEnchants();

        if (itemEnchants == null || itemEnchants.isEmpty()) {
            return;
        }

        for (TrEnchant enchant : itemEnchants) {
            if (enchant == null)
                continue;
            enchant.set(meta);
        }
    }

    @SuppressWarnings("UnstableApiUsage")
    private void setCustomModelData(ItemMeta meta) {
        meta.setCustomModelDataComponent(null);
        TrCustomModelData customModelData = getItem().getCustomModelData();

        if (customModelData == null) {
            // CustomModelData already removed.
            return;
        }

        customModelData.setTo(meta);

    }

    private void setNBTs(ItemMeta meta) {
        List<TrMemoryNBT<?>> nbts = getItem().getNBTs();

        if (nbts == null || nbts.isEmpty()) {
            // TODO: REMOVE NBTs
            return;
        }

        for (TrMemoryNBT<?> nbt : nbts) {
            if (nbt == null)
                continue;
            nbt.set(meta);
        }
    }

    private void setFlags(ItemMeta meta) {
        List<TrFlag> flags = getItem().getFlags();

        if (flags == null || flags.isEmpty()) {
            // TODO: REMOVE Flags
            return;
        }

        for (TrFlag flag : flags) {
            if (flag == null)
                continue;
            flag.set(meta);
        }
    }

    private void setDamage(ItemMeta meta) {
        if (meta instanceof Damageable damageable) {
            int damage = getItem().getDamage();
            if (damage <= 0 ||
                    (damageable.hasMaxDamage() && damageable.getMaxDamage() >= damage))
                return;

            damageable.setDamage(damage);
        }
    }

    private void setAttributes(ItemMeta meta) {
        List<TrAttribute> newAttributes = getItem().getAttributes();

        if (newAttributes == null || newAttributes.isEmpty()) {
            Multimap<Attribute, AttributeModifier> attributes = meta.getAttributeModifiers();
            if (attributes != null && !attributes.isEmpty()) {
                attributes.forEach((a, m) -> {
                    if (a != null) meta.removeAttributeModifier(a);
                });
            }
            return;
        }

        for (TrAttribute attribute : newAttributes) {
            if (attribute == null)
                continue;

            Attribute attr = attribute.getAttribute();

            Collection<AttributeModifier> modifiers = meta.getAttributeModifiers(attr);

            if ((modifiers != null && !modifiers.isEmpty()) &&
                    modifiers.contains(attribute.getAttributeModifier())) {
                return;
            }

            meta.addAttributeModifier(attribute.getAttribute(), attribute.getAttributeModifier());
        }
    }

    private void setRarity(ItemMeta meta) {
        TrItemRarity rarity = getItem().getRarity();

        if (rarity == null)
            return;

        Component newName = meta.customName();

        if (newName == null)
            return;

        meta.customName(TrItems.getMiniMessage().deserialize(rarity.getColor().toMiniMessage() + TrItems.getMiniMessage().serialize(newName)));
    }

}



















