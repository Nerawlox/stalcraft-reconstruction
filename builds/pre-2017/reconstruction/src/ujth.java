/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.logging.ILogAgent;
import net.minecraft.logging.LogAgent;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.RConThreadMain;
import net.minecraft.network.rcon.RConThreadQuery;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.PropertyManager;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.qlgf;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;

public class ujth
extends MinecraftServer
implements IServer {
    public final List _W = Collections.synchronizedList(new ArrayList());
    public final ILogAgent _X;
    public RConThreadQuery _Y;
    public RConThreadMain _Z;
    public PropertyManager __aa;
    public boolean __ab;
    public EnumGameType __ac;
    public NetworkListenThread __ad;
    public boolean __ae;

    public ujth(File file) {
        super(file);
        this._X = new LogAgent("Minecraft-Server", null, new File(file, "server.log").getAbsolutePath());
        new dign(this);
    }

    @Override
    public boolean _n() throws IOException {
        nwix nwix2;
        vmwh vmwh2 = new vmwh(this);
        vmwh2.setDaemon(true);
        vmwh2.start();
        this._O()._a("Starting minecraft server version 1.6.4");
        if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
            this._O()._b("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
        }
        FMLCommonHandler.instance().onServerStart(this);
        this._O()._a("Loading properties");
        this.__aa = new PropertyManager(new File("server.properties"), this._O());
        if (this._N()) {
            this._h("127.0.0.1");
        } else {
            this._d(this.__aa._a("online-mode", true));
            this._h(this.__aa._a("server-ip", ""));
        }
        this._e(this.__aa._a("spawn-animals", true));
        this._f(this.__aa._a("spawn-npcs", true));
        this._g(this.__aa._a("pvp", true));
        this._h(this.__aa._a("allow-flight", false));
        this._m(this.__aa._a("texture-pack", ""));
        this._n(this.__aa._a("motd", "A Minecraft Server"));
        this._i(this.__aa._a("force-gamemode", false));
        this._e(this.__aa._a("player-idle-timeout", 0));
        if (this.__aa._a("difficulty", 1) < 0) {
            this.__aa._a("difficulty", (Object)0);
        } else if (this.__aa._a("difficulty", 1) > 3) {
            this.__aa._a("difficulty", (Object)3);
        }
        this.__ab = this.__aa._a("generate-structures", true);
        int n = this.__aa._a("gamemode", EnumGameType._b._a());
        this.__ac = WorldSettings._a(n);
        this._O()._a("Default game type: " + (Object)((Object)this.__ac));
        InetAddress inetAddress = null;
        if (this._x().length() > 0) {
            inetAddress = InetAddress.getByName(this._x());
        }
        if (this._L() < 0) {
            this._b(this.__aa._a("server-port", 25565));
        }
        this._O()._a("Generating keypair");
        this._a(qlgf._b());
        this._O()._a("Starting Minecraft server on " + (this._x().length() == 0 ? "*" : this._x()) + ":" + this._L());
        try {
            this.__ad = new pljc(this, inetAddress, this._L());
        }
        catch (IOException iOException) {
            this._O()._b("**** FAILED TO BIND TO PORT!");
            this._O()._a("The exception was: {0}", iOException.toString());
            this._O()._b("Perhaps a server is already running on that port?");
            return false;
        }
        if (!this._X()) {
            this._O()._b("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            this._O()._b("The server will make no attempt to authenticate usernames. Beware.");
            this._O()._b("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            this._O()._b("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
        }
        FMLCommonHandler.instance().onServerStarted();
        this._a(new cfao(this));
        long l = System.nanoTime();
        if (this._j() == null) {
            this._k(this.__aa._a("level-name", "world"));
        }
        String string = this.__aa._a("level-seed", "");
        String string2 = this.__aa._a("level-type", "DEFAULT");
        String string3 = this.__aa._a("generator-settings", "");
        long l2 = new Random().nextLong();
        if (string.length() > 0) {
            try {
                long l3 = Long.parseLong(string);
                if (l3 != 0L) {
                    l2 = l3;
                }
            }
            catch (NumberFormatException numberFormatException) {
                l2 = string.hashCode();
            }
        }
        if ((nwix2 = nwix._a(string2)) == null) {
            nwix2 = nwix._d;
        }
        this._d(this.__aa._a("max-build-height", 256));
        this._d((this.__ae() + 8) / 16 * 16);
        this._d(sajh._a(this.__ae(), 64, 256));
        this.__aa._a("max-build-height", (Object)this.__ae());
        if (!FMLCommonHandler.instance().handleServerAboutToStart(this)) {
            return false;
        }
        this._O()._a("Preparing level \"" + this._j() + "\"");
        this._a(this._j(), this._j(), l2, nwix2, string3);
        long l4 = System.nanoTime() - l;
        String string4 = String.format("%.3fs", (double)l4 / 1.0E9);
        this._O()._a("Done (" + string4 + ")! For help, type \"help\" or \"?\"");
        if (this.__aa._a("enable-query", false)) {
            this._O()._a("Starting GS4 status listener");
            this._Y = new RConThreadQuery(this);
            this._Y._a();
        }
        if (this.__aa._a("enable-rcon", false)) {
            this._O()._a("Starting remote control listener");
            this._Z = new RConThreadMain(this);
            this._Z._a();
        }
        return FMLCommonHandler.instance().handleServerStarting(this);
    }

    @Override
    public boolean _q() {
        return this.__ab;
    }

    @Override
    public EnumGameType _r() {
        return this.__ac;
    }

    @Override
    public int _s() {
        return this.__aa._a("difficulty", 1);
    }

    @Override
    public boolean _t() {
        return this.__aa._a("hardcore", false);
    }

    @Override
    public void _a(CrashReport crashReport) {
        while (this._y()) {
            this.__as();
            try {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    @Override
    public CrashReport _b(CrashReport crashReport) {
        crashReport = super._b(crashReport);
        crashReport.getCategory()._a("Is Modded", new elgq(this));
        crashReport.getCategory()._a("Type", new ywai(this));
        return crashReport;
    }

    @Override
    public void _B() {
        System.exit(0);
    }

    @Override
    public void _D() {
        super._D();
        this.__as();
    }

    @Override
    public boolean _E() {
        return this.__aa._a("allow-nether", true);
    }

    @Override
    public boolean _Q() {
        return this.__aa._a("spawn-monsters", true);
    }

    @Override
    public void _a(cfbu cfbu2) {
        cfbu2._a("whitelist_enabled", this.__at()._t());
        cfbu2._a("whitelist_count", this.__at()._o().size());
        super._a(cfbu2);
    }

    @Override
    public boolean _G() {
        return this.__aa._a("snooper-enabled", true);
    }

    public void _a(String string, ICommandSender iCommandSender) {
        this._W.add(new oyqj(string, iCommandSender));
    }

    public void __as() {
        while (!this._W.isEmpty()) {
            oyqj oyqj2 = (oyqj)this._W.remove(0);
            this._J().executeCommand(oyqj2._b, oyqj2._a);
        }
    }

    @Override
    public boolean _W() {
        return true;
    }

    public cfao __at() {
        return (cfao)super.__ag();
    }

    @Override
    public NetworkListenThread __ah() {
        return this.__ad;
    }

    @Override
    public int _a(String string, int n) {
        return this.__aa._a(string, n);
    }

    @Override
    public String _a(String string, String string2) {
        return this.__aa._a(string, string2);
    }

    public boolean _a(String string, boolean bl) {
        return this.__aa._a(string, bl);
    }

    @Override
    public void _a(String string, Object object) {
        this.__aa._a(string, object);
    }

    @Override
    public void _a() {
        this.__aa._b();
    }

    @Override
    public String _b() {
        File file = this.__aa._c();
        return file != null ? file.getAbsolutePath() : "No settings file";
    }

    @Override
    public boolean __aj() {
        return this.__ae;
    }

    @Override
    public String _a(EnumGameType enumGameType, boolean bl) {
        return "";
    }

    @Override
    public boolean __ac() {
        return this.__aa._a("enable-command-block", false);
    }

    @Override
    public int __an() {
        return this.__aa._a("spawn-protection", super.__an());
    }

    @Override
    public boolean _a(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4;
        if (world.provider._i != 0) {
            return false;
        }
        if (this.__at()._p().isEmpty()) {
            return false;
        }
        if (this.__at()._g(entityPlayer.getCommandSenderName())) {
            return false;
        }
        if (this.__an() <= 0) {
            return false;
        }
        ChunkCoordinates chunkCoordinates = world.getSpawnPoint();
        int n5 = sajh._a(n - chunkCoordinates._a);
        int n6 = Math.max(n5, n4 = sajh._a(n3 - chunkCoordinates._c));
        return n6 <= this.__an();
    }

    @Override
    public ILogAgent _O() {
        return this._X;
    }

    @Override
    public int _u() {
        return this.__aa._a("op-permission-level", 4);
    }

    @Override
    public void _e(int n) {
        super._e(n);
        this.__aa._a("player-idle-timeout", (Object)n);
        this._a();
    }

    @Override
    public ozhc __ag() {
        return this.__at();
    }
}

