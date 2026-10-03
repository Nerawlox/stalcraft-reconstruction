/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class cvjc
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/cat/black.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/cat/ocelot.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/cat/red.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/cat/siamese.png");

    public cvjc(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    public void _a(EntityOcelot entityOcelot, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entityOcelot, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityOcelot entityOcelot) {
        switch (entityOcelot.func_70913_u()) {
            default: {
                return _b;
            }
            case 1: {
                return _a;
            }
            case 2: {
                return _c;
            }
            case 3: 
        }
        return _d;
    }

    public void _a(EntityOcelot entityOcelot, float f) {
        super.func_77041_b(entityOcelot, f);
        if (entityOcelot.func_70909_n()) {
            GL11.glScalef(0.8f, 0.8f, 0.8f);
        }
    }

    @Override
    public /* synthetic */ void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityOcelot)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityOcelot)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityOcelot)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityOcelot)entity);
    }

    @Override
    public /* synthetic */ void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityOcelot)entity, d, d2, d3, f, f2);
    }
}

