/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.ugqi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.util.vector.Matrix4f;

public class jgro {
    public final ResourceLocation _a;
    public final String _b;
    public final String _c;
    public final int _d = _M.incrementAndGet();
    private List<zwaw> _D = new ArrayList<zwaw>();
    private List<tupg> _E = new ArrayList<tupg>(4);
    private boolean _F;
    private boolean _G = true;
    ResourceLocation[] _e = new ResourceLocation[0];
    private kkwv[] _H;
    public final pidb _f = new pidb("diffuse color", 0.6f, 0.6f, 0.6f);
    public final pidb _g = new pidb("ambient color", 0.4f, 0.4f, 0.4f);
    public final pidb _h = new pidb("specular color", 0.0f, 0.0f, 0.0f);
    public final eidj _i = new eidj("ambient brightness", 0.0f);
    public final eidj _j = new eidj("alpha factor", 1.0f);
    public final eidj _k = new eidj("burn factor", 0.0f);
    public final eidj _l = new eidj("specular exponent", 0.0f);
    public final tupg _m = new tupg("diffuse map");
    public final tupg _n = new tupg("normal map");
    public final tupg _o = new tupg("specular map");
    public final tupg _p = new tupg("gloss map");
    public final tupg _q = new tupg("emission map");
    public final kjui _r = new kjui("alpha blending", false);
    public final kjui _s = new kjui("alpha transparency", false);
    public final kjui _t = new kjui("colourful specular", false);
    public final eidj _u = new eidj("reflection factor", 0.0f);
    public final eidj _v = new eidj("reflection gloss", 1.0f);
    public final eidj _w = new eidj("fresnel bias", 0.0f);
    public final eidj _x = new eidj("fresnel scale", 0.0f);
    public final eidj _y = new eidj("fresnel power", 3.0f);
    public final zwat _z = new zwat("lighting model");
    public final kjui _A = new kjui("allow streaming", true);
    public final jgro _B = new jgro("shader hook");
    private HashMap<String, Object> _I = null;
    private final kjui _J = new kjui("alpha as specular", false);
    private final kjui _K = new kjui("alpha as gloss", false);
    private final kjui _L = new kjui("force texturing", false);
    private static AtomicInteger _M = new AtomicInteger();
    public static jgro _C = new jgro("");

    public jgro(ResourceLocation resourceLocation, String string) {
        this._a = resourceLocation;
        this._c = string;
        String string2 = resourceLocation.func_110623_a();
        int n = string2.lastIndexOf("/");
        this._b = resourceLocation.func_110624_b() + ":" + (n == -1 ? "" : string2.substring(0, n + 1));
    }

    public jgro(String string) {
        this._a = null;
        this._b = null;
        this._c = string;
    }

    public void _a(String string) {
        if (this._F) {
            throw new IllegalStateException("Material is already loaded!");
        }
        int n = 0;
        for (zwaw zwaw2 : this._D) {
            if (!string.startsWith(zwaw2._b)) continue;
            String string2 = string.substring(zwaw2._b.length() + 1);
            zwaw2._a(string2);
            ++n;
        }
        if (n == 0) {
            if (this._B._a() == null || !this._B._a().readMaterialAttribute(string, this._I)) {
                gpmu._b("Unexpected line in material lib %s: %s", this._a, string);
            }
        } else if (n > 1) {
            throw new IllegalStateException("Attribute registered twice: " + string);
        }
    }

    public void _a(boolean bl) {
        if (this._F) {
            throw new IllegalStateException("Material is already created!");
        }
        this._G = bl;
    }

    public boolean _a() {
        return this._G;
    }

    public jgro _b(boolean bl) {
        for (tupg tupg2 : this._E) {
            tupg2._e = this._a(tupg2._b());
        }
        if (this._K._a()) {
            this._p._f = qlgf._d;
        }
        if (this._J._a()) {
            this._o._f = qlgf._d;
        }
        if (this._L._a() && this._m._c() == -1) {
            this._m._e = 0;
        }
        this._H = new kkwv[this._e.length];
        if (!bl && this._G) {
            fmib._c(this._e);
        } else {
            for (int i = 0; i < this._e.length; ++i) {
                this._H[i] = fmib._a(this._e[i], this._A._a());
            }
            this._h().forEach(hsnd::_j);
        }
        this._F = true;
        return this;
    }

