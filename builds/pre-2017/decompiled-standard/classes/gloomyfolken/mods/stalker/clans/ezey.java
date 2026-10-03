/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.stalker.clans.ClansMod;
import gloomyfolken.mods.stalker.clans.jgro;
import gloomyfolken.mods.stalker.clans.pidb;
import gloomyfolken.mods.stalker.clans.zwat;
import gloomyfolken.mods.stalker.hud.kjui;
import gloomyfolken.mods.stalker.player.qlgf;
import java.util.HashMap;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class ezey {
    private static final float _a = 4096.0f;
    private static final StringBuilder _b = new StringBuilder();
    private static final ResourceLocation _c = new ResourceLocation("stalkerclans", "textures/gui/capture.png");

    @ForgeSubscribe
    public void _a(ycvh ycvh2) {
        qoac qoac2 = ycvh2._a._e;
        if (qoac2 != null && qoac2._c("clan")) {
            ycvh2._b.add((Object)((Object)net.minecraft.util.ezfc._k) + "\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430: " + qoac2._j("clan"));
        }
    }

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("StalcraftClans", new zwat(mquk2._a));
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(RenderLivingEvent.Specials.Pre pre) {
        if (pre.entity instanceof EntityPlayer) {
            pre.setCanceled(true);
        }
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(qlgf.zwat zwat2) {
        zwat2.setCanceled(true);
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(RenderPlayerEvent.Post post) {
        gqqu gqqu2 = gqqu._b;
        double d = this._a(post.entity.field_70169_q, post.entity.field_70165_t, post.partialRenderTick);
        double d2 = this._a(post.entity.field_70167_r, post.entity.field_70163_u, post.partialRenderTick);
        double d3 = this._a(post.entity.field_70166_s, post.entity.field_70161_v, post.partialRenderTick);
        this._a(post.entityPlayer, d - gqqu._d, d2 - gqqu._e, d3 - gqqu._f);
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(qlgf.kjui kjui2) {
        gqqu gqqu2 = gqqu._b;
        float f = xpzm._E()._p._d;
        double d = this._a(kjui2._a.field_70169_q, kjui2._a.field_70165_t, f);
        double d2 = this._a(kjui2._a.field_70167_r, kjui2._a.field_70163_u, f);
        double d3 = this._a(kjui2._a.field_70166_s, kjui2._a.field_70161_v, f);
        this._a(kjui2._a, d - gqqu._d, d2 - gqqu._e, d3 - gqqu._f);
    }

    private double _a(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private boolean _a(EntityPlayer entityPlayer) {
        xpzm xpzm2 = xpzm._E();
        return xpzm._A() && entityPlayer != gqqu._b._j && !entityPlayer.func_98034_c(xpzm2._t) && entityPlayer.field_70153_n == null;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void _a(EntityPlayer entityPlayer, double d, double d2, double d3) {
        boolean bl = ClientProxy.ticker._c == entityPlayer;
        boolean bl2 = ClansMod._F.enabled;
        if ((bl || bl2) && this._a(entityPlayer)) {
            tupg tupg2 = gloomyfolken.mods.faction.pidb._a(entityPlayer)._a();
            zwat zwat2 = zwat._b(xpzm._E()._t);
            String string = tupg2._f + entityPlayer.field_71092_bJ;
            String string2 = zwat._b((EntityPlayer)entityPlayer)._c._b();
            jgro jgro2 = zwat2._a(entityPlayer);
            boolean bl3 = jgro2 == jgro._c || jgro2 == jgro._d;
            int n = jgro2._g;
            int n2 = 0;
            if (string2 != null) {
                HashMap<String, owak> hashMap = yuch._a._t;
                owak owak2 = hashMap.get(string2);
                jgro jgro3 = zwat._a(owak2);
                n2 = jgro3 == null ? 0x11FF11 : jgro3._g;
                bl3 = jgro3 == jgro._c || jgro2 == jgro._d;
                string2 = "<" + string2 + ">";
            }
            this._a(entityPlayer, d, d2, d3, string, string2, n, n2, bl, bl3);
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void _a(EntityPlayer entityPlayer, double d, double d2, double d3, String string, String string2, int n, int n2, boolean bl, boolean bl2) {
        if (entityPlayer.func_70608_bn()) {
            this._b(entityPlayer, d, d2 - 1.5, d3, string, string2, n, n2, bl, bl2);
        } else if (entityPlayer.func_70093_af()) {
            this._b(entityPlayer, d, d2 - 0.25, d3, string, string2, n, n2, bl, bl2);
        } else {
            this._b(entityPlayer, d, d2, d3, string, string2, n, n2, bl, bl2);
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void _b(EntityPlayer entityPlayer, double d, double d2, double d3, String string, String string2, int n, int n2, boolean bl, boolean bl2) {
        if (!bl && !bl2) {
            return;
        }
        float f = (float)Math.sqrt(d * d + d2 * d2 + d3 * d3);
        float f2 = Math.min(Math.max(f / 4.0f, 1.0f), 1.5f);
        float f3 = 0.026666667f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0f, (float)d2 + entityPlayer.field_70131_O + 0.5f, (float)d3);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-gqqu._b._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(gqqu._b._m, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-f3, -f3, f3);
        if (bl2) {
            float f4 = iwya._d;
            float f5 = iwya._e;
            iwya._a(iwya._b, 240.0f, 0.0f);
            this._b(f);
            iwya._d = f4;
            iwya._e = f5;
        }
        if (bl && this._a(f)) {
            ezfc._a();
            ezfc._d();
            ccuh ccuh2 = ccuh._a._a();
            ccuh2._b[1] = string2;
            ccuh2._b[0] = string;
            ccuh2._c[1] = n2;
            ccuh2._c[0] = n;
            ccuh2._d = 6.0f * f2;
            ccuh2.load();
            ezfa._a._b.add(ccuh2);
            ezfc._b();
        }
        GL11.glPopMatrix();
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    private void _b(float f) {
        xpzm xpzm2 = xpzm._E();
        GL11.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glDisable(2896);
        xpzm2._R()._a(oxmc._a);
        float f2 = 0.5f * f * 0.1f * (gloomyfolken.mods.effects.client.main.eidj._a._z / 90.0f);
        float f3 = -8.0f;
        GL11.glTranslatef(0.0f, f3, 0.0f);
        GL11.glScalef(f2, f2, f2);
        qozx._a(-7.0, -6.0, 14.0, 12.0, 480.0, 154.0, 494.0, 166.0, 512.0, 512.0);
        GL11.glScalef(1.0f / f2, 1.0f / f2, 1.0f / f2);
        GL11.glTranslatef(0.0f, -f3, 0.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public boolean _a(float f) {
        float f2 = 16.0f;
        float f3 = f2 * f2;
        float f4 = f * f;
        xpzm xpzm2 = xpzm._E();
        float f5 = xpzm2._D.func_78481_a(xpzm2._p._d, true);
        float f6 = 90.0f;
        float f7 = owxf._a(f6, f3);
        float f8 = owxf._a(f5, f4);
        return f8 > f7;
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(kjui kjui2) {
        boolean bl;
        if (kjui2._a != -1) {
            return;
        }
        Entity entity = ClientProxy.ticker._c;
        xpzm xpzm2 = xpzm._E();
        boolean bl2 = bl = entity != null && entity != gqqu._b._j && !entity.func_98034_c(xpzm2._t) && entity.field_70153_n == null;
        if (!bl) {
            return;
        }
        if (entity instanceof EntityPlayer) {
            HashMap<String, owak> hashMap;
            owak owak2;
            jgro jgro2;
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            zwat zwat2 = zwat._b(xpzm2._t);
            String string = zwat._b((EntityPlayer)entityPlayer)._c._b();
            jgro jgro3 = zwat2._a(entityPlayer);
            if (string != null && (jgro2 = zwat._a(owak2 = (hashMap = yuch._a._t).get(string))) != null && jgro2 != jgro._e) {
                kjui2._a = jgro2 == jgro._d || jgro2 == jgro._c ? -16711936 : -65536;
            }
            boolean bl3 = jgro3 == jgro._d || jgro3 == jgro._c;
            kjui2._a = bl3 ? -16711936 : -65536;
        }
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(RenderGameOverlayEvent.Pre pre) {
        if (pre.type == RenderGameOverlayEvent.ElementType.HOTBAR) {
            GL11.glEnable(3042);
            qmkx qmkx2 = yuch._b;
            if (qmkx2 == null || !qmkx2._a()) {
                return;
            }
            xpzm xpzm2 = xpzm._E();
            stiq stiq2 = xpzm2._J;
            htou htou2 = pre.resolution;
            qncw qncw2 = xpzm2._z;
            xpzm2._h._a(_c);
            float f = qmkx2._a;
            float f2 = Math.min(1.0f, f * 2.0f);
            float f3 = Math.max(0.0f, (f - 0.5f) * 2.0f);
            int n = -27 + qmkx2._e * 3;
            stiq2.func_73729_b(htou2._a() / 2 - 212, n, 0, 0, 212, 27);
            stiq2.func_73729_b(htou2._a() / 2, n, 0, 28, 212, 27);
            stiq2.func_73729_b(htou2._a() / 2 - 212 + 91, 2 + n, 0, 57, (int)(121.0f * f2), 16);
            stiq2.func_73729_b(htou2._a() / 2, 2 + n, 0, 73, (int)(121.0f * f3), 16);
            stiq2.func_73732_a(qncw2, qmkx2._b.isEmpty() ? "\u041d\u0435\u0442" : qmkx2._b, htou2._a() / 2 - 170, 1 + n, 0xFFFFFF);
            stiq2.func_73732_a(qncw2, qmkx2._c.isEmpty() ? "\u041d\u0435\u0442" : qmkx2._c, htou2._a() / 2 + 170, 1 + n, 0xFFFFFF);
            GL11.glDisable(3042);
        }
    }

    @ForgeSubscribe
    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    public void _a(lnrm.kjui kjui2) {
        if (kjui2._c != lnrm.pidb._b) {
            return;
        }
        pidb pidb2 = yuch._c;
        if (pidb2 == null || !yuch._g || pidb2._n()) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B == null) {
            xpzm2._a(new ogia(pidb2, yuch._f));
        }
    }
}

