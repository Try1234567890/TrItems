package me.tr.tritems.messages.placeholders;

import me.tr.trformatter.phases.analysis.lexer.tokens.params.manager.ParamsContainer;
import me.tr.trformatter.uids.UID;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.TrAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrAttributesTag extends TrItemTag {

    public TrAttributesTag() {
        super(new UID("item_attributes"));
    }

    @Override
    protected String getPlaceholder(TrItem item, ParamsContainer params) {
        Optional<String> split = getSplit(params);
        String format = getFormat(params);

        List<String> attributes = getAttributes(item, format);

        return split.map(s -> String.join(s, attributes)).orElseGet(attributes::toString);
    }

    private List<String> getAttributes(TrItem item, String format) {
        List<String> attributes = new ArrayList<>();

        for (TrAttribute attribute : item.getAttributes()) {
            String attrName = String.valueOf(attribute.getAttribute().getKey());
            String attrSent = String.valueOf(attribute.getAttribute().getSentiment());
            String modifierName = String.valueOf(attribute.getKey());
            String modifierAmount = String.valueOf(attribute.getAmount());
            String modifierOperation = String.valueOf(attribute.getOperation());

            String nbtEntry = format
                    .replace("$[ATTRIBUTE_NAME]", attrName)
                    .replace("$[ATTRIBUTE_SENTIMENT]", attrSent)
                    .replace("$[MODIFIER_NAME]", modifierName)
                    .replace("$[MODIFIER_AMOUNT]", modifierAmount)
                    .replace("$[MODIFIER_OPERATION]", modifierOperation);
            attributes.add(nbtEntry);
        }

        return attributes;
    }

    private String getFormat(ParamsContainer params) {
        String format = params.getAsOrNull("format", String.class);
        if (format == null || format.isEmpty()) {
            return "Attribute[Name: $[ATTRIBUTE_NAME] | Sentiment: $[ATTRIBUTE_SENTIMENT] Modifier[Name: $[MODIFIER_NAME] | Amount: $[MODIFIER_AMOUNT] | Operation: $[MODIFIER_OPERATION]]]";
        }
        return format;
    }

    private Optional<String> getSplit(ParamsContainer params) {
        return params.getAs("split", String.class);
    }

}
