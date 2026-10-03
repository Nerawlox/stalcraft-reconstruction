/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.stalker.player.zwaw;
import java.lang.reflect.Type;
import java.util.Arrays;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.sajh;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class mrkk {
    public pjrz[] _a;
    private float[] _b;
    private static final Gson _c = new GsonBuilder().registerTypeAdapter((Type)((Object)mrkk.class), new ogpf()).registerTypeAdapter((Type)((Object)pjrz.class), new sbzu()).registerTypeAdapter((Type)((Object)pjrz.kjui.class), new uzcj()).registerTypeAdapter((Type)((Object)pjrz.pidb.class), new dxrn()).create();
    private static Quaternion _d = new Quaternion();
    private static Vector3f _e = new Vector3f();
    private static pjrz _f = new pjrz(0.0f);
    private static pjrz _g = new pjrz(0.0f);
    private static pjrz _h = new pjrz(1.0f);

    public static mrkk _a(String string) {
        return _c.fromJson(srxe._b("/assets/weapons/tpanims/" + string), mrkk.class);
    }

    public mrkk(pjrz[] pjrzArray) {
        this._a = pjrzArray;
        Arrays.sort(this._a);
        this._b = new float[pjrzArray.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = pjrzArray[i]._d;
        }
    }

    public void _a(ncux ncux2, float f) {
        _e.set(ncux2._l.rotateAngleX, ncux2._l.rotateAngleY, ncux2._l.rotateAngleZ);
        jywc._a(_e, _d);
        mrkk._g._a._a.set(_d);
        mrkk._h._a._a.set(_d);
        _e.set(ncux2._k.rotateAngleX, ncux2._k.rotateAngleY, ncux2._k.rotateAngleZ);
        jywc._a(_e, _d);
        mrkk._g._b._a.set(_d);
        mrkk._h._b._a.set(_d);
        pjrz pjrz2 = this._d(f);
        this._a(pjrz2._a._a, pjrz2._a._b, ncux2._l);
        this._a(pjrz2._b._a, pjrz2._b._b, ncux2._k);
    }

    private void _a(Quaternion quaternion, float f, ModelRenderer modelRenderer) {
        _d.set(quaternion);
        jywc._b(_d, _e);
        modelRenderer.rotateAngleX = mrkk._e.x;
        modelRenderer.rotateAngleY = mrkk._e.y;
        modelRenderer.rotateAngleZ = mrkk._e.z;
        if (modelRenderer instanceof zwaw) {
            ((zwaw)((Object)modelRenderer)).setScaleY(f);
        }
    }

    public void _a(float f) {
        pjrz pjrz2 = this._d(f);
        ezfc._a(pjrz2._c._b);
        ezfc._a(pjrz2._c._a);
    }

    private pjrz _d(float f) {
        pjrz pjrz2 = this._b(f);
        pjrz pjrz3 = this._c(f);
        float f2 = this._a(pjrz2, pjrz3, f);
        if (pjrz2._e) {
            f2 = (float)Math.sin(f2 * (float)Math.PI * 0.5f);
        }
        _f._a(pjrz2, pjrz3, f2);
        mrkk._f._d = f;
        return _f;
    }

    private float _a(pjrz pjrz2, pjrz pjrz3, float f) {
        return sajh._a((f - pjrz2._d) / (pjrz3._d - pjrz2._d), 0.0f, 1.0f);
    }

    public pjrz _b(float f) {
        int n = Arrays.binarySearch(this._b, f);
        if (n < 0) {
            n = -n - 2;
        }
        return this._a(n);
    }

    public pjrz _c(float f) {
        int n = Arrays.binarySearch(this._b, f);
        if (n < 0) {
            n = -n - 2;
        }
        return this._a(++n);
    }

    private pjrz _a(int n) {
        if (n < 0) {
            return _g;
        }
        if (n >= this._a.length) {
            return _h;
        }
        return this._a[n];
    }
}

