/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

public interface IEntityFighter {
    public of getTarget();

    public void setTarget(of var1);

    public boolean canSee(nn var1);

    public void setLookPositionWithEntity(nn var1, float var2, float var3);

    public float getRotationYaw();
}

