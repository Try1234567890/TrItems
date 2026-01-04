package me.tr.tritems;

import me.tr.serializer.registries.HandlersRegistry;
import me.tr.trfiles.TrFiles;
import me.tr.trformatter.TrFormatter;
import me.tr.tritems.handlers.*;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.enchants.TrEnchantEntry;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.identification.TrIdentifier;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.MusicInstrument;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

public final class TrItems {
    private static MiniMessage miniMessage;
    private static Plugin plugin;

    private TrItems() {
    }

    /**
     * Initialize all TrItems internals.
     *
     * @param plugin The plugin to assign this instance to.
     * @throws PluginNotInitialized if the plugin is null.
     */
    public static void init(Plugin plugin) {
        if (plugin == null) {
            throw new PluginNotInitialized();
        }

        TrFiles.initAsync();
        TrFormatter.initAsync();

        HandlersRegistry.getInstance().register((c) -> c != null && TrItem.class.isAssignableFrom(c), (p) -> TrItemHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && PatternType.class.isAssignableFrom(c), (p) -> PatternTypeHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && MusicInstrument.class.isAssignableFrom(c), (p) -> MusicInstrumentHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && TrIdentifier.class.isAssignableFrom(c), (p) -> TrIdentifierHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && TrimMaterial.class.isAssignableFrom(c), (p) -> TrimMaterialHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && TrimPattern.class.isAssignableFrom(c), (p) -> TrimPatternHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && TrEnchantEntry.class.isAssignableFrom(c), (p) -> TrEnchantHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && World.class.isAssignableFrom(c), (p) -> WorldHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && TrFlag.class.isAssignableFrom(c), (p) -> TrFlagHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && Attribute.class.isAssignableFrom(c), (p) -> AttributeHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && OfflinePlayer.class.isAssignableFrom(c), (p) -> OfflinePlayerHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && NamespacedKey.class.isAssignableFrom(c), (p) -> NamespacedKeyHandler.INSTANCE);
        HandlersRegistry.getInstance().register((c) -> c != null && PotionEffectType.class.isAssignableFrom(c), (p) -> PotionEffectTypeHandler.INSTANCE);

        TrItems.miniMessage = MiniMessage.miniMessage();
        TrItems.plugin = plugin;
    }

    /**
     * Retrieve the assigned plugin to this instance.
     *
     * @return the assigned plugin to this instance.
     * @throws PluginNotInitialized if the plugin is null.
     */
    public static Plugin getPlugin() {
        if (TrItems.plugin == null) {
            throw new PluginNotInitialized();
        }
        return plugin;
    }

    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }
}
