/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

public interface IEntityShooter {
    public void shoot();

    public int getShootCooldown();

    public boolean canShoot();
}

