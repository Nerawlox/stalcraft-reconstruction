/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;
import net.minecraft.logging.ILogAgent;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.qlgf;

public class TcpConnection
implements jjpj {
    public static AtomicInteger _a = new AtomicInteger();
    public static AtomicInteger _b = new AtomicInteger();
    public final Object _c;
    public final ILogAgent _d;
    public Socket _e;
    public final SocketAddress _f;
    public volatile DataInputStream _g;
    public volatile DataOutputStream _h;
    public volatile boolean _i;
    public volatile boolean _j;
    public Queue _k;
    public List _l;
    public List _m;
    public NetHandler _n;
    public boolean _o;
    public Thread _p;
    public Thread _q;
    public String _r;
    public Object[] _s;
    public int _t;
    public int _u;
    public static int[] _v = new int[256];
    public static int[] _w = new int[256];
    public int _x;
    public boolean _y;
    public boolean _z;
    public SecretKey _A;
    public PrivateKey _B;
    public int _C;

    @SideOnly(value=Side.CLIENT)
    public TcpConnection(ILogAgent iLogAgent, Socket socket, String string, NetHandler netHandler) throws IOException {
        this(iLogAgent, socket, string, netHandler, null);
    }

    public TcpConnection(ILogAgent iLogAgent, Socket socket, String string, NetHandler netHandler, PrivateKey privateKey) throws IOException {
        GloomyHooks.onTcpConnection(this, iLogAgent, socket, string, netHandler, privateKey);
        this._c = new Object();
        this._i = true;
        this._k = new ConcurrentLinkedQueue();
        this._l = Collections.synchronizedList(new ArrayList());
        this._m = Collections.synchronizedList(new ArrayList());
        this._r = "";
        this._C = 50;
        this._B = privateKey;
        this._e = socket;
        this._d = iLogAgent;
        this._f = socket.getRemoteSocketAddress();
        this._n = netHandler;
        try {
            socket.setSoTimeout(30000);
            socket.setTrafficClass(24);
        }
        catch (SocketException socketException) {
            System.err.println(socketException.getMessage());
        }
        this._g = new DataInputStream(socket.getInputStream());
        this._h = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream(), 5120));
        this._q = new iglx(this, string + " read thread");
        this._p = new qodo(this, string + " write thread");
        this._q.start();
        this._p.start();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void _f() {
        this._a();
        this._p = null;
        this._q = null;
    }

    @Override
    public void _a(NetHandler netHandler) {
        this._n = netHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void _a(Packet packet) {
        if (!this._o) {
            Object object = this._c;
            Object object2 = this._c;
            synchronized (object2) {
                this._u += packet.getPacketSize() + 1;
                this._l.add(packet);
            }
        }
    }

    public boolean _g() {
        boolean bl = false;
        try {
            int n;
            int[] nArray;
            Packet packet;
            if ((this._x == 0 || !this._l.isEmpty() && MinecraftServer.__aq() - ((Packet)this._l.get((int)0)).creationTimeMillis >= (long)this._x) && (packet = this._a(false)) != null) {
                Packet.writePacket(packet, this._h);
                if (packet instanceof Packet252SharedKey && !this._z) {
                    if (!this._n.isServerHandler()) {
                        this._A = ((Packet252SharedKey)packet)._a();
                    }
                    this._j();
                }
                nArray = _w;
                int n2 = n = packet.getPacketId();
                nArray[n2] = nArray[n2] + (packet.getPacketSize() + 1);
                bl = true;
            }
            if (this._C-- <= 0 && (this._x == 0 || !this._m.isEmpty() && MinecraftServer.__aq() - ((Packet)this._m.get((int)0)).creationTimeMillis >= (long)this._x) && (packet = this._a(true)) != null) {
                Packet.writePacket(packet, this._h);
                nArray = _w;
                int n3 = n = packet.getPacketId();
                nArray[n3] = nArray[n3] + (packet.getPacketSize() + 1);
                this._C = 0;
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            if (!this._j) {
                this._a(exception);
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Packet _a(boolean bl) {
        Packet packet = null;
        List list2 = bl ? this._m : this._l;
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            while (!list2.isEmpty() && packet == null) {
                packet = (Packet)list2.remove(0);
                this._u -= packet.getPacketSize() + 1;
                if (!this._a(packet, bl)) continue;
                packet = null;
            }
            return packet;
        }
    }

    public boolean _a(Packet packet, boolean bl) {
        Packet packet2;
        if (!packet.isRealPacket()) {
            return false;
        }
        List list2 = bl ? this._m : this._l;
        Iterator iterator2 = list2.iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while ((packet2 = (Packet)iterator2.next()).getPacketId() != packet.getPacketId());
        return packet.containsSameEntityIDAs(packet2);
    }

    @Override
    public void _a() {
        if (this._q != null) {
            this._q.interrupt();
        }
        if (this._p != null) {
            this._p.interrupt();
        }
    }

    public boolean _h() {
        boolean bl = false;
        try {
            Packet packet = Packet.readPacket(this._d, this._g, this._n.isServerHandler(), this._e);
            if (packet != null) {
                int n;
                if (packet instanceof Packet252SharedKey && !this._y) {
                    if (this._n.isServerHandler()) {
                        this._A = ((Packet252SharedKey)packet)._a(this._B);
                    }
                    this._i();
                }
                int[] nArray = _v;
                int n2 = n = packet.getPacketId();
                nArray[n2] = nArray[n2] + (packet.getPacketSize() + 1);
                if (!this._o) {
                    if (packet.canProcessAsync() && this._n.canProcessPacketsAsync()) {
                        this._t = 0;
                        packet.processPacket(this._n);
                    } else {
                        this._k.add(packet);
                    }
                }
                bl = true;
            } else {
                this._a("disconnect.endOfStream", new Object[0]);
            }
            return bl;
        }
        catch (Exception exception) {
            if (!this._j) {
                this._a(exception);
            }
            return false;
        }
    }

    public void _a(Exception exception) {
        exception.printStackTrace();
        this._a("disconnect.genericReason", "Internal exception: " + exception.toString());
    }

    @Override
    public void _a(String string, Object ... objectArray) {
        if (this._i) {
            this._j = true;
            this._r = string;
            this._s = objectArray;
            this._i = false;
            new kmru(this).start();
            try {
                this._g.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this._h.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this._e.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this._g = null;
            this._h = null;
            this._e = null;
        }
    }

    @Override
    public void _b() {
        if (this._u > 0x200000) {
            this._a("disconnect.overflow", new Object[0]);
        }
        if (this._k.isEmpty()) {
            if (this._t++ == 1200) {
                this._a("disconnect.timeout", new Object[0]);
            }
        } else {
            this._t = 0;
        }
        int n = 1000;
        while (n-- >= 0) {
            Packet packet = (Packet)this._k.poll();
            if (packet == null || this._n.isConnectionClosed()) continue;
            packet.processPacket(this._n);
        }
        this._a();
        if (this._j && this._k.isEmpty()) {
            this._n.handleErrorMessage(this._r, this._s);
            FMLNetworkHandler.onConnectionClosed(this, this._n.getPlayer());
        }
    }

    @Override
    public SocketAddress _c() {
        return this._f;
    }

    @Override
    public void _d() {
        if (!this._o) {
            this._a();
            this._o = true;
            this._q.interrupt();
            new rrgv(this).start();
        }
    }

    public void _i() throws IOException {
        this._y = true;
        InputStream inputStream = this._e.getInputStream();
        this._g = new DataInputStream(qlgf._a(this._A, inputStream));
    }

    public void _j() throws IOException {
        this._h.flush();
        this._z = true;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(qlgf._a(this._A, this._e.getOutputStream()), 5120);
        this._h = new DataOutputStream(bufferedOutputStream);
    }

    @Override
    public int _e() {
        return this._m.size();
    }

    public Socket _k() {
        return this._e;
    }

    public static boolean _a(TcpConnection tcpConnection) {
        return tcpConnection._i;
    }

    public static boolean _b(TcpConnection tcpConnection) {
        return tcpConnection._o;
    }

    public static boolean _c(TcpConnection tcpConnection) {
        return tcpConnection._h();
    }

    public static boolean _d(TcpConnection tcpConnection) {
        return tcpConnection._g();
    }

    public static DataOutputStream _e(TcpConnection tcpConnection) {
        return tcpConnection._h;
    }

    public static boolean _f(TcpConnection tcpConnection) {
        return tcpConnection._j;
    }

    public static void _a(TcpConnection tcpConnection, Exception exception) {
        tcpConnection._a(exception);
    }

    public static Thread _g(TcpConnection tcpConnection) {
        return tcpConnection._q;
    }

    public static Thread _h(TcpConnection tcpConnection) {
        return tcpConnection._p;
    }
}

