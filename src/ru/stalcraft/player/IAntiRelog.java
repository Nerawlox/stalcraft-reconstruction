/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.player;

public interface IAntiRelog {
    public boolean isPlayerRelogging(jv var1);

    public void addReloggingPlayer(jv var1);

    public void onDamage(jv var1);

    public void onSaveAll();

    public void tick();
}

