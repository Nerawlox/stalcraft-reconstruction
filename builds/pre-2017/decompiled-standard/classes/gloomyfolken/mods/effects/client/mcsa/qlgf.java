/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.jxtc;
import java.io.DataInput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class qlgf
extends iess {
    public final jxtc _a;
    private tvqg _v;
    private tvqg _w;
    private ByteBuffer _x;
    private ByteBuffer _y;
    tvlz _b;
    tvlz _c;
    int _d;
    int _e;
    int _f;
    int _g;
    int _h;
    int _i;
    int _j;
    private static final boolean _z = true;

    public qlgf(jxtc jxtc2, String string, String string2, int n, short[] sArray, int n2, int n3, float f) {
        super(jxtc2, string, string2, n, sArray, n2, n3, f);
        this._a = jxtc2;
    }

    @Override
    protected void _a(ByteBuffer byteBuffer, hbom hbom2) throws IOException {
        int n;
        if (this._a.getFileVersion() < 7.0f) {
            throw new IOException("Only 7.0 models can be loaded to OGL");
        }
        this._d = this._f();
        this._e = n = 0;
        n += this._n * 8;
        if (this._a.hasUvs()) {
            this._g = n;
            n += this._n * 4;
        }
        if (this._a.hasNormals()) {
            this._f = n;
            n += this._n * 4;
        }
        if (this._a.hasTangents()) {
            this._h = n;
            n += this._n * 4;
        }
        if (this._r) {
            this._i = n;
            n += this._n * 4;
            if (this._s >= 3) {
                this._j = n;
                n += this._n * 4;
            }
        }
        int n2 = this._d * this._n;
        int n3 = this._q * (this._e() ? 4 : 2);
        this._v = new tvqg(byteBuffer, byteBuffer.position(), n2);
        hbom2.skipBytes(n2);
        this._w = new tvqg(byteBuffer, byteBuffer.position(), n3);
        hbom2.skipBytes(n3);
    }

    void _a() {
        this._b = new tvlz(34962, 35044, this._v._c);
        this._x = this._b._a(0, this._b._c, false, false);
        this._b._b();
        this._c = new tvlz(34963, 35044, this._w._c);
        this._y = this._c._a(0, this._c._c, false, false);
        this._c._b();
    }

    void _b() {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this._x.put(this._v._a());
            this._y.put(this._w._a());
        } else {
            try {
                this._a(this._v._c(), this._x);
                this._b(this._w._c(), this._y);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    void _c() {
        this._b._d();
        this._b._b();
        this._c._d();
        this._c._b();
    }

    private void _a(hbom hbom2, ByteBuffer byteBuffer) throws IOException {
        int n;
        for (n = 0; n < this._n; ++n) {
            this._b(hbom2, byteBuffer, 4);
        }
        if (this._a.hasUvs()) {
            for (n = 0; n < this._n; ++n) {
                this._b(hbom2, byteBuffer, 2);
            }
        }
        if (this._a.hasNormals()) {
            for (n = 0; n < this._n; ++n) {
                this._a(hbom2, byteBuffer, 4);
            }
        }
        if (this._a.hasTangents()) {
            for (n = 0; n < this._n; ++n) {
                this._a(hbom2, byteBuffer, 4);
            }
        }
        if (this._a.isAnimated()) {
            for (n = 0; n < this._n; ++n) {
                this._a(hbom2, byteBuffer, 4);
            }
            if (this._s >= 3) {
                for (n = 0; n < this._n; ++n) {
                    this._a(hbom2, byteBuffer, 4);
                }
            }
        }
    }

    private void _b(hbom hbom2, ByteBuffer byteBuffer) throws IOException {
        if (this._e()) {
            for (int i = 0; i < this._q; ++i) {
                byteBuffer.putInt(hbom2.readInt());
            }
        } else {
            for (int i = 0; i < this._q; ++i) {
                byteBuffer.putShort(hbom2.readShort());
            }
        }
    }

    private void _a(DataInput dataInput, ByteBuffer byteBuffer, int n) throws IOException {
        for (int i = 0; i < n; ++i) {
            byteBuffer.put(dataInput.readByte());
        }
    }

    private void _b(DataInput dataInput, ByteBuffer byteBuffer, int n) throws IOException {
        for (int i = 0; i < n; ++i) {
            byteBuffer.putShort(dataInput.readShort());
        }
    }

    @Override
    protected void _d() {
        this._b._e();
        this._c._e();
        this._b = null;
        this._c = null;
    }

    public String toString() {
        return this._l;
    }
}

