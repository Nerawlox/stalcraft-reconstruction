/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.common.IShearable
 *  nk
 *  oi
 *  pn
 *  pp
 *  ps
 *  qj
 *  qm
 *  qu
 *  sa
 *  vk
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraftforge.common.IShearable;

public class rz
extends rp
implements IShearable {
    private final vk bq = new vk((uy)new sa(this), 2, 1);
    public static final float[][] bp = new float[][]{{1.0f, 1.0f, 1.0f}, {0.85f, 0.5f, 0.2f}, {0.7f, 0.3f, 0.85f}, {0.4f, 0.6f, 0.85f}, {0.9f, 0.9f, 0.2f}, {0.5f, 0.8f, 0.1f}, {0.95f, 0.5f, 0.65f}, {0.3f, 0.3f, 0.3f}, {0.6f, 0.6f, 0.6f}, {0.3f, 0.5f, 0.6f}, {0.5f, 0.25f, 0.7f}, {0.2f, 0.3f, 0.7f}, {0.4f, 0.3f, 0.2f}, {0.4f, 0.5f, 0.2f}, {0.6f, 0.2f, 0.2f}, {0.1f, 0.1f, 0.1f}};
    private int br;
    private pn bs = new pn((og)((Object)this));

    public rz(abw par1World) {
        super(par1World);
        this.a(0.9f, 1.3f);
        this.k().a(true);
        this.c.a(0, (ps)new pp((og)((Object)this)));
        this.c.a(1, (ps)new qj((on)((Object)this), 1.25));
        this.c.a(2, (ps)new pk(this, 1.0));
        this.c.a(3, (ps)new qu((on)((Object)this), 1.1, yc.V.cv, false));
        this.c.a(4, (ps)new pr(this, 1.1));
        this.c.a(5, (ps)this.bs);
        this.c.a(6, (ps)new qm((on)((Object)this), 1.0));
        this.c.a(7, (ps)new px((og)((Object)this), uf.class, 6.0f));
        this.c.a(8, (ps)new ql((og)((Object)this)));
        this.bq.a(0, new ye(yc.aY, 1, 0));
        this.bq.a(1, new ye(yc.aY, 1, 0));
    }

    protected boolean bf() {
        return true;
    }

    protected void bi() {
        this.br = this.bs.f();
        super.bi();
    }

    @Override
    public void c() {
        if (this.q.I) {
            this.br = Math.max(0, this.br - 1);
        }
        super.c();
    }

    protected void az() {
        super.az();
        this.a(tp.a).a(8.0);
        this.a(tp.d).a((double)0.23f);
    }

    protected void a() {
        super.a();
        this.ah.a(16, new Byte(0));
    }

    protected void b(boolean par1, int par2) {
        if (!this.bU()) {
            this.a(new ye(aqz.ag.cF, 1, this.bT()), 0.0f);
        }
    }

    protected int s() {
        return aqz.ag.cF;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(byte par1) {
        if (par1 == 10) {
            this.br = 40;
        } else {
            super.a(par1);
        }
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        return super.a(par1EntityPlayer);
    }

    @SideOnly(value=Side.CLIENT)
    public float p(float par1) {
        return this.br <= 0 ? 0.0f : (this.br >= 4 && this.br <= 36 ? 1.0f : (this.br < 4 ? ((float)this.br - par1) / 4.0f : -((float)(this.br - 40) - par1) / 4.0f));
    }

    @SideOnly(value=Side.CLIENT)
    public float q(float par1) {
        if (this.br > 4 && this.br <= 36) {
            float f1 = ((float)(this.br - 4) - par1) / 32.0f;
            return 0.62831855f + 0.2199115f * ls.a(f1 * 28.7f);
        }
        return this.br > 0 ? 0.62831855f : this.B / 57.295776f;
    }

    @Override
    public void b(by par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("Sheared", this.bU());
        par1NBTTagCompound.a("Color", (byte)this.bT());
    }

    @Override
    public void a(by par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.i(par1NBTTagCompound.n("Sheared"));
        this.p(par1NBTTagCompound.c("Color"));
    }

    protected String r() {
        return "mob.sheep.say";
    }

    protected String aO() {
        return "mob.sheep.say";
    }

    protected String aP() {
        return "mob.sheep.say";
    }

    protected void a(int par1, int par2, int par3, int par4) {
        this.a("mob.sheep.step", 0.15f, 1.0f);
    }

    public int bT() {
        return this.ah.a(16) & 0xF;
    }

    public void p(int par1) {
        byte b0 = this.ah.a(16);
        this.ah.b(16, (byte)(b0 & 0xF0 | par1 & 0xF));
    }

    public boolean bU() {
        return (this.ah.a(16) & 0x10) != 0;
    }

    public void i(boolean par1) {
        byte b0 = this.ah.a(16);
        if (par1) {
            this.ah.b(16, (byte)(b0 | 0x10));
        } else {
            this.ah.b(16, (byte)(b0 & 0xFFFFFFEF));
        }
    }

    public static int a(Random par0Random) {
        int i2 = par0Random.nextInt(100);
        return i2 < 5 ? 15 : (i2 < 10 ? 7 : (i2 < 15 ? 8 : (i2 < 18 ? 12 : (par0Random.nextInt(500) == 0 ? 6 : 0))));
    }

    public rz b(nk par1EntityAgeable) {
        rz entitysheep = (rz)par1EntityAgeable;
        rz entitysheep1 = new rz(this.q);
        int i2 = this.a(this, entitysheep);
        entitysheep1.p(15 - i2);
        return entitysheep1;
    }

    public void n() {
        this.i(false);
        if (this.g_()) {
            this.a(60);
        }
    }

    public oi a(oi par1EntityLivingData) {
        par1EntityLivingData = super.a(par1EntityLivingData);
        this.p(rz.a(this.q.s));
        return par1EntityLivingData;
    }

    private int a(rp par1EntityAnimal, rp par2EntityAnimal) {
        int i2 = this.b(par1EntityAnimal);
        int j2 = this.b(par2EntityAnimal);
        this.bq.a(0).b(i2);
        this.bq.a(1).b(j2);
        ye itemstack = aaf.a().a(this.bq, ((rz)par1EntityAnimal).q);
        int k2 = itemstack != null && itemstack.b().cv == yc.aY.cv ? itemstack.k() : (this.q.s.nextBoolean() ? i2 : j2);
        return k2;
    }

    private int b(rp par1EntityAnimal) {
        return 15 - ((rz)par1EntityAnimal).bT();
    }

    public nk a(nk par1EntityAgeable) {
        return this.b(par1EntityAgeable);
    }

    public boolean isShearable(ye item, abw world, int X, int Y, int Z) {
        return !this.bU() && !this.g_();
    }

    public ArrayList<ye> onSheared(ye item, abw world, int X, int Y, int Z, int fortune) {
        ArrayList<ye> ret = new ArrayList<ye>();
        this.i(true);
        int i2 = 1 + this.ab.nextInt(3);
        for (int j2 = 0; j2 < i2; ++j2) {
            ret.add(new ye(aqz.ag.cF, 1, this.bT()));
        }
        this.q.a((nn)((Object)this), "mob.sheep.shear", 1.0f, 1.0f);
        return ret;
    }
}

