/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abs
 *  abv
 *  acp
 *  acr
 *  acu
 *  acw
 *  acx
 *  adb
 *  ade
 *  adh
 *  afe
 *  afz
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.terraingen.BiomeEvent$GetFoliageColor
 *  net.minecraftforge.event.terraingen.BiomeEvent$GetGrassColor
 *  net.minecraftforge.event.terraingen.BiomeEvent$GetWaterColor
 *  net.minecraftforge.event.terraingen.DeferredBiomeDecorator
 *  tg
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;

public abstract class acq {
    public static final acq[] a = new acq[256];
    public static final acq b = new ade(0).b(112).a("Ocean").b(-1.0f, 0.4f);
    public static final acq c = new adf(1).b(9286496).a("Plains").a(0.8f, 0.4f);
    public static final acq d = new acw(2).b(16421912).a("Desert").m().a(2.0f, 0.0f).b(0.1f, 0.2f);
    public static final acq e = new acx(3).b(0x606060).a("Extreme Hills").b(0.3f, 1.5f).a(0.2f, 0.3f);
    public static final acq f = new acz(4).b(353825).a("Forest").a(5159473).a(0.7f, 0.8f);
    public static final acq g = new adj(5).b(747097).a("Taiga").a(5159473).b().a(0.05f, 0.8f).b(0.1f, 0.4f);
    public static final acq h = new adi(6).b(522674).a("Swampland").a(9154376).b(-0.2f, 0.1f).a(0.8f, 0.9f);
    public static final acq i = new adh(7).b(255).a("River").b(-0.5f, 0.0f);
    public static final acq j = new ada(8).b(0xFF0000).a("Hell").m().a(2.0f, 0.0f);
    public static final acq k = new adk(9).b(0x8080FF).a("Sky").m();
    public static final acq l = new ade(10).b(0x9090A0).a("FrozenOcean").b().b(-1.0f, 0.5f).a(0.0f, 0.5f);
    public static final acq m = new adh(11).b(0xA0A0FF).a("FrozenRiver").b().b(-0.5f, 0.0f).a(0.0f, 0.5f);
    public static final acq n = new adb(12).b(0xFFFFFF).a("Ice Plains").b().a(0.0f, 0.5f);
    public static final acq o = new adb(13).b(0xA0A0A0).a("Ice Mountains").b().b(0.3f, 1.3f).a(0.0f, 0.5f);
    public static final acq p = new add(14).b(0xFF00FF).a("MushroomIsland").a(0.9f, 1.0f).b(0.2f, 1.0f);
    public static final acq q = new add(15).b(0xA000FF).a("MushroomIslandShore").a(0.9f, 1.0f).b(-1.0f, 0.1f);
    public static final acq r = new acp(16).b(16440917).a("Beach").a(0.8f, 0.4f).b(0.0f, 0.1f);
    public static final acq s = new acw(17).b(13786898).a("DesertHills").m().a(2.0f, 0.0f).b(0.3f, 0.8f);
    public static final acq t = new acz(18).b(2250012).a("ForestHills").a(5159473).a(0.7f, 0.8f).b(0.3f, 0.7f);
    public static final acq u = new adj(19).b(1456435).a("TaigaHills").b().a(5159473).a(0.05f, 0.8f).b(0.3f, 0.8f);
    public static final acq v = new acx(20).b(7501978).a("Extreme Hills Edge").b(0.2f, 0.8f).a(0.2f, 0.3f);
    public static final acq w = new adc(21).b(5470985).a("Jungle").a(5470985).a(1.2f, 0.9f).b(0.2f, 0.4f);
    public static final acq x = new adc(22).b(2900485).a("JungleHills").a(5470985).a(1.2f, 0.9f).b(1.8f, 0.5f);
    public String y;
    public int z;
    public byte A;
    public byte B;
    public int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public acu I;
    protected List J;
    protected List K;
    protected List L;
    protected List M;
    private boolean S;
    private boolean T;
    public final int N;
    protected aga O;
    protected aew P;
    protected aex Q;
    protected afy R;

    public acq(int par1) {
        this(par1, true);
    }

