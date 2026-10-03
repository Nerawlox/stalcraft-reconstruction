/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public class bqha
implements ctih {
    public UUID _a;
    public boolean _b;

    public bqha() {
    }

    public bqha(UUID uUID, boolean bl) {
        this._a = uUID;
        this._b = bl;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            bqha._a(0);
        }
        dataOutput.writeLong(this._a.getMostSignificantBits());
        dataOutput.writeLong(this._a.getLeastSignificantBits());
        dataOutput.writeBoolean(this._b);
    }

    @Override
    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            bqha._a(1);
        }
        this._a = new UUID(dataInput.readLong(), dataInput.readLong());
        this._b = dataInput.readBoolean();
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
        objectArray2[1] = "gloomyfolken/core/network/packets/srvmgr/PacketSrvmgrServerStopped";
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

