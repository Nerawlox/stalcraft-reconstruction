/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.xpzm;
import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.ugqi;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.opengl.GL20;

public class jxsn
extends jxtc {
    private kjui.kjui _P;
    public HashMap<String, Integer> _c = new HashMap();
    int _d;
    int _e;
    int _f;
    int _g;
    int _h;
    int _i;
    int _j;
    int _k;
    int _l;
    int _m;
    int _n;
    int _o;
    int _p;
    int _q;
    int _r;
    int _s;
    int _t;
    int _u;
    int _v;
    int _w;
    int _x;
    int _y;
    int _z;
    int _A;
    int _B;
    int _C;
    int _D;
    int _E;
    int _F;
    int _G;
    int _H;
    int _I;
    int _J;
    int _K;
    int _L;
    int _M;
    int _N;
    int _O;
    private boolean _Q;

    private jxsn(kjui.kjui kjui2) {
        super(() -> kjui2._c(), () -> kjui2._d(), "mcsa");
        this._P = kjui2;
        this._a(this._f());
    }

    protected void _a(int n) {
        if (this._Q) {
            return;
        }
        this._Q = true;
        this._d = GL20.glGetAttribLocation(n, "positionIn");
        this._e = GL20.glGetAttribLocation(n, "textureCoordsIn");
        this._f = GL20.glGetAttribLocation(n, "normalIn");
        this._i = GL20.glGetAttribLocation(n, "tangentIn");
        this._g = GL20.glGetAttribLocation(n, "animationData");
        this._h = GL20.glGetAttribLocation(n, "weights");
        this._k = GL20.glGetUniformLocation(n, "viewMatrix");
        this._l = GL20.glGetUniformLocation(n, "modelMatrix");
        this._m = GL20.glGetUniformLocation(n, "normalMatrix");
        this._j = GL20.glGetUniformLocation(n, "projectionMatrix");
        this._n = GL20.glGetUniformLocation(n, "animated");
        this._o = GL20.glGetUniformLocation(n, "qRotations");
        this._p = GL20.glGetUniformLocation(n, "vTranslations");
        this._q = GL20.glGetUniformLocation(n, "quantizationScale");
        this._r = GL20.glGetUniformLocation(n, "uvQuantizationScale");
        this._s = GL20.glGetUniformLocation(n, "usedTextures");
        this._t = GL20.glGetUniformLocation(n, "envMap");
        this._u = GL20.glGetUniformLocation(n, "diffuseMap");
        this._v = GL20.glGetUniformLocation(n, "normalMap");
        this._w = GL20.glGetUniformLocation(n, "specularMap");
        this._x = GL20.glGetUniformLocation(n, "glossMap");
        this._y = GL20.glGetUniformLocation(n, "emissionMap");
        this._z = GL20.glGetUniformLocation(n, "specularChannel");
        this._A = GL20.glGetUniformLocation(n, "glossChannel");
        this._B = GL20.glGetUniformLocation(n, "emissionChannel");
        this._C = GL20.glGetUniformLocation(n, "ambientColor");
        this._D = GL20.glGetUniformLocation(n, "diffuseColor");
        this._E = GL20.glGetUniformLocation(n, "specularColor");
        this._F = GL20.glGetUniformLocation(n, "specularExponent");
        this._G = GL20.glGetUniformLocation(n, "ambientBrightness");
        this._J = GL20.glGetUniformLocation(n, "lightmapColor");
        this._H = GL20.glGetUniformLocation(n, "alphaFactor");
        this._I = GL20.glGetUniformLocation(n, "burnFactor");
        this._K = GL20.glGetUniformLocation(n, "reflectionFactor");
        this._L = GL20.glGetUniformLocation(n, "reflectionGloss");
        this._M = GL20.glGetUniformLocation(n, "fresnelBias");
        this._N = GL20.glGetUniformLocation(n, "fresnelScale");
        this._O = GL20.glGetUniformLocation(n, "fresnelPower");
        if (this._P._o != null) {
            this._P._o.loadLocations(this);
        }
    }

    public void _c(String string) {
        this._c.put(string, GL20.glGetUniformLocation(this._f(), string));
    }

    @Override
    public int _a(String string) {
        Integer n = this._c.get(string);
        if (n == null) {
            return -1;
        }
        return n;
    }

    public static class gloomyfolken.mods.effects.client.mcsa.jxsn$kjui {
        private static HashMap<kjui, jxsn> _a = new HashMap();
        private jgro _b;
        private kjui _c;

        public gloomyfolken.mods.effects.client.mcsa.jxsn$kjui(jgro jgro2, int n) {
            this._b = jgro2;
            this._c = new kjui();
            this._c._r = n > 0;
            this._c._q = n;
        }

        public jxsn _a() {
            if (_a.containsKey(this._c)) {
                return _a.get(this._c);
            }
            jxsn jxsn2 = this._c._a();
            _a.put(this._c, jxsn2);
            return jxsn2;
        }

        private class kjui {
            private boolean _b;
            private boolean _c;
            private boolean _d;
            private boolean _e;
            private boolean _f;
            private boolean _g;
            private boolean _h;
            private boolean _i;
            private boolean _j;
            private boolean _k;
            private boolean _l;
            private boolean _m;
            private int _n;
            private ugqi _o;
            private int _p;
            private int _q;
            private boolean _r;

            private kjui() {
                this._b = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._m._a();
                this._c = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._n._a();
                this._d = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._o._a();
                this._e = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._p._a();
                this._f = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._q._a();
                this._h = this._g = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._h._e();
                this._i = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._r._a();
                this._j = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._s._a();
                this._k = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._t._a();
                this._l = kjui.this._b._b();
                this._m = kjui.this._b._c();
                this._n = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._z._a().ordinal() + 1;
                this._o = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._B._a();
                this._p = ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._e.length + (((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._m._a() && ((gloomyfolken.mods.effects.client.mcsa.jxsn$kjui)kjui.this)._b._m._b() == null ? 1 : 0);
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (object == null || this.getClass() != object.getClass()) {
                    return false;
                }
                kjui kjui2 = (kjui)object;
                if (this._b != kjui2._b) {
                    return false;
                }
                if (this._c != kjui2._c) {
                    return false;
                }
                if (this._d != kjui2._d) {
                    return false;
                }
                if (this._e != kjui2._e) {
                    return false;
                }
                if (this._f != kjui2._f) {
                    return false;
                }
                if (this._g != kjui2._g) {
                    return false;
                }
                if (this._r != kjui2._r) {
                    return false;
                }
                if (this._h != kjui2._h) {
                    return false;
                }
                if (this._i != kjui2._i) {
                    return false;
                }
                if (this._j != kjui2._j) {
                    return false;
                }
                if (this._k != kjui2._k) {
                    return false;
                }
                if (this._l != kjui2._l) {
                    return false;
                }
                if (this._q != kjui2._q) {
                    return false;
                }
                if (this._n != kjui2._n) {
                    return false;
                }
                if (this._o != kjui2._o) {
                    return false;
                }
                return this._p == kjui2._p;
            }

            public int hashCode() {
                int n = this._b ? 1 : 0;
                n = 31 * n + (this._c ? 1 : 0);
                n = 31 * n + (this._d ? 1 : 0);
                n = 31 * n + (this._e ? 1 : 0);
                n = 31 * n + (this._f ? 1 : 0);
                n = 31 * n + (this._g ? 1 : 0);
                n = 31 * n + (this._r ? 1 : 0);
                n = 31 * n + (this._h ? 1 : 0);
                n = 31 * n + (this._i ? 1 : 0);
                n = 31 * n + (this._j ? 1 : 0);
                n = 31 * n + (this._k ? 1 : 0);
                n = 31 * n + (this._l ? 1 : 0);
                n = 31 * n + this._q;
                n = 31 * n + this._n;
                n = 31 * n + (this._o == null ? 0 : this._o.hashCode());
                n = 31 * n + this._p;
                return n;
            }

            jxsn _a() {
                long l = System.currentTimeMillis();
                long l2 = System.currentTimeMillis() - l;
                gpmu._f("Built shader for material " + kjui.this._b + " in " + l2 + " ms", new Object[0]);
                l = System.currentTimeMillis();
                jxsn jxsn2 = new jxsn(kjui.this._c);
                if (jxsn2._f() == 0) {
                    throw new RuntimeException("Can't load shader");
                }
                long l3 = System.currentTimeMillis() - l;
                gpmu._f("Loaded shader for material " + kjui.this._b + " in " + l3 + " ms", new Object[0]);
                return jxsn2;
            }

            private String _b() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("#version ").append(eidj._E ? "140" : "110").append("\n");
                this._a(stringBuilder, "GLSL130", eidj._E);
                this._a(stringBuilder, "DIFFUSE_MAPPING", this._b);
                this._a(stringBuilder, "NORMAL_MAPPING", this._c);
                this._a(stringBuilder, "SPECULAR_MAPPING", this._d);
                this._a(stringBuilder, "GLOSS_MAPPING", this._e);
                this._a(stringBuilder, "EMISSION_MAPPING", this._f);
                this._a(stringBuilder, "SPECULAR_LIGHTING", this._g);
                this._a(stringBuilder, "ANIMATION", this._r);
                this._a(stringBuilder, "ALPHA_BLENDING", this._i);
                this._a(stringBuilder, "COLOURFUL_SPECULAR", this._k);
                this._a(stringBuilder, "REFLECTION", this._l);
                this._a(stringBuilder, "FORCE_PER_PIXEL_LIGHTING", this._h);
                this._a(stringBuilder, "ALPHA_TRANSPARENCY", this._j);
                this._a(stringBuilder, "NUM_MAPS", this._p);
                this._a(stringBuilder, "WEIGHTS_PER_VERTEX", this._q);
                this._a(stringBuilder, "LIGHTING_MODEL", this._n);
                this._a(stringBuilder, "NUM_BONES", 64);
                this._a(stringBuilder, "REFLECTION", this._l);
                this._a(stringBuilder, "FRESNEL", this._m);
                switch (this._n) {
                    case 1: {
                        this._a(stringBuilder, "NUM_LIGHTS", 1);
                        break;
                    }
                    case 2: {
                        this._a(stringBuilder, "NUM_LIGHTS", 2);
                        break;
                    }
                    default: {
                        throw new RuntimeException("Invalid lighting model: " + this._n);
                    }
                }
                stringBuilder.append("#line 1\n");
                return stringBuilder.toString();
            }

            private String _c() {
                return this._b() + this._a(xpzm._c._a(), this._o == null ? null : this._o.getVertexUniformHook(), this._o == null ? null : this._o.getVertexExitHook());
            }

            private String _d() {
                return this._b() + this._a(xpzm._c._b(), this._o == null ? null : this._o.getFragmentUniformHook(), this._o == null ? null : this._o.getFragmentExitHook());
            }

            private String _a(String string, String string2, String string3) {
                String string4 = string;
                string = this._a(string4, string, "#uniform_hook", string2);
                string = this._a(string4, string, "#exit_hook", string3);
                return string;
            }

            private String _a(String string, String string2, String string3, String string4) {
                if (!string2.contains(string3)) {
                    return string2;
                }
                if (string4 == null) {
                    return StringUtils.replace(string2, string3, "");
                }
                String string5 = StringUtils.substringBefore(string, string3);
                int n = StringUtils.countMatches(string5, "\n") + 2;
                String string6 = "#line 1\n" + string4 + "\n#line " + n;
                return StringUtils.replace(string2, string3, string6);
            }

            private void _a(StringBuilder stringBuilder, String string, boolean bl) {
                stringBuilder.append("#define ").append(string).append(" ").append(bl ? "1" : "0").append("\n");
            }

            private void _a(StringBuilder stringBuilder, String string, int n) {
                stringBuilder.append("#define ").append(string).append(" ").append(n).append("\n");
            }
        }
    }
}