    private int _a(ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return -1;
        }
        for (int i = 0; i < this._e.length; ++i) {
            if (!resourceLocation.equals(this._e[i])) continue;
            return i;
        }
        ResourceLocation[] resourceLocationArray = this._e;
        this._e = new ResourceLocation[resourceLocationArray.length + 1];
        System.arraycopy(resourceLocationArray, 0, this._e, 0, resourceLocationArray.length);
        this._e[this._e.length - 1] = resourceLocation;
        return this._e.length - 1;
    }

    public boolean _b() {
        return this._u._a() != 0.0f;
    }

    public boolean _c() {
        return this._b() && (this._w._a() != 0.0f || this._x._a() != 0.0f);
    }

    public Object _a(String string, Object object) {
        if (this._I == null) {
            return object;
        }
        Object object2 = this._I.get(string);
        return object2 == null ? object : object2;
    }

    public HashMap<String, Object> _d() {
        return this._I;
    }

    public void _e() {
        this._h().forEach(hsnd::_k);
    }

    private List<kkwv> _h() {
        if (this._G) {
            ArrayList<kkwv> arrayList = new ArrayList<kkwv>(this._H.length);
            for (int i = 0; i < this._H.length; ++i) {
                if (this._H[i] == null) continue;
                arrayList.add(this._H[i]);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public ResourceLocation[] _f() {
        return Arrays.copyOf(this._e, this._e.length);
    }

    public String toString() {
        return this._a + "/" + this._c;
    }

    public void _a(Runnable runnable) {
        List<kkwv> list2 = this._h();
        if (list2.isEmpty()) {
            ogai._t()._e(runnable);
        } else {
            ivtu ivtu2 = new ivtu(runnable, list2.size());
            for (kkwv kkwv2 : list2) {
                kkwv2._b(ivtu2::_a);
            }
        }
    }

    public void _a(Matrix4f matrix4f, float f, float f2) {
        if (!this._A._a() || f2 <= 0.0f) {
            return;
        }
        float f3 = gloomyfolken.mods.effects.client.main.eidj._a(matrix4f, f, f2);
        for (int i = 0; i < this._H.length; ++i) {
            kkwv kkwv2 = this._H[i];
            if (kkwv2 == null) continue;
            kkwv2._a(f3);
        }
    }

    public void _a(int n) {
        for (int i = 0; i < this._H.length; ++i) {
            kkwv kkwv2 = this._H[i];
            if (kkwv2 == null) continue;
            kkwv2._b(n);
        }
    }

    public boolean _g() {
        boolean bl = true;
        for (int i = 0; i < this._H.length; ++i) {
            kkwv kkwv2 = this._H[i];
            if (kkwv2 == null || kkwv2._i()) continue;
            bl = false;
        }
        return bl;
    }

    public static jgro _a(ResourceLocation resourceLocation, String string) {
        jgro jgro2 = new jgro(string);
        jgro2._m._d = resourceLocation;
        jgro2._s._d = true;
        jgro2._a(false);
        jgro2._b(false);
        return jgro2;
    }

    static {
        jgro._C._L._d = true;
        _C._b(false);
    }

    static enum ezey {
        _a,
        _b;

    }

    static enum qlgf {
        _a,
        _b,
        _c,
        _d;

    }

    class jgro
    extends zwaw {
        private ugqi _d;

        public jgro(String string) {
            super(string);
        }

        @Override
        void _a(String string) {
            this._d = ugqi.get(string);
            jgro.this._I = new HashMap();
        }

        public ugqi _a() {
            return this._d;
        }
    }

    class zwat
    extends zwaw {
        private ezey _d;

        zwat(String string) {
            super(string);
            this._d = ezey._b;
        }

        @Override
        void _a(String string) {
            this._d = ezey.values()[Integer.parseInt(string) - 1];
        }

        public ezey _a() {
            return this._d;
        }
    }

    class tupg
    extends zwaw {
        private ResourceLocation _d;
        private int _e;
        private qlgf _f;

        tupg(String string) {
            super(string);
            this._e = -1;
            this._f = qlgf._a;
            jgro.this._E.add(this);
        }

        @Override
        void _a(String string) {
            for (qlgf qlgf2 : qlgf.values()) {
                if (!string.toLowerCase().startsWith(qlgf2.name().toLowerCase() + "@")) continue;
                this._f = qlgf2;
                string = string.substring(qlgf2.name().length() + 1);
            }
            if (!string.equals("none")) {
                this._d = string.contains(":") || jgro.this._b == null ? new ResourceLocation(string) : new ResourceLocation(jgro.this._b + string);
            }
        }

        public boolean _a() {
            return this._c() >= 0;
        }

        public ResourceLocation _b() {
            return this._d;
        }

        public int _c() {
            return this._e;
        }

        public qlgf _d() {
            return this._f;
        }
    }

    class kjui
    extends zwaw {
        private boolean _d;

        kjui(String string, boolean bl) {
            super(string);
            this._d = bl;
        }

        @Override
        void _a(String string) {
            this._d = Boolean.parseBoolean(string);
        }

        public boolean _a() {
            return this._d;
        }
    }

    class pidb
    extends zwaw {
        private float[] _d;

        pidb(String string, float f, float f2, float f3) {
            super(string);
            this._d = new float[]{f, f2, f3};
        }

        @Override
        void _a(String string) {
            String[] stringArray = string.split(" ");
            for (int i = 0; i < stringArray.length; ++i) {
                this._d[i] = Float.parseFloat(stringArray[i]);
            }
        }

        public float _a() {
            return this._d[0];
        }

        public float _b() {
            return this._d[1];
        }

        public float _c() {
            return this._d[2];
        }

        public float[] _d() {
            return this._d;
        }

        public boolean _e() {
            return this._a() != 0.0f && this._c() != 0.0f && this._b() != 0.0f;
        }
    }

    class eidj
    extends zwaw {
        private float _d;

        public eidj(String string, float f) {
            super(string);
            this._d = f;
        }

        @Override
        void _a(String string) {
            this._d = Float.parseFloat(string);
        }

        public float _a() {
            return this._d;
        }
    }

    abstract class zwaw {
        public final String _b;

        zwaw(String string) {
            this._b = string;
            jgro.this._D.add(this);
        }

        abstract void _a(String var1);
    }
}

