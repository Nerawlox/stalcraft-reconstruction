/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  tn
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bhz
extends bgu {
    private static final bjo o = new bjo("textures/entity/zombie_pigman.png");
    private static final bjo p = new bjo("textures/entity/zombie/zombie.png");
    private static final bjo q = new bjo("textures/entity/zombie/zombie_villager.png");
    private bbj r = this.a;
    private bci s = new bci();
    protected bbj k;
    protected bbj l;
    protected bbj m;
    protected bbj n;
    private int t = 1;

    public bhz() {
        super(new bcm(), 0.5f, 1.0f);
    }

    @Override
    protected void b() {
        this.g = new bcm(1.0f, true);
        this.h = new bcm(0.5f, true);
        this.k = this.g;
        this.l = this.h;
        this.m = new bci(1.0f, 0.0f, true);
        this.n = new bci(0.5f, 0.0f, true);
    }

    protected int a(tw par1EntityZombie, int par2, float par3) {
        this.b(par1EntityZombie);
        return super.a(par1EntityZombie, par2, par3);
    }

    public void a(tw par1EntityZombie, double par2, double par4, double par6, float par8, float par9) {
        this.b(par1EntityZombie);
        super.a(par1EntityZombie, par2, par4, par6, par8, par9);
    }

    protected bjo a(tw par1EntityZombie) {
        return par1EntityZombie instanceof tn ? o : (par1EntityZombie.bT() ? q : p);
    }

    protected void a(tw par1EntityZombie, float par2) {
        this.b(par1EntityZombie);
        super.a((og)par1EntityZombie, par2);
    }

    private void b(tw par1EntityZombie) {
        if (par1EntityZombie.bT()) {
            if (this.t != this.s.a()) {
                this.s = new bci();
                this.t = this.s.a();
                this.m = new bci(1.0f, 0.0f, true);
                this.n = new bci(0.5f, 0.0f, true);
            }
            this.i = this.s;
            this.g = this.m;
            this.h = this.n;
        } else {
            this.i = this.r;
            this.g = this.k;
            this.h = this.l;
        }
        this.a = (bbj)this.i;
    }

    protected void a(tw par1EntityZombie, float par2, float par3, float par4) {
        if (par1EntityZombie.bV()) {
            par3 += (float)(Math.cos((double)par1EntityZombie.ac * 3.25) * Math.PI * 0.25);
        }
        super.a((of)par1EntityZombie, par2, par3, par4);
    }

    @Override
    protected void a(og par1EntityLiving, float par2) {
        this.a((tw)par1EntityLiving, par2);
    }

    @Override
    protected bjo a(og par1EntityLiving) {
        return this.a((tw)par1EntityLiving);
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.a((tw)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected int a(og par1EntityLiving, int par2, float par3) {
        return this.a((tw)par1EntityLiving, par2, par3);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((tw)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((tw)par1EntityLivingBase, par2);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        this.a((tw)par1EntityLivingBase, par2, par3, par4);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((tw)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((tw)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((tw)par1Entity, par2, par4, par6, par8, par9);
    }
}

