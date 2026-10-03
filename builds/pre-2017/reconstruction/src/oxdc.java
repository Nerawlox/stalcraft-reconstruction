/*
 * Decompiled with CFR 0.152.
 */
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class oxdc {
    protected static final byte[] _a = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    protected static final int _b = 1229472850;
    protected static final int _c = 1347179589;
    protected static final int _d = 1951551059;
    protected static final int _e = 1229209940;
    protected static final int _f = 1229278788;
    protected static final byte _g = 0;
    protected static final byte _h = 2;
    protected static final byte _i = 3;
    protected static final byte _j = 4;
    protected static final byte _k = 6;
    protected InputStream _l;
    protected final CRC32 _m;
    protected final byte[] _n;
    protected int _o;
    protected int _p;
    protected int _q;
    protected int _r;
    protected int _s;
    protected int _t;
    protected int _u;
    protected int _v;
    protected byte[] _w;
    protected byte[] _x;
    protected byte[] _y;

    public oxdc(InputStream inputStream) throws IOException {
        this._l = inputStream;
        this._m = new CRC32();
        this._n = new byte[4096];
        this._b(this._n, 0, _a.length);
        if (!oxdc._b(this._n)) {
            throw new IOException("Not a valid PNG file");
        }
        this._a(1229472850);
        this._g();
        this._j();
        while (true) {
            this._k();
            switch (this._p) {
                case 1229209940: {
                    if (this._u == 3 && this._w == null) {
                        throw new IOException("Missing PLTE chunk");
                    }
                    return;
                }
                case 1347179589: {
                    this._h();
                    break;
                }
                case 1951551059: {
                    this._i();
                }
            }
            this._j();
        }
    }

    public int _a() {
        return this._s;
    }

    public int _b() {
        return this._r;
    }

    public boolean _c() {
        return this._u == 6 || this._u == 4;
    }

    public boolean _d() {
        return this._c() || this._x != null || this._y != null;
    }

    public boolean _e() {
        return this._u == 6 || this._u == 2 || this._u == 3;
    }

    public void _a(byte by, byte by2, byte by3) {
        if (this._c()) {
            throw new UnsupportedOperationException("image has an alpha channel");
        }
        byte[] byArray = this._w;
        if (byArray == null) {
            this._y = new byte[]{0, by, 0, by2, 0, by3};
        } else {
            this._x = new byte[byArray.length / 3];
            int n = 0;
            int n2 = 0;
            while (n < byArray.length) {
                if (byArray[n] != by || byArray[n + 1] != by2 || byArray[n + 2] != by3) {
                    this._x[n2] = -1;
                }
                n += 3;
                ++n2;
            }
        }
    }

    public ivqx _a(ivqx ivqx2) {
        switch (this._u) {
            case 0: {
                switch (ivqx2) {
                    case _b: 
                    case _a: {
                        return ivqx2;
                    }
                }
                return ivqx._b;
            }
            default: {
                throw new UnsupportedOperationException("Not yet implemented");
            }
            case 2: {
                switch (ivqx2) {
                    case _a: {
                        break;
                    }
                    case _b: {
                        break;
                    }
                    case _c: {
                        break;
                    }
                    case _e: 
                    case _f: 
                    case _d: {
                        return ivqx2;
                    }
                    default: {
                        return ivqx._d;
                    }
                }
            }
            case 3: {
                switch (ivqx2) {
                    case _e: 
                    case _f: {
                        return ivqx2;
                    }
                }
                return ivqx._e;
            }
            case 4: {
                return ivqx._c;
            }
            case 6: 
        }
        switch (ivqx2) {
            case _e: 
            case _f: 
            case _d: {
                return ivqx2;
            }
        }
        return ivqx._e;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(ByteBuffer byteBuffer, ivqx ivqx2) throws IOException {
        int n = this._b() * ivqx2._g;
        int n2 = (this._r * this._t + 7) / 8 * this._v;
        byte[] byArray = new byte[n2 + 1];
        byte[] byArray2 = new byte[n2 + 1];
        byte[] byArray3 = this._t < 8 ? new byte[this._r + 1] : null;
        Inflater inflater = new Inflater();
        try {
            for (int i = 0; i < this._s; ++i) {
                this._a(inflater, byArray, 0, byArray.length);
                this._d(byArray, byArray2);
                int n3 = i * n - byteBuffer.position();
                if (n3 < 0) {
                    throw new UnsupportedOperationException("Negative num bytes to skip");
                }
                if (n3 > 0) {
                    byteBuffer.position(byteBuffer.position() + n3);
                }
                block1 : switch (this._u) {
                    case 0: {
                        switch (ivqx2) {
                            case _b: 
                            case _c: {
                                this._a(byteBuffer, byArray);
                                break block1;
                            }
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    default: {
                        throw new UnsupportedOperationException("Not yet implemented");
                    }
                    case 2: {
                        switch (ivqx2) {
                            case _e: {
                                this._e(byteBuffer, byArray);
                                break block1;
                            }
                            case _f: {
                                this._f(byteBuffer, byArray);
                                break block1;
                            }
                            case _d: {
                                this._d(byteBuffer, byArray);
                                break block1;
                            }
                            case _c: {
                                this._g(byteBuffer, byArray);
                                break block1;
                            }
                            case _b: 
                            case _a: {
                                this._h(byteBuffer, byArray);
                                break block1;
                            }
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 3: {
                        switch (this._t) {
                            case 1: {
                                this._c(byArray, byArray3);
                                break;
                            }
                            case 2: {
                                this._b(byArray, byArray3);
                                break;
                            }
                            default: {
                                throw new UnsupportedOperationException("Unsupported bitdepth for this image");
                            }
                            case 4: {
                                this._a(byArray, byArray3);
                                break;
                            }
                            case 8: {
                                byArray3 = byArray;
                            }
                        }
                        switch (ivqx2) {
                            case _e: {
                                this._o(byteBuffer, byArray3);
                                break block1;
                            }
                            case _f: {
                                this._p(byteBuffer, byArray3);
                                break block1;
                            }
                            case _d: {
                                this._q(byteBuffer, byArray3);
                                break block1;
                            }
                            case _c: {
                                this._r(byteBuffer, byArray3);
                                break block1;
                            }
                            case _b: 
                            case _a: {
                                this._s(byteBuffer, byArray3);
                                break block1;
                            }
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 4: {
                        switch (ivqx2) {
                            case _c: {
                                this._a(byteBuffer, byArray);
                                break block1;
                            }
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 6: {
                        switch (ivqx2) {
                            case _e: {
                                this._c(byteBuffer, byArray);
                                break block1;
                            }
                            case _f: {
                                this._j(byteBuffer, byArray);
                                break block1;
                            }
                            case _d: {
                                this._k(byteBuffer, byArray);
                                break block1;
                            }
                            case _c: {
                                this._l(byteBuffer, byArray);
                                break block1;
                            }
                            case _b: 
                            case _a: {
                                this._m(byteBuffer, byArray);
                                break block1;
                            }
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                }
                byte[] byArray4 = byArray;
                byArray = byArray2;
                byArray2 = byArray4;
            }
        }
        finally {
            inflater.end();
        }
    }

    public boolean _f() {
        if (this._u != 3) {
            return false;
        }
        for (int i = 0; i < this._w.length; i += 3) {
            if (this._w[i] == this._w[i + 1] && this._w[i] == this._w[i + 2]) continue;
            return false;
        }
        return true;
    }

    protected void _a(ByteBuffer byteBuffer, byte[] byArray) {
        byteBuffer.put(byArray, 1, byArray.length - 1);
    }

    protected void _b(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._y != null) {
            byte by = this._y[1];
            byte by2 = this._y[3];
            byte by3 = this._y[5];
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byte by4 = byArray[i];
                byte by5 = byArray[i + 1];
                byte by6 = byArray[i + 2];
                byte by7 = -1;
                if (by4 == by && by5 == by2 && by6 == by3) {
                    by7 = 0;
                }
                byteBuffer.put(by7).put(by6).put(by5).put(by4);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byteBuffer.put((byte)-1).put(byArray[i + 2]).put(byArray[i + 1]).put(byArray[i]);
            }
        }
    }

    protected void _c(ByteBuffer byteBuffer, byte[] byArray) {
        byteBuffer.put(byArray, 1, byArray.length - 1);
    }

    protected void _d(ByteBuffer byteBuffer, byte[] byArray) {
        byteBuffer.put(byArray, 1, byArray.length - 1);
    }

    protected void _e(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._y != null) {
            byte by = this._y[1];
            byte by2 = this._y[3];
            byte by3 = this._y[5];
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byte by4 = byArray[i];
                byte by5 = byArray[i + 1];
                byte by6 = byArray[i + 2];
                byte by7 = -1;
                if (by4 == by && by5 == by2 && by6 == by3) {
                    by7 = 0;
                }
                byteBuffer.put(by4).put(by5).put(by6).put(by7);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byteBuffer.put(byArray[i]).put(byArray[i + 1]).put(byArray[i + 2]).put((byte)-1);
            }
        }
    }

    protected void _f(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._y != null) {
            byte by = this._y[1];
            byte by2 = this._y[3];
            byte by3 = this._y[5];
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byte by4 = byArray[i];
                byte by5 = byArray[i + 1];
                byte by6 = byArray[i + 2];
                byte by7 = -1;
                if (by4 == by && by5 == by2 && by6 == by3) {
                    by7 = 0;
                }
                byteBuffer.put(by6).put(by5).put(by4).put(by7);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byteBuffer.put(byArray[i + 2]).put(byArray[i + 1]).put(byArray[i]).put((byte)-1);
            }
        }
    }

    protected void _g(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 3) {
            byteBuffer.put(byArray[i]).put(byArray[i + 1]);
        }
    }

    protected void _h(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 3) {
            byteBuffer.put(byArray[i]);
        }
    }

    protected void _i(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i + 3]).put(byArray[i + 2]).put(byArray[i + 1]).put(byArray[i]);
        }
    }

    protected void _j(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i + 2]).put(byArray[i + 1]).put(byArray[i]).put(byArray[i + 3]);
        }
    }

    protected void _k(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i]).put(byArray[i + 1]).put(byArray[i + 2]);
        }
    }

    protected void _l(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i]).put(byArray[i + 1]);
        }
    }

    protected void _m(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i]);
        }
    }

    protected void _n(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._x != null) {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n2 = byArray[i] & 0xFF;
                byte by = this._w[n2 * 3 + 0];
                byte by2 = this._w[n2 * 3 + 1];
                byte by3 = this._w[n2 * 3 + 2];
                byte by4 = this._x[n2];
                byteBuffer.put(by4).put(by3).put(by2).put(by);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n3 = byArray[i] & 0xFF;
                byte by = this._w[n3 * 3 + 0];
                byte by5 = this._w[n3 * 3 + 1];
                byte by6 = this._w[n3 * 3 + 2];
                byte by7 = -1;
                byteBuffer.put(by7).put(by6).put(by5).put(by);
            }
        }
    }

    protected void _o(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._x != null) {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n2 = byArray[i] & 0xFF;
                byte by = this._w[n2 * 3 + 0];
                byte by2 = this._w[n2 * 3 + 1];
                byte by3 = this._w[n2 * 3 + 2];
                byte by4 = this._x[n2];
                byteBuffer.put(by).put(by2).put(by3).put(by4);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n3 = byArray[i] & 0xFF;
                byte by = this._w[n3 * 3 + 0];
                byte by5 = this._w[n3 * 3 + 1];
                byte by6 = this._w[n3 * 3 + 2];
                byte by7 = -1;
                byteBuffer.put(by).put(by5).put(by6).put(by7);
            }
        }
    }

    protected void _p(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._x != null) {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n2 = byArray[i] & 0xFF;
                byte by = this._w[n2 * 3 + 0];
                byte by2 = this._w[n2 * 3 + 1];
                byte by3 = this._w[n2 * 3 + 2];
                byte by4 = this._x[n2];
                byteBuffer.put(by3).put(by2).put(by).put(by4);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n3 = byArray[i] & 0xFF;
                byte by = this._w[n3 * 3 + 0];
                byte by5 = this._w[n3 * 3 + 1];
                byte by6 = this._w[n3 * 3 + 2];
                byte by7 = -1;
                byteBuffer.put(by6).put(by5).put(by).put(by7);
            }
        }
    }

    protected void _q(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; ++i) {
            int n2 = byArray[i] & 0xFF;
            byte by = this._w[n2 * 3 + 0];
            byte by2 = this._w[n2 * 3 + 1];
            byte by3 = this._w[n2 * 3 + 2];
            byteBuffer.put(by).put(by2).put(by3);
        }
    }

    protected void _r(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; ++i) {
            int n2 = byArray[i] & 0xFF;
            byte by = this._w[n2 * 3 + 0];
            byte by2 = this._w[n2 * 3 + 1];
            byteBuffer.put(by).put(by2);
        }
    }

    protected void _s(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; ++i) {
            int n2 = byArray[i] & 0xFF;
            byte by = this._w[n2 * 3 + 0];
            byteBuffer.put(by);
        }
    }

    protected void _a(byte[] byArray, byte[] byArray2) {
        int n = byArray2.length;
        for (int i = 1; i < n; i += 2) {
            int n2 = byArray[1 + (i >> 1)] & 0xFF;
            switch (n - i) {
                default: {
                    byArray2[i + 1] = (byte)(n2 & 0xF);
                }
                case 1: 
            }
            byArray2[i] = (byte)(n2 >> 4);
        }
    }

    protected void _b(byte[] byArray, byte[] byArray2) {
        int n = byArray2.length;
        for (int i = 1; i < n; i += 4) {
            int n2 = byArray[1 + (i >> 2)] & 0xFF;
            switch (n - i) {
                default: {
                    byArray2[i + 3] = (byte)(n2 & 3);
                }
                case 3: {
                    byArray2[i + 2] = (byte)(n2 >> 2 & 3);
                }
                case 2: {
                    byArray2[i + 1] = (byte)(n2 >> 4 & 3);
                }
                case 1: 
            }
            byArray2[i] = (byte)(n2 >> 6);
        }
    }

    protected void _c(byte[] byArray, byte[] byArray2) {
        int n = byArray2.length;
        for (int i = 1; i < n; i += 8) {
            int n2 = byArray[1 + (i >> 3)] & 0xFF;
            switch (n - i) {
                default: {
                    byArray2[i + 7] = (byte)(n2 & 1);
                }
                case 7: {
                    byArray2[i + 6] = (byte)(n2 >> 1 & 1);
                }
                case 6: {
                    byArray2[i + 5] = (byte)(n2 >> 2 & 1);
                }
                case 5: {
                    byArray2[i + 4] = (byte)(n2 >> 3 & 1);
                }
                case 4: {
                    byArray2[i + 3] = (byte)(n2 >> 4 & 1);
                }
                case 3: {
                    byArray2[i + 2] = (byte)(n2 >> 5 & 1);
                }
                case 2: {
                    byArray2[i + 1] = (byte)(n2 >> 6 & 1);
                }
                case 1: 
            }
            byArray2[i] = (byte)(n2 >> 7);
        }
    }

    protected void _d(byte[] byArray, byte[] byArray2) throws IOException {
        switch (byArray[0]) {
            case 0: {
                break;
            }
            case 1: {
                this._a(byArray);
                break;
            }
            case 2: {
                this._e(byArray, byArray2);
                break;
            }
            case 3: {
                this._f(byArray, byArray2);
                break;
            }
            case 4: {
                this._g(byArray, byArray2);
                break;
            }
            default: {
                throw new IOException("invalide filter type in scanline: " + byArray[0]);
            }
        }
    }

    protected void _a(byte[] byArray) {
        int n = this._v;
        int n2 = byArray.length;
        for (int i = n + 1; i < n2; ++i) {
            int n3 = i;
            byArray[n3] = (byte)(byArray[n3] + byArray[i - n]);
        }
    }

    protected void _e(byte[] byArray, byte[] byArray2) {
        int n = this._v;
        int n2 = byArray.length;
        for (int i = 1; i < n2; ++i) {
            int n3 = i;
            byArray[n3] = (byte)(byArray[n3] + byArray2[i]);
        }
    }

    protected void _f(byte[] byArray, byte[] byArray2) {
        int n;
        int n2 = this._v;
        for (n = 1; n <= n2; ++n) {
            int n3 = n;
            byArray[n3] = (byte)(byArray[n3] + (byte)((byArray2[n] & 0xFF) >>> 1));
        }
        int n4 = byArray.length;
        while (n < n4) {
            int n5 = n;
            byArray[n5] = (byte)(byArray[n5] + (byte)((byArray2[n] & 0xFF) + (byArray[n - n2] & 0xFF) >>> 1));
            ++n;
        }
    }

    protected void _g(byte[] byArray, byte[] byArray2) {
        int n;
        int n2 = this._v;
        for (n = 1; n <= n2; ++n) {
            int n3 = n;
            byArray[n3] = (byte)(byArray[n3] + byArray2[n]);
        }
        int n4 = byArray.length;
        while (n < n4) {
            int n5;
            int n6;
            int n7 = byArray[n - n2] & 0xFF;
            int n8 = byArray2[n] & 0xFF;
            int n9 = byArray2[n - n2] & 0xFF;
            int n10 = n7 + n8 - n9;
            int n11 = n10 - n7;
            if (n11 < 0) {
                n11 = -n11;
            }
            if ((n6 = n10 - n8) < 0) {
                n6 = -n6;
            }
            if ((n5 = n10 - n9) < 0) {
                n5 = -n5;
            }
            if (n11 <= n6 && n11 <= n5) {
                n9 = n7;
            } else if (n6 <= n5) {
                n9 = n8;
            }
            int n12 = n++;
            byArray[n12] = (byte)(byArray[n12] + (byte)n9);
        }
    }

    protected void _g() throws IOException {
        this._b(13);
        this._a(this._n, 0, 13);
        this._r = this._a(this._n, 0);
        this._s = this._a(this._n, 4);
        this._t = this._n[8] & 0xFF;
        this._u = this._n[9] & 0xFF;
        block0 : switch (this._u) {
            case 0: {
                if (this._t != 8) {
                    throw new IOException("Unsupported bit depth: " + this._t);
                }
                this._v = 1;
                break;
            }
            default: {
                throw new IOException("unsupported color format: " + this._u);
            }
            case 2: {
                if (this._t != 8) {
                    throw new IOException("Unsupported bit depth: " + this._t);
                }
                this._v = 3;
                break;
            }
            case 3: {
                switch (this._t) {
                    case 1: 
                    case 2: 
                    case 4: 
                    case 8: {
                        this._v = 1;
                        break block0;
                    }
                }
                throw new IOException("Unsupported bit depth: " + this._t);
            }
            case 4: {
                if (this._t != 8) {
                    throw new IOException("Unsupported bit depth: " + this._t);
                }
                this._v = 2;
                break;
            }
            case 6: {
                if (this._t != 8) {
                    throw new IOException("Unsupported bit depth: " + this._t);
                }
                this._v = 4;
            }
        }
        if (this._n[10] != 0) {
            throw new IOException("unsupported compression method");
        }
        if (this._n[11] != 0) {
            throw new IOException("unsupported filtering method");
        }
        if (this._n[12] != 0) {
            throw new IOException("unsupported interlace method");
        }
    }

    protected void _h() throws IOException {
        int n = this._o / 3;
        if (n < 1 || n > 256 || this._o % 3 != 0) {
            throw new IOException("PLTE chunk has wrong length");
        }
        this._w = new byte[n * 3];
        this._a(this._w, 0, this._w.length);
    }

    protected void _i() throws IOException {
        switch (this._u) {
            case 0: {
                this._b(2);
                this._y = new byte[2];
                this._a(this._y, 0, 2);
            }
            default: {
                break;
            }
            case 2: {
                this._b(6);
                this._y = new byte[6];
                this._a(this._y, 0, 6);
                break;
            }
            case 3: {
                if (this._w == null) {
                    throw new IOException("tRNS chunk without PLTE chunk");
                }
                this._x = new byte[this._w.length / 3];
                Arrays.fill(this._x, (byte)-1);
                this._a(this._x, 0, this._x.length);
            }
        }
    }

    protected void _j() throws IOException {
        if (this._q > 0) {
            this._a((long)(this._q + 4));
        } else {
            this._b(this._n, 0, 4);
            int n = this._a(this._n, 0);
            int n2 = (int)this._m.getValue();
            if (n2 != n) {
                throw new IOException("Invalid CRC");
            }
        }
        this._q = 0;
        this._o = 0;
        this._p = 0;
    }

    protected void _k() throws IOException {
        this._b(this._n, 0, 8);
        this._o = this._a(this._n, 0);
        this._p = this._a(this._n, 4);
        this._q = this._o;
        this._m.reset();
        this._m.update(this._n, 4, 4);
    }

    protected void _a(int n) throws IOException {
        this._k();
        if (this._p != n) {
            throw new IOException("Expected chunk: " + Integer.toHexString(n));
        }
    }

    protected void _b(int n) throws IOException {
        if (this._o != n) {
            throw new IOException("Chunk has wrong size");
        }
    }

    protected int _a(byte[] byArray, int n, int n2) throws IOException {
        if (n2 > this._q) {
            n2 = this._q;
        }
        this._b(byArray, n, n2);
        this._m.update(byArray, n, n2);
        this._q -= n2;
        return n2;
    }

    protected void _a(Inflater inflater) throws IOException {
        while (this._q == 0) {
            this._j();
            this._a(1229209940);
        }
        int n = this._a(this._n, 0, this._n.length);
        inflater.setInput(this._n, 0, n);
    }

    protected void _a(Inflater inflater, byte[] byArray, int n, int n2) throws IOException {
        assert (byArray != this._n);
        try {
            do {
                int n3;
                if ((n3 = inflater.inflate(byArray, n, n2)) <= 0) {
                    if (inflater.finished()) {
                        throw new EOFException();
                    }
                    if (!inflater.needsInput()) {
                        throw new IOException("Can't inflate " + n2 + " bytes");
                    }
                    this._a(inflater);
                    continue;
                }
                n += n3;
                n2 -= n3;
            } while (n2 > 0);
        }
        catch (DataFormatException dataFormatException) {
            throw (IOException)new IOException("inflate error").initCause(dataFormatException);
        }
    }

    protected void _b(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        do {
            if ((n3 = this._l.read(byArray, n, n2)) < 0) {
                throw new EOFException();
            }
            n += n3;
        } while ((n2 -= n3) > 0);
    }

    protected int _a(byte[] byArray, int n) {
        return byArray[n] << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    protected void _a(long l) throws IOException {
        while (l > 0L) {
            long l2 = this._l.skip(l);
            if (l2 < 0L) {
                throw new EOFException();
            }
            l -= l2;
        }
    }

    protected static boolean _b(byte[] byArray) {
        for (int i = 4; i < _a.length; ++i) {
            if (byArray[i] == _a[i]) continue;
            return false;
        }
        return true;
    }
}

