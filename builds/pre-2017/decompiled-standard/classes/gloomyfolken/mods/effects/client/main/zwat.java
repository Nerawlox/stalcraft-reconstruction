/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.zwaw;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

public class zwat {
    @ForgeSubscribe
    public void _a(RenderWorldLastEvent renderWorldLastEvent) {
        xpzm._E().__ah._a("effectsapi");
        fmej._a = true;
        tfsl tfsl2 = xpzm._E()._D;
        if (eidj._a != null) {
            eidj._a._a(renderWorldLastEvent.partialTicks);
        }
        tfsl2.func_78468_a(0, renderWorldLastEvent.partialTicks);
        xpzm._E().__ah._a("rainSnow");
        xpzm._E()._D.func_78474_d(renderWorldLastEvent.partialTicks);
        xpzm._E().__ah._b();
        fmej._a = false;
        xpzm._E().__ah._b();
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

