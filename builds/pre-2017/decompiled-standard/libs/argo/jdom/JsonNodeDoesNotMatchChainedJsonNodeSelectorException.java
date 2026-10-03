/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.Functor;
import argo.jdom.JsonNodeDoesNotMatchJsonNodeSelectorException;
import argo.jdom.JsonNodeSelector;
import java.util.LinkedList;
import java.util.List;

final class JsonNodeDoesNotMatchChainedJsonNodeSelectorException
extends JsonNodeDoesNotMatchJsonNodeSelectorException {
    final Functor failedNode;
    final List<JsonNodeSelector> failPath;

    static JsonNodeDoesNotMatchJsonNodeSelectorException createJsonNodeDoesNotMatchJsonNodeSelectorException(Functor failedNode) {
        return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(failedNode, new LinkedList<JsonNodeSelector>());
    }

    static JsonNodeDoesNotMatchJsonNodeSelectorException createChainedJsonNodeDoesNotMatchJsonNodeSelectorException(JsonNodeDoesNotMatchChainedJsonNodeSelectorException e, JsonNodeSelector parentJsonNodeSelector) {
        LinkedList<JsonNodeSelector> chainedFailPath = new LinkedList<JsonNodeSelector>(e.failPath);
        chainedFailPath.add(parentJsonNodeSelector);
        return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(e.failedNode, chainedFailPath);
    }

    static JsonNodeDoesNotMatchJsonNodeSelectorException createUnchainedJsonNodeDoesNotMatchJsonNodeSelectorException(JsonNodeDoesNotMatchChainedJsonNodeSelectorException e, JsonNodeSelector parentJsonNodeSelector) {
        LinkedList<JsonNodeSelector> unchainedFailPath = new LinkedList<JsonNodeSelector>();
        unchainedFailPath.add(parentJsonNodeSelector);
        return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(e.failedNode, unchainedFailPath);
    }

    private JsonNodeDoesNotMatchChainedJsonNodeSelectorException(Functor failedNode, List<JsonNodeSelector> failPath) {
        super("Failed to match any JSON node at [" + JsonNodeDoesNotMatchChainedJsonNodeSelectorException.getShortFormFailPath(failPath) + "]");
        this.failedNode = failedNode;
        this.failPath = failPath;
    }

    static String getShortFormFailPath(List<JsonNodeSelector> failPath) {
        StringBuilder result2 = new StringBuilder();
        for (int i = failPath.size() - 1; i >= 0; --i) {
            result2.append(failPath.get(i).shortForm());
            if (i == 0) continue;
            result2.append(".");
        }
        return result2.toString();
    }

    @Override
    public String toString() {
        return "JsonNodeDoesNotMatchJsonNodeSelectorException{failedNode=" + this.failedNode + ", failPath=" + this.failPath + '}';
    }
}

