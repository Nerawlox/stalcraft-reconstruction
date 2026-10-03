/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  avb
 *  avz
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class auz
extends awe {
    private static bgw a = new bgw();
    private final avb b;
    private agc c = agc.e();
    private String d;
    private String e;
    private String p;
    private ava q;
    private aut r;
    private aut s;
    private aut t;

    public auz(avb par1GuiCreateWorld, String par2Str) {
        this.b = par1GuiCreateWorld;
        this.a(par2Str);
    }

    public String z_() {
        return this.c.toString();
    }

    public void a(String par1Str) {
        this.c = agc.a(par1Str);
    }

    @Override
    public void A_() {
        this.i.clear();
        this.d = bkb.a((String)"createWorld.customize.flat.title");
        this.e = bkb.a((String)"createWorld.customize.flat.tile");
        this.p = bkb.a((String)"createWorld.customize.flat.height");
        this.q = new ava(this);
        this.r = new aut(2, this.g / 2 - 154, this.h - 52, 100, 20, bkb.a((String)"createWorld.customize.flat.addLayer") + " (NYI)");
        this.i.add(this.r);
        this.s = new aut(3, this.g / 2 - 50, this.h - 52, 100, 20, bkb.a((String)"createWorld.customize.flat.editLayer") + " (NYI)");
        this.i.add(this.s);
        this.t = new aut(4, this.g / 2 - 155, this.h - 52, 150, 20, bkb.a((String)"createWorld.customize.flat.removeLayer"));
        this.i.add(this.t);
        this.i.add(new aut(0, this.g / 2 - 155, this.h - 28, 150, 20, bkb.a((String)"gui.done")));
        this.i.add(new aut(5, this.g / 2 + 5, this.h - 52, 150, 20, bkb.a((String)"createWorld.customize.presets")));
        this.i.add(new aut(1, this.g / 2 + 5, this.h - 28, 150, 20, bkb.a((String)"gui.cancel")));
        this.s.i = false;
        this.r.i = false;
        this.c.d();
        this.g();
    }

    @Override
    protected void a(aut par1GuiButton) {
        int i = this.c.c().size() - this.q.a - 1;
        if (par1GuiButton.g == 1) {
            this.f.a((awe)this.b);
        } else if (par1GuiButton.g == 0) {
            this.b.a = this.z_();
            this.f.a((awe)this.b);
        } else if (par1GuiButton.g == 5) {
            this.f.a((awe)new avz(this));
        } else if (par1GuiButton.g == 4 && this.i()) {
            this.c.c().remove(i);
            this.q.a = Math.min(this.q.a, this.c.c().size() - 1);
        }
        this.c.d();
        this.g();
    }

    public void g() {
        boolean flag;
        this.t.h = flag = this.i();
        this.s.h = flag;
        this.s.h = false;
        this.r.h = false;
    }

    private boolean i() {
        return this.q.a > -1 && this.q.a < this.c.c().size();
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        this.q.a(par1, par2, par3);
        this.a(this.o, this.d, this.g / 2, 8, 0xFFFFFF);
        int k = this.g / 2 - 92 - 16;
        this.b(this.o, this.e, k, 32, 0xFFFFFF);
        this.b(this.o, this.p, k + 2 + 213 - this.o.a(this.p), 32, 0xFFFFFF);
        super.a(par1, par2, par3);
    }

    static bgw h() {
        return a;
    }

    static agc a(auz par0GuiCreateFlatWorld) {
        return par0GuiCreateFlatWorld.c;
    }
}

