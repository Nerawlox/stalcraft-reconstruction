/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.format.CompactJsonFormatter;
import argo.format.JsonFormatter;
import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import argo.jdom.JsonNodeDoesNotMatchJsonNodeSelectorException;
import argo.jdom.JsonRootNode;

public final class JsonNodeDoesNotMatchPathElementsException
extends JsonNodeDoesNotMatchJsonNodeSelectorException {
    private static final JsonFormatter JSON_FORMATTER = new CompactJsonFormatter();

    static JsonNodeDoesNotMatchPathElementsException jsonNodeDoesNotMatchPathElementsException(JsonNodeDoesNotMatchChainedJsonNodeSelectorException delegate, Object[] pathElements, JsonRootNode rootNode) {
        return new JsonNodeDoesNotMatchPathElementsException(delegate, pathElements, rootNode);
    }

    private JsonNodeDoesNotMatchPathElementsException(JsonNodeDoesNotMatchChainedJsonNodeSelectorException delegate, Object[] pathElements, JsonRootNode rootNode) {
        super(JsonNodeDoesNotMatchPathElementsException.formatMessage(delegate, pathElements, rootNode));
    }

    private static String formatMessage(JsonNodeDoesNotMatchChainedJsonNodeSelectorException delegate, Object[] pathElements, JsonRootNode rootNode) {
        return "Failed to find " + delegate.failedNode.toString() + " at [" + JsonNodeDoesNotMatchChainedJsonNodeSelectorException.getShortFormFailPath(delegate.failPath) + "] while resolving [" + JsonNodeDoesNotMatchPathElementsException.commaSeparate(pathElements) + "] in " + JSON_FORMATTER.format(rootNode) + ".";
    }

    private static String commaSeparate(Object[] pathElements) {
        StringBuilder result2 = new StringBuilder();
        boolean firstElement = true;
        for (Object pathElement : pathElements) {
            if (!firstElement) {
                result2.append(".");
            }
            firstElement = false;
            if (pathElement instanceof String) {
                result2.append("\"").append(pathElement).append("\"");
                continue;
            }
            result2.append(pathElement);
        }
        return result2.toString();
    }
}

