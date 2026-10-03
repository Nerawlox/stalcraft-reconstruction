/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.user;

import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.convenience.Ha3Scroller;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;

public class MAtScroller
extends Ha3Scroller {
    private final String MESSAGE_TITLE = "MAtmos Volume";
    private final String MESSAGE_HINT = "<Look up/down>";
    private final String MESSAGE_MORE = "+";
    private final String MESSAGE_LESS = "-";
    private MAtMod mod;
    private float prevPitch;
    private boolean knowsHowToUse;
    private float doneValue;

    public MAtScroller(MAtMod mAtMod) {
        super(Minecraft._E());
        this.mod = mAtMod;
        this.knowsHowToUse = false;
    }

    @Override
    protected void doDraw(float f) {
        Minecraft minecraft = Minecraft._E();
        FontRenderer fontRenderer = minecraft._z;
        String string = (int)Math.floor(this.doneValue * 100.0f) + "%";
        htou htou2 = new htou(minecraft._M, minecraft._n, minecraft._o);
        int n = htou2._a();
        int n2 = htou2._b();
        int n3 = this.getWidthOf("_");
        int n4 = (n - n3) / 2 + this.getWidthOf(this.MESSAGE_TITLE) / 2;
        fontRenderer._a(this.MESSAGE_TITLE, n4 + n3 * 2, n2 / 2, 0xFFFFFF);
        fontRenderer._a(string, n4 + n3 * 2, n2 / 2 + 10, 0xFF0000 | (int)(200.0f + 55.0f * (this.doneValue < 1.0f ? 1.0f : 2.0f - this.doneValue)) << 8);
        if (!this.knowsHowToUse) {
            float f2 = (float)this.mod.util().getClientTick() + f;
            int n5 = (int)(200.0 + 55.0 * (Math.sin((double)f2 * Math.PI * 0.07) + 1.0) / 2.0);
            fontRenderer._a(this.MESSAGE_HINT, n4 + n3 * 2, n2 / 2 + 20, n5 << 16 | n5 << 8 | n5);
            if (Math.abs(this.getInitialPitch() - this.getPitch()) > 60.0f) {
                this.knowsHowToUse = true;
            }
        }
        fontRenderer._a(this.MESSAGE_MORE, n4 + n3 * 2, n2 / 2 - n2 / 6 + 3, 0xFFFF00);
        fontRenderer._a(this.MESSAGE_LESS, n4 + n3 * 2, n2 / 2 + n2 / 6 + 3, 0xFFFF00);
        int n6 = 8;
        float f3 = 20.0f;
        for (int i = 0; i < 8; ++i) {
            float f4 = ((this.getPitch() + 90.0f) % 20.0f / 20.0f + (float)i) / 8.0f;
            double d = Math.cos(Math.PI * (double)f4);
            fontRenderer._a("_", n4, n2 / 2 + (int)Math.floor(d * (double)n2 / 6.0), 0xFFFF00);
        }
    }

    private int getWidthOf(String string) {
        return Minecraft._E()._z._b(string);
    }

    public float getValue() {
        return this.doneValue;
    }

    @Override
    protected void doRoutineBefore() {
        int n = 10;
        if (this.mod.getConfig().getBoolean("sound.autopreview") && Math.floor((this.prevPitch + 90.0f) / 10.0f) != Math.floor((this.getPitch() + 90.0f) / 10.0f)) {
            float f = (-this.getPitch() + 90.0f) / 90.0f;
            float f2 = (float)Math.pow(2.0, -Math.floor(this.getPitch() / 10.0f) / 12.0);
            EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
            float f3 = (float)entityClientPlayerMP.posX;
            float f4 = (float)entityClientPlayerMP.posY;
            float f5 = (float)entityClientPlayerMP.posZ;
            this.mod.getSoundCommunicator().playSoundViaManager("random.click", f3, f4, f5, f, f2);
        }
        this.doneValue = -this.getPitch() / 90.0f + 1.0f;
        if (Math.abs(this.getPitch()) < 3.0f) {
            this.doneValue = 1.0f;
        }
        if (Math.abs(this.doneValue - 0.2f) < 0.05f) {
            this.doneValue = 0.2f;
        }
        this.prevPitch = this.getPitch();
    }

    @Override
    protected void doRoutineAfter() {
    }

    @Override
    protected void doStart() {
        this.prevPitch = this.getPitch();
    }

    @Override
    protected void doStop() {
    }
}

