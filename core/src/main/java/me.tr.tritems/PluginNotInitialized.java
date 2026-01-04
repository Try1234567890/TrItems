package me.tr.tritems;

public class PluginNotInitialized extends RuntimeException {

    public PluginNotInitialized(String name) {
        super("!! THIS IS NOT A " + name + " BUG !! " +
                name + " is not initialized. " +
                "Read the plugin that cause this error in the stacktrace, " +
                "then report to its author providing the logs.");
    }

    public PluginNotInitialized() {
        this("TrItems");
    }
}
