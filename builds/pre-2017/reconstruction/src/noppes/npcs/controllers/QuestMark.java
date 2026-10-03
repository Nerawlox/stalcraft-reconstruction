/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.util.Vec3;

public class QuestMark {
    private Vec3 pos;
    private float radius;

    public QuestMark(Vec3 vec3, float f) {
        this.pos = vec3;
        this.radius = f;
    }

    public Vec3 getPos() {
        return this.pos;
    }

    public void setPos(Vec3 vec3) {
        this.pos = vec3;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float f) {
        this.radius = f;
    }
}

