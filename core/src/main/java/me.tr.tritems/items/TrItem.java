package me.tr.tritems.items;

import com.google.common.collect.Multimap;
import me.tr.serializer.annotations.Essential;
import me.tr.serializer.annotations.Ignore;
import me.tr.serializer.annotations.Initialize;
import me.tr.serializer.processes.deserializer.Deserializer;
import me.tr.serializer.processes.serializer.Serializer;
import me.tr.serializer.utility.Utility;
import me.tr.trfiles.file.configuration.Section;
import me.tr.trfiles.file.configuration.memory.implementations.MemoryJsonConfiguration;
import me.tr.tritems.metas.TrItemMeta;
import me.tr.tritems.properties.ItemHasNoMeta;
import me.tr.tritems.properties.TrAttribute;
import me.tr.tritems.properties.amount.TrMaxAmount;
import me.tr.tritems.properties.custommodeldata.TrComponentCustomModelData;
import me.tr.tritems.properties.custommodeldata.TrCustomModelData;
import me.tr.tritems.properties.custommodeldata.TrIntegerCustomModelData;
import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.enchants.TrVanillaEnchant;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.identification.TrIdentifiable;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.identification.TrReusableIdentifier;
import me.tr.tritems.properties.nbts.TrMemoryNBT;
import me.tr.tritems.properties.owner.TrOwner;
import me.tr.tritems.properties.permissions.TrPermission;
import me.tr.tritems.properties.rarity.TrItemRarity;
import me.tr.tritems.recipes.TrRecipe;
import me.tr.tritems.recipes.inv.TrShapelessRecipe;
import me.tr.tritems.registries.TrItemRegistry;
import me.tr.tritems.utility.CanBeEmpty;
import me.tr.tritems.utility.TrValidator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TrItem implements TrIdentifiable {
    public static final TrMemoryNBT<Boolean> IS_TR_ITEM_NBT = new TrMemoryNBT<>("tr_items.is_tr_item", true);
    public static final String TR_ITEM_NBT_COMPOUND_ID = "tr_items.identifier";

    private static final Serializer serializer = new Serializer()
            .getOptions()
            .addAlias(null, "identifier", TrIdentifier.getKey())
            .addAlias(null, "id", TrIdentifier.getKey())
            .getSerializer();

    @SuppressWarnings("unchecked")
    private static final Deserializer deserializer = (Deserializer) new Deserializer()
            .getOptions()
            .addAlternatives(TrCustomModelData.class, (obj) -> obj instanceof Number ? TrIntegerCustomModelData.class : TrComponentCustomModelData.class)
            .addAlternatives(TrRecipe.class, (obj) -> {
                if (obj instanceof Map<?, ?> map) {
                    return TrRecipe.getRecipeClass(map);
                }
                return TrShapelessRecipe.class;
            })

            .addAlternatives(TrItem.class, (obj) -> {
                if (obj instanceof Map<?, ?> map) {
                    if (!String.class.equals(Utility.getKeyType(map)))
                        return TrItem.class;

                    return TrItemType.from((Map<String, Object>) map).getItem();
                }
                return TrItem.class;
            })

            .addAlias(null, "identifier", "ID", "id", TrIdentifier.getKey())
            .addAlias(TrItem.class, "owner", "UUID", "uuid", "Player", "player")
            .addAlias(TrMaxAmount.class, "maxAmount", "Max")
            .addAlias(TrMaxAmount.class, "minAmount", "Min")
            .addAlias(TrCompassItem.class, "lodestone", "Location", "Loc")

            .addEndMethod(EIItem.class, "finishDes")
            .addEndMethod(MMItem.class, "finishDes")
            .addEndMethod(MMOItem.class, "finishDes")
            .addEndMethod(TrArmorItem.class, "finishDes")
            .addEndMethod(TrBannerItem.class, "finishDes")
            .addEndMethod(TrBundleItem.class, "finishDes")
            .addEndMethod(TrCompassItem.class, "finishDes")
            .addEndMethod(TrCrossbowItem.class, "finishDes")
            .addEndMethod(TrEnchantedBookItem.class, "finishDes")
            .addEndMethod(TrFireworkRocketItem.class, "finishDes")
            .addEndMethod(TrFireworkStarItem.class, "finishDes")
            .addEndMethod(TrItem.class, "finishDes")
            .addEndMethod(TrKnowledgeBookItem.class, "finishDes")
            .addEndMethod(TrLeatherArmorItem.class, "finishDes")
            .addEndMethod(TrMapItem.class, "finishDes")
            .addEndMethod(TrMusicInstrumentItem.class, "finishDes")
            .addEndMethod(TrOminousBottleItem.class, "finishDes")
            .addEndMethod(TrPotionItem.class, "finishDes")
            .addEndMethod(TrShieldItem.class, "finishDes")
            .addEndMethod(TrSkullItem.class, "finishDes")
            .addEndMethod(TrSpawnEggItem.class, "finishDes")
            .addEndMethod(TrSuspiciousStewItem.class, "finishDes")
            .addEndMethod(TrTropicalFishBucketItem.class, "finishDes")
            .addEndMethod(TrWritableBookItem.class, "finishDes")
            .addEndMethod(TrWrittenBookItem.class, "finishDes")
            .addEndMethod(TrMemoryNBT.class, "finishDes")
            .addEndMethod(TrFlag.class, "finishDes")
            .addEndMethod(TrOwner.class, "finishDes")

            .addInstance(ArmorTrim.class, () -> new ArmorTrim(TrimMaterial.COPPER, TrimPattern.DUNE))
            .getProcess();

    private @Ignore TrMemoryNBT<TrIdentifier> ID_NBT;
    private @Essential TrIdentifier identifier;
    private @Essential Material material;
    private @Nullable String name;
    private @CanBeEmpty List<String> lore;
    private @CanBeEmpty List<TrEnchant> enchants;
    private @Nullable TrCustomModelData customModelData;
    private int amount;
    private @Nullable TrMaxAmount gameplayAmount;
    private @Nullable TrMaxAmount stackAmount;
    private @Nullable TrMaxAmount inventoryAmount;
    private @CanBeEmpty List<TrMemoryNBT<?>> nbts;
    private @CanBeEmpty List<TrPermission> permissions;
    private @CanBeEmpty List<TrFlag> flags;
    private @CanBeEmpty List<TrAttribute> attributes;
    private @Nullable TrItemRarity rarity;
    private @Nullable TrOwner owner;
    private int damage;
    private int slot;
    private @CanBeEmpty List<TrRecipe> recipes;

    private @Ignore TrItemMeta meta;
    private @Ignore ItemStack stack;
    private @Ignore ItemMeta itemMeta;
    private @Ignore TrItemType type;
    // private List<Function> functions;
    // private List<TrEffect> effects;

    @Initialize
    private TrItem() {
        this(TrIdentifier.random(), Material.STONE);
    }

    protected TrItem(TrItemType type) {
        this(TrIdentifier.random(), type.getExampleItem());
    }

    public TrItem(TrIdentifier identifier, @NotNull Material material) {
        this(identifier, TrItemType.from(material), material, new ArrayList<>(), null, null, null, null,
                -1, new ArrayList<>(), null, null, null,
                1, (short) 0, new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public TrItem(TrIdentifier identifier, @NotNull TrItemType type, @NotNull Material material,
                  @CanBeEmpty List<TrPermission> permissions, @Nullable TrOwner owner,
                  @Nullable TrCustomModelData customModelData, @Nullable TrItemRarity rarity,
                  @Nullable String name, int slot, @CanBeEmpty List<TrMemoryNBT<?>> nbts,
                  @Nullable TrMaxAmount inventoryAmount, @Nullable TrMaxAmount stackAmount,
                  @Nullable TrMaxAmount gameplayAmount, int amount, int damage,
                  @CanBeEmpty List<TrEnchant> enchants, @CanBeEmpty List<String> lore,
                  @CanBeEmpty List<TrFlag> flags, @CanBeEmpty List<TrAttribute> attributes,
                  @CanBeEmpty List<TrRecipe> recipes) {

        if (TrValidator.isNull(identifier, "Identifier cannot be null")) return;
        if (TrValidator.isNull(material, "Material of " + identifier + " cannot be null")) return;
        if (TrValidator.isNull(type, "Type of " + identifier + " cannot be null")) return;

        this.identifier = identifier;
        this.material = material;
        this.type = type;
        this.amount = amount < 0 ? 1 : amount;
        this.name = name;
        this.lore = TrValidator.isNull(lore, null) ? new ArrayList<>() : lore;
        this.nbts = TrValidator.isNull(nbts, null) ? new ArrayList<>() : nbts;
        this.attributes = TrValidator.isNull(attributes, null) ? new ArrayList<>() : attributes;
        this.recipes = TrValidator.isNull(recipes, null) ? new ArrayList<>() : recipes;
        this.customModelData = customModelData;
        this.enchants = TrValidator.isNull(enchants, null) ? new ArrayList<>() : enchants;
        this.rarity = rarity;
        this.slot = slot;
        this.damage = damage;
        this.permissions = TrValidator.isNull(permissions, null) ? new ArrayList<>() : permissions;
        this.flags = TrValidator.isNull(flags, null) ? new ArrayList<>() : flags;
        this.inventoryAmount = inventoryAmount;
        this.stackAmount = stackAmount;
        this.gameplayAmount = gameplayAmount;
        this.owner = owner;
        this.stack = new ItemStack(material, amount);
        this.itemMeta = hasMeta() ? stack.getItemMeta() : null;
        this.meta = type.getMeta(this);
        this.ID_NBT = new TrMemoryNBT<>(TR_ITEM_NBT_COMPOUND_ID, identifier);
        ID_NBT.set(this);
        getRegistry().register(this);
    }

    /*
     * =================
     * (DE)SERIALIZATION
     * =================
     */

    /**
     * Retrieve the TrItem from the provided stack
     * by picking the ID of TrItem from the stack.
     * <p>
     * If the stack is not a TrItem or the found ID
     * not exists, returns {@code null}.
     *
     * @param stack The stack to retrieve TrItem from.
     * @return The TrItem if found, otherwise {@code null}.
     */
    public static @Nullable TrItem from(ItemStack stack) {
        if (TrValidator.isNull(stack, "The provided stack to get TrItem from cannot be null"))
            return null;

        TrMemoryNBT<TrIdentifier> id = new TrMemoryNBT<>(TR_ITEM_NBT_COMPOUND_ID, TrReusableIdentifier.of("-"));

        TrIdentifier identifier = id.get(stack);

        if (identifier != null) {
            return getRegistry().get(identifier);
        }

        return null;
    }

    /**
     * Build an TrItem instance by coping
     * information from ItemStack.
     *
     * @param stack The stack to build TrItem on.
     * @return a new TrItem instance.
     */
    @SuppressWarnings("UnstableApiUsage")
    public static @NotNull TrItem build(ItemStack stack) {
        ItemMeta meta = stack.getItemMeta();

        TrItem item = new TrItem();

        item.setMaterial(stack.getType());
        item.setAmount(stack.getAmount());
        if (meta != null) {
            item.setCustomModelData(new TrComponentCustomModelData(meta.getCustomModelDataComponent()));
            Component name = meta.customName();
            if (name != null)
                item.setName(MiniMessage.miniMessage().serialize(name));

            if (meta instanceof Damageable damageable)
                item.setDamage(damageable.getDamage());

            item.setEnchants(meta.getEnchants().entrySet().stream().map(
                    enchant -> new TrEnchant(new TrVanillaEnchant(enchant.getKey()), enchant.getValue())
            ).toList());

            List<Component> lore = meta.lore();

            if (lore != null)
                item.setLore(lore.stream().map(line -> MiniMessage.miniMessage().serialize(line)).toList());

            TrFlag.getRegistry().values().filter(flag -> flag.has(meta)).forEach(item::addFlag);

            Multimap<Attribute, AttributeModifier> attributes = meta.getAttributeModifiers();
            if (meta.hasAttributeModifiers() && attributes != null) {
                for (Map.Entry<Attribute, AttributeModifier> attribute
                        : attributes.entries()) {
                    item.addAttribute(new TrAttribute(attribute.getKey(), attribute.getValue()));
                }
            }

        }

        item.finishDes();

        return item;
    }

    /**
     * Retrieve the TrItem from the provided stack
     * by picking the ID of TrItem from the stack.
     * <p>
     * If the stack is not a TrItem or the found ID
     * not exists, build it from the stack.
     *
     * @param stack The stack to retrieve TrItem from.
     * @return The TrItem if found, otherwise {@code null}.
     */
    public static @NotNull TrItem fromOrBuild(ItemStack stack) {
        TrItem trItem = from(stack);

        if (trItem != null)
            return trItem;

        return build(stack);
    }

    /**
     * Retrieve the TrItem with the provided ID from registry.
     *
     * @param id The item ID.
     * @return TrItem instance if found, otherwise {@code null}.
     */
    public static TrItem get(String id) {
        return getRegistry().get(id);
    }

    /**
     * Retrieve the TrItem with the provided ID from registry.
     *
     * @param id The item ID.
     * @return TrItem instance if found, otherwise {@code null}.
     */
    public static TrItem get(TrIdentifier id) {
        return getRegistry().get(id);
    }

    public static @Nullable TrItem deserialize(Map<String, Object> map) {
        if (TrValidator.isNull(map, "Provided map to deserialize TrItem cannot be null"))
            return null;
        return deserialize(MemoryJsonConfiguration.fromMap(map));
    }

    public static @Nullable TrItem deserialize(Section section) {
        if (TrValidator.isNull(section, "Provided section to deserialize TrItem cannot be null"))
            return null;

        TrIdentifier id = TrIdentifier.getID(section);
        TrItem item = getRegistry().get(id);

        if (item != null)
            return item;

        TrItemType type = TrItemType.from(section);

        return getDeserializer().deserialize(section.asMap(), type.getItem());
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> serialize() {
        return (Map<String, Object>) getSerializer().serialize(this);
    }

    /*
     * =================
     * SETTERS & GETTERS
     * =================
     */

    public static Serializer getSerializer() {
        return serializer;
    }

    public static Deserializer getDeserializer() {
        return deserializer;
    }

    public static TrItemRegistry getRegistry() {
        return TrItemRegistry.getInstance();
    }

    public @Nullable ItemMeta getItemMeta() {
        if (!hasMeta())
            throw new ItemHasNoMeta("This TrItem (" + material + ") has no meta.");
        return itemMeta;
    }

    public void setItemMeta(@Nullable ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
    }

    @Override
    public @NotNull TrIdentifier identifier() {
        return identifier;
    }

    public @NotNull TrIdentifier getIdentifier() {
        return identifier;
    }

    private void setIdentifier(@NotNull TrIdentifier identifier) {
        this.identifier = identifier;
    }

    public @NotNull TrItemType getType() {
        return type;
    }

    private void setType(@NotNull TrItemType type) {
        this.type = type;
    }

    public @CanBeEmpty List<TrPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(@CanBeEmpty List<TrPermission> permissions) {
        if (TrValidator.isNull(permissions)) {
            this.permissions = new ArrayList<>();
            return;
        }
        this.permissions = permissions;
    }

    public void addPermissions(@CanBeEmpty List<TrPermission> permissions) {
        if (TrValidator.isNull(permissions)) {
            this.permissions = new ArrayList<>();
            return;
        }
        this.permissions.addAll(permissions);
    }

    public void addPermissions(@CanBeEmpty TrPermission... permissions) {
        if (TrValidator.isNull(permissions)) {
            this.permissions = new ArrayList<>();
            return;
        }
        this.permissions.addAll(List.of(permissions));
    }

    public void addPermission(TrPermission permission) {
        if (TrValidator.isNull(permission))
            return;
        this.permissions.add(permission);
    }

    public List<TrFlag> getFlags() {
        return flags;
    }

    public void setFlags(@CanBeEmpty List<TrFlag> flags) {
        if (TrValidator.isNull(flags)) {
            this.flags = new ArrayList<>();
            return;
        }
        this.flags = flags;
    }

    public void addFlags(@CanBeEmpty List<TrFlag> flags) {
        if (TrValidator.isNull(flags)) {
            this.flags = new ArrayList<>();
            return;
        }
        this.flags.addAll(flags);
    }

    public void addFlags(@CanBeEmpty TrFlag... flags) {
        if (TrValidator.isNull(flags)) {
            this.flags = new ArrayList<>();
            return;
        }
        this.flags.addAll(List.of(flags));
    }

    public void addFlag(TrFlag flag) {
        if (TrValidator.isNull(flag))
            return;
        this.flags.add(flag);
    }

    public @NotNull Material getMaterial() {
        return material;
    }

    private void setMaterial(@NotNull Material material) {
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (TrValidator.checkIf(amount <= 0, "The amount for " + identifier() + " must be greater than 0"))
            return;
        this.amount = amount;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(@CanBeEmpty List<String> lore) {
        if (TrValidator.isNull(lore)) {
            this.lore = new ArrayList<>();
            return;
        }
        this.lore = lore;
    }

    public void addLore(@CanBeEmpty List<String> lore) {
        if (TrValidator.isNull(lore)) {
            this.lore = new ArrayList<>();
            return;
        }
        this.lore.addAll(lore);
    }

    public void addLore(@CanBeEmpty String... lore) {
        if (TrValidator.isNull(lore)) {
            this.lore = new ArrayList<>();
            return;
        }
        this.lore.addAll(List.of(lore));
    }

    public void addLore(String lore) {
        if (TrValidator.isNull(lore))
            return;
        this.lore.add(lore);
    }

    public void addLore(int i, String lore) {
        if (TrValidator.isNull(lore))
            return;
        this.lore.add(i, lore);
    }

    public List<TrEnchant> getEnchants() {
        return enchants;
    }

    public void setEnchants(@CanBeEmpty List<TrEnchant> enchants) {
        if (TrValidator.isNull(enchants)) {
            this.enchants = new ArrayList<>();
            return;
        }
        this.enchants = enchants;
    }

    public void addEnchants(@CanBeEmpty List<TrEnchant> enchants) {
        if (TrValidator.isNull(enchants)) {
            this.enchants = new ArrayList<>();
            return;
        }
        this.enchants.addAll(enchants);
    }

    public void addEnchants(@CanBeEmpty TrEnchant... enchants) {
        if (TrValidator.isNull(enchants)) {
            this.enchants = new ArrayList<>();
            return;
        }
        this.enchants.addAll(List.of(enchants));
    }

    public void addEnchant(TrEnchant enchant) {
        if (TrValidator.isNull(enchant))
            return;
        this.enchants.add(enchant);
    }

    public @Nullable TrMaxAmount getGameplayAmount() {
        return gameplayAmount;
    }

    public void setGameplayAmount(@Nullable TrMaxAmount gameplayAmount) {
        this.gameplayAmount = gameplayAmount;
    }

    public @Nullable TrMaxAmount getStackAmount() {
        return stackAmount;
    }

    public void setStackAmount(@Nullable TrMaxAmount stackAmount) {
        this.stackAmount = stackAmount;
    }

    public @Nullable TrMaxAmount getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(@Nullable TrMaxAmount inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public List<TrMemoryNBT<?>> getNBTs() {
        return nbts;
    }

    public void setNBTs(@CanBeEmpty List<TrMemoryNBT<?>> nbts) {
        this.nbts = nbts;
    }

    public void addNBTs(@CanBeEmpty List<TrMemoryNBT<?>> nbts) {
        if (TrValidator.isNull(nbts)) {
            this.nbts = new ArrayList<>();
            return;
        }
        this.nbts.addAll(nbts);
    }

    public void addNBTs(@CanBeEmpty TrMemoryNBT<?>... nbts) {
        if (TrValidator.isNull(nbts)) {
            this.nbts = new ArrayList<>();
            return;
        }
        this.nbts.addAll(List.of(nbts));
    }

    public void addNBT(TrMemoryNBT<?> nbt) {
        if (TrValidator.isNull(nbt))
            return;
        this.nbts.add(nbt);
    }

    public @Nullable TrItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(@Nullable TrItemRarity rarity) {
        this.rarity = rarity;
    }

    public @Nullable TrCustomModelData getCustomModelData() {
        return customModelData;
    }

    public void setCustomModelData(@Nullable TrCustomModelData customModelData) {
        this.customModelData = customModelData;
    }

    public @Nullable TrOwner getOwner() {
        return owner;
    }

    public void setOwner(@Nullable TrOwner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name == null ? getMaterial().name() : name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public @NotNull ItemStack getStack() {
        return stack;
    }

    public void setStack(@NotNull ItemStack stack) {
        if (TrValidator.isNull(stack, "The provided new ItemStack for " + identifier() + " is null."))
            return;
        this.stack = stack;
        stack.setItemMeta(getItemMeta());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (TrValidator.checkIf(damage < 0, "The provided damage for " + identifier() + " is < 0"))
            return;
        if (getItemMeta() instanceof Damageable damageable) {
            if (damageable.hasMaxDamage()) {
                this.damage = Math.max(0, Math.min(damage, damageable.getMaxDamage()));
                return;
            }
        }
        this.damage = Math.max(0, damage);

    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public List<TrAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<TrAttribute> attributes) {
        this.attributes = attributes;
    }

    public void addAttributes(@CanBeEmpty List<TrAttribute> attributes) {
        if (TrValidator.isNull(attributes)) {
            this.attributes = new ArrayList<>();
            return;
        }
        this.attributes.addAll(attributes);
    }

    public void addAttributes(@CanBeEmpty TrAttribute... attributes) {
        if (TrValidator.isNull(attributes)) {
            this.attributes = new ArrayList<>();
            return;
        }
        this.attributes.addAll(List.of(attributes));
    }

    public void addAttribute(TrAttribute attribute) {
        if (TrValidator.isNull(attribute))
            return;
        this.attributes.add(attribute);
    }

    public List<TrRecipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<TrRecipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipes(@CanBeEmpty List<TrRecipe> recipes) {
        if (TrValidator.isNull(recipes)) {
            this.recipes = new ArrayList<>();
            return;
        }
        this.recipes.addAll(recipes);
    }

    public void addRecipes(@CanBeEmpty TrRecipe... recipes) {
        if (TrValidator.isNull(recipes)) {
            this.recipes = new ArrayList<>();
            return;
        }
        this.recipes.addAll(List.of(recipes));
    }

    public void addRecipe(TrRecipe recipe) {
        if (TrValidator.isNull(recipe))
            return;
        this.recipes.add(recipe);
    }

    public TrItemMeta getMeta() {
        if (meta == null)
            meta = new TrItemMeta(this);
        return meta;
    }

    /**
     * Checks if stack of this item has meta and if it is empty.
     *
     * @return {@code true} if it not has meta or is meta empty, otherwise {@code false}.
     */
    public boolean isMetaEmpty() {
        return !hasMeta() || getStack().hasItemMeta();
    }

    /**
     * Checks if the stack of this item has meta.
     *
     * @return {@code true} if it has, otherwise {@code false}.
     */
    public boolean hasMeta() {
        return getStack().getItemMeta() != null;
    }


    /**
     * Get the stack of this item
     * with meta applied.
     *
     * @return the stack of this item.
     */
    public ItemStack toStack() {
        return getMeta().apply().getStack();
    }


    /*
     * ==================
     * PLAYER INTERACTION
     * ==================
     */

    /**
     * Give this item to the player.
     *
     * @param player The player to give to.
     */
    public void give(Player player) {
        if (TrValidator.isNull(player, "Player cannot be null while giving " + identifier() + " to it."))
            return;

        player.give(toStack());
    }

    /**
     * Give this item to the player at the provided slot.
     *
     * @param player The player to give to.
     * @param slot   The slot to give the item to.
     */
    public void give(Player player, int slot) {
        if (TrValidator.isNull(player, "Player cannot be null while giving " + identifier() + " to it."))
            return;
        give(player, slot, false);
    }

    /**
     * Give this item to the player at the provided slot.
     *
     * @param player The player to give to.
     * @param slot   The slot to give the item to.
     * @param force  Remove the item at the provided slot, if is present.
     */
    public void give(Player player, int slot, boolean force) {
        if (TrValidator.isNull(player, "Player cannot be null while giving " + identifier() + " to it."))
            return;
        if (slot < 0) {
            give(player);
            return;
        }

        Inventory inv = player.getInventory();
        ItemStack stackAtSlot = inv.getItem(slot);

        if (stackAtSlot != null && !force)
            return;

        inv.setItem(slot, toStack());
    }


    /*
     * ===============
     * UTILITY METHODS
     * ===============
     */

    /**
     * Clone this instance.
     *
     * @param newIdentifier The new identifier to assign.
     * @return The new instance of TrItem.
     */
    public TrItem clone(TrIdentifier newIdentifier) {
        Map<String, Object> serialize = serialize();
        serialize.put(TrIdentifier.getKey(), newIdentifier.toString());

        return deserialize(serialize);
    }

    /**
     * Checks if the provided stack is a TrItem.
     *
     * @param stack The stack to check.
     * @return {@code true} if it is, otherwise {@code false}.
     */
    public static boolean isTrItem(ItemStack stack) {
        return IS_TR_ITEM_NBT.has(stack);
    }

    /**
     * This method is called by deserializer to adjust some fields.
     */
    private void finishDes() {
        this.type = TrItemType.from(getMaterial());
        this.lore = TrValidator.isNull(lore, null) ? new ArrayList<>() : lore;
        this.nbts = TrValidator.isNull(nbts, null) ? new ArrayList<>() : nbts;
        this.enchants = TrValidator.isNull(enchants, null) ? new ArrayList<>() : enchants;
        this.permissions = TrValidator.isNull(permissions, null) ? new ArrayList<>() : permissions;
        this.flags = TrValidator.isNull(flags, null) ? new ArrayList<>() : flags;
        this.stack = new ItemStack(material, amount);
        this.itemMeta = hasMeta() ? stack.getItemMeta() : null;
        this.meta = type.getMeta(this);
        this.ID_NBT = new TrMemoryNBT<>(TR_ITEM_NBT_COMPOUND_ID, getIdentifier());
        this.ID_NBT.set(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        TrItem item = (TrItem) o;
        return getAmount() == item.getAmount() &&
                getDamage() == item.getDamage() &&
                getSlot() == item.getSlot() &&
                getMaterial() == item.getMaterial() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getLore(), item.getLore()) &&
                Objects.equals(getEnchants(), item.getEnchants()) &&
                Objects.equals(getCustomModelData(), item.getCustomModelData()) &&
                Objects.equals(getGameplayAmount(), item.getGameplayAmount()) &&
                Objects.equals(getStackAmount(), item.getStackAmount()) &&
                Objects.equals(getInventoryAmount(), item.getInventoryAmount()) &&
                Objects.equals(getNBTs(), item.getNBTs()) &&
                Objects.equals(getPermissions(), item.getPermissions()) &&
                Objects.equals(getFlags(), item.getFlags()) &&
                Objects.equals(getAttributes(), item.getAttributes()) &&
                Objects.equals(getRarity(), item.getRarity()) &&
                Objects.equals(getOwner(), item.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getMaterial(),
                getName(),
                getLore(),
                getEnchants(),
                getCustomModelData(),
                getAmount(),
                getGameplayAmount(),
                getStackAmount(),
                getInventoryAmount(),
                getNBTs(),
                getPermissions(),
                getFlags(),
                getAttributes(),
                getRarity(),
                getOwner(),
                getDamage()
        );
    }

    @Override
    public String toString() {
        return "TrItem{" +
                "ID=\"" + getIdentifier() + "\", " +
                "Type=\"" + getType().name() + "\", " +
                "Amount=" + getAmount() + ", " +
                (!TrValidator.isNull(getName()) ? "Name=\"" + getName() + "\", " : "") +
                (!TrValidator.isNull(getLore()) ? "Lore=" + getLore() + ", " : "") +
                (!TrValidator.isNull(getEnchants()) ? "Enchants=" + getEnchants().stream().map(TrEnchant::toString).toList() + ", " : "") +
                (!TrValidator.isNull(getCustomModelData()) ? "CustomModelData=" + getCustomModelData().toString() + ", " : "") +
                (!TrValidator.isNull(getGameplayAmount()) ? "GameplayAmount=" + getGameplayAmount() + ", " : "") +
                (!TrValidator.isNull(getStackAmount()) ? "StackAmount=" + getStackAmount() + ", " : "") +
                (!TrValidator.isNull(getInventoryAmount()) ? "InventoryAmount=" + getInventoryAmount() + ", " : "") +
                (!TrValidator.isNull(getNBTs()) ? "NBTs=" + getNBTs() + ", " : "") +
                (!TrValidator.isNull(getPermissions()) ? "Permissions=" + getPermissions() + ", " : "") +
                (!TrValidator.isNull(getRarity()) ? "Rarity=\"" + getRarity() + "\", " : "") +
                (!TrValidator.isNull(getOwner()) ? "Owner=\"" + getOwner() + "\", " : "") +
                (!TrValidator.isNull(getDamage()) ? "Damage=" + getDamage() + ", " : "") +
                (!TrValidator.isNull(getSlot()) ? "Slot=" + getSlot() + ", " : "") +
                (!TrValidator.isNull(getFlags()) ? "Flags=" + getFlags() + ", " : "") +
                (!TrValidator.isNull(getAttributes()) ? "Attributes=" + getAttributes() + ", " : "") +
                (!TrValidator.isNull(getRecipes()) ? "Recipes=" + getRecipes() + ", " : "") +
                "Stack=" + getStack() + ", " +
                (!TrValidator.isNull(getMeta()) ? "Meta=" + getMeta().getClass().getSimpleName() + ", " : "") +
                (!TrValidator.isNull(getStack()) ? "Stack=" + getStack().getClass().getSimpleName() + ", " : "") +
                (!TrValidator.isNull(getItemMeta()) ? "IMeta=" + getItemMeta().getClass().getSimpleName() + ", " : "") +
                "}";
    }
}
