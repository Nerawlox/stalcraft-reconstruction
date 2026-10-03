/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ImmutableMap;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import gloomyfolken.mods.stalker.clans.pidb;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public class hbqf {
    public static final ResourceLocation _a = new ResourceLocation("stalkerclans", "textures/gui/battle_hud.png");
    public static final Map<String, String> _b = ImmutableMap.builder().put("capture", "\u0417\u0430\u0445\u0432\u0430\u0442").put("assist", "\u041f\u043e\u043c\u043e\u0449\u044c \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0435").put("damage", "\u0423\u0440\u043e\u043d \u043f\u043e \u043f\u0440\u043e\u0442\u0438\u0432\u043d\u0438\u043a\u0443").put("spot", "\u041f\u043e\u043c\u043e\u0449\u044c \u0432 \u043e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u0438\u0438").put("point_def", "\u0417\u0430\u0449\u0438\u0442\u0430 \u0442\u043e\u0447\u043a\u0438").put("point_att", "\u0410\u0442\u0430\u043a\u0430 \u0442\u043e\u0447\u043a\u0438").build();
    private static final long _c = 5000L;
    private GuiRenderer _d = new GuiRendererBuilder().setTextureSize(512, 512).setFontRenderer(ExternalFont.tahoma12).create();
    private lnmb _e = new lnmb()._a("scale", new owvh()._a(new ivew(zftb._a, 100L, false))._a(new ivew(zftb._h, 800L, false))._a(new ivew(zftb._a, 3100L, true)))._a("alpha", new owvh()._a(new ivew(zftb._a, 3300L, true))._a(new ivew(zftb._f, 700L, true)))._a("score", new owvh()._a(new ivew(zftb._b, 600L, false))._a(new ivew(zftb._a, 3400L, true)))._a();
    private int _f;
    private String _g;
    private int _h;
    private Queue<pzop<String, Integer, Integer>> _i = new LinkedList<pzop<String, Integer, Integer>>();
    private static final long _j = 4000L;
    private static final long _k = 600L;
    private static final int _l = 0;
    private static final int _m = 1;
    private static final int _n = 2;
    private int _o = 0;
    private long _p = 0L;
    private long _q = 0L;
    private Map<String, pidb> _r = new LinkedHashMap<String, pidb>();
    private qlzo _s = new owvh()._a(new ivew(zftb._f, 700L, false))._a(new ivew(zftb._a, 3500L, true))._a(new ivew(zftb._g, 800L, true))._a();
    private String _t = null;
    private final int _u = 0;
    private final int _v = 1;
    private final int _w = 2;
    private Map<Integer, Integer> _x = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> _y = new HashMap<Integer, Integer>();
    private Map<Integer, Long> _z = new HashMap<Integer, Long>();
    private long _A = 0L;
    private boolean _B = false;
    private long _C;

    private gloomyfolken.mods.stalker.clans.pidb _a() {
        return yuch._c;
    }

    @ForgeSubscribe
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c != lnrm.pidb._b) {
            return;
        }
        gloomyfolken.mods.stalker.clans.pidb pidb2 = this._a();
        this._c();
        this._b();
        if (pidb2 == null) {
            return;
        }
        this._a(pidb2);
        this._d();
    }

    private void _b() {
        if (this._o == 1 && this._C - this._q > 4000L) {
            this._p = this._C;
            this._o = 2;
        } else if (this._o == 2 && this._C - this._p > 600L) {
            this._o = 0;
            this._q = 0L;
            this._p = this._C;
            this._r.clear();
        }
    }

    private void _c() {
        if (!this._i.isEmpty() && this._C - this._e._b() > 4000L) {
            pzop<String, Integer, Integer> pzop2 = this._i.poll();
            this._g = (String)pzop2._a;
            this._h = (Integer)pzop2._b;
            this._f = (Integer)pzop2._c;
            this._e._a();
        }
    }

    public void _a(String string, int n, int n2) {
        this._i.offer(pzop._a(string, n, n2));
    }

    public void _a(String string2, int n) {
        if (this._o == 0) {
            this._o = 1;
            this._p = this._C;
        }
        this._q = this._C;
        this._r.computeIfAbsent(string2, string -> new pidb(_b.getOrDefault(string, (String)string)))._a(n);
    }

    private void _d() {
        Queue<Pair<Integer, Boolean>> queue = yuch._h;
        if (this._C - this._s._c() > this._s._d() && !queue.isEmpty()) {
            Pair<Integer, Boolean> pair = queue.poll();
            char c = (char)(65 + pair.getLeft());
            this._t = pair.getRight() != false ? (Object)((Object)ezfc._k) + "\u041c\u044b \u0437\u0430\u0445\u0432\u0430\u0442\u0438\u043b\u0438 \u0442\u043e\u0447\u043a\u0443 " + c : (Object)((Object)ezfc._m) + "\u0422\u043e\u0447\u043a\u0430 " + c + " \u043f\u043e\u0442\u0435\u0440\u044f\u043d\u0430";
            this._s._a();
        }
    }

    private void _a(gloomyfolken.mods.stalker.clans.pidb pidb2) {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._t == null) {
            return;
        }
        double d = xpzm2._t.field_70165_t;
        double d2 = xpzm2._t.field_70163_u;
        double d3 = xpzm2._t.field_70161_v;
        List<pidb.eidj> list2 = pidb2._f();
        for (int i = 0; i < list2.size(); ++i) {
            pidb.eidj eidj2 = list2.get(i);
            int n = this._y.getOrDefault(i, 0);
            if (n == 0) {
                if (!eidj2._a(d, d2, d3)) continue;
                if (this._a(eidj2)) {
                    this._a(i, 2);
                    continue;
                }
                this._a(i, 1);
                continue;
            }
            if (n == 1) {
                if (!eidj2._a(d, d2, d3)) {
                    this._a(i, 0);
                    continue;
                }
                if (!this._a(eidj2)) continue;
                this._a(i, 2);
                continue;
            }
            if (n != 2) continue;
            if (!eidj2._a(d, d2, d3)) {
                this._a(i, 0);
                continue;
            }
            if (this._a(eidj2)) continue;
            this._a(i, 1);
        }
    }

    private boolean _a(pidb.eidj eidj2) {
        String string = yuch._a._a;
        return eidj2._b() && eidj2._c() == 1.0 && eidj2._a() != null && string.equals(eidj2._a()._b());
    }

    private void _a(int n, int n2) {
        Integer n3 = this._y.put(n, n2);
        this._x.put(n, n3 == null ? 0 : n3);
        this._z.put(n, this._C);
    }

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        this._C = System.currentTimeMillis();
        this._a(post.resolution);
        this._b(post.resolution);
        this._c(post.resolution);
        gloomyfolken.mods.stalker.clans.pidb pidb2 = this._a();
        if (pidb2 == null || pidb2._l().isEmpty() || pidb2._n()) {
            return;
        }
        GL11.glEnable(3042);
        int n = (int)((float)post.resolution._a() / this._d.scale);
        this._a(pidb2, n);
        this._b(pidb2, n);
        this._a(n);
        GL11.glDisable(3042);
    }

    private void _a(htou htou2) {
        long l = this._C - this._A;
        if (l > 5000L) {
            return;
        }
        float f = zftb._f._a(l, 0.0f, 1.0f, 5000.0f);
        String string = this._B ? "\u041f \u041e \u0411 \u0415 \u0414 \u0410" : "\u041f \u041e \u0420 \u0410 \u0416 \u0415 \u041d \u0418 \u0415";
        int n = 0xFFFFFF;
        int n2 = htou2._a() / 2;
        int n3 = htou2._b() / 2 - 50;
        SdfFont.tahoma.renderCenteredString(n2, n3, string, n |= (int)(f * 245.0f + 10.0f) << 24, true, 20.0f + 40.0f * f, SdfFont.FontWeight.Bold.INSTANCE);
    }

    public void _a(boolean bl) {
        this._B = bl;
        this._A = System.currentTimeMillis();
        jysc._c(new kjui());
    }

    private void _a(int n) {
        if (this._t == null) {
            return;
        }
        long l = this._C - this._s._c();
        if (l > this._s._d()) {
            return;
        }
        float f = this._s._b();
        int n2 = (int)(130.0f + 20.0f * f);
        int n3 = Math.min((int)(255.0f * f), 255) << 24;
        int n4 = n3 + 0xFFFFFF;
        if ((n4 & 0xFE000000) == 0) {
            return;
        }
        ExternalFont externalFont = ExternalFont.tahoma14;
        int n5 = externalFont.getStringWidth(this._t);
        this._d.drawRect(n / 2 - n5 - 4, n2 - externalFont.getFontHeight() - 2, n5 * 2 + 8, externalFont.getFontHeight() * 2 + 4, (int)Math.min(f * 40.0f, 40.0f) << 24);
        externalFont.renderCenteredString(this._t, n / 4, n2 / 2, n4, true);
    }

    private void _a(gloomyfolken.mods.stalker.clans.pidb pidb2, int n) {
        int n2 = 438;
        this._d.bindTexture(_a);
        this._d.drawTexturedModalRect(n / 2 - n2, 0, 0, 0, n2, 44);
        this._d.drawTexturedModalRect(n / 2, 0, 0, 56, n2, 44);
        int n3 = pidb2._c().size();
        for (int i = 0; i < n3; ++i) {
            int n4 = i < n3 / 2 ? -n2 + 26 : 68;
            this._a(n / 2 + n4 + i % (n3 > 2 ? 2 : 1) * 175, 8, i);
        }
        LocalTime localTime = qlxw._c._d().toLocalTime();
        LocalTime localTime2 = pidb2._b()._l();
        String string = DurationFormatUtils.formatDuration(Math.max(0L, localTime.until(localTime2, ChronoUnit.MILLIS)), "mm:ss");
        ExternalFont.tahoma18.renderCenteredString(string, n / 4, 10, -1, true);
    }

    private void _b(gloomyfolken.mods.stalker.clans.pidb pidb2, int n) {
        int n2 = pidb2._f().size();
        for (int i = 0; i < n2; ++i) {
            boolean bl;
            GL11.glEnable(3042);
            pidb.eidj eidj2 = pidb2._f().get(i);
            int n3 = this._x.getOrDefault(i, 0);
            int n4 = this._y.getOrDefault(i, 0);
            int n5 = eidj2._g();
            float f = (float)(eidj2._a() == null ? 1.0 : eidj2._c());
            String string = String.valueOf((char)(i + 65));
            int n6 = n / 2 + i * 54 - (n2 - 1) * 54 / 2;
            int n7 = 80;
            long l = 500L;
            long l2 = this._C - this._z.getOrDefault(i, 0L);
            boolean bl2 = bl = n3 == 1 && l2 < l || n4 == 1;
            if (bl) {
                int n8 = n / 2;
                int n9 = 155;
                float f2 = zftb._f._a(Math.min(l2, l - 1L), 0.0f, 1.0f, l);
                if (n3 == 1) {
                    f2 = 1.0f - f2;
                }
                float f3 = jywc._a(n6, (float)n8, f2);
                float f4 = jywc._a(n7, (float)n9, f2);
                float f5 = jywc._a(46.0f, 91.0f, f2);
                yuch._a(f3, f4, f, n5, n5, 106, 261, 4, 261, 91, f5);
                SdfFont.tahoma.renderCenteredString(f3 / 2.0f - 1.5f - 1.5f * f2, f4 / 2.0f - 6.5f - 3.0f * f2, string, -1358954496L, false, 10.0f + 5.0f * f2, SdfFont.FontWeight.Bold.INSTANCE);
                String string2 = eidj2._j()._c();
                int n10 = 0xFFFFFF + ((int)(f2 * 255.0f) << 24);
                if (!string2.isEmpty() && (n10 & 0xFE000000) != 0) {
                    ExternalFont.tahoma14.drawCenteredString(string2, n8 / 2, n9 / 2 + 25, n10);
                }
                this._a(pidb2, eidj2, n8, n9, f2);
                continue;
            }
            yuch._a(n6, n7, f, n5, n5, 92, 129, 42, 125, 46, 46.0f);
            SdfFont.tahoma.renderCenteredString((float)(n6 / 2) - 1.5f, (float)(n7 / 2) - 6.5f, string, -1358954496L, false, 10.0f, SdfFont.FontWeight.Bold.INSTANCE);
        }
    }

    private void _a(gloomyfolken.mods.stalker.clans.pidb pidb2, pidb.eidj eidj2, int n, int n2, float f) {
        Map<pidb.pidb, Integer> map = eidj2._d();
        if (map.size() <= 1) {
            return;
        }
        float f2 = eidj2._e();
        float f3 = 70.0f;
        float f4 = 0.0f;
        for (Map.Entry<pidb.pidb, Integer> entry : map.entrySet()) {
            int n3 = pidb2._l().get(entry.getKey()._b());
            n3 = n3 & 0xFFFFFF | (int)(f * 200.0f) << 24;
            float f5 = (float)entry.getValue().intValue() / f2 * f3;
            this._d.drawRect((float)n - f3 / 2.0f + f4, n2 - 65, f5, 4.0, n3);
            f4 += f5;
        }
    }

    private void _a(int n, int n2, int n3) {
        gloomyfolken.mods.stalker.clans.pidb pidb2 = this._a();
        pidb.pidb pidb3 = pidb2._c().get(n3);
        this._d.bindTexture(_a);
        this._d.drawTexturedModalRect(n + 5, n2, 4, 123, 27, 27);
        if (n3 == 0) {
            this._d.drawTexturedModalRect(n - 5, n2 - 3, 4, 152, 1, 35);
        }
        int n4 = pidb2._l().get(pidb3._b());
        this._d.drawRect(n + 2 + 5, n2 + 2, 23.0, 23.0, n4);
        this._d.drawTexturedModalRect(n + 175, n2 - 3, 4, 152, 1, 35);
        String string = pidb3._b();
        String string2 = this._d.trimToWidth(string, 80, true);
        String string3 = "[" + string2 + "]";
        this._d.drawString(string3, n + 35, n2 + 2, -1);
        int n5 = this._d.getStringWidth(string3);
        int n6 = 165 - (35 + n5);
        int n7 = (int)(pidb3._c() / pidb2._a() * (double)n6);
        int n8 = n + 35 + n5 + 3;
        this._d.drawRect(n8, n2 + 2, n6, 22.0, n4 & 0xFFFFFF | 0x3A000000);
        this._d.drawRect(n8, n2 + 2, n7, 22.0, n4 & 0xFFFFFF | 0x6F000000);
        this._d.drawString(String.valueOf((int)pidb3._c()), n + 35 + n5 + 5, n2 + 3, -1, true);
    }

    private void _b(htou htou2) {
        long l = this._C - this._e._b();
        if (l >= 4000L) {
            return;
        }
        float f = Math.max(1.0E-5f, this._e._a("scale"));
        float f2 = this._e._a("alpha");
        int n = (int)((float)this._h * this._e._a("score"));
        int n2 = (int)(f2 * 255.0f) << 24;
        if ((n2 & 0xFE000000) == 0) {
            return;
        }
        int n3 = htou2._a() / 2;
        int n4 = (int)((float)htou2._b() * 7.0f / 10.0f);
        ExternalFont externalFont = ExternalFont.tahoma14;
        int n5 = externalFont.getStringWidth(this._g + "   +" + this._h);
        int n6 = Math.max(80, n5);
        if (n5 < 80) {
            externalFont = ExternalFont.tahoma16;
        }
        int n7 = -externalFont.getFontHeight() / 2;
        GL11.glTranslatef(n3, n4, 0.0f);
        GL11.glScalef(1.0f, f, 1.0f);
        this._d.drawRect(-n6 - 4, -15.0, n6 * 2 + 8, 30.0, (int)(120.0f * f2) << 24);
        int n8 = externalFont.drawString(this._g + "  ", (double)(-n5 / 2), (double)n7, this._f | n2, true);
        externalFont.drawString("+" + n, (double)n8, (double)n7, 0xFFFFFF | n2, true);
        GL11.glScalef(1.0f, 1.0f / f, 1.0f);
        GL11.glTranslatef(-n3, -n4, 0.0f);
    }

    private void _c(htou htou2) {
        int n = 0;
        for (pidb pidb2 : this._r.values()) {
            pidb2._a(n++, htou2);
        }
    }

    private class kjui
    extends bqzs {
        kjui() {
            super("battle_finish");
        }

        @Override
        protected void update(jysc jysc2) {
            float f = zftb._f._a(hbqf.this._C - hbqf.this._A, 0.0f, 1.0f, 5000.0f);
            jysc2._h(Math.max((double)f, jysc2._h()));
            jysc2._n(Math.max(0.5 * (double)f, jysc2._p()));
        }

        @Override
        protected boolean shouldEffectStop(@NotNull jysc jysc2) {
            if (jysc2 == null) {
                kjui._a(0);
            }
            return hbqf.this._C - hbqf.this._A > 5000L;
        }

        @Override
        public void stop() {
            super.stop();
            this.get_manager()._h(0.0);
            this.get_manager()._n(0.0);
        }

        private static /* synthetic */ void _a(int n) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "manager", "gloomyfolken/mods/stalker/clans/client/gui/BattleHud$BattleEndEffect", "shouldEffectStop"));
        }
    }

    private class pidb {
        private static final long _b = 500L;
        private final String _c;
        private int _d = 0;
        private int _e = 0;
        private long _f = 0L;

        public pidb(String string) {
            this._c = string;
        }

        public void _a(int n, htou htou2) {
            if (hbqf.this._o == 0 || hbqf.this._o == 2 && hbqf.this._C - hbqf.this._p > 600L) {
                return;
            }
            long l = hbqf.this._C - this._f;
            int n2 = (int)zftb._b._a(Math.min(l, 500L), this._d, this._e, 500.0f);
            float f = zftb._h._a(l, 0.0f, 0.1f, 1000.0f) + 0.9f;
            ExternalFont externalFont = ExternalFont.tahoma12;
            String string = this._c + " +" + n2;
            double d = htou2._a() / 2;
            double d2 = (float)htou2._b() * 7.0f / 10.0f + 20.0f + (float)(n * (externalFont.getFontHeight() + 3));
            float f2 = hbqf.this._o != 2 ? 1.0f : zftb._f._a(hbqf.this._C - hbqf.this._p, 1.0f, -1.0f, 600.0f);
            int n3 = 0xFFFFFF + ((int)(f2 * 250.0f + 5.0f) << 24);
            GL11.glTranslated(d, d2, 0.0);
            GL11.glScalef(f, f, 1.0f);
            externalFont.drawString(string, (double)(-externalFont.getStringWidth(string) / 2), 0.0, n3, true);
            GL11.glScalef(1.0f / f, 1.0f / f, 1.0f);
            GL11.glTranslated(-d, -d2, 0.0);
        }

        public void _a(int n) {
            this._f = hbqf.this._C;
            this._d += this._e;
            this._e = n;
        }
    }
}

