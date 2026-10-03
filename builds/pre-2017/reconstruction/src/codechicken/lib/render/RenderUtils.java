/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.render;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    public static void translateToWorldCoords(Entity entity, float f) {
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        GL11.glTranslated(-d, -d2, -d3);
    }
}

