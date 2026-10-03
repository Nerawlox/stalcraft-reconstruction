/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.nbt.NBTBase;

public class NBTTagString
extends NBTBase {
    public String _c;

    public NBTTagString(String string) {
        super(string);
    }

    public NBTTagString(String string, String string2) {
        super(string);
        this._c = string2;
        if (string2 == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeUTF(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readUTF();
    }

    @Override
    public byte _a() {
        return 8;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public NBTBase _c() {
        return new NBTTagString(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagString nBTTagString = (NBTTagString)object;
            return this._c == null && nBTTagString._c == null || this._c != null && this._c.equals(nBTTagString._c);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c.hashCode();
    }
}

