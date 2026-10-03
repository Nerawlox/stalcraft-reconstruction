/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.util.Map;

abstract class AbstractJsonArray
extends JsonRootNode {
    AbstractJsonArray() {
    }

    @Override
    public JsonNodeType getType() {
        return JsonNodeType.ARRAY;
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
        return true;
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || !AbstractJsonArray.class.isAssignableFrom(that.getClass())) {
            return false;
        }
        AbstractJsonArray thatJsonArray = (AbstractJsonArray)that;
        return ((Object)this.getElements()).equals(thatJsonArray.getElements());
    }

    public int hashCode() {
        return ((Object)this.getElements()).hashCode();
    }

    public String toString() {
        return "JsonArray elements:[" + this.getElements() + "]";
    }
}

