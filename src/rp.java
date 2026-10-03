/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 *  nk
 *  nl
 *  os
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public abstract class rp
extends nk
implements nl {
    public int bp;
    private int bq;

    public rp(abw par1World) {
        super(par1World);
    }

    protected void bk() {
        if (this.b() != 0) {
            this.bp = 0;
        }
        super.bk();
    }

    public void c() {
        super.c();
        if (this.b() != 0) {
            this.bp = 0;
        }
        if (this.bp > 0) {
            --this.bp;
            String s2 = "heart";
            if (this.bp % 10 == 0) {
                double d0 = this.ab.nextGaussian() * 0.02;
                double d1 = this.ab.nextGaussian() * 0.02;
                double d2 = this.ab.nextGaussian() * 0.02;
                this.q.a(s2, this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + 0.5 + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, d0, d1, d2);
            }
        } else {
            this.bq = 0;
        }
    }

    protected void a(nn par1Entity, float par2) {
        if (par1Entity instanceof uf) {
            uf entityplayer;
            if (par2 < 3.0f) {
                double d0 = par1Entity.u - this.u;
                double d1 = par1Entity.w - this.w;
                this.A = (float)(Math.atan2(d1, d0) * 180.0 / Math.PI) - 90.0f;
                this.bn = true;
            }
            if ((entityplayer = (uf)par1Entity).by() == null || !this.c(entityplayer.by())) {
                this.j = null;
            }
        } else if (par1Entity instanceof rp) {
            rp entityanimal = (rp)((Object)par1Entity);
            if (this.b() > 0 && entityanimal.b() < 0) {
                if ((double)par2 < 2.5) {
                    this.bn = true;
                }
            } else if (this.bp > 0 && entityanimal.bp > 0) {
                if (entityanimal.j == null) {
                    entityanimal.j = this;
                }
                if (entityanimal.j == this && (double)par2 < 3.5) {
                    ++entityanimal.bp;
                    ++this.bp;
                    ++this.bq;
                    if (this.bq % 4 == 0) {
                        this.q.a("heart", this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + 0.5 + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, 0.0, 0.0, 0.0);
                    }
                    if (this.bq == 60) {
                        this.b((rp)((Object)par1Entity));
                    }
                } else {
                    this.bq = 0;
                }
            } else {
                this.bq = 0;
                this.j = null;
            }
        }
    }

    private void b(rp par1EntityAnimal) {
        nk entityageable = this.a(par1EntityAnimal);
        if (entityageable != null) {
            this.c(6000);
            par1EntityAnimal.c(6000);
            this.bp = 0;
            this.bq = 0;
            this.j = null;
            par1EntityAnimal.j = null;
            par1EntityAnimal.bq = 0;
            par1EntityAnimal.bp = 0;
            entityageable.c(-24000);
            entityageable.b(this.u, this.v, this.w, this.A, this.B);
            for (int i2 = 0; i2 < 7; ++i2) {
                double d0 = this.ab.nextGaussian() * 0.02;
                double d1 = this.ab.nextGaussian() * 0.02;
                double d2 = this.ab.nextGaussian() * 0.02;
                this.q.a("heart", this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + 0.5 + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, d0, d1, d2);
            }
            this.q.d((nn)entityageable);
        }
    }

    public boolean a(nb par1DamageSource, float par2) {
        os attributeinstance;
        if (this.ar()) {
            return false;
        }
        this.bo = 60;
        if (!this.bf() && (attributeinstance = this.a(tp.d)).a(h) == null) {
            attributeinstance.a(i);
        }
        this.j = null;
        this.bp = 0;
        return super.a(par1DamageSource, par2);
    }

    public float a(int par1, int par2, int par3) {
        return this.q.a(par1, par2 - 1, par3) == aqz.z.cF ? 10.0f : this.q.q(par1, par2, par3) - 0.5f;
    }

    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("InLove", this.bp);
    }

    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.bp = par1NBTTagCompound.e("InLove");
    }

    protected nn bL() {
        block5: {
            float f2;
            block6: {
                block4: {
                    if (this.bo > 0) {
                        return null;
                    }
                    f2 = 8.0f;
                    if (this.bp <= 0) break block4;
                    List list = this.q.a(((Object)((Object)this)).getClass(), this.E.b((double)f2, (double)f2, (double)f2));
                    for (int i2 = 0; i2 < list.size(); ++i2) {
                        rp entityanimal = (rp)((Object)list.get(i2));
                        if (entityanimal == this || entityanimal.bp <= 0) continue;
                        return entityanimal;
                    }
                    break block5;
                }
                if (this.b() != 0) break block6;
                List list = this.q.a(uf.class, this.E.b((double)f2, (double)f2, (double)f2));
                for (int i3 = 0; i3 < list.size(); ++i3) {
                    uf entityplayer = (uf)list.get(i3);
                    if (entityplayer.by() == null || !this.c(entityplayer.by())) continue;
                    return entityplayer;
                }
                break block5;
            }
            if (this.b() <= 0) break block5;
            List list = this.q.a(((Object)((Object)this)).getClass(), this.E.b((double)f2, (double)f2, (double)f2));
            for (int i4 = 0; i4 < list.size(); ++i4) {
                rp entityanimal = (rp)((Object)list.get(i4));
                if (entityanimal == this || entityanimal.b() >= 0) continue;
                return entityanimal;
            }
        }
        return null;
    }

    public boolean bs() {
        int k2;
        int j2;
        int i2 = ls.c(this.u);
        return this.q.a(i2, (j2 = ls.c(this.E.b)) - 1, k2 = ls.c(this.w)) == aqz.z.cF && this.q.m(i2, j2, k2) > 8 && super.bs();
    }

    public int o() {
        return 120;
    }

    protected boolean t() {
        return false;
    }

    protected int e(uf par1EntityPlayer) {
        return 1 + this.q.s.nextInt(3);
    }

    public boolean c(ye par1ItemStack) {
        return par1ItemStack.d == yc.V.cv;
    }

    public boolean a(uf par1EntityPlayer) {
        ye itemstack = par1EntityPlayer.bn.h();
        if (itemstack != null && this.c(itemstack) && this.b() == 0 && this.bp <= 0) {
            if (!par1EntityPlayer.bG.d) {
                --itemstack.b;
                if (itemstack.b <= 0) {
                    par1EntityPlayer.bn.a(par1EntityPlayer.bn.c, (ye)null);
                }
            }
            this.bX();
            return true;
        }
        return super.a(par1EntityPlayer);
    }

    public void bX() {
        this.bp = 600;
        this.j = null;
        this.q.a((nn)((Object)this), (byte)18);
    }

    public boolean bY() {
        return this.bp > 0;
    }

    public void bZ() {
        this.bp = 0;
    }

    public boolean a(rp par1EntityAnimal) {
        return par1EntityAnimal == this ? false : (((Object)((Object)par1EntityAnimal)).getClass() != ((Object)((Object)this)).getClass() ? false : this.bY() && par1EntityAnimal.bY());
    }

    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 18) {
            for (int i2 = 0; i2 < 7; ++i2) {
                double d0 = this.ab.nextGaussian() * 0.02;
                double d1 = this.ab.nextGaussian() * 0.02;
                double d2 = this.ab.nextGaussian() * 0.02;
                this.q.a("heart", this.u + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, this.v + 0.5 + (double)(this.ab.nextFloat() * this.P), this.w + (double)(this.ab.nextFloat() * this.O * 2.0f) - (double)this.O, d0, d1, d2);
            }
        } else {
            super.a(par1);
        }
    }
}

