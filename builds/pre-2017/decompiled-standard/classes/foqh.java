/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.DeferredBiomeDecorator;

public abstract class foqh {
    public static final foqh[] _a = new foqh[256];
    public static final foqh _b = new mcdz(0)._b(112)._a("Ocean")._b(-1.0f, 0.4f);
    public static final foqh _c = new rrsg(1)._b(9286496)._a("Plains")._a(0.8f, 0.4f);
    public static final foqh _d = new xteu(2)._b(16421912)._a("Desert")._b()._a(2.0f, 0.0f)._b(0.1f, 0.2f);
    public static final foqh _e = new zzkp(3)._b(0x606060)._a("Extreme Hills")._b(0.3f, 1.5f)._a(0.2f, 0.3f);
    public static final foqh _f = new xcdh(4)._b(353825)._a("Forest")._a(5159473)._a(0.7f, 0.8f);
    public static final foqh _g = new hdur(5)._b(747097)._a("Taiga")._a(5159473)._c()._a(0.05f, 0.8f)._b(0.1f, 0.4f);
    public static final foqh _h = new huwa(6)._b(522674)._a("Swampland")._a(9154376)._b(-0.2f, 0.1f)._a(0.8f, 0.9f);
    public static final foqh _i = new bcdo(7)._b(255)._a("River")._b(-0.5f, 0.0f);
    public static final foqh _j = new xtel(8)._b(0xFF0000)._a("Hell")._b()._a(2.0f, 0.0f);
    public static final foqh _k = new nwid(9)._b(0x8080FF)._a("Sky")._b();
    public static final foqh _l = new mcdz(10)._b(0x9090A0)._a("FrozenOcean")._c()._b(-1.0f, 0.5f)._a(0.0f, 0.5f);
    public static final foqh _m = new bcdo(11)._b(0xA0A0FF)._a("FrozenRiver")._c()._b(-0.5f, 0.0f)._a(0.0f, 0.5f);
    public static final foqh _n = new yfft(12)._b(0xFFFFFF)._a("Ice Plains")._c()._a(0.0f, 0.5f);
    public static final foqh _o = new yfft(13)._b(0xA0A0A0)._a("Ice Mountains")._c()._b(0.3f, 1.3f)._a(0.0f, 0.5f);
    public static final foqh _p = new sduo(14)._b(0xFF00FF)._a("MushroomIsland")._a(0.9f, 1.0f)._b(0.2f, 1.0f);
    public static final foqh _q = new sduo(15)._b(0xA000FF)._a("MushroomIslandShore")._a(0.9f, 1.0f)._b(-1.0f, 0.1f);
    public static final foqh _r = new yfge(16)._b(16440917)._a("Beach")._a(0.8f, 0.4f)._b(0.0f, 0.1f);
    public static final foqh _s = new xteu(17)._b(13786898)._a("DesertHills")._b()._a(2.0f, 0.0f)._b(0.3f, 0.8f);
    public static final foqh _t = new xcdh(18)._b(2250012)._a("ForestHills")._a(5159473)._a(0.7f, 0.8f)._b(0.3f, 0.7f);
    public static final foqh _u = new hdur(19)._b(1456435)._a("TaigaHills")._c()._a(5159473)._a(0.05f, 0.8f)._b(0.3f, 0.8f);
    public static final foqh _v = new zzkp(20)._b(7501978)._a("Extreme Hills Edge")._b(0.2f, 0.8f)._a(0.2f, 0.3f);
    public static final foqh _w = new xteo(21)._b(5470985)._a("Jungle")._a(5470985)._a(1.2f, 0.9f)._b(0.2f, 0.4f);
    public static final foqh _x = new xteo(22)._b(2900485)._a("JungleHills")._a(5470985)._a(1.2f, 0.9f)._b(1.8f, 0.5f);
    public String _y;
    public int _z;
    public byte _A;
    public byte _B;
    public int _C;
    public float _D;
    public float _E;
    public float _F;
    public float _G;
    public int _H;
    public qoqn _I;
    public List _J;
    public List _K;
    public List _L;
    public List _M;
    public boolean _N;
    public boolean _O;
    public final int _P;
    public dzqi _Q;
    public nfiu _R;
    public nwjr _S;
    public cfiv _T;

    public foqh(int n) {
        this(n, true);
    }

