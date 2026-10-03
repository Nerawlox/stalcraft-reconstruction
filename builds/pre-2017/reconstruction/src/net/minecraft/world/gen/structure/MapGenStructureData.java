/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class MapGenStructureData
extends WorldSavedData {
    public NBTTagCompound _a = new NBTTagCompound("Features");

    public MapGenStructureData(String string) {
        super(string);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this._a = nBTTagCompound._m("Features");
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Features", (NBTBase)this._a);
    }

    public void _a(NBTTagCompound nBTTagCompound, int n, int n2) {
        String string = this._a(n, n2);
        nBTTagCompound._a(string);
        this._a._a(string, (NBTBase)nBTTagCompound);
    }

    public String _a(int n, int n2) {
        return "[" + n + "," + n2 + "]";
    }

    public NBTTagCompound _a() {
        return this._a;
    }
}

