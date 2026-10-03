/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class xrvo
extends Block {
    public final boolean _a;

    public xrvo(int n, boolean bl) {
        super(n, Material._t);
        this._a = bl;
        if (bl) {
            this.setLightValue(1.0f);
        }
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        if (!world.isRemote) {
            if (this._a && !world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
                world.scheduleBlockUpdate(n, n2, n3, this.blockID, 4);
            } else if (!this._a && world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
                world.setBlock(n, n2, n3, Block.redstoneLampActive.blockID, 0, 2);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (!world.isRemote) {
            if (this._a && !world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
                world.scheduleBlockUpdate(n, n2, n3, this.blockID, 4);
            } else if (!this._a && world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
                world.setBlock(n, n2, n3, Block.redstoneLampActive.blockID, 0, 2);
            }
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote && this._a && !world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            world.setBlock(n, n2, n3, Block.redstoneLampIdle.blockID, 0, 2);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.redstoneLampIdle.blockID;
    }

    @Override
    public int idPicked(World world, int n, int n2, int n3) {
        return Block.redstoneLampIdle.blockID;
    }
}

