/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.anomaly.zwat;
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.smart.moving.ClimbGap;
import net.smart.moving.FeetClimbing;
import net.smart.moving.HandsClimbing;
import net.smart.moving.Orientation;
import net.smart.moving.SmartMovingSelf;
import net.smart.moving.config.SmartMovingAnticheatConfig;
import net.smart.utilities.Install;
import net.smart.utilities.Interface;
import net.smart.utilities.Reflect;
import net.smart.utilities.Utilities;

public class tvcu {
    public static int _a = 10;
    public static int _b = 20;
    private static SmartMovingAnticheatConfig __aV = SmartMovingAnticheatConfig.instance;
    public boolean _c;
    public boolean _d;
    public boolean _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public boolean _m;
    public boolean _n;
    public boolean _o;
    public boolean _p;
    public boolean _q;
    public boolean _r;
    public boolean _s;
    public boolean _t;
    public boolean _u;
    public boolean _v;
    public int _w;
    public int _x;
    public int _y;
    public float _z;
    boolean _A = false;
    int _B;
    private int __aW;
    private float __aX;
    public boolean _C;
    public boolean _D;
    public boolean _E;
    public boolean _F;
    public boolean _G;
    public boolean _H;
    public boolean _I;
    public boolean _J;
    public boolean _K;
    public boolean _L;
    public boolean _M;
    public boolean _N;
    public boolean _O;
    public boolean _P;
    public boolean _Q;
    public boolean _R;
    public float _S;
    public boolean _T;
    public boolean _U;
    public boolean _V;
    public boolean _W;
    public boolean _X;
    public boolean _Y;
    public boolean _Z;
    public boolean __aa;
    public int __ab;
    public int __ac;
    public int __ad;
    public int __ae;
    public int __af;
    public float __ag = 0.0f;
    public float __ah;
    public float __ai;
    public boolean __aj;
    public float __ak;
    public float __al;
    public float __am = Float.NaN;
    public float __an = Float.NaN;
    public float __ao;
    public float __ap;
    public float __aq = Float.MAX_VALUE;
    public float __ar = Float.MAX_VALUE;
    public double __as = 0.0;
    public double __at = 0.0;
    public float __au = -2.0f;
    private double __aY;
    private double __aZ;
    private double __ba;
    private float __bb;
    private float __bc;
    boolean __av;
    boolean __aw;
    private float __bd = -1.0f;
    private boolean __be;
    private double __bf;
    private double __bg;
    public double __ax;
    public double __ay;
    public double __az;
    private float __bh;
    private float __bi;
    public boolean __aA;
    public boolean __aB;
    public boolean __aC;
    public boolean __aD;
    private boolean __bj;
    private boolean __bk;
    private int __bl;
    private boolean __bm;
    private boolean __bn;
    private boolean __bo;
    private boolean __bp;
    private boolean __bq;
    private int __br;
    private int __bs;
    private int __bt;
    private int __bu;
    private int __bv;
    private int __bw = 0;
    public float __aE = 0.0f;
    private boolean __bx = false;
    private boolean __by = false;
    private boolean __bz;
    public int __aF = 0;
    public int __aG = 0;
    public final kjui __aH = new kjui();
    public final kjui __aI = new kjui();
    public final kjui __aJ = new kjui();
    public final kjui __aK = new kjui();
    public final kjui __aL = new kjui();
    public final kjui __aM = new kjui();
    public final kjui __aN = new kjui();
    public final kjui __aO = new kjui();
    public final kjui __aP = new kjui();
    public boolean __aQ = false;
    private static ClimbGap __bA = new ClimbGap();
    private static ClimbGap __bB = new ClimbGap();
    private static HandsClimbing[] __bC = new HandsClimbing[1];
    private static FeetClimbing[] __bD = new FeetClimbing[1];
    public static final Field __aR = Reflect.GetField(ModifiableAttributeInstance.class, Install.ModifiableAttributeInstance_attributeValue, false);
    public long __aS = 0L;
    public float __aT = 0.0f;
    public final jyfy __aU;
    private final EntityPlayer __bE;
    private float __bF;
    private float __bG;
    private float __bH;
    private int __bI;
    private long __bJ = -1L;

    public tvcu(EntityPlayer entityPlayer) {
        this.__aU = new jyfy(entityPlayer);
        this.__bE = entityPlayer;
    }

    public void _a(DataOutput dataOutput) throws IOException {
        this.__aU._a(dataOutput);
        dataOutput.writeBoolean(this._c);
        dataOutput.writeBoolean(this._d);
        dataOutput.writeBoolean(this._e);
        dataOutput.writeBoolean(this._f);
        dataOutput.writeBoolean(this._g);
        dataOutput.writeBoolean(this._h);
        dataOutput.writeBoolean(this._i);
        dataOutput.writeBoolean(this._j);
        dataOutput.writeBoolean(this._k);
        dataOutput.writeBoolean(this._l);
        dataOutput.writeBoolean(this._m);
        dataOutput.writeBoolean(this._n);
        dataOutput.writeBoolean(this._o);
        dataOutput.writeBoolean(this._p);
        dataOutput.writeBoolean(this._q);
        dataOutput.writeBoolean(this._r);
        dataOutput.writeBoolean(this._s);
        dataOutput.writeBoolean(this._t);
        dataOutput.writeBoolean(this._u);
        dataOutput.writeBoolean(this._v);
        dataOutput.writeInt(this._w);
        dataOutput.writeInt(this._x);
        dataOutput.writeInt(this._y);
        dataOutput.writeFloat(this._z);
        dataOutput.writeBoolean(this._A);
        dataOutput.writeInt(this._B);
        dataOutput.writeInt(this.__aW);
        dataOutput.writeFloat(this.__aX);
        dataOutput.writeBoolean(this._C);
        dataOutput.writeBoolean(this._D);
        dataOutput.writeBoolean(this._E);
        dataOutput.writeBoolean(this._F);
        dataOutput.writeBoolean(this._G);
        dataOutput.writeBoolean(this._H);
        dataOutput.writeBoolean(this._I);
        dataOutput.writeBoolean(this._J);
        dataOutput.writeBoolean(this._K);
        dataOutput.writeBoolean(this._L);
        dataOutput.writeBoolean(this._M);
        dataOutput.writeBoolean(this._N);
        dataOutput.writeBoolean(this._O);
        dataOutput.writeBoolean(this._P);
        dataOutput.writeBoolean(this._Q);
        dataOutput.writeBoolean(this._R);
        dataOutput.writeFloat(this._S);
        dataOutput.writeBoolean(this._T);
        dataOutput.writeBoolean(this._U);
        dataOutput.writeBoolean(this._V);
        dataOutput.writeBoolean(this._W);
        dataOutput.writeBoolean(this._X);
        dataOutput.writeBoolean(this._Y);
        dataOutput.writeBoolean(this._Z);
        dataOutput.writeBoolean(this.__aa);
        dataOutput.writeInt(this.__ab);
        dataOutput.writeInt(this.__ac);
        dataOutput.writeInt(this.__ad);
        dataOutput.writeInt(this.__ae);
        dataOutput.writeInt(this.__af);
        dataOutput.writeFloat(this.__ag);
        dataOutput.writeFloat(this.__ah);
        dataOutput.writeFloat(this.__ai);
        dataOutput.writeBoolean(this.__aj);
        dataOutput.writeFloat(this.__ak);
        dataOutput.writeFloat(this.__al);
        dataOutput.writeFloat(this.__am);
        dataOutput.writeFloat(this.__an);
        dataOutput.writeFloat(this.__ao);
        dataOutput.writeFloat(this.__aq);
        dataOutput.writeFloat(this.__ar);
        dataOutput.writeDouble(this.__as);
        dataOutput.writeDouble(this.__at);
        dataOutput.writeFloat(this.__au);
        dataOutput.writeDouble(this.__aY);
        dataOutput.writeDouble(this.__aZ);
        dataOutput.writeDouble(this.__ba);
        dataOutput.writeFloat(this.__bb);
        dataOutput.writeFloat(this.__bc);
        dataOutput.writeBoolean(this.__av);
        dataOutput.writeBoolean(this.__aw);
        dataOutput.writeFloat(this.__bd);
        dataOutput.writeBoolean(this.__be);
        dataOutput.writeDouble(this.__bf);
        dataOutput.writeDouble(this.__bg);
        dataOutput.writeDouble(this.__ax);
        dataOutput.writeDouble(this.__ay);
        dataOutput.writeDouble(this.__az);
        dataOutput.writeFloat(this.__bh);
        dataOutput.writeFloat(this.__bi);
        dataOutput.writeBoolean(this.__aA);
        dataOutput.writeBoolean(this.__aB);
        dataOutput.writeBoolean(this.__aC);
        dataOutput.writeBoolean(this.__aD);
        dataOutput.writeBoolean(this.__bj);
        dataOutput.writeBoolean(this.__bk);
        dataOutput.writeInt(this.__bl);
        dataOutput.writeBoolean(this.__bm);
        dataOutput.writeBoolean(this.__bn);
        dataOutput.writeBoolean(this.__bo);
        dataOutput.writeBoolean(this.__bp);
        dataOutput.writeBoolean(this.__bq);
        dataOutput.writeInt(this.__br);
        dataOutput.writeInt(this.__bs);
        dataOutput.writeInt(this.__bt);
        dataOutput.writeInt(this.__bu);
        dataOutput.writeInt(this.__bv);
        dataOutput.writeInt(this.__bw);
        dataOutput.writeFloat(this.__aE);
        dataOutput.writeBoolean(this.__bx);
        dataOutput.writeBoolean(this.__by);
    }

    public void _a(DataInput dataInput) throws IOException {
        this.__aU._a(dataInput);
        this._c = dataInput.readBoolean();
        this._d = dataInput.readBoolean();
        this._e = dataInput.readBoolean();
        this._f = dataInput.readBoolean();
        this._g = dataInput.readBoolean();
        this._h = dataInput.readBoolean();
        this._i = dataInput.readBoolean();
        this._j = dataInput.readBoolean();
        this._k = dataInput.readBoolean();
        this._l = dataInput.readBoolean();
        this._m = dataInput.readBoolean();
        this._n = dataInput.readBoolean();
        this._o = dataInput.readBoolean();
        this._p = dataInput.readBoolean();
        this._q = dataInput.readBoolean();
        this._r = dataInput.readBoolean();
        this._s = dataInput.readBoolean();
        this._t = dataInput.readBoolean();
        this._u = dataInput.readBoolean();
        this._v = dataInput.readBoolean();
        this._w = dataInput.readInt();
        this._x = dataInput.readInt();
        this._y = dataInput.readInt();
        this._z = dataInput.readFloat();
        this._A = dataInput.readBoolean();
        this._B = dataInput.readInt();
        this.__aW = dataInput.readInt();
        this.__aX = dataInput.readFloat();
        this._C = dataInput.readBoolean();
        this._D = dataInput.readBoolean();
        this._E = dataInput.readBoolean();
        this._F = dataInput.readBoolean();
        this._G = dataInput.readBoolean();
        this._H = dataInput.readBoolean();
        this._I = dataInput.readBoolean();
        this._J = dataInput.readBoolean();
        this._K = dataInput.readBoolean();
        this._L = dataInput.readBoolean();
        this._M = dataInput.readBoolean();
        this._N = dataInput.readBoolean();
        this._O = dataInput.readBoolean();
        this._P = dataInput.readBoolean();
        this._Q = dataInput.readBoolean();
        this._R = dataInput.readBoolean();
        this._S = dataInput.readFloat();
        this._T = dataInput.readBoolean();
        this._U = dataInput.readBoolean();
        this._V = dataInput.readBoolean();
        this._W = dataInput.readBoolean();
        this._X = dataInput.readBoolean();
        this._Y = dataInput.readBoolean();
        this._Z = dataInput.readBoolean();
        this.__aa = dataInput.readBoolean();
        this.__ab = dataInput.readInt();
        this.__ac = dataInput.readInt();
        this.__ad = dataInput.readInt();
        this.__ae = dataInput.readInt();
        this.__af = dataInput.readInt();
        this.__ag = dataInput.readFloat();
        this.__ah = dataInput.readFloat();
        this.__ai = dataInput.readFloat();
        this.__aj = dataInput.readBoolean();
        this.__ak = dataInput.readFloat();
        this.__al = dataInput.readFloat();
        this.__am = dataInput.readFloat();
        this.__an = dataInput.readFloat();
        this.__ao = dataInput.readFloat();
        this.__aq = dataInput.readFloat();
        this.__ar = dataInput.readFloat();
        this.__as = dataInput.readDouble();
        this.__at = dataInput.readDouble();
        this.__au = dataInput.readFloat();
        this.__aY = dataInput.readDouble();
        this.__aZ = dataInput.readDouble();
        this.__ba = dataInput.readDouble();
        this.__bb = dataInput.readFloat();
        this.__bc = dataInput.readFloat();
        this.__av = dataInput.readBoolean();
        this.__aw = dataInput.readBoolean();
        this.__bd = dataInput.readFloat();
        this.__be = dataInput.readBoolean();
        this.__bf = dataInput.readDouble();
        this.__bg = dataInput.readDouble();
        this.__ax = dataInput.readDouble();
        this.__ay = dataInput.readDouble();
        this.__az = dataInput.readDouble();
        this.__bh = dataInput.readFloat();
        this.__bi = dataInput.readFloat();
        this.__aA = dataInput.readBoolean();
        this.__aB = dataInput.readBoolean();
        this.__aC = dataInput.readBoolean();
        this.__aD = dataInput.readBoolean();
        this.__bj = dataInput.readBoolean();
        this.__bk = dataInput.readBoolean();
        this.__bl = dataInput.readInt();
        this.__bm = dataInput.readBoolean();
        this.__bn = dataInput.readBoolean();
        this.__bo = dataInput.readBoolean();
        this.__bp = dataInput.readBoolean();
        this.__bq = dataInput.readBoolean();
        this.__br = dataInput.readInt();
        this.__bs = dataInput.readInt();
        this.__bt = dataInput.readInt();
        this.__bu = dataInput.readInt();
        this.__bv = dataInput.readInt();
        this.__bw = dataInput.readInt();
        this.__aE = dataInput.readFloat();
        this.__bx = dataInput.readBoolean();
        this.__by = dataInput.readBoolean();
    }

    public World _a() {
        return this.__bE.worldObj;
    }

    public boolean _b() {
        return this._y > 1 && this._y < 7;
    }

    protected void _c() {
        this._i = true;
    }

    protected void _a(Float f) {
        this._j = true;
        this.__aU._k();
    }

