/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.clans;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.network.ClientPacketSender;

public class GuiClanInvite
extends awe {
    private static final bjo texture = new bjo("stalker", "textures/clans/invite.png");
    private String inviter;
    private String clan;

    public GuiClanInvite(String clan, String inviter) {
        this.inviter = inviter;
        this.clan = clan;
    }

    @Override
    public void A_() {
        this.i.add(new aut(0, this.g / 2 - 68, this.h / 2 + 17, 66, 20, "\u0412\u0441\u0442\u0443\u043f\u0438\u0442\u044c"));
        this.i.add(new aut(1, this.g / 2 + 2, this.h / 2 + 17, 66, 20, "\u041e\u0442\u043a\u0430\u0437\u0430\u0442\u044c\u0441\u044f"));
    }

    @Override
    public void a(int x2, int y2, float frame) {
        this.b(0);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        atv.w().N.a(texture);
        this.b(this.g / 2 - 78, this.h / 2 - 45, 0, 0, 156, 90);
        this.a(this.o, "\u0418\u0433\u0440\u043e\u043a " + this.inviter + " \u043f\u0440\u0438\u0433\u043b\u0430\u0448\u0430\u0435\u0442", this.g / 2, this.h / 2 - 18, 0xFFFFFF);
        this.a(this.o, "\u0432\u0430\u0441 \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443 \"" + this.clan + "\".", this.g / 2, this.h / 2 - 8, 0xFFFFFF);
        super.a(x2, y2, frame);
    }

    @Override
    protected void a(aut btn) {
        if (btn.g == 0) {
            ClientPacketSender.sendClanJoinRequest(this.clan);
        } else {
            atv.w().a((awe)null);
        }
    }

    @Override
    public boolean f() {
        return false;
    }
}

