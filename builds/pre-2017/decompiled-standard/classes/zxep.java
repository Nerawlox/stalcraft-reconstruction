/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.ByteBuffer;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class zxep
extends iess {
    public final rpms _a;
    public kjui[] _b;
    public int[] _c;

    public zxep(rpms rpms2, String string, String string2, int n, short[] sArray, int n2, int n3, float f) {
        super(rpms2, string, string2, n, sArray, n2, n3, f);
        this._a = rpms2;
    }

    @Override
    public void _a(ByteBuffer byteBuffer, hbom hbom2) throws IOException {
        if (this._a.fileVersion == 6.0f) {
            this._b(hbom2);
        } else if (this._a.fileVersion == 7.0f) {
            this._a(hbom2);
        }
    }

    private void _a(hbom hbom2) throws IOException {
        kjui kjui2;
        int n;
        this._b = new kjui[this._n];
        for (n = 0; n < this._n; ++n) {
            kjui2 = new kjui();
            kjui2._a = (Vector3f)new Vector3f(this._d(hbom2), this._d(hbom2), this._d(hbom2)).scale(this._a.quantization._a);
            if (this._a.hasTangents()) {
                kjui2._e = new Vector3f();
                kjui2._e.x = this._d(hbom2);
            } else {
                hbom2.skipBytes(2);
            }
            this._b[n] = kjui2;
        }
        if (this._a.hasUvs()) {
            for (n = 0; n < this._n; ++n) {
                this._b[n]._b = (Vector2f)new Vector2f(this._d(hbom2), this._d(hbom2)).scale(this._a.quantization._b);
            }
        }
        if (this._a.hasNormals()) {
            for (n = 0; n < this._n; ++n) {
                this._b[n]._c = new Vector3f(this._c(hbom2), this._c(hbom2), this._c(hbom2));
                if (this._a.hasTangents()) {
                    this._b[n]._e.y = this._c(hbom2);
                    continue;
                }
                hbom2.skipBytes(1);
            }
        }
        if (this._a.hasTangents()) {
            for (n = 0; n < this._n; ++n) {
                this._b[n]._d = new Vector3f(this._c(hbom2), this._c(hbom2), this._c(hbom2));
                this._b[n]._e.z = this._c(hbom2);
            }
        }
        if (this._r) {
            int n2;
            if (this._s <= 2) {
                for (n = 0; n < this._n; ++n) {
                    kjui2 = this._b[n];
                    kjui2._g = new byte[this._s];
                    for (n2 = 0; n2 < 2; ++n2) {
                        if (n2 < this._s) {
                            kjui2._g[n2] = hbom2.readByte();
                            continue;
                        }
                        hbom2.skipBytes(1);
                    }
                    kjui2._f = new float[this._s];
                    for (n2 = 0; n2 < 2; ++n2) {
                        if (n2 < this._s) {
                            kjui2._f[n2] = (float)hbom2.readUnsignedByte() / 255.0f;
                            continue;
                        }
                        hbom2.skipBytes(1);
                    }
                }
            } else {
                for (n = 0; n < this._n; ++n) {
                    kjui2 = this._b[n];
                    kjui2._g = new byte[this._s];
                    for (n2 = 0; n2 < 4; ++n2) {
                        if (n2 < this._s) {
                            kjui2._g[n2] = hbom2.readByte();
                            continue;
                        }
                        hbom2.skipBytes(1);
                    }
                }
                for (n = 0; n < this._n; ++n) {
                    kjui2 = this._b[n];
                    kjui2._f = new float[this._s];
                    for (n2 = 0; n2 < 4; ++n2) {
                        if (n2 < this._s) {
                            kjui2._f[n2] = (float)hbom2.readUnsignedByte() / 255.0f;
                            continue;
                        }
                        hbom2.skipBytes(1);
                    }
                }
            }
        }
        this._c = new int[this._p * 3];
        for (n = 0; n < this._p * 3; ++n) {
            this._c[n] = this._p * 3 > 65535 ? hbom2.readInt() : hbom2.readUnsignedShort();
        }
    }

    private void _b(hbom hbom2) throws IOException {
        int n;
        this._b = new kjui[this._n];
        for (n = 0; n < this._n; ++n) {
            kjui kjui2 = new kjui();
            kjui2._a = (Vector3f)new Vector3f(this._d(hbom2), this._d(hbom2), this._d(hbom2)).scale(this._a.quantization._a);
            if (this._a.hasUvs()) {
                kjui2._b = (Vector2f)new Vector2f(this._d(hbom2), this._d(hbom2)).scale(this._a.quantization._b);
            }
            if (this._a.hasNormals()) {
                kjui2._c = new Vector3f(this._c(hbom2), this._c(hbom2), this._c(hbom2));
            }
            if (this._a.hasTangents()) {
                kjui2._d = new Vector3f(this._c(hbom2), this._c(hbom2), this._c(hbom2));
                kjui2._e = new Vector3f(this._c(hbom2), this._c(hbom2), this._c(hbom2));
            }
            if (this._r) {
                kjui2._g = new byte[this._s];
                kjui2._f = new float[this._s];
                for (int i = 0; i < this._s; ++i) {
                    kjui2._g[i] = hbom2.readByte();
                }
                float f = 1.0f;
                for (int i = 0; i < this._s - 1; ++i) {
                    kjui2._f[i] = (float)hbom2.readUnsignedByte() / 255.0f;
                    f -= kjui2._f[i];
                }
                kjui2._f[this._s - 1] = f;
            }
            this._b[n] = kjui2;
        }
        this._c = new int[this._p * 3];
        for (n = 0; n < this._p * 3; ++n) {
            this._c[n] = this._p * 3 > 65535 ? hbom2.readInt() : hbom2.readUnsignedShort();
        }
    }

    private float _c(hbom hbom2) throws IOException {
        return (float)hbom2.readByte() / 127.0f;
    }

    private float _d(hbom hbom2) throws IOException {
        return (float)hbom2.readShort() / 32767.0f;
    }

    public float _a() {
        if (!this._a.hasUvs()) {
            return -1.0f;
        }
        double d = 0.0;
        double d2 = 0.0;
        Vector2f vector2f = new Vector2f();
        Vector3f vector3f = new Vector3f();
        for (int i = 0; i < this._p; ++i) {
            kjui kjui2 = this._b[this._c[i * 3 + 0]];
            kjui kjui3 = this._b[this._c[i * 3 + 1]];
            kjui kjui4 = this._b[this._c[i * 3 + 2]];
            double d3 = Vector3f.sub(kjui3._a, kjui2._a, vector3f).length();
            double d4 = Vector3f.sub(kjui4._a, kjui3._a, vector3f).length();
            double d5 = Vector3f.sub(kjui2._a, kjui4._a, vector3f).length();
            double d6 = Vector2f.sub(kjui3._b, kjui2._b, vector2f).length();
            double d7 = Vector2f.sub(kjui4._b, kjui3._b, vector2f).length();
            double d8 = Vector2f.sub(kjui2._b, kjui4._b, vector2f).length();
            double d9 = (d3 + d4 + d5) / 2.0;
            double d10 = (d6 + d7 + d8) / 2.0;
            double d11 = Math.sqrt(d9 * (d9 - d3) * (d9 - d4) * (d9 - d5));
            double d12 = Math.sqrt(d10 * (d10 - d6) * (d10 - d7) * (d10 - d8));
            if (Double.isInfinite(d11) || Double.isInfinite(d12) || Double.isNaN(d11) || Double.isNaN(d12) || d11 <= 0.0 || d12 <= 0.0) continue;
            d += d11;
            d2 += d12;
        }
        if (d2 <= 0.0 || d <= 0.0) {
            return 1.0f;
        }
        return (float)(d2 / d);
    }

    public kjui _a(int n) {
        return this._b[this._c[n]];
    }

    public zxep _b() {
        zxep zxep2 = new zxep(this._a, this._l, this._m, this._s, this._t, this._n, this._p, this._u);
        zxep2._c = this._c;
        zxep2._b = new kjui[this._n];
        for (int i = 0; i < this._n; ++i) {
            kjui kjui2 = new kjui();
            kjui2._a = new Vector3f();
            if (this._a.hasUvs()) {
                kjui2._b = new Vector2f(this._b[i]._b);
            }
            if (this._a.hasNormals()) {
                kjui2._c = new Vector3f();
            }
            if (this._a.hasTangents()) {
                kjui2._d = new Vector3f();
                kjui2._e = new Vector3f();
            }
            zxep2._b[i] = kjui2;
        }
        return zxep2;
    }

    public zxep _a(ivtm ivtm2, zxep zxep2) {
        if (zxep2 == null) {
            zxep2 = this._b();
        }
        Vector3f vector3f = new Vector3f();
        for (int i = 0; i < this._n; ++i) {
            kjui kjui2 = this._b[i];
            kjui kjui3 = zxep2._b[i];
            zxep._a(kjui3._a);
            zxep._a(kjui3._c);
            zxep._a(kjui3._d);
            zxep._a(kjui3._e);
            for (int j = 0; j < kjui2._g.length; ++j) {
                short s = this._t[kjui2._g[j]];
                float f = kjui2._f[j];
                Quaternion quaternion = ivtm2._b[s];
                Vector3f vector3f2 = ivtm2._a[s];
                Vector3f vector3f3 = this._a.getSkeleton()._e._a[s];
                Vector3f.sub(kjui2._a, vector3f3, vector3f);
                jywc._a(quaternion, vector3f, vector3f);
                Vector3f.add(vector3f, vector3f2, vector3f);
                Vector3f.add(kjui3._a, (Vector3f)vector3f.scale(f), kjui3._a);
                if (kjui3._c != null) {
                    jywc._a(quaternion, kjui2._c, vector3f);
                    Vector3f.add(kjui3._c, (Vector3f)vector3f.scale(f), kjui3._c);
                }
                if (kjui3._d != null) {
                    jywc._a(quaternion, kjui2._d, vector3f);
                    Vector3f.add(kjui3._d, (Vector3f)vector3f.scale(f), kjui3._d);
                }
                if (kjui3._e == null) continue;
                jywc._a(quaternion, kjui2._e, vector3f);
                Vector3f.add(kjui3._e, (Vector3f)vector3f.scale(f), kjui3._e);
            }
        }
        return zxep2;
    }

    private static void _a(Vector3f vector3f) {
        if (vector3f != null) {
            vector3f.set(0.0f, 0.0f, 0.0f);
        }
    }

    public static class kjui {
        public Vector3f _a;
        public Vector2f _b;
        public Vector3f _c;
        public Vector3f _d;
        public Vector3f _e;
        public float[] _f;
        public byte[] _g;
    }
}

