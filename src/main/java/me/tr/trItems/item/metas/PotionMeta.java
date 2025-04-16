package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.PotionItem;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PotionMeta extends BaseMeta {

    public void setMeta(PotionItem item, Player player) {
        super.setMeta(item, player);
        setBasePotionType(item);
        setColor(item);
        setCustomName(item, player);
        setCustomEffects(item);
    }

    public void setBasePotionType(PotionItem item) {
        org.bukkit.inventory.meta.PotionMeta potionMeta = item.getItemMeta();
        if (potionMeta == null) return;
        potionMeta.setBasePotionType(item.getBasePotionType());
        item.getStack().setItemMeta(potionMeta);
    }

    public void setColor(PotionItem item) {
        org.bukkit.inventory.meta.PotionMeta potionMeta = item.getItemMeta();
        if (potionMeta == null) return;
        potionMeta.setColor(item.getColor());
        item.getStack().setItemMeta(potionMeta);
    }

    public void setCustomName(PotionItem item, Player player) {
        org.bukkit.inventory.meta.PotionMeta potionMeta = item.getItemMeta();
        if (potionMeta == null) return;
        potionMeta.customName(main.getFormatter().format(item.getCustomName(), player));
        item.getStack().setItemMeta(potionMeta);
    }

    public void setCustomEffects(PotionItem item) {
        org.bukkit.inventory.meta.PotionMeta potionMeta = item.getItemMeta();
        if (potionMeta == null) return;
        for (PotionEffect effect : item.getCustomEffects())
            potionMeta.addCustomEffect(effect, true);
        item.getStack().setItemMeta(potionMeta);
    }


}
