/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import net.minecraft.client.Minecraft;

public abstract class Ha3Scroller {
    private Minecraft minecraft;
    private boolean isRunning;
    private float pitchBase;
    private float pitchGlobal;

    protected abstract void doDraw(float var1);

    protected abstract void doRoutineBefore();

    protected abstract void doRoutineAfter();

    protected abstract void doStart();

    protected abstract void doStop();

    public Ha3Scroller(Minecraft minecraft) {
        this.minecraft = minecraft;
        this.pitchBase = 0.0f;
        this.pitchGlobal = 0.0f;
    }

    protected Minecraft getMinecraft() {
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
        this.pitchGlobal = this.minecraft._t.rotationPitch;
        this.doRoutineAfter();
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.pitchBase = this.minecraft._t.rotationPitch;
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

