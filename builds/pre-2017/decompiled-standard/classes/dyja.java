/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class dyja
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/bat.png");
    public int _b;

    public dyja() {
        super(new ModelBat(), 0.25f);
        this._b = ((ModelBat)this.field_77045_g).func_82889_a();
    }

    public void _a(EntityBat entityBat, double d, double d2, double d3, float f, float f2) {
        int n = ((ModelBat)this.field_77045_g).func_82889_a();
        if (n != this._b) {
            this._b = n;
            this.field_77045_g = new ModelBat();
        }
        super.func_77031_a(entityBat, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityBat entityBat) {
        return _a;
    }

    public void _a(EntityBat entityBat, float f) {
        GL11.glScalef(0.35f, 0.35f, 0.35f);
    }

    public void _a(EntityBat entityBat, double d, double d2, double d3) {
        super.func_77039_a(entityBat, d, d2, d3);
    }

    public void _a(EntityBat entityBat, float f, float f2, float f3) {
        if (!entityBat.func_82235_h()) {
            GL11.glTranslatef(0.0f, sajh._b(f * 0.3f) * 0.1f, 0.0f);
        } else {
            GL11.glTranslatef(0.0f, -0.1f, 0.0f);
        }
        super.func_77043_a(entityBat, f, f2, f3);
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBat)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityBat)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntityBat)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void func_77039_a(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this._a((EntityBat)entityLivingBase, d, d2, d3);
    }

    @Override
    public /* synthetic */ void func_130000_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBat)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityBat)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBat)entity, d, d2, d3, f, f2);
    }
}

