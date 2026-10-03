/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  aux
 *  aya
 *  ayg
 *  ayn
 *  ayo
 *  azn
 *  azq
 *  bap
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.input.Keyboard
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class ayf
extends awe {
    private final awe a;
    private bak b;
    private ayg c;
    private int d;
    private int e;
    private int p;
    private int q = -1;
    private String r;
    private aut s;
    private aut t;
    private aut u;
    private aut v;
    private aut w;
    private aut x;
    private aut y;
    private aut z;
    private boolean A;

    public ayf(awe par1GuiScreen, bak par2McoServer) {
        this.a = par1GuiScreen;
        this.b = par2McoServer;
    }

    @Override
    public void c() {
    }

    @Override
    public void A_() {
        this.d = this.g / 2 - 200;
        this.e = 180;
        this.p = this.g / 2;
        Keyboard.enableRepeatEvents((boolean)true);
        this.i.clear();
        if (this.b.d.equals("CLOSED")) {
            this.s = new aut(0, this.d, this.a(12), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.open"));
            this.i.add(this.s);
            this.s.h = !this.b.h;
        } else {
            this.t = new aut(1, this.d, this.a(12), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.close"));
            this.i.add(this.t);
            this.t.h = !this.b.h;
        }
        this.y = new aut(7, this.d + this.e / 2 + 2, this.a(12), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.subscription"));
        this.i.add(this.y);
        this.u = new aut(5, this.d, this.a(10), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.edit"));
        this.i.add(this.u);
        this.v = new aut(6, this.d + this.e / 2 + 2, this.a(10), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.reset"));
        this.i.add(this.v);
        this.w = new aut(4, this.p, this.a(10), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.invite"));
        this.i.add(this.w);
        this.x = new aut(3, this.p + this.e / 2 + 2, this.a(10), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.uninvite"));
        this.i.add(this.x);
        this.z = new aut(8, this.p, this.a(12), this.e / 2 - 2, 20, bkb.a((String)"mco.configure.world.buttons.backup"));
        this.i.add(this.z);
        this.i.add(new aut(10, this.p + this.e / 2 + 2, this.a(12), this.e / 2 - 2, 20, bkb.a((String)"gui.back")));
        this.c = new ayg(this);
        this.u.h = !this.b.h;
        this.v.h = !this.b.h;
        this.w.h = !this.b.h;
        this.x.h = !this.b.h;
        this.z.h = !this.b.h;
    }

    private int a(int par1) {
        return 40 + par1 * 13;
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 10) {
                if (this.A) {
                    ((ayz)this.a).a(this.b.a);
                }
                this.f.a(this.a);
            } else if (par1GuiButton.g == 5) {
                this.f.a(new ayk(this, this.a, this.b));
            } else if (par1GuiButton.g == 1) {
                String s2 = bkb.a((String)"mco.configure.world.close.question.line1");
                String s1 = bkb.a((String)"mco.configure.world.close.question.line2");
                this.f.a((awe)new ayo((awe)this, ayp.b, s2, s1, 1));
            } else if (par1GuiButton.g == 0) {
                this.g();
            } else if (par1GuiButton.g == 4) {
                this.f.a((awe)new ayn(this.a, this, this.b));
            } else if (par1GuiButton.g == 3) {
                this.i();
            } else if (par1GuiButton.g == 6) {
                this.f.a((awe)new azn((awe)this, this.b));
            } else if (par1GuiButton.g == 7) {
                this.f.a((awe)new azq((awe)this, this.b));
            } else if (par1GuiButton.g == 8) {
                this.f.a((awe)new aya(this, this.b.a));
            }
        }
    }

    private void g() {
        azz mcoclient = new azz(this.f.H());
        try {
            Boolean obool = mcoclient.e(this.b.a);
            if (obool.booleanValue()) {
                this.A = true;
                this.b.d = "OPEN";
                this.A_();
            }
        }
        catch (bap exceptionmcoservice) {
            this.f.an().c(exceptionmcoservice.toString());
        }
        catch (IOException ioexception) {
            this.f.an().b("Realms: could not parse response");
        }
    }

    private void h() {
        azz mcoclient = new azz(this.f.H());
        try {
            boolean flag = mcoclient.f(this.b.a);
            if (flag) {
                this.A = true;
                this.b.d = "CLOSED";
                this.A_();
            }
        }
        catch (bap exceptionmcoservice) {
            this.f.an().c(exceptionmcoservice.toString());
        }
        catch (IOException ioexception) {
            this.f.an().b("Realms: could not parse response");
        }
    }

    private void i() {
        if (this.q >= 0 && this.q < this.b.f.size()) {
            this.r = (String)this.b.f.get(this.q);
            aux guiyesno = new aux((awe)this, "Warning!", bkb.a((String)"mco.configure.world.uninvite.question") + " '" + this.r + "'", 3);
            this.f.a((awe)guiyesno);
        }
    }

    @Override
    public void a(boolean par1, int par2) {
        if (par2 == 3) {
            if (par1) {
                azz mcoclient = new azz(this.f.H());
                try {
                    mcoclient.a(this.b.a, this.r);
                }
                catch (bap exceptionmcoservice) {
                    this.f.an().c(exceptionmcoservice.toString());
                }
                this.d(this.q);
            }
            this.f.a(new ayf(this.a, this.b));
        }
        if (par2 == 1) {
            if (par1) {
                this.h();
            }
            this.f.a(this);
        }
    }

    private void d(int par1) {
        this.b.f.remove(par1);
    }

    @Override
    protected void a(char par1, int par2) {
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        this.c.a(par1, par2, par3);
        this.a(this.o, bkb.a((String)"mco.configure.world.title"), this.g / 2, 17, 0xFFFFFF);
        this.b(this.o, bkb.a((String)"mco.configure.world.name"), this.d, this.a(1), 0xA0A0A0);
        this.b(this.o, this.b.b(), this.d, this.a(2), 0xFFFFFF);
        this.b(this.o, bkb.a((String)"mco.configure.world.description"), this.d, this.a(4), 0xA0A0A0);
        this.b(this.o, this.b.a(), this.d, this.a(5), 0xFFFFFF);
        this.b(this.o, bkb.a((String)"mco.configure.world.status"), this.d, this.a(7), 0xA0A0A0);
        this.b(this.o, this.j(), this.d, this.a(8), 0xFFFFFF);
        this.b(this.o, bkb.a((String)"mco.configure.world.invited"), this.p, this.a(1), 0xA0A0A0);
        super.a(par1, par2, par3);
    }

    private String j() {
        if (this.b.h) {
            return "Expired";
        }
        String s2 = this.b.d.toLowerCase();
        return Character.toUpperCase(s2.charAt(0)) + s2.substring(1);
    }

    static atv a(ayf par0GuiScreenConfigureWorld) {
        return par0GuiScreenConfigureWorld.f;
    }

    static int b(ayf par0GuiScreenConfigureWorld) {
        return par0GuiScreenConfigureWorld.p;
    }

    static int a(ayf par0GuiScreenConfigureWorld, int par1) {
        return par0GuiScreenConfigureWorld.a(par1);
    }

    static int c(ayf par0GuiScreenConfigureWorld) {
        return par0GuiScreenConfigureWorld.e;
    }

    static bak d(ayf par0GuiScreenConfigureWorld) {
        return par0GuiScreenConfigureWorld.b;
    }

    static int b(ayf par0GuiScreenConfigureWorld, int par1) {
        par0GuiScreenConfigureWorld.q = par1;
        return par0GuiScreenConfigureWorld.q;
    }

    static int e(ayf par0GuiScreenConfigureWorld) {
        return par0GuiScreenConfigureWorld.q;
    }

    static avi f(ayf par0GuiScreenConfigureWorld) {
        return par0GuiScreenConfigureWorld.o;
    }
}

