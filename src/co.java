/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cm
 *  cpw.mods.fml.common.network.FMLNetworkHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  cs
 *  ez
 *  fy
 *  lg
 *  lp
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import net.minecraft.server.MinecraftServer;

public class co
implements cm {
    public static AtomicInteger a = new AtomicInteger();
    public static AtomicInteger b = new AtomicInteger();
    private final Object h = new Object();
    private final lp i;
    private Socket j;
    private final SocketAddress k;
    private volatile DataInputStream l;
    private volatile DataOutputStream m;
    private volatile boolean n = true;
    private volatile boolean o;
    private Queue p = new ConcurrentLinkedQueue();
    private List q = Collections.synchronizedList(new ArrayList());
    private List r = Collections.synchronizedList(new ArrayList());
    private ez s;
    private boolean t;
    private Thread u;
    private Thread v;
    private String w = "";
    private Object[] x;
    private int y;
    private int z;
    public static int[] c = new int[256];
    public static int[] d = new int[256];
    public int e;
    boolean f;
    boolean g;
    private SecretKey A;
    private PrivateKey B;
    private int C = 50;

    @SideOnly(value=Side.CLIENT)
    public co(lp par1ILogAgent, Socket par2Socket, String par3Str, ez par4NetHandler) throws IOException {
        this(par1ILogAgent, par2Socket, par3Str, par4NetHandler, null);
    }

    public co(lp par1ILogAgent, Socket par2Socket, String par3Str, ez par4NetHandler, PrivateKey par5PrivateKey) throws IOException {
        this.B = par5PrivateKey;
        this.j = par2Socket;
        this.i = par1ILogAgent;
        this.k = par2Socket.getRemoteSocketAddress();
        this.s = par4NetHandler;
        try {
            par2Socket.setSoTimeout(30000);
            par2Socket.setTrafficClass(24);
        }
        catch (SocketException socketexception) {
            System.err.println(socketexception.getMessage());
        }
        this.l = new DataInputStream(par2Socket.getInputStream());
        this.m = new DataOutputStream(new BufferedOutputStream(par2Socket.getOutputStream(), 5120));
        this.v = new cp(this, par3Str + " read thread");
        this.u = new cq(this, par3Str + " write thread");
        this.v.start();
        this.u.start();
    }

    @SideOnly(value=Side.CLIENT)
    public void f() {
        this.a();
        this.u = null;
        this.v = null;
    }

    public void a(ez par1NetHandler) {
        this.s = par1NetHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(ey par1Packet) {
        if (!this.t) {
            Object object = this.h;
            Object object2 = this.h;
            synchronized (object2) {
                this.z += par1Packet.a() + 1;
                this.q.add(par1Packet);
            }
        }
    }

    private boolean h() {
        boolean flag = false;
        try {
            int i2;
            int[] aint;
            ey packet;
            if ((this.e == 0 || !this.q.isEmpty() && MinecraftServer.aq() - ((ey)this.q.get((int)0)).n >= (long)this.e) && (packet = this.a(false)) != null) {
                ey.a(packet, (DataOutput)this.m);
                if (packet instanceof fy && !this.g) {
                    if (!this.s.a()) {
                        this.A = ((fy)packet).d();
                    }
                    this.k();
                }
                aint = d;
                int n = i2 = packet.n();
                aint[n] = aint[n] + (packet.a() + 1);
                flag = true;
            }
            if (this.C-- <= 0 && (this.e == 0 || !this.r.isEmpty() && MinecraftServer.aq() - ((ey)this.r.get((int)0)).n >= (long)this.e) && (packet = this.a(true)) != null) {
                ey.a(packet, (DataOutput)this.m);
                aint = d;
                int n = i2 = packet.n();
                aint[n] = aint[n] + (packet.a() + 1);
                this.C = 0;
                flag = true;
            }
            return flag;
        }
        catch (Exception exception) {
            if (!this.o) {
                this.a(exception);
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ey a(boolean par1) {
        ey packet = null;
        List list = par1 ? this.r : this.q;
        Object object = this.h;
        Object object2 = this.h;
        synchronized (object2) {
            while (!list.isEmpty() && packet == null) {
                packet = (ey)list.remove(0);
                this.z -= packet.a() + 1;
                if (!this.a(packet, par1)) continue;
                packet = null;
            }
            return packet;
        }
    }

    private boolean a(ey par1Packet, boolean par2) {
        ey packet1;
        if (!par1Packet.e()) {
            return false;
        }
        List list = par2 ? this.r : this.q;
        Iterator iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while ((packet1 = (ey)iterator.next()).n() != par1Packet.n());
        return par1Packet.a(packet1);
    }

    public void a() {
        if (this.v != null) {
            this.v.interrupt();
        }
        if (this.u != null) {
            this.u.interrupt();
        }
    }

    private boolean i() {
        boolean flag = false;
        try {
            ey packet = ey.a(this.i, this.l, this.s.a(), this.j);
            if (packet != null) {
                int i2;
                if (packet instanceof fy && !this.f) {
                    if (this.s.a()) {
                        this.A = ((fy)packet).a(this.B);
                    }
                    this.j();
                }
                int[] aint = c;
                int n = i2 = packet.n();
                aint[n] = aint[n] + (packet.a() + 1);
                if (!this.t) {
                    if (packet.a_() && this.s.b()) {
                        this.y = 0;
                        packet.a(this.s);
                    } else {
                        this.p.add(packet);
                    }
                }
                flag = true;
            } else {
                this.a("disconnect.endOfStream", new Object[0]);
            }
            return flag;
        }
        catch (Exception exception) {
            if (!this.o) {
                this.a(exception);
            }
            return false;
        }
    }

    private void a(Exception par1Exception) {
        par1Exception.printStackTrace();
        this.a("disconnect.genericReason", "Internal exception: " + par1Exception.toString());
    }

    public void a(String par1Str, Object ... par2ArrayOfObj) {
        if (this.n) {
            this.o = true;
            this.w = par1Str;
            this.x = par2ArrayOfObj;
            this.n = false;
            new cr(this).start();
            try {
                this.l.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this.m.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                this.j.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this.l = null;
            this.m = null;
            this.j = null;
        }
    }

    public void b() {
        if (this.z > 0x200000) {
            this.a("disconnect.overflow", new Object[0]);
        }
        if (this.p.isEmpty()) {
            if (this.y++ == 1200) {
                this.a("disconnect.timeout", new Object[0]);
            }
        } else {
            this.y = 0;
        }
        int i2 = 1000;
        while (i2-- >= 0) {
            ey packet = (ey)this.p.poll();
            if (packet == null || this.s.c()) continue;
            packet.a(this.s);
        }
        this.a();
        if (this.o && this.p.isEmpty()) {
            this.s.a(this.w, this.x);
            FMLNetworkHandler.onConnectionClosed((cm)this, (uf)this.s.getPlayer());
        }
    }

    public SocketAddress c() {
        return this.k;
    }

    public void d() {
        if (!this.t) {
            this.a();
            this.t = true;
            this.v.interrupt();
            new cs(this).start();
        }
    }

    private void j() throws IOException {
        this.f = true;
        InputStream inputstream = this.j.getInputStream();
        this.l = new DataInputStream(lg.a((SecretKey)this.A, (InputStream)inputstream));
    }

    private void k() throws IOException {
        this.m.flush();
        this.g = true;
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(lg.a((SecretKey)this.A, (OutputStream)this.j.getOutputStream()), 5120);
        this.m = new DataOutputStream(bufferedoutputstream);
    }

    public int e() {
        return this.r.size();
    }

    public Socket g() {
        return this.j;
    }

    static boolean a(co par0TcpConnection) {
        return par0TcpConnection.n;
    }

    static boolean b(co par0TcpConnection) {
        return par0TcpConnection.t;
    }

    static boolean c(co par0TcpConnection) {
        return par0TcpConnection.i();
    }

    static boolean d(co par0TcpConnection) {
        return par0TcpConnection.h();
    }

    static DataOutputStream e(co par0TcpConnection) {
        return par0TcpConnection.m;
    }

    static boolean f(co par0TcpConnection) {
        return par0TcpConnection.o;
    }

    static void a(co par0TcpConnection, Exception par1Exception) {
        par0TcpConnection.a(par1Exception);
    }

    static Thread g(co par0TcpConnection) {
        return par0TcpConnection.v;
    }

    static Thread h(co par0TcpConnection) {
        return par0TcpConnection.u;
    }
}

