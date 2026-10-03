/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.Functor;
import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import argo.jdom.JsonNodeSelector;

final class ChainedFunctor<T, U, V>
implements Functor<T, V> {
    private final JsonNodeSelector<T, U> parentJsonNodeSelector;
    private final JsonNodeSelector<U, V> childJsonNodeSelector;

    ChainedFunctor(JsonNodeSelector<T, U> parentJsonNodeSelector, JsonNodeSelector<U, V> childJsonNodeSelector) {
        this.parentJsonNodeSelector = parentJsonNodeSelector;
        this.childJsonNodeSelector = childJsonNodeSelector;
    }

    @Override
    public boolean matchesNode(T jsonNode) {
        return this.parentJsonNodeSelector.matches(jsonNode) && this.childJsonNodeSelector.matches(this.parentJsonNodeSelector.getValue(jsonNode));
    }

    @Override
    public V applyTo(T jsonNode) {
        V value;
        U parent;
        try {
            parent = this.parentJsonNodeSelector.getValue(jsonNode);
        }
        catch (JsonNodeDoesNotMatchChainedJsonNodeSelectorException e) {
            throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.createUnchainedJsonNodeDoesNotMatchJsonNodeSelectorException(e, this.parentJsonNodeSelector);
        }
        try {
            value = this.childJsonNodeSelector.getValue(parent);
        }
        catch (JsonNodeDoesNotMatchChainedJsonNodeSelectorException e) {
            throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.createChainedJsonNodeDoesNotMatchJsonNodeSelectorException(e, this.parentJsonNodeSelector);
        }
        return value;
    }

    @Override
    public String shortForm() {
        return this.childJsonNodeSelector.shortForm();
    }

    public String toString() {
        return this.parentJsonNodeSelector.toString() + ", with " + this.childJsonNodeSelector.toString();
    }
}

