/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  awf
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.gui;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.network.ClientPacketSender;

public class GuiHandcuffs
extends awe {
    private static final bjo texture = new bjo("stalker", "textures/handcuffs_gui.png");
    private uf handcuffer;

    public GuiHandcuffs(uf handcuffer) {
        this.handcuffer = handcuffer;
    }

    @Override
    public void A_() {
        this.i.clear();
        this.i.add(new aut(2, this.g / 2 - 76, this.h / 2 + 40, 74, 20, "\u0414\u0430"));
        this.i.add(new aut(3, this.g / 2 + 2, this.h / 2 + 40, 74, 20, "\u041d\u0435\u0442"));
    }

    @Override
    public void a(int par1, int par2, float par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        this.f.N.a(texture);
        this.b(this.g / 2 - 95, this.h / 2 - 25, 0, 0, 190, 110);
        awf sr2 = new awf(this.f.u, this.f.d, this.f.e);
        this.a(this.o, "\u0418\u0433\u0440\u043e\u043a " + this.handcuffer.bu + " \u0445\u043e\u0447\u0435\u0442", sr2.a() / 2, sr2.b() / 2 - 10, 0xFFFFFF);
        this.a(this.o, "\u043d\u0430\u0434\u0435\u0442\u044c \u043d\u0430 \u0432\u0430\u0441 \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438.", sr2.a() / 2, sr2.b() / 2 + 10, 0xFFFFFF);
        this.a(this.o, "\u041f\u043e\u0437\u0432\u043e\u043b\u0438\u0442\u044c \u0435\u043c\u0443 \u044d\u0442\u043e?", sr2.a() / 2, sr2.b() / 2 + 30, 0xFFFFFF);
        super.a(par1, par2, par3);
    }

    @Override
    public boolean f() {
        return false;
    }

    @Override
    protected void a(aut btn) {
        if (btn.g == 2) {
            ClientPacketSender.sendHandcuffsAnswer(this.handcuffer, true);
        } else {
            ClientPacketSender.sendHandcuffsAnswer(this.handcuffer, false);
        }
        atv.w().a((awe)null);
    }
}

