package me.tr.trItems;

import me.tr.TrFiles;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.helper.logger.TrLogger;
import me.tr.trItems.item.loaders.ItemLoaderManager;

public final class TrItems {
    private static TrItems instance;
    private TrFiles trFiles;
    private TrLogger trLogger;
    private ItemManager itemManager;
    private ItemLoaderManager itemLoaderManager;
    private Formatter formatter;

    public static TrItems getInstance() {
        return instance;
    }

    private void init() {
        instance = this;
        trFiles = new TrFiles();
        trLogger = new TrLogger();
        itemManager = new ItemManager();
        itemLoaderManager = new ItemLoaderManager();
        formatter = new Formatter();
    }

    public void onEnable() {
        init();
        final String[] ON = {
                "",
                "<aqua>TrItems <dark_aqua>V. 1.0.3 <aqua>avviato con successo.",
                "<aqua>Tutti gli oggetti sono stati caricati. <dark_aqua>" + getItemManager().getCachedItems().size(),
                ""
        };
        for (String line : ON)
            getTrLogger().info(line);
    }

    public void onDisable() {

    }

    public TrLogger getTrLogger() {
        return trLogger;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public ItemLoaderManager getItemLoaderManager() {
        return itemLoaderManager;
    }

    public TrFiles getTrFiles() {
        return trFiles;
    }

    public Formatter getFormatter() {
        return formatter;
    }
}
