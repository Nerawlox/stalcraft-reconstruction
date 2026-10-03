/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import mcoptifine.CustomColorizer;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class OptifineHandler {
    public static int getColorMultiplier(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return CustomColorizer.getColorMultiplier(block, iBlockAccess, n, n2, n3);
    }
}

