/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.zwaw;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

public class zwat {
    @ForgeSubscribe
    public void _a(RenderWorldLastEvent renderWorldLastEvent) {
        Minecraft._E().__ah._a("effectsapi");
        fmej._a = true;
        EntityRenderer entityRenderer = Minecraft._E()._D;
        if (eidj._a != null) {
            eidj._a._a(renderWorldLastEvent.partialTicks);
        }
        entityRenderer.setupFog(0, renderWorldLastEvent.partialTicks);
        Minecraft._E().__ah._a("rainSnow");
        Minecraft._E()._D.renderRainSnow(renderWorldLastEvent.partialTicks);
        Minecraft._E().__ah._b();
        fmej._a = false;
        Minecraft._E().__ah._b();
    }

    @ForgeSubscribe
    public void _a(WorldEvent.Unload unload) {
        eidj._a._i();
    }

    @ForgeSubscribe(priority=EventPriority.LOWEST)
    public void _b(RenderWorldLastEvent renderWorldLastEvent) {
        zwaw._a(16384);
    }
}

