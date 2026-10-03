/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.mco.McoServer;

public class qnif
extends Thread {
    public final /* synthetic */ McoServer _a;
    public final /* synthetic */ lowp _b;

    public qnif(lowp lowp2, McoServer mcoServer) {
        this._b = lowp2;
        this._a = mcoServer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            if (!this._a._n) {
                this._a._n = true;
                this._a._p = -2L;
                this._a._m = "";
                htmo._g();
                long l = System.nanoTime();
                htmo._a(this._b._u, this._a);
                long l2 = System.nanoTime();
                this._a._p = (l2 - l) / 1000000L;
            } else if (this._a._o) {
                this._a._o = false;
                htmo._a(this._b._u, this._a);
            }
        }
        catch (UnknownHostException unknownHostException) {
            this._a._p = -1L;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            this._a._p = -1L;
        }
        catch (ConnectException connectException) {
            this._a._p = -1L;
        }
        catch (IOException iOException) {
            this._a._p = -1L;
        }
        catch (Exception exception) {
            this._a._p = -1L;
        }
        finally {
            Object object = htmo._e();
            synchronized (object) {
                htmo._h();
            }
        }
    }
}

