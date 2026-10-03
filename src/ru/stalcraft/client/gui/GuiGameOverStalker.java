/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  avc
 */
package ru.stalcraft.client.gui;

public class GuiGameOverStalker
extends avc {
    public int deathTimer;
    private int a = 0;

    public void a(int par1, int par2, float par3) {
        super.a(par1, par2, par3);
        if (this.deathTimer > 0) {
            String str = "\u041e\u0441\u0442\u0430\u043b\u043e\u0441\u044c: " + (this.deathTimer / 20 + 1 >= 60 ? this.deathTimer / 1200 + " \u043c\u0438\u043d." : this.deathTimer / 20 + 1 + " \u0441\u0435\u043a.");
            this.a(this.f.l, str, this.g / 2, 110, 0xFFFFFF);
        }
    }

    public void c() {
        super.c();
        --this.deathTimer;
        ++this.a;
        for (aut button : this.i) {
            if (button.g == 1) {
                boolean bl2 = button.h = this.a >= 20 && this.deathTimer <= 0;
            }
            if (button.g != 2 || button.h) continue;
            button.h = true;
        }
    }
}

