/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

public class Clock {
    private long startTime;

    public Clock() {
        this.reset();
    }

    public void reset() {
        this.startTime = System.nanoTime();
    }

    public long getTimeMilliseconds() {
        return (System.nanoTime() - this.startTime) / 1000000L;
    }

    public long getTimeMicroseconds() {
        return (System.nanoTime() - this.startTime) / 1000L;
    }
}

