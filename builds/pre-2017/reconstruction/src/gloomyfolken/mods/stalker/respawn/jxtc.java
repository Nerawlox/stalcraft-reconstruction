/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.tupg;
import java.lang.invoke.LambdaMetafactory;
import java.util.EnumSet;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class jxtc
extends TileEntity {
    private static int _a;
    private final int _b = _a++;
    public String _k = "";
    public int _l = 30;
    public boolean _m;
    public EnumSet<tupg> _n = EnumSet.allOf(tupg.class);
    public boolean _o;
    private hrvl _c;

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((jxtc)this));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("savepoint_name", this._k);
        nBTTagCompound._a("radius", this._l);
        nBTTagCompound._a("force", this._m);
        nBTTagCompound._a("showIcon", this._o);
        nBTTagCompound._a("respawnLoc", (NBTBase)this._a()._a());
        byte[] byArray = new byte[this._n.size()];
        int n = 0;
        for (tupg tupg2 : this._n) {
            byArray[n++] = (byte)tupg2.ordinal();
        }
        nBTTagCompound._a("factions", byArray);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._k = nBTTagCompound._j("savepoint_name");
        this._l = nBTTagCompound._f("radius");
        this._m = nBTTagCompound._o("force");
        this._o = nBTTagCompound._o("showIcon");
        if (nBTTagCompound._c("respawnLoc")) {
            this._c = new hrvl(nBTTagCompound._m("respawnLoc"));
        }
        this._n = EnumSet.noneOf(tupg.class);
        for (byte by : nBTTagCompound._k("factions")) {
            this._n.add(tupg.values()[by]);
        }
    }

    @Override
    public void setWorldObj(World world) {
        super.setWorldObj(world);
        if (!world.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public hrvl _a() {
        if (this._c == null) {
            this._c = new hrvl(new einh(this.worldObj, (double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5), new satm(0.0f, 0.0f));
        }
        return this._c;
    }
}

