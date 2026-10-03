/*
 * Decompiled with CFR 0.152.
 */
import org.jetbrains.annotations.NotNull;

class srxy
extends Thread {
    @NotNull
    final yciv _a;

    srxy(@NotNull yciv yciv2) {
        if (yciv2 == null) {
            srxy._a(0);
        }
        this._a = yciv2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
            if (this._a._c.isAlive()) {
                try {
                    this._a._c.stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (this._a._c.isAlive()) {
                try {
                    this._a._c.stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "par1TcpConnection", "gloomyfolken/core/network/TcpShutdownThread", "<init>"));
    }
}

