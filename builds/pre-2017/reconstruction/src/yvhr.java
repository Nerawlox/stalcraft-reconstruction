/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.kjui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class yvhr
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/wither/wither.png");
    public int _c;

    public yvhr() {
        super(new ModelWither(), 1.0f);
        this._c = ((ModelWither)this.mainModel).func_82903_a();
    }

    public void _a(EntityWither entityWither, double d, double d2, double d3, float f, float f2) {
        kjui._a(entityWither, true);
        int n = ((ModelWither)this.mainModel).func_82903_a();
        if (n != this._c) {
            this._c = n;
            this.mainModel = new ModelWither();
        }
        super.doRenderLiving(entityWither, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityWither entityWither) {
        int n = entityWither.func_82212_n();
        if (n <= 0 || n <= 80 && n / 5 % 2 == 1) {
            return _b;
        }
        return _a;
    }

    public void _a(EntityWither entityWither, float f) {
        int n = entityWither.func_82212_n();
        if (n > 0) {
            float f2 = 2.0f - ((float)n - f) / 220.0f * 0.5f;
            GL11.glScalef(f2, f2, f2);
        } else {
            GL11.glScalef(2.0f, 2.0f, 2.0f);
        }
    }

    public int _a(EntityWither entityWither, int n, float f) {
        if (entityWither.isArmored()) {
            if (entityWither.isInvisible()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }
            if (n == 1) {
                float f2 = (float)entityWither.ticksExisted + f;
                this.bindTexture(_a);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f3 = sajh._b(f2 * 0.02f) * 3.0f;
                float f4 = f2 * 0.01f;
                GL11.glTranslatef(f3, f4, 0.0f);
                this.setRenderPassModel(this.mainModel);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f5 = 0.5f;
                GL11.glColor4f(f5, f5, f5, 1.0f);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                GL11.glTranslatef(0.0f, -0.01f, 0.0f);
                GL11.glScalef(1.1f, 1.1f, 1.1f);
                return 1;
            }
            if (n == 2) {
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }
        return -1;
    }

    public int _b(EntityWither entityWither, int n, float f) {
        return -1;
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWither)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityWither)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityWither)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ int inheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._b((EntityWither)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWither)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityWither)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityWither)entity, d, d2, d3, f, f2);
    }
}

