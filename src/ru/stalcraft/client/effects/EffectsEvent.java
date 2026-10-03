/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.event.ForgeSubscribe
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.effects;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.asm.MethodsHelper;
import ru.stalcraft.client.effects.EffectsEngine;

public class EffectsEvent {
    @ForgeSubscribe
    public void onWorldRendering(RenderWorldLastEvent e2) {
        MethodsHelper.shouldRenderRainShow = true;
        bfe entityRenderer = atv.w().p;
        EffectsEngine.renderStatic(e2.partialTicks);
        try {
            ReflectionHelper.findMethod(bfe.class, (Object)entityRenderer, (String[])new String[]{"setupFog", "func_78468_a", "a"}, (Class[])new Class[]{Integer.class, Float.class}).invoke(entityRenderer, 0, Float.valueOf(e2.partialTicks));
        }
        catch (Exception exception) {
            // empty catch block
        }
        GL11.glEnable((int)2912);
        try {
            ReflectionHelper.findMethod(bfe.class, (Object)entityRenderer, (String[])new String[]{"renderRainSnow", "func_78474_d", "d"}, (Class[])new Class[]{Float.class}).invoke(entityRenderer, Float.valueOf(e2.partialTicks));
        }
        catch (Exception exception) {
            // empty catch block
        }
        MethodsHelper.shouldRenderRainShow = false;
        GL11.glDisable((int)2912);
    }
}

