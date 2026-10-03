/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import net.minecraft.client.Minecraft;

public class DebugPathTest {
    public static void markPoint(int n, int n2, int n3) {
        pkix pkix2 = Minecraft._E()._r;
        pkix2.spawnParticle("smoke", (double)n + 0.5, (double)n2 + 0.25, (double)n3 + 0.5, 0.0, 0.005, 0.0);
        pkix2.spawnParticle("flame", (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, 0.0, 0.005, 0.0);
    }
}

