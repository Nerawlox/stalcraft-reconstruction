/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.NBTBase;

public class NBTTagList
extends NBTBase {
    public List _c = new ArrayList();
    public byte _d;

    public NBTTagList() {
        super("");
    }

    public NBTTagList(String string) {
        super(string);
    }

    @Override
    public void _a(DataOutput dataOutput) throws IOException {
        this._d = !this._c.isEmpty() ? ((NBTBase)this._c.get(0))._a() : (byte)1;
        dataOutput.writeByte(this._d);
        dataOutput.writeInt(this._c.size());
        for (int i = 0; i < this._c.size(); ++i) {
            ((NBTBase)this._c.get(i))._a(dataOutput);
        }
    }

    @Override
    public void _a(DataInput dataInput, int n) throws IOException {
        if (n > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this._d = dataInput.readByte();
        int n2 = dataInput.readInt();
        this._c = new ArrayList();
        for (int i = 0; i < n2; ++i) {
            NBTBase nBTBase = NBTBase._a(this._d, (String)null);
            nBTBase._a(dataInput, n + 1);
            this._c.add(nBTBase);
        }
    }

    @Override
    public byte _a() {
        return 9;
    }

    public String toString() {
        return "" + this._c.size() + " entries of type " + NBTBase._a(this._d);
    }

    public void _a(NBTBase nBTBase) {
        this._d = nBTBase._a();
        this._c.add(nBTBase);
    }

    public NBTBase _a(int n) {
        return (NBTBase)this._c.remove(n);
    }

    public NBTBase _b(int n) {
        return (NBTBase)this._c.get(n);
    }

    public int _d() {
        return this._c.size();
    }

    @Override
    public NBTBase _c() {
        NBTTagList nBTTagList = new NBTTagList(this._b());
        nBTTagList._d = this._d;
        for (NBTBase nBTBase : this._c) {
            NBTBase nBTBase2 = nBTBase._c();
            nBTTagList._c.add(nBTBase2);
        }
        return nBTTagList;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagList nBTTagList = (NBTTagList)object;
            if (this._d == nBTTagList._d) {
                return this._c.equals(nBTTagList._c);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c.hashCode();
    }
}

