/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.pidb;

public final class kjui
extends ThreadLocal {
    public pidb _a() {
        return new pidb(300, 2000);
    }

    public /* synthetic */ Object initialValue() {
        return this._a();
    }
}

