/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ejection.pidb;
import net.minecraft.client.Minecraft;

@ezey(_a={eidj.CLIENT})
public class kjui
implements nttf {
    public static kjui _a;
    public pidb _b = null;
    public int _c = -1;
    private int _k;
    private float _l;
    private float _m;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    public float _i;
    public float _j;

    public kjui() {
        _a = this;
    }

    @Override
    public void onTickInGame() {
        if (Minecraft._E()._r.lastLightningBolt == 2) {
            this._k = 0;
            this._l = (float)Math.random() / 2.0f;
            this._m = (float)Math.random() / 2.0f;
            this._d = 0.11f;
        }
        ++this._k;
        this._d = (float)((double)this._d * 0.97);
        this._i = this._f;
        this._h = this._e;
        this._j = this._g;
        this._f = this._d * (float)(this._k % 4 < 2 ? 1 : -1);
        this._e = this._d * this._l * (float)(this._k % 4 < 2 ? 1 : -1);
        this._g = this._d * this._m * (float)(this._k % 4 < 2 ? 1 : -1);
        if (this._b != null) {
            this._b._b();
        }
    }

    @Override
    public void onGameJoined() {
        this._b = null;
        this._c = -1;
        this._k = 0;
        this._l = 0.0f;
        this._m = 0.0f;
        this._d = 0.0f;
        this._e = 0.0f;
        this._f = 0.0f;
        this._g = 0.0f;
        this._h = 0.0f;
        this._i = 0.0f;
        this._j = 0.0f;
    }

    public float[] _a(float f) {
        if (this._b == null) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        float f2 = this._h + (this._e - this._h) * f;
        float f3 = this._i + (this._f - this._i) * f;
        float f4 = this._j + (this._g - this._j) * f;
        return new float[]{f2, f3, f4, 0.0f, 0.0f, 0.0f};
    }
}

