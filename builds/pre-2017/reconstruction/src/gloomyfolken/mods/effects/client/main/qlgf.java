/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.mcsa.ezfa;
import java.util.LinkedList;
import java.util.function.Supplier;

public class qlgf<T extends kjui> {
    private final Supplier<T> _a;
    private LinkedList<T> _b = new LinkedList();

    public qlgf(Supplier<T> supplier) {
        this._a = supplier;
    }

    public T _a() {
        if (this._b.isEmpty()) {
            kjui kjui2 = (kjui)this._a.get();
            kjui2.parentPool = this;
            return (T)kjui2;
        }
        return (T)((kjui)this._b.pollFirst());
    }

    public static abstract class kjui
    extends ezfa.pidb {
        protected qlgf parentPool;

        @Override
        protected void clear() {
            this.parentPool._b.add(this);
        }
    }
}

