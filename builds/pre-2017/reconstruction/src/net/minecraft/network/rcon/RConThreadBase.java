/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.rcon;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.rcon.IServer;

public abstract class RConThreadBase
implements Runnable {
    public boolean _a;
    public IServer _b;
    public Thread _c;
    public int _d = 5;
    public List _e = new ArrayList();
    public List _f = new ArrayList();

    public RConThreadBase(IServer iServer) {
        this._b = iServer;
        if (this._b._l()) {
            this._c("Debugging is enabled, performance maybe reduced!");
        }
    }

    public synchronized void _a() {
        this._c = new Thread(this);
        this._c.start();
        this._a = true;
    }

    public boolean _b() {
        return this._a;
    }

    public void _a(String string) {
        this._b._e(string);
    }

    public void _b(String string) {
        this._b._b(string);
    }

    public void _c(String string) {
        this._b._c(string);
    }

    public void _d(String string) {
        this._b._d(string);
    }

    public int _c() {
        return this._b._g();
    }

    public void _a(DatagramSocket datagramSocket) {
        this._a("registerSocket: " + datagramSocket);
        this._e.add(datagramSocket);
    }

    public boolean _a(DatagramSocket datagramSocket, boolean bl) {
        this._a("closeSocket: " + datagramSocket);
        if (null == datagramSocket) {
            return false;
        }
        boolean bl2 = false;
        if (!datagramSocket.isClosed()) {
            datagramSocket.close();
            bl2 = true;
        }
        if (bl) {
            this._e.remove(datagramSocket);
        }
        return bl2;
    }

    public boolean _a(ServerSocket serverSocket) {
        return this._a(serverSocket, true);
    }

    public boolean _a(ServerSocket serverSocket, boolean bl) {
        this._a("closeSocket: " + serverSocket);
        if (null == serverSocket) {
            return false;
        }
        boolean bl2 = false;
        try {
            if (!serverSocket.isClosed()) {
                serverSocket.close();
                bl2 = true;
            }
        }
        catch (IOException iOException) {
            this._c("IO: " + iOException.getMessage());
        }
        if (bl) {
            this._f.remove(serverSocket);
        }
        return bl2;
    }

    public void _d() {
        this._a(false);
    }

    public void _a(boolean bl) {
        int n = 0;
        for (Closeable closeable : this._e) {
            if (!this._a((DatagramSocket)closeable, false)) continue;
            ++n;
        }
        this._e.clear();
        for (Closeable closeable : this._f) {
            if (!this._a((ServerSocket)closeable, false)) continue;
            ++n;
        }
        this._f.clear();
        if (bl && 0 < n) {
            this._c("Force closed " + n + " sockets");
        }
    }
}

