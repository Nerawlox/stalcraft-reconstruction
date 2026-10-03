/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.nbt.NBTBase;

public class grhp
extends NBTBase {
    public long _c;

    public grhp(String string) {
        super(string);
    }

    public grhp(String string, long l) {
        super(string);
        this._c = l;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeLong(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readLong();
    }

    @Override
    public byte _a() {
        return 4;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public NBTBase _c() {
        return new grhp(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            grhp grhp2 = (grhp)object;
            return this._c == grhp2._c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ (int)(this._c ^ this._c >>> 32);
    }
}

