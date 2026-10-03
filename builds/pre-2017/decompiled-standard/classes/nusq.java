/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;

public class nusq
extends kjwj {
    public final kjui _b;
    public final String _c;
    public final float _d;
    public final float _e;
    public final float _f;
    public final float _g;
    public final float _h;
    public final float _i;
    public final float _j;
    public final float _k;
    public final int _l;

    public nusq(int n, String string, String string2, List<String> list2, int n2, kjui kjui2, String string3, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n3) {
        super(n, string, "weapons:" + string2, list2, n2);
        this._b = kjui2;
        this._c = string3;
        this._d = f;
        this._e = f2;
        this._f = f3;
        this._g = f4;
        this._h = f5;
        this._i = f6;
        this._j = f7;
        this._k = f8;
        this._l = n3;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        list2.add((Object)((Object)this._b._g) + this._b._f + " \u043f\u0430\u0442\u0440\u043e\u043d");
        jgro._a(list2, "\u0423\u0440\u043e\u043d", jgro._a(this._d * (float)this._l));
        jgro._a(list2, "\u0411\u0440\u043e\u043d\u0435\u0431\u043e\u0439\u043d\u043e\u0441\u0442\u044c", jgro._a(this._e));
        jgro._a(list2, "\u041f\u043e\u0434\u0436\u0438\u0433\u0430\u043d\u0438\u0435", jgro._c(this._f));
        jgro._a(list2, "\u041a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u0435", jgro._c(this._h));
        jgro._b(list2, "\u0417\u0430\u043a\u043b\u0438\u043d\u0438\u0432\u0430\u043d\u0438\u0435", jgro._c(this._g));
        jgro._b(list2, "\u0420\u0430\u0437\u0431\u0440\u043e\u0441", jgro._a(this._i));
        jgro._a(list2, "\u041e\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u044e\u0449\u0435\u0435 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435", this._j * 100.0f);
        if (this._l > 1) {
            this._c(list2, "\u0427\u0438\u0441\u043b\u043e \u043f\u043e\u0440\u0430\u0436\u0430\u044e\u0449\u0438\u0445 \u044d\u043b\u0435\u043c\u0435\u043d\u0442\u043e\u0432: " + this._l);
        }
    }

    public static enum kjui {
        _a("\u0421\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u044b\u0439", ezfc._p),
        _b("\u0411\u0440\u043e\u043d\u0435\u0431\u043e\u0439\u043d\u044b\u0439", ezfc._c),
        _c("\u042d\u043a\u0441\u043f\u0430\u043d\u0441\u0438\u0432\u043d\u044b\u0439", ezfc._g),
        _d("\u0417\u0430\u0436\u0438\u0433\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439", ezfc._o),
        _e("\u041e\u0442\u0441\u044b\u0440\u0435\u0432\u0448\u0438\u0439", ezfc._h);

        public final String _f;
        public final ezfc _g;

        private kjui(String string2, ezfc ezfc2) {
            this._f = string2;
            this._g = ezfc2;
        }
    }
}

