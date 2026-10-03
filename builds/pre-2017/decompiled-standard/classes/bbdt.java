/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bbdt
extends tfvm {
    public static final ResourceLocation _a = new ResourceLocation("textures/map/map_background.png");
    public final htvc _b = new htvc();
    public dwan _c;

    @Override
    public void func_94143_a(nege nege2) {
        this._c = nege2._b("itemframe_background");
    }

    public void _a(EntityItemFrame entityItemFrame, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        float f3 = (float)(entityItemFrame.field_70165_t - d) - 0.5f;
        float f4 = (float)(entityItemFrame.field_70163_u - d2) - 0.5f;
        float f5 = (float)(entityItemFrame.field_70161_v - d3) - 0.5f;
        int n = entityItemFrame.field_70523_b + ugqx._a[entityItemFrame.field_82332_a];
        int n2 = entityItemFrame.field_70524_c;
        int n3 = entityItemFrame.field_70521_d + ugqx._b[entityItemFrame.field_82332_a];
        GL11.glTranslatef((float)n - f3, (float)n2 - f4, (float)n3 - f5);
        this._b(entityItemFrame);
        this._c(entityItemFrame);
        GL11.glPopMatrix();
    }

    public ResourceLocation _a(EntityItemFrame entityItemFrame) {
        return null;
    }

    public void _b(EntityItemFrame entityItemFrame) {
        GL11.glPushMatrix();
        GL11.glRotatef(entityItemFrame.field_70177_z, 0.0f, 1.0f, 0.0f);
        this.field_76990_c._g._a(sctd._c);
        twgu twgu2 = twgu.field_71988_x;
        float f = 0.0625f;
        float f2 = 0.75f;
        float f3 = f2 / 2.0f;
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3 + 0.0625f, 0.5f - f3 + 0.0625f, f * 0.5f, 0.5f + f3 - 0.0625f, 0.5f + f3 - 0.0625f);
        this._b._a(this._c);
        this._b._a(twgu2, 0, 1.0f);
        this._b._a();
        this._b._c();
        GL11.glPopMatrix();
        this._b._a(twgu.field_71988_x.func_71858_a(1, 2));
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3, 0.5f - f3, f + 1.0E-4f, f + 0.5f - f3, 0.5f + f3);
        this._b._a(twgu2, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f + f3 - f, 0.5f - f3, f + 1.0E-4f, 0.5f + f3, 0.5f + f3);
        this._b._a(twgu2, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3, 0.5f - f3, f, 0.5f + f3, f + 0.5f - f3);
        this._b._a(twgu2, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this._b._b(0.0, 0.5f - f3, 0.5f + f3 - f, f, 0.5f + f3, 0.5f + f3);
        this._b._a(twgu2, 0, 1.0f);
        GL11.glPopMatrix();
        this._b._c();
        this._b._a();
        GL11.glPopMatrix();
    }

    public void _c(EntityItemFrame entityItemFrame) {
        cvzo cvzo2 = entityItemFrame.func_82335_i();
        if (cvzo2 != null) {
            EntityItem entityItem = new EntityItem(entityItemFrame.field_70170_p, 0.0, 0.0, 0.0, cvzo2);
            entityItem.func_92059_d()._b = 1;
            entityItem.field_70290_d = 0.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.453125f * (float)ugqx._a[entityItemFrame.field_82332_a], -0.18f, -0.453125f * (float)ugqx._b[entityItemFrame.field_82332_a]);
            GL11.glRotatef(180.0f + entityItemFrame.field_70177_z, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90 * entityItemFrame.func_82333_j(), 0.0f, 0.0f, 1.0f);
            switch (entityItemFrame.func_82333_j()) {
                case 1: {
                    GL11.glTranslatef(-0.16f, -0.16f, 0.0f);
                    break;
                }
                case 2: {
                    GL11.glTranslatef(0.0f, -0.32f, 0.0f);
                    break;
                }
                case 3: {
                    GL11.glTranslatef(0.16f, -0.16f, 0.0f);
                }
            }
            if (entityItem.func_92059_d()._a() == tgdv.field_77744_bd) {
                this.field_76990_c._g._a(_a);
                htvf htvf2 = htvf.field_78398_a;
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScalef(0.00390625f, 0.00390625f, 0.00390625f);
                GL11.glTranslatef(-65.0f, -107.0f, -3.0f);
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                htvf2.func_78382_b();
                int n = 7;
                htvf2.func_78374_a(0 - n, 128 + n, 0.0, 0.0, 1.0);
                htvf2.func_78374_a(128 + n, 128 + n, 0.0, 1.0, 1.0);
                htvf2.func_78374_a(128 + n, 0 - n, 0.0, 1.0, 0.0);
                htvf2.func_78374_a(0 - n, 0 - n, 0.0, 0.0, 0.0);
                htvf2.func_78381_a();
                thdd thdd2 = tgdv.field_77744_bd._a(entityItem.func_92059_d(), entityItemFrame.field_70170_p);
                GL11.glTranslatef(0.0f, 0.0f, -1.0f);
                if (thdd2 != null) {
                    this.field_76990_c._h.field_78449_f._a(null, this.field_76990_c._g, thdd2);
                }
            } else {
                Object object;
                if (entityItem.func_92059_d()._a() == tgdv.field_77750_aQ) {
                    object = xpzm._E()._R();
                    ((apbu)object)._a(sctd._e);
                    dhji dhji2 = ((sctd)((apbu)object)._b(sctd._e))._d(tgdv.field_77750_aQ.func_77650_f(entityItem.func_92059_d()).func_94215_i());
                    if (dhji2 instanceof twyn) {
                        twyn twyn2 = (twyn)dhji2;
                        double d = twyn2._a;
                        double d2 = twyn2._b;
                        twyn2._a = 0.0;
                        twyn2._b = 0.0;
                        twyn2._a(entityItemFrame.field_70170_p, entityItemFrame.field_70165_t, entityItemFrame.field_70161_v, sajh._g(180 + entityItemFrame.field_82332_a * 90), false, true);
                        twyn2._a = d;
                        twyn2._b = d2;
                    }
                }
                xsbj.field_82407_g = true;
                gqqu._b._a(entityItem, 0.0, 0.0, 0.0, 0.0f, 0.0f);
                xsbj.field_82407_g = false;
                if (entityItem.func_92059_d()._a() == tgdv.field_77750_aQ) {
                    object = ((sctd)xpzm._E()._R()._b(sctd._e))._d(tgdv.field_77750_aQ.func_77650_f(entityItem.func_92059_d()).func_94215_i());
                }
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityItemFrame)entity);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityItemFrame)entity, d, d2, d3, f, f2);
    }
}

