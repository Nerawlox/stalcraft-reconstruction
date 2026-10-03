/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.modloader.BaseModProxy;
import java.util.Random;

public class ModLoaderWorldGenerator
implements IWorldGenerator {
    private BaseModProxy mod;

    public ModLoaderWorldGenerator(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void generate(Random random, int n, int n2, ozlu ozlu2, mccn mccn2, mccn mccn3) {
        if (mccn2 instanceof rrvu) {
            this.mod.generateSurface(ozlu2, random, n << 4, n2 << 4);
        } else if (mccn2 instanceof ozoc) {
            this.mod.generateNether(ozlu2, random, n << 4, n2 << 4);
        }
    }
}

