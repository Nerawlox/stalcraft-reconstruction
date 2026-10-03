/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  avw
 *  awj
 *  bdd
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  la
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class avy
extends awe {
    protected int a;
    private int b;

    @Override
    public void A_() {
        this.a = 0;
        this.i.clear();
        int b0 = -16;
        boolean flag = true;
        this.i.add(new aut(1, this.g / 2 - 100, this.h / 4 + 120 + b0, bkb.a((String)"menu.returnToMenu")));
        if (!this.f.A()) {
            ((aut)this.i.get((int)0)).f = bkb.a((String)"menu.disconnect");
        }
        this.i.add(new aut(4, this.g / 2 - 100, this.h / 4 + 24 + b0, bkb.a((String)"menu.returnToGame")));
        this.i.add(new aut(0, this.g / 2 - 100, this.h / 4 + 96 + b0, 98, 20, bkb.a((String)"menu.options")));
        aut guibutton = new aut(7, this.g / 2 + 2, this.h / 4 + 96 + b0, 98, 20, bkb.a((String)"menu.shareToLan"));
        this.i.add(guibutton);
        this.i.add(new aut(5, this.g / 2 - 100, this.h / 4 + 48 + b0, 98, 20, bkb.a((String)"gui.achievements")));
        this.i.add(new aut(6, this.g / 2 + 2, this.h / 4 + 48 + b0, 98, 20, bkb.a((String)"gui.stats")));
        guibutton.h = this.f.B() && !this.f.C().c();
    }

    @Override
    protected void a(aut par1GuiButton) {
        switch (par1GuiButton.g) {
            case 0: {
                this.f.a((awe)new avw((awe)this, this.f.u));
                break;
            }
            case 1: {
                par1GuiButton.h = false;
                this.f.y.a(la.j, 1);
                this.f.f.F();
                this.f.a((bdd)null);
                this.f.a(new blt());
            }
            default: {
                break;
            }
            case 4: {
                this.f.a((awe)null);
                this.f.g();
                this.f.v.f();
                break;
            }
            case 5: {
                this.f.a(new awq(this.f.y));
                break;
            }
            case 6: {
                this.f.a(new awr(this, this.f.y));
                break;
            }
            case 7: {
                this.f.a((awe)new awj((awe)this));
            }
        }
    }

    @Override
    public void c() {
        super.c();
        ++this.b;
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        this.a(this.o, "Game menu", this.g / 2, 40, 0xFFFFFF);
        super.a(par1, par2, par3);
    }
}

