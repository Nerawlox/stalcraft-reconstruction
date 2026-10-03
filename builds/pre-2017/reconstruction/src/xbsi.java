/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.nbt.NBTBase;

public class xbsi
extends NBTBase {
    public xbsi() {
        super(null);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
    }

    @Override
    public void _a(DataOutput dataOutput) {
    }

    @Override
    public byte _a() {
        return 0;
    }

    public String toString() {
        return "END";
    }

    @Override
    public NBTBase _c() {
        return new xbsi();
    }
}

