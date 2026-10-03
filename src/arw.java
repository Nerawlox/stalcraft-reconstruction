/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ge
 *  mo
 *  ni
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class arw
extends asp
implements mo {
    public static final ni[][] a = new ni[][]{{ni.c, ni.e}, {ni.m, ni.j}, {ni.g}, {ni.l}};
    @SideOnly(value=Side.CLIENT)
    private long b;
    @SideOnly(value=Side.CLIENT)
    private float c;
    private boolean d;
    private int e = -1;
    private int f;
    private int g;
    private ye h;
    private String i;

    @Override
    public void h() {
        if (this.k.I() % 80L == 0L) {
            this.v();
            this.u();
        }
    }

    private void u() {
        if (this.d && this.e > 0 && !this.k.I && this.f > 0) {
            double d0 = this.e * 10 + 10;
            int b0 = 0;
            if (this.e >= 4 && this.f == this.g) {
                b0 = 1;
            }
            asx axisalignedbb = asx.a().a((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1)).b(d0, d0, d0);
            axisalignedbb.e = this.k.R();
            List list = this.k.a(uf.class, axisalignedbb);
            for (uf entityplayer : list) {
                entityplayer.c(new nj(this.f, 180, b0, true));
            }
            if (this.e >= 4 && this.f != this.g && this.g > 0) {
                for (uf entityplayer : list) {
                    entityplayer.c(new nj(this.g, 180, 0, true));
                }
            }
        }
    }

    private void v() {
        if (!this.k.l(this.l, this.m + 1, this.n)) {
            this.d = false;
            this.e = 0;
        } else {
            int j2;
            this.d = true;
            this.e = 0;
            int i = 1;
            while (i <= 4 && (j2 = this.m - i) >= 0) {
                boolean flag = true;
                block1: for (int k = this.l - i; k <= this.l + i && flag; ++k) {
                    for (int l = this.n - i; l <= this.n + i; ++l) {
                        int i1 = this.k.a(k, j2, l);
                        aqz block = aqz.s[i1];
                        if (block != null && block.isBeaconBase(this.k, k, j2, l, this.l, this.m, this.n)) continue;
                        flag = false;
                        continue block1;
                    }
                }
                if (!flag) break;
                this.e = i++;
            }
            if (this.e == 0) {
                this.d = false;
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public float v_() {
        if (!this.d) {
            return 0.0f;
        }
        int i = (int)(this.k.I() - this.b);
        this.b = this.k.I();
        if (i > 1) {
            this.c -= (float)i / 40.0f;
            if (this.c < 0.0f) {
                this.c = 0.0f;
            }
        }
        this.c += 0.025f;
        if (this.c > 1.0f) {
            this.c = 1.0f;
        }
        return this.c;
    }

    public int j() {
        return this.f;
    }

    public int k() {
        return this.g;
    }

    public int l() {
        return this.e;
    }

    @SideOnly(value=Side.CLIENT)
    public void c(int par1) {
        this.e = par1;
    }

    public void d(int par1) {
        this.f = 0;
        for (int j2 = 0; j2 < this.e && j2 < 3; ++j2) {
            for (ni potion : a[j2]) {
                if (potion.H != par1) continue;
                this.f = par1;
                return;
            }
        }
    }

    public void e(int par1) {
        this.g = 0;
        if (this.e >= 4) {
            for (int j2 = 0; j2 < 4; ++j2) {
                for (ni potion : a[j2]) {
                    if (potion.H != par1) continue;
                    this.g = par1;
                    return;
                }
            }
        }
    }

    @Override
    public ey m() {
        by nbttagcompound = new by();
        this.b(nbttagcompound);
        return new ge(this.l, this.m, this.n, 3, nbttagcompound);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public double n() {
        return 65536.0;
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.f = par1NBTTagCompound.e("Primary");
        this.g = par1NBTTagCompound.e("Secondary");
        this.e = par1NBTTagCompound.e("Levels");
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Primary", this.f);
        par1NBTTagCompound.a("Secondary", this.g);
        par1NBTTagCompound.a("Levels", this.e);
    }

    public int j_() {
        return 1;
    }

    public ye a(int par1) {
        return par1 == 0 ? this.h : null;
    }

    public ye a(int par1, int par2) {
        if (par1 == 0 && this.h != null) {
            if (par2 >= this.h.b) {
                ye itemstack = this.h;
                this.h = null;
                return itemstack;
            }
            this.h.b -= par2;
            return new ye(this.h.d, par2, this.h.k());
        }
        return null;
    }

    public ye a_(int par1) {
        if (par1 == 0 && this.h != null) {
            ye itemstack = this.h;
            this.h = null;
            return itemstack;
        }
        return null;
    }

    public void a(int par1, ye par2ItemStack) {
        if (par1 == 0) {
            this.h = par2ItemStack;
        }
    }

    public String b() {
        return this.c() ? this.i : "container.beacon";
    }

    public boolean c() {
        return this.i != null && this.i.length() > 0;
    }

    public void a(String par1Str) {
        this.i = par1Str;
    }

    public int d() {
        return 1;
    }

    public boolean a(uf par1EntityPlayer) {
        return this.k.r(this.l, this.m, this.n) != this ? false : par1EntityPlayer.e((double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5) <= 64.0;
    }

    public void k_() {
    }

    public void g() {
    }

    public boolean b(int par1, ye par2ItemStack) {
        return par2ItemStack.d == yc.bJ.cv || par2ItemStack.d == yc.p.cv || par2ItemStack.d == yc.r.cv || par2ItemStack.d == yc.q.cv;
    }
}

