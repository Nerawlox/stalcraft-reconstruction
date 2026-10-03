/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import net.minecraft.network.NetworkListenThread;

public class zibx
extends Thread {
    public final List _a = Collections.synchronizedList(new ArrayList());
    public final HashMap _b = new HashMap();
    public int _c;
    public final ServerSocket _d;
    public NetworkListenThread _e;
    public final InetAddress _f;
    public final int _g;

    public zibx(NetworkListenThread networkListenThread, InetAddress inetAddress, int n) throws IOException {
        super("Listen thread");
        this._e = networkListenThread;
        this._g = n;
        this._d = new ServerSocket(n, 0, inetAddress);
        this._f = inetAddress == null ? this._d.getInetAddress() : inetAddress;
        this._d.setPerformancePreferences(0, 2, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a() {
        List list = this._a;
        List list2 = this._a;
        synchronized (list2) {
            for (int i = 0; i < this._a.size(); ++i) {
                yezc yezc2 = (yezc)this._a.get(i);
                try {
                    yezc2._a();
                }
                catch (Exception exception) {
                    yezc2._a("Internal server error");
                    FMLLog.log(Level.SEVERE, exception, "Error handling login related packet - connection from %s refused", yezc2._c());
                    this._e._c()._O()._a("Failed to handle packet for " + yezc2._c() + ": " + exception, exception);
                }
                if (yezc2._e) {
                    this._a.remove(i--);
                }
                yezc2._d._a();
            }
        }
    }

    @Override
    public void run() {
        while (this._e._c) {
            try {
                Socket socket = this._d.accept();
                yezc yezc2 = new yezc(this._e._c(), socket, "Connection #" + this._c++);
                this._a(yezc2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        this._e._c()._O()._a("Closing listening thread");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(yezc yezc2) {
        if (yezc2 == null) {
            throw new IllegalArgumentException("Got null pendingconnection!");
        }
        List list = this._a;
        List list2 = this._a;
        synchronized (list2) {
            this._a.add(yezc2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(InetAddress inetAddress) {
        if (inetAddress != null) {
            HashMap hashMap = this._b;
            HashMap hashMap2 = this._b;
            synchronized (hashMap2) {
                this._b.remove(inetAddress);
            }
        }
    }

    public void _b() {
        try {
            this._d.close();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int _c() {
        return this._g;
    }
}

