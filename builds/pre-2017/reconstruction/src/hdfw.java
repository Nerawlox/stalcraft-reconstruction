/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.nbt.NBTBase;

public class hdfw
extends NBTBase {
    public int _c;

    public hdfw(String string) {
        super(string);
    }

    public hdfw(String string, int n) {
        super(string);
        this._c = n;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeInt(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readInt();
    }

    @Override
    public byte _a() {
        return 3;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public NBTBase _c() {
        return new hdfw(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            hdfw hdfw2 = (hdfw)object;
            return this._c == hdfw2._c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c;
    }
}

