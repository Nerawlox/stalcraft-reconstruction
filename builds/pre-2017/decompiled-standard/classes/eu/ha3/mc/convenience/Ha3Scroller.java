/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import net.minecraft.client.xpzm;

public abstract class Ha3Scroller {
    private xpzm minecraft;
    private boolean isRunning;
    private float pitchBase;
    private float pitchGlobal;

    protected abstract void doDraw(float var1);

    protected abstract void doRoutineBefore();

    protected abstract void doRoutineAfter();

    protected abstract void doStart();

    protected abstract void doStop();

    public Ha3Scroller(xpzm xpzm2) {
        this.minecraft = xpzm2;
        this.pitchBase = 0.0f;
        this.pitchGlobal = 0.0f;
    }

    protected xpzm getMinecraft() {
        return this.minecraft;
    }

    public float getInitialPitch() {
        return this.pitchBase;
    }

    public float getPitch() {
        return this.pitchGlobal;
    }

    public void draw(float f) {
        if (!this.isRunning) {
            return;
        }
        this.doDraw(f);
    }

    public void routine() {
        if (!this.isRunning) {
            return;
        }
        this.doRoutineBefore();
        this.pitchGlobal = this.minecraft._t.field_70125_A;
        this.doRoutineAfter();
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.pitchBase = this.minecraft._t.field_70125_A;
        this.doStart();
    }

    public void stop() {
        if (!this.isRunning) {
            return;
        }
        this.isRunning = false;
        this.doStop();
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}

