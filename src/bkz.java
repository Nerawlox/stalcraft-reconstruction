/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acb
 *  acd
 *  acg
 *  amc
 *  bky
 *  bla
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  hn
 *  jj
 *  jl
 *  jo
 *  kd
 *  lc
 *  lg
 *  lp
 *  mv
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.DimensionManager
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.world.WorldEvent$Load
 */
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.world.WorldEvent;

@SideOnly(value=Side.CLIENT)
public class bkz
extends MinecraftServer {
    private final atv l;
    private final acd m;
    private final lp n;
    private blc o;
    private boolean p;
    private boolean q;
    private blh r;

    public bkz(atv par1Minecraft, String par2Str, String par3Str, acd par4WorldSettings) {
        super(new File(par1Minecraft.x, "saves"));
        this.n = new lc("Minecraft-Server", " [SERVER]", new File(par1Minecraft.x, "output-server.log").getAbsolutePath());
        this.j(par1Minecraft.H().a());
        this.k(par2Str);
        this.l(par3Str);
        this.b(par1Minecraft.p());
        this.c(par4WorldSettings.c());
        this.d(256);
        this.a((hn)new bky(this));
        this.l = par1Minecraft;
        this.c = par1Minecraft.I();
        this.m = par4WorldSettings;
        try {
            this.o = new blc(this);
        }
        catch (IOException ioexception) {
            throw new Error();
        }
    }

    protected void a(String par1Str, String par2Str, long par3, acg par5WorldType, String par6Str) {
        this.a(par1Str);
        amc isavehandler = this.P().a(par1Str, true);
        Object overWorld = this.O() ? new jj((MinecraftServer)this, isavehandler, par2Str, 0, this.a, this.an()) : new js(this, isavehandler, par2Str, 0, this.m, this.a, this.an());
        Integer[] integerArray = DimensionManager.getStaticDimensionIDs();
        int n = integerArray.length;
        for (int k = 0; k < n; ++k) {
            int dim = integerArray[k];
            Object world = dim == 0 ? overWorld : new jl((MinecraftServer)this, isavehandler, par2Str, dim, this.m, (js)overWorld, this.a, this.an());
            ((abw)world).a((acb)new jo((MinecraftServer)this, (js)world));
            if (!this.K()) {
                ((abw)world).N().a(this.h());
            }
            MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.Load((abw)world));
        }
        this.af().a(new js[]{overWorld});
        this.c(this.i());
        this.f();
    }

    protected boolean d() throws IOException {
        this.n.a("Starting integrated minecraft server version 1.6.4");
        this.d(false);
        this.e(true);
        this.f(true);
        this.g(true);
        this.h(true);
        this.n.a("Generating keypair");
        this.a(lg.b());
        if (!FMLCommonHandler.instance().handleServerAboutToStart((MinecraftServer)this)) {
            return false;
        }
        this.a(this.L(), this.M(), this.m.d(), this.m.h(), this.m.j());
        this.n(this.J() + " - " + this.b[0].N().k());
        return FMLCommonHandler.instance().handleServerStarting((MinecraftServer)this);
    }

    public void s() {
        boolean flag = this.p;
        this.p = this.o.f();
        if (!flag && this.p) {
            this.n.a("Saving and pausing game...");
            this.af().g();
            this.a(false);
        }
        if (!this.p) {
            super.s();
        }
    }

    public boolean g() {
        return false;
    }

    public ace h() {
        return this.m.e();
    }

    public int i() {
        return this.l.u.Y;
    }

    public boolean j() {
        return this.m.f();
    }

    protected File q() {
        return this.l.x;
    }

    public boolean V() {
        return false;
    }

    public blc a() {
        return this.o;
    }

    protected void a(b par1CrashReport) {
        this.l.a(par1CrashReport);
    }

    public b b(b par1CrashReport) {
        par1CrashReport = super.b(par1CrashReport);
        par1CrashReport.g().a("Type", (Callable)new bla(this));
        par1CrashReport.g().a("Is Modded", new blb(this));
        return par1CrashReport;
    }

    public void a(mv par1PlayerUsageSnooper) {
        super.a(par1PlayerUsageSnooper);
        par1PlayerUsageSnooper.a("snooper_partner", (Object)this.l.E().f());
    }

    public boolean T() {
        return atv.w().T();
    }

    public String a(ace par1EnumGameType, boolean par2) {
        try {
            String s2 = this.o.c();
            this.an().a("Started on " + s2);
            this.q = true;
            this.r = new blh(this.ac(), s2);
            this.r.start();
            this.af().a(par1EnumGameType);
            this.af().b(par2);
            return s2;
        }
        catch (IOException ioexception) {
            return null;
        }
    }

    public lp an() {
        return this.n;
    }

    public void m() {
        super.m();
        if (this.r != null) {
            this.r.interrupt();
            this.r = null;
        }
    }

    public void p() {
        super.p();
        if (this.r != null) {
            this.r.interrupt();
            this.r = null;
        }
    }

    public boolean c() {
        return this.q;
    }

    public void a(ace par1EnumGameType) {
        this.af().a(par1EnumGameType);
    }

    public boolean ab() {
        return true;
    }

    public int k() {
        return 4;
    }

    public kd ag() {
        return this.a();
    }
}

