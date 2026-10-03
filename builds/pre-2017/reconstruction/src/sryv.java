/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class sryv {
    @NotNull
    private static final HashMap<Integer, Class<? extends ctih>> _a = new HashMap();
    @NotNull
    private static final HashMap<Class<? extends ctih>, Integer> _b = new HashMap();

    public static void _a(@NotNull Class<? extends ctih> clazz, int n) {
        if (clazz == null) {
            sryv._a(0);
        }
        if (n > 65535) {
            throw new RuntimeException("Too many registered packets!");
        }
        _a.put(n, clazz);
        _b.put(clazz, n);
    }

    @NotNull
    public static ctih _a(@NotNull DataInput dataInput) throws IOException {
        ctih ctih2;
        int n;
        Class<? extends ctih> clazz;
        if (dataInput == null) {
            sryv._a(1);
        }
        if ((clazz = _a.get(n = dataInput.readUnsignedShort())) == null) {
            throw new IOException("Bad packet id " + n);
        }
        try {
            ctih2 = clazz.newInstance();
        }
        catch (Exception exception) {
            throw new IOException("No valid constructor for packet " + n);
        }
        try {
            ctih2.read(dataInput);
        }
        catch (Exception exception) {
            throw new IOException("Exception during reading packet", exception);
        }
        ctih ctih3 = ctih2;
        if (ctih3 == null) {
            sryv._a(2);
        }
        return ctih3;
    }

    public static void _a(@NotNull ctih ctih2, @NotNull DataOutput dataOutput) throws IOException {
        if (ctih2 == null) {
            sryv._a(3);
        }
        if (dataOutput == null) {
            sryv._a(4);
        }
        dataOutput.writeShort(sryv._a(ctih2));
        try {
            ctih2.write(dataOutput);
        }
        catch (Exception exception) {
            throw new IOException("Exception during writing packet", exception);
        }
    }

    public static int _a(@NotNull Class<? extends ctih> clazz) {
        Integer n;
        if (clazz == null) {
            sryv._a(5);
        }
        if ((n = _b.get(clazz)) == null) {
            throw new RuntimeException("Packet not registered");
        }
        return n;
    }

    public static int _a(@NotNull ctih ctih2) {
        Integer n;
        if (ctih2 == null) {
            sryv._a(6);
        }
        if ((n = _b.get(ctih2.getClass())) == null) {
            throw new RuntimeException("Packet " + ctih2.getClass() + " not registered");
        }
        return n;
    }

    static {
        sryv._a(bqis.class, 2000);
        sryv._a(cckb.class, 2001);
    }

    private static /* synthetic */ void _a(int n) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n2;
        String string;
        switch (n) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 2: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n) {
            default: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n2];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "clazz";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "input";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "gloomyfolken/core/network/PacketRegistry";
                break;
            }
            case 3: 
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "packet";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "output";
                break;
            }
        }
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "gloomyfolken/core/network/PacketRegistry";
                break;
            }
            case 2: {
                objectArray = objectArray2;
                objectArray2[1] = "readNextPacket";
                break;
            }
        }
        switch (n) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "registerPacket";
                break;
            }
            case 1: {
                objectArray = objectArray;
                objectArray[2] = "readNextPacket";
                break;
            }
            case 2: {
                break;
            }
            case 3: 
            case 4: {
                objectArray = objectArray;
                objectArray[2] = "writeNextPacket";
                break;
            }
            case 5: 
            case 6: {
                objectArray = objectArray;
                objectArray[2] = "getPacketId";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 2: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

