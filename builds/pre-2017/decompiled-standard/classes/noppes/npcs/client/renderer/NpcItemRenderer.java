/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import gloomyfolken.mods.asm.ItemAtlasHooks;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraftforge.client.IItemRenderer;
import noppes.npcs.items.ItemRenderInterface;
import org.lwjgl.opengl.GL11;

public class NpcItemRenderer
implements IItemRenderer {
    private static final ResourceLocation field_110930_b = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    @Override
    public boolean handleRenderType(cvzo cvzo2, IItemRenderer.ItemRenderType itemRenderType) {
        return itemRenderType == IItemRenderer.ItemRenderType.EQUIPPED;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, cvzo cvzo2, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return false;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType itemRenderType, cvzo cvzo2, Object ... objectArray) {
        if (cvzo2._a() instanceof ItemRenderInterface) {
            GL11.glTranslatef(0.9375f, 0.0625f, 0.0f);
            GL11.glRotatef(-335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            ((ItemRenderInterface)((Object)cvzo2._a())).renderSpecial();
            this.renderItem3d((EntityLivingBase)objectArray[1], cvzo2);
        }
    }

    public void renderItem3d(EntityLivingBase entityLivingBase, cvzo cvzo2) {
        xpzm xpzm2 = xpzm._E();
        apbu apbu2 = xpzm2._R();
        int n = 0;
        htvf htvf2 = htvf.field_78398_a;
        dwan dwan2 = entityLivingBase.func_70620_b(cvzo2, n);
        if (dwan2 != null) {
            ItemAtlasHooks.bindItemTexture(dwan2, 0.0f);
            float f = dwan2.func_94209_e();
            float f2 = dwan2.func_94212_f();
            float f3 = dwan2.func_94206_g();
            float f4 = dwan2.func_94210_h();
            float f5 = 0.0f;
            float f6 = 0.3f;
            GL11.glEnable(32826);
            GL11.glTranslatef(-f5, -f6, 0.0f);
            float f7 = 1.5f;
            GL11.glScalef(f7, f7, f7);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
            jizq.func_78439_a(htvf2, f2, f3, f, f4, dwan2.func_94211_a(), dwan2.func_94216_b(), 0.0625f);
            if (cvzo2._c(n)) {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                apbu2._a(field_110930_b);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                float f8 = 0.76f;
                GL11.glColor4f(0.5f * f8, 0.25f * f8, 0.8f * f8, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                float f9 = 0.125f;
                GL11.glScalef(f9, f9, f9);
                float f10 = (float)(xpzm._M() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef(f10, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f9, f9, f9);
                f10 = (float)(xpzm._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f10, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glDisable(32826);
        }
    }
}

