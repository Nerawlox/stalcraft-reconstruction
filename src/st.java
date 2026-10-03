/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  amy
 *  asx
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  hr
 *  nb
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.IMinecartCollisionHandler
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.minecart.MinecartCollisionEvent
 *  net.minecraftforge.event.entity.minecart.MinecartUpdateEvent
 *  su
 *  sw
 *  sy
 *  sz
 *  tb
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.IMinecartCollisionHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.event.entity.minecart.MinecartUpdateEvent;

public abstract class st
extends nn {
    protected boolean a;
    protected final hr b;
    protected String c;
    protected static final int[][][] d = new int[][][]{new int[][]{{0, 0, -1}, {0, 0, 1}}, new int[][]{{-1, 0, 0}, {1, 0, 0}}, new int[][]{{-1, -1, 0}, {1, 0, 0}}, new int[][]{{-1, 0, 0}, {1, -1, 0}}, new int[][]{{0, 0, -1}, {0, -1, 1}}, new int[][]{{0, -1, -1}, {0, 0, 1}}, new int[][]{{0, 0, 1}, {1, 0, 0}}, new int[][]{{0, 0, 1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {1, 0, 0}}};
    protected int e;
    protected double f;
    protected double g;
    protected double h;
    protected double i;
    protected double j;
    @SideOnly(value=Side.CLIENT)
    protected double au;
    @SideOnly(value=Side.CLIENT)
    protected double av;
    @SideOnly(value=Side.CLIENT)
    protected double aw;
    public static float defaultMaxSpeedAirLateral = 0.4f;
    public static float defaultMaxSpeedAirVertical = -1.0f;
    public static double defaultDragAir = 0.95f;
    protected boolean canUseRail = true;
    protected boolean canBePushed = true;
    private static IMinecartCollisionHandler collisionHandler = null;
    private float currentSpeedRail = this.getMaxCartSpeedOnRail();
    protected float maxSpeedAirLateral = defaultMaxSpeedAirLateral;
    protected float maxSpeedAirVertical = defaultMaxSpeedAirVertical;
    protected double dragAir = defaultDragAir;

    public st(abw par1World) {
        super(par1World);
        this.m = true;
        this.a(0.98f, 0.7f);
        this.N = this.P / 2.0f;
        this.b = par1World != null ? par1World.a(this) : null;
    }

    public static st a(abw par0World, double par1, double par3, double par5, int par7) {
        switch (par7) {
            case 1: {
                return new su(par0World, par1, par3, par5);
            }
            case 2: {
                return new sw(par0World, par1, par3, par5);
            }
            case 3: {
                return new tb(par0World, par1, par3, par5);
            }
            case 4: {
                return new sz(par0World, par1, par3, par5);
            }
            case 5: {
                return new sx(par0World, par1, par3, par5);
            }
        }
        return new sy(par0World, par1, par3, par5);
    }

    @Override
    protected boolean e_() {
        return false;
    }

    @Override
    protected void a() {
        this.ah.a(17, new Integer(0));
        this.ah.a(18, new Integer(1));
        this.ah.a(19, new Float(0.0f));
        this.ah.a(20, new Integer(0));
        this.ah.a(21, new Integer(6));
        this.ah.a(22, (Object)0);
    }

    @Override
    public asx g(nn par1Entity) {
        if (st.getCollisionHandler() != null) {
            return st.getCollisionHandler().getCollisionBox(this, par1Entity);
        }
        return par1Entity.M() ? par1Entity.E : null;
    }

    @Override
    public asx E() {
        if (st.getCollisionHandler() != null) {
            return st.getCollisionHandler().getBoundingBox(this);
        }
        return null;
    }

    @Override
    public boolean M() {
        return this.canBePushed;
    }

    public st(abw par1World, double par2, double par4, double par6) {
        this(par1World);
        this.b(par2, par4, par6);
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.r = par2;
        this.s = par4;
        this.t = par6;
    }

    @Override
    public double Y() {
        return (double)this.P * 0.0 - (double)0.3f;
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (!this.q.I && !this.M) {
            boolean flag;
            if (this.ar()) {
                return false;
            }
            this.h(-this.k());
            this.c(10);
            this.K();
            this.a(this.i() + par2 * 10.0f);
            boolean bl2 = flag = par1DamageSource.i() instanceof uf && ((uf)par1DamageSource.i()).bG.d;
            if (flag || this.i() > 40.0f) {
                if (this.n != null) {
                    this.n.a(this);
                }
                if (flag && !this.c()) {
                    this.x();
                } else {
                    this.a(par1DamageSource);
                }
            }
            return true;
        }
        return true;
    }

    public void a(nb par1DamageSource) {
        this.x();
        ye itemstack = new ye(yc.aB, 1);
        if (this.c != null) {
            itemstack.c(this.c);
        }
        this.a(itemstack, 0.0f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void ad() {
        this.h(-this.k());
        this.c(10);
        this.a(this.i() + this.i() * 10.0f);
    }

    @Override
    public boolean L() {
        return !this.M;
    }

    @Override
    public void x() {
        super.x();
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override
    public void l_() {
        int i2;
        if (this.b != null) {
            this.b.a();
        }
        if (this.j() > 0) {
            this.c(this.j() - 1);
        }
        if (this.i() > 0.0f) {
            this.a(this.i() - 1.0f);
        }
        if (this.v < -64.0) {
            this.C();
        }
        if (!this.q.I && this.q instanceof js) {
            this.q.C.a("portal");
            MinecraftServer minecraftserver = ((js)this.q).p();
            i2 = this.z();
            if (this.ap) {
                if (minecraftserver.u()) {
                    if (this.o == null && this.aq++ >= i2) {
                        this.aq = i2;
                        this.ao = this.ac();
                        int b0 = this.q.t.i == -1 ? 0 : -1;
                        this.b(b0);
                    }
                    this.ap = false;
                }
            } else {
                if (this.aq > 0) {
                    this.aq -= 4;
                }
                if (this.aq < 0) {
                    this.aq = 0;
                }
            }
            if (this.ao > 0) {
                --this.ao;
            }
            this.q.C.b();
        }
        if (this.q.I) {
            if (this.e > 0) {
                double d0 = this.u + (this.f - this.u) / (double)this.e;
                double d1 = this.v + (this.g - this.v) / (double)this.e;
                double d2 = this.w + (this.h - this.w) / (double)this.e;
                double d3 = ls.g(this.i - (double)this.A);
                this.A = (float)((double)this.A + d3 / (double)this.e);
                this.B = (float)((double)this.B + (this.j - (double)this.B) / (double)this.e);
                --this.e;
                this.b(d0, d1, d2);
                this.b(this.A, this.B);
            } else {
                this.b(this.u, this.v, this.w);
                this.b(this.A, this.B);
            }
        } else {
            double d8;
            int k2;
            this.r = this.u;
            this.s = this.v;
            this.t = this.w;
            this.y -= (double)0.04f;
            int j2 = ls.c(this.u);
            if (amy.d_((abw)this.q, (int)j2, (int)((i2 = ls.c(this.v)) - 1), (int)(k2 = ls.c(this.w)))) {
                --i2;
            }
            double d4 = 0.4;
            double d5 = 0.0078125;
            int l2 = this.q.a(j2, i2, k2);
            if (this.canUseRail() && amy.e_((int)l2)) {
                amy rail = (amy)aqz.s[l2];
                float railMaxSpeed = rail.getRailMaxSpeed(this.q, this, j2, i2, k2);
                double maxSpeed = Math.min(railMaxSpeed, this.getCurrentCartSpeedCapOnRail());
                int i1 = rail.getBasicRailMetadata((acf)this.q, this, j2, i2, k2);
                this.a(j2, i2, k2, maxSpeed, this.getSlopeAdjustment(), l2, i1);
                if (l2 == aqz.cy.cF) {
                    this.a(j2, i2, k2, (this.q.h(j2, i2, k2) & 8) != 0);
                }
            } else {
                this.b(this.F ? d4 : (double)this.getMaxSpeedAirLateral());
            }
            this.D();
            this.B = 0.0f;
            double d6 = this.r - this.u;
            double d7 = this.t - this.w;
            if (d6 * d6 + d7 * d7 > 0.001) {
                this.A = (float)(Math.atan2(d7, d6) * 180.0 / Math.PI);
                if (this.a) {
                    this.A += 180.0f;
                }
            }
            if ((d8 = (double)ls.g(this.A - this.C)) < -170.0 || d8 >= 170.0) {
                this.A += 180.0f;
                this.a = !this.a;
            }
            this.b(this.A, this.B);
            asx box = st.getCollisionHandler() != null ? st.getCollisionHandler().getMinecartCollisionBox(this) : this.E.b(0.2, 0.0, 0.2);
            List list = this.q.b((nn)this, box);
            if (list != null && !list.isEmpty()) {
                for (int j1 = 0; j1 < list.size(); ++j1) {
                    nn entity = (nn)list.get(j1);
                    if (entity == this.n || !entity.M() || !(entity instanceof st)) continue;
                    entity.f(this);
                }
            }
            if (this.n != null && this.n.M) {
                if (this.n.o == this) {
                    this.n.o = null;
                }
                this.n = null;
            }
            MinecraftForge.EVENT_BUS.post((Event)new MinecartUpdateEvent(this, (float)j2, (float)i2, (float)k2));
        }
    }

    public void a(int par1, int par2, int par3, boolean par4) {
    }

    protected void b(double par1) {
        if (this.x < -par1) {
            this.x = -par1;
        }
        if (this.x > par1) {
            this.x = par1;
        }
        if (this.z < -par1) {
            this.z = -par1;
        }
        if (this.z > par1) {
            this.z = par1;
        }
        double moveY = this.y;
        if (this.getMaxSpeedAirVertical() > 0.0f && this.y > (double)this.getMaxSpeedAirVertical()) {
            moveY = this.getMaxSpeedAirVertical();
            if (Math.abs(this.x) < (double)0.3f && Math.abs(this.z) < (double)0.3f) {
                this.y = moveY = (double)0.15f;
            }
        }
        if (this.F) {
            this.x *= 0.5;
            this.y *= 0.5;
            this.z *= 0.5;
        }
        this.d(this.x, moveY, this.z);
        if (!this.F) {
            this.x *= this.getDragAir();
            this.y *= this.getDragAir();
            this.z *= this.getDragAir();
        }
    }

    protected void a(int par1, int par2, int par3, double par4, double par6, int par8, int par9) {
        double d10;
        double d9;
        double d8;
        double d7;
        double d6;
        this.T = 0.0f;
        atc vec3 = this.a(this.u, this.v, this.w);
        this.v = par2;
        boolean flag = false;
        boolean flag1 = false;
        if (par8 == aqz.Y.cF) {
            flag = (this.q.h(par1, par2, par3) & 8) != 0;
            boolean bl2 = flag1 = !flag;
        }
        if (((amy)aqz.s[par8]).e()) {
            par9 &= 7;
        }
        if (par9 >= 2 && par9 <= 5) {
            this.v = par2 + 1;
        }
        if (par9 == 2) {
            this.x -= par6;
        }
        if (par9 == 3) {
            this.x += par6;
        }
        if (par9 == 4) {
            this.z += par6;
        }
        if (par9 == 5) {
            this.z -= par6;
        }
        int[][] aint = d[par9];
        double d2 = aint[1][0] - aint[0][0];
        double d3 = aint[1][2] - aint[0][2];
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        double d5 = this.x * d2 + this.z * d3;
        if (d5 < 0.0) {
            d2 = -d2;
            d3 = -d3;
        }
        if ((d6 = Math.sqrt(this.x * this.x + this.z * this.z)) > 2.0) {
            d6 = 2.0;
        }
        this.x = d6 * d2 / d4;
        this.z = d6 * d3 / d4;
        if (this.n != null && this.n instanceof of && (d7 = (double)((of)this.n).bf) > 0.0) {
            d8 = -Math.sin(this.n.A * (float)Math.PI / 180.0f);
            d9 = Math.cos(this.n.A * (float)Math.PI / 180.0f);
            d10 = this.x * this.x + this.z * this.z;
            if (d10 < 0.01) {
                this.x += d8 * 0.1;
                this.z += d9 * 0.1;
                flag1 = false;
            }
        }
        if (flag1 && this.shouldDoRailFunctions()) {
            d7 = Math.sqrt(this.x * this.x + this.z * this.z);
            if (d7 < 0.03) {
                this.x *= 0.0;
                this.y *= 0.0;
                this.z *= 0.0;
            } else {
                this.x *= 0.5;
                this.y *= 0.0;
                this.z *= 0.5;
            }
        }
        d7 = 0.0;
        d8 = (double)par1 + 0.5 + (double)aint[0][0] * 0.5;
        d9 = (double)par3 + 0.5 + (double)aint[0][2] * 0.5;
        d10 = (double)par1 + 0.5 + (double)aint[1][0] * 0.5;
        double d11 = (double)par3 + 0.5 + (double)aint[1][2] * 0.5;
        d2 = d10 - d8;
        d3 = d11 - d9;
        if (d2 == 0.0) {
            this.u = (double)par1 + 0.5;
            d7 = this.w - (double)par3;
        } else if (d3 == 0.0) {
            this.w = (double)par3 + 0.5;
            d7 = this.u - (double)par1;
        } else {
            double d12 = this.u - d8;
            double d13 = this.w - d9;
            d7 = (d12 * d2 + d13 * d3) * 2.0;
        }
        this.u = d8 + d2 * d7;
        this.w = d9 + d3 * d7;
        this.b(this.u, this.v + (double)this.N, this.w);
        this.moveMinecartOnRail(par1, par2, par3, par4);
        if (aint[0][1] != 0 && ls.c(this.u) - par1 == aint[0][0] && ls.c(this.w) - par3 == aint[0][2]) {
            this.b(this.u, this.v + (double)aint[0][1], this.w);
        } else if (aint[1][1] != 0 && ls.c(this.u) - par1 == aint[1][0] && ls.c(this.w) - par3 == aint[1][2]) {
            this.b(this.u, this.v + (double)aint[1][1], this.w);
        }
        this.h();
        atc vec31 = this.a(this.u, this.v, this.w);
        if (vec31 != null && vec3 != null) {
            double d14 = (vec3.d - vec31.d) * 0.05;
            d6 = Math.sqrt(this.x * this.x + this.z * this.z);
            if (d6 > 0.0) {
                this.x = this.x / d6 * (d6 + d14);
                this.z = this.z / d6 * (d6 + d14);
            }
            this.b(this.u, vec31.d, this.w);
        }
        int j1 = ls.c(this.u);
        int k1 = ls.c(this.w);
        if (j1 != par1 || k1 != par3) {
            d6 = Math.sqrt(this.x * this.x + this.z * this.z);
            this.x = d6 * (double)(j1 - par1);
            this.z = d6 * (double)(k1 - par3);
        }
        if (this.shouldDoRailFunctions()) {
            ((amy)aqz.s[par8]).onMinecartPass(this.q, this, par1, par2, par3);
        }
        if (flag && this.shouldDoRailFunctions()) {
            double d15 = Math.sqrt(this.x * this.x + this.z * this.z);
            if (d15 > 0.01) {
                double d16 = 0.06;
                this.x += this.x / d15 * d16;
                this.z += this.z / d15 * d16;
            } else if (par9 == 1) {
                if (this.q.u(par1 - 1, par2, par3)) {
                    this.x = 0.02;
                } else if (this.q.u(par1 + 1, par2, par3)) {
                    this.x = -0.02;
                }
            } else if (par9 == 0) {
                if (this.q.u(par1, par2, par3 - 1)) {
                    this.z = 0.02;
                } else if (this.q.u(par1, par2, par3 + 1)) {
                    this.z = -0.02;
                }
            }
        }
    }

    protected void h() {
        if (this.n != null) {
            this.x *= (double)0.997f;
            this.y *= 0.0;
            this.z *= (double)0.997f;
        } else {
            this.x *= (double)0.96f;
            this.y *= 0.0;
            this.z *= (double)0.96f;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public atc a(double par1, double par3, double par5, double par7) {
        int l2;
        int k2;
        int j2;
        int i2 = ls.c(par1);
        if (amy.d_((abw)this.q, (int)i2, (int)((j2 = ls.c(par3)) - 1), (int)(k2 = ls.c(par5)))) {
            --j2;
        }
        if (!amy.e_((int)(l2 = this.q.a(i2, j2, k2)))) {
            return null;
        }
        int i1 = ((amy)aqz.s[l2]).getBasicRailMetadata((acf)this.q, this, i2, j2, k2);
        par3 = j2;
        if (i1 >= 2 && i1 <= 5) {
            par3 = j2 + 1;
        }
        int[][] aint = d[i1];
        double d4 = aint[1][0] - aint[0][0];
        double d5 = aint[1][2] - aint[0][2];
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        if (aint[0][1] != 0 && ls.c(par1 += (d4 /= d6) * par7) - i2 == aint[0][0] && ls.c(par5 += (d5 /= d6) * par7) - k2 == aint[0][2]) {
            par3 += (double)aint[0][1];
        } else if (aint[1][1] != 0 && ls.c(par1) - i2 == aint[1][0] && ls.c(par5) - k2 == aint[1][2]) {
            par3 += (double)aint[1][1];
        }
        return this.a(par1, par3, par5);
    }

    public atc a(double par1, double par3, double par5) {
        int l2;
        int k2;
        int j2;
        int i2 = ls.c(par1);
        if (amy.d_((abw)this.q, (int)i2, (int)((j2 = ls.c(par3)) - 1), (int)(k2 = ls.c(par5)))) {
            --j2;
        }
        if (amy.e_((int)(l2 = this.q.a(i2, j2, k2)))) {
            int i1 = ((amy)aqz.s[l2]).getBasicRailMetadata((acf)this.q, this, i2, j2, k2);
            par3 = j2;
            if (i1 >= 2 && i1 <= 5) {
                par3 = j2 + 1;
            }
            int[][] aint = d[i1];
            double d3 = 0.0;
            double d4 = (double)i2 + 0.5 + (double)aint[0][0] * 0.5;
            double d5 = (double)j2 + 0.5 + (double)aint[0][1] * 0.5;
            double d6 = (double)k2 + 0.5 + (double)aint[0][2] * 0.5;
            double d7 = (double)i2 + 0.5 + (double)aint[1][0] * 0.5;
            double d8 = (double)j2 + 0.5 + (double)aint[1][1] * 0.5;
            double d9 = (double)k2 + 0.5 + (double)aint[1][2] * 0.5;
            double d10 = d7 - d4;
            double d11 = (d8 - d5) * 2.0;
            double d12 = d9 - d6;
            if (d10 == 0.0) {
                par1 = (double)i2 + 0.5;
                d3 = par5 - (double)k2;
            } else if (d12 == 0.0) {
                par5 = (double)k2 + 0.5;
                d3 = par1 - (double)i2;
            } else {
                double d13 = par1 - d4;
                double d14 = par5 - d6;
                d3 = (d13 * d10 + d14 * d12) * 2.0;
            }
            par1 = d4 + d10 * d3;
            par3 = d5 + d11 * d3;
            par5 = d6 + d12 * d3;
            if (d11 < 0.0) {
                par3 += 1.0;
            }
            if (d11 > 0.0) {
                par3 += 0.5;
            }
            return this.q.V().a(par1, par3, par5);
        }
        return null;
    }

    @Override
    protected void a(by par1NBTTagCompound) {
        if (par1NBTTagCompound.n("CustomDisplayTile")) {
            this.i(par1NBTTagCompound.e("DisplayTile"));
            this.j(par1NBTTagCompound.e("DisplayData"));
            this.k(par1NBTTagCompound.e("DisplayOffset"));
        }
        if (par1NBTTagCompound.b("CustomName") && par1NBTTagCompound.i("CustomName").length() > 0) {
            this.c = par1NBTTagCompound.i("CustomName");
        }
    }

    @Override
    protected void b(by par1NBTTagCompound) {
        if (this.s()) {
            par1NBTTagCompound.a("CustomDisplayTile", true);
            par1NBTTagCompound.a("DisplayTile", this.m() == null ? 0 : this.m().cF);
            par1NBTTagCompound.a("DisplayData", this.o());
            par1NBTTagCompound.a("DisplayOffset", this.q());
        }
        if (this.c != null && this.c.length() > 0) {
            par1NBTTagCompound.a("CustomName", this.c);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float S() {
        return 0.0f;
    }

    @Override
    public void f(nn par1Entity) {
        MinecraftForge.EVENT_BUS.post((Event)new MinecartCollisionEvent(this, par1Entity));
        if (st.getCollisionHandler() != null) {
            st.getCollisionHandler().onEntityCollision(this, par1Entity);
            return;
        }
        if (!this.q.I && par1Entity != this.n) {
            double d1;
            double d0;
            double d2;
            if (par1Entity instanceof of && !(par1Entity instanceof uf) && !(par1Entity instanceof sd) && this.canBeRidden() && this.x * this.x + this.z * this.z > 0.01 && this.n == null && par1Entity.o == null) {
                par1Entity.a(this);
            }
            if ((d2 = (d0 = par1Entity.u - this.u) * d0 + (d1 = par1Entity.w - this.w) * d1) >= (double)1.0E-4f) {
                d2 = ls.a(d2);
                d0 /= d2;
                d1 /= d2;
                double d3 = 1.0 / d2;
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                d0 *= d3;
                d1 *= d3;
                d0 *= (double)0.1f;
                d1 *= (double)0.1f;
                d0 *= (double)(1.0f - this.aa);
                d1 *= (double)(1.0f - this.aa);
                d0 *= 0.5;
                d1 *= 0.5;
                if (par1Entity instanceof st) {
                    atc vec31;
                    double d4 = par1Entity.u - this.u;
                    double d5 = par1Entity.w - this.w;
                    atc vec3 = this.q.V().a(d4, 0.0, d5).a();
                    double d6 = Math.abs(vec3.b(vec31 = this.q.V().a((double)ls.b(this.A * (float)Math.PI / 180.0f), 0.0, (double)ls.a(this.A * (float)Math.PI / 180.0f)).a()));
                    if (d6 < (double)0.8f) {
                        return;
                    }
                    double d7 = par1Entity.x + this.x;
                    double d8 = par1Entity.z + this.z;
                    if (((st)par1Entity).isPoweredCart() && !this.isPoweredCart()) {
                        this.x *= (double)0.2f;
                        this.z *= (double)0.2f;
                        this.g(par1Entity.x - d0, 0.0, par1Entity.z - d1);
                        par1Entity.x *= (double)0.95f;
                        par1Entity.z *= (double)0.95f;
                    } else if (!((st)par1Entity).isPoweredCart() && this.isPoweredCart()) {
                        par1Entity.x *= (double)0.2f;
                        par1Entity.z *= (double)0.2f;
                        par1Entity.g(this.x + d0, 0.0, this.z + d1);
                        this.x *= (double)0.95f;
                        this.z *= (double)0.95f;
                    } else {
                        this.x *= (double)0.2f;
                        this.z *= (double)0.2f;
                        this.g((d7 /= 2.0) - d0, 0.0, (d8 /= 2.0) - d1);
                        par1Entity.x *= (double)0.2f;
                        par1Entity.z *= (double)0.2f;
                        par1Entity.g(d7 + d0, 0.0, d8 + d1);
                    }
                } else {
                    this.g(-d0, 0.0, -d1);
                    par1Entity.g(d0 / 4.0, 0.0, d1 / 4.0);
                }
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.f = par1;
        this.g = par3;
        this.h = par5;
        this.i = par7;
        this.j = par8;
        this.e = par9 + 2;
        this.x = this.au;
        this.y = this.av;
        this.z = this.aw;
    }

    public void a(float par1) {
        this.ah.b(19, Float.valueOf(par1));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void h(double par1, double par3, double par5) {
        this.au = this.x = par1;
        this.av = this.y = par3;
        this.aw = this.z = par5;
    }

    public float i() {
        return this.ah.d(19);
    }

    public void c(int par1) {
        this.ah.b(17, par1);
    }

    public int j() {
        return this.ah.c(17);
    }

    public void h(int par1) {
        this.ah.b(18, par1);
    }

    public int k() {
        return this.ah.c(18);
    }

    public abstract int l();

    public aqz m() {
        if (!this.s()) {
            return this.n();
        }
        int i2 = this.v().c(20) & 0xFFFF;
        return i2 > 0 && i2 < aqz.s.length ? aqz.s[i2] : null;
    }

    public aqz n() {
        return null;
    }

    public int o() {
        return !this.s() ? this.p() : this.v().c(20) >> 16;
    }

    public int p() {
        return 0;
    }

    public int q() {
        return !this.s() ? this.r() : this.v().c(21);
    }

    public int r() {
        return 6;
    }

    public void i(int par1) {
        this.v().b(20, par1 & 0xFFFF | this.o() << 16);
        this.a(true);
    }

    public void j(int par1) {
        aqz block = this.m();
        int j2 = block == null ? 0 : block.cF;
        this.v().b(20, j2 & 0xFFFF | par1 << 16);
        this.a(true);
    }

    public void k(int par1) {
        this.v().b(21, par1);
        this.a(true);
    }

    public boolean s() {
        return this.v().a(22) == 1;
    }

    public void a(boolean par1) {
        this.v().b(22, (byte)(par1 ? 1 : 0));
    }

    public void a(String par1Str) {
        this.c = par1Str;
    }

    @Override
    public String an() {
        return this.c != null ? this.c : super.an();
    }

    public boolean c() {
        return this.c != null;
    }

    public String t() {
        return this.c;
    }

    public void moveMinecartOnRail(int x2, int y2, int z2, double par4) {
        double d12 = this.x;
        double d13 = this.z;
        if (this.n != null) {
            d12 *= 0.75;
            d13 *= 0.75;
        }
        if (d12 < -par4) {
            d12 = -par4;
        }
        if (d12 > par4) {
            d12 = par4;
        }
        if (d13 < -par4) {
            d13 = -par4;
        }
        if (d13 > par4) {
            d13 = par4;
        }
        this.d(d12, 0.0, d13);
    }

    public static IMinecartCollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public static void setCollisionHandler(IMinecartCollisionHandler handler) {
        collisionHandler = handler;
    }

    public ye getCartItem() {
        if (this instanceof su) {
            return new ye(yc.aP);
        }
        if (this instanceof tb) {
            return new ye(yc.cc);
        }
        if (this instanceof sw) {
            return new ye(yc.aQ);
        }
        if (this instanceof sx) {
            return new ye(yc.cd);
        }
        return new ye(yc.aB);
    }

    public boolean canUseRail() {
        return this.canUseRail;
    }

    public void setCanUseRail(boolean use) {
        this.canUseRail = use;
    }

    public boolean shouldDoRailFunctions() {
        return true;
    }

    public boolean isPoweredCart() {
        return this.l() == 2;
    }

    public boolean canBeRidden() {
        return this instanceof sy;
    }

    public float getMaxCartSpeedOnRail() {
        return 1.2f;
    }

    public final float getCurrentCartSpeedCapOnRail() {
        return this.currentSpeedRail;
    }

    public final void setCurrentCartSpeedCapOnRail(float value) {
        this.currentSpeedRail = value = Math.min(value, this.getMaxCartSpeedOnRail());
    }

    public float getMaxSpeedAirLateral() {
        return this.maxSpeedAirLateral;
    }

    public void setMaxSpeedAirLateral(float value) {
        this.maxSpeedAirLateral = value;
    }

    public float getMaxSpeedAirVertical() {
        return this.maxSpeedAirVertical;
    }

    public void setMaxSpeedAirVertical(float value) {
        this.maxSpeedAirVertical = value;
    }

    public double getDragAir() {
        return this.dragAir;
    }

    public void setDragAir(double value) {
        this.dragAir = value;
    }

    public double getSlopeAdjustment() {
        return 0.0078125;
    }
}

