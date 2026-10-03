/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.mod;

import eu.ha3.matmos.game.mod.LiteModMAtmos;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.ForgeSubscribe;

public class MatmosEventHandler {
    @ForgeSubscribe
    public void onTick(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b) {
            boolean bl = Minecraft._E().__ab;
            LiteModMAtmos.instance.onTick(0.0f, bl, true);
        }
    }

    @ForgeSubscribe
    public void onRenderTick(lnrm.ezey ezey2) {
        if (ezey2._c == lnrm.pidb._b) {
            boolean bl = Minecraft._E().__ab;
            LiteModMAtmos.instance.onTick(ezey2._d, bl, false);
        }
    }
}

