/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class tgvf
extends TileEntity {
    public byte _a;
    public boolean _b;

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("note", this._a);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._a = nBTTagCompound._d("note");
        if (this._a < 0) {
            this._a = 0;
        }
        if (this._a > 24) {
            this._a = (byte)24;
        }
    }

    public void _a() {
        this._a = (byte)((this._a + 1) % 25);
        this.onInventoryChanged();
    }

    public void _a(World world, int n, int n2, int n3) {
        if (world.getBlockMaterial(n, n2 + 1, n3) != Material._a) {
            return;
        }
        Material material = world.getBlockMaterial(n, n2 - 1, n3);
        int n4 = 0;
        if (material == Material._e) {
            n4 = 1;
        }
        if (material == Material._p) {
            n4 = 2;
        }
        if (material == Material._s) {
            n4 = 3;
        }
        if (material == Material._d) {
            n4 = 4;
        }
        world.addBlockEvent(n, n2, n3, Block.music.blockID, n4, this._a);
    }
}

