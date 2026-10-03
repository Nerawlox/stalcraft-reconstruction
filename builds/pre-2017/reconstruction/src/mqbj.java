/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public class mqbj
implements ctih {
    public UUID _a;
    public String _b;
    public String _c;
    public String _d;
    public boolean _e;
    public boolean _f;

    public mqbj() {
    }

    public mqbj(UUID uUID, String string, String string2, String string3, boolean bl, boolean bl2) {
        this._a = uUID;
        this._b = string;
        this._c = string2;
        this._d = string3;
        this._e = bl;
        this._f = bl2;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            mqbj._a(0);
        }
        dataOutput.writeLong(this._a.getMostSignificantBits());
        dataOutput.writeLong(this._a.getLeastSignificantBits());
        dataOutput.writeUTF(this._b);
        dataOutput.writeUTF(this._c);
        dataOutput.writeUTF(this._d);
        dataOutput.writeBoolean(this._e);
        dataOutput.writeBoolean(this._f);
    }

    @Override
    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            mqbj._a(1);
        }
        this._a = new UUID(dataInput.readLong(), dataInput.readLong());
        this._b = dataInput.readUTF();
        this._c = dataInput.readUTF();
        this._d = dataInput.readUTF();
        this._e = dataInput.readBoolean();
        this._f = dataInput.readBoolean();
    }

    @Override
    public boolean _a() {
        return true;
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "output";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "input";
                break;
            }
        }
        objectArray2[1] = "gloomyfolken/bundle/common/network/packet/connect/PacketClientLogin";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "write";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[2] = "read";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

