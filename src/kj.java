/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ho
 *  kf
 *  kg
 *  ki
 *  kk
 *  net.minecraft.server.MinecraftServer
 */
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
import net.minecraft.server.MinecraftServer;

public class kj
extends ki {
    private long g;
    private int h;
    private int i;
    private int j;
    private String k;
    private String l;
    private DatagramSocket m;
    private byte[] n = new byte[1460];
    private DatagramPacket o;
    private Map p;
    private String q;
    private String r;
    private Map s;
    private long t;
    private kf u;
    private long v;

    public kj(ho par1IServer) {
        super(par1IServer);
        this.h = par1IServer.a("query.port", 0);
        this.r = par1IServer.w();
        this.i = par1IServer.x();
        this.k = par1IServer.y();
        this.j = par1IServer.B();
        this.l = par1IServer.L();
        this.v = 0L;
        this.q = "0.0.0.0";
        if (0 != this.r.length() && !this.q.equals(this.r)) {
            this.q = this.r;
        } else {
            this.r = "0.0.0.0";
            try {
                InetAddress inetaddress = InetAddress.getLocalHost();
                this.q = inetaddress.getHostAddress();
            }
            catch (UnknownHostException unknownhostexception) {
                this.c("Unable to determine local host IP, please set server-ip in '" + par1IServer.b_() + "' : " + unknownhostexception.getMessage());
            }
        }
        if (0 == this.h) {
            this.h = this.i;
            this.b("Setting default query port to " + this.h);
            par1IServer.a("query.port", (Object)this.h);
            par1IServer.a("debug", (Object)false);
            par1IServer.a();
        }
        this.p = new HashMap();
        this.u = new kf(1460);
        this.s = new HashMap();
        this.t = new Date().getTime();
    }

    private void a(byte[] par1ArrayOfByte, DatagramPacket par2DatagramPacket) throws IOException {
        this.m.send(new DatagramPacket(par1ArrayOfByte, par1ArrayOfByte.length, par2DatagramPacket.getSocketAddress()));
    }

    private boolean a(DatagramPacket par1DatagramPacket) throws IOException {
        byte[] abyte = par1DatagramPacket.getData();
        int i2 = par1DatagramPacket.getLength();
        SocketAddress socketaddress = par1DatagramPacket.getSocketAddress();
        this.a("Packet len " + i2 + " [" + socketaddress + "]");
        if (3 <= i2 && -2 == abyte[0] && -3 == abyte[1]) {
            this.a("Packet '" + kg.a((byte)abyte[2]) + "' [" + socketaddress + "]");
            switch (abyte[2]) {
                case 0: {
                    if (!this.c(par1DatagramPacket).booleanValue()) {
                        this.a("Invalid challenge [" + socketaddress + "]");
                        return false;
                    }
                    if (15 == i2) {
                        this.a(this.b(par1DatagramPacket), par1DatagramPacket);
                        this.a("Rules [" + socketaddress + "]");
                    } else {
                        kf rconoutputstream = new kf(1460);
                        rconoutputstream.a(0);
                        rconoutputstream.a(this.a(par1DatagramPacket.getSocketAddress()));
                        rconoutputstream.a(this.k);
                        rconoutputstream.a("SMP");
                        rconoutputstream.a(this.l);
                        rconoutputstream.a(Integer.toString(this.d()));
                        rconoutputstream.a(Integer.toString(this.j));
                        rconoutputstream.a((short)this.i);
                        rconoutputstream.a(this.q);
                        this.a(rconoutputstream.a(), par1DatagramPacket);
                        this.a("Status [" + socketaddress + "]");
                    }
                }
                case 9: {
                    this.d(par1DatagramPacket);
                    this.a("Challenge [" + socketaddress + "]");
                    return true;
                }
            }
            return true;
        }
        this.a("Invalid packet [" + socketaddress + "]");
        return false;
    }

    private byte[] b(DatagramPacket par1DatagramPacket) throws IOException {
        long i2 = MinecraftServer.aq();
        if (i2 < this.v + 5000L) {
            byte[] abyte = this.u.a();
            byte[] abyte1 = this.a(par1DatagramPacket.getSocketAddress());
            abyte[1] = abyte1[0];
            abyte[2] = abyte1[1];
            abyte[3] = abyte1[2];
            abyte[4] = abyte1[3];
            return abyte;
        }
        this.v = i2;
        this.u.b();
        this.u.a(0);
        this.u.a(this.a(par1DatagramPacket.getSocketAddress()));
        this.u.a("splitnum");
        this.u.a(128);
        this.u.a(0);
        this.u.a("hostname");
        this.u.a(this.k);
        this.u.a("gametype");
        this.u.a("SMP");
        this.u.a("game_id");
        this.u.a("MINECRAFT");
        this.u.a("version");
        this.u.a(this.b.z());
        this.u.a("plugins");
        this.u.a(this.b.D());
        this.u.a("map");
        this.u.a(this.l);
        this.u.a("numplayers");
        this.u.a("" + this.d());
        this.u.a("maxplayers");
        this.u.a("" + this.j);
        this.u.a("hostport");
        this.u.a("" + this.i);
        this.u.a("hostip");
        this.u.a(this.q);
        this.u.a(0);
        this.u.a(1);
        this.u.a("player_");
        this.u.a(0);
        String[] astring = this.b.C();
        byte b0 = (byte)astring.length;
        for (byte b1 = (byte)(b0 - 1); b1 >= 0; b1 = (byte)(b1 - 1)) {
            this.u.a(astring[b1]);
        }
        this.u.a(0);
        return this.u.a();
    }

    private byte[] a(SocketAddress par1SocketAddress) {
        return ((kk)this.s.get(par1SocketAddress)).c();
    }

    private Boolean c(DatagramPacket par1DatagramPacket) {
        SocketAddress socketaddress = par1DatagramPacket.getSocketAddress();
        if (!this.s.containsKey(socketaddress)) {
            return false;
        }
        byte[] abyte = par1DatagramPacket.getData();
        return ((kk)this.s.get(socketaddress)).a() != kg.c((byte[])abyte, (int)7, (int)par1DatagramPacket.getLength()) ? Boolean.valueOf(false) : Boolean.valueOf(true);
    }

    private void d(DatagramPacket par1DatagramPacket) throws IOException {
        kk rconthreadqueryauth = new kk(this, par1DatagramPacket);
        this.s.put(par1DatagramPacket.getSocketAddress(), rconthreadqueryauth);
        this.a(rconthreadqueryauth.b(), par1DatagramPacket);
    }

    private void f() {
        long i2;
        if (this.a && (i2 = MinecraftServer.aq()) >= this.g + 30000L) {
            this.g = i2;
            Iterator iterator = this.s.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                if (!((kk)entry.getValue()).a(i2).booleanValue()) continue;
                iterator.remove();
            }
        }
    }

    public void run() {
        this.b("Query running on " + this.r + ":" + this.h);
        this.g = MinecraftServer.aq();
        this.o = new DatagramPacket(this.n, this.n.length);
        try {
            while (this.a) {
                try {
                    this.m.receive(this.o);
                    this.f();
                    this.a(this.o);
                }
                catch (SocketTimeoutException sockettimeoutexception) {
                    this.f();
                }
                catch (PortUnreachableException sockettimeoutexception) {
                }
                catch (IOException ioexception) {
                    this.a(ioexception);
                }
            }
        }
        finally {
            this.e();
        }
    }

    public void a() {
        if (!this.a) {
            if (0 < this.h && 65535 >= this.h) {
                if (this.g()) {
                    super.a();
                }
            } else {
                this.c("Invalid query port " + this.h + " found in '" + this.b.b_() + "' (queries disabled)");
            }
        }
    }

    private void a(Exception par1Exception) {
        if (this.a) {
            this.c("Unexpected exception, buggy JRE? (" + par1Exception.toString() + ")");
            if (!this.g()) {
                this.d("Failed to recover from buggy JRE, shutting down!");
                this.a = false;
            }
        }
    }

    private boolean g() {
        try {
            this.m = new DatagramSocket(this.h, InetAddress.getByName(this.r));
            this.a(this.m);
            this.m.setSoTimeout(500);
            return true;
        }
        catch (SocketException socketexception) {
            this.c("Unable to initialise query system on " + this.r + ":" + this.h + " (Socket): " + socketexception.getMessage());
        }
        catch (UnknownHostException unknownhostexception) {
            this.c("Unable to initialise query system on " + this.r + ":" + this.h + " (Unknown Host): " + unknownhostexception.getMessage());
        }
        catch (Exception exception) {
            this.c("Unable to initialise query system on " + this.r + ":" + this.h + " (E): " + exception.getMessage());
        }
        return false;
    }
}

