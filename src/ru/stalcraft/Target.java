/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

public class Target {
    public uf entity;
    public double startX;
    public double startY;
    public double startZ;
    public int worldID;
    public int timer = 0;

    public Target(uf entity, double x2, double y2, double z2, int w2) {
        this.entity = entity;
        this.startX = x2;
        this.startY = y2;
        this.startZ = z2;
        this.worldID = w2;
    }
}

