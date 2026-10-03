/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.item.ItemStack;

public class ivkt
extends ytyx {
    private int _a;
    private ItemStack _b;

    public ivkt(int n, ItemStack itemStack) {
        this._a = n;
        this._b = itemStack;
    }

    public ivkt() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = qlgf.readItemStack(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        qlgf.writeItemStack(this._b, dataOutput);
    }
}

