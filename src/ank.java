/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  amw
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mn
 *  mo
 *  mt
 *  net.minecraftforge.common.ForgeDirection
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class ank
extends amw {
    private final Random b = new Random();
    public final int a;

    protected ank(int par1, int par2) {
        super(par1, akc.d);
        this.a = par2;
        this.a(ww.c);
        this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
    }

    public boolean c() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public int d() {
        return 22;
    }

    public void a(acf par1IBlockAccess, int par2, int par3, int par4) {
        if (par1IBlockAccess.a(par2, par3, par4 - 1) == this.cF) {
            this.a(0.0625f, 0.0f, 0.0f, 0.9375f, 0.875f, 0.9375f);
        } else if (par1IBlockAccess.a(par2, par3, par4 + 1) == this.cF) {
            this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 1.0f);
        } else if (par1IBlockAccess.a(par2 - 1, par3, par4) == this.cF) {
            this.a(0.0f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        } else if (par1IBlockAccess.a(par2 + 1, par3, par4) == this.cF) {
            this.a(0.0625f, 0.0f, 0.0625f, 1.0f, 0.875f, 0.9375f);
        } else {
            this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
        }
    }

    public void a(abw par1World, int par2, int par3, int par4) {
        super.a(par1World, par2, par3, par4);
        this.f_(par1World, par2, par3, par4);
        int l = par1World.a(par2, par3, par4 - 1);
        int i1 = par1World.a(par2, par3, par4 + 1);
        int j1 = par1World.a(par2 - 1, par3, par4);
        int k1 = par1World.a(par2 + 1, par3, par4);
        if (l == this.cF) {
            this.f_(par1World, par2, par3, par4 - 1);
        }
        if (i1 == this.cF) {
            this.f_(par1World, par2, par3, par4 + 1);
        }
        if (j1 == this.cF) {
            this.f_(par1World, par2 - 1, par3, par4);
        }
        if (k1 == this.cF) {
            this.f_(par1World, par2 + 1, par3, par4);
        }
    }

    public void a(abw par1World, int par2, int par3, int par4, of par5EntityLivingBase, ye par6ItemStack) {
        int l = par1World.a(par2, par3, par4 - 1);
        int i1 = par1World.a(par2, par3, par4 + 1);
        int j1 = par1World.a(par2 - 1, par3, par4);
        int k1 = par1World.a(par2 + 1, par3, par4);
        int b0 = 0;
        int l1 = ls.c((double)(par5EntityLivingBase.A * 4.0f / 360.0f) + 0.5) & 3;
        if (l1 == 0) {
            b0 = 2;
        }
        if (l1 == 1) {
            b0 = 5;
        }
        if (l1 == 2) {
            b0 = 3;
        }
        if (l1 == 3) {
            b0 = 4;
        }
        if (l != this.cF && i1 != this.cF && j1 != this.cF && k1 != this.cF) {
            par1World.b(par2, par3, par4, b0, 3);
        } else {
            if (!(l != this.cF && i1 != this.cF || b0 != 4 && b0 != 5)) {
                if (l == this.cF) {
                    par1World.b(par2, par3, par4 - 1, b0, 3);
                } else {
                    par1World.b(par2, par3, par4 + 1, b0, 3);
                }
                par1World.b(par2, par3, par4, b0, 3);
            }
            if (!(j1 != this.cF && k1 != this.cF || b0 != 2 && b0 != 3)) {
                if (j1 == this.cF) {
                    par1World.b(par2 - 1, par3, par4, b0, 3);
                } else {
                    par1World.b(par2 + 1, par3, par4, b0, 3);
                }
                par1World.b(par2, par3, par4, b0, 3);
            }
        }
        if (par6ItemStack.u()) {
            ((ary)par1World.r(par2, par3, par4)).a(par6ItemStack.s());
        }
    }

    public void f_(abw par1World, int par2, int par3, int par4) {
        if (!par1World.I) {
            int b0;
            int l = par1World.a(par2, par3, par4 - 1);
            int i1 = par1World.a(par2, par3, par4 + 1);
            int j1 = par1World.a(par2 - 1, par3, par4);
            int k1 = par1World.a(par2 + 1, par3, par4);
            boolean flag = true;
            if (l != this.cF && i1 != this.cF) {
                if (j1 != this.cF && k1 != this.cF) {
                    b0 = 3;
                    if (aqz.t[l] && !aqz.t[i1]) {
                        b0 = 3;
                    }
                    if (aqz.t[i1] && !aqz.t[l]) {
                        b0 = 2;
                    }
                    if (aqz.t[j1] && !aqz.t[k1]) {
                        b0 = 5;
                    }
                    if (aqz.t[k1] && !aqz.t[j1]) {
                        b0 = 4;
                    }
                } else {
                    int l1 = par1World.a(j1 == this.cF ? par2 - 1 : par2 + 1, par3, par4 - 1);
                    int i2 = par1World.a(j1 == this.cF ? par2 - 1 : par2 + 1, par3, par4 + 1);
                    b0 = 3;
                    boolean flag1 = true;
                    int j2 = j1 == this.cF ? par1World.h(par2 - 1, par3, par4) : par1World.h(par2 + 1, par3, par4);
                    if (j2 == 2) {
                        b0 = 2;
                    }
                    if ((aqz.t[l] || aqz.t[l1]) && !aqz.t[i1] && !aqz.t[i2]) {
                        b0 = 3;
                    }
                    if ((aqz.t[i1] || aqz.t[i2]) && !aqz.t[l] && !aqz.t[l1]) {
                        b0 = 2;
                    }
                }
            } else {
                int l1 = par1World.a(par2 - 1, par3, l == this.cF ? par4 - 1 : par4 + 1);
                int i2 = par1World.a(par2 + 1, par3, l == this.cF ? par4 - 1 : par4 + 1);
                b0 = 5;
                boolean flag1 = true;
                int j2 = l == this.cF ? par1World.h(par2, par3, par4 - 1) : par1World.h(par2, par3, par4 + 1);
                if (j2 == 4) {
                    b0 = 4;
                }
                if ((aqz.t[j1] || aqz.t[l1]) && !aqz.t[k1] && !aqz.t[i2]) {
                    b0 = 5;
                }
                if ((aqz.t[k1] || aqz.t[i2]) && !aqz.t[j1] && !aqz.t[l1]) {
                    b0 = 4;
                }
            }
            par1World.b(par2, par3, par4, b0, 3);
        }
    }

    public boolean c(abw par1World, int par2, int par3, int par4) {
        int l = 0;
        if (par1World.a(par2 - 1, par3, par4) == this.cF) {
            ++l;
        }
        if (par1World.a(par2 + 1, par3, par4) == this.cF) {
            ++l;
        }
        if (par1World.a(par2, par3, par4 - 1) == this.cF) {
            ++l;
        }
        if (par1World.a(par2, par3, par4 + 1) == this.cF) {
            ++l;
        }
        return l > 1 ? false : (this.k(par1World, par2 - 1, par3, par4) ? false : (this.k(par1World, par2 + 1, par3, par4) ? false : (this.k(par1World, par2, par3, par4 - 1) ? false : !this.k(par1World, par2, par3, par4 + 1))));
    }

    private boolean k(abw par1World, int par2, int par3, int par4) {
        return par1World.a(par2, par3, par4) != this.cF ? false : (par1World.a(par2 - 1, par3, par4) == this.cF ? true : (par1World.a(par2 + 1, par3, par4) == this.cF ? true : (par1World.a(par2, par3, par4 - 1) == this.cF ? true : par1World.a(par2, par3, par4 + 1) == this.cF)));
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        super.a(par1World, par2, par3, par4, par5);
        ary tileentitychest = (ary)par1World.r(par2, par3, par4);
        if (tileentitychest != null) {
            tileentitychest.i();
        }
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        ary tileentitychest = (ary)par1World.r(par2, par3, par4);
        if (tileentitychest != null) {
            for (int j1 = 0; j1 < tileentitychest.j_(); ++j1) {
                ye itemstack = tileentitychest.a(j1);
                if (itemstack == null) continue;
                float f = this.b.nextFloat() * 0.8f + 0.1f;
                float f1 = this.b.nextFloat() * 0.8f + 0.1f;
                float f2 = this.b.nextFloat() * 0.8f + 0.1f;
                while (itemstack.b > 0) {
                    int k1 = this.b.nextInt(21) + 10;
                    if (k1 > itemstack.b) {
                        k1 = itemstack.b;
                    }
                    itemstack.b -= k1;
                    ss entityitem = new ss(par1World, (float)par2 + f, (float)par3 + f1, (float)par4 + f2, new ye(itemstack.d, k1, itemstack.k()));
                    float f3 = 0.05f;
                    entityitem.x = (float)this.b.nextGaussian() * f3;
                    entityitem.y = (float)this.b.nextGaussian() * f3 + 0.2f;
                    entityitem.z = (float)this.b.nextGaussian() * f3;
                    if (itemstack.p()) {
                        entityitem.d().d((by)itemstack.q().b());
                    }
                    par1World.d(entityitem);
                }
            }
            par1World.m(par2, par3, par4, par5);
        }
        super.a(par1World, par2, par3, par4, par5, par6);
    }

    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.I) {
            return true;
        }
        mo iinventory = this.g_(par1World, par2, par3, par4);
        if (iinventory != null) {
            par5EntityPlayer.a(iinventory);
        }
        return true;
    }

    public mo g_(abw par1World, int par2, int par3, int par4) {
        ary object = (ary)par1World.r(par2, par3, par4);
        if (object == null) {
            return null;
        }
        if (par1World.isBlockSolidOnSide(par2, par3 + 1, par4, ForgeDirection.DOWN)) {
            return null;
        }
        if (ank.m(par1World, par2, par3, par4)) {
            return null;
        }
        if (par1World.a(par2 - 1, par3, par4) == this.cF && (par1World.isBlockSolidOnSide(par2 - 1, par3 + 1, par4, ForgeDirection.DOWN) || ank.m(par1World, par2 - 1, par3, par4))) {
            return null;
        }
        if (par1World.a(par2 + 1, par3, par4) == this.cF && (par1World.isBlockSolidOnSide(par2 + 1, par3 + 1, par4, ForgeDirection.DOWN) || ank.m(par1World, par2 + 1, par3, par4))) {
            return null;
        }
        if (par1World.a(par2, par3, par4 - 1) == this.cF && (par1World.isBlockSolidOnSide(par2, par3 + 1, par4 - 1, ForgeDirection.DOWN) || ank.m(par1World, par2, par3, par4 - 1))) {
            return null;
        }
        if (par1World.a(par2, par3, par4 + 1) == this.cF && (par1World.isBlockSolidOnSide(par2, par3 + 1, par4 + 1, ForgeDirection.DOWN) || ank.m(par1World, par2, par3, par4 + 1))) {
            return null;
        }
        if (par1World.a(par2 - 1, par3, par4) == this.cF) {
            object = new mn("container.chestDouble", (mo)((ary)par1World.r(par2 - 1, par3, par4)), (mo)object);
        }
        if (par1World.a(par2 + 1, par3, par4) == this.cF) {
            object = new mn("container.chestDouble", (mo)object, (mo)((ary)par1World.r(par2 + 1, par3, par4)));
        }
        if (par1World.a(par2, par3, par4 - 1) == this.cF) {
            object = new mn("container.chestDouble", (mo)((ary)par1World.r(par2, par3, par4 - 1)), (mo)object);
        }
        if (par1World.a(par2, par3, par4 + 1) == this.cF) {
            object = new mn("container.chestDouble", (mo)object, (mo)((ary)par1World.r(par2, par3, par4 + 1)));
        }
        return object;
    }

    public asp b(abw par1World) {
        ary tileentitychest = new ary();
        return tileentitychest;
    }

    public boolean f() {
        return this.a == 1;
    }

    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (!this.f()) {
            return 0;
        }
        int i1 = ((ary)par1IBlockAccess.r((int)par2, (int)par3, (int)par4)).h;
        return ls.a(i1, 0, 15);
    }

    public int c(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par5 == 1 ? this.b(par1IBlockAccess, par2, par3, par4, par5) : 0;
    }

    public static boolean m(abw par0World, int par1, int par2, int par3) {
        rx entityocelot1;
        rx entityocelot;
        Iterator iterator = par0World.a(rx.class, asx.a().a((double)par1, (double)(par2 + 1), (double)par3, (double)(par1 + 1), (double)(par2 + 2), (double)(par3 + 1))).iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while (!(entityocelot = (entityocelot1 = (rx)((Object)iterator.next()))).bU());
        return true;
    }

    public boolean q_() {
        return true;
    }

    public int b_(abw par1World, int par2, int par3, int par4, int par5) {
        return uy.b(this.g_(par1World, par2, par3, par4));
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a("planks_oak");
    }
}

