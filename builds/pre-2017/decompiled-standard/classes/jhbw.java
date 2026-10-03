/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.entity.EntityKisselWave;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class jhbw
extends tfvm {
    private static ResourceLocation _a = new ResourceLocation("anomalies", "textures/anomaly/kissel_distortion.dds");

    public void _a(EntityKisselWave entityKisselWave, double d, double d2, double d3, float f, float f2) {
        xpzm._E()._h._a(_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, entityKisselWave.alpha);
        float f3 = entityKisselWave.prevSize + (entityKisselWave.size - entityKisselWave.prevSize) * f2;
        hsmn._a(d, d2, d3, 1, f3);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityKisselWave)entity, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return null;
    }
}

