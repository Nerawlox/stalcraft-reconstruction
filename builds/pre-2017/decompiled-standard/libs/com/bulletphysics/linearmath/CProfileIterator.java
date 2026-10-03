/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.linearmath.CProfileNode;

public class CProfileIterator {
    private CProfileNode currentParent;
    private CProfileNode currentChild;

    CProfileIterator(CProfileNode start) {
        this.currentParent = start;
        this.currentChild = this.currentParent.getChild();
    }

    public void first() {
        this.currentChild = this.currentParent.getChild();
    }

    public void next() {
        this.currentChild = this.currentChild.getSibling();
    }

    public boolean isDone() {
        return this.currentChild == null;
    }

    public boolean isRoot() {
        return this.currentParent.getParent() == null;
    }

    public void enterChild(int index) {
        this.currentChild = this.currentParent.getChild();
        while (this.currentChild != null && index != 0) {
            --index;
            this.currentChild = this.currentChild.getSibling();
        }
        if (this.currentChild != null) {
            this.currentParent = this.currentChild;
            this.currentChild = this.currentParent.getChild();
        }
    }

    public void enterParent() {
        if (this.currentParent.getParent() != null) {
            this.currentParent = this.currentParent.getParent();
        }
        this.currentChild = this.currentParent.getChild();
    }

    public String getCurrentName() {
        return this.currentChild.getName();
    }

    public int getCurrentTotalCalls() {
        return this.currentChild.getTotalCalls();
    }

    public float getCurrentTotalTime() {
        return this.currentChild.getTotalTime();
    }

    public String getCurrentParentName() {
        return this.currentParent.getName();
    }

    public int getCurrentParentTotalCalls() {
        return this.currentParent.getTotalCalls();
    }

    public float getCurrentParentTotalTime() {
        return this.currentParent.getTotalTime();
    }
}

