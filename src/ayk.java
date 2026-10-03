/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  azd
 *  azn
 *  bap
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.input.Keyboard
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.UnsupportedEncodingException;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class ayk
extends awe {
    private awe a;
    private awe b;
    private avf c;
    private avf d;
    private bak e;
    private aut p;
    private int q;
    private int r;
    private int s;
    private azd t;

    public ayk(awe par1GuiScreen, awe par2GuiScreen, bak par3McoServer) {
        this.a = par1GuiScreen;
        this.b = par2GuiScreen;
        this.e = par3McoServer;
    }

    @Override
    public void c() {
        this.d.a();
        this.c.a();
    }

    @Override
    public void A_() {
        this.q = this.g / 4;
        this.r = this.g / 4 - 2;
        this.s = this.g / 2 + 4;
        Keyboard.enableRepeatEvents((boolean)true);
        this.i.clear();
        this.p = new aut(0, this.q, this.h / 4 + 120 + 22, this.r, 20, bkb.a((String)"mco.configure.world.buttons.done"));
        this.i.add(this.p);
        this.i.add(new aut(1, this.s, this.h / 4 + 120 + 22, this.r, 20, bkb.a((String)"gui.cancel")));
        this.d = new avf(this.o, this.q, 56, 212, 20);
        this.d.b(true);
        this.d.f(32);
        this.d.a(this.e.b());
        this.c = new avf(this.o, this.q, 96, 212, 20);
        this.c.f(32);
        this.c.a(this.e.a());
        this.t = new azd(this.g, this.h, this.q, 122, this.e.i, this.e.j);
        this.i.addAll(this.t.a);
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.h) {
            if (par1GuiButton.g == 1) {
                this.f.a(this.a);
            } else if (par1GuiButton.g == 0) {
                this.g();
            } else if (par1GuiButton.g == 2) {
                this.f.a((awe)new azn((awe)this, this.e));
            } else {
                this.t.a(par1GuiButton);
            }
        }
    }

    private void g() {
        azz mcoclient = new azz(this.f.H());
        try {
            String s2 = this.c.b() != null && !this.c.b().trim().equals("") ? this.c.b() : null;
            mcoclient.a(this.e.a, this.d.b(), s2, this.t.e, this.t.f);
            this.e.a(this.d.b());
            this.e.b(this.c.b());
            this.e.i = this.t.e;
            this.e.j = this.t.f;
            this.f.a(new ayf(this.b, this.e));
        }
        catch (bap exceptionmcoservice) {
            this.f.an().c(exceptionmcoservice.toString());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception) {
            this.f.an().b("Realms: " + unsupportedencodingexception.getLocalizedMessage());
        }
    }

    @Override
    protected void a(char par1, int par2) {
        this.d.a(par1, par2);
        this.c.a(par1, par2);
        if (par2 == 15) {
            this.d.b(!this.d.l());
            this.c.b(!this.c.l());
        }
        if (par2 == 28 || par2 == 156) {
            this.g();
        }
        this.p.h = this.d.b() != null && !this.d.b().trim().equals("");
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        this.c.a(par1, par2, par3);
        this.d.a(par1, par2, par3);
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        this.a(this.o, bkb.a((String)"mco.configure.world.edit.title"), this.g / 2, 17, 0xFFFFFF);
        this.b(this.o, bkb.a((String)"mco.configure.world.name"), this.q, 43, 0xA0A0A0);
        this.b(this.o, bkb.a((String)"mco.configure.world.description"), this.q, 84, 0xA0A0A0);
        this.d.f();
        this.c.f();
        this.t.a((awe)this, this.o);
        super.a(par1, par2, par3);
    }
}

