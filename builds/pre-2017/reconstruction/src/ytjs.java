/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class ytjs
implements ctih {
    public boolean _a;

    public ytjs() {
    }

    public ytjs(boolean bl) {
        this._a = bl;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            ytjs._a(0);
        }
        dataOutput.writeBoolean(this._a);
    }

    @Override
    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            ytjs._a(1);
        }
        this._a = dataInput.readBoolean();
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
        objectArray2[1] = "gloomyfolken/core/network/packets/srvmgr/PacketSrvmgrLoginResult";
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

