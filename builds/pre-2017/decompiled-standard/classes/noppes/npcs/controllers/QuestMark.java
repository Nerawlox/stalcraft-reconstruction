/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.util.ofbx;

public class QuestMark {
    private ofbx pos;
    private float radius;

    public QuestMark(ofbx ofbx2, float f) {
        this.pos = ofbx2;
        this.radius = f;
    }

    public ofbx getPos() {
        return this.pos;
    }

    public void setPos(ofbx ofbx2) {
        this.pos = ofbx2;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float f) {
        this.radius = f;
    }
}

