/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

public abstract class pzrd {
    @NotNull
    public yciv _a;
    private final sawy _b;

    public pzrd(@NotNull yciv yciv2) {
        if (yciv2 == null) {
            pzrd._a(0);
        }
        this._b = new sawy();
        this._a = yciv2;
    }

    public pzrd(@NotNull Socket socket, boolean bl, @NotNull Logger logger) throws IOException {
        if (socket == null) {
            pzrd._a(1);
        }
        if (logger == null) {
            pzrd._a(2);
        }
        this._b = new sawy();
        this._a = new yciv(this, socket, bl, logger);
    }

    public pzrd(@NotNull String string, int n, @NotNull Logger logger) throws IOException {
        if (string == null) {
            pzrd._a(3);
        }
        if (logger == null) {
            pzrd._a(4);
        }
        this(new Socket(InetAddress.getByName(string), n), true, logger);
    }

    public void _a() {
        this._a._c();
    }

    public void _a(@NotNull ctih ctih2) {
        if (ctih2 == null) {
            pzrd._a(5);
        }
        this._a._a(ctih2);
    }

    public void _b(@NotNull ctih ctih2) {
        if (ctih2 == null) {
            pzrd._a(6);
        }
        if (this._b._a(ctih2)) {
            this._b._a(ctih2, this);
        } else {
            this._c(ctih2);
        }
    }

    protected abstract void _c(@NotNull ctih var1);

    public void _a(@NotNull String string) {
        if (string == null) {
            pzrd._a(7);
        }
    }

    public int _b() {
        return Integer.MAX_VALUE;
    }

    @NotNull
    public abstract String _c();

    protected void _d() {
        if (this._a._i) {
            this._a(new cckb());
        }
    }

    protected void _b(String string) {
        this._a._b(string);
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "connection";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "socket";
                break;
            }
            case 2: 
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "logger";
                break;
            }
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "ip";
                break;
            }
            case 5: 
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "packet";
                break;
            }
            case 7: {
                objectArray2 = objectArray3;
                objectArray3[0] = "reason";
                break;
            }
        }
        objectArray2[1] = "gloomyfolken/core/network/NetworkHandler";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "<init>";
                break;
            }
            case 5: {
                objectArray = objectArray2;
                objectArray2[2] = "sendPacket";
                break;
            }
            case 6: {
                objectArray = objectArray2;
                objectArray2[2] = "processPacket";
                break;
            }
            case 7: {
                objectArray = objectArray2;
                objectArray2[2] = "handleConnectionClosed";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

