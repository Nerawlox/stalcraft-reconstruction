/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 *  ud
 *  we
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class awy
extends awe {
    protected static final bjo a = new bjo("textures/gui/container/inventory.png");
    protected static bgw b = new bgw();
    protected int c = 176;
    protected int d = 166;
    public uy e;
    protected int p;
    protected int q;
    private we t;
    private we u;
    private boolean v;
    private ye w;
    private int x;
    private int y;
    private we z;
    private long A;
    private ye B;
    private we C;
    private long D;
    protected final Set r = new HashSet();
    protected boolean s;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private long I;
    private we J;
    private int K;
    private boolean L;
    private ye M;

    public awy(uy par1Container) {
        this.e = par1Container;
        this.G = true;
    }

    @Override
    public void A_() {
        super.A_();
        this.f.h.bp = this.e;
        this.p = (this.g - this.c) / 2;
        this.q = (this.h - this.d) / 2;
    }

    @Override
    public void a(int par1, int par2, float par3) {
        ye itemstack;
        int i1;
        this.e();
        int k = this.p;
        int l = this.q;
        this.a(par3, par1, par2);
        GL11.glDisable((int)32826);
        att.a();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        super.a(par1, par2, par3);
        att.c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)k, (float)l, (float)0.0f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)32826);
        this.t = null;
        int short1 = 240;
        int short2 = 240;
        bma.a((int)bma.b, (float)((float)short1 / 1.0f), (float)((float)short2 / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        for (int j1 = 0; j1 < this.e.c.size(); ++j1) {
            we slot = (we)this.e.c.get(j1);
            this.a(slot);
            if (!this.a(slot, par1, par2) || !slot.b()) continue;
            this.t = slot;
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            int k1 = slot.h;
            i1 = slot.i;
            this.a(k1, i1, k1 + 16, i1 + 16, -2130706433, -2130706433);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
        }
        GL11.glDisable((int)2896);
        this.b(par1, par2);
        GL11.glEnable((int)2896);
        ud inventoryplayer = this.f.h.bn;
        ye ye2 = itemstack = this.w == null ? inventoryplayer.o() : this.w;
        if (itemstack != null) {
            int b0 = 8;
            i1 = this.w == null ? 8 : 16;
            String s2 = null;
            if (this.w != null && this.v) {
                itemstack = itemstack.m();
                itemstack.b = ls.f((float)itemstack.b / 2.0f);
            } else if (this.s && this.r.size() > 1) {
                itemstack = itemstack.m();
                itemstack.b = this.H;
                if (itemstack.b == 0) {
                    s2 = "" + (Object)((Object)a.o) + "0";
                }
            }
            this.a(itemstack, par1 - k - b0, par2 - l - i1, s2);
        }
        if (this.B != null) {
            float f1 = (float)(atv.F() - this.A) / 100.0f;
            if (f1 >= 1.0f) {
                f1 = 1.0f;
                this.B = null;
            }
            i1 = this.z.h - this.x;
            int l1 = this.z.i - this.y;
            int i2 = this.x + (int)((float)i1 * f1);
            int j2 = this.y + (int)((float)l1 * f1);
            this.a(this.B, i2, j2, null);
        }
        GL11.glPopMatrix();
        if (inventoryplayer.o() == null && this.t != null && this.t.e()) {
            ye itemstack1 = this.t.d();
            this.a(itemstack1, par1, par2);
        }
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        att.b();
    }

    private void a(ye par1ItemStack, int par2, int par3, String par4Str) {
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)32.0f);
        this.n = 200.0f;
        awy.b.f = 200.0f;
        avi font = null;
        if (par1ItemStack != null) {
            font = par1ItemStack.b().getFontRenderer(par1ItemStack);
        }
        if (font == null) {
            font = this.o;
        }
        b.b(font, this.f.J(), par1ItemStack, par2, par3);
        b.a(font, this.f.J(), par1ItemStack, par2, par3 - (this.w == null ? 0 : 8), par4Str);
        this.n = 0.0f;
        awy.b.f = 0.0f;
    }

    protected void a(ye par1ItemStack, int par2, int par3) {
        List list = par1ItemStack.a((uf)this.f.h, this.f.u.x);
        for (int k = 0; k < list.size(); ++k) {
            if (k == 0) {
                list.set(k, "\u00a7" + Integer.toHexString(par1ItemStack.w().e) + (String)list.get(k));
                continue;
            }
            list.set(k, (Object)((Object)a.h) + (String)list.get(k));
        }
        avi font = par1ItemStack.b().getFontRenderer(par1ItemStack);
        this.drawHoveringText(list, par2, par3, font == null ? this.o : font);
    }

    protected void a(String par1Str, int par2, int par3) {
        this.a(Arrays.asList(par1Str), par2, par3);
    }

    protected void a(List par1List, int par2, int par3) {
        this.drawHoveringText(par1List, par2, par3, this.o);
    }

    protected void drawHoveringText(List par1List, int par2, int par3, avi font) {
        if (!par1List.isEmpty()) {
            GL11.glDisable((int)32826);
            att.a();
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            int k = 0;
            for (String s2 : par1List) {
                int l = font.a(s2);
                if (l <= k) continue;
                k = l;
            }
            int i1 = par2 + 12;
            int j1 = par3 - 12;
            int k1 = 8;
            if (par1List.size() > 1) {
                k1 += 2 + (par1List.size() - 1) * 10;
            }
            if (i1 + k > this.g) {
                i1 -= 28 + k;
            }
            if (j1 + k1 + 6 > this.h) {
                j1 = this.h - k1 - 6;
            }
            this.n = 300.0f;
            awy.b.f = 300.0f;
            int l1 = -267386864;
            this.a(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
            this.a(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
            this.a(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
            this.a(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
            this.a(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
            int i2 = 0x505000FF;
            int j2 = (i2 & 0xFEFEFE) >> 1 | i2 & 0xFF000000;
            this.a(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
            this.a(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
            this.a(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
            this.a(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);
            for (int k2 = 0; k2 < par1List.size(); ++k2) {
                String s1 = (String)par1List.get(k2);
                font.a(s1, i1, j1, -1);
                if (k2 == 0) {
                    j1 += 2;
                }
                j1 += 10;
            }
            this.n = 0.0f;
            awy.b.f = 0.0f;
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
            att.b();
            GL11.glEnable((int)32826);
        }
    }

    protected void b(int par1, int par2) {
    }

    protected abstract void a(float var1, int var2, int var3);

    protected void a(we par1Slot) {
        ms icon;
        int i = par1Slot.h;
        int j2 = par1Slot.i;
        ye itemstack = par1Slot.d();
        boolean flag = false;
        boolean flag1 = par1Slot == this.u && this.w != null && !this.v;
        ye itemstack1 = this.f.h.bn.o();
        String s2 = null;
        if (par1Slot == this.u && this.w != null && this.v && itemstack != null) {
            itemstack = itemstack.m();
            itemstack.b /= 2;
        } else if (this.s && this.r.contains(par1Slot) && itemstack1 != null) {
            if (this.r.size() == 1) {
                return;
            }
            if (uy.a(par1Slot, itemstack1, true) && this.e.b(par1Slot)) {
                itemstack = itemstack1.m();
                flag = true;
                uy.a(this.r, this.E, itemstack, par1Slot.d() == null ? 0 : par1Slot.d().b);
                if (itemstack.b > itemstack.e()) {
                    s2 = (Object)((Object)a.o) + "" + itemstack.e();
                    itemstack.b = itemstack.e();
                }
                if (itemstack.b > par1Slot.a()) {
                    s2 = (Object)((Object)a.o) + "" + par1Slot.a();
                    itemstack.b = par1Slot.a();
                }
            } else {
                this.r.remove(par1Slot);
                this.g();
            }
        }
        this.n = 100.0f;
        awy.b.f = 100.0f;
        if (itemstack == null && (icon = par1Slot.c()) != null) {
            GL11.glDisable((int)2896);
            this.f.J().a(bik.c);
            this.a(i, j2, icon, 16, 16);
            GL11.glEnable((int)2896);
            flag1 = true;
        }
        if (!flag1) {
            if (flag) {
                awy.a(i, j2, i + 16, j2 + 16, -2130706433);
            }
            GL11.glEnable((int)2929);
            b.b(this.o, this.f.J(), itemstack, i, j2);
            b.a(this.o, this.f.J(), itemstack, i, j2, s2);
        }
        awy.b.f = 0.0f;
        this.n = 0.0f;
    }

    private void g() {
        ye itemstack = this.f.h.bn.o();
        if (itemstack != null && this.s) {
            this.H = itemstack.b;
            for (we slot : this.r) {
                ye itemstack1 = itemstack.m();
                int i = slot.d() == null ? 0 : slot.d().b;
                uy.a(this.r, this.E, itemstack1, i);
                if (itemstack1.b > itemstack1.e()) {
                    itemstack1.b = itemstack1.e();
                }
                if (itemstack1.b > slot.a()) {
                    itemstack1.b = slot.a();
                }
                this.H -= itemstack1.b - i;
            }
        }
    }

    private we c(int par1, int par2) {
        for (int k = 0; k < this.e.c.size(); ++k) {
            we slot = (we)this.e.c.get(k);
            if (!this.a(slot, par1, par2)) continue;
            return slot;
        }
        return null;
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        boolean flag = par3 == this.f.u.U.d + 100;
        we slot = this.c(par1, par2);
        long l = atv.F();
        this.L = this.J == slot && l - this.I < 250L && this.K == par3;
        this.G = false;
        if (par3 == 0 || par3 == 1 || flag) {
            int i1 = this.p;
            int j1 = this.q;
            boolean flag1 = par1 < i1 || par2 < j1 || par1 >= i1 + this.c || par2 >= j1 + this.d;
            int k1 = -1;
            if (slot != null) {
                k1 = slot.g;
            }
            if (flag1) {
                k1 = -999;
            }
            if (this.f.u.A && flag1 && this.f.h.bn.o() == null) {
                this.f.a((awe)null);
                return;
            }
            if (k1 != -1) {
                if (this.f.u.A) {
                    if (slot != null && slot.e()) {
                        this.u = slot;
                        this.w = null;
                        this.v = par3 == 1;
                    } else {
                        this.u = null;
                    }
                } else if (!this.s) {
                    if (this.f.h.bn.o() == null) {
                        if (par3 == this.f.u.U.d + 100) {
                            this.a(slot, k1, par3, 3);
                        } else {
                            boolean flag2 = k1 != -999 && (Keyboard.isKeyDown((int)42) || Keyboard.isKeyDown((int)54));
                            int b0 = 0;
                            if (flag2) {
                                this.M = slot != null && slot.e() ? slot.d() : null;
                                b0 = 1;
                            } else if (k1 == -999) {
                                b0 = 4;
                            }
                            this.a(slot, k1, par3, b0);
                        }
                        this.G = true;
                    } else {
                        this.s = true;
                        this.F = par3;
                        this.r.clear();
                        if (par3 == 0) {
                            this.E = 0;
                        } else if (par3 == 1) {
                            this.E = 1;
                        }
                    }
                }
            }
        }
        this.J = slot;
        this.I = l;
        this.K = par3;
    }

    @Override
    protected void a(int par1, int par2, int par3, long par4) {
        we slot = this.c(par1, par2);
        ye itemstack = this.f.h.bn.o();
        if (this.u != null && this.f.u.A) {
            if (par3 == 0 || par3 == 1) {
                if (this.w == null) {
                    if (slot != this.u) {
                        this.w = this.u.d().m();
                    }
                } else if (this.w.b > 1 && slot != null && uy.a(slot, this.w, false)) {
                    long i1 = atv.F();
                    if (this.C == slot) {
                        if (i1 - this.D > 500L) {
                            this.a(this.u, this.u.g, 0, 0);
                            this.a(slot, slot.g, 1, 0);
                            this.a(this.u, this.u.g, 0, 0);
                            this.D = i1 + 750L;
                            --this.w.b;
                        }
                    } else {
                        this.C = slot;
                        this.D = i1;
                    }
                }
            }
        } else if (this.s && slot != null && itemstack != null && itemstack.b > this.r.size() && uy.a(slot, itemstack, true) && slot.a(itemstack) && this.e.b(slot)) {
            this.r.add(slot);
            this.g();
        }
    }

    @Override
    protected void b(int par1, int par2, int par3) {
        we slot = this.c(par1, par2);
        int l = this.p;
        int i1 = this.q;
        boolean flag = par1 < l || par2 < i1 || par1 >= l + this.c || par2 >= i1 + this.d;
        int j1 = -1;
        if (slot != null) {
            j1 = slot.g;
        }
        if (flag) {
            j1 = -999;
        }
        if (this.L && slot != null && par3 == 0 && this.e.a((ye)null, slot)) {
            if (awy.p()) {
                if (slot != null && slot.f != null && this.M != null) {
                    for (we slot1 : this.e.c) {
                        if (slot1 == null || !slot1.a((uf)this.f.h) || !slot1.e() || slot1.f != slot.f || !uy.a(slot1, this.M, true)) continue;
                        this.a(slot1, slot1.g, par3, 1);
                    }
                }
            } else {
                this.a(slot, j1, par3, 6);
            }
            this.L = false;
            this.I = 0L;
        } else {
            if (this.s && this.F != par3) {
                this.s = false;
                this.r.clear();
                this.G = true;
                return;
            }
            if (this.G) {
                this.G = false;
                return;
            }
            if (this.u != null && this.f.u.A) {
                if (par3 == 0 || par3 == 1) {
                    if (this.w == null && slot != this.u) {
                        this.w = this.u.d();
                    }
                    boolean flag1 = uy.a(slot, this.w, false);
                    if (j1 != -1 && this.w != null && flag1) {
                        this.a(this.u, this.u.g, par3, 0);
                        this.a(slot, j1, 0, 0);
                        if (this.f.h.bn.o() != null) {
                            this.a(this.u, this.u.g, par3, 0);
                            this.x = par1 - l;
                            this.y = par2 - i1;
                            this.z = this.u;
                            this.B = this.w;
                            this.A = atv.F();
                        } else {
                            this.B = null;
                        }
                    } else if (this.w != null) {
                        this.x = par1 - l;
                        this.y = par2 - i1;
                        this.z = this.u;
                        this.B = this.w;
                        this.A = atv.F();
                    }
                    this.w = null;
                    this.u = null;
                }
            } else if (this.s && !this.r.isEmpty()) {
                this.a((we)null, -999, uy.d(0, this.E), 5);
                for (we slot1 : this.r) {
                    this.a(slot1, slot1.g, uy.d(1, this.E), 5);
                }
                this.a((we)null, -999, uy.d(2, this.E), 5);
            } else if (this.f.h.bn.o() != null) {
                if (par3 == this.f.u.U.d + 100) {
                    this.a(slot, j1, par3, 3);
                } else {
                    boolean flag1;
                    boolean bl2 = flag1 = j1 != -999 && (Keyboard.isKeyDown((int)42) || Keyboard.isKeyDown((int)54));
                    if (flag1) {
                        this.M = slot != null && slot.e() ? slot.d() : null;
                    }
                    this.a(slot, j1, par3, flag1 ? 1 : 0);
                }
            }
        }
        if (this.f.h.bn.o() == null) {
            this.I = 0L;
        }
        this.s = false;
    }

    private boolean a(we par1Slot, int par2, int par3) {
        return this.c(par1Slot.h, par1Slot.i, 16, 16, par2, par3);
    }

    protected boolean c(int par1, int par2, int par3, int par4, int par5, int par6) {
        int k1 = this.p;
        int l1 = this.q;
        return (par5 -= k1) >= par1 - 1 && par5 < par1 + par3 + 1 && (par6 -= l1) >= par2 - 1 && par6 < par2 + par4 + 1;
    }

    protected void a(we par1Slot, int par2, int par3, int par4) {
        if (par1Slot != null) {
            par2 = par1Slot.g;
        }
        this.f.c.a(this.e.d, par2, par3, par4, (uf)this.f.h);
    }

    @Override
    protected void a(char par1, int par2) {
        if (par2 == 1 || par2 == this.f.u.N.d) {
            this.f.h.i();
        }
        this.a(par2);
        if (this.t != null && this.t.e()) {
            if (par2 == this.f.u.U.d) {
                this.a(this.t, this.t.g, 0, 3);
            } else if (par2 == this.f.u.O.d) {
                this.a(this.t, this.t.g, awy.o() ? 1 : 0, 4);
            }
        }
    }

    protected boolean a(int par1) {
        if (this.f.h.bn.o() == null && this.t != null) {
            for (int j2 = 0; j2 < 9; ++j2) {
                if (par1 != 2 + j2) continue;
                this.a(this.t, this.t.g, j2, 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public void b() {
        if (this.f.h != null) {
            this.e.b((uf)this.f.h);
        }
    }

    @Override
    public boolean f() {
        return false;
    }

    @Override
    public void c() {
        super.c();
        if (!this.f.h.T() || this.f.h.M) {
            this.f.h.i();
        }
    }
}

