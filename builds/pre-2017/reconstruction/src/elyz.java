/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.item.ItemStack;

public class elyz
extends zwat {
    private int _a;
    private int _b;
    private int _c;
    private int _d;

    public elyz(ItemStack itemStack, int n) {
        if (itemStack != null) {
            this._a = itemStack._d;
            this._b = itemStack._f;
            this._c = itemStack._b;
            this._d = n;
        }
    }

    public elyz() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
    }
}

