/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

class Span {
    public int x1;
    public int x2;
    public float z1;
    public float z2;
    public short c1r;
    public short c1g;
    public short c1b;
    public short c2r;
    public short c2g;
    public short c2b;
    public Span prev;
    public Span next;

    Span() {
    }

    public void set(Span s) {
        this.x1 = s.x1;
        this.x2 = s.x2;
        this.z1 = s.z1;
        this.z2 = s.z2;
        this.c1r = s.c1r;
        this.c1g = s.c1g;
        this.c1b = s.c1b;
        this.c2r = s.c2r;
        this.c2g = s.c2g;
        this.c2b = s.c2b;
    }
}

