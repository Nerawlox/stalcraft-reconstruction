/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  aws
 *  awu
 *  awv
 *  bkb
 *  blv
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class awr
extends awe {
    private static bgw c = new bgw();
    protected awe a;
    protected String b = "Select world";
    private awu d;
    private awv e;
    private aws p;
    private blv q;
    private awg r;

    public awr(awe par1GuiScreen, blv par2StatFileWriter) {
        this.a = par1GuiScreen;
        this.q = par2StatFileWriter;
    }

    @Override
    public void A_() {
        this.b = bkb.a((String)"gui.stats");
        this.d = new awu(this);
        this.d.d(1, 1);
        this.e = new awv(this);
        this.e.d(1, 1);
        this.p = new aws(this);
        this.p.d(1, 1);
        this.r = this.d;
        this.g();
    }

    public void g() {
        this.i.add(new aut(0, this.g / 2 + 4, this.h - 28, 150, 20, bkb.a((String)"gui.done")));
        this.i.add(new aut(1, this.g / 2 - 154, this.h - 52, 100, 20, bkb.a((String)"stat.generalButton")));
        aut guibutton = new aut(2, this.g / 2 - 46, this.h - 52, 100, 20, bkb.a((String)"stat.blocksButton"));
        this.i.add(guibutton);
        aut guibutton1 = new aut(3, this.g / 2 + 62, this.h - 52, 100, 20, bkb.a((String)"stat.itemsButton"));
        this.i.add(guibutton1);
        if (this.p.a() == 0) {
            guibutton.h = false;
        }
        if (this.e.a() == 0) {
            guibutton1.h = false;
        }
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 0) {
                this.f.a(this.a);
            } else if (par1GuiButton.g == 1) {
                this.r = this.d;
            } else if (par1GuiButton.g == 3) {
                this.r = this.e;
            } else if (par1GuiButton.g == 2) {
                this.r = this.p;
            } else {
                this.r.a(par1GuiButton);
            }
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.r.a(par1, par2, par3);
        this.a(this.o, this.b, this.g / 2, 20, 0xFFFFFF);
        super.a(par1, par2, par3);
    }

    private void c(int par1, int par2, int par3) {
        this.b(par1 + 1, par2 + 1);
        GL11.glEnable((int)32826);
        att.c();
        c.a(this.o, this.f.J(), new ye(par3, 1, 0), par1 + 2, par2 + 2);
        att.a();
        GL11.glDisable((int)32826);
    }

    private void b(int par1, int par2) {
        this.c(par1, par2, 0, 0);
    }

    private void c(int par1, int par2, int par3, int par4) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(l);
        float f = 0.0078125f;
        float f1 = 0.0078125f;
        boolean flag = true;
        boolean flag1 = true;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(par1 + 0, par2 + 18, this.n, (float)(par3 + 0) * 0.0078125f, (float)(par4 + 18) * 0.0078125f);
        tessellator.a(par1 + 18, par2 + 18, this.n, (float)(par3 + 18) * 0.0078125f, (float)(par4 + 18) * 0.0078125f);
        tessellator.a(par1 + 18, par2 + 0, this.n, (float)(par3 + 18) * 0.0078125f, (float)(par4 + 0) * 0.0078125f);
        tessellator.a(par1 + 0, par2 + 0, this.n, (float)(par3 + 0) * 0.0078125f, (float)(par4 + 0) * 0.0078125f);
        tessellator.a();
    }

    static atv a(awr par0GuiStats) {
        return par0GuiStats.f;
    }

    static avi b(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static blv c(awr par0GuiStats) {
        return par0GuiStats.q;
    }

    static avi d(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static avi e(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static atv f(awr par0GuiStats) {
        return par0GuiStats.f;
    }

    static void a(awr par0GuiStats, int par1, int par2, int par3, int par4) {
        par0GuiStats.c(par1, par2, par3, par4);
    }

    static atv g(awr par0GuiStats) {
        return par0GuiStats.f;
    }

    static avi h(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static avi i(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static avi j(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static avi k(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static avi l(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static void a(awr par0GuiStats, int par1, int par2, int par3, int par4, int par5, int par6) {
        par0GuiStats.a(par1, par2, par3, par4, par5, par6);
    }

    static avi m(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static avi n(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static void b(awr par0GuiStats, int par1, int par2, int par3, int par4, int par5, int par6) {
        par0GuiStats.a(par1, par2, par3, par4, par5, par6);
    }

    static avi o(awr par0GuiStats) {
        return par0GuiStats.o;
    }

    static void a(awr par0GuiStats, int par1, int par2, int par3) {
        par0GuiStats.c(par1, par2, par3);
    }
}

