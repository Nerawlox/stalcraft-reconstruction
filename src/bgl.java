/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbf
 *  bbo
 *  bbr
 *  bbu
 *  bbv
 *  bcb
 *  bga
 *  bgb
 *  bgc
 *  bgd
 *  bge
 *  bgf
 *  bgh
 *  bgi
 *  bgr
 *  bgs
 *  bgt
 *  bgv
 *  bgy
 *  bhd
 *  bhg
 *  bhi
 *  bhk
 *  bhl
 *  bhm
 *  bho
 *  bhq
 *  bhu
 *  bhv
 *  bhy
 *  bim
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 *  oa
 *  od
 *  ol
 *  org.lwjgl.opengl.GL11
 *  rw
 *  sj
 *  sp
 *  sr
 *  sz
 *  tb
 *  te
 *  tg
 *  tk
 *  tl
 *  tq
 *  u
 *  um
 *  uo
 *  up
 *  ur
 *  us
 *  ut
 *  uv
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgl {
    public Map q = new HashMap();
    public static bgl a = new bgl();
    private avi r;
    public static double b;
    public static double c;
    public static double d;
    public bim e;
    public bfj f;
    public abw g;
    public of h;
    public of i;
    public float j;
    public float k;
    public aul l;
    public double m;
    public double n;
    public double o;
    public static boolean p;

    private bgl() {
        this.q.put(te.class, new bgd());
        this.q.put(tt.class, new bhp());
        this.q.put(ry.class, new bhi((bbo)new bbr(), (bbo)new bbr(0.5f), 0.7f));
        this.q.put(rz.class, new bhk((bbo)new bbv(), (bbo)new bbu(), 0.7f));
        this.q.put(rr.class, new bgf((bbo)new bbf(), 0.7f));
        this.q.put(rw.class, new bhf((bbo)new bbf(), 0.7f));
        this.q.put(sf.class, new bhy((bbo)new bcl(), (bbo)new bcl(), 0.5f));
        this.q.put(rq.class, new bge((bbo)new bbe(), 0.3f));
        this.q.put(rx.class, new bhg((bbo)new bbq(), 0.4f));
        this.q.put(tq.class, new bhl());
        this.q.put(tf.class, new bgg());
        this.q.put(tg.class, new bgk());
        this.q.put(sb.class, new bho());
        this.q.put(tr.class, new bhm());
        this.q.put(tv.class, new bhv());
        this.q.put(td.class, new bgb());
        this.q.put(tw.class, new bhz());
        this.q.put(ts.class, new bhn((bbo)new bcb(16), (bbo)new bcb(0), 0.25f));
        this.q.put(tl.class, new bgy());
        this.q.put(uf.class, new bhj());
        this.q.put(tk.class, new bgs((bbo)new bcm(), 0.5f, 6.0f));
        this.q.put(tj.class, new bgr());
        this.q.put(sc.class, new bhq((bbo)new bce(), 0.7f));
        this.q.put(ub.class, new bhu());
        this.q.put(sd.class, new bht());
        this.q.put(ro.class, new bga());
        this.q.put(sk.class, new bgj());
        this.q.put(sj.class, new bgi());
        this.q.put(sm.class, new bhw());
        this.q.put(nn.class, new bgh());
        this.q.put(ol.class, new bhh());
        this.q.put(od.class, new bgv());
        this.q.put(oe.class, new bgz());
        this.q.put(uh.class, new bfz());
        this.q.put(up.class, new bgx(yc.aF));
        this.q.put(us.class, new bgx(yc.bp));
        this.q.put(ui.class, new bgx(yc.bC));
        this.q.put(ur.class, new bgx(yc.aR));
        this.q.put(uu.class, new bgx(yc.bu, 16384));
        this.q.put(ut.class, new bgx(yc.bF));
        this.q.put(uk.class, new bgx(yc.bW));
        this.q.put(um.class, new bgp(2.0f));
        this.q.put(uo.class, new bgp(0.5f));
        this.q.put(uv.class, new bhx());
        this.q.put(ss.class, new bgw());
        this.q.put(oa.class, new bgn());
        this.q.put(tc.class, new bhs());
        this.q.put(sr.class, new bgo());
        this.q.put(tb.class, new bhr());
        this.q.put(sz.class, new bhd());
        this.q.put(st.class, new bhc());
        this.q.put(sq.class, new bgc());
        this.q.put(ul.class, new bgq());
        this.q.put(rs.class, new bgt((bbo)new bbp(), 0.75f));
        this.q.put(sp.class, new bha());
        for (bgm render : this.q.values()) {
            render.a(this);
        }
    }

    public bgm a(Class par1Class) {
        bgm render = (bgm)this.q.get(par1Class);
        if (render == null && par1Class != nn.class) {
            render = this.a(par1Class.getSuperclass());
            this.q.put(par1Class, render);
        }
        return render;
    }

    public bgm a(nn par1Entity) {
        return this.a(par1Entity.getClass());
    }

    public void a(abw par1World, bim par2TextureManager, avi par3FontRenderer, of par4EntityLivingBase, of par5EntityLivingBase, aul par6GameSettings, float par7) {
        this.g = par1World;
        this.e = par2TextureManager;
        this.l = par6GameSettings;
        this.h = par4EntityLivingBase;
        this.i = par5EntityLivingBase;
        this.r = par3FontRenderer;
        if (par4EntityLivingBase.bh()) {
            int z2;
            int y2;
            int x2 = ls.c(par4EntityLivingBase.u);
            aqz block = aqz.s[par1World.a(x2, y2 = ls.c(par4EntityLivingBase.v), z2 = ls.c(par4EntityLivingBase.w))];
            if (block != null && block.isBed(par1World, x2, y2, z2, par4EntityLivingBase)) {
                int k = block.getBedDirection(par1World, x2, y2, z2);
                this.j = k * 90 + 180;
                this.k = 0.0f;
            }
        } else {
            this.j = par4EntityLivingBase.C + (par4EntityLivingBase.A - par4EntityLivingBase.C) * par7;
            this.k = par4EntityLivingBase.D + (par4EntityLivingBase.B - par4EntityLivingBase.D) * par7;
        }
        if (par6GameSettings.aa == 2) {
            this.j += 180.0f;
        }
        this.m = par4EntityLivingBase.U + (par4EntityLivingBase.u - par4EntityLivingBase.U) * (double)par7;
        this.n = par4EntityLivingBase.V + (par4EntityLivingBase.v - par4EntityLivingBase.V) * (double)par7;
        this.o = par4EntityLivingBase.W + (par4EntityLivingBase.w - par4EntityLivingBase.W) * (double)par7;
    }

    public void a(nn par1Entity, float par2) {
        if (par1Entity.ac == 0) {
            par1Entity.U = par1Entity.u;
            par1Entity.V = par1Entity.v;
            par1Entity.W = par1Entity.w;
        }
        double d0 = par1Entity.U + (par1Entity.u - par1Entity.U) * (double)par2;
        double d1 = par1Entity.V + (par1Entity.v - par1Entity.V) * (double)par2;
        double d2 = par1Entity.W + (par1Entity.w - par1Entity.W) * (double)par2;
        float f1 = par1Entity.C + (par1Entity.A - par1Entity.C) * par2;
        int i2 = par1Entity.c(par2);
        if (par1Entity.af()) {
            i2 = 0xF000F0;
        }
        int j2 = i2 % 65536;
        int k = i2 / 65536;
        bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.a(par1Entity, d0 - b, d1 - c, d2 - d, f1, par2);
    }

    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        block9: {
            bgm render = null;
            try {
                render = this.a(par1Entity);
                if (render == null || this.e == null) break block9;
                if (p && !par1Entity.aj()) {
                    try {
                        this.b(par1Entity, par2, par4, par6, par8, par9);
                    }
                    catch (Throwable throwable) {
                        throw new u(b.a(throwable, "Rendering entity hitbox in world"));
                    }
                }
                try {
                    render.a(par1Entity, par2, par4, par6, par8, par9);
                }
                catch (Throwable throwable1) {
                    throw new u(b.a(throwable1, "Rendering entity in world"));
                }
                try {
                    render.b(par1Entity, par2, par4, par6, par8, par9);
                }
                catch (Throwable throwable2) {
                    throw new u(b.a(throwable2, "Post-rendering entity in world"));
                }
            }
            catch (Throwable throwable3) {
                b crashreport = b.a(throwable3, "Rendering entity in world");
                m crashreportcategory = crashreport.a("Entity being rendered");
                par1Entity.a(crashreportcategory);
                m crashreportcategory1 = crashreport.a("Renderer details");
                crashreportcategory1.a("Assigned renderer", render);
                crashreportcategory1.a("Location", m.a(par2, par4, par6));
                crashreportcategory1.a("Rotation", Float.valueOf(par8));
                crashreportcategory1.a("Delta", Float.valueOf(par9));
                throw new u(crashreport);
            }
        }
    }

    private void b(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glPushMatrix();
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(255, 255, 255, 32);
        double d3 = -par1Entity.O / 2.0f;
        double d4 = -par1Entity.O / 2.0f;
        double d5 = par1Entity.O / 2.0f;
        double d6 = -par1Entity.O / 2.0f;
        double d7 = -par1Entity.O / 2.0f;
        double d8 = par1Entity.O / 2.0f;
        double d9 = par1Entity.O / 2.0f;
        double d10 = par1Entity.O / 2.0f;
        double d11 = par1Entity.P;
        tessellator.a(par2 + d3, par4 + d11, par6 + d4);
        tessellator.a(par2 + d3, par4, par6 + d4);
        tessellator.a(par2 + d5, par4, par6 + d6);
        tessellator.a(par2 + d5, par4 + d11, par6 + d6);
        tessellator.a(par2 + d9, par4 + d11, par6 + d10);
        tessellator.a(par2 + d9, par4, par6 + d10);
        tessellator.a(par2 + d7, par4, par6 + d8);
        tessellator.a(par2 + d7, par4 + d11, par6 + d8);
        tessellator.a(par2 + d5, par4 + d11, par6 + d6);
        tessellator.a(par2 + d5, par4, par6 + d6);
        tessellator.a(par2 + d9, par4, par6 + d10);
        tessellator.a(par2 + d9, par4 + d11, par6 + d10);
        tessellator.a(par2 + d7, par4 + d11, par6 + d8);
        tessellator.a(par2 + d7, par4, par6 + d8);
        tessellator.a(par2 + d3, par4, par6 + d4);
        tessellator.a(par2 + d3, par4 + d11, par6 + d4);
        tessellator.a();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glDepthMask((boolean)true);
    }

    public void a(abw par1World) {
        this.g = par1World;
    }

    public double a(double par1, double par3, double par5) {
        double d3 = par1 - this.m;
        double d4 = par3 - this.n;
        double d5 = par5 - this.o;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public avi a() {
        return this.r;
    }

    public void a(mt par1IconRegister) {
        for (bgm render : this.q.values()) {
            render.a(par1IconRegister);
        }
    }
}