    public acq(int par1, boolean register) {
        this.A = (byte)aqz.z.cF;
        this.B = (byte)aqz.A.cF;
        this.C = 5169201;
        this.D = 0.1f;
        this.E = 0.3f;
        this.F = 0.5f;
        this.G = 0.5f;
        this.H = 0xFFFFFF;
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.T = true;
        this.O = new aga(false);
        this.P = new aew(false);
        this.Q = new aex(false);
        this.R = new afy();
        this.N = par1;
        if (register) {
            acq.a[par1] = this;
        }
        this.I = this.a();
        this.K.add(new acr(rz.class, 12, 4, 4));
        this.K.add(new acr(ry.class, 10, 4, 4));
        this.K.add(new acr(rq.class, 10, 4, 4));
        this.K.add(new acr(rr.class, 8, 4, 4));
        this.J.add(new acr(tt.class, 10, 4, 4));
        this.J.add(new acr(tw.class, 10, 4, 4));
        this.J.add(new acr(tr.class, 10, 4, 4));
        this.J.add(new acr(tf.class, 10, 4, 4));
        this.J.add(new acr(ts.class, 10, 4, 4));
        this.J.add(new acr(tg.class, 1, 1, 4));
        this.L.add(new acr(sc.class, 10, 4, 4));
        this.M.add(new acr(ro.class, 10, 8, 8));
    }

    public acu a() {
        return this.getModdedBiomeDecorator(new acu(this));
    }

    public acq a(float par1, float par2) {
        if (par1 > 0.1f && par1 < 0.2f) {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        this.F = par1;
        this.G = par2;
        return this;
    }

    public acq b(float par1, float par2) {
        this.D = par1;
        this.E = par2;
        return this;
    }

    public acq m() {
        this.T = false;
        return this;
    }

    public afe a(Random par1Random) {
        return par1Random.nextInt(10) == 0 ? this.P : this.O;
    }

    public afe b(Random par1Random) {
        return new afz(aqz.ac.cF, 1);
    }

    public acq b() {
        this.S = true;
        return this;
    }

    public acq a(String par1Str) {
        this.y = par1Str;
        return this;
    }

    public acq a(int par1) {
        this.C = par1;
        return this;
    }

    public acq b(int par1) {
        this.z = par1;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int a(float par1) {
        if ((par1 /= 3.0f) < -1.0f) {
            par1 = -1.0f;
        }
        if (par1 > 1.0f) {
            par1 = 1.0f;
        }
        return Color.getHSBColor(0.62222224f - par1 * 0.05f, 0.5f + par1 * 0.1f, 1.0f).getRGB();
    }

    public List a(oh par1EnumCreatureType) {
        return par1EnumCreatureType == oh.a ? this.J : (par1EnumCreatureType == oh.b ? this.K : (par1EnumCreatureType == oh.d ? this.L : (par1EnumCreatureType == oh.c ? this.M : null)));
    }

    public boolean c() {
        return this.S;
    }

    public boolean d() {
        return this.S ? false : this.T;
    }

    public boolean e() {
        return this.G > 0.85f;
    }

    public float f() {
        return 0.1f;
    }

    public final int g() {
        return (int)(this.G * 65536.0f);
    }

    public final int h() {
        return (int)(this.F * 65536.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public final float i() {
        return this.G;
    }

    public final float j() {
        return this.F;
    }

    public void a(abw par1World, Random par2Random, int par3, int par4) {
        this.I.a(par1World, par2Random, par3, par4);
    }

    @SideOnly(value=Side.CLIENT)
    public int k() {
        double d0 = ls.a(this.j(), 0.0f, 1.0f);
        double d1 = ls.a(this.i(), 0.0f, 1.0f);
        return this.getModdedBiomeGrassColor(abv.a((double)d0, (double)d1));
    }

    @SideOnly(value=Side.CLIENT)
    public int l() {
        double d0 = ls.a(this.j(), 0.0f, 1.0f);
        double d1 = ls.a(this.i(), 0.0f, 1.0f);
        return this.getModdedBiomeFoliageColor(abs.a((double)d0, (double)d1));
    }

    public acu getModdedBiomeDecorator(acu original) {
        return new DeferredBiomeDecorator(this, original);
    }

    public int getWaterColorMultiplier() {
        BiomeEvent.GetWaterColor event = new BiomeEvent.GetWaterColor(this, this.H);
        MinecraftForge.EVENT_BUS.post((Event)event);
        return event.newColor;
    }

    public int getModdedBiomeGrassColor(int original) {
        BiomeEvent.GetGrassColor event = new BiomeEvent.GetGrassColor(this, original);
        MinecraftForge.EVENT_BUS.post((Event)event);
        return event.newColor;
    }

    public int getModdedBiomeFoliageColor(int original) {
        BiomeEvent.GetFoliageColor event = new BiomeEvent.GetFoliageColor(this, original);
        MinecraftForge.EVENT_BUS.post((Event)event);
        return event.newColor;
    }
}

