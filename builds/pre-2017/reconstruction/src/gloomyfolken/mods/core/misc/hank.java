/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.samo;
import java.util.function.Function;

public class hank<K, R>
extends samo<K, Function<K, R>> {
    public hank(Class clazz) {
        super(clazz);
    }

    public <E extends K> void _a(Class<E> clazz, Function<E, R> function) {
        this._b.put(clazz, function);
    }
}

