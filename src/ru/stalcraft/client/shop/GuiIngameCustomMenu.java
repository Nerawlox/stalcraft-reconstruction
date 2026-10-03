/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  avw
 *  awj
 *  bdd
 *  bkb
 *  la
 */
package ru.stalcraft.client.shop;

import ru.stalcraft.client.shop.gui.GuiTabWeapon;

public class GuiIngameCustomMenu
extends awe {
    private int updateCounter2;
    private int updateCounter;

    @Override
    public void A_() {
        this.updateCounter2 = 0;
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
        this.i.add(new aut(79, this.g / 2 - 100, this.h / 4 + 72 + b0, "\u0414\u043e\u043d\u0430\u0442"));
        guibutton.h = this.f.B() && !this.f.C().c();
    }

    @Override
    public boolean f() {
        return false;
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
            case 79: {
                this.f.a(new GuiTabWeapon());
            }
        }
    }

    @Override
    public void c() {
        super.c();
        ++this.updateCounter;
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.e();
        this.a(this.o, "Game menu Area", this.g / 2, 40, 0xFFFFFF);
        super.a(par1, par2, par3);
    }
}

