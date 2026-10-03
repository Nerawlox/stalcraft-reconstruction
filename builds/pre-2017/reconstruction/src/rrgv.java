/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.network.TcpConnection;

public class rrgv
extends Thread {
    public final /* synthetic */ TcpConnection _a;

    public rrgv(TcpConnection tcpConnection) {
        this._a = tcpConnection;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
            if (TcpConnection._a(this._a)) {
                TcpConnection._h(this._a).interrupt();
                this._a._a("disconnect.closed", new Object[0]);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

