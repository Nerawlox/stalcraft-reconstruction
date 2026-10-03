/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class bbbv
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/iron_golem.png");
    public final ModelIronGolem _b;

    public bbbv() {
        super(new ModelIronGolem(), 0.5f);
        this._b = (ModelIronGolem)this.field_77045_g;
    }

    public void _a(EntityIronGolem entityIronGolem, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entityIronGolem, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityIronGolem entityIronGolem) {
        return _a;
    }

    public void _a(EntityIronGolem entityIronGolem, float f, float f2, float f3) {
        super.func_77043_a(entityIronGolem, f, f2, f3);
        if ((double)entityIronGolem.field_70721_aZ < 0.01) {
            return;
        }
        float f4 = 13.0f;
        float f5 = entityIronGolem.field_70754_ba - entityIronGolem.field_70721_aZ * (1.0f - f3) + 6.0f;
        float f6 = (Math.abs(f5 % f4 - f4 * 0.5f) - f4 * 0.25f) / (f4 * 0.25f);
        GL11.glRotatef(6.5f * f6, 0.0f, 0.0f, 1.0f);
    }

    public void _a(EntityIronGolem entityIronGolem, float f) {
        super.func_77029_c(entityIronGolem, f);
        if (entityIronGolem.func_70853_p() == 0) {
            return;
        }
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glRotatef(5.0f + 180.0f * this._b.field_78177_c.field_78795_f / (float)Math.PI, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(-0.6875f, 1.25f, -0.9375f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        float f2 = 0.8f;
        GL11.glScalef(f2, -f2, f2);
        int n = entityIronGolem.func_70070_b(f);
        int n2 = n % 65536;
        int n3 = n / 65536;
        iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.func_110776_a(sctd._c);
        this.field_76988_d._a((twgu)twgu.field_72107_ae, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glDisable(32826);
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityIronGolem)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityIronGolem)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntityIronGolem)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityIronGolem)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityIronGolem)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityIronGolem)entity, d, d2, d3, f, f2);
    }
}

