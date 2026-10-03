/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.modloader.BaseModProxy;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class ModLoaderWorldGenerator
implements IWorldGenerator {
    private BaseModProxy mod;

    public ModLoaderWorldGenerator(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void generate(Random random, int n, int n2, World world, IChunkProvider iChunkProvider, IChunkProvider iChunkProvider2) {
        if (iChunkProvider instanceof rrvu) {
            this.mod.generateSurface(world, random, n << 4, n2 << 4);
        } else if (iChunkProvider instanceof ozoc) {
            this.mod.generateNether(world, random, n << 4, n2 << 4);
        }
    }
}

