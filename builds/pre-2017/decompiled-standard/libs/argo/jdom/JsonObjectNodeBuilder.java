/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class JsonObjectNodeBuilder
implements JsonNodeBuilder<JsonRootNode> {
    private final List<JsonFieldBuilder> fieldBuilders = new LinkedList<JsonFieldBuilder>();

    JsonObjectNodeBuilder() {
    }

    public JsonObjectNodeBuilder withField(String name2, JsonNodeBuilder value) {
        return this.withField(JsonNodeFactories.string(name2), value);
    }

    public JsonObjectNodeBuilder withField(JsonStringNode name2, JsonNodeBuilder value) {
        return this.withFieldBuilder(JsonFieldBuilder.aJsonFieldBuilder().withKey(name2).withValue(value));
    }

    public JsonObjectNodeBuilder withFieldBuilder(JsonFieldBuilder jsonFieldBuilder) {
        this.fieldBuilders.add(jsonFieldBuilder);
        return this;
    }

    @Override
    public JsonRootNode build() {
        return JsonNodeFactories.object((Map<JsonStringNode, JsonNode>)new HashMap<JsonStringNode, JsonNode>(){
            {
                for (JsonFieldBuilder fieldBuilder : JsonObjectNodeBuilder.this.fieldBuilders) {
                    this.put(fieldBuilder.buildKey(), fieldBuilder.buildValue());
                }
            }
        });
    }
}

