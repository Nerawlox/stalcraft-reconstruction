/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.kjui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class tfui
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    public ModelDragon _e;

    public tfui() {
        super(new ModelDragon(0.0f), 0.5f);
        this._e = (ModelDragon)this.field_77045_g;
        this.func_77042_a(this.field_77045_g);
    }

    public void _a(EntityDragon entityDragon, float f, float f2, float f3) {
        float f4 = (float)entityDragon.func_70974_a(7, f3)[0];
        float f5 = (float)(entityDragon.func_70974_a(5, f3)[1] - entityDragon.func_70974_a(10, f3)[1]);
        GL11.glRotatef(-f4, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(f5 * 10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
        if (entityDragon.field_70725_aQ > 0) {
            float f6 = ((float)entityDragon.field_70725_aQ + f3 - 1.0f) / 20.0f * 1.6f;
            if ((f6 = sajh._c(f6)) > 1.0f) {
                f6 = 1.0f;
            }
            GL11.glRotatef(f6 * this.func_77037_a(entityDragon), 0.0f, 0.0f, 1.0f);
        }
    }

    public void _a(EntityDragon entityDragon, float f, float f2, float f3, float f4, float f5, float f6) {
        if (entityDragon.field_70995_bG > 0) {
            float f7 = (float)entityDragon.field_70995_bG / 200.0f;
            GL11.glDepthFunc(515);
            GL11.glEnable(3008);
            GL11.glAlphaFunc(516, f7);
            this.func_110776_a(_a);
            this.field_77045_g.func_78088_a(entityDragon, f, f2, f3, f4, f5, f6);
            GL11.glAlphaFunc(516, 0.1f);
            GL11.glDepthFunc(514);
        }
        this.func_110777_b(entityDragon);
        this.field_77045_g.func_78088_a(entityDragon, f, f2, f3, f4, f5, f6);
        if (entityDragon.field_70737_aN > 0) {
            GL11.glDepthFunc(514);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
            this.field_77045_g.func_78088_a(entityDragon, f, f2, f3, f4, f5, f6);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDepthFunc(515);
        }
    }

    public void _a(EntityDragon entityDragon, double d, double d2, double d3, float f, float f2) {
        kjui._a(entityDragon, false);
        super.func_77031_a(entityDragon, d, d2, d3, f, f2);
        if (entityDragon.field_70992_bH != null) {
            float f3 = (float)entityDragon.field_70992_bH.field_70261_a + f2;
            float f4 = sajh._a(f3 * 0.2f) / 2.0f + 0.5f;
            f4 = (f4 * f4 + f4) * 0.2f;
            float f5 = (float)(entityDragon.field_70992_bH.field_70165_t - entityDragon.field_70165_t - (entityDragon.field_70169_q - entityDragon.field_70165_t) * (double)(1.0f - f2));
            float f6 = (float)((double)f4 + entityDragon.field_70992_bH.field_70163_u - 1.0 - entityDragon.field_70163_u - (entityDragon.field_70167_r - entityDragon.field_70163_u) * (double)(1.0f - f2));
            float f7 = (float)(entityDragon.field_70992_bH.field_70161_v - entityDragon.field_70161_v - (entityDragon.field_70166_s - entityDragon.field_70161_v) * (double)(1.0f - f2));
            float f8 = sajh._c(f5 * f5 + f7 * f7);
            float f9 = sajh._c(f5 * f5 + f6 * f6 + f7 * f7);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d, (float)d2 + 2.0f, (float)d3);
            GL11.glRotatef((float)(-Math.atan2(f7, f5)) * 180.0f / (float)Math.PI - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef((float)(-Math.atan2(f8, f6)) * 180.0f / (float)Math.PI - 90.0f, 1.0f, 0.0f, 0.0f);
            htvf htvf2 = htvf.field_78398_a;
            qnon._a();
            GL11.glDisable(2884);
            this.func_110776_a(_b);
            GL11.glShadeModel(7425);
            float f10 = 0.0f - ((float)entityDragon.field_70173_aa + f2) * 0.01f;
            float f11 = sajh._c(f5 * f5 + f6 * f6 + f7 * f7) / 32.0f - ((float)entityDragon.field_70173_aa + f2) * 0.01f;
            htvf2.func_78371_b(5);
            int n = 8;
            for (int i = 0; i <= n; ++i) {
                float f12 = sajh._a((float)(i % n) * (float)Math.PI * 2.0f / (float)n) * 0.75f;
                float f13 = sajh._b((float)(i % n) * (float)Math.PI * 2.0f / (float)n) * 0.75f;
                float f14 = (float)(i % n) * 1.0f / (float)n;
                htvf2.func_78378_d(0);
                htvf2.func_78374_a(f12 * 0.2f, f13 * 0.2f, 0.0, f14, f11);
                htvf2.func_78378_d(0xFFFFFF);
                htvf2.func_78374_a(f12, f13, f9, f14, f10);
            }
            htvf2.func_78381_a();
            GL11.glEnable(2884);
            GL11.glShadeModel(7424);
            qnon._b();
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation _a(EntityDragon entityDragon) {
        return _d;
    }

    public void _a(EntityDragon entityDragon, float f) {
        super.func_77029_c(entityDragon, f);
        htvf htvf2 = htvf.field_78398_a;
        if (entityDragon.field_70995_bG > 0) {
            qnon._a();
            float f2 = ((float)entityDragon.field_70995_bG + f) / 200.0f;
            float f3 = 0.0f;
            if (f2 > 0.8f) {
                f3 = (f2 - 0.8f) / 0.2f;
            }
            Random random = new Random(432L);
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(3008);
            GL11.glEnable(2884);
            GL11.glDepthMask(false);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, -1.0f, -2.0f);
            int n = 0;
            while ((float)n < (f2 + f2 * f2) / 2.0f * 60.0f) {
                GL11.glRotatef(random.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(random.nextFloat() * 360.0f + f2 * 90.0f, 0.0f, 0.0f, 1.0f);
                htvf2.func_78371_b(6);
                float f4 = random.nextFloat() * 20.0f + 5.0f + f3 * 10.0f;
                float f5 = random.nextFloat() * 2.0f + 1.0f + f3 * 2.0f;
                htvf2.func_78384_a(0xFFFFFF, (int)(255.0f * (1.0f - f3)));
                htvf2.func_78377_a(0.0, 0.0, 0.0);
                htvf2.func_78384_a(0xFF00FF, 0);
                htvf2.func_78377_a(-0.866 * (double)f5, f4, -0.5f * f5);
                htvf2.func_78377_a(0.866 * (double)f5, f4, -0.5f * f5);
                htvf2.func_78377_a(0.0, f4, 1.0f * f5);
                htvf2.func_78377_a(-0.866 * (double)f5, f4, -0.5f * f5);
                htvf2.func_78381_a();
                ++n;
            }
            GL11.glPopMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            qnon._b();
        }
    }

    public int _a(EntityDragon entityDragon, int n, float f) {
        if (n == 1) {
            GL11.glDepthFunc(515);
        }
        if (n != 0) {
            return -1;
        }
        this.func_110776_a(_c);
        float f2 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        GL11.glDisable(2896);
        GL11.glDepthFunc(514);
        int n2 = 61680;
        int n3 = n2 % 65536;
        int n4 = n2 / 65536;
        iwya._a(iwya._b, (float)n3 / 1.0f, (float)n4 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
        return 1;
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityDragon)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityDragon)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityDragon)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntityDragon)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void func_77036_a(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this._a((EntityDragon)entityLivingBase, f, f2, f3, f4, f5, f6);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityDragon)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityDragon)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityDragon)entity, d, d2, d3, f, f2);
    }
}

