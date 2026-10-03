/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;

public class rrvf
extends ByteArrayOutputStream {
    public int _a;
    public int _b;
    public final /* synthetic */ nfjd _c;

    public rrvf(nfjd nfjd2, int n, int n2) {
        this._c = nfjd2;
        super(8096);
        this._a = n;
        this._b = n2;
    }

    @Override
    public void close() {
        this._c._a(this._a, this._b, this.buf, this.count);
    }
}

