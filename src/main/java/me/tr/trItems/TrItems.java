package me.tr.trItems;

import me.tr.trFiles.TrFiles;
import me.tr.trLogger.logger.ConsoleLogger;

public final class TrItems {
    private static TrItems instance;
    private TrFiles fileLib;
    private ConsoleLogger logger;

    private TrItems() {
        init();
    }

    public static TrItems getInstance() {
        if (instance == null) {
            instance = new TrItems();
        }
        return instance;
    }

    private void init() {
        fileLib = new TrFiles();
        logger = new ConsoleLogger();
    }

    public ConsoleLogger getLogger() {
        return logger;
    }

    public TrFiles getFileLib() {
        return fileLib;
    }
}
