/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

public class FakeChunkPosition
extends xtcd {
    private static FakeChunkPosition _g = new FakeChunkPosition(0, 0, 0);
    public int _a;
    public int _b;
    public int _c;

    public static FakeChunkPosition get(int n, int n2, int n3) {
        FakeChunkPosition._g._a = n;
        FakeChunkPosition._g._b = n2;
        FakeChunkPosition._g._c = n3;
        return _g;
    }

    public FakeChunkPosition(int n, int n2, int n3) {
        super(0, 0, 0);
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public int hashCode() {
        return this._a * 8976890 + this._b * 981131 + this._c;
    }
}

