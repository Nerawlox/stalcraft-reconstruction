/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class wpcc
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/snowman.png");
    public ModelSnowMan _b;

    public wpcc() {
        super(new ModelSnowMan(), 0.5f);
        this._b = (ModelSnowMan)this.field_77045_g;
        this.func_77042_a(this._b);
    }

    public void _a(EntitySnowman entitySnowman, float f) {
        super.func_77029_c(entitySnowman, f);
        cvzo cvzo2 = new cvzo(twgu.field_72061_ba, 1);
        if (cvzo2 != null && cvzo2._a() instanceof mbpd) {
            boolean bl;
            GL11.glPushMatrix();
            this._b.field_78195_c.func_78794_c(0.0625f);
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean bl2 = bl = iItemRenderer != null && iItemRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, cvzo2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (bl || htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                float f2 = 0.625f;
                GL11.glTranslatef(0.0f, -0.34375f, 0.0f);
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f2, -f2, f2);
            }
            this.field_76990_c._h.func_78443_a(entitySnowman, cvzo2, 0);
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation _a(EntitySnowman entitySnowman) {
        return _a;
    }

    @Override
    public void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this._a((EntitySnowman)entityLivingBase, f);
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntitySnowman)entity);
    }
}

