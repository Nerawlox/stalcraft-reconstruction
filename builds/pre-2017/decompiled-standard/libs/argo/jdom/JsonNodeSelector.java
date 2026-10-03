/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

import argo.jdom.ChainedFunctor;
import argo.jdom.Functor;

public final class JsonNodeSelector<T, U> {
    private final Functor<T, U> valueGetter;

    JsonNodeSelector(Functor<T, U> valueGetter) {
        this.valueGetter = valueGetter;
    }

    public boolean matches(T jsonNode) {
        return this.valueGetter.matchesNode(jsonNode);
    }

    public U getValue(T argument) {
        return this.valueGetter.applyTo(argument);
    }

    public <V> JsonNodeSelector<T, V> with(JsonNodeSelector<U, V> childJsonNodeSelector) {
        return new JsonNodeSelector<T, U>(new ChainedFunctor(this, childJsonNodeSelector));
    }

    String shortForm() {
        return this.valueGetter.shortForm();
    }

    public String toString() {
        return this.valueGetter.toString();
    }
}

