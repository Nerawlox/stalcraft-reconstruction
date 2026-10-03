/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import argo.jdom.JsonNodeDoesNotMatchPathElementsException;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonNodeSelector;
import argo.jdom.JsonNodeSelectors;
import argo.jdom.JsonNodeType;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.util.List;
import java.util.Map;

public abstract class JsonNode {
    JsonNode() {
    }

    public abstract JsonNodeType getType();

    public abstract boolean hasText();

    public abstract String getText();

    public abstract boolean hasFields();

    public abstract Map<JsonStringNode, JsonNode> getFields();

    public abstract boolean hasElements();

    public abstract List<JsonNode> getElements();

    public boolean isNode(Object ... pathElements) {
        return JsonNodeSelectors.anyNode(pathElements).matches(this);
    }

    public JsonNode getNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.anyNode(pathElements), this, pathElements);
    }

    public boolean isRootNode(Object ... pathElements) {
        return JsonNodeSelectors.anyRootNode(pathElements).matches(this);
    }

    public JsonRootNode getRootNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.anyRootNode(pathElements), this, pathElements);
    }

    public final boolean isBooleanValue(Object ... pathElements) {
        return JsonNodeSelectors.aBooleanNode(pathElements).matches(this);
    }

    public final Boolean getBooleanValue(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aBooleanNode(pathElements), this, pathElements);
    }

    public final boolean isNullableBooleanValue(Object ... pathElements) {
        return JsonNodeSelectors.aNullableBooleanNode(pathElements).matches(this);
    }

    public final Boolean getNullableBooleanValue(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNullableBooleanNode(pathElements), this, pathElements);
    }

    public final boolean isStringValue(Object ... pathElements) {
        return JsonNodeSelectors.aStringNode(pathElements).matches(this);
    }

    public final String getStringValue(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aStringNode(pathElements), this, pathElements);
    }

    public final boolean isNullableStringValue(Object ... pathElements) {
        return JsonNodeSelectors.aNullableStringNode(pathElements).matches(this);
    }

    public final String getNullableStringValue(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNullableStringNode(pathElements), this, pathElements);
    }

    public final boolean isNumberValue(Object ... pathElements) {
        return JsonNodeSelectors.aNumberNode(pathElements).matches(this);
    }

    public final String getNumberValue(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNumberNode(pathElements), this, pathElements);
    }

    public final boolean isNullableNumberNode(Object ... pathElements) {
        return JsonNodeSelectors.aNullableNumberNode(pathElements).matches(this);
    }

    public final String getNullableNumberValue(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNullableNumberNode(pathElements), this, pathElements);
    }

    public final boolean isNullNode(Object ... pathElements) {
        return JsonNodeSelectors.aNullNode(pathElements).matches(this);
    }

    public final JsonNode getNullNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNullNode(pathElements), this, pathElements);
    }

    public final boolean isObjectNode(Object ... pathElements) {
        return JsonNodeSelectors.anObjectNode(pathElements).matches(this);
    }

    public final Map<JsonStringNode, JsonNode> getObjectNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.anObjectNode(pathElements), this, pathElements);
    }

    public final boolean isNullableObjectNode(Object ... pathElements) {
        return JsonNodeSelectors.aNullableObjectNode(pathElements).matches(this);
    }

    public final Map<JsonStringNode, JsonNode> getNullableObjectNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNullableObjectNode(pathElements), this, pathElements);
    }

    public final boolean isArrayNode(Object ... pathElements) {
        return JsonNodeSelectors.anArrayNode(pathElements).matches(this);
    }

    public final List<JsonNode> getArrayNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.anArrayNode(pathElements), this, pathElements);
    }

    public final boolean isNullableArrayNode(Object ... pathElements) {
        return JsonNodeSelectors.aNullableArrayNode(pathElements).matches(this);
    }

    public final List<JsonNode> getNullableArrayNode(Object ... pathElements) {
        return this.wrapExceptionsFor(JsonNodeSelectors.aNullableArrayNode(pathElements), this, pathElements);
    }

    private <T, V extends JsonNode> T wrapExceptionsFor(JsonNodeSelector<V, T> value, V node, Object[] pathElements) throws JsonNodeDoesNotMatchPathElementsException {
        try {
            return value.getValue(node);
        }
        catch (JsonNodeDoesNotMatchChainedJsonNodeSelectorException e) {
            throw JsonNodeDoesNotMatchPathElementsException.jsonNodeDoesNotMatchPathElementsException(e, pathElements, JsonNodeFactories.array(node));
        }
    }
}

