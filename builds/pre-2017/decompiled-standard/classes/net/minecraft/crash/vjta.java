/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.Comparator;
import net.minecraft.crash.xpzm;

public class vjta
implements Comparator {
    public final /* synthetic */ xpzm _a;

    public vjta(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public int _a(Class clazz, Class clazz2) {
        String string = clazz.getPackage() == null ? "" : clazz.getPackage().getName();
        String string2 = clazz2.getPackage() == null ? "" : clazz2.getPackage().getName();
        return string.compareTo(string2);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((Class)object, (Class)object2);
    }
}

