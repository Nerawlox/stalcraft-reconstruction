/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import net.minecraft.client.model.ModelBase;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.renderer.RenderNPCInterface;
import org.lwjgl.opengl.GL11;

public class RenderNpcDragon
extends RenderNPCInterface {
    public RenderNpcDragon(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    @Override
    protected void renderPlayerScale(EntityNPCInterface entityNPCInterface, float f) {
        GL11.glTranslatef(0.0f, 0.0f, 0.120000005f * (float)entityNPCInterface.display.modelSize);
        super.renderPlayerScale(entityNPCInterface, f);
    }
}

