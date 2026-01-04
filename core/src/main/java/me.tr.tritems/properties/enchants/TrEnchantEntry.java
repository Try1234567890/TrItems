package me.tr.tritems.properties.enchants;

import me.tr.serializer.annotations.Ignore;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifiable;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.nbts.TrMemoryNBT;
import me.tr.tritems.registries.TrEnchantRegistry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public abstract class TrEnchantEntry implements TrIdentifiable {
    public static final TrEnchantEntry PROTECTION = getEnchantment(Enchantment.PROTECTION);
    public static final TrEnchantEntry FIRE_PROTECTION = getEnchantment(Enchantment.FIRE_PROTECTION);
    public static final TrEnchantEntry FEATHER_FALLING = getEnchantment(Enchantment.FEATHER_FALLING);
    public static final TrEnchantEntry BLAST_PROTECTION = getEnchantment(Enchantment.BLAST_PROTECTION);
    public static final TrEnchantEntry PROJECTILE_PROTECTION = getEnchantment(Enchantment.PROJECTILE_PROTECTION);
    public static final TrEnchantEntry RESPIRATION = getEnchantment(Enchantment.RESPIRATION);
    public static final TrEnchantEntry AQUA_AFFINITY = getEnchantment(Enchantment.AQUA_AFFINITY);
    public static final TrEnchantEntry THORNS = getEnchantment(Enchantment.THORNS);
    public static final TrEnchantEntry DEPTH_STRIDER = getEnchantment(Enchantment.DEPTH_STRIDER);
    public static final TrEnchantEntry FROST_WALKER = getEnchantment(Enchantment.FROST_WALKER);
    public static final TrEnchantEntry BINDING_CURSE = getEnchantment(Enchantment.BINDING_CURSE);
    public static final TrEnchantEntry SHARPNESS = getEnchantment(Enchantment.SHARPNESS);
    public static final TrEnchantEntry SMITE = getEnchantment(Enchantment.SMITE);
    public static final TrEnchantEntry BANE_OF_ARTHROPODS = getEnchantment(Enchantment.BANE_OF_ARTHROPODS);
    public static final TrEnchantEntry KNOCKBACK = getEnchantment(Enchantment.KNOCKBACK);
    public static final TrEnchantEntry FIRE_ASPECT = getEnchantment(Enchantment.FIRE_ASPECT);
    public static final TrEnchantEntry LOOTING = getEnchantment(Enchantment.LOOTING);
    public static final TrEnchantEntry SWEEPING_EDGE = getEnchantment(Enchantment.SWEEPING_EDGE);
    public static final TrEnchantEntry EFFICIENCY = getEnchantment(Enchantment.EFFICIENCY);
    public static final TrEnchantEntry SILK_TOUCH = getEnchantment(Enchantment.SILK_TOUCH);
    public static final TrEnchantEntry UNBREAKING = getEnchantment(Enchantment.UNBREAKING);
    public static final TrEnchantEntry FORTUNE = getEnchantment(Enchantment.FORTUNE);
    public static final TrEnchantEntry POWER = getEnchantment(Enchantment.POWER);
    public static final TrEnchantEntry PUNCH = getEnchantment(Enchantment.PUNCH);
    public static final TrEnchantEntry FLAME = getEnchantment(Enchantment.FLAME);
    public static final TrEnchantEntry INFINITY = getEnchantment(Enchantment.INFINITY);
    public static final TrEnchantEntry LUCK_OF_THE_SEA = getEnchantment(Enchantment.LUCK_OF_THE_SEA);
    public static final TrEnchantEntry LURE = getEnchantment(Enchantment.LURE);
    public static final TrEnchantEntry LOYALTY = getEnchantment(Enchantment.LOYALTY);
    public static final TrEnchantEntry IMPALING = getEnchantment(Enchantment.IMPALING);
    public static final TrEnchantEntry RIPTIDE = getEnchantment(Enchantment.RIPTIDE);
    public static final TrEnchantEntry CHANNELING = getEnchantment(Enchantment.CHANNELING);
    public static final TrEnchantEntry MULTISHOT = getEnchantment(Enchantment.MULTISHOT);
    public static final TrEnchantEntry QUICK_CHARGE = getEnchantment(Enchantment.QUICK_CHARGE);
    public static final TrEnchantEntry PIERCING = getEnchantment(Enchantment.PIERCING);
    public static final TrEnchantEntry DENSITY = getEnchantment(Enchantment.DENSITY);
    public static final TrEnchantEntry BREACH = getEnchantment(Enchantment.BREACH);
    public static final TrEnchantEntry WIND_BURST = getEnchantment(Enchantment.WIND_BURST);
    public static final TrEnchantEntry MENDING = getEnchantment(Enchantment.MENDING);
    public static final TrEnchantEntry VANISHING_CURSE = getEnchantment(Enchantment.VANISHING_CURSE);
    public static final TrEnchantEntry SOUL_SPEED = getEnchantment(Enchantment.SOUL_SPEED);
    public static final TrEnchantEntry SWIFT_SNEAK = getEnchantment(Enchantment.SWIFT_SNEAK);
    private final TrIdentifier identifier;
    public final @Ignore TrMemoryNBT<Integer> NBT;
    private @Ignore int maxLevel;
    private @Ignore Set<TrEnchantEntry> conflicts;
    private @Ignore Set<ItemType> targets;
    private @Ignore double anvilExpCost;
    private @Ignore double moneyCost;

    public TrEnchantEntry(TrIdentifier identifier, double moneyCost, double anvilExpCost,
                          Set<ItemType> targets, Set<TrEnchantEntry> conflicts, int maxLevel) {
        this.moneyCost = moneyCost;
        this.anvilExpCost = anvilExpCost;
        this.targets = targets;
        this.conflicts = conflicts;
        this.maxLevel = maxLevel;
        this.identifier = identifier;
        this.NBT = new TrMemoryNBT<>("tritems.enchants." + identifier().getIdentifier(), 0);
        getRegistry().register(this);
    }


    public static @Nullable TrEnchantEntry getEnchantment(String name) {
        return getRegistry().get(name);
    }

    public static @Nullable TrEnchantEntry getEnchantment(TrIdentifier id) {
        return getRegistry().get(id);
    }

    public static @Nullable TrEnchantEntry getEnchantment(Enchantment enchantment) {
        return getRegistry().get(enchantment.getKey().getKey());
    }

    public static TrEnchantRegistry getRegistry() {
        return TrEnchantRegistry.getInstance();
    }

    @Override
    public TrIdentifier identifier() {
        return identifier;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Set<TrEnchantEntry> getConflicts() {
        return conflicts;
    }

    public void setConflicts(Set<TrEnchantEntry> conflicts) {
        this.conflicts = conflicts;
    }

    public Set<ItemType> getTargets() {
        return targets;
    }

    public void setTargets(Set<ItemType> targets) {
        this.targets = targets;
    }

    public double getAnvilExpCost() {
        return anvilExpCost;
    }

    public void setAnvilExpCost(double anvilExpCost) {
        this.anvilExpCost = anvilExpCost;
    }

    public double getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(double moneyCost) {
        this.moneyCost = moneyCost;
    }

    public boolean has(ItemMeta meta) {
        return NBT.has(meta);
    }

    public void set(ItemMeta meta, int level) {
        NBT.setValue(level);
        NBT.set(meta);
    }

    public void remove(ItemMeta meta) {
        NBT.remove(meta);
    }

    public boolean has(ItemStack stack) {
        return NBT.has(stack);
    }

    public void set(ItemStack stack, int level) {
        NBT.setValue(level);
        NBT.set(stack);
    }

    public void remove(ItemStack stack) {
        NBT.remove(stack);
    }

    public abstract void use(Player player, TrItem item);

    @Override
    public String toString() {
        return "TrEnchant{ID=" + identifier + "}";
    }

    public String complexToString() {
        return "TrEnchant{ID=" + identifier + ", maxLevel=" + maxLevel + ", conflicts=" + conflicts + ", targets=" + targets + ", anvilExpCost=" + anvilExpCost + ", moneyCost=" + moneyCost + '}';
    }
}
