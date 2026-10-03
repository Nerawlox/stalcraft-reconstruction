/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.JsonRootNode;
import java.util.List;

public abstract class AbstractJsonObject
extends JsonRootNode {
    @Override
    public JsonNodeType getType() {
        return JsonNodeType.OBJECT;
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
        return true;
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
        if (that == null || !AbstractJsonObject.class.isAssignableFrom(that.getClass())) {
            return false;
        }
        AbstractJsonObject thatJsonObject = (AbstractJsonObject)that;
        return ((Object)this.getFields()).equals(thatJsonObject.getFields());
    }

    public int hashCode() {
        return ((Object)this.getFields()).hashCode();
    }

    public String toString() {
        return "JsonObject fields:[" + this.getFields() + "]";
    }
}

