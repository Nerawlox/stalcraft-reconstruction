/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonStringNode;

public final class JsonField {
    private final JsonStringNode name;
    private final JsonNode value;

    public JsonField(JsonStringNode name2, JsonNode value) {
        this.name = name2;
        this.value = value;
    }

    JsonStringNode getName() {
        return this.name;
    }

    JsonNode getValue() {
        return this.value;
    }
}

