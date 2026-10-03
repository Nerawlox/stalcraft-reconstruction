/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public interface IWorldGenerator {
    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6);
}

