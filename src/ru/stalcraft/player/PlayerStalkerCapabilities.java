/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  uc
 */
package ru.stalcraft.player;

import ru.stalcraft.player.PlayerInfo;

public class PlayerStalkerCapabilities
extends uc {
    private uf player;
    private PlayerInfo info;

    public PlayerStalkerCapabilities(uf player, PlayerInfo info) {
        this.player = player;
        this.info = info;
    }

    public float b() {
        return super.b();
    }

    public PlayerInfo getInfo() {
        return this.info;
    }
}

