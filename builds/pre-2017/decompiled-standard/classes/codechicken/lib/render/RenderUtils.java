/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.render;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    public static void translateToWorldCoords(Entity entity, float f) {
        double d = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)f;
        double d2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)f;
        double d3 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)f;
        GL11.glTranslated(-d, -d2, -d3);
    }
}

