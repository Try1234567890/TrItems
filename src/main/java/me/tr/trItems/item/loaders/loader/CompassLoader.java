package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.CompassItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

public class CompassLoader extends BaseLoader {

    public CompassItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        Location lodestone = getLodestone(itemSection);
        boolean trackLodestone = getTrackLodestone(itemSection);
        return new CompassItem(baseItem, lodestone, trackLodestone);
    }

    public boolean getTrackLodestone(Section itemSection) {
        return itemSection.getBoolean("TrackLodestone");
    }

    public Location getLodestone(Section itemSection) {
        String lodestoneStr = itemSection.getString("Lodestone");
        String[] lodestoneStrSplit = lodestoneStr.split(" ");
        if (lodestoneStrSplit.length < 2)
            throw new ArrayIndexOutOfBoundsException("Lodestone location " + lodestoneStr + " not contains enough information.");
        try {
            double x = Double.parseDouble(lodestoneStrSplit[0]);
            double y = Double.parseDouble(lodestoneStrSplit[1]);
            double z = Double.parseDouble(lodestoneStrSplit[2]);
            String worldName = lodestoneStrSplit.length >= 4 ? lodestoneStrSplit[3] : Bukkit.getWorlds().getFirst().getName();
            World world = Bukkit.getWorld(worldName);
            if (world == null)
                throw new NullPointerException("World " + worldName + " not found.");
            return new Location(world, x, y, z);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Lodestone location coordinates can only contains numbers");
        }

    }
}
