/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ash
 *  mo
 *  nb
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.minecart.MinecartInteractEvent
 *  nw
 *  sv
 */
import java.util.List;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class sx
extends sv
implements ash {
    private boolean a = true;
    private int b = -1;

    public sx(abw par1World) {
        super(par1World);
    }

    public sx(abw par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public int l() {
        return 5;
    }

    public aqz n() {
        return aqz.cv;
    }

    public int r() {
        return 1;
    }

    public int j_() {
        return 5;
    }

    public boolean c(uf par1EntityPlayer) {
        if (MinecraftForge.EVENT_BUS.post((Event)new MinecartInteractEvent((st)((Object)this), par1EntityPlayer))) {
            return true;
        }
        if (!this.q.I) {
            par1EntityPlayer.a(this);
        }
        return true;
    }

    public void a(int par1, int par2, int par3, boolean par4) {
        boolean flag1;
        boolean bl2 = flag1 = !par4;
        if (flag1 != this.u()) {
            this.f(flag1);
        }
    }

    public boolean u() {
        return this.a;
    }

    public void f(boolean par1) {
        this.a = par1;
    }

    public abw az() {
        return this.q;
    }

    public double aA() {
        return this.u;
    }

    public double aB() {
        return this.v;
    }

    public double aC() {
        return this.w;
    }

    public void l_() {
        super.l_();
        if (!this.q.I && this.T() && this.u()) {
            --this.b;
            if (!this.aE()) {
                this.l(0);
                if (this.aD()) {
                    this.l(4);
                    this.e();
                }
            }
        }
    }

    public boolean aD() {
        if (asi.a(this)) {
            return true;
        }
        List list = this.q.a(ss.class, this.E.b(0.25, 0.0, 0.25), nw.a);
        if (list.size() > 0) {
            asi.a((mo)this, (ss)list.get(0));
        }
        return false;
    }

    public void a(nb par1DamageSource) {
        super.a(par1DamageSource);
        this.a(aqz.cv.cF, 1, 0.0f);
    }

    protected void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("TransferCooldown", this.b);
    }

    protected void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.b = par1NBTTagCompound.e("TransferCooldown");
    }

    public void l(int par1) {
        this.b = par1;
    }

    public boolean aE() {
        return this.b > 0;
    }
}

