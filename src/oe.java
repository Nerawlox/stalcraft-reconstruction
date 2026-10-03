/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  oc
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class oe
extends oc {
    public oe(abw par1World) {
        super(par1World);
    }

    public oe(abw par1World, int par2, int par3, int par4) {
        super(par1World, par2, par3, par4, 0);
        this.b((double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5);
    }

    protected void a() {
        super.a();
    }

    public void a(int par1) {
    }

    public int d() {
        return 9;
    }

    public int e() {
        return 9;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean a(double par1) {
        return par1 < 1024.0;
    }

    public void b(nn par1Entity) {
    }

    public boolean d(by par1NBTTagCompound) {
        return false;
    }

    public void b(by par1NBTTagCompound) {
    }

    public void a(by par1NBTTagCompound) {
    }

    public boolean c(uf par1EntityPlayer) {
        List list;
        double d0;
        ye itemstack = par1EntityPlayer.aZ();
        boolean flag = false;
        if (itemstack != null && itemstack.d == yc.ch.cv && !this.q.I) {
            d0 = 7.0;
            list = this.q.a(og.class, asx.a().a(this.u - d0, this.v - d0, this.w - d0, this.u + d0, this.v + d0, this.w + d0));
            if (list != null) {
                for (og entityliving : list) {
                    if (!entityliving.bH() || entityliving.bI() != par1EntityPlayer) continue;
                    entityliving.b((nn)((Object)this), true);
                    flag = true;
                }
            }
        }
        if (!this.q.I && !flag) {
            this.x();
            if (par1EntityPlayer.bG.d) {
                d0 = 7.0;
                list = this.q.a(og.class, asx.a().a(this.u - d0, this.v - d0, this.w - d0, this.u + d0, this.v + d0, this.w + d0));
                if (list != null) {
                    for (og entityliving : list) {
                        if (!entityliving.bH() || entityliving.bI() != this) continue;
                        entityliving.a(true, false);
                    }
                }
            }
        }
        return true;
    }

    public boolean c() {
        int i2 = this.q.a(this.b, this.c, this.d);
        return aqz.s[i2] != null && aqz.s[i2].d() == 11;
    }

    public static oe a(abw par0World, int par1, int par2, int par3) {
        oe entityleashknot = new oe(par0World, par1, par2, par3);
        entityleashknot.p = true;
        par0World.d((nn)((Object)entityleashknot));
        return entityleashknot;
    }

    public static oe b(abw par0World, int par1, int par2, int par3) {
        List list = par0World.a(oe.class, asx.a().a((double)par1 - 1.0, (double)par2 - 1.0, (double)par3 - 1.0, (double)par1 + 1.0, (double)par2 + 1.0, (double)par3 + 1.0));
        Object object = null;
        if (list != null) {
            for (oe entityleashknot : list) {
                if (entityleashknot.b != par1 || entityleashknot.c != par2 || entityleashknot.d != par3) continue;
                return entityleashknot;
            }
        }
        return null;
    }
}

