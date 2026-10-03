/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acd
 *  acg
 *  ad
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  go
 *  hn
 *  ho
 *  ir
 *  iu
 *  iv
 *  iw
 *  ix
 *  kd
 *  lc
 *  lg
 *  lp
 *  mv
 *  net.minecraft.server.MinecraftServer
 *  t
 */
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class is
extends MinecraftServer
implements ho {
    private final List l = Collections.synchronizedList(new ArrayList());
    private final lp m;
    private kj n;
    private kn o;
    private hq p;
    private boolean q;
    private ace r;
    private kd s;
    private boolean t;

    public is(File par1File) {
        super(par1File);
        this.m = new lc("Minecraft-Server", (String)null, new File(par1File, "server.log").getAbsolutePath());
        new it(this);
    }

    protected boolean d() throws IOException {
        acg worldtype;
        iu dedicatedservercommandthread = new iu(this);
        dedicatedservercommandthread.setDaemon(true);
        dedicatedservercommandthread.start();
        this.an().a("Starting minecraft server version 1.6.4");
        if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
            this.an().b("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
        }
        FMLCommonHandler.instance().onServerStart(this);
        this.an().a("Loading properties");
        this.p = new hq(new File("server.properties"), this.an());
        if (this.K()) {
            this.c("127.0.0.1");
        } else {
            this.d(this.p.a("online-mode", true));
            this.c(this.p.a("server-ip", ""));
        }
        this.e(this.p.a("spawn-animals", true));
        this.f(this.p.a("spawn-npcs", true));
        this.g(this.p.a("pvp", true));
        this.h(this.p.a("allow-flight", false));
        this.m(this.p.a("texture-pack", ""));
        this.n(this.p.a("motd", "A Minecraft Server"));
        this.i(this.p.a("force-gamemode", false));
        this.e(this.p.a("player-idle-timeout", 0));
        if (this.p.a("difficulty", 1) < 0) {
            this.p.a("difficulty", (Object)0);
        } else if (this.p.a("difficulty", 1) > 3) {
            this.p.a("difficulty", (Object)3);
        }
        this.q = this.p.a("generate-structures", true);
        int i2 = this.p.a("gamemode", ace.b.a());
        this.r = acd.a((int)i2);
        this.an().a("Default game type: " + (Object)((Object)this.r));
        InetAddress inetaddress = null;
        if (this.n().length() > 0) {
            inetaddress = InetAddress.getByName(this.n());
        }
        if (this.I() < 0) {
            this.b(this.p.a("server-port", 25565));
        }
        this.an().a("Generating keypair");
        this.a(lg.b());
        this.an().a("Starting Minecraft server on " + (this.n().length() == 0 ? "*" : this.n()) + ":" + this.I());
        try {
            this.s = new ix((MinecraftServer)this, inetaddress, this.I());
        }
        catch (IOException ioexception) {
            this.an().b("**** FAILED TO BIND TO PORT!");
            this.an().b("The exception was: {0}", new Object[]{ioexception.toString()});
            this.an().b("Perhaps a server is already running on that port?");
            return false;
        }
        if (!this.W()) {
            this.an().b("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            this.an().b("The server will make no attempt to authenticate usernames. Beware.");
            this.an().b("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            this.an().b("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
        }
        FMLCommonHandler.instance().onServerStarted();
        this.a((hn)new ir(this));
        long j2 = System.nanoTime();
        if (this.L() == null) {
            this.k(this.p.a("level-name", "world"));
        }
        String s2 = this.p.a("level-seed", "");
        String s1 = this.p.a("level-type", "DEFAULT");
        String s22 = this.p.a("generator-settings", "");
        long k = new Random().nextLong();
        if (s2.length() > 0) {
            try {
                long l2 = Long.parseLong(s2);
                if (l2 != 0L) {
                    k = l2;
                }
            }
            catch (NumberFormatException numberformatexception) {
                k = s2.hashCode();
            }
        }
        if ((worldtype = acg.a((String)s1)) == null) {
            worldtype = acg.b;
        }
        this.d(this.p.a("max-build-height", 256));
        this.d((this.ad() + 8) / 16 * 16);
        this.d(ls.a(this.ad(), 64, 256));
        this.p.a("max-build-height", (Object)this.ad());
        if (!FMLCommonHandler.instance().handleServerAboutToStart((MinecraftServer)this)) {
            return false;
        }
        this.an().a("Preparing level \"" + this.L() + "\"");
        this.a(this.L(), this.L(), k, worldtype, s22);
        long i1 = System.nanoTime() - j2;
        String s3 = String.format("%.3fs", (double)i1 / 1.0E9);
        this.an().a("Done (" + s3 + ")! For help, type \"help\" or \"?\"");
        if (this.p.a("enable-query", false)) {
            this.an().a("Starting GS4 status listener");
            this.n = new kj(this);
            this.n.a();
        }
        if (this.p.a("enable-rcon", false)) {
            this.an().a("Starting remote control listener");
            this.o = new kn(this);
            this.o.a();
        }
        return FMLCommonHandler.instance().handleServerStarting((MinecraftServer)this);
    }

    public boolean g() {
        return this.q;
    }

    public ace h() {
        return this.r;
    }

    public int i() {
        return this.p.a("difficulty", 1);
    }

    public boolean j() {
        return this.p.a("hardcore", false);
    }

    protected void a(b par1CrashReport) {
        while (this.o()) {
            this.as();
            try {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedexception) {
                interruptedexception.printStackTrace();
            }
        }
    }

    public b b(b par1CrashReport) {
        par1CrashReport = super.b(par1CrashReport);
        par1CrashReport.g().a("Is Modded", (Callable)new iv(this));
        par1CrashReport.g().a("Type", (Callable)new iw(this));
        return par1CrashReport;
    }

    protected void r() {
        System.exit(0);
    }

    public void t() {
        super.t();
        this.as();
    }

    public boolean u() {
        return this.p.a("allow-nether", true);
    }

    public boolean N() {
        return this.p.a("spawn-monsters", true);
    }

    public void a(mv par1PlayerUsageSnooper) {
        par1PlayerUsageSnooper.a("whitelist_enabled", (Object)this.at().n());
        par1PlayerUsageSnooper.a("whitelist_count", (Object)this.at().h().size());
        super.a(par1PlayerUsageSnooper);
    }

    public boolean T() {
        return this.p.a("snooper-enabled", true);
    }

    public void a(String par1Str, ad par2ICommandSender) {
        this.l.add(new go(par1Str, par2ICommandSender));
    }

    public void as() {
        while (!this.l.isEmpty()) {
            go servercommand = (go)this.l.remove(0);
            this.G().a(servercommand.b, servercommand.a);
        }
    }

    public boolean V() {
        return true;
    }

    public ir at() {
        return (ir)super.af();
    }

    public kd ag() {
        return this.s;
    }

    public int a(String par1Str, int par2) {
        return this.p.a(par1Str, par2);
    }

    public String a(String par1Str, String par2Str) {
        return this.p.a(par1Str, par2Str);
    }

    public boolean a(String par1Str, boolean par2) {
        return this.p.a(par1Str, par2);
    }

    public void a(String par1Str, Object par2Obj) {
        this.p.a(par1Str, par2Obj);
    }

    public void a() {
        this.p.b();
    }

    public String b_() {
        File file1 = this.p.c();
        return file1 != null ? file1.getAbsolutePath() : "No settings file";
    }

    public boolean ai() {
        return this.t;
    }

    public String a(ace par1EnumGameType, boolean par2) {
        return "";
    }

    public boolean ab() {
        return this.p.a("enable-command-block", false);
    }

    public int am() {
        return this.p.a("spawn-protection", super.am());
    }

    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer) {
        int i1;
        if (par1World.t.i != 0) {
            return false;
        }
        if (this.at().i().isEmpty()) {
            return false;
        }
        if (this.at().e(par5EntityPlayer.c_())) {
            return false;
        }
        if (this.am() <= 0) {
            return false;
        }
        t chunkcoordinates = par1World.K();
        int l2 = ls.a(par2 - chunkcoordinates.a);
        int j1 = Math.max(l2, i1 = ls.a(par4 - chunkcoordinates.c));
        return j1 <= this.am();
    }

    public lp an() {
        return this.m;
    }

    public int k() {
        return this.p.a("op-permission-level", 4);
    }

    public void e(int par1) {
        super.e(par1);
        this.p.a("player-idle-timeout", (Object)par1);
        this.a();
    }

    public hn af() {
        return this.at();
    }

    @SideOnly(value=Side.SERVER)
    public void au() {
        iz.a(this);
        this.t = true;
    }
}

