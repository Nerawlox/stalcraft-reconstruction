/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aot
 *  ash
 *  asx
 *  mo
 *  my
 *  nw
 *  s
 */
import java.util.List;

public class asi
extends asp
implements ash {
    private ye[] a = new ye[5];
    private String b;
    private int c = -1;

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        cg nbttaglist = par1NBTTagCompound.m("Items");
        this.a = new ye[this.j_()];
        if (par1NBTTagCompound.b("CustomName")) {
            this.b = par1NBTTagCompound.i("CustomName");
        }
        this.c = par1NBTTagCompound.e("TransferCooldown");
        for (int i = 0; i < nbttaglist.c(); ++i) {
            by nbttagcompound1 = (by)nbttaglist.b(i);
            byte b0 = nbttagcompound1.c("Slot");
            if (b0 < 0 || b0 >= this.a.length) continue;
            this.a[b0] = ye.a(nbttagcompound1);
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        cg nbttaglist = new cg();
        for (int i = 0; i < this.a.length; ++i) {
            if (this.a[i] == null) continue;
            by nbttagcompound1 = new by();
            nbttagcompound1.a("Slot", (byte)i);
            this.a[i].b(nbttagcompound1);
            nbttaglist.a(nbttagcompound1);
        }
        par1NBTTagCompound.a("Items", nbttaglist);
        par1NBTTagCompound.a("TransferCooldown", this.c);
        if (this.c()) {
            par1NBTTagCompound.a("CustomName", this.b);
        }
    }

    @Override
    public void e() {
        super.e();
    }

    public int j_() {
        return this.a.length;
    }

    public ye a(int par1) {
        return this.a[par1];
    }

    public ye a(int par1, int par2) {
        if (this.a[par1] != null) {
            if (this.a[par1].b <= par2) {
                ye itemstack = this.a[par1];
                this.a[par1] = null;
                return itemstack;
            }
            ye itemstack = this.a[par1].a(par2);
            if (this.a[par1].b == 0) {
                this.a[par1] = null;
            }
            return itemstack;
        }
        return null;
    }

    public ye a_(int par1) {
        if (this.a[par1] != null) {
            ye itemstack = this.a[par1];
            this.a[par1] = null;
            return itemstack;
        }
        return null;
    }

    public void a(int par1, ye par2ItemStack) {
        this.a[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.b > this.d()) {
            par2ItemStack.b = this.d();
        }
    }

    public String b() {
        return this.c() ? this.b : "container.hopper";
    }

    public boolean c() {
        return this.b != null && this.b.length() > 0;
    }

    public void a(String par1Str) {
        this.b = par1Str;
    }

    public int d() {
        return 64;
    }

    public boolean a(uf par1EntityPlayer) {
        return this.k.r(this.l, this.m, this.n) != this ? false : par1EntityPlayer.e((double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5) <= 64.0;
    }

    public void k_() {
    }

    public void g() {
    }

    public boolean b(int par1, ye par2ItemStack) {
        return true;
    }

    @Override
    public void h() {
        if (this.k != null && !this.k.I) {
            --this.c;
            if (!this.l()) {
                this.c(0);
                this.j();
            }
        }
    }

    public boolean j() {
        if (this.k != null && !this.k.I) {
            if (!this.l() && aot.d((int)this.p())) {
                boolean flag = this.u();
                boolean bl2 = flag = asi.a(this) || flag;
                if (flag) {
                    this.c(8);
                    this.e();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean u() {
        mo iinventory = this.v();
        if (iinventory == null) {
            return false;
        }
        for (int i = 0; i < this.j_(); ++i) {
            if (this.a(i) == null) continue;
            ye itemstack = this.a(i).m();
            ye itemstack1 = asi.a(iinventory, this.a(i, 1), s.a[aot.c((int)this.p())]);
            if (itemstack1 == null || itemstack1.b == 0) {
                iinventory.e();
                return true;
            }
            this.a(i, itemstack);
        }
        return false;
    }

    public static boolean a(ash par0Hopper) {
        mo iinventory = asi.b(par0Hopper);
        if (iinventory != null) {
            int b0 = 0;
            if (iinventory instanceof my && b0 > -1) {
                my isidedinventory = (my)iinventory;
                int[] aint = isidedinventory.c(b0);
                for (int i = 0; i < aint.length; ++i) {
                    if (!asi.a(par0Hopper, iinventory, aint[i], b0)) continue;
                    return true;
                }
            } else {
                int j2 = iinventory.j_();
                for (int k = 0; k < j2; ++k) {
                    if (!asi.a(par0Hopper, iinventory, k, b0)) continue;
                    return true;
                }
            }
        } else {
            ss entityitem = asi.a(par0Hopper.az(), par0Hopper.aA(), par0Hopper.aB() + 1.0, par0Hopper.aC());
            if (entityitem != null) {
                return asi.a((mo)par0Hopper, entityitem);
            }
        }
        return false;
    }

    private static boolean a(ash par0Hopper, mo par1IInventory, int par2, int par3) {
        ye itemstack = par1IInventory.a(par2);
        if (itemstack != null && asi.b(par1IInventory, itemstack, par2, par3)) {
            ye itemstack1 = itemstack.m();
            ye itemstack2 = asi.a((mo)par0Hopper, par1IInventory.a(par2, 1), -1);
            if (itemstack2 == null || itemstack2.b == 0) {
                par1IInventory.e();
                return true;
            }
            par1IInventory.a(par2, itemstack1);
        }
        return false;
    }

    public static boolean a(mo par0IInventory, ss par1EntityItem) {
        boolean flag = false;
        if (par1EntityItem == null) {
            return false;
        }
        ye itemstack = par1EntityItem.d().m();
        ye itemstack1 = asi.a(par0IInventory, itemstack, -1);
        if (itemstack1 != null && itemstack1.b != 0) {
            par1EntityItem.a(itemstack1);
        } else {
            flag = true;
            par1EntityItem.x();
        }
        return flag;
    }

    public static ye a(mo par0IInventory, ye par1ItemStack, int par2) {
        if (par0IInventory instanceof my && par2 > -1) {
            my isidedinventory = (my)par0IInventory;
            int[] aint = isidedinventory.c(par2);
            for (int j2 = 0; j2 < aint.length && par1ItemStack != null && par1ItemStack.b > 0; ++j2) {
                par1ItemStack = asi.c(par0IInventory, par1ItemStack, aint[j2], par2);
            }
        } else {
            int k = par0IInventory.j_();
            for (int l = 0; l < k && par1ItemStack != null && par1ItemStack.b > 0; ++l) {
                par1ItemStack = asi.c(par0IInventory, par1ItemStack, l, par2);
            }
        }
        if (par1ItemStack != null && par1ItemStack.b == 0) {
            par1ItemStack = null;
        }
        return par1ItemStack;
    }

    private static boolean a(mo par0IInventory, ye par1ItemStack, int par2, int par3) {
        return !par0IInventory.b(par2, par1ItemStack) ? false : !(par0IInventory instanceof my) || ((my)par0IInventory).a(par2, par1ItemStack, par3);
    }

    private static boolean b(mo par0IInventory, ye par1ItemStack, int par2, int par3) {
        return !(par0IInventory instanceof my) || ((my)par0IInventory).b(par2, par1ItemStack, par3);
    }

    private static ye c(mo par0IInventory, ye par1ItemStack, int par2, int par3) {
        ye itemstack1 = par0IInventory.a(par2);
        if (asi.a(par0IInventory, par1ItemStack, par2, par3)) {
            int max;
            boolean flag = false;
            if (itemstack1 == null) {
                int max2 = Math.min(par1ItemStack.e(), par0IInventory.d());
                if (max2 >= par1ItemStack.b) {
                    par0IInventory.a(par2, par1ItemStack);
                    par1ItemStack = null;
                } else {
                    par0IInventory.a(par2, par1ItemStack.a(max2));
                }
                flag = true;
            } else if (asi.a(itemstack1, par1ItemStack) && (max = Math.min(par1ItemStack.e(), par0IInventory.d())) > itemstack1.b) {
                int l = Math.min(par1ItemStack.b, max - itemstack1.b);
                par1ItemStack.b -= l;
                itemstack1.b += l;
                boolean bl2 = flag = l > 0;
            }
            if (flag) {
                if (par0IInventory instanceof asi) {
                    ((asi)par0IInventory).c(8);
                    par0IInventory.e();
                }
                par0IInventory.e();
            }
        }
        return par1ItemStack;
    }

    private mo v() {
        int i = aot.c((int)this.p());
        return asi.b(this.az(), this.l + s.b[i], (double)(this.m + s.c[i]), (double)(this.n + s.d[i]));
    }

    public static mo b(ash par0Hopper) {
        return asi.b(par0Hopper.az(), par0Hopper.aA(), par0Hopper.aB() + 1.0, par0Hopper.aC());
    }

    public static ss a(abw par0World, double par1, double par3, double par5) {
        List list = par0World.a(ss.class, asx.a().a(par1, par3, par5, par1 + 1.0, par3 + 1.0, par5 + 1.0), nw.a);
        return list.size() > 0 ? (ss)list.get(0) : null;
    }

    public static mo b(abw par0World, double par1, double par3, double par5) {
        List list;
        int l;
        aqz block;
        int k;
        int j2;
        mo iinventory = null;
        int i = ls.c(par1);
        asp tileentity = par0World.r(i, j2 = ls.c(par3), k = ls.c(par5));
        if (tileentity != null && tileentity instanceof mo && (iinventory = (mo)tileentity) instanceof ary && (block = aqz.s[l = par0World.a(i, j2, k)]) instanceof ank) {
            iinventory = ((ank)((Object)block)).g_(par0World, i, j2, k);
        }
        if (iinventory == null && (list = par0World.a((nn)null, asx.a().a(par1, par3, par5, par1 + 1.0, par3 + 1.0, par5 + 1.0), nw.b)) != null && list.size() > 0) {
            iinventory = (mo)list.get(par0World.s.nextInt(list.size()));
        }
        return iinventory;
    }

    private static boolean a(ye par0ItemStack, ye par1ItemStack) {
        return par0ItemStack.d != par1ItemStack.d ? false : (par0ItemStack.k() != par1ItemStack.k() ? false : (par0ItemStack.b > par0ItemStack.e() ? false : ye.a(par0ItemStack, par1ItemStack)));
    }

    public double aA() {
        return this.l;
    }

    public double aB() {
        return this.m;
    }

    public double aC() {
        return this.n;
    }

    public void c(int par1) {
        this.c = par1;
    }

    public boolean l() {
        return this.c > 0;
    }
}

