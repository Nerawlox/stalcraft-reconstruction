/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;

public class tvqg {
    public final ByteBuffer _a;
    public final int _b;
    public final int _c;

    public tvqg(ByteBuffer byteBuffer, int n, int n2) {
        this._a = byteBuffer;
        this._b = n;
        this._c = n2;
    }

    public ByteBuffer _a() {
        this._a.limit(this._b + this._c);
        this._a.position(this._b);
        return this._a;
    }

    public terj _b() {
        return new terj(this._a());
    }

    public hbom _c() {
        return new hbom(this._b());
    }
}

