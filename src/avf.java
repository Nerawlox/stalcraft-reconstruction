/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class avf
extends avk {
    private final avi a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private String f = "";
    private int g = 32;
    private int h;
    private boolean i = true;
    private boolean j = true;
    private boolean o;
    private boolean p = true;
    private int q;
    private int r;
    private int s;
    private int t = 0xE0E0E0;
    private int u = 0x707070;
    private boolean v = true;

    public avf(avi par1FontRenderer, int par2, int par3, int par4, int par5) {
        this.a = par1FontRenderer;
        this.b = par2;
        this.c = par3;
        this.d = par4;
        this.e = par5;
    }

    public void a() {
        ++this.h;
    }

    public void a(String par1Str) {
        this.f = par1Str.length() > this.g ? par1Str.substring(0, this.g) : par1Str;
        this.e();
    }

    public String b() {
        return this.f;
    }

    public String c() {
        int i = this.r < this.s ? this.r : this.s;
        int j2 = this.r < this.s ? this.s : this.r;
        return this.f.substring(i, j2);
    }

    public void b(String par1Str) {
        int l;
        String s1 = "";
        String s2 = v.a(par1Str);
        int i = this.r < this.s ? this.r : this.s;
        int j2 = this.r < this.s ? this.s : this.r;
        int k = this.g - this.f.length() - (i - this.s);
        boolean flag = false;
        if (this.f.length() > 0) {
            s1 = s1 + this.f.substring(0, i);
        }
        if (k < s2.length()) {
            s1 = s1 + s2.substring(0, k);
            l = k;
        } else {
            s1 = s1 + s2;
            l = s2.length();
        }
        if (this.f.length() > 0 && j2 < this.f.length()) {
            s1 = s1 + this.f.substring(j2);
        }
        this.f = s1;
        this.d(i - this.s + l);
    }

    public void a(int par1) {
        if (this.f.length() != 0) {
            if (this.s != this.r) {
                this.b("");
            } else {
                this.b(this.c(par1) - this.r);
            }
        }
    }

    public void b(int par1) {
        if (this.f.length() != 0) {
            if (this.s != this.r) {
                this.b("");
            } else {
                boolean flag = par1 < 0;
                int j2 = flag ? this.r + par1 : this.r;
                int k = flag ? this.r : this.r + par1;
                String s2 = "";
                if (j2 >= 0) {
                    s2 = this.f.substring(0, j2);
                }
                if (k < this.f.length()) {
                    s2 = s2 + this.f.substring(k);
                }
                this.f = s2;
                if (flag) {
                    this.d(par1);
                }
            }
        }
    }

    public int c(int par1) {
        return this.a(par1, this.h());
    }

    public int a(int par1, int par2) {
        return this.a(par1, this.h(), true);
    }

    public int a(int par1, int par2, boolean par3) {
        int k = par2;
        boolean flag1 = par1 < 0;
        int l = Math.abs(par1);
        for (int i1 = 0; i1 < l; ++i1) {
            if (flag1) {
                while (par3 && k > 0 && this.f.charAt(k - 1) == ' ') {
                    --k;
                }
                while (k > 0 && this.f.charAt(k - 1) != ' ') {
                    --k;
                }
                continue;
            }
            int j1 = this.f.length();
            if ((k = this.f.indexOf(32, k)) == -1) {
                k = j1;
                continue;
            }
            while (par3 && k < j1 && this.f.charAt(k) == ' ') {
                ++k;
            }
        }
        return k;
    }

    public void d(int par1) {
        this.e(this.s + par1);
    }

    public void e(int par1) {
        this.r = par1;
        int j2 = this.f.length();
        if (this.r < 0) {
            this.r = 0;
        }
        if (this.r > j2) {
            this.r = j2;
        }
        this.i(this.r);
    }

    public void d() {
        this.e(0);
    }

    public void e() {
        this.e(this.f.length());
    }

    public boolean a(char par1, int par2) {
        if (this.p && this.o) {
            switch (par1) {
                case '\u0001': {
                    this.e();
                    this.i(0);
                    return true;
                }
                case '\u0003': {
                    awe.d(this.c());
                    return true;
                }
                case '\u0016': {
                    this.b(awe.l());
                    return true;
                }
                case '\u0018': {
                    awe.d(this.c());
                    this.b("");
                    return true;
                }
            }
            switch (par2) {
                case 14: {
                    if (awe.o()) {
                        this.a(-1);
                    } else {
                        this.b(-1);
                    }
                    return true;
                }
                case 199: {
                    if (awe.p()) {
                        this.i(0);
                    } else {
                        this.d();
                    }
                    return true;
                }
                case 203: {
                    if (awe.p()) {
                        if (awe.o()) {
                            this.i(this.a(-1, this.n()));
                        } else {
                            this.i(this.n() - 1);
                        }
                    } else if (awe.o()) {
                        this.e(this.c(-1));
                    } else {
                        this.d(-1);
                    }
                    return true;
                }
                case 205: {
                    if (awe.p()) {
                        if (awe.o()) {
                            this.i(this.a(1, this.n()));
                        } else {
                            this.i(this.n() + 1);
                        }
                    } else if (awe.o()) {
                        this.e(this.c(1));
                    } else {
                        this.d(1);
                    }
                    return true;
                }
                case 207: {
                    if (awe.p()) {
                        this.i(this.f.length());
                    } else {
                        this.e();
                    }
                    return true;
                }
                case 211: {
                    if (awe.o()) {
                        this.a(1);
                    } else {
                        this.b(1);
                    }
                    return true;
                }
            }
            if (v.a(par1)) {
                this.b(Character.toString(par1));
                return true;
            }
            return false;
        }
        return false;
    }

    public void a(int par1, int par2, int par3) {
        boolean flag;
        boolean bl2 = flag = par1 >= this.b && par1 < this.b + this.d && par2 >= this.c && par2 < this.c + this.e;
        if (this.j) {
            this.b(this.p && flag);
        }
        if (this.o && par3 == 0) {
            int l = par1 - this.b;
            if (this.i) {
                l -= 4;
            }
            String s2 = this.a.a(this.f.substring(this.q), this.o());
            this.e(this.a.a(s2, l).length() + this.q);
        }
    }

    public void f() {
        if (this.q()) {
            if (this.i()) {
                avf.a(this.b - 1, this.c - 1, this.b + this.d + 1, this.c + this.e + 1, -6250336);
                avf.a(this.b, this.c, this.b + this.d, this.c + this.e, -16777216);
            }
            int i = this.p ? this.t : this.u;
            int j2 = this.r - this.q;
            int k = this.s - this.q;
            String s2 = this.a.a(this.f.substring(this.q), this.o());
            boolean flag = j2 >= 0 && j2 <= s2.length();
            boolean flag1 = this.o && this.h / 6 % 2 == 0 && flag;
            int l = this.i ? this.b + 4 : this.b;
            int i1 = this.i ? this.c + (this.e - 8) / 2 : this.c;
            int j1 = l;
            if (k > s2.length()) {
                k = s2.length();
            }
            if (s2.length() > 0) {
                String s1 = flag ? s2.substring(0, j2) : s2;
                j1 = this.a.a(s1, l, i1, i);
            }
            boolean flag2 = this.r < this.f.length() || this.f.length() >= this.g();
            int k1 = j1;
            if (!flag) {
                k1 = j2 > 0 ? l + this.d : l;
            } else if (flag2) {
                k1 = j1 - 1;
                --j1;
            }
            if (s2.length() > 0 && flag && j2 < s2.length()) {
                this.a.a(s2.substring(j2), j1, i1, i);
            }
            if (flag1) {
                if (flag2) {
                    avk.a(k1, i1 - 1, k1 + 1, i1 + 1 + this.a.a, -3092272);
                } else {
                    this.a.a("_", k1, i1, i);
                }
            }
            if (k != j2) {
                int l1 = l + this.a.a(s2.substring(0, k));
                this.c(k1, i1 - 1, l1 - 1, i1 + 1 + this.a.a);
            }
        }
    }

    private void c(int par1, int par2, int par3, int par4) {
        int i1;
        if (par1 < par3) {
            i1 = par1;
            par1 = par3;
            par3 = i1;
        }
        if (par2 < par4) {
            i1 = par2;
            par2 = par4;
            par4 = i1;
        }
        bfq tessellator = bfq.a;
        GL11.glColor4f((float)0.0f, (float)0.0f, (float)255.0f, (float)255.0f);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3058);
        GL11.glLogicOp((int)5387);
        tessellator.b();
        tessellator.a((double)par1, (double)par4, 0.0);
        tessellator.a((double)par3, (double)par4, 0.0);
        tessellator.a((double)par3, (double)par2, 0.0);
        tessellator.a((double)par1, (double)par2, 0.0);
        tessellator.a();
        GL11.glDisable((int)3058);
        GL11.glEnable((int)3553);
    }

    public void f(int par1) {
        this.g = par1;
        if (this.f.length() > par1) {
            this.f = this.f.substring(0, par1);
        }
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.r;
    }

    public boolean i() {
        return this.i;
    }

    public void a(boolean par1) {
        this.i = par1;
    }

    public void g(int par1) {
        this.t = par1;
    }

    public void h(int par1) {
        this.u = par1;
    }

    public void b(boolean par1) {
        if (par1 && !this.o) {
            this.h = 0;
        }
        this.o = par1;
    }

    public boolean l() {
        return this.o;
    }

    public void c(boolean par1) {
        this.p = par1;
    }

    public int n() {
        return this.s;
    }

    public int o() {
        return this.i() ? this.d - 8 : this.d;
    }

    public void i(int par1) {
        int j2 = this.f.length();
        if (par1 > j2) {
            par1 = j2;
        }
        if (par1 < 0) {
            par1 = 0;
        }
        this.s = par1;
        if (this.a != null) {
            if (this.q > j2) {
                this.q = j2;
            }
            int k = this.o();
            String s2 = this.a.a(this.f.substring(this.q), k);
            int l = s2.length() + this.q;
            if (par1 == this.q) {
                this.q -= this.a.a(this.f, k, true).length();
            }
            if (par1 > l) {
                this.q += par1 - l;
            } else if (par1 <= this.q) {
                this.q -= this.q - par1;
            }
            if (this.q < 0) {
                this.q = 0;
            }
            if (this.q > j2) {
                this.q = j2;
            }
        }
    }

    public void d(boolean par1) {
        this.j = par1;
    }

    public boolean q() {
        return this.v;
    }

    public void e(boolean par1) {
        this.v = par1;
    }
}

