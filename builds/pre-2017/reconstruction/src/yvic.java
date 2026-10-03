/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class yvic
extends RenderLiving {
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/spider_eyes.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/spider/spider.png");

    public yvic() {
        super(new ModelSpider(), 1.0f);
        this.setRenderPassModel(new ModelSpider());
    }

    public float _b(EntitySpider entitySpider) {
        return 180.0f;
    }

    public int _a(EntitySpider entitySpider, int n, float f) {
        if (n != 0) {
            return -1;
        }
        this.bindTexture(_b);
        float f2 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (entitySpider.isInvisible()) {
            GL11.glDepthMask(false);
        } else {
            GL11.glDepthMask(true);
        }
        int n2 = 61680;
        int n3 = n2 % 65536;
        int n4 = n2 / 65536;
        iwya._a(iwya._b, (float)n3 / 1.0f, (float)n4 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
        return 1;
    }

    public ResourceLocation _a(EntitySpider entitySpider) {
        return _c;
    }

    @Override
    public /* synthetic */ float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
        return this._b((EntitySpider)entityLivingBase);
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntitySpider)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntitySpider)entity);
    }
}

