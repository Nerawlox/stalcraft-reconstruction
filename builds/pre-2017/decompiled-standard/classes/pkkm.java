/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class pkkm
extends yvic {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/spider/cave_spider.png");

    public pkkm() {
        this.field_76989_e *= 0.7f;
    }

    public void _a(EntityCaveSpider entityCaveSpider, float f) {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
    }

    public ResourceLocation _a(EntityCaveSpider entityCaveSpider) {
        return _a;
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityCaveSpider)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityCaveSpider)entity);
    }
}

