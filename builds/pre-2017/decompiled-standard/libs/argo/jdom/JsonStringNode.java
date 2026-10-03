/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeType;
import java.util.List;
import java.util.Map;

public final class JsonStringNode
extends JsonNode
implements Comparable<JsonStringNode>,
JsonNodeBuilder<JsonStringNode> {
    private final String value;

    JsonStringNode(String value) {
        if (value == null) {
            throw new NullPointerException("Attempt to construct a JsonString with a null value.");
        }
        this.value = value;
    }

    @Override
    public JsonNodeType getType() {
        return JsonNodeType.STRING;
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
        JsonStringNode thatJsonTextNode = (JsonStringNode)that;
        return this.value.equals(thatJsonTextNode.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "JsonStringNode value:[" + this.value + "]";
    }

    @Override
    public int compareTo(JsonStringNode that) {
        return this.value.compareTo(that.value);
    }

    @Override
    public JsonStringNode build() {
        return this;
    }
}

