/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentScatteredFeature;

public class nfmv
extends ComponentScatteredFeature {
    public boolean _e;

    public nfmv() {
    }

    public nfmv(Random random, int n, int n2) {
        super(random, n, 64, n2, 7, 5, 9);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Witch", this._e);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._e = nBTTagCompound._o("Witch");
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        if (!this._a(world, uken2, 0)) {
            return false;
        }
        this._a(world, uken2, 1, 1, 1, 5, 1, 7, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 1, 4, 2, 5, 4, 7, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 2, 1, 0, 4, 1, 0, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 2, 2, 2, 3, 3, 2, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 1, 2, 3, 1, 3, 6, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 5, 2, 3, 5, 3, 6, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 2, 2, 7, 4, 3, 7, Block.planks.blockID, 1, Block.planks.blockID, 1, false);
        this._a(world, uken2, 1, 0, 2, 1, 3, 2, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 5, 0, 2, 5, 3, 2, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 1, 0, 7, 1, 3, 7, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 5, 0, 7, 5, 3, 7, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, Block.fence.blockID, 0, 2, 3, 2, uken2);
        this._a(world, Block.fence.blockID, 0, 3, 3, 7, uken2);
        this._a(world, 0, 0, 1, 3, 4, uken2);
        this._a(world, 0, 0, 5, 3, 4, uken2);
        this._a(world, 0, 0, 5, 3, 5, uken2);
        this._a(world, Block.flowerPot.blockID, 7, 1, 3, 5, uken2);
        this._a(world, Block.workbench.blockID, 0, 3, 2, 6, uken2);
        this._a(world, Block.cauldron.blockID, 0, 4, 2, 6, uken2);
        this._a(world, Block.fence.blockID, 0, 1, 2, 1, uken2);
        this._a(world, Block.fence.blockID, 0, 5, 2, 1, uken2);
        int n4 = this._e(Block.stairsWoodOak.blockID, 3);
        int n5 = this._e(Block.stairsWoodOak.blockID, 1);
        int n6 = this._e(Block.stairsWoodOak.blockID, 0);
        int n7 = this._e(Block.stairsWoodOak.blockID, 2);
        this._a(world, uken2, 0, 4, 1, 6, 4, 1, Block.stairsWoodSpruce.blockID, n4, Block.stairsWoodSpruce.blockID, n4, false);
        this._a(world, uken2, 0, 4, 2, 0, 4, 7, Block.stairsWoodSpruce.blockID, n6, Block.stairsWoodSpruce.blockID, n6, false);
        this._a(world, uken2, 6, 4, 2, 6, 4, 7, Block.stairsWoodSpruce.blockID, n5, Block.stairsWoodSpruce.blockID, n5, false);
        this._a(world, uken2, 0, 4, 8, 6, 4, 8, Block.stairsWoodSpruce.blockID, n7, Block.stairsWoodSpruce.blockID, n7, false);
        for (n3 = 2; n3 <= 7; n3 += 5) {
            for (n2 = 1; n2 <= 5; n2 += 4) {
                this._b(world, Block.wood.blockID, 0, n2, -1, n3, uken2);
            }
        }
        if (!this._e && uken2._b(n3 = this._c(2, 5), n2 = this._b(2), n = this._d(2, 5))) {
            this._e = true;
            EntityWitch entityWitch = new EntityWitch(world);
            entityWitch.setLocationAndAngles((double)n3 + 0.5, n2, (double)n + 0.5, 0.0f, 0.0f);
            entityWitch.onSpawnWithEgg(null);
            world.spawnEntityInWorld(entityWitch);
        }
        return true;
    }
}

