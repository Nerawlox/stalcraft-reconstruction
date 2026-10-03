/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class apap
extends tfvm {
    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        apap.func_76978_a(entity.field_70121_D, d - entity.field_70142_S, d2 - entity.field_70137_T, d3 - entity.field_70136_U);
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