    protected void _a(float f, float f2, float f3, float f4, boolean bl) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = sajh._c(f2 * f2 + f3 * f3);
        if (f13 >= 0.01f) {
            if (f13 < 1.0f) {
                f13 = 1.0f;
            }
            f8 = f2 / f13;
            f7 = f3 / f13;
            f6 = sajh._a(this.__aU._B * 3.141593f / 180.0f);
            f5 = sajh._b(this.__aU._B * 3.141593f / 180.0f);
            f9 = f8 * f5;
            f10 = -f7 * f6;
            f11 = f8 * f6;
            f12 = f7 * f5;
        }
        f13 = bl ? this.__aU._C / 57.295776f : 0.0f;
        f8 = sajh._b(f13);
        f7 = -sajh._a(f13) * Math.signum(f3);
        f6 = f10 * f8 + f9;
        f5 = sajh._c(f10 * f10 + f12 * f12) * f7 + f;
        float f14 = f12 * f8 + f11;
        float f15 = sajh._c(sajh._c(f6 * f6 + f14 * f14) + f5 * f5);
        if (f15 > 0.01f) {
            float f16 = f4 / f15;
            this.__aU._m += (double)(f6 * f16);
            this.__aU._n += (double)(f5 * f16);
            this.__aU._o += (double)(f14 * f16);
        }
    }

    protected int _a(int n, int n2, int n3) {
        String string;
        Block block;
        int n4 = this._a().getBlockId(n, n2, n3);
        if (n4 <= 0) {
            return -1;
        }
        Dictionary dictionary = (Dictionary)tvcu.__aV._ceilingClimbConfigurationObject.value;
        Set set = (Set)dictionary.get(n4);
        if (set == null && n4 >= 0 && (block = Block.blocksList[n4]) != null && (string = block.getUnlocalizedName()) != null && !string.isEmpty() && (set = (Set)dictionary.get(string)) == null && string.startsWith("tile.") && string.length() > 5) {
            set = (Set)dictionary.get(string.substring(5));
        }
        return set == null ? -1 : (set.isEmpty() ? n4 : (set.contains(this._a().getBlockMetadata(n, n2, n3)) ? n4 : -1));
    }

    protected boolean _a(int n) {
        if (n != Block.lavaStill.blockID && n != Block.lavaMoving.blockID) {
            Block block = n > 0 ? Block.blocksList[n] : null;
            return block != null && block.blockMaterial == Material._i;
        }
        return true;
    }

    protected float _b(int n, int n2, int n3) {
        int n4 = this._a().getBlockId(n, n2, n3);
        if (n4 != Block.waterStill.blockID && n4 != Block.waterMoving.blockID) {
            if (n4 != Block.lavaStill.blockID && n4 != Block.lavaMoving.blockID) {
                Material material = this._a().getBlockMaterial(n, n2, n3);
                return material != null && material != Material._i ? (material == Material._h ? this._c(n, n2, n3) : (material._d() ? 1.0f : 0.0f)) : ((Boolean)tvcu.__aV._lavaLikeWater.value != false ? 1.0f : 0.0f);
            }
            return (Boolean)tvcu.__aV._lavaLikeWater.value != false ? this._c(n, n2, n3) : 0.0f;
        }
        return this._c(n, n2, n3);
    }

    protected float _c(int n, int n2, int n3) {
        int n4 = this._a().getBlockMetadata(n, n2, n3);
        return n4 >= 8 ? 1.0f : (n4 == 0 ? (this._a().isAirBlock(n, n2 + 1, n3) ? 0.8875f : 1.0f) : (float)(8 - n4) / 8.0f);
    }

    protected float _a(int n, int n2, int n3, int n4) {
        int n5 = Orientation.getFiniteLiquidWater(n4);
        if (n5 > 0) {
            if (n5 == 2) {
                return 1.0f;
            }
            if (n5 == 1) {
                int n6 = this._a().getBlockId(n, n2 + 1, n3);
                if (Orientation.getFiniteLiquidWater(n6) > 0) {
                    return 1.0f;
                }
                return (float)(this._a().getBlockMetadata(n, n2, n3) + 1) / 16.0f;
            }
        }
        return 0.0f;
    }

    public boolean _a(boolean bl) {
        return this._a(1, true, bl) > 0;
    }

    public boolean _b(boolean bl) {
        return this._b(1, true, bl) > 0;
    }

    public boolean _c(boolean bl) {
        return this._c(1, false, bl) > 0;
    }

    public boolean _d(boolean bl) {
        return this._a(1, false, false, true, bl) > 0;
    }

    public boolean _e(boolean bl) {
        return this._a(1, false, true, false, bl) > 0;
    }

    protected int _a(int n, boolean bl, boolean bl2) {
        return this._a(n, bl, true, false, bl2);
    }

    protected int _b(int n, boolean bl, boolean bl2) {
        return this._a(n, bl, false, true, bl2);
    }

    protected int _c(int n, boolean bl, boolean bl2) {
        return this._a(n, bl, true, true, bl2);
    }

    protected int _a(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n2 = sajh._c(this.__aU._j);
        int n3 = sajh._c(this.__aU._a._c);
        int n4 = sajh._c(this.__aU._l);
        if (__aV.isStandardBaseClimb()) {
            int n5 = this._a().getBlockId(n2, n3, n4);
            return bl2 ? (bl3 ? (Orientation.isClimbable(this._a(), n2, n3, n4) ? 1 : 0) : (n5 != Block.vine.blockID && Orientation.isClimbable(this._a(), n2, n3, n4) ? 1 : 0)) : (!bl3 ? 0 : (n5 == Block.vine.blockID && Orientation.isClimbable(this._a(), n2, n3, n4) ? 1 : 0));
        }
        if (bl4) {
            --n3;
        }
        HashSet<Orientation> hashSet = null;
        if (bl) {
            hashSet = Orientation.getClimbingOrientations(this.__aU, true, false);
        }
        int n6 = 0;
        int n7 = sajh._c(this.__aU._a._c + Math.ceil(this.__aU._a._f - this.__aU._a._c)) - 1;
        for (int i = n3; i <= n7; ++i) {
            Orientation orientation;
            int n8 = this._a().getBlockId(n2, i, n4);
            if (bl2) {
                boolean bl5 = Orientation.isKnownLadder(n8);
                orientation = null;
                if (bl5) {
                    orientation = Orientation.getKnownLadderOrientation(this._a(), n2, i, n4);
                    if (hashSet == null || hashSet.contains(orientation)) {
                        ++n6;
                    }
                }
                HashSet<Orientation> hashSet2 = hashSet != null ? hashSet : Orientation.Orthogonals;
                for (Orientation orientation2 : hashSet2) {
                    Orientation orientation3;
                    int n5;
                    if (n6 >= n) {
                        return n6;
                    }
                    if (orientation2 == orientation || !Orientation.isKnownLadder(n5 = this._a().getBlockId(n2 + orientation2._i, i, n4 + orientation2._k)) || (orientation3 = Orientation.getKnownLadderOrientation(this._a(), n2 + orientation2._i, i, n4 + orientation2._k)).rotate(180) != orientation2) continue;
                    ++n6;
                }
            }
            if (n6 >= n) {
                return n6;
            }
            if (bl3 && Orientation.isVine(n8)) {
                if (hashSet == null) {
                    ++n6;
                } else {
                    for (Orientation orientation4 : hashSet) {
                        orientation = orientation4;
                        if (!orientation.hasVineOrientation(this._a(), n2, i, n4) || !orientation.isRemoteSolid(this._a(), n2, i, n4)) continue;
                        ++n6;
                        break;
                    }
                }
            }
            if (n6 < n) continue;
            return n6;
        }
        return n6;
    }

    public boolean _d() {
        Orientation orientation;
        if (this.__aU._u && this.__aU._v && !this.__aU._x && this.__aH._a && (orientation = Orientation.getOrientation(this.__aU, 20.0f, true, false)) != null) {
            int n = sajh._c(this.__aU._j);
            int n2 = sajh._c(this.__aU._a._f);
            int n3 = sajh._c(this.__aU._l);
            if (Orientation.isLadder(this._a().getBlockId(n, n2, n3))) {
                return Orientation.getKnownLadderOrientation(this._a(), n, n2, n3) == orientation;
            }
        }
        return false;
    }

    public boolean _e() {
        Orientation orientation;
        if (this.__aU._u && this.__aU._v && !this.__aU._x && this.__aH._a && (orientation = Orientation.getOrientation(this.__aU, 20.0f, true, false)) != null) {
            int n = sajh._c(this.__aU._j);
            int n2 = sajh._c(this.__aU._a._f);
            int n3 = sajh._c(this.__aU._l);
            if (Orientation.isTrapDoor(this._a().getBlockId(n, n2, n3))) {
                return Orientation.getOpenTrapDoorOrientation(this._a(), n, n2, n3) == orientation;
            }
        }
        return false;
    }

    public boolean _f() {
        Orientation orientation;
        if (this.__aU._u && this.__aU._v && !this.__aU._x && this.__aH._a && (orientation = Orientation.getOrientation(this.__aU, 20.0f, true, false)) != null) {
            int n = sajh._c(this.__aU._j);
            int n2 = sajh._c(this.__aU._a._f);
            int n3 = sajh._c(this.__aU._l);
            if (this._a().getBlockId(n, n2, n3) == Block.cobblestoneWall.blockID) {
                return !((BlockWall)Block.cobblestoneWall)._a(this._a(), n - orientation._i, n2, n3 - orientation._k);
            }
        }
        return false;
    }

    private List<AxisAlignedBB> _g(double d, double d2, double d3) {
        double d4 = this.__aU._a._c;
        double d5 = this.__aU._a._f;
        this.__aU._a._c = d;
        this.__aU._a._f = d2;
        List<AxisAlignedBB> list2 = this._a(d3 == 0.0 ? this.__aU._a : this.__aU._a._e(-d3, 0.0, -d3));
        this.__aU._a._c = d4;
        this.__aU._a._f = d5;
        return list2;
    }

    protected boolean _a(double d, double d2) {
        return this._g(d, d2, 0.0).size() > 0;
    }

    protected double _a(double d, double d2, double d3) {
        List<AxisAlignedBB> list2 = this._g(d, d2, d3);
        double d4 = d;
        for (int i = 0; i < list2.size(); ++i) {
            AxisAlignedBB axisAlignedBB = list2.get(i);
            if (!this._a(axisAlignedBB, d, d2, d3)) continue;
            d4 = Math.max(d4, axisAlignedBB._f);
        }
        return Math.min(d4, d2);
    }

    protected double _b(double d, double d2, double d3) {
        List<AxisAlignedBB> list2 = this._g(d, d2, d3);
        double d4 = d2;
        for (int i = 0; i < list2.size(); ++i) {
            AxisAlignedBB axisAlignedBB = list2.get(i);
            if (!this._a(axisAlignedBB, d, d2, d3)) continue;
            d4 = Math.min(d4, axisAlignedBB._c);
        }
        return Math.max(d4, d);
    }

    protected boolean _g() {
        return this._b(this.__aU._a._c, this.__aU._a._f) != this.__aU._a._c || this._c(this.__aU._a._c, this.__aU._a._f) != this.__aU._a._f;
    }

    protected boolean _h() {
        return this._a().isMaterialInBB(this.__aU._a._b(-0.1f, -0.4f, -0.1f), Material._h);
    }

    protected double _b(double d, double d2) {
        int n = sajh._c(this.__aU._j);
        int n2 = sajh._c(d);
        int n3 = sajh._c(d2);
        int n4 = sajh._c(this.__aU._l);
        for (int i = n3; i >= n2; --i) {
            float f = this._b(n, i, n4);
            if (!(f > 0.0f)) continue;
            return (float)i + f;
        }
        return d;
    }

    protected double _c(double d, double d2) {
        int n = sajh._c(this.__aU._j);
        int n2 = sajh._c(d);
        int n3 = sajh._c(d2);
        int n4 = sajh._c(this.__aU._l);
        for (int i = n2; i <= n3; ++i) {
            float f = this._b(n, i, n4);
            if (!(f > 0.0f)) continue;
            if ((double)i > d) {
                return i;
            }
            if (!((double)((float)i + f) > d)) continue;
            return d;
        }
        return d2;
    }

    public boolean _a(AxisAlignedBB axisAlignedBB, double d, double d2, double d3) {
        return axisAlignedBB._e >= this.__aU._a._b - d3 && axisAlignedBB._b <= this.__aU._a._e + d3 && axisAlignedBB._f >= d && axisAlignedBB._c <= d2 && axisAlignedBB._g >= this.__aU._a._d - d3 && axisAlignedBB._d <= this.__aU._a._g + d3;
    }

    private boolean _e(int n, int n2, int n3) {
        return this._a().isBlockNormalCube(n, n2, n3);
    }

    public boolean _a(double d, double d2, double d3, boolean bl) {
        int n = sajh._c(d);
        int n2 = sajh._c(d2);
        int n3 = sajh._c(d3);
        double d4 = d - (double)n;
        double d5 = d3 - (double)n3;
        if (this._e(n, n2, n3) || bl && this._e(n, n2 + 1, n3)) {
            boolean bl2 = !this._e(n - 1, n2, n3) && (!bl || !this._e(n - 1, n2 + 1, n3));
            boolean bl3 = !this._e(n + 1, n2, n3) && (!bl || !this._e(n + 1, n2 + 1, n3));
            boolean bl4 = !this._e(n, n2, n3 - 1) && (!bl || !this._e(n, n2 + 1, n3 - 1));
            boolean bl5 = !this._e(n, n2, n3 + 1) && (!bl || !this._e(n, n2 + 1, n3 + 1));
            int n4 = -1;
            double d6 = 9999.0;
            if (bl2 && d4 < d6) {
                d6 = d4;
                n4 = 0;
            }
            if (bl3 && 1.0 - d4 < d6) {
                d6 = 1.0 - d4;
                n4 = 1;
            }
            if (bl4 && d5 < d6) {
                d6 = d5;
                n4 = 4;
            }
            if (bl5 && 1.0 - d5 < d6) {
                n4 = 5;
            }
            float f = 0.1f;
            if (n4 == 0) {
                this.__aU._m = -f;
            }
            if (n4 == 1) {
                this.__aU._m = f;
            }
            if (n4 == 4) {
                this.__aU._o = -f;
            }
            if (n4 == 5) {
                this.__aU._o = f;
            }
        }
        return false;
    }

    private List<AxisAlignedBB> _a(AxisAlignedBB axisAlignedBB) {
        return this._a().getCollidingBoundingBoxes(this.__bE, axisAlignedBB);
    }

    public int _c(double d, double d2, double d3) {
        int n;
        int n2;
        boolean bl;
        float f = this.__aU._d;
        double d4 = this.__aU._j;
        double d5 = this.__aU._l;
        boolean bl2 = this.__aU._F;
        double d6 = this.__aU._m;
        double d7 = this.__aU._n;
        double d8 = this.__aU._o;
        AxisAlignedBB axisAlignedBB = this.__aU._a._c();
        boolean bl3 = this.__aU._x;
        World world = this._a();
        float f2 = 0.5f;
        f *= 0.4f;
        if (bl2) {
            bl2 = false;
            d *= 0.7;
            d2 *= 0.7;
            d3 *= 0.7;
            d6 = 0.0;
            d7 = 0.0;
            d8 = 0.0;
        }
        double d9 = d;
        double d10 = d2;
        double d11 = d3;
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB._c();
        boolean bl4 = bl = bl3 && this._x();
        if (bl) {
            double d12 = 0.05;
            while (d != 0.0 && this._a(axisAlignedBB._c(d, -1.0, 0.0)).size() == 0) {
                d = d < d12 && d >= -d12 ? 0.0 : (d > 0.0 ? (d -= d12) : (d += d12));
                d9 = d;
            }
            while (d3 != 0.0 && this._a(axisAlignedBB._c(0.0, -1.0, d3)).size() == 0) {
                d3 = d3 < d12 && d3 >= -d12 ? 0.0 : (d3 > 0.0 ? (d3 -= d12) : (d3 += d12));
                d11 = d3;
            }
            while (d != 0.0 && d3 != 0.0 && this._a(axisAlignedBB._c(d, -1.0, d3)).size() == 0) {
                d = d < d12 && d >= -d12 ? 0.0 : (d > 0.0 ? (d -= d12) : (d += d12));
                d3 = d3 < d12 && d3 >= -d12 ? 0.0 : (d3 > 0.0 ? (d3 -= d12) : (d3 += d12));
                d9 = d;
                d11 = d3;
            }
        }
        List<AxisAlignedBB> list2 = this._a(axisAlignedBB._a(d, d2, d3));
        for (n2 = 0; n2 < list2.size(); ++n2) {
            d2 = list2.get(n2)._b(axisAlignedBB, d2);
        }
        axisAlignedBB._d(0.0, d2, 0.0);
        n2 = bl3 || d10 != d2 && d10 < 0.0 ? 1 : 0;
        for (n = 0; n < list2.size(); ++n) {
            d = list2.get(n)._a(axisAlignedBB, d);
        }
        axisAlignedBB._d(d, 0.0, 0.0);
        for (n = 0; n < list2.size(); ++n) {
            d3 = list2.get(n)._c(axisAlignedBB, d3);
        }
        axisAlignedBB._d(0.0, 0.0, d3);
        if (f2 > 0.0f && n2 != 0 && (bl || f < 0.05f) && (d9 != d || d11 != d3)) {
            int n3;
            double d13 = d;
            double d14 = d2;
            double d15 = d3;
            d = d9;
            d2 = f2;
            d3 = d11;
            AxisAlignedBB axisAlignedBB3 = axisAlignedBB._c();
            axisAlignedBB._c(axisAlignedBB2);
            List<AxisAlignedBB> list3 = this._a(axisAlignedBB._a(d9, d2, d11));
            for (n3 = 0; n3 < list3.size(); ++n3) {
                d2 = list3.get(n3)._b(axisAlignedBB, d2);
            }
            axisAlignedBB._d(0.0, d2, 0.0);
            for (n3 = 0; n3 < list3.size(); ++n3) {
                d = list3.get(n3)._a(axisAlignedBB, d);
            }
            axisAlignedBB._d(d, 0.0, 0.0);
            for (n3 = 0; n3 < list3.size(); ++n3) {
                d3 = list3.get(n3)._c(axisAlignedBB, d3);
            }
            axisAlignedBB._d(0.0, 0.0, d3);
            d2 = -f2;
            for (n3 = 0; n3 < list3.size(); ++n3) {
                d2 = list3.get(n3)._b(axisAlignedBB, d2);
            }
            axisAlignedBB._d(0.0, d2, 0.0);
            if (d13 * d13 + d15 * d15 >= d * d + d3 * d3) {
                d = d13;
                d2 = d14;
                d3 = d15;
                axisAlignedBB._c(axisAlignedBB3);
            } else {
                double d16 = axisAlignedBB._c - (double)((int)axisAlignedBB._c);
                if (d16 > 0.0) {
                    float f3 = (float)((double)f + d16 + 0.01);
                }
            }
        }
        boolean bl5 = d9 > d;
        boolean bl6 = d9 < d;
        boolean bl7 = d10 > d2;
        boolean bl8 = d10 < d2;
        boolean bl9 = d11 > d3;
        boolean bl10 = d11 < d3;
        int n4 = 0;
        if (bl5) {
            ++n4;
        }
        if (bl6) {
            n4 += 2;
        }
        if (bl7) {
            n4 += 4;
        }
        if (bl8) {
            n4 += 8;
        }
        if (bl9) {
            n4 += 16;
        }
        if (bl10) {
            n4 += 32;
        }
        return n4;
    }

    public void _a(boolean bl, boolean bl2) {
        double d = this.__aU._j - this.__aU._g;
        double d2 = this.__aU._l - this.__aU._i;
        float f = sajh._a(d * d + d2 * d2);
        if (f < 0.05f && (double)f > 0.02 && bl) {
            boolean bl3;
            float f2;
            float f3;
            float f4 = this.__aU._E;
            float f5 = 0.0f;
            f5 = f * 3.0f;
            f4 = (float)Math.atan2(d2, d) * 180.0f / 3.141593f - 90.0f;
            for (f3 = f4 - this.__aU._E; f3 < -180.0f; f3 += 360.0f) {
            }
            while (f3 >= 180.0f) {
                f3 -= 360.0f;
            }
            float f6 = this.__aU._E + f3 * 0.3f;
            for (f2 = this.__aU._B - f6; f2 < -180.0f; f2 += 360.0f) {
            }
            while (f2 >= 180.0f) {
                f2 -= 360.0f;
            }
            boolean bl4 = bl3 = f2 < -90.0f || f2 >= 90.0f;
            if (f2 < -75.0f) {
                f2 = -75.0f;
            }
            if (f2 >= 75.0f) {
                f2 = 75.0f;
            }
            this.__aU._E = this.__aU._B - f2;
            if (f2 * f2 > 2500.0f) {
                this.__aU._E += f2 * 0.2f;
            }
            if (bl3) {
                f5 *= -1.0f;
            }
            while (this.__aU._E - this.__aU._D < -180.0f) {
                this.__aU._D -= 360.0f;
            }
            while (this.__aU._E - this.__aU._D >= 180.0f) {
                this.__aU._D += 360.0f;
            }
        }
        if (bl2) {
            // empty if block
        }
    }

    protected double _i() {
        return this.__aU._a._c - this._a(this.__aU._a._c - 1.1, this.__aU._a._c, 0.0);
    }

    protected double _j() {
        return this._b(this.__aU._a._f, this.__aU._a._f + 1.1, 0.0) - this.__aU._a._f;
    }

    public double _a(double d) {
        return this.__aU._a._c - this._a(this.__aU._a._c - d, this.__aU._a._c, 0.0);
    }

    public int _b(double d) {
        int n;
        int n2 = sajh._c(this.__aU._j);
        int n3 = sajh._c(this.__aU._l);
        int n4 = n - (int)Math.ceil(d);
        for (n = sajh._c(this.__aU._a._c); n >= n4; --n) {
            int n5 = this._a().getBlockId(n2, n, n3);
            if (n5 <= 0) continue;
            return n5;
        }
        return -1;
    }

    public void _a(float f, float f2) {
        if (this.__aU._d() && !__aV.isFlyingEnabled()) {
            double d = this.__aU._n;
            float f3 = this.__aU._p;
            this.__aU._p = 0.05f;
            this._b(f, f2);
            this.__aU._n = d * 0.6;
            this.__aU._p = f3;
        } else {
            this._b(f, f2);
        }
    }

    private void _b(float f, float f2) {
        if (this._z() && !__aV.isRunningEnabled()) {
            this.__aU._b(false);
        }
        boolean bl = this._p || this._q;
        boolean bl2 = this._p;
        boolean bl3 = this._e;
        boolean bl4 = this._q;
        boolean bl5 = this._m;
        boolean bl6 = this._U;
        this._u();
        double d = this.__aU._j;
        double d2 = this.__aU._k;
        double d3 = this.__aU._l;
        if (this.__aU._u) {
            this.__as = this.__aU._j;
            this.__at = this.__aU._l;
        }
        float f3 = this._c(f2, f);
        boolean bl7 = __aV.isFreeClimbingEnabled() && (double)this.__aU._j() <= 3.0 && this._C && this.__aU._u && !this._q;
        boolean bl8 = this._a(f2, f, f3, bl2, bl4, bl7, bl6);
        boolean bl9 = this._a(f2, f, bl8, bl7);
        boolean bl10 = this._a(f2, f, f3, bl8, bl9);
        this._a(f2, f, f3, bl8, bl9, bl10, bl, bl3, bl5);
        this._v();
        double d4 = this.__aU._j - d;
        double d5 = this.__aU._k - d2;
        double d6 = this.__aU._l - d3;
        this._k(d4, d5, d6);
    }

    private float _G() {
        return tvcu.__aV.enabled ? ((Float)tvcu.__aV._speedFactor.value).floatValue() * __aV.getUserSpeedFactor() * this._E() * 10.0f / (this.__aU._g() ? 1.3f : 1.0f) : 1.0f;
    }

    private float _c(float f, float f2) {
        float f3 = this._G();
        if (this.__bI != 0) {
            float f4 = 0.2f;
            if (tvcu.__aV.enabled) {
                Item item = Item.itemsList[this.__bI];
                f4 = item instanceof ItemSword ? ((Float)tvcu.__aV._usageSwordSpeedFactor.value).floatValue() : (item instanceof ItemBow ? ((Float)tvcu.__aV._usageBowSpeedFactor.value).floatValue() : (item instanceof ItemFood ? ((Float)tvcu.__aV._usageFoodSpeedFactor.value).floatValue() : ((Float)tvcu.__aV._usageSpeedFactor.value).floatValue()));
            }
            f3 *= f4;
        }
        if (!(this._t || this._l && !this._k)) {
            if (this._c) {
                f3 *= ((Float)tvcu.__aV._sneakFactor.value).floatValue();
            }
        } else {
            f3 *= ((Float)tvcu.__aV._crawlFactor.value).floatValue();
        }
        if (this._d) {
            f3 *= ((Float)tvcu.__aV._sprintFactor.value).floatValue();
        }
        if (this._e) {
            if (f2 == 0.0f && f == 0.0f) {
                if (this._D && this._N && (Math.abs(this.__aU._j - this.__as) >= 0.05 || Math.abs(this.__aU._l - this.__at) >= 0.05)) {
                    f = 0.3f;
                    if (this._J) {
                        if (this.__ac != 0 && this.__ae != 0) {
                            f = 0.0f;
                        } else {
                            Orientation orientation = Orientation.getOrientation(this.__aU, 45.0f, true, false);
                            if (orientation != null) {
                                float f5 = (float)orientation.getHorizontalBorderGap(this.__aU._j, this.__aU._l);
                                float f6 = this.__aU._c / 2.0f;
                                float f7 = Math.max(0.0f, f5 * (1.0f + f6) - f6);
                                f = f7 * f7 * 0.3f;
                            }
                        }
                    }
                }
            } else {
                f3 *= ((Float)tvcu.__aV._freeClimbingHorizontalSpeedFactor.value).floatValue();
            }
        }
        if (this._m) {
            f3 *= ((Float)tvcu.__aV._ceilingClimbingSpeedFactor.value).floatValue();
        }
        return f3;
    }

    private boolean _H() {
        return this._a().isMaterialInBB(this.__aU._a._b(-0.1f, -0.4f, -0.1f), Material._i);
    }

    private boolean _a(float f, float f2, float f3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5;
        boolean bl6 = false;
        boolean bl7 = bl5 = !this._v && !bl3 && (this._h() || bl && this._g() || __aV.isLavaLikeWaterEnabled() && this._H());
        if (bl5) {
            boolean bl8;
            this._J();
            float f4 = this._z;
            boolean bl9 = bl8 = !__aV.isSwimmingEnabled() && !__aV.isDivingEnabled();
            if (this.__aU._e()) {
                this._K();
                bl8 = true;
            }
            if (bl8 && this._t) {
                this._N();
            } else {
                this._L();
            }
            if (!bl8) {
                boolean bl10;
                this._K();
                int n = sajh._c(this.__aU._j);
                int n2 = sajh._c(this.__aU._a._c);
                int n3 = sajh._c(this.__aU._l);
                boolean bl11 = false;
                boolean bl12 = false;
                boolean bl13 = false;
                double d = this.__aU._a._c - (double)n2;
                double d2 = this._b(this.__aU._a._f - 1.8, this.__aU._a._f + 1.2);
                double d3 = this._b(this.__aU._a._f - 1.8, this.__aU._a._f + 1.2, 0.0);
                double d4 = Math.min(d2, d3);
                double d5 = d2 - this._a(d2 - 2.0, d2, 0.0);
                double d6 = d2 - this._a(d4 - 2.0, d4, 0.0);
                double d7 = d2 - (double)n2 - d;
                if (this._t && d7 > (double)0.65f) {
                    this._N();
                }
                double d8 = 0.0;
                boolean bl14 = d7 >= 0.0 && d5 <= 1.5;
                boolean bl15 = this.__aU._z;
                boolean bl16 = this.__aM._a && (Boolean)tvcu.__aV._diveDownOnSneak.value != false;
                boolean bl17 = this.__aM._a && (Boolean)tvcu.__aV._swimDownOnSneak.value != false;
                boolean bl18 = bl10 = bl14 && (bl || bl2);
                if (bl10) {
                    HashSet<Orientation> hashSet = Orientation.getClimbingOrientations(this.__aU, true, true);
                    Iterator<Orientation> iterator2 = hashSet.iterator();
                    while (iterator2.hasNext() && (bl10 &= !iterator2.next().isTunnelAhead(this._a(), n, n2, n3))) {
                    }
                }
                if (bl && bl10 && bl17) {
                    bl17 = false;
                    this._W = true;
                }
                if (this._q && bl15 && bl16) {
                    bl16 = false;
                    bl15 = false;
                }
                if (!(this._t || this._k || this._l)) {
                    if (d7 >= 0.0 && d7 <= 2.0) {
                        boolean bl19;
                        double d9 = d7 + 0.1625;
                        boolean bl20 = bl19 = this.__aU._C < 0.0f && f > 0.0f || this.__aU._C > 0.0f && f < 0.0f;
                        if (!(bl15 || bl19 || bl10)) {
                            if (d9 < 1.5) {
                                bl13 = true;
                                d8 = d9 < 1.0 ? -0.02 : -0.02;
                            } else {
                                bl12 = true;
                                d8 = bl16 ? 0.01 - 0.1 * (double)f3 : (d9 < 1.8 ? -0.02 : (d9 < 1.82 ? -0.01 : (d9 < 1.84 ? -0.005 : (d9 < 1.86 ? -0.0025 : (d9 < 1.864 ? -0.00125 : (d9 < 1.868 ? 0.0 : (d9 < 1.872 ? 0.00125 : (d9 < 1.876 ? 0.0025 : (d9 < 1.88 ? 0.005 : (d9 < 1.9 ? 0.01 : 0.01))))))))));
                            }
                        } else if (d9 < 1.4) {
                            bl13 = true;
                            d8 = d9 < 1.0 ? -0.02 : -0.01;
                        } else if (d9 < 1.9) {
                            bl11 = true;
                            if (bl17) {
                                d8 = -0.05 * (double)(this._d ? ((Float)tvcu.__aV._sprintFactor.value).floatValue() : 1.0f);
                            } else if (d9 < 1.5) {
                                d8 = -0.02;
                            }
                            d8 = d9 < 1.6 ? -0.01 : (d9 < 1.62 ? -0.005 : (d9 < 1.64 ? -0.0025 : (d9 < 1.66 ? -0.00125 : (d9 < 1.664 ? -6.25E-4 : (d9 < 1.668 ? 0.0 : (d9 < 1.672 ? 6.25E-4 : (d9 < 1.676 ? 0.00125 : (d9 < 1.68 ? 0.0025 : (d9 < 1.7 ? 0.005 : (d9 < 1.8 ? 0.01 : 0.02))))))))));
                        } else {
                            bl12 = true;
                            d8 = bl15 ? 0.05 * (double)(this._d ? ((Float)tvcu.__aV._sprintFactor.value).floatValue() : 1.0f) : (bl16 ? 0.01 - 0.1 * (double)f3 : (bl19 ? 0.04 : 0.02));
                        }
                    } else if (d7 > 2.0) {
                        bl12 = true;
                        d8 = bl15 ? (this._d && d7 < 2.5 && this._a().isAirBlock(n, n2 + 3, n3) ? 0.11 / (double)((Float)tvcu.__aV._sprintFactor.value).floatValue() : 0.01 + 0.1 * (double)f3) : (bl16 ? 0.01 - 0.1 * (double)f3 : 0.01);
                    } else {
                        bl6 = true;
                    }
                } else {
                    this._o = true;
                }
                this._S = (float)d7;
                float f5 = this._S + f4;
                if ((this._t || this._u) && f5 < 1.0f) {
                    if (f5 < 0.65f) {
                        this._g(f4);
                        bl6 = true;
                    } else {
                        if (bl10) {
                            this._b(0.0, 0.1, 0.0, true);
                        }
                        this._t = false;
                        this._q = false;
                        this._p = true;
                        this._o = false;
                    }
                }
                if (!bl6) {
                    bl11 = !bl8 && bl11 && __aV.isSwimmingEnabled();
                    bl12 = !bl8 && bl12 && __aV.isDivingEnabled();
                    bl13 = !bl8 && bl13 && __aV.isSwimmingEnabled();
                    boolean bl21 = bl8 = !bl11 && !bl12 && !bl13;
                    if (!bl8) {
                        boolean bl22;
                        if (bl15) {
                            this.__aU._n -= (double)0.04f;
                        }
                        if (bl11) {
                            this.__aU._m *= 0.85;
                            this.__aU._n *= 0.85;
                            this.__aU._o *= 0.85;
                        } else if (bl12) {
                            this.__aU._m *= 0.83;
                            this.__aU._n *= 0.83;
                            this.__aU._o *= 0.83;
                        } else if (bl13) {
                            this.__aU._m *= 0.8;
                            this.__aU._n *= 0.83;
                            this.__aU._o *= 0.8;
                        } else {
                            this.__aU._m *= 0.9;
                            this.__aU._n *= 0.85;
                            this.__aU._o *= 0.9;
                        }
                        boolean bl23 = true;
                        boolean bl24 = bl22 = bl12 && !bl15 && !bl16 && f2 == 0.0f && f == 0.0f;
                        if (bl12) {
                            f3 *= ((Float)tvcu.__aV._diveSpeedFactor.value).floatValue();
                        }
                        if (bl11) {
                            f3 *= ((Float)tvcu.__aV._swimSpeedFactor.value).floatValue();
                        }
                        this.__af = !bl11 && !bl12 ? 0 : ++this.__af;
                        boolean bl25 = (f != 0.0f || f2 != 0.0f) && this.__aU._u && bl15 && !this._c;
                        boolean bl26 = this._U = bl25 && (this.__af > 10 || this.__aU._x || bl4);
                        if (bl12) {
                            if (!(bl15 || bl16 || bl22)) {
                                this._a((float)d8, f2, f, 0.02f * f3, (boolean)((Boolean)tvcu.__aV._diveControlVertical.value));
                            } else {
                                this.__aU._n = (this.__aU._n + d8) * 0.6;
                            }
                            bl23 = false;
                        } else {
                            this.__aU._n = bl11 && bl17 ? (this.__aU._n + d8) * 0.6 : (this._U ? (double)0.3f : (this.__aU._n += d8));
                        }
                        this._q = bl12;
                        this._r = bl22;
                        this._p = bl11;
                        this._V = bl14 && (this._q || this._p);
                        this._o = bl13;
                        if (this._q || this._p) {
                            this._g(-1.0f);
                        }
                        if (this._V && d6 < (double)0.55f) {
                            if (this._c) {
                                this._g(-1.0f);
                                this._t = true;
                                this._q = false;
                                this._p = false;
                                this._V = false;
                                this._o = true;
                            } else {
                                this._L();
                                this._i(0.0, this._a(this.__aU._a._c, this.__aU._a._f, 0.0) - this.__aU._a._c, 0.0);
                                this._t = false;
                                this._q = false;
                                this._p = false;
                                this._V = false;
                                this._o = true;
                            }
                        }
                        if (bl23) {
                            this.__aU._a(f2, f, 0.02f * f3);
                        }
                        this._i(this.__aU._m, this.__aU._n, this.__aU._o);
                    }
                }
            } else {
                this._q = false;
                this._p = false;
                this._V = false;
                this._o = false;
                this._X = false;
            }
            if (bl8) {
                this._K();
                if (this._t) {
                    this._g(f4);
                }
                double d = this.__aU._k;
                this.__aU._a(f2, f, 0.02f * f3);
                this._i(this.__aU._m, this.__aU._n, this.__aU._o);
                this.__aU._m *= (double)0.8f;
                this.__aU._n *= (double)0.8f;
                this.__aU._o *= (double)0.8f;
                this.__aU._n -= 0.02;
                if (this.__aU._u && this._h(this.__aU._m, this.__aU._n + (double)0.6f - this.__aU._k + d, this.__aU._o)) {
                    this.__aU._n = 0.3f;
                }
            }
        }
        return bl5 && !bl6;
    }

    private boolean _a(float f, float f2, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl3 = !this._v && !bl && !bl2 && this._H();
        if (bl3) {
            this._N();
            this._J();
            this._K();
            double d = this.__aU._k;
            this.__aU._a(f2, f, 0.02f);
            this._i(this.__aU._m, this.__aU._n, this.__aU._o);
            this.__aU._m *= 0.5;
            this.__aU._n *= 0.5;
            this.__aU._o *= 0.5;
            this.__aU._n -= 0.02;
            if (this.__aU._u && this._h(this.__aU._m, this.__aU._n + (double)0.6f - this.__aU._k + d, this.__aU._o)) {
                this.__aU._n = 0.3f;
            }
        }
        return bl3;
    }

    private boolean _h(double d, double d2, double d3) {
        AxisAlignedBB axisAlignedBB = this.__aU._a._c(d, d2, d3);
        List<AxisAlignedBB> list2 = this._a(axisAlignedBB);
        return list2.isEmpty() && !this._a().isAnyLiquid(axisAlignedBB);
    }

    private boolean _a(float f, float f2, float f3, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl3 = !bl && !bl2 && this.__aU._d() && __aV.isFlyingEnabled();
        if (bl3) {
            this._K();
            this._J();
            float f4 = 0.0f;
            if (this.__aM._a) {
                f4 -= 0.98f;
            }
            if (this.__aL._a) {
                f4 += 0.98f;
            }
            this._a(f4, f2, f, f3 * 0.05f * ((Float)tvcu.__aV._flyingSpeedFactor.value).floatValue(), (boolean)((Boolean)tvcu.__aV._flyControlVertical.value));
            this._i(this.__aU._m, this.__aU._n, this.__aU._o);
            this.__aU._m *= (double)0.91f;
            this.__aU._n *= (double)0.91f;
            this.__aU._o *= (double)0.91f;
        }
        return bl3;
    }

    private void _a(float f, float f2, float f3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        if (!(bl || bl2 || bl3)) {
            this._K();
            if (!this.__aN._a) {
                this._h(bl4);
            }
            boolean bl7 = this._e(this._k);
            boolean bl8 = this._d(this._k);
            float f4 = this._b(f, f2, f3, bl7, bl8);
            boolean bl9 = (this._t || this._l) && this.__aU._F;
            this._b(this.__aU._m, this.__aU._n, this.__aU._o, bl9);
            this._a(bl7, bl8, bl5);
            this._f(bl6);
            this._f(f4);
        }
        this._g(bl4);
    }

    private void _b(double d, double d2, double d3, boolean bl) {
        boolean bl2 = this.__aU._F;
        if (bl) {
            this.__aU._F = false;
        }
        this._i(d, d2, d3);
        if (bl) {
            this.__aU._F = bl2;
        }
    }

    private void _i(double d, double d2, double d3) {
        this.__aU._f = 0.5f;
        this._d(d, d2, d3);
        this._j(d, d2, d3);
        this._e(d, d2, d3);
        this.__aU._f = 0.0f;
    }

    private void _j(double d, double d2, double d3) {
        int n;
        double d4;
        double d5;
        double d6;
        int n2;
        int n3;
        boolean bl;
        this.__aU._d *= 0.4f;
        double d7 = this.__aU._j;
        double d8 = this.__aU._k;
        double d9 = this.__aU._l;
        if (this.__aU._F) {
            this.__aU._F = false;
            d *= 0.7;
            d2 *= 0.7;
            d3 *= 0.7;
            this.__aU._m = 0.0;
            this.__aU._n = 0.0;
            this.__aU._o = 0.0;
        }
        double d10 = d;
        double d11 = d2;
        double d12 = d3;
        AxisAlignedBB axisAlignedBB = this.__aU._a._c();
        boolean bl2 = bl = this.__aU._x && this.__aU._h();
        if (bl) {
            double d13 = 0.05;
            while (d != 0.0 && this._a(this.__aU._a._c(d, -1.0, 0.0)).isEmpty()) {
                d = d < d13 && d >= -d13 ? 0.0 : (d > 0.0 ? (d -= d13) : (d += d13));
                d10 = d;
            }
            while (d3 != 0.0 && this._a(this.__aU._a._c(0.0, -1.0, d3)).isEmpty()) {
                d3 = d3 < d13 && d3 >= -d13 ? 0.0 : (d3 > 0.0 ? (d3 -= d13) : (d3 += d13));
                d12 = d3;
            }
            while (d != 0.0 && d3 != 0.0 && this._a(this.__aU._a._c(d, -1.0, d3)).isEmpty()) {
                d = d < d13 && d >= -d13 ? 0.0 : (d > 0.0 ? (d -= d13) : (d += d13));
                d3 = d3 < d13 && d3 >= -d13 ? 0.0 : (d3 > 0.0 ? (d3 -= d13) : (d3 += d13));
                d10 = d;
                d12 = d3;
            }
        }
        List<AxisAlignedBB> list2 = this._a(this.__aU._a._a(d, d2, d3));
        for (n3 = 0; n3 < list2.size(); ++n3) {
            d2 = list2.get(n3)._b(this.__aU._a, d2);
        }
        this.__aU._a._d(0.0, d2, 0.0);
        n3 = this.__aU._x || d11 != d2 && d11 < 0.0 ? 1 : 0;
        for (n2 = 0; n2 < list2.size(); ++n2) {
            d = list2.get(n2)._a(this.__aU._a, d);
        }
        this.__aU._a._d(d, 0.0, 0.0);
        for (n2 = 0; n2 < list2.size(); ++n2) {
            d3 = list2.get(n2)._c(this.__aU._a, d3);
        }
        this.__aU._a._d(0.0, 0.0, d3);
        if (this.__aU._f > 0.0f && n3 != 0 && (bl || this.__aU._d < 0.05f) && (d10 != d || d12 != d3)) {
            d6 = d;
            d5 = d2;
            d4 = d3;
            d = d10;
            d2 = this.__aU._f;
            d3 = d12;
            AxisAlignedBB axisAlignedBB2 = this.__aU._a._c();
            this.__aU._a._c(axisAlignedBB);
            list2 = this._a(this.__aU._a._a(d10, d2, d12));
            for (n = 0; n < list2.size(); ++n) {
                d2 = list2.get(n)._b(this.__aU._a, d2);
            }
            this.__aU._a._d(0.0, d2, 0.0);
            for (n = 0; n < list2.size(); ++n) {
                d = list2.get(n)._a(this.__aU._a, d);
            }
            this.__aU._a._d(d, 0.0, 0.0);
            for (n = 0; n < list2.size(); ++n) {
                d3 = list2.get(n)._c(this.__aU._a, d3);
            }
            this.__aU._a._d(0.0, 0.0, d3);
            d2 = -this.__aU._f;
            for (n = 0; n < list2.size(); ++n) {
                d2 = list2.get(n)._b(this.__aU._a, d2);
            }
            this.__aU._a._d(0.0, d2, 0.0);
            if (d6 * d6 + d4 * d4 >= d * d + d3 * d3) {
                d = d6;
                d2 = d5;
                d3 = d4;
                this.__aU._a._c(axisAlignedBB2);
            }
        }
        this.__aU._j = (this.__aU._a._b + this.__aU._a._e) / 2.0;
        this.__aU._k = this.__aU._a._c + (double)this.__aU._e - (double)this.__aU._d;
        this.__aU._l = (this.__aU._a._d + this.__aU._a._g) / 2.0;
        this.__aU._u = d10 != d || d12 != d3;
        this.__aU._v = d11 != d2;
        this.__aU._x = d11 != d2 && d11 < 0.0;
        this.__aU._w = this.__aU._u || this.__aU._v;
        this.__aU._a(d2, this.__aU._x);
        if (d10 != d) {
            this.__aU._m = 0.0;
        }
        if (d11 != d2) {
            this.__aU._n = 0.0;
        }
        if (d12 != d3) {
            this.__aU._o = 0.0;
        }
        d6 = this.__aU._j - d7;
        d5 = this.__aU._k - d8;
        d4 = this.__aU._l - d9;
        if (this._o() && !bl && !this.__aU._e()) {
            int n4;
            int n5 = sajh._c(this.__aU._j);
            n = sajh._c(this.__aU._k - (double)0.2f - (double)this.__aU._e);
            int n6 = sajh._c(this.__aU._l);
            int n7 = this._a().getBlockId(n5, n, n6);
            if (n7 == 0 && ((n4 = this._a().blockGetRenderType(n5, n - 1, n6)) == 11 || n4 == 32 || n4 == 21)) {
                n7 = this._a().getBlockId(n5, n - 1, n6);
            }
            if (n7 != Block.ladder.blockID) {
                d5 = 0.0;
            }
            this.__aU._r = (float)((double)this.__aU._r + (double)sajh._a(d6 * d6 + d4 * d4) * 0.6);
            this.__aU._s = (float)((double)this.__aU._s + (double)sajh._a(d6 * d6 + d5 * d5 + d4 * d4) * 0.6);
            if (this.__aU._s > (float)this.__aU._t && n7 > 0) {
                this.__aU._t = (int)this.__aU._s + 1;
                if (this._h()) {
                    float f = sajh._a(this.__aU._m * this.__aU._m * (double)0.2f + this.__aU._n * this.__aU._n + this.__aU._o * this.__aU._o * (double)0.2f) * 0.35f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    this.__bE.playSound("liquid.swim", f, 1.0f + (this.__bE.rand.nextFloat() - this.__bE.rand.nextFloat()) * 0.4f);
                }
                this._b(n5, n, n6, n7);
                Block.blocksList[n7].onEntityWalking(this._a(), n5, n, n6, this.__bE);
            }
        }
        this._I();
    }

    private void _b(int n, int n2, int n3, int n4) {
        StepSound stepSound = Block.blocksList[n4].stepSound;
        if (this._a().getBlockId(n, n2 + 1, n3) == Block.snow.blockID) {
            stepSound = Block.snow.stepSound;
            this.__bE.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
        } else if (!Block.blocksList[n4].blockMaterial._d()) {
            this.__bE.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
        }
    }

    private void _I() {
        int n = sajh._c(this.__aU._a._b + 0.001);
        int n2 = sajh._c(this.__aU._a._c + 0.001);
        int n3 = sajh._c(this.__aU._a._d + 0.001);
        int n4 = sajh._c(this.__aU._a._e - 0.001);
        int n5 = sajh._c(this.__aU._a._f - 0.001);
        int n6 = sajh._c(this.__aU._a._g - 0.001);
        if (this._a().checkChunksExist(n, n2, n3, n4, n5, n6)) {
            for (int i = n; i <= n4; ++i) {
                for (int j = n2; j <= n5; ++j) {
                    for (int k = n3; k <= n6; ++k) {
                        int n7 = this._a().getBlockId(i, j, k);
                        Block block = Block.blocksList[n7];
                        if (block == null) continue;
                        Block.blocksList[n7].onEntityCollidedWithBlock(this._a(), i, j, k, this.__bE);
                    }
                }
            }
        }
    }

    public boolean _k() {
        int n = sajh._c(this.__aU._j);
        int n2 = sajh._c(this.__aU._a._c);
        int n3 = sajh._c(this.__aU._l);
        int n4 = this._a().getBlockId(n, n2, n3);
        Block block = Block.blocksList[n4];
        return block != null && block.isLadder(this._a(), n, n2, n3, this.__bE);
    }

    private float _b(float f, float f2, float f3, boolean bl, boolean bl2) {
        double d;
        float f4;
        float f5;
        float f6;
        int n;
        if (this.__aU._x && !this._T) {
            n = this._a().getBlockId(sajh._c(this.__aU._j), sajh._c(this.__aU._a._c) - 1, sajh._c(this.__aU._l));
            f6 = n > 0 ? Block.blocksList[n].slipperiness * 0.91f : 0.546f;
            if (this.__aL._a && this._d && __aV.isJumpingEnabled(0, 0)) {
                f3 *= ((Float)tvcu.__aV._sprintJumpVerticalFactor.value).floatValue();
            }
        } else {
            f6 = 0.91f;
        }
        if (this._e && this._d()) {
            this.__aU._a(0.0f, -1.0f, 0.07f);
        } else if (this._e && this._e()) {
            if (this._k()) {
                this.__aU._a(0.0f, -1.0f, 0.09f);
            } else {
                this.__aU._a(0.0f, -1.0f, 0.09f);
            }
        } else if (this._e && this._f()) {
            this.__aU._a(0.0f, -1.0f, 0.07f);
        } else if (!this._u) {
            float f7;
            if (this._s) {
                f3 *= ((Float)tvcu.__aV._headJumpControlFactor.value).floatValue();
            } else if (tvcu.__aV.enabled && !this.__aU._x && !this.__aU._d() && !this._v) {
                f3 *= ((Float)tvcu.__aV._jumpControlFactor.value).floatValue();
            }
            f5 = 0.1627714f / (f6 * f6 * f6);
            f4 = this.__aU._x ? this._E() * f5 : this.__aU._p;
            float f8 = f7 = this.__aU._g() ? f4 / 1.3f : f4;
            if (__aV.isRunningEnabled() && this._z() && !this._d) {
                f3 *= ((Float)tvcu.__aV._runFactor.value).floatValue();
            }
            this.__aU._a(f2, f, f7 * f3);
        }
        if (this.__aU._x && !this._T) {
            n = this._a().getBlockId(sajh._c(this.__aU._j), sajh._c(this.__aU._a._c) - 1, sajh._c(this.__aU._l));
            if (n > 0) {
                f4 = Block.blocksList[n].slipperiness;
                if (this._u) {
                    f6 = 1.0f / ((1.0f / f4 - 1.0f) / 25.0f * ((Float)tvcu.__aV._slideSlipperinessFactor.value).floatValue() + 1.0f) * 0.98f;
                    if (f2 != 0.0f && ((Float)tvcu.__aV._slideControlDegrees.value).floatValue() > 0.0f && !Double.isNaN(d = -Math.atan(this.__aU._m / this.__aU._o))) {
                        if (this.__aU._o < 0.0) {
                            d += Math.PI;
                        }
                        double d2 = Math.sqrt(this.__aU._m * this.__aU._m + this.__aU._o * this.__aU._o);
                        this.__aU._m = d2 * -Math.sin(d -= (double)(((Float)tvcu.__aV._slideControlDegrees.value).floatValue() / 57.295776f * Math.signum(f2)));
                        this.__aU._o = d2 * Math.cos(d);
                    }
                } else {
                    f6 = f4 * 0.91f;
                }
            } else {
                f6 = 0.546f;
            }
        } else {
            f6 = this.__aa ? 0.999f : 0.91f;
        }
        if (!bl && !bl2) {
            if (__aV.isFreeClimbAutoLaddderEnabled() && f > 0.0f && (d = this.__aU._a._c - (double)(n = sajh._c(this.__aU._a._c))) < 0.1) {
                int n2 = sajh._c(this.__aU._j);
                int n3 = sajh._c(this.__aU._l);
                if (Orientation.isLadder(this._a().getBlockId(n2, n - 1, n3))) {
                    this.__aU._n = Math.max(this.__aU._n, 0.0);
                }
            }
        } else {
            boolean bl3;
            f5 = 0.15f;
            if (this.__aU._m < (double)(-f5)) {
                this.__aU._m = -f5;
            }
            if (this.__aU._m > (double)f5) {
                this.__aU._m = f5;
            }
            if (this.__aU._o < (double)(-f5)) {
                this.__aU._o = -f5;
            }
            if (this.__aU._o > (double)f5) {
                this.__aU._o = f5;
            }
            boolean bl4 = bl3 = !this._e && bl && !__aV.isTotalFreeLadderClimb() || bl2 && !__aV.isTotalFreeVineClimb();
            if (bl3) {
                this.__aU._k();
                this.__aU._n = Math.max(this.__aU._n, -0.15 * (double)this._G());
            }
            if (__aV.isFreeBaseClimb()) {
                if (this.__aM._a && this.__aU._n < 0.0 && !this.__aU._x && bl3) {
                    this.__aU._n = 0.0;
                }
            } else if (this.__aU._h() && this.__aU._n < 0.0) {
                this.__aU._n = 0.0;
            }
        }
        return f6;
    }

    private void _a(boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        this._J();
        boolean bl5 = bl4 = bl || bl2;
        if (__aV.isStandardBaseClimb() && this.__aU._u && bl4) {
            this.__aU._n = 0.2 * (double)this._G();
        }
        if (__aV.isSimpleBaseClimb() && this.__aU._u && bl4) {
            int n = sajh._c(this.__aU._j);
            int n2 = sajh._c(this.__aU._a._c);
            int n3 = sajh._c(this.__aU._l);
            boolean bl6 = Orientation.isClimbable(this._a(), n, n2, n3);
            boolean bl7 = Orientation.isClimbable(this._a(), n, n2 + 1, n3);
            this.__aU._n = bl6 && bl7 ? 0.2 : (bl6 ? 0.2 : (bl7 ? 0.1 : 0.0));
            this.__aU._n *= (double)this._G();
        }
        if (__aV.isSmartBaseClimb() || __aV.isFreeClimbingEnabled()) {
            boolean bl8;
            boolean bl9;
            boolean bl10;
            double d = this.__aU._j;
            double d2 = this.__aU._a._c;
            double d3 = this.__aU._l;
            int n = sajh._c(d);
            int n4 = sajh._c(d2);
            int n5 = sajh._c(d3);
            if (__aV.isSmartBaseClimb() && bl4 && this.__aU._u) {
                bl10 = Orientation.isClimbable(this._a(), n, n4, n5);
                bl9 = Orientation.isClimbable(this._a(), n, n4 + 1, n5);
                if (bl10 && bl9) {
                    this.__aU._n = 0.2;
                } else if (bl10) {
                    boolean bl11 = bl8 = Orientation.PZ.isHandsLadderSubstitute(this._a(), n, n4 + 1, n5) || Orientation.NZ.isHandsLadderSubstitute(this._a(), n, n4 + 1, n5) || Orientation.ZP.isHandsLadderSubstitute(this._a(), n, n4 + 1, n5) || Orientation.ZN.isHandsLadderSubstitute(this._a(), n, n4 + 1, n5);
                    this.__aU._n = bl8 ? 0.2 : 0.1;
                } else if (bl9) {
                    boolean bl12 = bl8 = Orientation.ZZ.isFeetLadderSubstitute(this._a(), n, n4, n5) || Orientation.PZ.isFeetLadderSubstitute(this._a(), n, n4, n5) || Orientation.NZ.isFeetLadderSubstitute(this._a(), n, n4, n5) || Orientation.ZP.isFeetLadderSubstitute(this._a(), n, n4, n5) || Orientation.ZN.isFeetLadderSubstitute(this._a(), n, n4, n5);
                    this.__aU._n = bl8 ? 0.2 : 0.1;
                } else {
                    this.__aU._n = 0.0;
                }
                this.__aU._n *= (double)this._G();
            }
            if (__aV.isFreeClimbingEnabled() && this.__aU._j() <= ((Float)tvcu.__aV._freeClimbFallMaximumDistance.value).floatValue() && (!bl4 || __aV.isFreeBaseClimb())) {
                bl10 = !__aV.isClimbExhaustionEnabled() || this.__ag <= ((Float)tvcu.__aV._climbExhaustionStop.value).floatValue() && (bl3 || this.__ag <= ((Float)tvcu.__aV._climbExhaustionStart.value).floatValue());
                bl9 = false;
                if (this._C || this._D) {
                    if (__aV.isClimbExhaustionEnabled()) {
                        this.__ak = Math.min(this.__ak, ((Float)tvcu.__aV._climbExhaustionStop.value).floatValue());
                        this.__al = Math.min(this.__al, ((Float)tvcu.__aV._climbExhaustionStart.value).floatValue());
                    }
                    if (bl10) {
                        bl9 = true;
                    }
                }
                if (bl9) {
                    int n6;
                    int n7;
                    float f;
                    boolean bl13 = bl8 = this._t || this._u;
                    if (this._k || this._l || bl8) {
                        d2 += -1.0;
                    }
                    if ((f = this.__aU._B % 360.0f) < 0.0f) {
                        f += 360.0f;
                    }
                    double d4 = d2 * 2.0 + 1.0;
                    HandsClimbing handsClimbing = HandsClimbing.None;
                    FeetClimbing feetClimbing = FeetClimbing.None;
                    tvcu.__bC[0] = handsClimbing;
                    tvcu.__bD[0] = feetClimbing;
                    __bA.reset();
                    __bB.reset();
                    Orientation.PZ.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                    Orientation.NZ.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                    Orientation.ZP.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                    Orientation.ZN.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                    handsClimbing = __bC[0];
                    feetClimbing = __bD[0];
                    this._N = handsClimbing != HandsClimbing.None || feetClimbing != FeetClimbing.None;
                    this._Q = tvcu.__bA.CanStand || tvcu.__bB.CanStand;
                    boolean bl14 = this._R = tvcu.__bA.MustCrawl || tvcu.__bB.MustCrawl;
                    if (!bl8) {
                        Orientation.PP.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                        Orientation.NP.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                        Orientation.NN.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                        Orientation.PN.seekClimbGap(f, this._a(), n, d, d4, n5, d3, this._k, this._l, bl8, __bC, __bD, __bA, __bB);
                    }
                    handsClimbing = __bC[0];
                    feetClimbing = __bD[0];
                    this._O = tvcu.__bA.CanStand || tvcu.__bB.CanStand;
                    boolean bl15 = this._P = tvcu.__bA.MustCrawl || tvcu.__bB.MustCrawl;
                    if (handsClimbing == HandsClimbing.BottomHold && Orientation.isLadder(this._a().getBlockId(n, n4 + 2, n5))) {
                        Orientation orientation = Orientation.getKnownLadderOrientation(this._a(), n, n4 + 2, n5);
                        n7 = n + orientation._i;
                        n6 = n5 + orientation._k;
                        if (!this._a().getBlockMaterial(n7, n4, n6)._a() && !this._a().getBlockMaterial(n7, n4 + 1, n6)._a()) {
                            handsClimbing = HandsClimbing.None;
                        }
                    }
                    if (!this.__aN._a && handsClimbing == HandsClimbing.Up && feetClimbing == FeetClimbing.None && !this.__aU._u && this._a().isAirBlock(n, n4, n5) && this._a().isAirBlock(n, n4 + 1, n5)) {
                        handsClimbing = HandsClimbing.None;
                    }
                    if (feetClimbing.IsRelevant() || handsClimbing.IsRelevant()) {
                        if (this._C) {
                            if (this._u && handsClimbing.IsRelevant()) {
                                this._u = false;
                                this._t = true;
                            }
                            handsClimbing = handsClimbing.ToUp();
                            if (!(feetClimbing != FeetClimbing.FastUp || handsClimbing == HandsClimbing.None && this.__aU._x && tvcu.__bB.BlockId != Block.bed.blockID)) {
                                this._a(0.2, 0, 1);
                            } else if ((this._O || this._P) && handsClimbing == HandsClimbing.FastUp && (feetClimbing == FeetClimbing.None || feetClimbing == FeetClimbing.BaseWithHands)) {
                                this._a(feetClimbing == FeetClimbing.None ? 0.1 : 0.2, 2, 1);
                            } else if (!(!feetClimbing.IsRelevant() || !handsClimbing.IsRelevant() || feetClimbing == FeetClimbing.BaseHold && handsClimbing == HandsClimbing.Sink || handsClimbing == HandsClimbing.Sink && feetClimbing == FeetClimbing.TopWithHands || handsClimbing == HandsClimbing.TopHold && feetClimbing == FeetClimbing.TopWithHands)) {
                                this._a(0.14, !(!this._O && !this._P || handsClimbing == HandsClimbing.Sink && feetClimbing == FeetClimbing.BaseWithHands) ? 2 : 1, 1);
                            } else if (handsClimbing.IsUp()) {
                                this._c(0.1);
                            } else if (handsClimbing != HandsClimbing.TopHold && feetClimbing != FeetClimbing.BaseHold && (feetClimbing != FeetClimbing.SlowUpWithHoldWithoutHands || handsClimbing != HandsClimbing.None)) {
                                if (handsClimbing == HandsClimbing.Sink || feetClimbing == FeetClimbing.SlowUpWithSinkWithoutHands && handsClimbing == HandsClimbing.None) {
                                    this._c(0.05);
                                }
                            } else if (!this.__aL._c || !(this._h = this._a(n7 = feetClimbing != FeetClimbing.None ? 5 : 6, null, null, null))) {
                                if (!(handsClimbing == HandsClimbing.Sink && feetClimbing == FeetClimbing.BaseHold || handsClimbing == HandsClimbing.TopHold && feetClimbing == FeetClimbing.TopWithHands)) {
                                    this._c(0.08);
                                } else {
                                    this._a(0.08, 2, 1);
                                }
                            }
                        } else if (this._D) {
                            if ((handsClimbing = handsClimbing.ToDown()) == HandsClimbing.BottomHold && !feetClimbing.IsIndependentlyRelevant()) {
                                this._c(0.08);
                            } else if (handsClimbing.IsRelevant()) {
                                if (feetClimbing == FeetClimbing.FastUp) {
                                    this._a(0.01, 0, 1);
                                } else if (feetClimbing == FeetClimbing.SlowUpWithHoldWithoutHands) {
                                    this._c(0.01);
                                } else if (feetClimbing == FeetClimbing.TopWithHands) {
                                    this._c(0.01);
                                } else if (feetClimbing != FeetClimbing.BaseWithHands && feetClimbing != FeetClimbing.BaseHold) {
                                    this._a(0.05, handsClimbing == HandsClimbing.FastUp ? 2 : 1, 0);
                                } else if (!(handsClimbing != HandsClimbing.None && handsClimbing != HandsClimbing.Up || handsClimbing == HandsClimbing.Up && feetClimbing == FeetClimbing.BaseHold)) {
                                    this._c(0.05);
                                } else {
                                    this._c(0.01);
                                }
                            }
                            if (this._M) {
                                this._d(0.08);
                                if (this.__aL._c) {
                                    int n8 = n6 = feetClimbing != FeetClimbing.None ? 1 : 0;
                                    int n9 = !((Boolean)tvcu.__aV._climbJumpBackHeadOnGrab.value == false ? this.__aN._a : !this.__aN._a) ? (n6 != 0 ? 9 : 10) : (n6 != 0 ? 7 : 8);
                                    n7 = n9;
                                    float f2 = this.__aU._B + 180.0f;
                                    if (this._a(n7, null, null, Float.valueOf(f2))) {
                                        this.__bn = !this._s;
                                        this._e = false;
                                        this.__aU._B = f2;
                                        this._c();
                                    }
                                }
                            }
                        }
                        if (this._e) {
                            this._d(((Float)tvcu.__aV._freeClimbFallDamageStartDistance.value).floatValue(), ((Float)tvcu.__aV._freeClimbFallDamageFactor.value).floatValue());
                        }
                        if (this._C || this._D) {
                            if (handsClimbing == HandsClimbing.None) {
                                this._w = 0;
                            } else if (feetClimbing == FeetClimbing.None) {
                                this._x = 0;
                            }
                            this.__ab = tvcu.__bA.BlockId;
                            this.__ac = tvcu.__bA.Meta;
                            this.__ad = tvcu.__bB.BlockId;
                            this.__ae = tvcu.__bB.Meta;
                        }
                    }
                }
                this._f = this._e && this.__ab == Block.vine.blockID;
                this._g = this._e && this.__ad == Block.vine.blockID;
                this._K = this._f || this._g;
                this._J = !(!this._K || this.__ab != -1 && this.__ab != Block.vine.blockID || this.__ad != -1 && this.__ad != Block.vine.blockID);
            }
        }
    }

    private void _f(boolean bl) {
        boolean bl2;
        boolean bl3 = !__aV.isCeilingClimbExhaustionEnabled() || this.__ag <= ((Float)tvcu.__aV._ceilingClimbExhaustionStop.value).floatValue() && (bl || this.__ag <= ((Float)tvcu.__aV._ceilingClimbExhaustionStart.value).floatValue());
        boolean bl4 = !__aV.isFreeClimbingEnabled() && this._t && !this.__aC;
        boolean bl5 = bl2 = this._G && !this._e && (!this._t || bl4) && !this._l;
        if (bl2 && __aV.isCeilingClimbExhaustionEnabled()) {
            this.__ak = Math.min(this.__ak, ((Float)tvcu.__aV._ceilingClimbExhaustionStop.value).floatValue());
            this.__al = Math.min(this.__al, ((Float)tvcu.__aV._ceilingClimbExhaustionStart.value).floatValue());
        }
        if (bl2 && bl3) {
            boolean bl6;
            double d = this.__aU._j;
            double d2 = this.__aU._a._f + (double)(bl4 ? 1.0f : 0.0f);
            double d3 = this.__aU._l;
            int n = sajh._c(d);
            int n2 = sajh._c(d2);
            int n3 = sajh._c(d3);
            int n4 = this._a(n, n2, n3);
            int n5 = this._a(n, n2 + 1, n3);
            boolean bl7 = n4 > -1;
            boolean bl8 = bl6 = n5 > -1;
            if (bl7 || bl6) {
                double d4 = 1.0 - d2 + (double)n2;
                if (bl6) {
                    d4 += 1.0;
                }
                double d5 = this._b(d2, d2 + 0.6, 0.2);
                if (d4 < 1.9 && d5 < d2 + 0.5) {
                    this.__aU._n = d4 > 1.2 ? 0.12 : (d4 > 1.115 ? 0.08 : 0.04);
                    this.__aU._k();
                    this._m = true;
                    int n6 = this.__ab = bl7 ? n4 : n5;
                }
            }
        }
        if (this._m && bl4) {
            this._t = false;
            this._L();
            this._b(0.0, 1.0, 0.0, true);
        }
    }

    private void _f(float f) {
        this.__aU._n -= 0.08;
        this.__aU._n *= (double)0.98f;
        this.__aU._m *= (double)f;
        this.__aU._o *= (double)f;
    }

    private void _k(double d, double d2, double d3) {
        float f = 0.0f;
        if (tvcu.__aV.enabled) {
            float f2;
            boolean bl;
            boolean bl2 = this._z();
            boolean bl3 = Math.abs(d2) < 0.007;
            boolean bl4 = bl = this._H && bl3;
            if (!this.__aU._e()) {
                float f3;
                float f4 = sajh._a(d * d + d3 * d3);
                f2 = sajh._a((double)(f4 * f4) + d2 * d2);
                int n = Math.round(f2 * 100.0f);
                if (__aV.isHungerGainEnabled()) {
                    f3 = __aV.getFactor(true, this.__aU._x, this._H, bl, this._c, bl2, this._d, this._e, this._k, this._m, this._o, this._p, this._q, this._t, this._l);
                    f += ((Float)tvcu.__aV._alwaysHungerGain.value).floatValue() + (float)n * 1.0E-4f * f3;
                }
                f3 = 0.0f;
                if (this.__aQ) {
                    f3 += __aV.getConcentrationExhaustion();
                }
                if (this._e && !bl && __aV.isClimbExhaustionEnabled()) {
                    float f5 = ((Float)tvcu.__aV._baseExhautionGainFactor.value).floatValue();
                    f5 = bl3 ? (f5 *= ((Float)tvcu.__aV._climbStrafeExhaustionGain.value).floatValue()) : (!this._H ? (this._C ? (f5 *= ((Float)tvcu.__aV._climbStrafeUpExhaustionGain.value).floatValue()) : (this._D ? (f5 *= ((Float)tvcu.__aV._climbStrafeDownExhaustionGain.value).floatValue()) : (f5 *= 0.0f))) : (this._C ? (f5 *= ((Float)tvcu.__aV._climbUpExhaustionGain.value).floatValue()) : (this._D ? (f5 *= ((Float)tvcu.__aV._climbDownExhaustionGain.value).floatValue()) : (f5 *= 0.0f))));
                    f3 += f5;
                }
                if (this._m && !this._H && __aV.isCeilingClimbExhaustionEnabled()) {
                    f3 += ((Float)tvcu.__aV._baseExhautionGainFactor.value).floatValue() * ((Float)tvcu.__aV._ceilingClimbExhaustionGain.value).floatValue();
                }
                if (this._d && __aV.isSprintExhaustionEnabled()) {
                    if (f3 == 0.0f) {
                        f3 = ((Float)tvcu.__aV._baseExhautionGainFactor.value).floatValue();
                    }
                    f3 *= ((Float)tvcu.__aV._sprintExhaustionGainFactor.value).floatValue();
                }
                if (this._z() && __aV.isRunExhaustionEnabled()) {
                    if (f3 == 0.0f) {
                        f3 = ((Float)tvcu.__aV._baseExhautionGainFactor.value).floatValue();
                    }
                    f3 *= ((Float)tvcu.__aV._runExhaustionGainFactor.value).floatValue();
                }
                f3 += this.__ap;
                if (this.__ao > 0.0f) {
                    f3 += this.__ao * ((Float)tvcu.__aV._baseExhautionGainFactor.value).floatValue();
                    if (this.__aq == Float.MAX_VALUE) {
                        this.__aq = __aV.getMaximumExhaustion();
                    }
                    this.__ak = Math.min(this.__ak, this.__aq);
                    if (this.__ar == Float.MAX_VALUE) {
                        this.__ar = __aV.getMaximumExhaustion();
                    }
                    this.__al = Math.min(this.__al, this.__ar);
                }
                this.__ag += f3 / this.__bG;
            } else {
                f = -1.0f;
            }
            if (this.__ag > 0.0f) {
                boolean bl5;
                if (__aV.isExhaustionLossHungerEnabled()) {
                    // empty if block
                }
                if (bl5 = true) {
                    f2 = __aV.getFactor(false, this.__aU._x, this._H, bl, this._c, bl2, this._d, this._e, this._k, this._m, this._o, this._p, this._q, this._t, this._l);
                    float f6 = 1.0f * f2;
                    this.__ag -= f6 / this.__bG * this.__bH;
                    if (__aV.isExhaustionLossHungerEnabled()) {
                        f += ((Float)tvcu.__aV._exhaustionLossHungerFactor.value).floatValue() * f6;
                    }
                }
            }
            if (this.__ag < 0.0f) {
                this.__ag = 0.0f;
            }
            if (this.__ag == 0.0f) {
                this.__al = Float.NaN;
                this.__ak = Float.NaN;
            }
            if (this.__ak == Float.MAX_VALUE) {
                this.__ak = this.__am;
            }
            if (this.__al == Float.MAX_VALUE) {
                this.__al = this.__an;
            }
            this.__ao = 0.0f;
            this.__ap = 0.0f;
            this.__aq = Float.MAX_VALUE;
            this.__ar = Float.MAX_VALUE;
        } else {
            f = -1.0f;
        }
        if (!this._a().isRemote) {
            this.__bE.addExhaustion(f);
        }
    }

    public float _l() {
        return this.__ag;
    }

    public float _m() {
        return this.__ah;
    }

    public float _n() {
        return this.__ai;
    }

    public void _a(float f) {
        if (!Float.isNaN(f) && f > 0.0f) {
            this.__ao += f;
        }
    }

    public void _b(float f) {
        if (!Float.isNaN(f) && f >= 0.0f) {
            this.__aq = Math.min(this.__aq, f);
        }
    }

    public void _c(float f) {
        if (!Float.isNaN(f) && f >= 0.0f) {
            this.__ar = Math.min(this.__ar, f);
        }
    }

    private void _g(boolean bl) {
        if (this.__aN._a) {
            this._h(bl);
        }
        if (this._z != 0.0f && this.__aU._i()) {
            this._M();
        }
    }

    private void _h(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this._p || this._q;
        if (bl && !bl2 && !this.__aU._i()) {
            this._g(-1.0f);
            double d = this._a(this.__aU._a._c - 1.0, this.__aU._a._c, 0.0);
            double d2 = this._c(this.__aU._a._f, this.__aU._a._f + 1.1);
            double d3 = this._b(this.__aU._a._f, this.__aU._a._f + 1.1, 0.0);
            this._L();
            if (d3 - d < (double)this.__aU._b) {
                this._t = true;
                this._o = false;
                this._g(-1.0f);
            } else if (d2 - d < (double)this.__aU._b) {
                this._t = true;
                this.__bj = true;
                this._o = false;
                this._g(-1.0f);
            } else if (d > this.__aU._a._c) {
                if (this._c && d > this.__aU._a._c + 0.5) {
                    this._t = true;
                    this._o = false;
                    this._g(-1.0f);
                }
                this._b(0.0, d - this.__aU._a._c, 0.0, true);
            }
        }
    }

    public boolean _o() {
        return !this._e && !this._q;
    }

    private void _J() {
        this._e = false;
        this._f = false;
        this._g = false;
        this._J = false;
        this._K = false;
        this._L = false;
        this._N = false;
        this._w = 0;
        this._x = 0;
        this._m = false;
    }

    private void _K() {
        this._S = -1.0f;
        this._o = false;
        this._p = false;
        this._q = false;
        this._r = false;
        this._V = false;
        this._W = false;
        this._U = false;
    }

    private void _c(double d) {
        this._a(d, 1, 1);
    }

    private void _a(double d, int n, int n2) {
        this._d(d);
        this._w = n;
        this._x = n2;
    }

    private void _d(double d) {
        boolean bl;
        this._e = true;
        if (this.__br > 0) {
            d = 0.08;
        }
        if (d != 0.08) {
            float f = this._G();
            if (this._d) {
                f *= ((Float)tvcu.__aV._sprintFactor.value).floatValue();
            }
            if (__aV.isFreeBaseClimb() && d == 0.14) {
                switch (this._a(Integer.MAX_VALUE, false, this._k)) {
                    case 1: {
                        f *= ((Float)tvcu.__aV._freeOneLadderClimbUpSpeedFactor.value).floatValue();
                        break;
                    }
                    case 2: {
                        f *= ((Float)tvcu.__aV._freeBothLadderClimbUpSpeedFactor.value).floatValue();
                    }
                }
            }
            d = d > 0.08 ? (d - 0.08) * (double)((Float)tvcu.__aV._freeClimbingUpSpeedFactor.value).floatValue() * (double)f + 0.08 : 0.08 - (0.08 - d) * (double)((Float)tvcu.__aV._freeClimbingDownSpeedFactor.value).floatValue() * (double)f;
            if (this._P && this._k && d > 0.08) {
                d = Math.min(0.17, d);
            }
        } else {
            this._L = true;
        }
        boolean bl2 = bl = d < 0.0 || d > this.__aU._n;
        if (bl) {
            this.__aU._n = d;
        }
        this._h = !bl && !this._M;
    }

    public boolean _p() {
        return this._c(this._k);
    }

    public void _d(double d, double d2, double d3) {
        this.__aY = this.__aU._j;
        this.__aZ = this.__aU._l;
        this.__ba = this.__aU._k;
        if (this.__aM._a || this.__bx) {
            this.__aU._d = !(this._p || this._q || this._t || this._e || !__aV.isSneakingEnabled() && !this._x()) ? (this._c ? 0.6f : 0.0f) : 0.0f;
        }
        if (this._u || this._t) {
            this.__bb = this.__aU._r;
            this.__aU._r = Float.MIN_VALUE;
        }
        if (this.__bm) {
            int n = this._c(d, d2, d3);
            this.__bc = Utilities.getHorizontalCollisionangle((n & 0x10) != 0, (n & 0x20) != 0, (n & 1) != 0, (n & 2) != 0);
        }
    }

    public void _e(double d, double d2, double d3) {
        if (this._u || this._t) {
            this.__aU._r = this.__bb;
        }
        if (this._z != 0.0f) {
            this.__aU._k += (double)this._z;
        }
        this.__av = this.__aU._x;
        double d4 = this.__aU._j - this.__aY;
        double d5 = this.__aU._l - this.__aZ;
        double d6 = this.__aU._k - this.__ba;
        double d7 = sajh._a(d4 * d4 + d5 * d5 + d6 * d6);
        if (this._e || this._m) {
            this.__aE = (float)((double)this.__aE + d7 * (this._e ? 1.2 : 0.9));
            if (this.__aE > (float)this.__bw) {
                StepSound stepSound;
                Block block;
                int n = this._e ? (this.__ab == -1 ? (this.__ad == -1 ? Block.cobblestone.blockID : this.__ad) : (this.__ad == -1 ? this.__ab : (this.__bw % 2 != 0 ? this.__ad : this.__ab))) : this.__ab;
                ++this.__bw;
                if (n >= 0 && n < Block.blocksList.length && (block = Block.blocksList[n]) != null && (stepSound = Block.blocksList[n].stepSound) != null) {
                    this.__bE.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
                }
            }
        }
        if (this._p) {
            this.__aX = (float)((double)this.__aX + d7);
            if (this.__aX > 1.4285715f) {
                Random random = this.__bE.getRNG();
                this.__bE.playSound("random.splash", 0.05f, 1.0f + (random.nextFloat() - random.nextFloat()) * 0.4f);
                this.__aX -= 1.0f;
            }
        }
    }

    public void _d(int n, int n2, int n3) {
    }

    private void _L() {
        this.__aU._a._c += (double)this._z;
        this.__aU._b -= this._z;
        this._z = 0.0f;
    }

    private void _M() {
        this.__aU._b -= this._z;
        this._z = 0.0f;
    }

    private void _g(float f) {
        this._L();
        if (f != 0.0f) {
            this._z = f;
            this.__aU._a._c -= (double)this._z;
            this.__aU._b += this._z;
        }
    }

    public boolean _f(double d, double d2, double d3) {
        if (this._B > 0) {
            return false;
        }
        boolean bl = false;
        if (this._z != 0.0f) {
            bl = this.__aU._b > 1.0f;
        }
        return this._a(d, d2, d3, bl);
    }

    public void _q() {
        this.__bo = this.__aU._u;
        this._T = false;
    }

    public void _r() {
        this._a(this._p || this._q || this._o || this._t, this._p);
        float f = this._E();
        if (tvcu.__aV.enabled) {
            float f2 = f;
            if (this._d || this._Z || this._z()) {
                if (this.__aU._g()) {
                    f2 = f / 1.3f;
                }
                if (!this._d && !this._Z) {
                    if (this._z()) {
                        f2 *= 1.3f * ((Float)tvcu.__aV._perspectiveRunFactor.value).floatValue();
                    }
                } else {
                    f2 *= ((Float)tvcu.__aV._perspectiveSprintFactor.value).floatValue();
                }
            }
            this.__bd = this.__bd != -1.0f ? (this.__bd += (f2 - this.__bd) * ((Float)tvcu.__aV._perspectiveFadeFactor.value).floatValue()) : f;
        }
        if (this.__aU._f()) {
            this.__ag = 0.0f;
        }
        if (this.__aU._d() || this._e) {
            this.__aU._k();
        }
        this.__bl = this.__aU._u ? ++this.__bl : 0;
        if (this.__be) {
            // empty if block
        }
        this.__be = false;
    }

    public void _s() {
        this.__aw = this.__aU._d();
    }

    public void _t() {
    }

    public void _u() {
        if (this.__aj && !this.__aL._a) {
            this.__aj = false;
        }
        if (!this._p && !this._q) {
            boolean bl;
            boolean bl2 = bl = this.__bq && this.__aU._x && this.__aL._a && !this._h() && !this._H();
            if (!bl || this.__aU._a._c - this._a(this.__aU._a._c - 0.2, this.__aU._a._c, 0.0) < 0.01) {
                int n;
                boolean bl3;
                this.__bf = this.__aU._m;
                this.__bg = this.__aU._o;
                boolean bl4 = false;
                if (__aV.isJumpChargingEnabled()) {
                    bl3 = this.__aU._x && this._H;
                    bl4 = bl3 && this._I;
                    int n2 = n = bl3 && ((Boolean)tvcu.__aV._jumpChargeCancelOnSneakRelease.value == false || this._I) ? 1 : 0;
                    if (n != 0) {
                        if (this.__aL._a && (((Boolean)tvcu.__aV._jumpChargeCancelOnSneakRelease.value).booleanValue() || this._I)) {
                            this.__ah += 1.0f;
                        } else {
                            if (this.__ah > 0.0f) {
                                this._a(1, null, null, null);
                            }
                            this.__ah = 0.0f;
                        }
                    } else {
                        if (this.__ah > 0.0f) {
                            this.__aj = true;
                        }
                        this.__ah = 0.0f;
                    }
                }
                bl3 = false;
                if (__aV.isHeadJumpingEnabled()) {
                    boolean bl5 = bl3 = this.__aN._a && (this._Y || this._Z || this._z() && this.__aU._x) && !this._t;
                    if (bl3) {
                        if (this.__aL._a) {
                            this.__ai += 1.0f;
                        } else {
                            if (this.__ai > 0.0f && this.__aU._x) {
                                this._a(3, null, null, null);
                            }
                            this.__ai = 0.0f;
                        }
                    } else {
                        if (this.__ai > 0.0f) {
                            this.__aj = true;
                        }
                        this.__ai = 0.0f;
                    }
                }
                if (this.__aL._a && this._h() && this._o) {
                    double d = this.__aU._k - (double)sajh._c(this.__aU._k);
                    double d2 = this._c ? 0.37 : 0.6;
                    if (d > d2) {
                        this.__aU._n -= (double)0.04f;
                        if (!this._X && this.__aU._x && this.__ah == 0.0f && this._a(0, true, null, null)) {
                            Random random = this.__bE.getRNG();
                            this.__bE.playSound("random.splash", 0.05f, 1.0f + (random.nextFloat() - random.nextFloat()) * 0.4f);
                        }
                    }
                }
                if (!(!bl || this.__aj || bl4 || bl3 || this._K)) {
                    this._a(0, false, null, null);
                }
                n = 0;
                int n3 = 0;
                if (this.__bs == -1) {
                    ++n;
                }
                if (this.__bt == -1) {
                    --n;
                }
                if (this.__bu == -1) {
                    ++n3;
                }
                if (n != 0 || n3 != 0) {
                    int n4 = n > 0 ? (n3 == 0 ? 270 : 225) : (n < 0 ? (n3 == 0 ? 90 : 135) : 180);
                    if (this._a(2, null, null, Float.valueOf(this.__aU._B + (float)n4))) {
                        this._y = (360 - n4) / 45 % 8;
                    }
                    this.__bs = 0;
                    this.__bt = 0;
                    this.__bu = 0;
                }
            }
        }
    }

    public void _v() {
        if (this.__bm && !Double.isNaN(this.__bc)) {
            float f;
            float f2;
            int n;
            if (this.__aN._a) {
                if (this.__aU._j() > ((Float)tvcu.__aV._wallHeadJumpFallMaximumDistance.value).floatValue()) {
                    return;
                }
                n = this.__bo ? 14 : 12;
            } else {
                if (this.__aU._j() > ((Float)tvcu.__aV._wallUpJumpFallMaximumDistance.value).floatValue()) {
                    return;
                }
                n = this.__bo ? 13 : 11;
            }
            if (!this.__bo) {
                f2 = Utilities.getAngle(this.__bg, -this.__bf);
                if (Double.isNaN(f2)) {
                    return;
                }
                f = this.__bc * 2.0f - f2 + 180.0f;
            } else {
                f = this.__bc;
            }
            while (f > 360.0f) {
                f -= 360.0f;
            }
            if (((Float)tvcu.__aV._wallUpJumpOrthogonalTolerance.value).floatValue() != 0.0f) {
                for (f2 = f; f2 > 45.0f; f2 -= 90.0f) {
                }
                if (Math.abs(f2) < ((Float)tvcu.__aV._wallUpJumpOrthogonalTolerance.value).floatValue()) {
                    f = (float)Math.round(f / 90.0f) * 90.0f;
                }
            }
            if (this._a(n, null, null, Float.valueOf(f))) {
                this.__bn = !this._s;
                this.__aU._u = false;
                this.__aU._B = f;
                this._a(Float.valueOf(f));
            }
        }
    }

    public boolean _a(int n, Boolean bl, Boolean bl2, Float f) {
        boolean bl3 = false;
        if (n == 13 || n == 14) {
            n = n == 13 ? 11 : 12;
            bl3 = true;
        }
        boolean bl4 = bl != null ? bl : this._o;
        boolean bl5 = bl2 != null ? bl2.booleanValue() : this._z();
        boolean bl6 = n == 1;
        boolean bl7 = true;
        if (n != 0 && n != 1 && n != 3 && n != 5 && n != 6 && n != 7 && n != 8 && n != 9 && n != 10 && n != 2 && n != 11 && n != 12) {
            bl7 = false;
        }
        boolean bl8 = n == 3 || n == 9 || n == 10 || n == 12;
        int n2 = tvcu._a(this._H, this._c, bl5, this._d, f);
        boolean bl9 = __aV.isJumpingEnabled(n2, n);
        if (bl9) {
            float f2;
            double d;
            double d2;
            double d3;
            double d4;
            float f3;
            float f4;
            boolean bl10 = __aV.isJumpExhaustionEnabled(n2, n);
            if (bl10) {
                f4 = __aV.getJumpExhaustionStop(n2, n, this.__ah);
                if (this.__ag > f4) {
                    return false;
                }
                this.__al = Math.min(this.__al, f4);
                this.__ak = Math.min(this.__ak, f4 + __aV.getJumpExhaustionGain(n2, n, this.__ah));
            }
            f4 = 1.0f;
            float f5 = __aV.getJumpHorizontalFactor(n2, n) * f4;
            float f6 = __aV.getJumpVerticalFactor(n2, n) * f4;
            float f7 = f3 = bl6 ? __aV.getJumpChargeFactor(this.__ah) : 1.0f;
            if (!bl7) {
                f5 = sajh._c(f5 * f5 + f6 * f6);
                f6 = 0.0f;
            }
            Double d5 = null;
            double d6 = sajh._a(this.__bf * this.__bf + this.__bg * this.__bg);
            double d7 = -0.078 + 0.498 * (double)f6 * (double)f3;
            if (f5 > 1.0f && !this.__aU._u) {
                d5 = (double)__aV.getMaxHorizontalMotion(n2, n, bl4) * (double)this._G();
            }
            if (bl8) {
                d4 = Math.atan(d7 / d6);
                d3 = Math.sqrt(d7 * d7 + d6 * d6);
                d2 = (double)__aV.getHeadJumpFactor(this.__ai) * d4;
                d = d3 * Math.sin(d2);
                double d8 = d3 * Math.cos(d2);
                if (d5 != null) {
                    d5 = d5 * (d8 / d6);
                }
                d7 = d;
                d6 = d8;
            }
            if (f != null) {
                f2 = f.floatValue() / 57.295776f;
                boolean bl11 = n == 11 || n == 12;
                d3 = Math.max(d6, (double)f5);
                d2 = -Math.sin(f2);
                d = Math.cos(f2);
                this.__aU._m = tvcu._a(this.__bf, d2, bl11, d3, f5);
                this.__aU._o = tvcu._a(this.__bg, d, bl11, d3, f5);
                d6 = 0.0;
                d7 = f6;
            }
            if (d6 > 0.0) {
                d4 = Math.abs(this.__aU._m) * (double)f5;
                d3 = Math.abs(this.__aU._o) * (double)f5;
                if (d5 != null) {
                    d4 = Math.min(d4, d5 * (double)f5 * (Math.abs(this.__aU._m) / d6));
                    d3 = Math.min(d3, d5 * (double)f5 * (Math.abs(this.__aU._o) / d6));
                }
                this.__aU._m = Math.signum(this.__aU._m) * d4;
                this.__aU._o = Math.signum(this.__aU._o) * d3;
            }
            if (bl7 && !bl3) {
                this.__aU._n = d7;
                this._Z = this._d;
            }
            if (bl10) {
                f2 = __aV.getJumpExhaustionGain(n2, n, this.__ah);
                this.__ag += f2;
            }
            if (bl8) {
                this._s = true;
                this._g(-1.0f);
            }
            this.__aU._y = true;
            this._T = true;
        }
        return bl9;
    }

    private static double _a(double d, double d2, boolean bl, double d3, float f) {
        return !bl ? d + d2 * d3 : (Math.signum(d) != Math.signum(d2) ? d2 * (double)f : Math.max(Math.abs(d), Math.abs(d2) * d3) * Math.signum(d2));
    }

    private static int _a(boolean bl, boolean bl2, boolean bl3, boolean bl4, Float f) {
        bl3 &= f == null;
        if (bl4 &= f == null) {
            return 0;
        }
        if (bl3) {
            return 1;
        }
        if (bl2) {
            return 3;
        }
        if (bl) {
            return 4;
        }
        return 2;
    }

    private void _N() {
        if (this._z < 0.0f) {
            boolean bl;
            double d = this._i();
            boolean bl2 = bl = d < 1.0;
            if (!bl) {
                this._L();
            } else {
                boolean bl3;
                double d2 = bl ? this._j() : -1.0;
                boolean bl4 = bl3 = d + d2 >= 1.0;
                if (bl3) {
                    this._e(d);
                } else {
                    this._f(d);
                }
            }
        }
    }

    private void _b(boolean bl, boolean bl2) {
        if (this._z < 0.0f) {
            boolean bl3;
            double d = this._i();
            boolean bl4 = d < 1.0;
            double d2 = bl4 ? this._j() : -1.0;
            boolean bl5 = bl3 = d + d2 >= 1.0;
            if (bl && bl4 && bl3) {
                this._v = false;
                this.__aU._a(false);
                bl2 = true;
            }
            if (bl2) {
                if (!bl4 && !this.__aM._a) {
                    this._L();
                } else if (!(!bl3 || this.__aM._a && this.__aN._a)) {
                    this._e(d);
                } else {
                    this._f(d);
                }
            }
        }
    }

    private void _e(double d) {
        this._b(0.0, 1.0 - d, 0.0, true);
        this._t = false;
        this._s = false;
        this._L();
    }

    private void _f(double d) {
        this._b(0.0, -d, 0.0, true);
        if (__aV.isSlidingEnabled() && (this.__aN._a || this.__aD)) {
            this._u = true;
        } else {
            this.__aC = this._P();
        }
    }

    private void _d(float f, float f2) {
        if (this.__aU._j() >= f) {
            this.__aE = this.__bw;
        }
        this.__aU._a(0.0f);
    }

    public void _w() {
        if (this._a().isRemote) {
            this._A = false;
            this._B = 5;
        }
    }

    public void _a(flys flys2, boolean bl) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        this.__bq = false;
        this.__am = this.__ak;
        this.__an = this.__al;
        this.__ak = Float.MAX_VALUE;
        this.__al = Float.MAX_VALUE;
        boolean bl12 = this.__aU._d() && !this._v;
        boolean bl13 = this._z();
        boolean bl14 = false;
        if (!(this._A || this._a().isRemote && this._B != 0 || this.__aU._e())) {
            if (this._a(this.__aU._a._c, this.__aU._a._f, 0.0) > this.__aU._a._c) {
                bl14 = true;
                this._P();
            }
            this._A = true;
        }
        if (this._B > 0) {
            --this._B;
        }
        if (!flys2._e) {
            this._X = false;
        }
        this.__aU._z = !(!flys2._e || this._t || this._u || __aV.isHeadJumpingEnabled() && this.__aN._a && this.__aU._g() || __aV.isJumpChargingEnabled() && this._I && this.__aU._x && this._H || this.__aj);
        boolean bl15 = this.__aU._e();
        boolean bl16 = this.__aU._i();
        boolean bl17 = !tvcu.__aV.enabled || bl15 || bl16;
        this.__aH._a(flys2._a);
        this.__aI._a(flys2._b);
        this.__aJ._a(flys2._c);
        this.__aK._a(flys2._d);
        this.__aL._a(flys2._e);
        this.__aO._a(flys2._f);
        this.__aM._a(flys2._g);
        this.__aN._a(flys2._h);
        this.__aP._a(flys2._i);
        this.__bh = flys2._j;
        this.__bi = flys2._k;
        this.__aU._z = !(!flys2._e || this._t || this._u || __aV.isHeadJumpingEnabled() && this.__aN._a && this.__aU._g() || __aV.isJumpChargingEnabled() && this._I && this.__aU._x && this._H || this.__aj);
        double d = this.__aU._m * this.__aU._m + this.__aU._o * this.__aU._o;
        boolean bl18 = false;
        double d2 = -1.0;
        if (this._t || this._k) {
            d2 = this._a(this.__aU._a._c - (bl14 ? 0.0 : 1.0), this.__aU._a._c, (Boolean)tvcu.__aV._crawlOverEdge.value != false ? 0.0 : -0.05);
            double d3 = this._b(this.__aU._a._f, this.__aU._a._f + 1.1, 0.0);
            boolean bl19 = bl18 = d3 - d2 < (double)(this.__aU._b - this._z);
        }
        if (this.__aU._d() && (__aV.isFlyingEnabled() || __aV.isLevitateSmallEnabled())) {
            bl18 = false;
        }
        boolean bl20 = __aV.isCrawlToggleEnabled() ? this.__by : (bl11 = this.__aM._a || !__aV.isFreeClimbingEnabled() && this.__aN._a);
        if (this.__bj) {
            if (!(bl11 || this._h() || bl18)) {
                double d4;
                if (this._t && (d4 = this._c(this.__aU._a._f, this.__aU._a._f + 1.1)) - d2 >= (double)(this.__aU._b + 1.0f)) {
                    this.__bj = false;
                }
            } else {
                this.__bj = false;
            }
        }
        boolean bl21 = this.__aP._c && this.__aU._x && this.__aF <= 0;
        boolean bl22 = !this.__aU._d() && (this._t && (bl11 || this.__bj) || bl21);
        boolean bl23 = __aV.isCrawlingEnabled() && bl22;
        boolean bl24 = !this._p && !this._q && (!this._o || this._S + this._z < 0.65f) && !this._e && this.__aU._j() < ((Float)tvcu.__aV._fallingDistanceMinimum.value).floatValue();
        this.__aC = this._t;
        boolean bl25 = this._t = bl24 && (bl23 || bl18);
        if (!this._t) {
            this.__bj = false;
        }
        if (this.__aC && !this._t && this.__aU._d()) {
            this._a(0, null, null, null);
        }
        this._F = (this._F || this.__aN._c && !this.__aC) && this.__aN._a && this.__bh > 0.0f && this._t && this.__aU._u;
        boolean bl26 = this._b(this._k);
        boolean bl27 = (this.__aN._a || this._M && this.__aM._a || __aV.isFreeClimbAutoLaddderEnabled() && this._a(this._k) || __aV.isFreeClimbAutoVineEnabled() && bl26) && (!this._u || this.__aN._a && this.__bh > 0.0f) && !this._s && !this._F && !bl17;
        boolean bl28 = bl10 = __aV.isFreeClimbingEnabled() && bl27;
        if (!bl10 || this.__aU._v) {
            this._h = false;
        }
        if (this.__aU._w) {
            this._i = false;
        }
        this._C = bl10 && this.__bh > 0.0f || this._K && this.__aL._a && (!this.__aM._a || !bl26) && (!this._t || this.__aU._u) && (!this._u || this.__aU._u);
        this._D = bl10 && this.__bh <= 0.0f && !bl23;
        this._G = __aV.isCeilingClimbingEnabled() && this.__aN._a && !this._F && !this._x() && !bl17;
        boolean bl29 = false;
        boolean bl30 = this._v;
        boolean bl31 = this._v = __aV.isFlyingEnabled() && this.__aU._d();
        if (this._v && !bl30) {
            this._g(-1.0f);
        } else if (!this._v && bl30) {
            bl29 = true;
        }
        if (!__aV.isFlyingEnabled() && __aV.isLevitateSmallEnabled()) {
            if (bl12 && !this.__aB) {
                this._g(-1.0f);
            } else if (!bl12 && this.__aB) {
                bl29 = true;
            }
        }
        this.__aD = this._s;
        boolean bl32 = this._s = this._s && !this.__aU._x && !this._p && !this._q && !this._v && !this.__aU._d() && (!this._h() || this.__aU._n >= 0.0) && !this._H();
        if (!this._s) {
            this.__aa = false;
        }
        if (this.__aD && !this._s && this.__aU._x) {
            this._d(((Float)tvcu.__aV._headFallDamageStartDistance.value).floatValue(), ((Float)tvcu.__aV._headFallDamageFactor.value).floatValue());
            bl29 = true;
        }
        boolean bl33 = bl9 = this._v && (Boolean)tvcu.__aV._flyCloseToGround.value == false && d < 0.003 && this.__aU._n > -0.03;
        if (bl29 || bl9) {
            this._b(bl9, bl29);
        }
        if (this._u && this.__aU._j() > 0.05f) {
            this._u = false;
            this._s = true;
            this.__aa = true;
        }
        if (__aV.isSlidingEnabled() && this.__aN._a && (this._Y || this.__aA && !bl13 && this.__aU._x) && !this._t && this.__aM._c && !this._o) {
            this._g(-1.0f);
            this._b(0.0, -1.0, 0.0, true);
            this._a(4, false, (Boolean)this.__aA, null);
            this._u = true;
            this._s = false;
            this.__aa = false;
        }
        if (this._u && (!this.__aM._a || d < (double)((Float)tvcu.__aV._slidingSpeedStopFactor.value).floatValue() * 0.01)) {
            this._u = false;
            this.__aC = this._P();
        }
        if (this._u && this.__aU._j() > ((Float)tvcu.__aV._fallingDistanceMinimum.value).floatValue()) {
            this._u = false;
            this.__aC = true;
            this._t = false;
        }
        boolean bl34 = __aV.isSneakToggleEnabled() ? this.__bx || this.__aM._c : this.__aM._a;
        boolean bl35 = !(this._v || this._u || this._s || this._q && (Boolean)tvcu.__aV._diveDownOnSneak.value != false || this._p && (Boolean)tvcu.__aV._swimDownOnSneak.value != false && !this._W || !bl34 || bl23 || bl18 || __aV.isCrawlingEnabled() && this.__aN._a);
        boolean bl36 = __aV.isSneakingEnabled() && bl35;
        boolean bl37 = this.__bh != 0.0f || this.__bi != 0.0f;
        boolean bl38 = this.__bh > 0.0f;
        this._E = __aV.isSprintingEnabled() && !this._u && this.__aO._a && (bl38 || this._e || this._p && (bl37 || this.__aM._a && (Boolean)tvcu.__aV._swimDownOnSneak.value != false) || this._q && (bl37 || this.__aL._a || this.__aM._a && (Boolean)tvcu.__aV._diveDownOnSneak.value != false) || this._v && (bl37 || this.__aL._a || this.__aM._a)) && !bl17;
        boolean bl39 = bl8 = !__aV.isRunExhaustionEnabled() || this.__ag < ((Float)tvcu.__aV._runExhaustionStop.value).floatValue() && (this.__aA || this.__ag < ((Float)tvcu.__aV._runExhaustionStart.value).floatValue());
        if (bl13 && this.__aU._x && __aV.isRunExhaustionEnabled()) {
            this.__ak = Math.min(this.__ak, ((Float)tvcu.__aV._runExhaustionStop.value).floatValue());
            this.__al = Math.min(this.__al, ((Float)tvcu.__aV._runExhaustionStart.value).floatValue());
        }
        if (!bl8 && bl13) {
            bl13 = false;
            this.__aU._b(false);
        }
        if (!(this.__aU._x || !this._d || this._e || this._m || this._q || this._p)) {
            this._Z = true;
        }
        boolean bl40 = bl7 = !__aV.isSprintExhaustionEnabled() || this.__ag <= ((Float)tvcu.__aV._sprintExhaustionStop.value).floatValue() && (this._d || this._Z || this.__ag <= ((Float)tvcu.__aV._sprintExhaustionStart.value).floatValue());
        if (this.__aU._x || this._v || this._p || this._q || this._H()) {
            this._Z = false;
        }
        boolean bl41 = false;
        if (this._E && !bl36) {
            if (!this._Z && __aV.isSprintExhaustionEnabled()) {
                this.__ak = Math.min(this.__ak, ((Float)tvcu.__aV._sprintExhaustionStop.value).floatValue());
                this.__al = Math.min(this.__al, ((Float)tvcu.__aV._sprintExhaustionStart.value).floatValue());
            }
            if (bl7) {
                bl41 = true;
            }
        }
        boolean bl42 = true;
        boolean bl43 = bl41 && ((Boolean)tvcu.__aV._sprintDuringItemUsage.value != false || this.__bI <= 0);
        boolean bl44 = bl43 && !this.__aU._v;
        boolean bl45 = bl43 && this.__bl < 3;
        boolean bl46 = bl45 && bl44;
        boolean bl47 = this._Y;
        this._Y = bl45 && (this.__aU._x || this.__aG <= 5) && !this._p && !this._q && !this._e;
        boolean bl48 = bl45 && this._p;
        boolean bl49 = bl46 && this._q;
        boolean bl50 = bl45 && this._m;
        boolean bl51 = bl46 && this._v;
        boolean bl52 = bl43 && this._e && bl42;
        boolean bl53 = this._d = this._Y || bl52 || bl48 || bl49 || bl50 || bl51 || bl52;
        if (this._Y && !bl47) {
            this.__bp = this.__aU._g();
        } else if (!bl47 || !this._Y) {
            // empty if block
        }
        this._I = bl35 && !this._E && !this._e;
        boolean bl54 = this._c;
        this._c = bl36 && this._I;
        boolean bl55 = this._M && this.__aM._a || this._e && bl || bl10 && !this._p && !this._q && !this._t && (this.__aM._a || this.__by);
        this._M = bl55 && this._e;
        this._H = d < 5.0E-4;
        boolean bl56 = this._l;
        boolean bl57 = this._l = !(!this.__aC && !this._l || !this._e || !this._N || !this.__aM._a && !this.__by || !(this.__bh > 0.0f));
        if (this._l) {
            boolean bl58 = bl6 = !this._a(this.__aU._a._c - (this._k ? 0.95 : 1.0), this.__aU._a._c);
            if (bl6) {
                bl56 = false;
                this._l = false;
                if (!this._k) {
                    this._L();
                }
            }
            if (!bl56) {
                this.__aC = false;
                this._t = false;
            }
        } else if (bl56) {
            boolean bl59 = bl6 = this.__aM._a || this.__by;
            if (!this._e) {
                this.__aC = this._P();
                double d5 = this.__aU._a._c;
                this._b(0.0, -d5 + Math.floor(d5), 0.0, true);
            } else if (this.__bh <= 0.0f) {
                this.__aC = bl6;
                this._t = bl6;
                this._C = false;
                this._D = false;
                if (!bl6) {
                    this._L();
                }
                double d6 = this.__aU._a._c;
                this._b(0.0, -d6 + Math.floor(d6) + (double)(bl6 ? 0.0f : 1.0f), 0.0, true);
            } else if (!bl6) {
                this._L();
                double d7 = this.__aU._a._c;
                this._b(0.0, Math.ceil(d7) - d7, 0.0, true);
            }
        }
        bl6 = this._k;
        boolean bl60 = this._P || this._O && this._M;
        boolean bl61 = bl5 = bl55 && this._C;
        if (this.__br > 1) {
            --this.__br;
        } else if (this._k && !bl60 && this.__br == 0) {
            this.__br = 6;
        }
        boolean bl62 = this._k = bl5 && (bl60 && this.__br == 0 || this.__br > 1);
        if (this._k && !bl6) {
            this._g(-1.0f);
            bl4 = this.__aU._u;
            this._b(0.0, 0.05, 0.0, true);
            this.__aU._u = bl4;
        } else if (!this._k && bl6) {
            this.__br = 0;
            if (!(bl18 || this.__aM._a || this.__by)) {
                this._L();
            } else {
                double d8 = this.__aU._a._c - this._a(this.__aU._a._c - 1.0, this.__aU._a._c, 0.0);
                if (d8 >= 0.0 && d8 < 1.0) {
                    this.__aC = this._P();
                    this._b(0.0, -d8, 0.0, true);
                } else {
                    this._L();
                }
            }
        }
        if (this.__aC && !this._t && !bl14 && !this.__aU._d()) {
            this._L();
            this._b(0.0, d2 - this.__aU._a._c, 0.0, true);
        } else if (this._t && !this.__aC || bl14) {
            this._g(-1.0f);
            this._b(0.0, -1.0, 0.0, true);
            if (bl14) {
                this.__aC = this._P();
            }
        }
        if (this.__aN._c) {
            if (this._V && bl27) {
                this._L();
                this._b(0.0, this._a(this.__aU._a._c, this.__aU._a._f, 0.0) - this.__aU._a._c, 0.0, true);
                if (this.__aL._a) {
                    this._X = true;
                }
            } else if (this._o && bl22 && this._S >= 0.55f) {
                if (this._S >= 0.6f) {
                    this._g(-1.0f);
                    this._b(0.0, -1.6f + this._S, 0.0, true);
                    this._t = false;
                } else {
                    this._g(-1.0f);
                    this._b(0.0, -1.0, 0.0, true);
                    this.__aC = this._P();
                }
            }
        }
        this._j = false;
        if (this.__bn && (this.__aU._x || this._e || !this.__aL._a)) {
            this.__bn = false;
        }
        bl4 = __aV.isWallJumpEnabled() && !this._s && !this.__aU._x && !this._e && !this._p && !this._q && !bl12 && !this._v;
        boolean bl63 = false;
        if (((Boolean)tvcu.__aV._wallJumpDoubleClick.value).booleanValue()) {
            if (bl4) {
                if (this.__aL._c) {
                    if (this.__bv == 0) {
                        this.__bv = __aV.wallJumpDoubleClickTicks();
                    } else {
                        bl63 = true;
                        this.__bv = 0;
                    }
                } else if (this.__bv > 0) {
                    --this.__bv;
                }
            } else {
                this.__bv = 0;
            }
        } else {
            bl63 = this.__aL._c;
        }
        this.__bm = bl4 && (bl63 || this.__bn || this.__bm && this.__aL._a && !this.__aU._u);
        boolean bl64 = !bl16 && this.__aU._x && !this._t && !this._e && !this._k && !this._p && !this._q;
        boolean bl65 = __aV.isSideJumpEnabled() && bl64;
        boolean bl66 = bl65 && !this.__aJ._a;
        boolean bl67 = bl65 && !this.__aI._a;
        boolean bl68 = bl3 = __aV.isBackJumpEnabled() && bl64 && !this.__aH._a && !this._y();
        if (bl66) {
            if (this.__aI._c) {
                this.__bs = this.__bs == 0 ? __aV.angleJumpDoubleClickTicks() : -1;
            } else if (this.__bs > 0) {
                --this.__bs;
            }
        } else {
            this.__bs = 0;
        }
        if (bl67) {
            if (this.__aJ._c) {
                this.__bt = this.__bt == 0 ? __aV.angleJumpDoubleClickTicks() : -1;
            } else if (this.__bt > 0) {
                --this.__bt;
            }
        } else {
            this.__bt = 0;
        }
        if (bl3) {
            if (this.__aK._c) {
                this.__bu = this.__bu == 0 ? __aV.angleJumpDoubleClickTicks() : -1;
            } else if (this.__bu > 0) {
                --this.__bu;
            }
        } else {
            this.__bu = 0;
        }
        if (this.__bt == -2 && this.__bu <= 0) {
            this.__bt = -1;
        }
        if (this.__bs == -2 && this.__bu <= 0) {
            this.__bs = -1;
        }
        if (this.__bu == -2 && (this.__bs <= 0 || this.__bt <= 0)) {
            this.__bu = -1;
        }
        if (this.__bt == -1 && this.__bu > 0) {
            this.__bt = -2;
        }
        if (this.__bs == -1 && this.__bu > 0) {
            this.__bs = -2;
        }
        if (this.__bu == -1 && (this.__bs > 0 || this.__bt > 0)) {
            this.__bu = -2;
        }
        if (this.__aU._x || this.__aU._v) {
            this._y = 0;
        }
        this._n = Interface.isRopeSliding();
        boolean bl69 = __aV.isSneakToggleEnabled();
        boolean bl70 = __aV.isCrawlToggleEnabled();
        boolean bl71 = false;
        boolean bl72 = false;
        if (bl69 || bl70) {
            boolean bl73 = bl2 = this._t && (this.__aL._d || this.__aP._d && !this.__bz);
            if (bl2) {
                float f = ((Float)tvcu.__aV.crawlingEndMaxExhaustion.value).floatValue();
                if (this.__ag <= f) {
                    if (this.__aF <= 0) {
                        bl72 = true;
                        this._b(_b);
                        this.__ap += ((Float)tvcu.__aV.crawlingEndExhaustion.value).floatValue();
                    }
                } else {
                    this._e(f);
                }
            }
            if (!(this._t || this._l || this._k)) {
                bl71 = true;
            }
            bl71 |= bl72;
        }
        bl2 = false;
        if (bl69) {
            if (this._t && !bl72) {
                bl2 = true;
            }
            if (bl36 && this._E && this.__aM._c && this.__bx) {
                bl2 = true;
                this.__bk = true;
            }
            if (bl54 && this.__aM._c) {
                bl2 = true;
            }
            if (!this._p && !this._q && this.__aL._d) {
                bl2 = true;
            }
        }
        boolean bl74 = false;
        if (bl69) {
            if (bl72 && this.__aM._d) {
                bl74 = true;
            }
            if (this._d && this.__aM._d && !this.__bk) {
                bl74 = true;
            }
            if (this._c && !bl54) {
                bl74 = true;
            }
        }
        boolean bl75 = false;
        if (bl70) {
            if (this._t && !this.__aC) {
                bl75 = true;
            }
            if (this._k && !bl6) {
                bl75 = true;
            }
        }
        if (bl69) {
            if (bl74) {
                this.__bx = true;
            }
            if (bl2) {
                this.__bx = false;
            }
        }
        if (bl70) {
            if (bl75) {
                this.__by = true;
                this.__bz = this.__aP._a;
                this._b(_a);
                this._O();
            }
            if (bl71) {
                this.__by = false;
            }
        }
        if (this.__aM._d) {
            this.__bk = false;
        }
        if (this.__aP._d) {
            this.__bz = false;
        }
        this.__aG = this.__aU._x ? 0 : ++this.__aG;
        this.__aA = bl13;
        this.__aB = bl12;
    }

    private void _b(int n) {
        this.__aF = n;
    }

    private void _O() {
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> {
                Minecraft minecraft = Minecraft._E();
                Random random = minecraft._r.rand;
                minecraft._N._a("stalker:foley_fall_", 0.7f + random.nextFloat() * 0.3f, 0.9f + random.nextFloat() * 0.2f);
            });
        }
    }

    private boolean _P() {
        this._t = true;
        if (__aV.isCrawlToggleEnabled()) {
            this.__by = true;
        }
        this.__bz = true;
        return true;
    }

    public boolean _x() {
        return this._c && (this.__aU._x || this.__aU._F) || (Boolean)tvcu.__aV._sneak.value == false && this._I && this.__ah > 0.0f || (this.__aU._e() || !tvcu.__aV.enabled) && this.__aU._h() || (Boolean)tvcu.__aV._crawlOverEdge.value == false && this._t && !this._e;
    }

    public boolean _y() {
        return (this._d || this.__aU._g()) && this.__aU._x && !this._u && !this._t;
    }

    public boolean _z() {
        return this.__aU._g() && !this._d && this.__aU._x;
    }

    public void _A() {
        this.__bq = true;
    }

    public boolean _B() {
        return this.__aU._z;
    }

    public boolean _C() {
        return !__aV.isFlyingEnabled() && !__aV.isLevitationAnimationEnabled() ? false : this.__aU._d();
    }

    public boolean _D() {
        return !__aV.isFallAnimationEnabled() ? false : !this.__aU._x && this.__aU._j() > ((Float)tvcu.__aV._fallAnimationDistanceMinimum.value).floatValue();
    }

    public float _E() {
        return this.__bF;
    }

    public void _d(float f) {
    }

    public long _F() {
        boolean bl = this.__aU._b < 1.0f;
        long l = 0L;
        l |= this._n ? 1L : 0L;
        l <<= 1;
        l |= this._j ? 1L : 0L;
        l <<= 1;
        l |= this._d ? 1L : 0L;
        l <<= 1;
        l |= this._c ? 1L : 0L;
        l <<= 1;
        l |= this._i ? 1L : 0L;
        l <<= 1;
        l |= this._h ? 1L : 0L;
        l <<= 1;
        l |= this._f ? 1L : 0L;
        l <<= 1;
        l |= this._g ? 1L : 0L;
        l <<= 3;
        l |= (long)this._y;
        l <<= 1;
        l |= this._u ? 1L : 0L;
        l <<= 1;
        l |= this._s ? 1L : 0L;
        l <<= 1;
        l |= this._r ? 1L : 0L;
        l <<= 1;
        l |= this._m ? 1L : 0L;
        l <<= 1;
        l |= this._C() ? 1L : 0L;
        l <<= 1;
        l |= this._D() ? 1L : 0L;
        l <<= 1;
        l |= bl ? 1L : 0L;
        l <<= 1;
        l |= this._e ? 1L : 0L;
        l <<= 1;
        l |= this._t ? 1L : 0L;
        l <<= 1;
        l |= this._l ? 1L : 0L;
        l <<= 1;
        l |= this._p ? 1L : 0L;
        l <<= 1;
        l |= this._o ? 1L : 0L;
        l <<= 1;
        l |= this._q ? 1L : 0L;
        l <<= 1;
        l |= this.__aU._z ? 1L : 0L;
        l <<= 4;
        l |= (long)this._w;
        l <<= 4;
        return l |= (long)this._x;
    }

    public void _a(flys flys2, boolean bl, int n, boolean bl2, float f, float f2, float f3) {
        if (this.__aF > 0) {
            --this.__aF;
        }
        this.__aQ = flys2._l;
        this.__aU._b();
        this.__aU._a(this.__bE);
        if (Math.abs(this.__aU._m) < 0.005) {
            this.__aU._m = 0.0;
        }
        if (Math.abs(this.__aU._n) < 0.005) {
            this.__aU._n = 0.0;
        }
        if (Math.abs(this.__aU._o) < 0.005) {
            this.__aU._o = 0.0;
        }
        this.__aU._b(false);
        this.__bF = f;
        this.__bG = f2;
        this.__bH = f3;
        this.__bI = n;
        this.__aU._c(bl);
        this.__aU._e = 1.62f;
        this._q();
        if (this.__aU._A > 0) {
            --this.__aU._A;
        }
        this._s();
        this.__aU._F = !this.__aU._d() && (this._a().isMaterialInBB(this.__aU._a._b(-0.1f, -0.4f, -0.1f), Material._j) || this._a().isMaterialInBB(this.__aU._a._b(-0.1f, -0.4f, -0.1f), Material._F));
        this._a(flys2, bl2);
        if (this.__aU._z) {
            if (!this._h() && !this._H()) {
                if (this.__aU._x && this.__aU._A == 0) {
                    this.__bq = true;
                    this.__aU._A = 10;
                }
            } else {
                this.__aU._n += (double)0.04f;
            }
        } else {
            this.__aU._A = 0;
        }
        this.__bi *= 0.98f;
        this.__bh *= 0.98f;
        this._a(this.__bi, this.__bh);
        this._t();
        this._r();
        this.__ax = this.__aU._m;
        this.__ay = this.__aU._n;
        this.__az = this.__aU._o;
        if (!this._a().isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public void _e(float f) {
        this.__aS = System.currentTimeMillis();
        this.__aT = f;
    }

    public void _a(SmartMovingSelf smartMovingSelf) {
        smartMovingSelf.isSlow = this._c;
        smartMovingSelf.isFast = this._d;
        smartMovingSelf.isClimbing = this._e;
        smartMovingSelf.isHandsVineClimbing = this._f;
        smartMovingSelf.isFeetVineClimbing = this._g;
        smartMovingSelf.isClimbJumping = this._h;
        smartMovingSelf.isClimbBackJumping = this._i;
        smartMovingSelf.isWallJumping = this._j;
        smartMovingSelf.isClimbCrawling = this._k;
        smartMovingSelf.isCrawlClimbing = this._l;
        smartMovingSelf.isCeilingClimbing = this._m;
        smartMovingSelf.isRopeSliding = this._n;
        smartMovingSelf.isDipping = this._o;
        smartMovingSelf.isSwimming = this._p;
        smartMovingSelf.isDiving = this._q;
        smartMovingSelf.isLevitating = this._r;
        smartMovingSelf.isHeadJumping = this._s;
        smartMovingSelf.isCrawling = this._t;
        smartMovingSelf.isSliding = this._u;
        smartMovingSelf.isFlying = this._v;
        smartMovingSelf.actualHandsClimbType = this._w;
        smartMovingSelf.actualFeetClimbType = this._x;
        smartMovingSelf.angleJumpType = this._y;
        smartMovingSelf.heightOffset = this._z;
        smartMovingSelf.exhaustion = this.__ag;
        smartMovingSelf.jumpCharge = this.__ah;
        smartMovingSelf.headJumpCharge = this.__ai;
    }

    public void _a(zwat zwat2, int n) {
        Vec3 vec3 = this.__bE.worldObj.getWorldVec3Pool()._a(this.__aU._j, this.__aU._a._c, this.__aU._l);
        Vec3 vec32 = this.__bE.worldObj.getWorldVec3Pool()._a(this.__aU._m, this.__aU._n, this.__aU._o);
        Vec3 vec33 = zwat2._a(vec3, vec32, n);
        this.__aU._m = vec33._c;
        this.__aU._n = vec33._d;
        this.__aU._o = vec33._e;
    }

    private static class kjui {
        public boolean _a;
        public boolean _b;
        public boolean _c;
        public boolean _d;

        private kjui() {
        }

        public void _a(boolean bl) {
            this._b = this._a;
            this._a = bl;
            this._c = !this._b && this._a;
            this._d = this._b && !this._a;
        }
    }
}

