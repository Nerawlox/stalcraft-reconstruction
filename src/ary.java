/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mn
 *  mo
 *  vj
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ary
extends asp
implements mo {
    private ye[] i = new ye[36];
    public boolean a;
    public ary b;
    public ary c;
    public ary d;
    public ary e;
    public float f;
    public float g;
    public int h;
    private int j;
    private int r;
    private String s;

    public ary() {
        this.r = -1;
    }

    @SideOnly(value=Side.CLIENT)
    public ary(int par1) {
        this.r = par1;
    }

    public int j_() {
        return 27;
    }

    public ye a(int par1) {
        return this.i[par1];
    }

    public ye a(int par1, int par2) {
        if (this.i[par1] != null) {
            if (this.i[par1].b <= par2) {
                ye itemstack = this.i[par1];
                this.i[par1] = null;
                this.e();
                return itemstack;
            }
            ye itemstack = this.i[par1].a(par2);
            if (this.i[par1].b == 0) {
                this.i[par1] = null;
            }
            this.e();
            return itemstack;
        }
        return null;
    }

    public ye a_(int par1) {
        if (this.i[par1] != null) {
            ye itemstack = this.i[par1];
            this.i[par1] = null;
            return itemstack;
        }
        return null;
    }

    public void a(int par1, ye par2ItemStack) {
        this.i[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.b > this.d()) {
            par2ItemStack.b = this.d();
        }
        this.e();
    }

    public String b() {
        return this.c() ? this.s : "container.chest";
    }

    public boolean c() {
        return this.s != null && this.s.length() > 0;
    }

    public void a(String par1Str) {
        this.s = par1Str;
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        cg nbttaglist = par1NBTTagCompound.m("Items");
        this.i = new ye[this.j_()];
        if (par1NBTTagCompound.b("CustomName")) {
            this.s = par1NBTTagCompound.i("CustomName");
        }
        for (int i = 0; i < nbttaglist.c(); ++i) {
            by nbttagcompound1 = (by)nbttaglist.b(i);
            int j2 = nbttagcompound1.c("Slot") & 0xFF;
            if (j2 < 0 || j2 >= this.i.length) continue;
            this.i[j2] = ye.a(nbttagcompound1);
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        cg nbttaglist = new cg();
        for (int i = 0; i < this.i.length; ++i) {
            if (this.i[i] == null) continue;
            by nbttagcompound1 = new by();
            nbttagcompound1.a("Slot", (byte)i);
            this.i[i].b(nbttagcompound1);
            nbttaglist.a(nbttagcompound1);
        }
        par1NBTTagCompound.a("Items", nbttaglist);
        if (this.c()) {
            par1NBTTagCompound.a("CustomName", this.s);
        }
    }

    public int d() {
        return 64;
    }

    public boolean a(uf par1EntityPlayer) {
        return this.k.r(this.l, this.m, this.n) != this ? false : par1EntityPlayer.e((double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5) <= 64.0;
    }

    @Override
    public void i() {
        super.i();
        this.a = false;
    }

    private void a(ary par1TileEntityChest, int par2) {
        if (par1TileEntityChest.r()) {
            this.a = false;
        } else if (this.a) {
            switch (par2) {
                case 0: {
                    if (this.e == par1TileEntityChest) break;
                    this.a = false;
                    break;
                }
                case 1: {
                    if (this.d == par1TileEntityChest) break;
                    this.a = false;
                    break;
                }
                case 2: {
                    if (this.b == par1TileEntityChest) break;
                    this.a = false;
                    break;
                }
                case 3: {
                    if (this.c == par1TileEntityChest) break;
                    this.a = false;
                }
            }
        }
    }

    public void j() {
        if (!this.a) {
            this.a = true;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            if (this.a(this.l - 1, this.m, this.n)) {
                this.d = (ary)this.k.r(this.l - 1, this.m, this.n);
            }
            if (this.a(this.l + 1, this.m, this.n)) {
                this.c = (ary)this.k.r(this.l + 1, this.m, this.n);
            }
            if (this.a(this.l, this.m, this.n - 1)) {
                this.b = (ary)this.k.r(this.l, this.m, this.n - 1);
            }
            if (this.a(this.l, this.m, this.n + 1)) {
                this.e = (ary)this.k.r(this.l, this.m, this.n + 1);
            }
            if (this.b != null) {
                this.b.a(this, 0);
            }
            if (this.e != null) {
                this.e.a(this, 2);
            }
            if (this.c != null) {
                this.c.a(this, 1);
            }
            if (this.d != null) {
                this.d.a(this, 3);
            }
        }
    }

    private boolean a(int par1, int par2, int par3) {
        aqz block = aqz.s[this.k.a(par1, par2, par3)];
        return block != null && block instanceof ank ? ((ank)((Object)block)).a == this.l() : false;
    }

    @Override
    public void h() {
        float f;
        super.h();
        this.j();
        ++this.j;
        if (!this.k.I && this.h != 0 && (this.j + this.l + this.m + this.n) % 200 == 0) {
            this.h = 0;
            f = 5.0f;
            List list = this.k.a(uf.class, asx.a().a((double)((float)this.l - f), (double)((float)this.m - f), (double)((float)this.n - f), (double)((float)(this.l + 1) + f), (double)((float)(this.m + 1) + f), (double)((float)(this.n + 1) + f)));
            for (uf entityplayer : list) {
                mo iinventory;
                if (!(entityplayer.bp instanceof vj) || (iinventory = ((vj)entityplayer.bp).e()) != this && (!(iinventory instanceof mn) || !((mn)iinventory).a((mo)this))) continue;
                ++this.h;
            }
        }
        this.g = this.f;
        f = 0.1f;
        if (this.h > 0 && this.f == 0.0f && this.b == null && this.d == null) {
            double d1 = (double)this.l + 0.5;
            double d0 = (double)this.n + 0.5;
            if (this.e != null) {
                d0 += 0.5;
            }
            if (this.c != null) {
                d1 += 0.5;
            }
            this.k.a(d1, (double)this.m + 0.5, d0, "random.chestopen", 0.5f, this.k.s.nextFloat() * 0.1f + 0.9f);
        }
        if (this.h == 0 && this.f > 0.0f || this.h > 0 && this.f < 1.0f) {
            float f2;
            float f1 = this.f;
            this.f = this.h > 0 ? (this.f += f) : (this.f -= f);
            if (this.f > 1.0f) {
                this.f = 1.0f;
            }
            if (this.f < (f2 = 0.5f) && f1 >= f2 && this.b == null && this.d == null) {
                double d0 = (double)this.l + 0.5;
                double d2 = (double)this.n + 0.5;
                if (this.e != null) {
                    d2 += 0.5;
                }
                if (this.c != null) {
                    d0 += 0.5;
                }
                this.k.a(d0, (double)this.m + 0.5, d2, "random.chestclosed", 0.5f, this.k.s.nextFloat() * 0.1f + 0.9f);
            }
            if (this.f < 0.0f) {
                this.f = 0.0f;
            }
        }
    }

    @Override
    public boolean b(int par1, int par2) {
        if (par1 == 1) {
            this.h = par2;
            return true;
        }
        return super.b(par1, par2);
    }

    public void k_() {
        if (this.h < 0) {
            this.h = 0;
        }
        ++this.h;
        this.k.d(this.l, this.m, this.n, this.q().cF, 1, this.h);
        this.k.f(this.l, this.m, this.n, this.q().cF);
        this.k.f(this.l, this.m - 1, this.n, this.q().cF);
    }

    public void g() {
        if (this.q() != null && this.q() instanceof ank) {
            --this.h;
            this.k.d(this.l, this.m, this.n, this.q().cF, 1, this.h);
            this.k.f(this.l, this.m, this.n, this.q().cF);
            this.k.f(this.l, this.m - 1, this.n, this.q().cF);
        }
    }

    public boolean b(int par1, ye par2ItemStack) {
        return true;
    }

    @Override
    public void w_() {
        super.w_();
        this.i();
        this.j();
    }

    public int l() {
        if (this.r == -1) {
            if (this.k == null || !(this.q() instanceof ank)) {
                return 0;
            }
            this.r = ((ank)((Object)this.q())).a;
        }
        return this.r;
    }
}

