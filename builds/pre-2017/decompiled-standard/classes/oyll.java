/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelWitch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class oyll
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/witch.png");
    public final ModelWitch _b;

    public oyll() {
        super(new ModelWitch(0.0f), 0.5f);
        this._b = (ModelWitch)this.field_77045_g;
    }

    public void _a(EntityWitch entityWitch, double d, double d2, double d3, float f, float f2) {
        cvzo cvzo2 = entityWitch.func_70694_bm();
        this._b.field_82900_g = cvzo2 != null;
        super.func_77031_a(entityWitch, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityWitch entityWitch) {
        return _a;
    }

    public void _a(EntityWitch entityWitch, float f) {
        float f2 = 1.0f;
        GL11.glColor3f(f2, f2, f2);
        super.func_77029_c(entityWitch, f);
        cvzo cvzo2 = entityWitch.func_70694_bm();
        if (cvzo2 != null) {
            float f3;
            GL11.glPushMatrix();
            if (this.field_77045_g.field_78091_s) {
                f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
            }
            this._b.field_82898_f.func_78794_c(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.53125f, 0.21875f);
            if (cvzo2._d < 256 && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3 *= 0.75f, -f3, f3);
            } else if (cvzo2._d == tgdv.field_77707_k.field_77779_bT) {
                f3 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else if (tgdv.field_77698_e[cvzo2._d].func_77662_d()) {
                f3 = 0.625f;
                if (tgdv.field_77698_e[cvzo2._d].func_77629_n_()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                this._a();
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                f3 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f3, f3, f3);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
            this.field_76990_c._h.func_78443_a(entityWitch, cvzo2, 0);
            if (cvzo2._a().func_77623_v()) {
                this.field_76990_c._h.func_78443_a(entityWitch, cvzo2, 1);
            }
            GL11.glPopMatrix();
        }
    }

    public void _a() {
        GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
    }

    public void _b(EntityWitch entityWitch, float f) {
        float f2 = 0.9375f;
        GL11.glScalef(f2, f2, f2);
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitch)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._b((EntityWitch)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityWitch)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitch)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityWitch)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWitch)entity, d, d2, d3, f, f2);
    }
}

