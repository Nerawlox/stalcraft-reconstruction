/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class divb
extends zybc {
    protected static final ResourceLocation __ac = new ResourceLocation("textures/gui/container/inventory.png");
    protected int __ad = 176;
    protected int __ae = 166;
    public jjgc __af;
    protected int __ag;
    protected int __ah;
    protected yeso __ai;
    protected yeso __aj;
    protected boolean __ak;
    protected cvzo __al;
    protected yeso __am;
    protected long __an;
    protected int __ao;
    protected int __ap;
    protected final Set<yeso> __aq = new HashSet<yeso>();
    protected cvzo __ar;
    protected cvzo __as;
    protected yeso __at;
    protected yeso __au;
    protected boolean __av;
    protected boolean __aw;
    protected boolean __ax;
    protected long __ay;
    protected long __az;
    protected int __aA;
    protected int __aB;
    protected int __aC;
    protected int __aD;
    protected ArrayList<Rectangle> __aE;
    protected boolean __aF = true;
    protected boolean __aG = true;
    protected boolean[] __aH;

    public divb(jjgc jjgc2) {
        super(jjgc2);
        this.__af = jjgc2;
        this.__aw = true;
        this.__aE = new ArrayList();
        this.field_73882_e = xpzm._E();
        this.__aH = new boolean[100];
    }

    @Override
    public void func_73866_w_() {
        this.field_73882_e._t.field_71070_bA = this.__af;
        this.__ag = (this.field_73880_f - this.__ad) / 2;
        this.__ah = (this.field_73881_g - this.__ae) / 2;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        int n3;
        cvzo cvzo2;
        this.func_73873_v_();
        int n4 = this.__ag;
        int n5 = this.__ah;
        this.func_74185_a(f, n, n2);
        GL11.glDisable(32826);
        qnon._a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        qnon._c();
        GL11.glPushMatrix();
        GL11.glTranslatef(n4, n5, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(32826);
        this.__ai = null;
        int n6 = 240;
        int n7 = 240;
        iwya._a(iwya._b, (float)n6 / 1.0f, (float)n7 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        this.func_74189_g(n, n2);
        GL11.glEnable(2896);
        eidj eidj2 = this.field_73882_e._t.field_71071_by;
        cvzo cvzo3 = cvzo2 = this.__al == null ? eidj2._g() : this.__al;
        if (cvzo2 != null) {
            n3 = this.__al == null ? 8 : 16;
            String string = null;
            if (this.__al != null && this.__ak) {
                cvzo2 = cvzo2._l();
                cvzo2._b = sajh._f((float)cvzo2._b / 2.0f);
            } else if (this.__av && this.__aq.size() > 1) {
                cvzo2 = cvzo2._l();
                cvzo2._b = this.__aC;
                if (cvzo2._b == 0) {
                    string = "" + (Object)((Object)ezfc._o) + "0";
                }
            }
            this._a(cvzo2, n - n4 - 8, n2 - n5 - n3, string);
        }
        if (this.__ar != null) {
            float f2 = (float)(xpzm._M() - this.__an) / 100.0f;
            if (f2 >= 1.0f) {
                f2 = 1.0f;
                this.__ar = null;
            }
            n3 = this.__am.field_75223_e - this.__ao;
            int n8 = this.__am.field_75221_f - this.__ap;
            int n9 = this.__ao + (int)((float)n3 * f2);
            int n10 = this.__ap + (int)((float)n8 * f2);
            this._a(this.__ar, n9, n10, null);
        }
        GL11.glPopMatrix();
        if (eidj2._g() == null && this.__ai != null && this.__ai.func_75216_d()) {
            cvzo cvzo4 = this.__ai.func_75211_c();
            this.func_74184_a(cvzo4, n, n2);
        }
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        qnon._b();
    }

    @Override
    public void func_74184_a(cvzo cvzo2, int n, int n2) {
        super.func_74184_a(cvzo2, n, n2);
    }

    @Override
    public void func_73733_a(int n, int n2, int n3, int n4, int n5, int n6) {
        super.func_73733_a(n, n2, n3, n4, n5, n6);
    }

    protected void _a(cvzo cvzo2, int n, int n2, String string) {
        GL11.glTranslatef(0.0f, 0.0f, 32.0f);
        this.field_73735_i = 200.0f;
        zybc.field_74196_a.field_77023_b = 200.0f;
        qncw qncw2 = null;
        if (cvzo2 != null) {
            qncw2 = cvzo2._a().getFontRenderer(cvzo2);
        }
        if (qncw2 == null) {
            qncw2 = this.field_73886_k;
        }
        zybc.field_74196_a.func_82406_b(qncw2, this.field_73882_e._R(), cvzo2, n, n2);
        zybc.field_74196_a.func_94148_a(qncw2, this.field_73882_e._R(), cvzo2, n, n2 - (this.__al == null ? 0 : 8), string);
        this.field_73735_i = 0.0f;
        zybc.field_74196_a.field_77023_b = 0.0f;
    }

    @Override
    protected void func_74189_g(int n, int n2) {
    }

    @Override
    protected abstract void func_74185_a(float var1, int var2, int var3);

    protected void _a(yeso yeso2) {
        dwan dwan2;
        int n = yeso2.field_75223_e;
        int n2 = yeso2.field_75221_f;
        cvzo cvzo2 = yeso2.func_75211_c();
        boolean bl = false;
        boolean bl2 = yeso2 == this.__aj && this.__al != null && !this.__ak;
        cvzo cvzo3 = this.field_73882_e._t.field_71071_by._g();
        String string = null;
        if (yeso2 == this.__aj && this.__al != null && this.__ak && cvzo2 != null) {
            cvzo2 = cvzo2._l();
            cvzo2._b /= 2;
        } else if (this.__av && this.__aq.contains(yeso2) && cvzo3 != null) {
            if (this.__aq.size() == 1) {
                return;
            }
            if (jjgc.func_94527_a(yeso2, cvzo3, true) && this.__af.func_94531_b(yeso2)) {
                cvzo2 = cvzo3._l();
                bl = true;
                jjgc.func_94525_a(this.__aq, this.__aA, cvzo2, yeso2.func_75211_c() == null ? 0 : yeso2.func_75211_c()._b);
                if (cvzo2._b > cvzo2._d()) {
                    string = (Object)((Object)ezfc._o) + "" + cvzo2._d();
                    cvzo2._b = cvzo2._d();
                }
                if (cvzo2._b > yeso2.func_75219_a()) {
                    string = (Object)((Object)ezfc._o) + "" + yeso2.func_75219_a();
                    cvzo2._b = yeso2.func_75219_a();
                }
            } else {
                this.__aq.remove(yeso2);
                this._h();
            }
        }
        this.field_73735_i = 100.0f;
        zybc.field_74196_a.field_77023_b = 100.0f;
        if (cvzo2 == null && (dwan2 = yeso2.func_75212_b()) != null) {
            GL11.glDisable(2896);
            this.field_73882_e._R()._a(sctd._e);
            this.func_94065_a(n, n2, dwan2, 16, 16);
            GL11.glEnable(2896);
            bl2 = true;
        }
        if (!bl2) {
            if (bl) {
                divb.func_73734_a(n, n2, n + 16, n2 + 16, -2130706433);
            }
            GL11.glEnable(2929);
            zybc.field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n, n2);
            zybc.field_74196_a.func_94148_a(this.field_73886_k, this.field_73882_e._R(), cvzo2, n, n2, string);
        }
        zybc.field_74196_a.field_77023_b = 0.0f;
        this.field_73735_i = 0.0f;
    }

    protected void _h() {
        cvzo cvzo2 = this.field_73882_e._t.field_71071_by._g();
        if (cvzo2 != null && this.__av) {
            this.__aC = cvzo2._b;
            for (yeso yeso2 : this.__aq) {
                cvzo cvzo3 = cvzo2._l();
                int n = yeso2.func_75211_c() == null ? 0 : yeso2.func_75211_c()._b;
                jjgc.func_94525_a(this.__aq, this.__aA, cvzo3, n);
                if (cvzo3._b > cvzo3._d()) {
                    cvzo3._b = cvzo3._d();
                }
                if (cvzo3._b > yeso2.func_75219_a()) {
                    cvzo3._b = yeso2.func_75219_a();
                }
                this.__aC -= cvzo3._b - n;
            }
        }
    }

    @Override
    public yeso func_74187_b(int n, int n2) {
        for (int i = 0; i < this.__af.field_75151_b.size(); ++i) {
            yeso yeso2 = (yeso)this.__af.field_75151_b.get(i);
            if (!this.func_74186_a(yeso2, n, n2) || !this.__aG || this.__aH[i]) continue;
            return yeso2;
        }
        return null;
    }

    public void _a(yeso yeso2, int n, int n2, int n3) {
    }

    public boolean _a(int n, int n2, int n3) {
        boolean bl = n3 == this.field_73882_e._M.field_74322_I._d + 100;
        yeso yeso2 = this.func_74187_b(n, n2);
        long l = xpzm._M();
        this.__ax = this.__au == yeso2 && l - this.__az < 250L && this.__aD == n3;
        this.__aw = false;
        if (yeso2 != null) {
            this._a(yeso2, n, n2, n3);
        }
        if (yeso2 instanceof ukeo) {
            return true;
        }
        if (n3 == 0 || n3 == 1 || bl) {
            int n4 = this.__ag;
            int n5 = this.__ah;
            boolean bl2 = n < n4 || n2 < n5 || n >= n4 + this.__ad || n2 >= n5 + this.__ae;
            for (Rectangle rectangle : this.__aE) {
                bl2 &= !rectangle.contains(n, n2);
            }
            int n6 = -1;
            if (yeso2 != null) {
                n6 = yeso2.field_75222_d;
            }
            if (bl2 && yeso2 == null) {
                n6 = -999;
            }
            if (this.field_73882_e._M.field_85185_A && bl2 && this.field_73882_e._t.field_71071_by._g() == null) {
                this.field_73882_e._a((gqjz)null);
                return false;
            }
            if (n6 != -1) {
                if (this.field_73882_e._M.field_85185_A) {
                    if (yeso2 != null && yeso2.func_75216_d()) {
                        this.__aj = yeso2;
                        this.__al = null;
                        this.__ak = n3 == 1;
                    } else {
                        this.__aj = null;
                    }
                } else if (!this.__av) {
                    if (this.field_73882_e._t.field_71071_by._g() == null) {
                        if (n3 == this.field_73882_e._M.field_74322_I._d + 100) {
                            this.func_74191_a(yeso2, n6, n3, 3);
                        } else {
                            boolean bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            int n7 = 0;
                            if (bl3) {
                                this.__as = yeso2 != null && yeso2.func_75216_d() ? yeso2.func_75211_c() : null;
                                n7 = 1;
                            } else if (n6 == -999) {
                                n7 = 4;
                            }
                            this.func_74191_a(yeso2, n6, n3, n7);
                        }
                        this.__aw = true;
                    } else {
                        this.__av = true;
                        this.__aB = n3;
                        this.__aq.clear();
                        if (n3 == 0) {
                            this.__aA = 0;
                        } else if (n3 == 1) {
                            this.__aA = 1;
                        }
                    }
                }
            }
        }
        this.__au = yeso2;
        this.__az = l;
        this.__aD = n3;
        return yeso2 != null;
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        yeso yeso2 = this.func_74187_b(n, n2);
        cvzo cvzo2 = this.field_73882_e._t.field_71071_by._g();
        if (this.__aj != null && this.field_73882_e._M.field_85185_A) {
            if (n3 == 0 || n3 == 1) {
                if (this.__al == null) {
                    if (yeso2 != this.__aj) {
                        this.__al = this.__aj.func_75211_c()._l();
                    }
                } else if (this.__al._b > 1 && yeso2 != null && jjgc.func_94527_a(yeso2, this.__al, false)) {
                    long l2 = xpzm._M();
                    if (this.__at == yeso2) {
                        if (l2 - this.__ay > 500L) {
                            this.func_74191_a(this.__aj, this.__aj.field_75222_d, 0, 0);
                            this.func_74191_a(yeso2, yeso2.field_75222_d, 1, 0);
                            this.func_74191_a(this.__aj, this.__aj.field_75222_d, 0, 0);
                            this.__ay = l2 + 750L;
                            --this.__al._b;
                        }
                    } else {
                        this.__at = yeso2;
                        this.__ay = l2;
                    }
                }
            }
        } else if (this.__av && yeso2 != null && cvzo2 != null && cvzo2._b > this.__aq.size() && jjgc.func_94527_a(yeso2, cvzo2, true) && yeso2.func_75214_a(cvzo2) && this.__af.func_94531_b(yeso2)) {
            this.__aq.add(yeso2);
            this._h();
        }
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        yeso yeso2 = this.func_74187_b(n, n2);
        int n4 = this.__ag;
        int n5 = this.__ah;
        boolean bl = n < n4 || n2 < n5 || n >= n4 + this.__ad || n2 >= n5 + this.__ae;
        for (Rectangle object : this.__aE) {
            bl &= !object.contains(n, n2);
        }
        int n6 = -1;
        if (yeso2 != null) {
            n6 = yeso2.field_75222_d;
        }
        if (bl) {
            n6 = -999;
        }
        if (this.__ax && yeso2 != null && n3 == 0 && this.__af.func_94530_a(null, yeso2)) {
            if (divb.func_73877_p()) {
                if (yeso2 != null && yeso2.field_75224_c != null && this.__as != null) {
                    for (yeso yeso3 : this.__af.field_75151_b) {
                        if (yeso3 == null || !yeso3.func_82869_a(this.field_73882_e._t) || !yeso3.func_75216_d() || yeso3.field_75224_c != yeso2.field_75224_c || !jjgc.func_94527_a(yeso3, this.__as, true)) continue;
                        this.func_74191_a(yeso3, yeso3.field_75222_d, n3, 1);
                    }
                }
            } else {
                this.func_74191_a(yeso2, n6, n3, 6);
            }
            this.__ax = false;
            this.__az = 0L;
        } else {
            if (this.__av && this.__aB != n3) {
                this.__av = false;
                this.__aq.clear();
                this.__aw = true;
                return;
            }
            if (this.__aw) {
                this.__aw = false;
                return;
            }
            if (this.__aj != null && this.field_73882_e._M.field_85185_A) {
                if (n3 == 0 || n3 == 1) {
                    if (this.__al == null && yeso2 != this.__aj) {
                        this.__al = this.__aj.func_75211_c();
                    }
                    boolean bl2 = jjgc.func_94527_a(yeso2, this.__al, false);
                    if (n6 != -1 && this.__al != null && bl2) {
                        this.func_74191_a(this.__aj, this.__aj.field_75222_d, n3, 0);
                        this.func_74191_a(yeso2, n6, 0, 0);
                        if (this.field_73882_e._t.field_71071_by._g() != null) {
                            this.func_74191_a(this.__aj, this.__aj.field_75222_d, n3, 0);
                            this.__ao = n - n4;
                            this.__ap = n2 - n5;
                            this.__am = this.__aj;
                            this.__ar = this.__al;
                            this.__an = xpzm._M();
                        } else {
                            this.__ar = null;
                        }
                    } else if (this.__al != null) {
                        this.__ao = n - n4;
                        this.__ap = n2 - n5;
                        this.__am = this.__aj;
                        this.__ar = this.__al;
                        this.__an = xpzm._M();
                    }
                    this.__al = null;
                    this.__aj = null;
                }
            } else if (this.__av && !this.__aq.isEmpty()) {
                this.func_74191_a(null, -999, jjgc.func_94534_d(0, this.__aA), 5);
                for (yeso yeso4 : this.__aq) {
                    this.func_74191_a(yeso4, yeso4.field_75222_d, jjgc.func_94534_d(1, this.__aA), 5);
                }
                this.func_74191_a(null, -999, jjgc.func_94534_d(2, this.__aA), 5);
            } else if (this.field_73882_e._t.field_71071_by._g() != null) {
                if (n3 == this.field_73882_e._M.field_74322_I._d + 100) {
                    this.func_74191_a(yeso2, n6, n3, 3);
                } else {
                    boolean bl3;
                    boolean bl4 = bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (bl3) {
                        this.__as = yeso2 != null && yeso2.func_75216_d() ? yeso2.func_75211_c() : null;
                    }
                    this.func_74191_a(yeso2, n6, n3, bl3 ? 1 : 0);
                }
            }
        }
        if (this.field_73882_e._t.field_71071_by._g() == null) {
            this.__az = 0L;
        }
        this.__av = false;
    }

    @Override
    protected boolean func_74186_a(yeso yeso2, int n, int n2) {
        return this.func_74188_c(yeso2.field_75223_e, yeso2.field_75221_f, 16, 16, n, n2);
    }

    @Override
    public boolean func_74188_c(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.__ag;
        int n8 = this.__ah;
        return (n5 -= n7) >= n - 1 && n5 < n + n3 + 1 && (n6 -= n8) >= n2 - 1 && n6 < n2 + n4 + 1;
    }

    @Override
    protected void func_74191_a(yeso yeso2, int n, int n2, int n3) {
        if (yeso2 != null) {
            n = yeso2.field_75222_d;
        }
        this.field_73882_e._j._a(this.__af.field_75152_c, n, n2, n3, this.field_73882_e._t);
    }

    @Override
    protected void func_73869_a(char c, int n) {
        this.func_82319_a(n);
        if (this.__ai != null && this.__ai.func_75216_d()) {
            if (n == this.field_73882_e._M.field_74322_I._d) {
                this.func_74191_a(this.__ai, this.__ai.field_75222_d, 0, 3);
            } else if (n == this.field_73882_e._M.field_74316_C._d) {
                this.func_74191_a(this.__ai, this.__ai.field_75222_d, divb.func_73861_o() ? 1 : 0, 4);
            }
        }
    }

    @Override
    protected boolean func_82319_a(int n) {
        if (this.field_73882_e._t.field_71071_by._g() == null && this.__ai != null) {
            for (int i = 0; i < 9; ++i) {
                if (n != 2 + i) continue;
                this.func_74191_a(this.__ai, this.__ai.field_75222_d, i, 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public void func_73874_b() {
        if (this.field_73882_e._t != null) {
            this.__af.func_75134_a(this.field_73882_e._t);
        }
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (!this.field_73882_e._t.func_70089_S() || this.field_73882_e._t.field_70128_L) {
            this.field_73882_e._t.func_71053_j();
        }
    }

    public void _a(int n, int n2, int[] nArray) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, nArray);
    }

    public void _a(int n, int n2, int n3, int n4, int[] nArray) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, nArray);
    }

    @Override
    public void func_73729_b(int n, int n2, int n3, int n4, int n5, int n6) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, n5, n6);
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, n5, n6, n7, n8);
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }
}

