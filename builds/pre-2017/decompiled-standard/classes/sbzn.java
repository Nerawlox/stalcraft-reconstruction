/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.weapon.ugqx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class sbzn
implements nttf {
    public static mrof _a;
    public static nuoa _b;
    public static ndrq _c;
    public static loku _d;
    public static sbcg _e;
    public static sbcg _f;
    public static sbcg _g;
    public static sbcg _h;
    public static sbcg _i;
    public static jykp _j;
    public static ctve _k;
    public static uiaq _l;
    public static ndlw _m;
    public static zfvg _n;
    private static HashMap<Class<? extends iefv>, ctve> _o;
    private cvzo _p;
    private static kjui[] _q;
    private List<gloomyfolken.mods.effects.client.mcsa.kjui> _r = new ArrayList<gloomyfolken.mods.effects.client.mcsa.kjui>();

    public static float _a(int n) {
        return sbzn._q[n]._g;
    }

    public static float _a() {
        return ugqx._a((EntityPlayer)xpzm._E()._t)._o;
    }

    public sbzn() {
        _c = new ndrq();
        _c._c();
        _d = new loku();
        _e = new sbcg("auto_reload", "\u0410\u0432\u0442\u043e\u043f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0430", true);
        _f = new sbcg("click_aiming", "\u041f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u0435 \u043f\u043e \u043a\u043b\u0438\u043a\u0443", false);
        _g = new sbcg("render_sleeves", "\u0413\u0438\u043b\u044c\u0437\u044b \u043d\u0430 \u0437\u0435\u043c\u043b\u0435", true);
        _h = new sbcg("render_equipped_items", "\u041e\u0440\u0443\u0436\u0438\u0435 \u043d\u0430 \u0441\u043f\u0438\u043d\u0435", true);
        _i = new sbcg("bullet_holes", "\u0414\u044b\u0440\u043a\u0438 \u043e\u0442 \u043f\u0443\u043b\u044c", true);
        _j = new jykp("lod_distance", "LOD \u043e\u0440\u0443\u0436\u0438\u044f", kjui._b, kjui2 -> kjui2._f);
        GloomyAPI.registerOption(_e);
        GloomyAPI.registerOption(_f);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @ForgeSubscribe
    public void _a(xqrl xqrl2) {
        sbzn._g.enabled = xqrl2._a > 0;
        sbzn._h.enabled = xqrl2._a > 0;
        sbzn._i.enabled = xqrl2._a > 0;
        sbzn._j.value = xqrl2._a == 3 ? kjui._e.ordinal() : xqrl2._a;
    }

    @Override
    public void onGameJoined() {
        this._p = null;
        _a = new mrof();
        _b = new nuoa();
    }

    @Override
    public void onTickInGame() {
        _a._a();
        _b._a();
        this._d();
        this._b();
    }

    private void _b() {
        float f = sbzn._a();
        jysc jysc2 = jysc._H();
        if (jysc2 != null && f > 0.0f) {
            jysc2._v(0.8 + (double)f * 0.2);
        }
    }

    private void _a(pjux pjux2, cvzo cvzo2) {
        this._r.clear();
        wolf wolf2 = (wolf)cvzo2._a();
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = pjux2._e(cvzo2);
        this._r.add(kjui2);
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            dxwc dxwc2 = (dxwc)wolf2._d(cvzo2, pidb2);
            if (dxwc2 == null) continue;
            iefv iefv2 = dxwc2._d();
            this._r.add(iefv2 == null ? null : iefv2._a(wolf2._i_(cvzo2)));
        }
        for (gloomyfolken.mods.effects.client.mcsa.kjui kjui3 : this._r) {
            if (kjui3 == null || !kjui3._i() || kjui3._b == null || !kjui3._b._i()) continue;
            if (kjui3 == kjui2) {
                if (kjui3._a() == null) continue;
                kjui3._a().getMeshes().forEach(qlgf2 -> {
                    if (pjux._o.test(qlgf2._l)) {
                        kjui2._b._u_()._a(qlgf2._m)._a(0);
                    }
                });
                continue;
            }
            kjui3._b._u_()._a().values().forEach(jgro2 -> jgro2._a(0));
        }
        this._r.clear();
    }

    private void _c() {
        xpzm xpzm2 = xpzm._E();
        for (int i = 0; i < 4; ++i) {
            IItemRenderer iItemRenderer;
            cvzo cvzo2 = xpzm2._t.field_71071_by._a[i];
            if (cvzo2 == null || !(cvzo2._a() instanceof wolf) || (iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) == null || !(iItemRenderer instanceof pjux)) continue;
            this._a((pjux)iItemRenderer, cvzo2);
        }
    }

    private void _d() {
        xpzm xpzm2 = xpzm._E();
        this._c();
        cvzo cvzo2 = xpzm2._D.field_78516_c.field_78453_b;
        if (cvzo2 != this._p) {
            IItemRenderer iItemRenderer;
            this._p = cvzo2;
            ctve ctve2 = _k;
            _k = null;
            if (cvzo2 != null && (iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) != null && iItemRenderer instanceof ycss) {
                _k = ((ycss)((Object)iItemRenderer))._a();
            }
            if (ctve2 != _k && ctve2 != null) {
                ctve2._a(null);
            }
        }
        if (_k != null) {
            _k._a();
        }
    }

    static {
        _l = new uiaq();
        _m = new ndlw();
        _n = new zfvg();
        _o = new HashMap();
        _q = kjui.values();
    }

    public static enum kjui {
        _a("\u0412\u0441\u0435\u0433\u0434\u0430", 0),
        _b("c 8 \u043c", 8),
        _c("c 16 \u043c", 16),
        _d("c 24 \u043c", 24),
        _e("\u041d\u0438\u043a\u043e\u0433\u0434\u0430", 10000);

        public final String _f;
        public final int _g;

        private kjui(String string2, int n2) {
            this._f = string2;
            this._g = n2;
        }
    }
}

