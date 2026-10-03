/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonArrayNodeBuilder;
import argo.jdom.JsonConstants;
import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNumberNode;
import argo.jdom.JsonObjectNodeBuilder;
import argo.jdom.JsonStringNode;

public final class JsonNodeBuilders {
    private JsonNodeBuilders() {
    }

    public static JsonNodeBuilder<JsonNode> aNullBuilder() {
        return JsonConstants.NULL;
    }

    public static JsonNodeBuilder<JsonNode> aTrueBuilder() {
        return JsonConstants.TRUE;
    }

    public static JsonNodeBuilder<JsonNode> aFalseBuilder() {
        return JsonConstants.FALSE;
    }

    public static JsonNodeBuilder<JsonNode> aNumberBuilder(String value) {
        return new JsonNumberNode(value);
    }

    public static JsonNodeBuilder<JsonStringNode> aStringBuilder(String value) {
        return new JsonStringNode(value);
    }

    public static JsonObjectNodeBuilder anObjectBuilder() {
        return new JsonObjectNodeBuilder();
    }

    public static JsonArrayNodeBuilder anArrayBuilder() {
        return new JsonArrayNodeBuilder();
    }
}

