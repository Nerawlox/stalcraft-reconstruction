/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.interfaces.Sheet;
import java.util.ArrayList;
import java.util.List;

public class GenericSheet<T>
implements Sheet<T> {
    private final List<T> values;
    private final int count;
    private final List<Integer> versions;

    public GenericSheet(int n, T t) {
        this.values = new ArrayList<T>(n);
        this.count = n;
        this.versions = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
            this.values.add(t);
            this.versions.add(0);
        }
    }

    @Override
    public T get(int n) {
        return this.values.get(n);
    }

    @Override
    public void set(int n, T t) {
        if (!t.equals(this.values.get(n))) {
            this.values.set(n, t);
            this.versions.set(n, this.versions.get(n) + 1);
        }
    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public int getVersionOf(int n) {
        return this.versions.get(n);
    }
}

