/*
 * Decompiled with CFR 0.152.
 */
import org.jetbrains.annotations.NotNull;

public class ownm
extends Thread {
    @NotNull
    final yciv _a;
    @NotNull
    final String _b;

    ownm(@NotNull yciv yciv2, @NotNull String string) {
        if (yciv2 == null) {
            ownm._a(0);
        }
        if (string == null) {
            ownm._a(1);
        }
        this._a = yciv2;
        this._b = string;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
            if (this._a._e()) {
                this._a._d.interrupt();
                this._a._b(this._b);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2 = new Object[3];
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[0] = "par1TcpConnection";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[0] = "message";
                break;
            }
        }
        objectArray[1] = "gloomyfolken/core/network/TcpShutdownDelayThread";
        objectArray[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

