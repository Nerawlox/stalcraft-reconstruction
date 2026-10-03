/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class lqmc
extends nwsb {
    private int _a;
    private int _N;

    public lqmc(ywry ywry2, int n, int n2, int n3) {
        super(ywry2, n, n2);
        this._a = n3;
        this._N = 0;
        this._m();
    }

    public lqmc(ywry ywry2, int n, int n2, int n3, int n4) {
        super(ywry2, n, n2, n3, n4);
        this._a = 1;
    }

    @Override
    public void _a(String string, int n, int n2) {
    }

    @Override
    public void _a() {
        int n = this._A - this._o;
        this._d(this._l._d(this._b(), n));
        int n2 = this._b().substring(0, this._q).length();
        this._N = -(n2 -= this._l._d(this._b().substring(0, this._q), n).length());
    }

    @Override
    public void _b(int n, int n2) {
    }

    @Override
    public void _c(char c, int n) {
        int n2 = this._A - this._o;
        StringBuilder stringBuilder = new StringBuilder(this._b());
        if (this._b().length() > 0 && this._q > 0) {
            if (gqjz.func_73861_o() && ((byte)c == 127 || (byte)c == 8)) {
                int n3 = this._b().length();
                String string = this._b().substring(0, this._q);
                n3 = (string = string.replaceAll(" +", " ")).contains(" ") ? (n3 -= stringBuilder.delete(string.lastIndexOf(" "), this._q).length()) : (n3 -= stringBuilder.delete(0, this._q).length());
                this._c(stringBuilder.toString());
                this._e(this._q - n3);
                this._a();
                this._J = 0L;
                return;
            }
            if ((byte)c == 8) {
                stringBuilder.deleteCharAt(this._q - 1);
                this._c(stringBuilder.toString());
                this._e(this._q - 1);
                this._a();
                this._J = 0L;
                return;
            }
        }
        if (n == 203) {
            this._e(this._q - 1);
            this._a();
            return;
        }
        if (n == 205) {
            this._e(this._q + 1);
            this._a();
            return;
        }
        String string = this._l._d(this._b(), n2);
        int n4 = string.length() - string.replace(nwsb._f, "").length();
        if ((byte)c == 13) {
            if (n4 + 1 >= this._a) {
                return;
            }
            stringBuilder.insert(this._q, nwsb._f);
            this._c(stringBuilder.toString());
            this._a();
            this._e(this._q + 1);
            this._J = 0L;
            return;
        }
        if (this._b().length() >= this._m) {
            return;
        }
        if (!this._l._c.contains(c + "")) {
            return;
        }
        string = this._l._d(this._b() + c, n2);
        n4 = string.length() - string.replace(nwsb._f, "").length();
        if (n4 >= this._a) {
            return;
        }
        stringBuilder.insert(this._q, c);
        this._c(stringBuilder.toString());
        this._e(this._q + 1);
        this._a();
        this._J = 0L;
    }

    @Override
    public void _b(xpzm xpzm2, int n, int n2) {
        GL11.glTranslated(this._o / 4, -this._p / 4, 0.0);
        StringBuilder stringBuilder = new StringBuilder(this._c());
        this._J += System.currentTimeMillis() - this._K;
        if (this._l()) {
            stringBuilder.insert(this._c(this._q + this._N, 0, this._c().length()), this._J % 1000L < 600L ? "\t" : "");
        }
        this._l._b(stringBuilder.toString(), 0.0, 0.0, this._r);
        this._K = System.currentTimeMillis();
    }

    @Override
    public void _m() {
        float f = (float)this._l._a("D");
        float f2 = (float)this._l._b("D");
        float f3 = (float)this._n * f / 2.0f + (float)this._o;
        float f4 = f2 / 2.0f * (float)this._a;
        this._A = (int)f3;
        this._B = (int)f4;
    }
}

