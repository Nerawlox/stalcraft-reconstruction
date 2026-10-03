/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class gqtk
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/squid.png");

    public gqtk(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public void _a(EntitySquid entitySquid, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entitySquid, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntitySquid entitySquid) {
        return _a;
    }

    public void _a(EntitySquid entitySquid, float f, float f2, float f3) {
        float f4 = entitySquid.field_70862_e + (entitySquid.field_70861_d - entitySquid.field_70862_e) * f3;
        float f5 = entitySquid.field_70860_g + (entitySquid.field_70859_f - entitySquid.field_70860_g) * f3;
        GL11.glTranslatef(0.0f, 0.5f, 0.0f);
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(f5, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, -1.2f, 0.0f);
    }

    public float _a(EntitySquid entitySquid, float f) {
        return entitySquid.field_70865_by + (entitySquid.field_70866_j - entitySquid.field_70865_by) * f;
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySquid)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        return this._a((EntitySquid)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntitySquid)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySquid)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntitySquid)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntitySquid)entity, d, d2, d3, f, f2);
    }
}

