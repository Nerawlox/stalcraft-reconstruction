/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.logging.ILogAgent;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.server.ConvertingProgressUpdate;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;

public abstract class MinecraftServer
implements Runnable,
ICommandSender,
ujun {
    public static MinecraftServer _a;
    public final ISaveFormat _b;
    public final cfbu _c = new cfbu("server", this, MinecraftServer.__aq());
    public final File _d;
    public final List _e = new ArrayList();
    public final zyqp _f;
    public final fokl _g = new fokl();
    public String _h;
    public int _i = -1;
    public WorldServer[] _j = new WorldServer[0];
    public ozhc _k;
    public boolean _l = true;
    public boolean _m;
    public int _n;
    public Proxy _o;
    public String _p;
    public int _q;
    public boolean _r;
    public boolean _s;
    public boolean _t;
    public boolean _u;
    public boolean _v;
    public String _w;
    public int _x;
    public int _y = 0;
    public long _z;
    public long _A;
    public long _B;
    public long _C;
    public final long[] _D;
    public final long[] _E;
    public final long[] _F;
    public final long[] _G;
    public final long[] _H;
    public Hashtable<Integer, long[]> _I = new Hashtable();
    public KeyPair _J;
    public String _K;
    public String _L;
    @SideOnly(value=Side.CLIENT)
    public String _M;
    public boolean _N;
    public boolean _O;
    public boolean _P;
    public String _Q = "";
    public boolean _R;
    public long _S;
    public String _T;
    public boolean _U;
    public boolean _V;

    public MinecraftServer(File file) {
        this._o = Proxy.NO_PROXY;
        this._D = new long[100];
        this._E = new long[100];
        this._F = new long[100];
        this._G = new long[100];
        this._H = new long[100];
        _a = this;
        this._d = file;
        this._f = new jjbh();
        this._b = new AnvilSaveConverter(file);
        this._m();
    }

    public void _m() {
        qnxl._a();
    }

    public abstract boolean _n() throws IOException;

    public void _f(String string) {
        if (this._S()._a(string)) {
            this._O()._a("Converting map!");
            this._g("menu.convertingLevel");
            this._S()._a(string, new ConvertingProgressUpdate(this));
        }
    }

    public synchronized void _g(String string) {
        this._T = string;
    }

    @SideOnly(value=Side.CLIENT)
    public synchronized String _o() {
        return this._T;
    }

    public void _a(String string, String string2, long l, nwix nwix2, String string3) {
        WorldSettings worldSettings;
        this._f(string);
        this._g("menu.loadingLevel");
        ISaveHandler iSaveHandler = this._b._a(string, true);
        WorldInfo worldInfo = iSaveHandler.loadWorldInfo();
        if (worldInfo == null) {
            worldSettings = new WorldSettings(l, this._r(), this._q(), this._t(), nwix2);
            worldSettings._a(string3);
        } else {
            worldSettings = new WorldSettings(worldInfo);
        }
        if (this._O) {
            worldSettings._a();
        }
        WorldServer worldServer = this._R() ? new zily(this, iSaveHandler, string2, 0, this._g, this._O()) : new WorldServer(this, iSaveHandler, string2, 0, worldSettings, this._g, this._O());
        Integer[] integerArray = DimensionManager.getStaticDimensionIDs();
        int n = integerArray.length;
        for (int i = 0; i < n; ++i) {
            int n2 = integerArray[i];
            WorldServer worldServer2 = n2 == 0 ? worldServer : new rasa(this, iSaveHandler, string2, n2, worldSettings, worldServer, this._g, this._O());
            worldServer2.addWorldAccess(new WorldManager(this, worldServer2));
            if (!this._N()) {
                worldServer2.getWorldInfo()._a(this._r());
            }
            this._k._a(this._j);
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Load(worldServer2));
        }
        this._k._a(new WorldServer[]{worldServer});
        this._c(this._s());
        this._p();
    }

    public void _p() {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        int n = 0;
        this._g("menu.generatingTerrain");
        int n2 = 0;
        this._O()._a("Preparing start region for level " + n2);
        WorldServer worldServer = this._j[n2];
        ChunkCoordinates chunkCoordinates = worldServer.getSpawnPoint();
        long l = MinecraftServer.__aq();
        for (int i = -192; i <= 192 && this._y(); i += 16) {
            for (int j = -192; j <= 192 && this._y(); j += 16) {
                long l2 = MinecraftServer.__aq();
                if (l2 - l > 1000L) {
                    this._b("Preparing spawn area", n * 100 / 625);
                    l = l2;
                }
                ++n;
                worldServer.theChunkProviderServer._a(chunkCoordinates._a + i >> 4, chunkCoordinates._c + j >> 4);
            }
        }
        this._v();
    }

    public abstract boolean _q();

    public abstract EnumGameType _r();

    public abstract int _s();

    public abstract boolean _t();

    public abstract int _u();

    public void _b(String string, int n) {
        this._p = string;
        this._q = n;
        this._O()._a(string + ": " + n + "%");
    }

    public void _v() {
        this._p = null;
        this._q = 0;
    }

    public void _a(boolean bl) {
        if (!this._P) {
            WorldServer[] worldServerArray = this._j;
            if (worldServerArray == null) {
                return;
            }
            for (WorldServer worldServer : worldServerArray) {
                if (worldServer == null) continue;
                if (!bl) {
                    this._O()._a("Saving chunks for level '" + worldServer.getWorldInfo()._k() + "'/" + worldServer.provider._l());
                }
                try {
                    worldServer.saveAllChunks(true, null);
                }
                catch (xcad xcad2) {
                    this._O()._b(xcad2.getMessage());
                }
            }
        }
    }

    public void _w() {
        if (!this._P) {
            WorldServer[] worldServerArray;
            this._O()._a("Stopping server");
            if (this.__ah() != null) {
                this.__ah()._a();
            }
            if (this._k != null) {
                this._O()._a("Saving players");
                this._k._n();
                this._k._v();
            }
            this._O()._a("Saving worlds");
            this._a(false);
            for (int i = 0; i < this._j.length; ++i) {
                WorldServer[] worldServerArray2 = this._j[i];
                MinecraftForge.EVENT_BUS.post(new WorldEvent.Unload((World)worldServerArray2));
                worldServerArray2.flush();
            }
            for (WorldServer worldServer : worldServerArray = this._j) {
                DimensionManager.setWorld(worldServer.provider._i, null);
            }
            if (this._c != null && this._c._f()) {
                this._c._g();
            }
        }
    }

    public String _x() {
        return this._h;
    }

    public void _h(String string) {
        this._h = string;
    }

    public boolean _y() {
        return this._l;
    }

    public void _z() {
        this._l = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        long l;
        long l2;
        try {
            if (!this._n()) {
                this._a((CrashReport)null);
                return;
            }
            FMLCommonHandler.instance().handleServerStarted();
            l2 = MinecraftServer.__aq();
            FMLCommonHandler.instance().onWorldLoadTick(this._j);
            l = 0L;
        }
        catch (Throwable throwable) {
            if (FMLCommonHandler.instance().shouldServerBeKilledQuietly()) {
                return;
            }
            throwable.printStackTrace();
            this._O()._b("Encountered an unexpected exception " + throwable.getClass().getSimpleName(), throwable);
            CrashReport crashReport = null;
            crashReport = throwable instanceof turb ? this._b(((turb)throwable)._a()) : this._b(new CrashReport("Exception in server tick loop", throwable));
            File file = new File(new File(this._A(), "crash-reports"), "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-server.txt");
            if (crashReport.saveToFile(file, this._O())) {
                this._O()._c("This crash report has been saved to: " + file.getAbsolutePath());
            } else {
                this._O()._c("We were unable to save this crash report to disk.");
            }
            this._a(crashReport);
            return;
        }
        finally {
            try {
                if (FMLCommonHandler.instance().shouldServerBeKilledQuietly()) {
                    return;
                }
                this._w();
                this._m = true;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            finally {
                FMLCommonHandler.instance().handleServerStopped();
                this._m = true;
                this._B();
            }
        }
        while (true) {
            if (!this._l) {
                FMLCommonHandler.instance().handleServerStopping();
                return;
            }
            long l3 = MinecraftServer.__aq();
            long l4 = l3 - l2;
            if (l4 > 2000L && l2 - this._S >= 15000L) {
                this._O()._b("Can't keep up! Did the system time change, or is the server overloaded?");
                l4 = 2000L;
                this._S = l2;
            }
            if (l4 < 0L) {
                this._O()._b("Time ran backwards! Did the system time change?");
                l4 = 0L;
            }
            l += l4;
            l2 = l3;
            if (this._j[0].areAllPlayersAsleep()) {
                this._C();
                l = 0L;
            } else {
                while (l > 50L) {
                    l -= 50L;
                    this._C();
                }
            }
            Thread.sleep(1L);
            this._R = true;
        }
    }

    public File _A() {
        return new File(".");
    }

    public void _a(CrashReport crashReport) {
    }

    public void _B() {
    }

    public void _C() {
        FMLCommonHandler.instance().rescheduleTicks(Side.SERVER);
        long l = System.nanoTime();
        AxisAlignedBB._a()._a();
        FMLCommonHandler.instance().onPreServerTick();
        ++this._n;
        if (this._U) {
            this._U = false;
            this._g._c = true;
            this._g._a();
        }
        this._g._a("root");
        this._D();
        if (this._n % 900 == 0) {
            this._g._a("save");
            this._k._n();
            this._a(true);
            this._g._b();
        }
        this._g._a("tallying");
        this._H[this._n % 100] = System.nanoTime() - l;
        this._D[this._n % 100] = Packet.sentID - this._z;
        this._z = Packet.sentID;
        this._E[this._n % 100] = Packet.sentSize - this._A;
        this._A = Packet.sentSize;
        this._F[this._n % 100] = Packet.receivedID - this._B;
        this._B = Packet.receivedID;
        this._G[this._n % 100] = Packet.receivedSize - this._C;
        this._C = Packet.receivedSize;
        this._g._b();
        this._g._a("snooper");
        if (!this._c._f() && this._n > 100) {
            this._c._a();
        }
        if (this._n % 6000 == 0) {
            this._c._d();
        }
        this._g._b();
        this._g._b();
        FMLCommonHandler.instance().onPostServerTick();
    }

    public void _D() {
        this._g._a("levels");
        Integer[] integerArray = DimensionManager.getIDs(this._n % 200 == 0);
        for (int i = 0; i < integerArray.length; ++i) {
            int n = integerArray[i];
            long l = System.nanoTime();
            if (n == 0 || this._E()) {
                WorldServer worldServer = DimensionManager.getWorld(n);
                this._g._a(worldServer.getWorldInfo()._k());
                this._g._a("pools");
                worldServer.getWorldVec3Pool()._a();
                this._g._b();
                if (this._n % 20 == 0) {
                    this._g._a("timeSync");
                    this._k._a(new rrld(worldServer.getTotalWorldTime(), worldServer.getWorldTime(), worldServer.getGameRules()._b("doDaylightCycle")), worldServer.provider._i);
                    this._g._b();
                }
                this._g._a("tick");
                FMLCommonHandler.instance().onPreWorldTick(worldServer);
                try {
                    worldServer.tick();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception ticking world");
                    worldServer.addWorldInfoToCrashReport(crashReport);
                    throw new turb(crashReport);
                }
                try {
                    worldServer.updateEntities();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception ticking world entities");
                    worldServer.addWorldInfoToCrashReport(crashReport);
                    throw new turb(crashReport);
                }
                FMLCommonHandler.instance().onPostWorldTick(worldServer);
                this._g._b();
                this._g._a("tracker");
                worldServer.getEntityTracker()._a();
                this._g._b();
                this._g._b();
            }
            this._I.get((Object)Integer.valueOf((int)n))[this._n % 100] = System.nanoTime() - l;
        }
        this._g._c("dim_unloading");
        DimensionManager.unloadWorlds(this._I);
        this._g._c("connection");
        this.__ah()._b();
        this._g._c("players");
        this._k._i();
        this._g._c("tickables");
        for (int i = 0; i < this._e.size(); ++i) {
            ((IUpdatePlayerListBox)this._e.get(i))._a();
        }
        this._g._b();
    }

    public boolean _E() {
        return true;
    }

    public void _F() {
        new vmwi(this, "Server thread").start();
    }

    public File _i(String string) {
        return new File(this._A(), string);
    }

    public void _b(String string) {
        this._O()._a(string);
    }

    public void _c(String string) {
        this._O()._b(string);
    }

    public WorldServer _a(int n) {
        WorldServer worldServer = DimensionManager.getWorld(n);
        if (worldServer == null) {
            DimensionManager.initDimension(n);
            worldServer = DimensionManager.getWorld(n);
        }
        return worldServer;
    }

    public String _c() {
        return this._h;
    }

    public int _d() {
        return this._i;
    }

    public String _e() {
        return this._w;
    }

    public String _f() {
        return "1.6.4";
    }

    public int _g() {
        return this._k._q();
    }

    public int _h() {
        return this._k._r();
    }

    public String[] _i() {
        return this._k._k();
    }

    public String _k() {
        return "";
    }

    public String _a(String string) {
        RConConsoleSource._a._a();
        this._f.executeCommand(RConConsoleSource._a, string);
        return RConConsoleSource._a._b();
    }

    public boolean _l() {
        return false;
    }

    public void _d(String string) {
        this._O()._c(string);
    }

    public void _e(String string) {
        if (this._l()) {
            this._O()._a(string);
        }
    }

    public String _H() {
        return FMLCommonHandler.instance().getModName();
    }

    public CrashReport _b(CrashReport crashReport) {
        crashReport.getCategory()._a("Profiler Position", new jjtx(this));
        if (this._j != null && this._j.length > 0 && this._j[0] != null) {
            crashReport.getCategory()._a("Vec3 Pool Size", new elgy(this));
        }
        if (this._k != null) {
            crashReport.getCategory()._a("Player Count", new grmg(this));
        }
        return crashReport;
    }

    public List _a(ICommandSender iCommandSender, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string.startsWith("/")) {
            boolean bl = !(string = string.substring(1)).contains(" ");
            List list2 = this._f.getPossibleCommands(iCommandSender, string);
            if (list2 != null) {
                for (String string2 : list2) {
                    if (bl) {
                        arrayList.add("/" + string2);
                        continue;
                    }
                    arrayList.add(string2);
                }
            }
            return arrayList;
        }
        String[] stringArray = string.split(" ", -1);
        String string3 = stringArray[stringArray.length - 1];
        for (String string4 : this._k._k()) {
            if (!CommandBase.doesStringStartWith(string3, string4)) continue;
            arrayList.add(string4);
        }
        return arrayList;
    }

    public static MinecraftServer _I() {
        return _a;
    }

    @Override
    public String getCommandSenderName() {
        return "Server";
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
        this._O()._a(chatMessageComponent.toString());
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return true;
    }

    public zyqp _J() {
        return this._f;
    }

    public KeyPair _K() {
        return this._J;
    }

    public int _L() {
        return this._i;
    }

    public void _b(int n) {
        this._i = n;
    }

    public String _M() {
        return this._K;
    }

    public void _j(String string) {
        this._K = string;
    }

    public boolean _N() {
        return this._K != null;
    }

    public String _j() {
        return this._L;
    }

    public void _k(String string) {
        this._L = string;
    }

    @SideOnly(value=Side.CLIENT)
    public void _l(String string) {
        this._M = string;
    }

    @SideOnly(value=Side.CLIENT)
    public String _P() {
        return this._M;
    }

    public void _a(KeyPair keyPair) {
        this._J = keyPair;
    }

    public void _c(int n) {
        for (int i = 0; i < this._j.length; ++i) {
            WorldServer worldServer = this._j[i];
            if (worldServer == null) continue;
            if (worldServer.getWorldInfo()._t()) {
                worldServer.difficultySetting = 3;
                worldServer.setAllowedSpawnTypes(true, true);
                continue;
            }
            if (this._N()) {
                worldServer.difficultySetting = n;
                worldServer.setAllowedSpawnTypes(worldServer.difficultySetting > 0, true);
                continue;
            }
            worldServer.difficultySetting = n;
            worldServer.setAllowedSpawnTypes(this._Q(), this._s);
        }
    }

    public boolean _Q() {
        return true;
    }

    public boolean _R() {
        return this._N;
    }

    public void _b(boolean bl) {
        this._N = bl;
    }

    public void _c(boolean bl) {
        this._O = bl;
    }

    public ISaveFormat _S() {
        return this._b;
    }

    public void _T() {
        this._P = true;
        this._S()._c();
        for (int i = 0; i < this._j.length; ++i) {
            WorldServer worldServer = this._j[i];
            if (worldServer == null) continue;
            MinecraftForge.EVENT_BUS.post(new WorldEvent.Unload(worldServer));
            worldServer.flush();
        }
        this._S()._d(this._j[0].getSaveHandler().getWorldDirectoryName());
        this._z();
    }

    public String _U() {
        return this._Q;
    }

    public void _m(String string) {
        this._Q = string;
    }

    @Override
    public void _a(cfbu cfbu2) {
        cfbu2._a("whitelist_enabled", false);
        cfbu2._a("whitelist_count", 0);
        cfbu2._a("players_current", this._g());
        cfbu2._a("players_max", this._h());
        cfbu2._a("players_seen", this._k._s().length);
        cfbu2._a("uses_auth", this._r);
        cfbu2._a("gui_state", this.__aj() ? "enabled" : "disabled");
        cfbu2._a("run_time", (MinecraftServer.__aq() - cfbu2._i()) / 60L * 1000L);
        cfbu2._a("avg_tick_ms", (int)(sajh._a(this._H) * 1.0E-6));
        cfbu2._a("avg_sent_packet_count", (int)sajh._a(this._D));
        cfbu2._a("avg_sent_packet_size", (int)sajh._a(this._E));
        cfbu2._a("avg_rec_packet_count", (int)sajh._a(this._F));
        cfbu2._a("avg_rec_packet_size", (int)sajh._a(this._G));
        int n = 0;
        for (int i = 0; i < this._j.length; ++i) {
            if (this._j[i] == null) continue;
            WorldServer worldServer = this._j[i];
            WorldInfo worldInfo = worldServer.getWorldInfo();
            cfbu2._a("world[" + n + "][dimension]", worldServer.provider._i);
            cfbu2._a("world[" + n + "][mode]", (Object)worldInfo._r());
            cfbu2._a("world[" + n + "][difficulty]", worldServer.difficultySetting);
            cfbu2._a("world[" + n + "][hardcore]", worldInfo._t());
            cfbu2._a("world[" + n + "][generator_name]", worldInfo._u()._a());
            cfbu2._a("world[" + n + "][generator_version]", worldInfo._u()._c());
            cfbu2._a("world[" + n + "][height]", this._x);
            cfbu2._a("world[" + n + "][chunks_loaded]", worldServer.getChunkProvider()._e());
            ++n;
        }
        cfbu2._a("worlds", n);
    }

    @Override
    public void _b(cfbu cfbu2) {
        cfbu2._a("singleplayer", this._N());
        cfbu2._a("server_brand", this._H());
        cfbu2._a("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        cfbu2._a("dedicated", this._W());
    }

    @Override
    public boolean _G() {
        return true;
    }

    public int _V() {
        return 16;
    }

    public abstract boolean _W();

    public boolean _X() {
        return this._r;
    }

    public void _d(boolean bl) {
        this._r = bl;
    }

    public boolean _Y() {
        return this._s;
    }

    public void _e(boolean bl) {
        this._s = bl;
    }

    public boolean _Z() {
        return this._t;
    }

    public void _f(boolean bl) {
        this._t = bl;
    }

    public boolean __aa() {
        return this._u;
    }

    public void _g(boolean bl) {
        this._u = bl;
    }

    public boolean __ab() {
        return this._v;
    }

    public void _h(boolean bl) {
        this._v = bl;
    }

    public abstract boolean __ac();

    public String __ad() {
        return this._w;
    }

    public void _n(String string) {
        this._w = string;
    }

    public int __ae() {
        return this._x;
    }

    public void _d(int n) {
        this._x = n;
    }

    public boolean __af() {
        return this._m;
    }

    public ozhc __ag() {
        return this._k;
    }

    public void _a(ozhc ozhc2) {
        this._k = ozhc2;
    }

    public void _a(EnumGameType enumGameType) {
        for (int i = 0; i < this._j.length; ++i) {
            MinecraftServer._I()._j[i].getWorldInfo()._a(enumGameType);
        }
    }

    public abstract NetworkListenThread __ah();

    @SideOnly(value=Side.CLIENT)
    public boolean __ai() {
        return this._R;
    }

    public boolean __aj() {
        return false;
    }

    public abstract String _a(EnumGameType var1, boolean var2);

    public int __ak() {
        return this._n;
    }

    public void __al() {
        this._U = true;
    }

    @SideOnly(value=Side.CLIENT)
    public cfbu __am() {
        return this._c;
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(0, 0, 0);
    }

    @Override
    public World getEntityWorld() {
        return this._j[0];
    }

    public int __an() {
        return 16;
    }

    public boolean _a(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public abstract ILogAgent _O();

    public void _i(boolean bl) {
        this._V = bl;
    }

    public boolean __ao() {
        return this._V;
    }

    public Proxy __ap() {
        return this._o;
    }

    public static long __aq() {
        return System.currentTimeMillis();
    }

    public int __ar() {
        return this._y;
    }

    public void _e(int n) {
        this._y = n;
    }

    public static ozhc _a(MinecraftServer minecraftServer) {
        return minecraftServer._k;
    }
}

