/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.stalker.player.kjui;
import gloomyfolken.mods.stalker.player.tupg;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class jxtc
extends tupg {
    public static ModelBiped _e = new ModelBiped();
    private static zxbe _f = new zxbe((jhuw)tupg._a._a, new iest[0]);

    @Override
    protected zxbe _d() {
        return _f;
    }

    @Override
    protected ModelBiped _e() {
        return _e;
    }

    @Override
    protected void _a(float f, float f2, float f3, float f4, float f5, float f6, float f7, AbstractClientPlayer abstractClientPlayer, boolean bl, float f8) {
        this._a(_e, abstractClientPlayer, f8);
    }

    @Override
    protected void _a(AbstractClientPlayer abstractClientPlayer, boolean bl) {
        if (abstractClientPlayer.func_70093_af()) {
            ezfc._a(0.0f, -0.125f, 0.0f);
        }
    }

    @Override
    public void _a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (this.func_110813_b(abstractClientPlayer)) {
            float f;
            float f2 = 1.6f;
            float f3 = 0.016666668f * f2;
            double d4 = abstractClientPlayer.func_70068_e(this.field_76990_c._j);
            float f4 = f = abstractClientPlayer.func_70093_af() ? msev.NAME_TAG_RANGE_SNEAK : msev.NAME_TAG_RANGE;
            if (d4 <= (double)(f * f)) {
                String string = abstractClientPlayer.func_96090_ax();
                if (abstractClientPlayer.func_70093_af()) {
                    qncw qncw2 = this.func_76983_a();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)d + 0.0f, (float)d2 + abstractClientPlayer.field_70131_O + 0.5f, (float)d3);
                    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
                    GL11.glScalef(-f3, -f3, f3);
                    GL11.glDisable(2896);
                    GL11.glTranslatef(0.0f, 0.25f / f3, 0.0f);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    htvf htvf2 = htvf.field_78398_a;
                    GL11.glDisable(3553);
                    htvf2.func_78382_b();
                    int n = qncw2._b(string) / 2;
                    htvf2.func_78369_a(0.0f, 0.0f, 0.0f, 0.25f);
                    htvf2.func_78377_a(-n - 1, -1.0, 0.0);
                    htvf2.func_78377_a(-n - 1, 8.0, 0.0);
                    htvf2.func_78377_a(n + 1, 8.0, 0.0);
                    htvf2.func_78377_a(n + 1, -1.0, 0.0);
                    htvf2.func_78381_a();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    qncw2._b(string, -qncw2._b(string) / 2, 0, 0x20FFFFFF);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glPopMatrix();
                } else {
                    this.func_96449_a(abstractClientPlayer, d, d2, d3, string, f3, d4);
                }
            }
        }
    }

    static {
        _f._b(new kjui(new nuco(), _e));
    }
}

