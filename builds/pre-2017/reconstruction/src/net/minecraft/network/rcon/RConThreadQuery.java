/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.rcon;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.RConThreadBase;
import net.minecraft.network.rcon.RConThreadQueryAuth;
import net.minecraft.server.MinecraftServer;

public class RConThreadQuery
extends RConThreadBase {
    public long _g;
    public int _h;
    public int _i;
    public int _j;
    public String _k;
    public String _l;
    public DatagramSocket _m;
    public byte[] _n = new byte[1460];
    public DatagramPacket _o;
    public Map _p;
    public String _q;
    public String _r;
    public Map _s;
    public long _t;
    public oial _u;
    public long _v;

    public RConThreadQuery(IServer iServer) {
        super(iServer);
        this._h = iServer._a("query.port", 0);
        this._r = iServer._c();
        this._i = iServer._d();
        this._k = iServer._e();
        this._j = iServer._h();
        this._l = iServer._j();
        this._v = 0L;
        this._q = "0.0.0.0";
        if (0 == this._r.length() || this._q.equals(this._r)) {
            this._r = "0.0.0.0";
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                this._q = inetAddress.getHostAddress();
            }
            catch (UnknownHostException unknownHostException) {
                this._c("Unable to determine local host IP, please set server-ip in '" + iServer._b() + "' : " + unknownHostException.getMessage());
            }
        } else {
            this._q = this._r;
        }
        if (0 == this._h) {
            this._h = this._i;
            this._b("Setting default query port to " + this._h);
            iServer._a("query.port", (Object)this._h);
            iServer._a("debug", false);
            iServer._a();
        }
        this._p = new HashMap();
        this._u = new oial(1460);
        this._s = new HashMap();
        this._t = new Date().getTime();
    }

    public void _a(byte[] byArray, DatagramPacket datagramPacket) {
        this._m.send(new DatagramPacket(byArray, byArray.length, datagramPacket.getSocketAddress()));
    }

    public boolean _a(DatagramPacket datagramPacket) {
        byte[] byArray = datagramPacket.getData();
        int n = datagramPacket.getLength();
        SocketAddress socketAddress = datagramPacket.getSocketAddress();
        this._a("Packet len " + n + " [" + socketAddress + "]");
        if (3 > n || -2 != byArray[0] || -3 != byArray[1]) {
            this._a("Invalid packet [" + socketAddress + "]");
            return false;
        }
        this._a("Packet '" + ywcd._a(byArray[2]) + "' [" + socketAddress + "]");
        switch (byArray[2]) {
            case 9: {
                this._d(datagramPacket);
                this._a("Challenge [" + socketAddress + "]");
                return true;
            }
            case 0: {
                if (!this._c(datagramPacket).booleanValue()) {
                    this._a("Invalid challenge [" + socketAddress + "]");
                    return false;
                }
                if (15 == n) {
                    this._a(this._b(datagramPacket), datagramPacket);
                    this._a("Rules [" + socketAddress + "]");
                    break;
                }
                oial oial2 = new oial(1460);
                oial2._a(0);
                oial2._a(this._a(datagramPacket.getSocketAddress()));
                oial2._a(this._k);
                oial2._a("SMP");
                oial2._a(this._l);
                oial2._a(Integer.toString(this._c()));
                oial2._a(Integer.toString(this._j));
                oial2._a((short)this._i);
                oial2._a(this._q);
                this._a(oial2._a(), datagramPacket);
                this._a("Status [" + socketAddress + "]");
            }
        }
        return true;
    }

    public byte[] _b(DatagramPacket datagramPacket) {
        long l = MinecraftServer.__aq();
        if (l < this._v + 5000L) {
            byte[] byArray = this._u._a();
            byte[] byArray2 = this._a(datagramPacket.getSocketAddress());
            byArray[1] = byArray2[0];
            byArray[2] = byArray2[1];
            byArray[3] = byArray2[2];
            byArray[4] = byArray2[3];
            return byArray;
        }
        this._v = l;
        this._u._b();
        this._u._a(0);
        this._u._a(this._a(datagramPacket.getSocketAddress()));
        this._u._a("splitnum");
        this._u._a(128);
        this._u._a(0);
        this._u._a("hostname");
        this._u._a(this._k);
        this._u._a("gametype");
        this._u._a("SMP");
        this._u._a("game_id");
        this._u._a("MINECRAFT");
        this._u._a("version");
        this._u._a(this._b._f());
        this._u._a("plugins");
        this._u._a(this._b._k());
        this._u._a("map");
        this._u._a(this._l);
        this._u._a("numplayers");
        this._u._a("" + this._c());
        this._u._a("maxplayers");
        this._u._a("" + this._j);
        this._u._a("hostport");
        this._u._a("" + this._i);
        this._u._a("hostip");
        this._u._a(this._q);
        this._u._a(0);
        this._u._a(1);
        this._u._a("player_");
        this._u._a(0);
        String[] stringArray = this._b._i();
        byte by = (byte)stringArray.length;
        for (byte by2 = (byte)(by - 1); by2 >= 0; by2 = (byte)(by2 - 1)) {
            this._u._a(stringArray[by2]);
        }
        this._u._a(0);
        return this._u._a();
    }

    public byte[] _a(SocketAddress socketAddress) {
        return ((RConThreadQueryAuth)this._s.get(socketAddress))._c();
    }

    public Boolean _c(DatagramPacket datagramPacket) {
        SocketAddress socketAddress = datagramPacket.getSocketAddress();
        if (!this._s.containsKey(socketAddress)) {
            return false;
        }
        byte[] byArray = datagramPacket.getData();
        if (((RConThreadQueryAuth)this._s.get(socketAddress))._a() != ywcd._c(byArray, 7, datagramPacket.getLength())) {
            return false;
        }
        return true;
    }

    public void _d(DatagramPacket datagramPacket) {
        RConThreadQueryAuth rConThreadQueryAuth = new RConThreadQueryAuth(this, datagramPacket);
        this._s.put(datagramPacket.getSocketAddress(), rConThreadQueryAuth);
        this._a(rConThreadQueryAuth._b(), datagramPacket);
    }

    public void _e() {
        if (!this._a) {
            return;
        }
        long l = MinecraftServer.__aq();
        if (l < this._g + 30000L) {
            return;
        }
        this._g = l;
        Iterator iterator2 = this._s.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            if (!((RConThreadQueryAuth)entry.getValue())._a(l).booleanValue()) continue;
            iterator2.remove();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        this._b("Query running on " + this._r + ":" + this._h);
        this._g = MinecraftServer.__aq();
        this._o = new DatagramPacket(this._n, this._n.length);
        try {
            while (this._a) {
                try {
                    this._m.receive(this._o);
                    this._e();
                    this._a(this._o);
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    this._e();
                }
                catch (PortUnreachableException portUnreachableException) {
                }
                catch (IOException iOException) {
                    this._a(iOException);
                }
            }
        }
        finally {
            this._d();
        }
    }

    @Override
    public void _a() {
        if (this._a) {
            return;
        }
        if (0 >= this._h || 65535 < this._h) {
            this._c("Invalid query port " + this._h + " found in '" + this._b._b() + "' (queries disabled)");
            return;
        }
        if (this._f()) {
            super._a();
        }
    }

    public void _a(Exception exception) {
        if (!this._a) {
            return;
        }
        this._c("Unexpected exception, buggy JRE? (" + exception.toString() + ")");
        if (!this._f()) {
            this._d("Failed to recover from buggy JRE, shutting down!");
            this._a = false;
        }
    }

    public boolean _f() {
        try {
            this._m = new DatagramSocket(this._h, InetAddress.getByName(this._r));
            this._a(this._m);
            this._m.setSoTimeout(500);
            return true;
        }
        catch (SocketException socketException) {
            this._c("Unable to initialise query system on " + this._r + ":" + this._h + " (Socket): " + socketException.getMessage());
        }
        catch (UnknownHostException unknownHostException) {
            this._c("Unable to initialise query system on " + this._r + ":" + this._h + " (Unknown Host): " + unknownHostException.getMessage());
        }
        catch (Exception exception) {
            this._c("Unable to initialise query system on " + this._r + ":" + this._h + " (E): " + exception.getMessage());
        }
        return false;
    }
}

