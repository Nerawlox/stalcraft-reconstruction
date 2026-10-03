/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import net.minecraft.network.TcpConnection;

public class qodo
extends Thread {
    public final /* synthetic */ TcpConnection _a;

    public qodo(TcpConnection tcpConnection, String string) {
        this._a = tcpConnection;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block12: {
            TcpConnection._b.getAndIncrement();
            block7: while (true) {
                while (TcpConnection._a(this._a)) {
                    boolean bl = false;
                    while (TcpConnection._d(this._a)) {
                        bl = true;
                    }
                    try {
                        if (bl && TcpConnection._e(this._a) != null) {
                            TcpConnection._e(this._a).flush();
                        }
                    }
                    catch (IOException iOException) {
                        if (!TcpConnection._f(this._a)) {
                            TcpConnection._a(this._a, iOException);
                        }
                        iOException.printStackTrace();
                    }
                    try {
                        qodo.sleep(2L);
                        continue block7;
                    }
                    catch (InterruptedException interruptedException) {
                    }
                }
                break block12;
                {
                    continue block7;
                    break;
                }
                break;
            }
            finally {
                TcpConnection._b.getAndDecrement();
            }
        }
    }
}

