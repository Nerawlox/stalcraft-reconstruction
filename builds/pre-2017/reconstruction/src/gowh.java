/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class gowh<S> {
    @NotNull
    private HashMap<Class<?>, dwoi<?, S>> _a = new HashMap();

    public <P extends ctih> gowh<S> _a(@NotNull Class<P> clazz, @NotNull dwoi<P, S> dwoi2) {
        if (clazz == null) {
            gowh._a(0);
        }
        if (dwoi2 == null) {
            gowh._a(1);
        }
        this._a.put(clazz, dwoi2);
        return this;
    }

    public boolean _a(@NotNull ctih ctih2) {
        if (ctih2 == null) {
            gowh._a(2);
        }
        return this._a.containsKey(ctih2.getClass());
    }

    public void _a(@NotNull ctih ctih2, @NotNull S s) {
        dwoi<?, S> dwoi2;
        if (ctih2 == null) {
            gowh._a(3);
        }
        if (s == null) {
            gowh._a(4);
        }
        if ((dwoi2 = this._a.get(ctih2.getClass())) == null) {
            throw new IllegalArgumentException("Handler for packet " + ctih2.getClass().getSimpleName() + " not registered!");
        }
        dwoi2.processPacket(ctih2, s);
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "clazz";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "handler";
                break;
            }
            case 2: 
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "packet";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "sender";
                break;
            }
        }
        objectArray2[1] = "gloomyfolken/core/network/PacketHandlerRegistry";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "registerPacketHandler";
                break;
            }
            case 2: {
                objectArray = objectArray2;
                objectArray2[2] = "isPacketRegistered";
                break;
            }
            case 3: 
            case 4: {
                objectArray = objectArray2;
                objectArray2[2] = "processPacket";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

