/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.ISaveHandler;

public class pidb {
    public static ISaveHandler _a(ISaveHandler iSaveHandler, String string) {
        if ("DIM0".equals(string)) {
            return MinecraftServer._I().getEntityWorld().getSaveHandler();
        }
        return iSaveHandler;
    }

    public static String _a(String string) {
        if ("DIM0".equals(string)) {
            return MinecraftServer._I().getEntityWorld().getWorldInfo()._k();
        }
        return string;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static String _a(WorldProvider worldProvider) {
        int n = worldProvider._i;
        if (worldProvider._b == null || !worldProvider._b.isRemote) {
            n = InvokeWithResult.frontend(() -> null);
        }
        return n == 0 ? null : "DIM" + n;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(WorldProvider worldProvider, long l, float f) {
        double d = (double)(l % 160000L) + (double)f;
        double d2 = d > 120000.0 ? (d - 120000.0) / 80000.0 + 0.25 : d / 240000.0 - 0.25;
        if (d2 < 0.0) {
            d2 += 1.0;
        }
        if (d2 > 1.0) {
            d2 -= 1.0;
        }
        double d3 = d2;
        d2 = 1.0f - (float)((Math.cos(d2 * Math.PI) + 1.0) / 2.0);
        d2 = d3 + (d2 - d3) / 3.0;
        return (float)d2;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static int _a(WorldProvider worldProvider, long l) {
        return (int)(l / 160000L) % 8;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(World world) {
        if (!world.provider._g) {
            world.prevRainingStrength = world.rainingStrength;
            world.rainingStrength = world.rainingStrength + (world.worldInfo._p() ? 0.01f : -0.01f);
            world.rainingStrength = sajh._a(world.rainingStrength, 0.0f, 1.0f);
            world.prevThunderingStrength = world.thunderingStrength;
            world.thunderingStrength = world.thunderingStrength + (world.worldInfo._n() ? 0.01f : -0.01f);
            world.thunderingStrength = sajh._a(world.thunderingStrength, 0.0f, 1.0f);
        }
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void _a(fngq fngq2, char c, int n) {
        if (n == 46) {
            Minecraft minecraft = Minecraft._E();
            minecraft._a(new ivbz(minecraft._B, false));
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void _a(Minecraft minecraft) {
        ntpl._a();
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="startSection")
    public static void _a(fokl fokl2, String string) {
        if (!GloomyLoadingPlugin._a && fokl2.getClass() != dfso.class) {
            ntpl._a._a(string);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="endSection")
    public static void _a(fokl fokl2) {
        if (!GloomyLoadingPlugin._a && fokl2.getClass() != dfso.class) {
            ntpl._a._b();
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="endStartSection")
    public static void _b(fokl fokl2, String string) {
        if (!GloomyLoadingPlugin._a && fokl2.getClass() != dfso.class) {
            ntpl._a._c(string);
        }
    }
}

