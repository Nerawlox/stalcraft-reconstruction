/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.AbstractJsonObject;
import argo.jdom.JsonNode;
import argo.jdom.JsonStringNode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class JsonObject
extends AbstractJsonObject {
    private final Map<JsonStringNode, JsonNode> fields;

    JsonObject(Map<JsonStringNode, JsonNode> fields2) {
        this.fields = Collections.unmodifiableMap(new HashMap<JsonStringNode, JsonNode>(fields2));
    }

    @Override
    public Map<JsonStringNode, JsonNode> getFields() {
        return this.fields;
    }
}

