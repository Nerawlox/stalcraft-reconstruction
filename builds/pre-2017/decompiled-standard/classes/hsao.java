/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;
import org.jetbrains.annotations.NotNull;

public class hsao
extends zwat {
    private byte[] _a;
    private int _b;

    public hsao(tvcu tvcu2, int n) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            tvcu2._a(dataOutputStream);
            this._a = byteArrayOutputStream.toByteArray();
            this._b = n;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            hsao._a(0);
        }
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._a.length);
        dataOutput.write(this._a);
    }

    @Override
    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            hsao._a(1);
        }
        this._b = dataInput.readInt();
        this._a = new byte[dataInput.readInt()];
        dataInput.readFully(this._a);
    }

    @Override
    public void processClient(boolean bl) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this._a);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(xpzm._E()._t);
        try {
            smartMovingSelf.anticheat._a(dataInputStream);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        new dfsr(this._b).sendToServer();
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
        objectArray2[1] = "gloomyfolken/mods/anticheat/movement/PacketSmartmovingState";
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

    public hsao() {
    }
}

