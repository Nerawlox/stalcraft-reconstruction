/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  bu
 *  cpw.mods.fml.common.registry.GameRegistry
 *  kp
 *  ku
 *  nb
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.entity.item.ItemExpireEvent
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 */
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ss
extends nn {
    public int a;
    public int b;
    private int d = 5;
    public float c = (float)(Math.random() * Math.PI * 2.0);
    public int lifespan = 6000;

    public ss(abw par1World, double par2, double par4, double par6) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.N = this.P / 2.0f;
        this.b(par2, par4, par6);
        this.A = (float)(Math.random() * 360.0);
        this.x = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.y = 0.2f;
        this.z = (float)(Math.random() * (double)0.2f - (double)0.1f);
    }

    public ss(abw par1World, double par2, double par4, double par6, ye par8ItemStack) {
        this(par1World, par2, par4, par6);
        this.a(par8ItemStack);
        this.lifespan = par8ItemStack.b() == null ? 6000 : par8ItemStack.b().getEntityLifespan(par8ItemStack, par1World);
    }

    @Override
    protected boolean e_() {
        return false;
    }

    public ss(abw par1World) {
        super(par1World);
        this.a(0.25f, 0.25f);
        this.N = this.P / 2.0f;
    }

    @Override
    protected void a() {
        this.v().a(10, 5);
    }

    @Override
    public void l_() {
        boolean flag;
        ye stack = this.v().f(10);
        if (stack != null && stack.b() != null && stack.b().onEntityItemUpdate(this)) {
            return;
        }
        super.l_();
        if (this.b > 0) {
            --this.b;
        }
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        this.y -= (double)0.04f;
        this.Z = this.i(this.u, (this.E.b + this.E.e) / 2.0, this.w);
        this.d(this.x, this.y, this.z);
        boolean bl2 = flag = (int)this.r != (int)this.u || (int)this.s != (int)this.v || (int)this.t != (int)this.w;
        if (flag || this.ac % 25 == 0) {
            if (this.q.g(ls.c(this.u), ls.c(this.v), ls.c(this.w)) == akc.i) {
                this.y = 0.2f;
                this.x = (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f;
                this.z = (this.ab.nextFloat() - this.ab.nextFloat()) * 0.2f;
                this.a("random.fizz", 0.4f, 2.0f + this.ab.nextFloat() * 0.4f);
            }
            if (!this.q.I) {
                this.e();
            }
        }
        float f2 = 0.98f;
        if (this.F) {
            f2 = 0.58800006f;
            int i2 = this.q.a(ls.c(this.u), ls.c(this.E.b) - 1, ls.c(this.w));
            if (i2 > 0) {
                f2 = aqz.s[i2].cV * 0.98f;
            }
        }
        this.x *= (double)f2;
        this.y *= (double)0.98f;
        this.z *= (double)f2;
        if (this.F) {
            this.y *= -0.5;
        }
        ++this.a;
        ye item = this.v().f(10);
        if (!this.q.I && this.a >= this.lifespan) {
            if (item != null) {
                ItemExpireEvent event = new ItemExpireEvent(this, item.b() == null ? 6000 : item.b().getEntityLifespan(item, this.q));
                if (MinecraftForge.EVENT_BUS.post((Event)event)) {
                    this.lifespan += event.extraLife;
                } else {
                    this.x();
                }
            } else {
                this.x();
            }
        }
        if (item != null && item.b <= 0) {
            this.x();
        }
    }

    private void e() {
        for (ss entityitem : this.q.a(ss.class, this.E.b(0.5, 0.0, 0.5))) {
            this.a(entityitem);
        }
    }

    public boolean a(ss par1EntityItem) {
        if (par1EntityItem == this) {
            return false;
        }
        if (par1EntityItem.T() && this.T()) {
            ye itemstack = this.d();
            ye itemstack1 = par1EntityItem.d();
            if (itemstack1.b() != itemstack.b()) {
                return false;
            }
            if (itemstack1.p() ^ itemstack.p()) {
                return false;
            }
            if (itemstack1.p() && !itemstack1.q().equals((Object)itemstack.q())) {
                return false;
            }
            if (itemstack1.b().n() && itemstack1.k() != itemstack.k()) {
                return false;
            }
            if (itemstack1.b < itemstack.b) {
                return par1EntityItem.a(this);
            }
            if (itemstack1.b + itemstack.b > itemstack1.e()) {
                return false;
            }
            itemstack1.b += itemstack.b;
            par1EntityItem.b = Math.max(par1EntityItem.b, this.b);
            par1EntityItem.a = Math.min(par1EntityItem.a, this.a);
            par1EntityItem.a(itemstack1);
            this.x();
            return true;
        }
        return false;
    }

    public void c() {
        this.a = 4800;
    }

    @Override
    public boolean I() {
        return this.q.a(this.E, akc.h, (nn)this);
    }

    @Override
    protected void e(int par1) {
        this.a(nb.a, (float)par1);
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        if (this.d() != null && this.d().d == yc.bU.cv && par1DamageSource.c()) {
            return false;
        }
        this.K();
        this.d = (int)((float)this.d - par2);
        if (this.d <= 0) {
            this.x();
        }
        return false;
    }

    @Override
    public void b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("Health", (short)((byte)this.d));
        par1NBTTagCompound.a("Age", (short)this.a);
        par1NBTTagCompound.a("Lifespan", this.lifespan);
        if (this.d() != null) {
            par1NBTTagCompound.a("Item", this.d().b(new by()));
        }
    }

    @Override
    public void a(by par1NBTTagCompound) {
        this.d = par1NBTTagCompound.d("Health") & 0xFF;
        this.a = par1NBTTagCompound.d("Age");
        by nbttagcompound1 = par1NBTTagCompound.l("Item");
        this.a(ye.a(nbttagcompound1));
        ye item = this.v().f(10);
        if (item == null || item.b <= 0) {
            this.x();
        }
        if (par1NBTTagCompound.b("Lifespan")) {
            this.lifespan = par1NBTTagCompound.e("Lifespan");
        }
    }

    @Override
    public void b_(uf par1EntityPlayer) {
        if (!this.q.I) {
            if (this.b > 0) {
                return;
            }
            EntityItemPickupEvent event = new EntityItemPickupEvent(par1EntityPlayer, this);
            if (MinecraftForge.EVENT_BUS.post((Event)event)) {
                return;
            }
            ye itemstack = this.d();
            int i2 = itemstack.b;
            if (this.b <= 0 && (event.getResult() == Event.Result.ALLOW || i2 <= 0 || par1EntityPlayer.bn.a(itemstack))) {
                if (itemstack.d == aqz.O.cF) {
                    par1EntityPlayer.a((ku)kp.g);
                }
                if (itemstack.d == yc.aH.cv) {
                    par1EntityPlayer.a((ku)kp.t);
                }
                if (itemstack.d == yc.p.cv) {
                    par1EntityPlayer.a((ku)kp.w);
                }
                if (itemstack.d == yc.bq.cv) {
                    par1EntityPlayer.a((ku)kp.z);
                }
                GameRegistry.onPickupNotification((uf)par1EntityPlayer, (ss)this);
                this.a("random.pop", 0.2f, ((this.ab.nextFloat() - this.ab.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                par1EntityPlayer.a((nn)this, i2);
                if (itemstack.b <= 0) {
                    this.x();
                }
            }
        }
    }

    @Override
    public String an() {
        return bu.a((String)("item." + this.d().a()));
    }

    @Override
    public boolean aq() {
        return false;
    }

    @Override
    public void b(int par1) {
        super.b(par1);
        if (!this.q.I) {
            this.e();
        }
    }

    public ye d() {
        ye itemstack = this.v().f(10);
        if (itemstack == null) {
            if (this.q != null) {
                this.q.Y().c("Item entity " + this.k + " has no item?!");
            }
            return new ye(aqz.y);
        }
        return itemstack;
    }

    public void a(ye par1ItemStack) {
        this.v().b(10, par1ItemStack);
        this.v().h(10);
    }
}

