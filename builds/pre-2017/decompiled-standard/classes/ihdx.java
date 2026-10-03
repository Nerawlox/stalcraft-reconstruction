/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class ihdx {
    public final EntityPlayer _a;
    public int[] _b = new int[128];
    public int[] _c = new int[128];
    public int _d;
    public int _e;
    public byte[] _f;
    public int _g;
    public boolean _h;
    public final /* synthetic */ thdd _i;

    public ihdx(thdd thdd2, EntityPlayer entityPlayer) {
        this._i = thdd2;
        this._a = entityPlayer;
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = 0;
            this._c[i] = 127;
        }
    }

    public byte[] _a(cvzo cvzo2) {
        int n;
        int n2;
        if (!this._h) {
            byte[] byArray = new byte[]{2, this._i._d};
            this._h = true;
            return byArray;
        }
        if (--this._e < 0) {
            this._e = 4;
            byte[] byArray = new byte[this._i._h.size() * 3 + 1];
            byArray[0] = 1;
            n2 = 0;
            for (ozsr ozsr2 : this._i._h.values()) {
                byArray[n2 * 3 + 1] = (byte)(ozsr2._a << 4 | ozsr2._d & 0xF);
                byArray[n2 * 3 + 2] = ozsr2._b;
                byArray[n2 * 3 + 3] = ozsr2._c;
                ++n2;
            }
            int n3 = n = !cvzo2._A() ? 1 : 0;
            if (this._f == null || this._f.length != byArray.length) {
                n = 0;
            } else {
                for (int i = 0; i < byArray.length; ++i) {
                    if (byArray[i] == this._f[i]) continue;
                    n = 0;
                    break;
                }
            }
            if (n == 0) {
                this._f = byArray;
                return byArray;
            }
        }
        for (int i = 0; i < 1; ++i) {
            if (this._b[n2 = this._d++ * 11 % 128] < 0) continue;
            n = this._c[n2] - this._b[n2] + 1;
            int n4 = this._b[n2];
            byte[] byArray = new byte[n + 3];
            byArray[0] = 0;
            byArray[1] = (byte)n2;
            byArray[2] = (byte)n4;
            for (int j = 0; j < byArray.length - 3; ++j) {
                byArray[j + 3] = this._i._e[(j + n4) * 128 + n2];
            }
            this._c[n2] = -1;
            this._b[n2] = -1;
            return byArray;
        }
        return null;
    }
}

