/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;

public class xrpu
extends ccsw {
    private ResourceLocation _s;
    public float _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    public float _i;
    public float _j;
    public float _k;
    public float _l;
    public float _m;
    public int _n = 1;
    public float _o = 1.0f;
    public float _p = -0.1f;
    public float _q;

    public xrpu(String string, String string2) {
        if (string != null && !string.isEmpty()) {
            this._s = new ResourceLocation("weapons", "anims/" + string);
        }
        this._c();
    }

    @Override
    protected void _a(anof anof2) {
        this._a = anof2._j("aimPosX");
        this._b = anof2._j("aimPosY");
        this._c = anof2._j("aimPosZ");
        this._d = anof2._j("aimRotX");
        this._e = anof2._j("aimRotY");
        this._f = anof2._j("firstPersonPosX");
        this._g = anof2._j("firstPersonPosY");
        this._h = anof2._j("firstPersonPosZ");
        this._i = anof2._j("thirdPersonPosX");
        this._j = anof2._j("thirdPersonPosY");
        this._k = anof2._j("thirdPersonPosZ");
        this._l = anof2._j("leftHandY");
        this._m = anof2._j("leftHandZ");
        this._n = anof2._a("lightType", 1);
        this._o = anof2._j("lightSize");
        this._p = anof2._j("lightDistance");
        this._q = anof2._j("aimTextureDistance");
    }

    @Override
    protected List<ResourceLocation> _a() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        if (this._s != null) {
            arrayList.add(this._s);
        }
        return arrayList;
    }

    @ezey(_a={eidj.CLIENT})
    public void _b() {
        ivgt ivgt2 = new ivgt();
        ivgt2._a("");
        ivgt2._a("aimPosX", this._a);
        ivgt2._a("aimPosY", this._b);
        ivgt2._a("aimPosZ", this._c);
        ivgt2._a("aimRotX", this._d);
        ivgt2._a("aimRotY", this._e);
        ivgt2._a("firstPersonPosX", this._f);
        ivgt2._a("firstPersonPosY", this._g);
        ivgt2._a("firstPersonPosZ", this._h);
        ivgt2._a("thirdPersonPosX", this._i);
        ivgt2._a("thirdPersonPosY", this._j);
        ivgt2._a("thirdPersonPosZ", this._k);
        ivgt2._a("leftHandY", this._l);
        ivgt2._a("leftHandZ", this._m);
        ivgt2._a("lightSize", this._o);
        ivgt2._a("lightType", this._n);
        ivgt2._a("lightDistance", this._p);
        ivgt2._a("aimTextureDistance", this._q);
        ivgt2._a();
        File file = new File("animation.anm");
        int n = 1;
        while (file.exists()) {
            file = new File("animation (" + n++ + ").anm");
        }
        ivgt2._a(file);
        if (xpzm._E()._t != null) {
            xpzm._E()._t.func_71035_c("\u0424\u0430\u0439\u043b \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d \u043a\u0430\u043a " + file.getName());
        }
    }
}