    public foqh(int n, boolean bl) {
        this._A = (byte)twgu.field_71980_u.field_71990_ca;
        this._B = (byte)twgu.field_71979_v.field_71990_ca;
        this._C = 5169201;
        this._D = 0.1f;
        this._E = 0.3f;
        this._F = 0.5f;
        this._G = 0.5f;
        this._H = 0xFFFFFF;
        this._J = new ArrayList();
        this._K = new ArrayList();
        this._L = new ArrayList();
        this._M = new ArrayList();
        this._O = true;
        this._Q = new dzqi(false);
        this._R = new nfiu(false);
        this._S = new nwjr(false);
        this._T = new cfiv();
        this._P = n;
        if (bl) {
            foqh._a[n] = this;
        }
        this._I = this._a();
        this._K.add(new yffo(EntitySheep.class, 12, 4, 4));
        this._K.add(new yffo(EntityPig.class, 10, 4, 4));
        this._K.add(new yffo(EntityChicken.class, 10, 4, 4));
        this._K.add(new yffo(EntityCow.class, 8, 4, 4));
        this._J.add(new yffo(EntitySpider.class, 10, 4, 4));
        this._J.add(new yffo(EntityZombie.class, 10, 4, 4));
        this._J.add(new yffo(EntitySkeleton.class, 10, 4, 4));
        this._J.add(new yffo(EntityCreeper.class, 10, 4, 4));
        this._J.add(new yffo(EntitySlime.class, 10, 4, 4));
        this._J.add(new yffo(EntityEnderman.class, 1, 1, 4));
        this._L.add(new yffo(EntitySquid.class, 10, 4, 4));
        this._M.add(new yffo(EntityBat.class, 10, 8, 8));
    }

    public qoqn _a() {
        return this._a(new qoqn(this));
    }

    public foqh _a(float f, float f2) {
        if (f > 0.1f && f < 0.2f) {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        this._F = f;
        this._G = f2;
        return this;
    }

    public foqh _b(float f, float f2) {
        this._D = f;
        this._E = f2;
        return this;
    }

    public foqh _b() {
        this._O = false;
        return this;
    }

    public zzpm _a(Random random) {
        return random.nextInt(10) == 0 ? this._R : this._Q;
    }

    public zzpm _b(Random random) {
        return new zinw(twgu.field_71962_X.field_71990_ca, 1);
    }

    public foqh _c() {
        this._N = true;
        return this;
    }

    public foqh _a(String string) {
        this._y = string;
        return this;
    }

    public foqh _a(int n) {
        this._C = n;
        return this;
    }

    public foqh _b(int n) {
        this._z = n;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(float f) {
        if ((f /= 3.0f) < -1.0f) {
            f = -1.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.getHSBColor(0.62222224f - f * 0.05f, 0.5f + f * 0.1f, 1.0f).getRGB();
    }

    public List _a(jxsn jxsn2) {
        return jxsn2 == jxsn._a ? this._J : (jxsn2 == jxsn._b ? this._K : (jxsn2 == jxsn._d ? this._L : (jxsn2 == jxsn._c ? this._M : null)));
    }

    public boolean _d() {
        return this._N;
    }

    public boolean _e() {
        return this._N ? false : this._O;
    }

    public boolean _f() {
        return this._G > 0.85f;
    }

    public float _g() {
        return 0.1f;
    }

    public final int _h() {
        return (int)(this._G * 65536.0f);
    }

    public final int _i() {
        return (int)(this._F * 65536.0f);
    }

    @SideOnly(value=Side.CLIENT)
    public final float _j() {
        return this._G;
    }

    public final float _k() {
        return this._F;
    }

    public void _a(ozlu ozlu2, Random random, int n, int n2) {
        this._I.func_76796_a(ozlu2, random, n, n2);
    }

    @SideOnly(value=Side.CLIENT)
    public int _l() {
        double d = sajh._a(this._k(), 0.0f, 1.0f);
        double d2 = sajh._a(this._j(), 0.0f, 1.0f);
        return this._c(gapq._a(d, d2));
    }

    @SideOnly(value=Side.CLIENT)
    public int _m() {
        double d = sajh._a(this._k(), 0.0f, 1.0f);
        double d2 = sajh._a(this._j(), 0.0f, 1.0f);
        return this._d(igvq._a(d, d2));
    }

    public qoqn _a(qoqn qoqn2) {
        return new DeferredBiomeDecorator(this, qoqn2);
    }

    public int _n() {
        BiomeEvent.GetWaterColor getWaterColor = new BiomeEvent.GetWaterColor(this, this._H);
        MinecraftForge.EVENT_BUS.post(getWaterColor);
        return getWaterColor.newColor;
    }

    public int _c(int n) {
        BiomeEvent.GetGrassColor getGrassColor = new BiomeEvent.GetGrassColor(this, n);
        MinecraftForge.EVENT_BUS.post(getGrassColor);
        return getGrassColor.newColor;
    }

    public int _d(int n) {
        BiomeEvent.GetFoliageColor getFoliageColor = new BiomeEvent.GetFoliageColor(this, n);
        MinecraftForge.EVENT_BUS.post(getFoliageColor);
        return getFoliageColor.newColor;
    }
}

