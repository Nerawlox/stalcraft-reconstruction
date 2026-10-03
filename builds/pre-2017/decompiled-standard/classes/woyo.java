/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.util.ezfc;

public class woyo
extends Thread {
    public final /* synthetic */ htsm _a;
    public final /* synthetic */ mayb _b;

    public woyo(mayb mayb2, htsm htsm2) {
        this._b = mayb2;
        this._a = htsm2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            this._a._d = (Object)((Object)ezfc._i) + "Polling..";
            long l = System.nanoTime();
            gqju._c(this._a);
            long l2 = System.nanoTime();
            this._a._e = (l2 - l) / 1000000L;
        }
        catch (UnknownHostException unknownHostException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)ezfc._e) + "Can't resolve hostname";
        }
        catch (SocketTimeoutException socketTimeoutException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)ezfc._e) + "Can't reach server";
        }
        catch (ConnectException connectException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)ezfc._e) + "Can't reach server";
        }
        catch (IOException iOException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)ezfc._e) + "Communication error";
        }
        catch (Exception exception) {
            this._a._e = -1L;
            this._a._d = "ERROR: " + exception.getClass();
        }
        finally {
            Object object = gqju._b();
            synchronized (object) {
                gqju._e();
            }
        }
    }
}

