/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ObjectArrays;
import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.jxtc;
import net.minecraft.util.tdpx;

public abstract class zhqo {
    public static final zhqo[] _a = new zhqo[256];
    public static final zhqo[] _b;
    public static final zhqo _c;
    public static final zhqo _d;
    public static final zhqo _e;
    public static final zhqo _f;
    public static final zhqo _g;
    public static final zhqo _h;
    public static final zhqo _i;
    public static final zhqo _j;
    public static final zhqo _k;
    public static final zhqo _l;
    public static final zhqo _m;
    public static final zhqo _n;
    public static final zhqo _o;
    public static final zhqo _p;
    public static final zhqo _q;
    public static final zhqo _r;
    public static final zhqo _s;
    public static final zhqo _t;
    public static final zhqo _u;
    public static final zhqo _v;
    public static final zhqo _w;
    public static final zhqo _x;
    public final int _y;
    public final int _z;
    public nvsz _A;
    public String _B;

    public zhqo(int n, int n2, nvsz nvsz2) {
        this._y = n;
        this._z = n2;
        this._A = nvsz2;
        if (_a[n] != null) {
            throw new IllegalArgumentException("Duplicate enchantment id!");
        }
        zhqo._a[n] = this;
    }

    public int _a() {
        return this._z;
    }

    public int _b() {
        return 1;
    }

    public int _c() {
        return 1;
    }

    public int _a(int n) {
        return 1 + n * 10;
    }

    public int _b(int n) {
        return this._a(n) + 5;
    }

    public int _a(int n, jxtc jxtc2) {
        return 0;
    }

    public float _a(int n, EntityLivingBase entityLivingBase) {
        return 0.0f;
    }

    public boolean _a(zhqo zhqo2) {
        return this != zhqo2;
    }

    public zhqo _a(String string) {
        this._B = string;
        return this;
    }

    public String _d() {
        return "enchantment." + this._B;
    }

    public String _c(int n) {
        String string = tdpx._a(this._d());
        return string + " " + tdpx._a("enchantment.level." + n);
    }

    public boolean _a(cvzo cvzo2) {
        return this._A._a(cvzo2._a());
    }

    public boolean _b(cvzo cvzo2) {
        return this._a(cvzo2);
    }

    public static void _b(zhqo zhqo2) {
        ObjectArrays.concat(_b, zhqo2);
    }

    public boolean _e() {
        return true;
    }

    static {
        _c = new igdi(0, 10, 0);
        _d = new igdi(1, 5, 1);
        _e = new igdi(2, 5, 2);
        _f = new igdi(3, 2, 3);
        _g = new igdi(4, 5, 4);
        _h = new ohua(5, 2);
        _i = new nerj(6, 2);
        _j = new ekyk(7, 1);
        _k = new neog(16, 10, 0);
        _l = new neog(17, 5, 1);
        _m = new neog(18, 5, 2);
        _n = new sdan(19, 5);
        _o = new nvtg(20, 2);
        _p = new sdai(21, 2, nvsz._g);
        _q = new wpmi(32, 10);
        _r = new xsot(33, 1);
        _s = new zhua(34, 5);
        _t = new sdai(35, 2, nvsz._h);
        _u = new dytw(48, 10);
        _v = new yene(49, 2);
        _w = new txbm(50, 2);
        _x = new ohrg(51, 1);
        ArrayList<zhqo> arrayList = new ArrayList<zhqo>();
        for (zhqo zhqo2 : _a) {
            if (zhqo2 == null) continue;
            arrayList.add(zhqo2);
        }
        _b = arrayList.toArray(new zhqo[0]);
    }
}

