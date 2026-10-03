/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class kkbk
implements ctih {
    public String _a;
    public int _b;
    public int _c;
    public Map<UUID, String> _d;

    public kkbk() {
    }

    public kkbk(@NotNull String string, int n, int n2, @Nullable Map<UUID, String> map) {
        if (string == null) {
            kkbk._a(0);
        }
        this._a = string;
        this._b = n;
        this._c = n2;
        this._d = map;
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            kkbk._a(1);
        }
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        if (this._d == null) {
            dataOutput.writeInt(0);
        } else {
            dataOutput.writeInt(this._d.size());
            for (Map.Entry<UUID, String> entry : this._d.entrySet()) {
                dataOutput.writeLong(entry.getKey().getMostSignificantBits());
                dataOutput.writeLong(entry.getKey().getLeastSignificantBits());
                dataOutput.writeUTF(entry.getValue());
            }
        }
    }

    @Override
    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            kkbk._a(2);
        }
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        int n = dataInput.readInt();
        this._d = new HashMap<UUID, String>(n);
        for (int i = 0; i < n; ++i) {
            this._d.put(new UUID(dataInput.readLong(), dataInput.readLong()), dataInput.readUTF());
        }
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "password";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "output";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "input";
                break;
            }
        }
        objectArray2[1] = "gloomyfolken/core/network/packets/srvmgr/PacketSrvmgrLogin";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "<init>";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[2] = "write";
                break;
            }
            case 2: {
                objectArray = objectArray2;
                objectArray2[2] = "read";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

