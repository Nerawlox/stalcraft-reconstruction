/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ni
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class uu
extends uq {
    private ye c;

    public uu(abw par1World) {
        super(par1World);
    }

    public uu(abw par1World, of par2EntityLivingBase, int par3) {
        this(par1World, par2EntityLivingBase, new ye(yc.bu, 1, par3));
    }

    public uu(abw par1World, of par2EntityLivingBase, ye par3ItemStack) {
        super(par1World, par2EntityLivingBase);
        this.c = par3ItemStack;
    }

    @SideOnly(value=Side.CLIENT)
    public uu(abw par1World, double par2, double par4, double par6, int par8) {
        this(par1World, par2, par4, par6, new ye(yc.bu, 1, par8));
    }

    public uu(abw par1World, double par2, double par4, double par6, ye par8ItemStack) {
        super(par1World, par2, par4, par6);
        this.c = par8ItemStack;
    }

    @Override
    protected float e() {
        return 0.05f;
    }

    @Override
    protected float c() {
        return 0.5f;
    }

    @Override
    protected float d() {
        return -20.0f;
    }

    public void a(int par1) {
        if (this.c == null) {
            this.c = new ye(yc.bu, 1, 0);
        }
        this.c.b(par1);
    }

    public int i() {
        if (this.c == null) {
            this.c = new ye(yc.bu, 1, 0);
        }
        return this.c.k();
    }

    @Override
    protected void a(ata par1MovingObjectPosition) {
        if (!this.q.I) {
            asx axisalignedbb;
            List list1;
            List list = yc.bu.g(this.c);
            if (list != null && !list.isEmpty() && (list1 = this.q.a(of.class, axisalignedbb = this.E.b(4.0, 2.0, 4.0))) != null && !list1.isEmpty()) {
                for (of entitylivingbase : list1) {
                    double d0 = this.e(entitylivingbase);
                    if (!(d0 < 16.0)) continue;
                    double d1 = 1.0 - Math.sqrt(d0) / 4.0;
                    if (entitylivingbase == par1MovingObjectPosition.g) {
                        d1 = 1.0;
                    }
                    for (nj potioneffect : list) {
                        int i2 = potioneffect.a();
                        if (ni.a[i2].b()) {
                            ni.a[i2].a(this.h(), entitylivingbase, potioneffect.c(), d1);
                            continue;
                        }
                        int j2 = (int)(d1 * (double)potioneffect.b() + 0.5);
                        if (j2 <= 20) continue;
                        entitylivingbase.c(new nj(i2, j2, potioneffect.c()));
                    }
                }
            }
            this.q.e(2002, (int)Math.round(this.u), (int)Math.round(this.v), (int)Math.round(this.w), this.i());
            this.x();
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        if (par1NBTTagCompound.b("Potion")) {
            this.c = ye.a(par1NBTTagCompound.l("Potion"));
        } else {
            this.a(par1NBTTagCompound.e("potionValue"));
        }
        if (this.c == null) {
            this.x();
        }
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        if (this.c != null) {
            par1NBTTagCompound.a("Potion", this.c.b(new by()));
        }
    }
}

