/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;

public class supr {
    public int _a;
    public int _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    @SideOnly(value=Side.CLIENT)
    public boolean _f;
    public List<cvzo> _g;

    public supr(int n, int n2) {
        this(n, n2, 0);
    }

    public supr(int n, int n2, int n3) {
        this(n, n2, n3, false);
    }

    public supr(int n, int n2, int n3, boolean bl) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._e = bl;
        this._g = new ArrayList<cvzo>();
        this._g.add(new cvzo(tgdv.field_77771_aG));
    }

    public supr(supr supr2) {
        this._a = supr2._a;
        this._b = supr2._b;
        this._c = supr2._c;
        this._g = supr2._d();
    }

    public void _a(supr supr2) {
        if (this._a != supr2._a) {
            System.err.println("This method should only be called for matching effects!");
        }
        if (supr2._c > this._c) {
            this._c = supr2._c;
            this._b = supr2._b;
        } else if (supr2._c == this._c && this._b < supr2._b) {
            this._b = supr2._b;
        } else if (!supr2._e && this._e) {
            this._e = supr2._e;
        }
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public List<cvzo> _d() {
        return this._g;
    }

    public boolean _a(cvzo cvzo2) {
        boolean bl = false;
        for (cvzo cvzo3 : this._g) {
            if (!cvzo3._b(cvzo2)) continue;
            bl = true;
        }
        return bl;
    }

    public void _a(List<cvzo> list2) {
        this._g = list2;
    }

    public void _b(cvzo cvzo2) {
        boolean bl = false;
        for (cvzo cvzo3 : this._g) {
            if (!cvzo3._b(cvzo2)) continue;
            bl = true;
        }
        if (!bl) {
            this._g.add(cvzo2);
        }
    }

    public void _a(boolean bl) {
        this._d = bl;
    }

    public boolean _e() {
        return this._e;
    }

    public boolean _a(EntityLivingBase entityLivingBase) {
        if (this._b > 0) {
            if (hdpq._a[this._a]._b(this._b, this._c)) {
                this._b(entityLivingBase);
            }
            this._f();
        }
        return this._b > 0;
    }

    public int _f() {
        return --this._b;
    }

    public void _b(EntityLivingBase entityLivingBase) {
        if (this._b > 0) {
            hdpq._a[this._a]._a(entityLivingBase, this._c);
        }
    }

    public String _g() {
        return hdpq._a[this._a]._c();
    }

    public int hashCode() {
        return this._a;
    }

    public String toString() {
        String string = "";
        string = this._c() > 0 ? this._g() + " x " + (this._c() + 1) + ", Duration: " + this._b() : this._g() + ", Duration: " + this._b();
        if (this._d) {
            string = string + ", Splash: true";
        }
        return hdpq._a[this._a]._h() ? "(" + string + ")" : string;
    }

    public boolean equals(Object object) {
        if (!(object instanceof supr)) {
            return false;
        }
        supr supr2 = (supr)object;
        return this._a == supr2._a && this._c == supr2._c && this._b == supr2._b && this._d == supr2._d && this._e == supr2._e;
    }

    public qoac _a(qoac qoac2) {
        qoac2._a("Id", (byte)this._a());
        qoac2._a("Amplifier", (byte)this._c());
        qoac2._a("Duration", this._b());
        qoac2._a("Ambient", this._e());
        return qoac2;
    }

    public static supr _b(qoac qoac2) {
        byte by = qoac2._d("Id");
        byte by2 = qoac2._d("Amplifier");
        int n = qoac2._f("Duration");
        boolean bl = qoac2._o("Ambient");
        return new supr(by, n, by2, bl);
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(boolean bl) {
        this._f = bl;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _h() {
        return this._f;
    }
}

