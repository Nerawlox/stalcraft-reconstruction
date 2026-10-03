/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.CustomItems;
import noppes.npcs.client.model.ModelMailboxUS;
import noppes.npcs.client.model.ModelMailboxWow;
import org.lwjgl.opengl.GL11;

public class BlockMailboxRenderer
extends htys
implements ISimpleBlockRenderingHandler {
    private static final ResourceLocation text1 = new ResourceLocation("customnpcs", "textures/misc/mailbox1.png");
    private static final ResourceLocation text2 = new ResourceLocation("customnpcs", "textures/misc/mailbox2.png");
    private ModelMailboxUS model = new ModelMailboxUS();
    private ModelMailboxWow model2 = new ModelMailboxWow();

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        int n = hurg2.field_70331_k.func_72805_g(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n) | 4;
        int n2 = hurg2.field_70331_k.func_72805_g(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n) >> 2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2 + 1.5f, (float)d3 + 0.5f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(90 * n, 0.0f, 1.0f, 0.0f);
        if (n2 == 0) {
            this.func_110628_a(text1);
            this.model.func_78088_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        if (n2 == 1) {
            this.func_110628_a(text2);
            this.model2.func_78088_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.8f, 0.0f);
        GL11.glScalef(0.9f, 0.9f, 0.9f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        if (n == 0) {
            this.func_110628_a(text1);
            this.model.func_78088_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        if (n == 1) {
            this.func_110628_a(text2);
            this.model2.func_78088_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        }
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return CustomItems.mailbox.func_71857_b();
    }
}

