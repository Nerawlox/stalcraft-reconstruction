/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.pcollections;

import kotlin.reflect.jvm.internal.pcollections.IntTree;

final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = new IntTreePMap<Object>(IntTree.EMPTYNODE);
    private final IntTree<V> root;

    public static <V> IntTreePMap<V> empty() {
        return EMPTY;
    }

    private IntTreePMap(IntTree<V> root) {
        this.root = root;
    }

    private IntTreePMap<V> withRoot(IntTree<V> root) {
        if (root == this.root) {
            return this;
        }
        return new IntTreePMap<V>(root);
    }

    public V get(int key) {
        return this.root.get(key);
    }

    public IntTreePMap<V> plus(int key, V value) {
        return this.withRoot(this.root.plus(key, value));
    }

    public IntTreePMap<V> minus(int key) {
        return this.withRoot(this.root.minus(key));
    }
}

