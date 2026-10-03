/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonRootNode;
import java.util.LinkedList;
import java.util.List;

public final class JsonArrayNodeBuilder
implements JsonNodeBuilder<JsonRootNode> {
    private final List<JsonNodeBuilder> elementBuilders = new LinkedList<JsonNodeBuilder>();

    JsonArrayNodeBuilder() {
    }

    public JsonArrayNodeBuilder withElement(JsonNodeBuilder elementBuilder) {
        this.elementBuilders.add(elementBuilder);
        return this;
    }

    @Override
    public JsonRootNode build() {
        LinkedList<JsonNode> elements = new LinkedList<JsonNode>();
        for (JsonNodeBuilder elementBuilder : this.elementBuilders) {
            elements.add((JsonNode)elementBuilder.build());
        }
        return JsonNodeFactories.array(elements);
    }
}

