/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class gomc {
    private final TileEntity _a;
    private int _b;
    private int _c;
    private int _d;

    public gomc(TileEntity tileEntity) {
        this._a = tileEntity;
    }

    public void _a() {
        if (!this._a.worldObj.isRemote && this._b()) {
            this._a.worldObj.setBlockToAir(this._a.xCoord, this._a.yCoord, this._a.zCoord);
        }
    }

    public void _a(int n, int n2, int n3) {
        this._b = n;
        this._c = n2;
        this._d = n3;
    }

    public boolean _b() {
        return this._b != this._a.xCoord || this._c != this._a.yCoord || this._d != this._a.zCoord;
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        this._b = nBTTagCompound._f("placedAtX");
        this._c = nBTTagCompound._f("placedAtY");
        this._d = nBTTagCompound._f("placedAtZ");
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("placedAtX", this._b);
        nBTTagCompound._a("placedAtY", this._c);
        nBTTagCompound._a("placedAtZ", this._d);
    }
}

