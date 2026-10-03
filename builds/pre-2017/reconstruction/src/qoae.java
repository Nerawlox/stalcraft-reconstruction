/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.nbt.NBTBase;

public class qoae
extends NBTBase {
    public double _c;

    public qoae(String string) {
        super(string);
    }

    public qoae(String string, double d) {
        super(string);
        this._c = d;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeDouble(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readDouble();
    }

    @Override
    public byte _a() {
        return 6;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public NBTBase _c() {
        return new qoae(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            qoae qoae2 = (qoae)object;
            return this._c == qoae2._c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        long l = Double.doubleToLongBits(this._c);
        return super.hashCode() ^ (int)(l ^ l >>> 32);
    }
}

