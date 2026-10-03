/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.AbstractJsonArray;
import argo.jdom.JsonNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class JsonArray
extends AbstractJsonArray {
    private final List<JsonNode> elements;

    JsonArray(final Iterable<JsonNode> elements) {
        this.elements = Collections.unmodifiableList(new ArrayList<JsonNode>(){
            {
                for (JsonNode element : elements) {
                    this.add(element);
                }
            }
        });
    }

    @Override
    public List<JsonNode> getElements() {
        return this.elements;
    }
}

