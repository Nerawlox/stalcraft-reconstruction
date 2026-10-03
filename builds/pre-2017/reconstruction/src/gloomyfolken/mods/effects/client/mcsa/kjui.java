/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.effects.client.mcsa.pidb;
import gloomyfolken.mods.effects.client.mcsa.tupg;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.effects.client.mcsa.zwat;
import gloomyfolken.mods.effects.client.mcsa.zwaw;
import java.util.function.Consumer;
import net.minecraft.util.ResourceLocation;

public class kjui
extends hsnd<ugqx>
implements zwaw {
    public final hsnd<jxtc> _a;
    public final hsnd<tupg> _b;
    public final zwat _c;
    public final zwat _d;
    public final zwat _e;

    public static kjui _a(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        jyth jyth2 = jyth._a(resourceLocation);
        pidb pidb2 = new pidb(resourceLocation2);
        return new kjui(jyth2, pidb2);
    }

    public kjui(ResourceLocation resourceLocation) {
        this(resourceLocation, jxtc.getDefaultMaterialPath(resourceLocation));
    }

    public kjui(String string) {
        this(uyvo._a(string));
    }

    public kjui(String string, String string2) {
        this(uyvo._a(string), uyvo._a(string2));
    }

    public kjui(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this(jyth._a(resourceLocation), jyth._a(resourceLocation2));
    }

    public kjui(hsnd<jxtc> hsnd2, hsnd<tupg> hsnd3) {
        this._a = hsnd2;
        this._b = hsnd3;
        this._c = () -> this._u_() == null ? null : ((ugqx)this._u_())._b();
        this._d = () -> this._u_() == null ? null : ((ugqx)this._u_())._c();
        this._e = () -> this._u_() == null ? null : ((ugqx)this._u_())._d();
    }

    public jxtc _a() {
        return this._a._u_();
    }

    public tupg _b() {
        return this._b._u_();
    }

    public jywl _c() {
        jxtc jxtc2 = this._a();
        return jxtc2 == null ? null : jxtc2.getSkeleton();
    }

    @Override
    protected void _d() {
        kjui kjui2 = new kjui();
        this._a._a((jxtc)((Object)((Consumer<jxtc>)kjui2::_a)));
        this._b._a((tupg)((Object)((Consumer<tupg>)kjui2::_a)));
    }

    @Override
    protected void _a(ugqx ugqx2) {
        ugqx2.release();
        this._a._k();
        this._b._k();
    }

    @Override
    public zwat getWrappedRenderHelper() {
        return this._e;
    }

    public String toString() {
        return "DynamicMcsaRenderer for " + this._a;
    }

    private class kjui {
        private jxtc _b;
        private tupg _c;
        private int _d;

        private kjui() {
        }

        void _a(jxtc jxtc2) {
            this._b = jxtc2;
            this._a();
        }

        void _a(tupg tupg2) {
            this._c = tupg2;
            this._a();
        }

        private void _a() {
            if (++this._d == 2) {
                if (this._b == null || this._c == null) {
                    kjui.this._a(null, oxca.kjui._d);
                } else {
                    ugqx ugqx2 = new ugqx(this._b, this._c);
                    ugqx2.onLoaded(() -> kjui.this._a(ugqx2, oxca.kjui._c));
                    ugqx2.onBroken(() -> kjui.this._a(null, oxca.kjui._d));
                    ugqx2.load(true);
                }
            }
        }
    }
}

