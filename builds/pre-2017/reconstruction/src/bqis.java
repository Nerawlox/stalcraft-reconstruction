/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class bqis
implements ctih {
    public String _a;

    public bqis() {
    }

    public bqis(String string) {
        this._a = string;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            bqis._a(0);
        }
        dataOutput.writeUTF(this._a);
    }

    @Override
    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            bqis._a(1);
        }
        this._a = dataInput.readUTF();
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
        objectArray2[1] = "gloomyfolken/core/network/packets/PacketDisconnect";
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

