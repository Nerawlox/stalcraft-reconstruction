/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.Functor;
import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;

abstract class LeafFunctor<T, V>
implements Functor<T, V> {
    LeafFunctor() {
    }

    @Override
    public final V applyTo(T jsonNode) {
        if (!this.matchesNode(jsonNode)) {
            throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.createJsonNodeDoesNotMatchJsonNodeSelectorException(this);
        }
        return this.typeSafeApplyTo(jsonNode);
    }

    protected abstract V typeSafeApplyTo(T var1);
}

