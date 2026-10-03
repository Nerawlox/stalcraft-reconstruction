/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.BulletStats;

class CProfileNode {
    protected String name;
    protected int totalCalls;
    protected float totalTime;
    protected long startTime;
    protected int recursionCounter;
    protected CProfileNode parent;
    protected CProfileNode child;
    protected CProfileNode sibling;

    public CProfileNode(String name2, CProfileNode parent) {
        this.name = name2;
        this.totalCalls = 0;
        this.totalTime = 0.0f;
        this.startTime = 0L;
        this.recursionCounter = 0;
        this.parent = parent;
        this.child = null;
        this.sibling = null;
        this.reset();
    }

    public CProfileNode getSubNode(String name2) {
        CProfileNode child = this.child;
        while (child != null) {
            if (child.name == name2) {
                return child;
            }
            child = child.sibling;
        }
        CProfileNode node = new CProfileNode(name2, this);
        node.sibling = this.child;
        this.child = node;
        return node;
    }

    public CProfileNode getParent() {
        return this.parent;
    }

    public CProfileNode getSibling() {
        return this.sibling;
    }

    public CProfileNode getChild() {
        return this.child;
    }

    public void cleanupMemory() {
        this.child = null;
        this.sibling = null;
    }

    public void reset() {
        this.totalCalls = 0;
        this.totalTime = 0.0f;
        BulletStats.gProfileClock.reset();
        if (this.child != null) {
            this.child.reset();
        }
        if (this.sibling != null) {
            this.sibling.reset();
        }
    }

    public void call() {
        ++this.totalCalls;
        if (this.recursionCounter++ == 0) {
            this.startTime = BulletStats.profileGetTicks();
        }
    }

    public boolean Return() {
        if (--this.recursionCounter == 0 && this.totalCalls != 0) {
            long time = BulletStats.profileGetTicks();
            this.totalTime += (float)(time -= this.startTime) / BulletStats.profileGetTickRate();
        }
        return this.recursionCounter == 0;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalls() {
        return this.totalCalls;
    }

    public float getTotalTime() {
        return this.totalTime;
    }
}

