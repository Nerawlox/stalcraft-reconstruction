/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class gqqi
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/enderman/enderman.png");
    public ModelEnderman _c;
    public Random _d = new Random();

    public gqqi() {
        super(new ModelEnderman(), 0.5f);
        this._c = (ModelEnderman)this.mainModel;
        this.setRenderPassModel(this._c);
    }

    public void _a(EntityEnderman entityEnderman, double d, double d2, double d3, float f, float f2) {
        this._c.isCarrying = entityEnderman.getCarried() > 0;
        this._c.isAttacking = entityEnderman.isScreaming();
        if (entityEnderman.isScreaming()) {
            double d4 = 0.02;
            d += this._d.nextGaussian() * d4;
            d3 += this._d.nextGaussian() * d4;
        }
        super.doRenderLiving(entityEnderman, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityEnderman entityEnderman) {
        return _b;
    }

    public void _a(EntityEnderman entityEnderman, float f) {
        super.renderEquippedItems(entityEnderman, f);
        if (entityEnderman.getCarried() > 0) {
            GL11.glEnable(32826);
            GL11.glPushMatrix();
            float f2 = 0.5f;
            GL11.glTranslatef(0.0f, 0.6875f, -0.75f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(-(f2 *= 1.0f), -f2, f2);
            int n = entityEnderman.getBrightnessForRender(f);
            int n2 = n % 65536;
            int n3 = n / 65536;
            iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindTexture(sctd._c);
            this.renderBlocks._a(Block.blocksList[entityEnderman.getCarried()], entityEnderman.getCarryingData(), 1.0f);
            GL11.glPopMatrix();
            GL11.glDisable(32826);
        }
    }

    public int _a(EntityEnderman entityEnderman, int n, float f) {
        if (n != 0) {
            return -1;
        }
        this.bindTexture(_a);
        float f2 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        GL11.glDisable(2896);
        if (entityEnderman.isInvisible()) {
            GL11.glDepthMask(false);
        } else {
            GL11.glDepthMask(true);
        }
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
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityEnderman)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityEnderman)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityEnderman)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityEnderman)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityEnderman)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityEnderman)entity, d, d2, d3, f, f2);
    }
}

