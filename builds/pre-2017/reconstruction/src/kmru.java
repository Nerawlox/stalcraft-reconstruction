/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.network.TcpConnection;

public class kmru
extends Thread {
    public final /* synthetic */ TcpConnection _a;

    public kmru(TcpConnection tcpConnection) {
        this._a = tcpConnection;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
            if (TcpConnection._g(this._a).isAlive()) {
                try {
                    TcpConnection._g(this._a).stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (TcpConnection._h(this._a).isAlive()) {
                try {
                    TcpConnection._h(this._a).stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

