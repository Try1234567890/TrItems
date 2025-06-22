package me.tr.trItems.item.exeptions;

/**
 * The ItemMetaNotFound exception is thrown when an item meta is expected but not found.
 * It extends RuntimeException, indicating that it is an unchecked exception.
 */
public class ItemMetaNotFound extends RuntimeException {

    /**
     * Constructs a new ItemMetaNotFound exception with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception
     */
    public ItemMetaNotFound(String message) {
        super(message);
    }

    /**
     * Constructs a new ItemMetaNotFound exception with the specified detail message and cause.
     *
     * @param message  The detail message explaining the reason for the exception
     * @param runnable The cause of the exception
     */
    public ItemMetaNotFound(String message, Throwable runnable) {
        super(message, runnable);
    }
}