/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.tdpx;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class thcx
implements cfqs {
    public Minecraft _w;
    public double _x = 0.0;
    public int _y;
    public int _z;
    public int _A;
    public int _B;
    protected boolean _C;
    protected boolean _D;
    protected boolean _E;
    protected ywry _F;
    protected thcx _G;
    protected int _H;
    protected int[] _I;

    public thcx(ywry ywry2, int n) {
        this._H = n;
        this._G = null;
        this._F = ywry2;
        this._C = true;
        this._E = true;
        this._D = true;
        this._I = new int[6];
        this._w = Minecraft._E();
    }

    @Override
    public double _e() {
        return this._x;
    }

    @Override
    public void _a(double d) {
        this._x = d;
    }

    public thcx _a(int[] nArray) {
        this._I = nArray;
        return this;
    }

    public thcx _b(boolean bl) {
        this._D = bl;
        return this;
    }

    public thcx _c(boolean bl) {
        this._E = bl;
        return this;
    }

    public boolean _f() {
        return this._E;
    }

    public void _d(int n) {
        this._H = n;
    }

    public int _g() {
        return this._H;
    }

    public thcx _d(boolean bl) {
        this._C = bl;
        this._F._c(this);
        if (!bl && this._F._U == this) {
            this._F._U = null;
        }
        return this;
    }

    public thcx _a(int n, int n2) {
        this._y = n;
        this._z = n2;
        return this;
    }

    public thcx _d(int n, int n2) {
        this._A = n;
        this._B = n2;
        return this;
    }

    protected boolean _h() {
        return this._j();
    }

    protected boolean _i() {
        return this._k();
    }

    @Override
    public boolean _j() {
        return this._G != null ? this._G._h() && this._C : this._C;
    }

    public boolean _k() {
        return this._G != null ? this._G._i() && this._D : this._D;
    }

    public boolean _e(int n, int n2) {
        return this._j() && this._g(n, n2) && this._k();
    }

    public boolean _f(int n, int n2) {
        return this._g(n, n2) && this._F._b(n, n2) == this;
    }

    @Override
    public boolean _g(int n, int n2) {
        return n >= this._y && n <= this._y + this._A && n2 >= this._z && n2 <= this._z + this._B;
    }

    public boolean _l() {
        return this._F._U == this && this._f() && this._j() && this._k();
    }

    public void _b(Minecraft minecraft, int n, int n2) {
    }

    public void _a(Minecraft minecraft, int n, int n2) {
        qozx._a(0, 0, this._I);
    }

    @Override
    public void _c(Minecraft minecraft, int n, int n2) {
        if (!this._j()) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslated(this._y, this._z, 0.0);
        GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
        this._a(minecraft, n, n2);
        this._b(minecraft, n, n2);
        GL11.glPopMatrix();
    }

    public void _m() {
    }

    public boolean _b(char c, int n) {
        boolean bl;
        boolean bl2 = this._G != null ? this._G._b(c, n) : (bl = this._k() && this._j());
        if (bl) {
            this._a(c, n);
        }
        return bl;
    }

    public boolean _b(int n, int n2, int n3) {
        boolean bl;
        boolean bl2 = this._G != null ? this._G._b(n, n2, n3) : (bl = this._k() && this._j());
        if (bl) {
            this._a(n, n2, n3);
        }
        return bl;
    }

    public void _a(char c, int n) {
    }

    public void _a(int n, int n2, int n3) {
        this._n();
    }

    public void _n() {
    }

    public void _o() {
    }

    public static String _b(String string) {
        return tdpx._a(string);
    }
}

