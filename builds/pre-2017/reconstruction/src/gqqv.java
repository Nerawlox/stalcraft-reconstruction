/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;

public class gqqv
extends scrm {
    public void _a(EntityMinecartMobSpawner entityMinecartMobSpawner, float f, Block block, int n) {
        super._a(entityMinecartMobSpawner, f, block, n);
        if (block == Block.mobSpawner) {
            pkpp._a(entityMinecartMobSpawner.func_98039_d(), entityMinecartMobSpawner.posX, entityMinecartMobSpawner.posY, entityMinecartMobSpawner.posZ, f);
        }
    }
}

