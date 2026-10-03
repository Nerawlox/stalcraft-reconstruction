/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTTagCompound;

public class ytcl
extends zwat {
    public String _a;
    public NBTTagCompound _b;
    public boolean _c;

    public ytcl(String string, NBTTagCompound nBTTagCompound, boolean bl) {
        this._a = string;
        this._b = nBTTagCompound;
        this._c = bl;
    }

    public ytcl() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = qlgf.readNBTTagCompound(dataInput);
        this._c = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        qlgf.writeNBTTagCompound(this._b, dataOutput);
        dataOutput.writeBoolean(this._c);
    }
}

