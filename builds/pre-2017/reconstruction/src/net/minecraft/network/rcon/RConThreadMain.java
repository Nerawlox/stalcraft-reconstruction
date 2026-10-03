/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.rcon;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.RConThreadBase;
import net.minecraft.network.rcon.RConThreadClient;

public class RConThreadMain
extends RConThreadBase {
    public int _g;
    public int _h;
    public String _i;
    public ServerSocket _j;
    public String _k;
    public Map _l;

    public RConThreadMain(IServer iServer) {
        super(iServer);
        this._g = iServer._a("rcon.port", 0);
        this._k = iServer._a("rcon.password", "");
        this._i = iServer._c();
        this._h = iServer._d();
        if (0 == this._g) {
            this._g = this._h + 10;
            this._b("Setting default rcon port to " + this._g);
            iServer._a("rcon.port", (Object)this._g);
            if (0 == this._k.length()) {
                iServer._a("rcon.password", (Object)"");
            }
            iServer._a();
        }
        if (0 == this._i.length()) {
            this._i = "0.0.0.0";
        }
        this._e();
        this._j = null;
    }

    public void _e() {
        this._l = new HashMap();
    }

    public void _f() {
        Iterator iterator2 = this._l.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            if (((RConThreadClient)entry.getValue())._b()) continue;
            iterator2.remove();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        this._b("RCON running on " + this._i + ":" + this._g);
        try {
            while (this._a) {
                try {
                    Socket socket = this._j.accept();
                    socket.setSoTimeout(500);
                    RConThreadClient rConThreadClient = new RConThreadClient(this._b, socket);
                    rConThreadClient._a();
                    this._l.put(socket.getRemoteSocketAddress(), rConThreadClient);
                    this._f();
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    this._f();
                }
                catch (IOException iOException) {
                    if (!this._a) continue;
                    this._b("IO: " + iOException.getMessage());
                }
            }
        }
        finally {
            this._a(this._j);
        }
    }

    @Override
    public void _a() {
        if (0 == this._k.length()) {
            this._c("No rcon password set in '" + this._b._b() + "', rcon disabled!");
            return;
        }
        if (0 >= this._g || 65535 < this._g) {
            this._c("Invalid rcon port " + this._g + " found in '" + this._b._b() + "', rcon disabled!");
            return;
        }
        if (this._a) {
            return;
        }
        try {
            this._j = new ServerSocket(this._g, 0, InetAddress.getByName(this._i));
            this._j.setSoTimeout(500);
            super._a();
        }
        catch (IOException iOException) {
            this._c("Unable to initialise rcon on " + this._i + ":" + this._g + " : " + iOException.getMessage());
        }
    }
}

