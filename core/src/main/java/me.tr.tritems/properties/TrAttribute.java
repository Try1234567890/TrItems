package me.tr.tritems.properties;

import me.tr.serializer.annotations.Initialize;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

public class TrAttribute {
    private Attribute attribute;
    private NamespacedKey key;
    private double amount;
    private AttributeModifier.Operation operation;

    @Initialize
    private TrAttribute() {
    }

    public TrAttribute(Attribute attribute, NamespacedKey key, double amount,
                       AttributeModifier.Operation operation) {
        this.attribute = attribute;
        this.key = key;
        this.amount = amount;
        this.operation = operation;
    }

    public TrAttribute(Attribute attribute, AttributeModifier modifier) {
        this.attribute = attribute;
        this.key = modifier.getKey();
        this.amount = modifier.getAmount();
        this.operation = modifier.getOperation();
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public AttributeModifier getAttributeModifier() {
        return new AttributeModifier(getKey(), getAmount(), getOperation());
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }


    public NamespacedKey getKey() {
        return key;
    }

    public void setKey(NamespacedKey key) {
        this.key = key;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AttributeModifier.Operation getOperation() {
        return operation;
    }

    public void setOperation(AttributeModifier.Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "TrAttribute{" +
                "Attribute=" + attribute +
                ", Key=" + key +
                ", Amount=" + amount +
                ", Operation=" + operation +
                '}';
    }
}
