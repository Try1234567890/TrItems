package me.tr.trItems.item.helper;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

/**
 * The Attributes class represents an attribute and its corresponding modifier.
 * It is used to define and modify attributes for items in the game.
 */
public class Attributes {
    private final Attribute attribute;
    private final AttributeModifier attributeModifier;

    /**
     * Constructs an Attributes instance with the specified attribute and attribute modifier.
     *
     * @param attribute         The Attribute to be modified
     * @param attributeModifier The AttributeModifier to apply to the attribute
     */
    public Attributes(Attribute attribute, AttributeModifier attributeModifier) {
        this.attribute = attribute;
        this.attributeModifier = attributeModifier;
    }

    /**
     * Gets the Attribute associated with this instance.
     *
     * @return The Attribute associated with this instance
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * Gets the AttributeModifier associated with this instance.
     *
     * @return The AttributeModifier associated with this instance
     */
    public AttributeModifier getAttributeModifier() {
        return attributeModifier;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "attribute=" + attribute +
                ", attributeModifier=" + attributeModifier +
                '}';
    }
}
