/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.renderer.RenderNPCInterface;
import org.lwjgl.opengl.GL11;

public class RenderNpcSlime
extends RenderNPCInterface {
    private ModelBase scaleAmount;

    public RenderNpcSlime(ModelBase modelBase, ModelBase modelBase2, float f) {
        super(modelBase, f);
        this.scaleAmount = modelBase2;
    }

    protected int shouldSlimeRenderPass(EntityNPCInterface entityNPCInterface, int n, float f) {
        if (entityNPCInterface.isInvisible()) {
            return 0;
        }
        if (n == 0) {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if (n == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return -1;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this.shouldSlimeRenderPass((EntityNPCInterface)entityLivingBase, n, f);
    }
}

