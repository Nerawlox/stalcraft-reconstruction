/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cm
 *  cpw.mods.fml.common.network.FMLNetworkHandler
 *  do
 *  dq
 *  ea
 *  eb
 *  eg
 *  ep
 *  ez
 *  fj
 *  fy
 *  hn
 *  ix
 *  jz
 *  ma
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.server.MinecraftServer;

public class jy
extends ez {
    private static Random c = new Random();
    private byte[] d;
    private final MinecraftServer e;
    public final co a;
    public boolean b;
    private int f;
    public String g;
    private volatile boolean h;
    private String i = "";
    private boolean j;
    private SecretKey k;

    public jy(MinecraftServer par1MinecraftServer, Socket par2Socket, String par3Str) throws IOException {
        this.e = par1MinecraftServer;
        this.a = new co(par1MinecraftServer.an(), par2Socket, par3Str, this, par1MinecraftServer.H().getPrivate());
        this.a.e = 0;
    }

    public void d() {
        if (this.h) {
            this.e();
        }
        if (this.f++ == 6000) {
            this.a("Took too long to log in");
        } else {
            this.a.b();
        }
    }

    public void a(String par1Str) {
        try {
            this.e.an().a("Disconnecting " + this.f() + ": " + par1Str);
            this.a.a((ey)new eb(par1Str));
            this.a.d();
            this.b = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(dq par1Packet2ClientProtocol) {
        if (this.g != null) {
            this.a("Quit repeating yourself!");
        } else {
            this.g = par1Packet2ClientProtocol.f();
            if (!this.g.equals(ma.a((String)this.g))) {
                this.a("Invalid username!");
            } else {
                PublicKey publickey = this.e.H().getPublic();
                if (par1Packet2ClientProtocol.d() != 78) {
                    if (par1Packet2ClientProtocol.d() > 78) {
                        this.a("Outdated server!");
                    } else {
                        this.a("Outdated client!");
                    }
                } else {
                    this.i = this.e.W() ? Long.toString(c.nextLong(), 16) : "-";
                    this.d = new byte[4];
                    c.nextBytes(this.d);
                    this.a.a((ey)new fj(this.i, publickey, this.d));
                }
            }
        }
    }

    public void a(fy par1Packet252SharedKey) {
        PrivateKey privatekey = this.e.H().getPrivate();
        this.k = par1Packet252SharedKey.a(privatekey);
        if (!Arrays.equals(this.d, par1Packet252SharedKey.b(privatekey))) {
            this.a("Invalid client reply");
        }
        this.a.a((ey)new fy());
    }

    public void a(do par1Packet205ClientCommand) {
        if (par1Packet205ClientCommand.a == 0) {
            if (this.j) {
                this.a("Duplicate login");
                return;
            }
            this.j = true;
            if (this.e.W()) {
                new jz(this).start();
            } else {
                this.h = true;
            }
        }
    }

    public void a(ep par1Packet1Login) {
        FMLNetworkHandler.handleLoginPacketOnServer((jy)this, (ep)par1Packet1Login);
    }

    public void e() {
        FMLNetworkHandler.onConnectionReceivedFromClient((jy)this, (MinecraftServer)this.e, (SocketAddress)this.a.c(), (String)this.g);
    }

    public void completeConnection(String s2) {
        if (s2 != null) {
            this.a(s2);
        } else {
            jv entityplayermp = this.e.af().a(this.g);
            if (entityplayermp != null) {
                this.e.af().a((cm)this.a, entityplayermp);
            }
        }
        this.b = true;
    }

    public void a(String par1Str, Object[] par2ArrayOfObj) {
        this.e.an().a(this.f() + " lost connection");
        this.b = true;
    }

    public void a(eg par1Packet254ServerPing) {
        try {
            hn serverconfigurationmanager = this.e.af();
            String s2 = null;
            if (par1Packet254ServerPing.d()) {
                s2 = this.e.ac() + "\u00a7" + serverconfigurationmanager.k() + "\u00a7" + serverconfigurationmanager.l();
            } else {
                List<Serializable> list = Arrays.asList(1, 78, this.e.z(), this.e.ac(), serverconfigurationmanager.k(), serverconfigurationmanager.l());
                for (Serializable object : list) {
                    s2 = s2 == null ? "\u00a7" : s2 + "\u0000";
                    s2 = s2 + object.toString().replaceAll("\u0000", "");
                }
            }
            InetAddress inetaddress = null;
            if (this.a.g() != null) {
                inetaddress = this.a.g().getInetAddress();
            }
            this.a.a((ey)new eb(s2));
            this.a.d();
            if (inetaddress != null && this.e.ag() instanceof ix) {
                ((ix)this.e.ag()).a(inetaddress);
            }
            this.b = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(ey par1Packet) {
        this.a("Protocol error");
    }

    public String f() {
        return this.g != null ? this.g + " [" + this.a.c().toString() + "]" : this.a.c().toString();
    }

    public boolean a() {
        return true;
    }

    public boolean c() {
        return this.b;
    }

    static String a(jy par0NetLoginHandler) {
        return par0NetLoginHandler.i;
    }

    static MinecraftServer b(jy par0NetLoginHandler) {
        return par0NetLoginHandler.e;
    }

    static SecretKey c(jy par0NetLoginHandler) {
        return par0NetLoginHandler.k;
    }

    static String d(jy par0NetLoginHandler) {
        return par0NetLoginHandler.g;
    }

    public static boolean a(jy par0NetLoginHandler, boolean par1) {
        par0NetLoginHandler.h = par1;
        return par0NetLoginHandler.h;
    }

    public void a(ea par1Packet250CustomPayload) {
        FMLNetworkHandler.handlePacket250Packet((ea)par1Packet250CustomPayload, (cm)this.a, (ez)this);
    }

    public void handleVanilla250Packet(ea payload) {
    }

    public uf getPlayer() {
        return null;
    }
}

