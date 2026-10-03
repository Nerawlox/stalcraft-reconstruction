/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class qnnk
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/creeper/creeper.png");
    public ModelBase _c = new ModelCreeper(2.0f);

    public qnnk() {
        super(new ModelCreeper(), 0.5f);
    }

    public void _a(EntityCreeper entityCreeper, float f) {
        float f2 = entityCreeper.func_70831_j(f);
        float f3 = 1.0f + sajh._a(f2 * 100.0f) * f2 * 0.01f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        f2 *= f2;
        f2 *= f2;
        float f4 = (1.0f + f2 * 0.4f) * f3;
        float f5 = (1.0f + f2 * 0.1f) / f3;
        GL11.glScalef(f4, f5, f4);
    }

    public int _a(EntityCreeper entityCreeper, float f, float f2) {
        float f3 = entityCreeper.func_70831_j(f2);
        if ((int)(f3 * 10.0f) % 2 == 0) {
            return 0;
        }
        int n = (int)(f3 * 0.2f * 255.0f);
        if (n < 0) {
            n = 0;
        }
        if (n > 255) {
            n = 255;
        }
        int n2 = 255;
        int n3 = 255;
        int n4 = 255;
        return n << 24 | n2 << 16 | n3 << 8 | n4;
    }

    public int _a(EntityCreeper entityCreeper, int n, float f) {
        if (entityCreeper.func_70830_n()) {
            if (entityCreeper.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }
            if (n == 1) {
                float f2 = (float)entityCreeper.field_70173_aa + f;
                this.func_110776_a(_a);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f3 = f2 * 0.01f;
                float f4 = f2 * 0.01f;
                GL11.glTranslatef(f3, f4, 0.0f);
                this.func_77042_a(this._c);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f5 = 0.5f;
                GL11.glColor4f(f5, f5, f5, 1.0f);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
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

    public int _b(EntityCreeper entityCreeper, int n, float f) {
        return -1;
    }

    public ResourceLocation _a(EntityCreeper entityCreeper) {
        return _b;
    }

    @Override
    public /* synthetic */ void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityCreeper)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ int func_77030_a(EntityLivingBase entityLivingBase, float f, float f2) {
        return this._a((EntityCreeper)entityLivingBase, f, f2);
    }

    @Override
    public /* synthetic */ int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityCreeper)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ int func_77035_b(EntityLivingBase entityLivingBase, int n, float f) {
        return this._b((EntityCreeper)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityCreeper)entity);
    }
}

