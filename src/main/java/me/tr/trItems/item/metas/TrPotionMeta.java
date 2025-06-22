package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrPotionItem;
import me.tr.trItems.message.MessageFormatter;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

import java.util.List;

public class TrPotionMeta extends TrBaseMeta {


    private TrPotionMeta() {
    }


    public TrPotionMeta(TrPotionItem item) {
        super(item);
    }

    @Override
    public TrPotionItem getItem() {
        return (TrPotionItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setBasePotionType();
        setColor();
        setCustomName(player);
        setCustomEffects();
    }

    public void setBasePotionType() {
        PotionMeta potionMeta = getItem().getItemMeta();
        if (potionMeta == null) return;
        potionMeta.setBasePotionType(getItem().getBasePotionType());
        getItem().getStack().setItemMeta(potionMeta);
    }

    public void editBasePotionType(PotionType potionType) {
        getItem().setBasePotionType(potionType);
        setBasePotionType();
    }

    public void setColor() {
        PotionMeta potionMeta = getItem().getItemMeta();
        if (potionMeta == null) return;
        potionMeta.setColor(getItem().getColor());
        getItem().getStack().setItemMeta(potionMeta);
    }

    public void editColor(Color color) {
        getItem().setColor(color);
        setColor();
    }

    public void setCustomName(Player player) {
        PotionMeta potionMeta = getItem().getItemMeta();
        if (potionMeta == null) return;
        Component customName = MessageFormatter.getInstance().format(getItem().getCustomName(), player);
        if (customName != null) {
            potionMeta.displayName(customName);
            getItem().getStack().setItemMeta(potionMeta);
        }
    }

    public void editCustomName(String customName, Player player) {
        getItem().setCustomName(customName);
        setCustomName(player);
    }

    public void setCustomEffects() {
        PotionMeta potionMeta = getItem().getItemMeta();
        if (potionMeta == null) return;
        for (PotionEffect effect : getItem().getCustomEffects())
            potionMeta.addCustomEffect(effect, true);
        getItem().getStack().setItemMeta(potionMeta);
    }

    public void editCustomEffects(List<PotionEffect> customEffects) {
        getItem().setCustomEffect(customEffects);
        setCustomEffects();
    }


}
