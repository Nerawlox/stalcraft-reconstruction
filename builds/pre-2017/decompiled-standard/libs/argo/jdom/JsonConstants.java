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

final class JsonConstants
extends JsonNode
implements JsonNodeBuilder<JsonNode> {
    static final JsonConstants NULL = new JsonConstants(JsonNodeType.NULL);
    static final JsonConstants TRUE = new JsonConstants(JsonNodeType.TRUE);
    static final JsonConstants FALSE = new JsonConstants(JsonNodeType.FALSE);
    private final JsonNodeType jsonNodeType;

    private JsonConstants(JsonNodeType jsonNodeType) {
        this.jsonNodeType = jsonNodeType;
    }

    @Override
    public JsonNodeType getType() {
        return this.jsonNodeType;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String getText() {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
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

    @Override
    public JsonNode build() {
        return this;
    }
}

