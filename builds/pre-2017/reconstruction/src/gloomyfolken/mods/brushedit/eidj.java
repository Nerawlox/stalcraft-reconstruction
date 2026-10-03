/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.brushedit;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class eidj {
    public int _a;
    public int _b;
    public NBTTagCompound _c;

    public eidj() {
    }

    public eidj(World world, int n, int n2, int n3) {
        this._a = world.getBlockId(n, n2, n3);
        this._b = world.getBlockMetadata(n, n2, n3);
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity != null) {
            this._c = new NBTTagCompound();
            tileEntity.writeToNBT(this._c);
        }
    }

    public eidj(int n, int n2, NBTTagCompound nBTTagCompound) {
        this._a = n;
        this._b = n2;
        this._c = nBTTagCompound;
    }

    public void _a(World world, int n, int n2, int n3) {
        world.setBlock(n, n2, n3, this._a, this._b, 3);
        if (this._c != null) {
            TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
            tileEntity.readFromNBT(this._c);
            tileEntity.xCoord = n;
            tileEntity.yCoord = n2;
            tileEntity.zCoord = n3;
        }
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("id", this._a);
        nBTTagCompound._a("metadata", this._b);
        if (this._c != null) {
            nBTTagCompound._a("tile", (NBTBase)this._c);
        }
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        this._a = nBTTagCompound._f("id");
        this._b = nBTTagCompound._f("metadata");
        if (nBTTagCompound._c("tile")) {
            this._c = nBTTagCompound._m("tile");
        }
    }
}

