/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class wnxc {
    public final String _a;
    public final int _b;
    public final float _c;
    public final float _d;
    public final float _e;
    private final float _g;
    private static final float _h = 3.051851E-5f;
    public kjui[] _f;

    public wnxc(String string, int n, float f, float f2, float f3) {
        this._a = string;
        this._b = n;
        this._f = new kjui[n];
        this._d = f;
        this._c = (float)(n - 1) * f * 20.0f;
        this._g = f2 / 32767.0f;
        this._e = f3;
    }

    public void _a(hbom hbom2, int n) throws IOException {
        for (int i = 0; i < this._b; ++i) {
            kjui kjui2 = new kjui(n);
            for (int j = 0; j < n; ++j) {
                Quaternion quaternion = new Quaternion((float)hbom2.readShort() * 3.051851E-5f, (float)hbom2.readShort() * 3.051851E-5f, (float)hbom2.readShort() * 3.051851E-5f, (float)hbom2.readShort() * 3.051851E-5f);
                float f = quaternion.length();
                kjui2._b[j * 4 + 0] = quaternion.x / f;
                kjui2._b[j * 4 + 1] = quaternion.y / f;
                kjui2._b[j * 4 + 2] = quaternion.z / f;
                kjui2._b[j * 4 + 3] = quaternion.w / f;
                for (int k = 0; k < 3; ++k) {
                    kjui2._a[j * 3 + k] = hbom2.readShort();
                }
            }
            this._f[i] = kjui2;
        }
    }

    public class kjui {
        public short[] _a;
        public float[] _b;

        public kjui(int n) {
            this._a = new short[n * 3];
            this._b = new float[n * 4];
        }

        public void _a(Vector3f vector3f, int n) {
            int n2 = n * 3;
            vector3f.set((float)this._a[n2] * wnxc.this._g, (float)this._a[n2 + 1] * wnxc.this._g, (float)this._a[n2 + 2] * wnxc.this._g);
        }

        public void _a(Quaternion quaternion, int n) {
            int n2 = n * 4;
            quaternion.set(this._b[n2], this._b[n2 + 1], this._b[n2 + 2], this._b[n2 + 3]);
        }
    }
}

