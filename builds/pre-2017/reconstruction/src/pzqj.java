/*
 * Decompiled with CFR 0.152.
 */
import org.jetbrains.annotations.NotNull;

public class pzqj
extends Thread {
    @NotNull
    public final yciv _a;

    public pzqj(@NotNull yciv yciv2) {
        if (yciv2 == null) {
            pzqj._a(0);
        }
        this._a = yciv2;
    }

    @Override
    public void run() {
        while (this._a._e()) {
            while (this._a._b()) {
            }
            try {
                Thread.sleep(2L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "connection", "gloomyfolken/core/network/TcpWriterThread", "<init>"));
    }
}

