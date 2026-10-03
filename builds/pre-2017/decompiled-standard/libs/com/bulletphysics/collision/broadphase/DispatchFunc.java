/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

public enum DispatchFunc {
    DISPATCH_DISCRETE(1),
    DISPATCH_CONTINUOUS(2);

    private int value;

    private DispatchFunc(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

