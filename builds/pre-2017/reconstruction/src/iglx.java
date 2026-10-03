/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.network.TcpConnection;

public class iglx
extends Thread {
    public final /* synthetic */ TcpConnection _a;

    public iglx(TcpConnection tcpConnection, String string) {
        this._a = tcpConnection;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        TcpConnection._a.getAndIncrement();
        try {
            while (TcpConnection._a(this._a) && !TcpConnection._b(this._a)) {
                while (TcpConnection._c(this._a)) {
                }
                try {
                    iglx.sleep(2L);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        finally {
            TcpConnection._a.getAndDecrement();
        }
    }
}

