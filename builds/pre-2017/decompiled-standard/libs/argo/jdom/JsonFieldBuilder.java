/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonStringNode;

final class JsonFieldBuilder {
    private JsonStringNode key;
    private JsonNodeBuilder valueBuilder;

    private JsonFieldBuilder() {
    }

    static JsonFieldBuilder aJsonFieldBuilder() {
        return new JsonFieldBuilder();
    }

    JsonFieldBuilder withKey(JsonStringNode jsonStringNode) {
        this.key = jsonStringNode;
        return this;
    }

    JsonFieldBuilder withValue(JsonNodeBuilder jsonNodeBuilder) {
        this.valueBuilder = jsonNodeBuilder;
        return this;
    }

    JsonStringNode buildKey() {
        return this.key;
    }

    JsonNode buildValue() {
        return this.valueBuilder.build();
    }
}

