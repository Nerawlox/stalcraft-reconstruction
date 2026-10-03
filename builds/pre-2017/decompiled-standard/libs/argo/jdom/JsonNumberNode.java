/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeType;
import argo.jdom.JsonStringNode;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class JsonNumberNode
extends JsonNode
implements JsonNodeBuilder<JsonNode> {
    private static final Pattern PATTERN = Pattern.compile("(-?)(0|([1-9]([0-9]*)))(\\.[0-9]+)?((e|E)(\\+|-)?[0-9]+)?");
    private final String value;

    JsonNumberNode(String value) {
        if (value == null) {
            throw new NullPointerException("Attempt to construct a JsonNumber with a null value.");
        }
        if (!PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Attempt to construct a JsonNumber with a String [" + value + "] that does not match the JSON number specification.");
        }
        this.value = value;
    }

    @Override
    public JsonNodeType getType() {
        return JsonNodeType.NUMBER;
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public String getText() {
        return this.value;
    }

    @Override
    public boolean hasFields() {
        return false;
    }

    @Override
    public Map<JsonStringNode, JsonNode> getFields() {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    @Override
    public boolean hasElements() {
        return false;
    }

    @Override
    public List<JsonNode> getElements() {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || this.getClass() != that.getClass()) {
            return false;
        }
        JsonNumberNode thatJsonNumberNode = (JsonNumberNode)that;
        return this.value.equals(thatJsonNumberNode.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "JsonNumberNode value:[" + this.value + "]";
    }

    @Override
    public JsonNode build() {
        return this;
    }
}

