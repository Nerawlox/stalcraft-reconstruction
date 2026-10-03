/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;
import net.minecraft.world.gen.structure.MapGenStructure;

public class CallableIsFeatureChunk
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ MapGenStructure _c;

    public CallableIsFeatureChunk(MapGenStructure mapGenStructure, int n, int n2) {
        this._c = mapGenStructure;
        this._a = n;
        this._b = n2;
    }

    public String _a() {
        return this._c._a(this._a, this._b) ? "True" : "False";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

